package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/DownloadFileParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "fileToken", "", "fileName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFileToken", "()Ljava/lang/String;", "getFileName", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadFileParam implements NonProguard {
    private final String fileName;
    private final String fileToken;

    public static /* synthetic */ DownloadFileParam copy$default(DownloadFileParam r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.fileToken;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.fileName;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.fileToken;
    }

    public final String component2() {
        return this.fileName;
    }

    public final DownloadFileParam copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        return new DownloadFileParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DownloadFileParam) == true) goto L8;
        return false;
    L8:
        DownloadFileParam r101 = (DownloadFileParam) r100;
        if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.fileToken.hashCode() * 31;
        String r101 = this.fileName;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "DownloadFileParam(fileToken='" + this.fileToken + "', fileName=" + this.fileName + ')';
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public DownloadFileParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        this.fileToken = r100;
        this.fileName = r101;
    }
}
