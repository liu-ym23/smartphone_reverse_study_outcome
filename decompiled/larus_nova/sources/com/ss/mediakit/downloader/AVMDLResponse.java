package com.ss.mediakit.downloader;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Response;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public Call call;
    public long contentlength;
    public boolean isReadErr;
    public long readOff;
    public AVMDLRequest request;
    public Response response;
    public int statusCode;

    public static /* synthetic */ String a(AVMDLResponse r100) {
        return r100.lambda$readData$0();
    }

    public static /* synthetic */ String b(AVMDLResponse r100, int r101) {
        return r100.lambda$readData$1(r101);
    }

    public static /* synthetic */ String c(AVMDLResponse r100, long r101) {
        return r100.lambda$isFinish$2(r101);
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    private /* synthetic */ String lambda$readData$0() {
        return String.format(Locale.US, "before read off:%d reqoff:%d req size:%d", new Object[]{Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size)});
    }

    private void parseResponse() {
        Response r100 = this.response;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.code();
        this.statusCode = r101;
        if (r101 != 200) goto L10;
        this.contentlength = toInt(this.response.header("Content-Length"));
        return;
    L10:
        if (r101 != 206) goto L19;
        String r102 = this.response.header("Content-Range");
        if (TextUtils.isEmpty(r102) == true) goto L20;
        int r103 = r102.lastIndexOf(HTTP.URL_DEFAULT);
        if (r103 >= 0) goto L16;
        return;
    L16:
        if (r103 >= (r102.length() - 1)) goto L22;
        this.contentlength = toInt(r102.substring(r103 + 1), -1);
        return;
    L22:
        return;
    L20:
        return;
    }

    public void cancel() {
        Call r100 = this.call;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public boolean isFinish() {
        AVMDLRequest r100 = this.request;
        long r101 = r100.size;
        if (r101 < 0) goto L5;
        final long r102 = r100.reqOff + r101;
    L6:
        long r103 = this.contentlength;
        if (r102 <= r103) goto L9;
        r102 = r103;
    L9:
        AVMDLLog.d(TAG, new g(this, r102));
        if (this.readOff < r102) goto L12;
        return true;
    L12:
        return false;
    L5:
        r102 = this.contentlength;
        goto L6
    }

    public boolean isOpenSuccessful() {
        int r100 = this.statusCode;
        if (r100 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 300) goto L7;
        return true;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    private /* synthetic */ String lambda$isFinish$2(long r100) {
        return String.format(Locale.US, "check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", new Object[]{Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(r100)});
    }

    private /* synthetic */ String lambda$readData$1(int r100) {
        return String.format(Locale.US, "after read,ret:%d off:%d reqoff:%d req size:%d", new Object[]{Integer.valueOf(r100), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size)});
    }

    public static int toInt(String r100) {
        return toInt(r100, 0);
    }

    public int readData(byte[] r110) {
        if (this.response.body() != null) goto L17;
        return 0;
    L17:
        final int r111 = this.response.body().byteStream().read(r110);     // Catch: IOException -> L13
        if (r111 <= 0) goto L19;
        AVMDLLog.d(TAG, new h(this));     // Catch: IOException -> L13
        long r100 = r111;
        this.readOff += r100;     // Catch: IOException -> L13
        AVMDLRequest r101 = this.request;     // Catch: IOException -> L13
        r101.reqOff += r100;     // Catch: IOException -> L13
        long r102 = r101.size;     // Catch: IOException -> L13
        if (r102 <= 0) goto L11;
        r101.size = r102 - r100;     // Catch: IOException -> L13
    L11:
        AVMDLLog.d(TAG, new i(this, r111));     // Catch: IOException -> L13
        return r111;
    L19:
        return -1;
    L13:
        e = move-exception;
        this.isReadErr = true;
        AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
        return -1;
    }

    public static int toInt(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return r101;
    L8:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return r101;
    }

    public AVMDLResponse(AVMDLRequest r100, Response r101, Call r102) {
        this.request = r100;
        this.response = r101;
        this.call = r102;
        this.contentlength = -1;
        this.statusCode = -1;
        this.readOff = r100.reqOff;
        this.isReadErr = false;
        parseResponse();
    }
}
