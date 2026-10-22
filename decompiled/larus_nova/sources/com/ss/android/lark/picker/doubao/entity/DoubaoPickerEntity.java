package com.ss.android.lark.picker.doubao.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "", "<init>", "()V", "fileType", "", "getFileType", "()I", "setFileType", "(I)V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "fileToken", "getFileToken", "setFileToken", "fileURL", "getFileURL", "setFileURL", "openTime", "", "getOpenTime", "()J", "setOpenTime", "(J)V", "editTime", "getEditTime", "setEditTime", "iconInfo", "getIconInfo", "setIconInfo", "bitableBizType", "getBitableBizType", "()Ljava/lang/Integer;", "setBitableBizType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isOwner", "", "()Z", "setOwner", "(Z)V", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoPickerEntity {
    private Integer bitableBizType;
    private long editTime;
    private String fileName;
    private String fileToken;
    private int fileType;
    private String fileURL;
    private String iconInfo;
    private boolean isOwner;
    private long openTime;

    public DoubaoPickerEntity() {
        this.fileName = "";
        this.fileToken = "";
        this.fileURL = "";
    }

    public final Integer getBitableBizType() {
        return this.bitableBizType;
    }

    public final long getEditTime() {
        return this.editTime;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getFileURL() {
        return this.fileURL;
    }

    public final String getIconInfo() {
        return this.iconInfo;
    }

    public final long getOpenTime() {
        return this.openTime;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final void setBitableBizType(Integer r100) {
        this.bitableBizType = r100;
    }

    public final void setEditTime(long r100) {
        this.editTime = r100;
    }

    public final void setFileName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileName = r100;
    }

    public final void setFileToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileToken = r100;
    }

    public final void setFileType(int r100) {
        this.fileType = r100;
    }

    public final void setFileURL(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileURL = r100;
    }

    public final void setIconInfo(String r100) {
        this.iconInfo = r100;
    }

    public final void setOpenTime(long r100) {
        this.openTime = r100;
    }

    public final void setOwner(boolean r100) {
        this.isOwner = r100;
    }
}
