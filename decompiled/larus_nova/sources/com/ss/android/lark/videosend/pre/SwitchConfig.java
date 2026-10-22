package com.ss.android.lark.videosend.pre;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/videosend/pre/SwitchConfig;", "", "selectVideoEnable", "", "openAlbumEnable", "shareFromSystemEnable", "previewVideoEnable", "<init>", "(IIII)V", "getSelectVideoEnable", "()I", "setSelectVideoEnable", "(I)V", "getOpenAlbumEnable", "setOpenAlbumEnable", "getShareFromSystemEnable", "setShareFromSystemEnable", "getPreviewVideoEnable", "setPreviewVideoEnable", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchConfig {

    @SerializedName("open_album_enable")
    private int openAlbumEnable;

    @SerializedName("preview_video_enable")
    private int previewVideoEnable;

    @SerializedName("select_video_enable")
    private int selectVideoEnable;

    @SerializedName("share_from_system_enable")
    private int shareFromSystemEnable;

    public SwitchConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public final int getOpenAlbumEnable() {
        return this.openAlbumEnable;
    }

    public final int getPreviewVideoEnable() {
        return this.previewVideoEnable;
    }

    public final int getSelectVideoEnable() {
        return this.selectVideoEnable;
    }

    public final int getShareFromSystemEnable() {
        return this.shareFromSystemEnable;
    }

    public final void setOpenAlbumEnable(int r100) {
        this.openAlbumEnable = r100;
    }

    public final void setPreviewVideoEnable(int r100) {
        this.previewVideoEnable = r100;
    }

    public final void setSelectVideoEnable(int r100) {
        this.selectVideoEnable = r100;
    }

    public final void setShareFromSystemEnable(int r100) {
        this.shareFromSystemEnable = r100;
    }

    public SwitchConfig(int r100, int r101, int r102, int r103) {
        this.selectVideoEnable = r100;
        this.openAlbumEnable = r101;
        this.shareFromSystemEnable = r102;
        this.previewVideoEnable = r103;
    }

    public /* synthetic */ SwitchConfig(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 1;
    L14:
        this(r100, r101, r102, r103);
    }
}
