package com.ss.android.lark.videosend.pre;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.videosend.tools.VideoTools;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/videosend/pre/PreConfig;", "", "filter", "Lcom/ss/android/lark/videosend/pre/FilterConfig;", VideoTools.ERROR_TYPE_COMPRESS, "Lcom/ss/android/lark/videosend/pre/PreCompressConfig;", TemplateNodeType.RAW, "Lcom/ss/android/lark/videosend/pre/PreRawConfig;", "<init>", "(Lcom/ss/android/lark/videosend/pre/FilterConfig;Lcom/ss/android/lark/videosend/pre/PreCompressConfig;Lcom/ss/android/lark/videosend/pre/PreRawConfig;)V", "getFilter", "()Lcom/ss/android/lark/videosend/pre/FilterConfig;", "setFilter", "(Lcom/ss/android/lark/videosend/pre/FilterConfig;)V", "getCompress", "()Lcom/ss/android/lark/videosend/pre/PreCompressConfig;", "setCompress", "(Lcom/ss/android/lark/videosend/pre/PreCompressConfig;)V", "getRaw", "()Lcom/ss/android/lark/videosend/pre/PreRawConfig;", "setRaw", "(Lcom/ss/android/lark/videosend/pre/PreRawConfig;)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreConfig {

    @SerializedName(VideoTools.ERROR_TYPE_COMPRESS)
    private PreCompressConfig compress;

    @SerializedName("filter")
    private FilterConfig filter;

    @SerializedName(TemplateNodeType.RAW)
    private PreRawConfig raw;

    public PreConfig() {
        this(null, null, null, 7, null);
    }

    public final PreCompressConfig getCompress() {
        return this.compress;
    }

    public final FilterConfig getFilter() {
        return this.filter;
    }

    public final PreRawConfig getRaw() {
        return this.raw;
    }

    public final void setCompress(PreCompressConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.compress = r100;
    }

    public final void setFilter(FilterConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filter = r100;
    }

    public final void setRaw(PreRawConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.raw = r100;
    }

    public PreConfig(FilterConfig r100, PreCompressConfig r101, PreRawConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        Intrinsics.checkNotNullParameter(r101, VideoTools.ERROR_TYPE_COMPRESS);
        Intrinsics.checkNotNullParameter(r102, TemplateNodeType.RAW);
        this.filter = r100;
        this.compress = r101;
        this.raw = r102;
    }

    public /* synthetic */ PreConfig(FilterConfig r110, PreCompressConfig r111, PreRawConfig r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r110 = new FilterConfig(0, 0, 0, 7, null);
    L6:
        if ((r113 & 2) == 0) goto L9;
        r111 = new PreCompressConfig(null, null, 3, null);
    L9:
        if ((r113 & 4) == 0) goto L11;
        r112 = new PreRawConfig(0, 0, 0, null, null, 0, 63, null);
    L11:
        this(r110, r111, r112);
    }
}
