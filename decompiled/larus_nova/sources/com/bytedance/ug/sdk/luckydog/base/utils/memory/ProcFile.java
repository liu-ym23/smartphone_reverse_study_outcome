package com.bytedance.ug.sdk.luckydog.base.utils.memory;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = null;
    public final String content;

    public static class a implements Parcelable.Creator<ProcFile> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProcFile createFromParcel(Parcel r100) {
            return new ProcFile(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProcFile[] newArray(int r100) {
            return new ProcFile[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // java.io.File
    public long length() {
        return this.content.length();
    }

    public ProcFile(Parcel r100) {
        super(r100.readString());
        this.content = r100.readString();
    }

    public static String readFile(String r100) throws IOException {
        BufferedReader r101 = null;
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L12
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L12
        String r104 = r103.readLine();     // Catch: Throwable -> L10
        String r105 = "";
    L5:
        if (r104 == null) goto L7;
        r102.append(r105);     // Catch: Throwable -> L10
        r102.append(r104);     // Catch: Throwable -> L10
        r105 = "\n";
        r104 = r103.readLine();     // Catch: Throwable -> L10
        goto L5
    L7:
        String r106 = r102.toString();     // Catch: Throwable -> L10
        r103.close();     // Catch: IOException -> L16
    L9:
        return r106;
    L10:
        th = th;
        r101 = r103;
    L13:
        if (r101 != null) goto L20;
    L15:
        throw th;
    L20:
        r101.close();     // Catch: IOException -> L17
    L12:
        th = th;
        goto L13
    }

    public ProcFile(String r100) throws IOException {
        super(r100);
        this.content = readFile(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(getAbsolutePath());
        r100.writeString(this.content);
    }
}
