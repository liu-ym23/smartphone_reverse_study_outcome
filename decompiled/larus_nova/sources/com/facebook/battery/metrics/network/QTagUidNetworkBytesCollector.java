package com.facebook.battery.metrics.network;

import android.os.Process;
import com.facebook.battery.metrics.core.SystemMetricsLogger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
class QTagUidNetworkBytesCollector extends NetworkBytesCollector {
    private static final long[] LOCAL_IFACE_HASHES = null;
    private static final String STATS_PATH = "/proc/net/xt_qtaguid/stats";
    private static final String TAG = "QTagUidNetworkBytesCollector";
    private static final long UID = 0;
    private static final long WLAN0_HASH = 0;
    private int mChar;
    private boolean mHasPeeked;
    private boolean mIsValid;
    private RandomAccessFile mQTagUidStatsFile;
    private boolean mReachedEof;

    private void closeFile() {
        this.mIsValid = false;
        RandomAccessFile r100 = this.mQTagUidStatsFile;
        if (r100 == null) goto L9;
        r100.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    private int readHash() throws IOException {
        boolean r100 = false;
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r100 == true) goto L10;
        if (read() == false) goto L10;
        int r103 = this.mChar;
        if (r103 != 32) goto L8;
        r100 = true;
        goto L3
    L8:
        r102 = (r102 * 31) + r103;
        r101 = true;
    L10:
        softAssert(r101);
        return r102;
    }

    private long readNumber() throws IOException {
        boolean r100 = false;
        long r101 = 0;
        boolean r102 = false;
    L3:
        if (r100 == true) goto L10;
        if (read() == false) goto L10;
        if (Character.isDigit(this.mChar) == true) goto L8;
        r100 = true;
        goto L3
    L8:
        r101 = (r101 * 10) + ((long) (this.mChar - 48));
        r102 = true;
    L10:
        softAssert(r102);
        return r101;
    }

    @Override // com.facebook.battery.metrics.network.NetworkBytesCollector
    public boolean supportsBgDistinction() {
        return true;
    }

    private boolean read() throws IOException {
        boolean r100 = false;
        if (this.mHasPeeked == false) goto L6;
        this.mHasPeeked = false;
        return !this.mReachedEof;
    L6:
        int r101 = this.mQTagUidStatsFile.read();
        this.mChar = r101;
        if (r101 != (-1)) goto L9;
        r100 = true;
    L9:
        this.mReachedEof = r100;
        return !r100;
    }

    public RandomAccessFile openFile() throws FileNotFoundException {
        return new RandomAccessFile(STATS_PATH, "r");
    }

    static {
        UID = Process.myUid();
        WLAN0_HASH = 113213102;
        LOCAL_IFACE_HASHES = new long[]{-1320644472, 3459};
    }

    public QTagUidNetworkBytesCollector() {
        this.mIsValid = true;
        this.mReachedEof = false;
        this.mHasPeeked = false;
    }

    private boolean peek() throws IOException {
        read();
        this.mHasPeeked = true;
        return true ^ this.mReachedEof;
    }

    public void finalize() throws Throwable {
        closeFile();
    }

    private static boolean isLocalInterface(int r100) {
        int r101 = 0;
    L3:
        long[] r102 = LOCAL_IFACE_HASHES;
        if (r101 >= r102.length) goto L10;
        if (r100 == r102[r101]) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    private void skipPast(char r100) throws IOException {
        boolean r101 = false;
    L3:
        if (r101 == true) goto L9;
        if (read() == false) goto L9;
        if (this.mChar != r100) goto L3;
        r101 = true;
    L9:
        softAssert(r101);
    }

    private boolean softAssert(boolean r100) {
        boolean r101 = r100 & this.mIsValid;
        this.mIsValid = r101;
        return r101;
    }

    @Override // com.facebook.battery.metrics.network.NetworkBytesCollector
    public boolean getTotalBytes(long[] r110) {
        if (this.mIsValid == true) goto L5;
        return false;
    L5:
        Arrays.fill(r110, 0);
    L41:
        e = move-exception;
        SystemMetricsLogger.wtf(TAG, "Unable to parse file", e);
        closeFile();
    L44:
        return this.mIsValid;
    L7:
        if (this.mQTagUidStatsFile != null) goto L9;
        this.mQTagUidStatsFile = openFile();     // Catch: IOException -> L41
    L9:
        this.mReachedEof = false;     // Catch: IOException -> L41
        this.mQTagUidStatsFile.seek(0);     // Catch: IOException -> L41
        skipPast('\n');     // Catch: IOException -> L41
    L10:
        if (this.mReachedEof == true) goto L44;
        if (this.mIsValid == false) goto L44;
        if (peek() == false) goto L44;
        skipPast(' ');     // Catch: IOException -> L41
        int r100 = readHash();     // Catch: IOException -> L41
        skipPast(' ');     // Catch: IOException -> L41
        long r101 = readNumber();     // Catch: IOException -> L41
        boolean r111 = true;
        if (r100 != WLAN0_HASH) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == false) goto L22;
    L24:
        r111 = false;
    L26:
        if (r101 != UID) goto L39;
        if (r102 == true) goto L30;
        if (r111 == false) goto L39;
    L30:
        long r103 = readNumber();     // Catch: IOException -> L41
        if (r102 == false) goto L33;
        char r104 = 0;
    L34:
        int r105 = r104 | 0;     // Catch: IOException -> L41
        if (r103 != 0) goto L37;
        int r106 = 4;
    L38:
        int r107 = r106 | r105;     // Catch: IOException -> L41
        int r108 = r107 | 0;     // Catch: IOException -> L41
        r110[r108] = r110[r108] + readNumber();     // Catch: IOException -> L41
        skipPast(' ');     // Catch: IOException -> L41
        int r109 = r107 | 1;     // Catch: IOException -> L41
        r110[r109] = r110[r109] + readNumber();     // Catch: IOException -> L41
        skipPast('\n');     // Catch: IOException -> L41
        goto L10
    L37:
        r106 = 0;
        goto L38
    L33:
        r104 = 2;
    L39:
        skipPast('\n');     // Catch: IOException -> L41
        goto L10
    L22:
        if (isLocalInterface(r100) == true) goto L24;
    L19:
        r102 = false;
        goto L20
    }
}
