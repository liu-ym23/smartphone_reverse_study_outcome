package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/videosend/tools/ResolutionConfig;", "", "width", "", "height", "<init>", "(II)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResolutionConfig {

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    public ResolutionConfig() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public ResolutionConfig(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    public /* synthetic */ ResolutionConfig(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = UnixStat.LINK_FLAG;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = UnixStat.LINK_FLAG;
    L8:
        this(r100, r101);
    }
}
