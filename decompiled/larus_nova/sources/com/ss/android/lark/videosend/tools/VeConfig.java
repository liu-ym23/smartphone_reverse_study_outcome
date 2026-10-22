package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VeConfig;", "", "remuxFileSize", "", "internalSetting", "Lcom/ss/android/lark/videosend/tools/InternalSetting;", "feature", "Lcom/ss/android/lark/videosend/tools/Feature;", "unsupportedMagic", "", "", "<init>", "(ILcom/ss/android/lark/videosend/tools/InternalSetting;Lcom/ss/android/lark/videosend/tools/Feature;Ljava/util/List;)V", "getRemuxFileSize", "()I", "setRemuxFileSize", "(I)V", "getInternalSetting", "()Lcom/ss/android/lark/videosend/tools/InternalSetting;", "setInternalSetting", "(Lcom/ss/android/lark/videosend/tools/InternalSetting;)V", "getFeature", "()Lcom/ss/android/lark/videosend/tools/Feature;", "setFeature", "(Lcom/ss/android/lark/videosend/tools/Feature;)V", "getUnsupportedMagic", "()Ljava/util/List;", "setUnsupportedMagic", "(Ljava/util/List;)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VeConfig {

    @SerializedName("feature")
    private Feature feature;

    @SerializedName("internal_setting")
    private InternalSetting internalSetting;

    @SerializedName("remux_max_file_size")
    private int remuxFileSize;

    @SerializedName("unsupported_header_magic")
    private List<String> unsupportedMagic;

    public VeConfig() {
        this(0, null, null, null, 15, null);
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final InternalSetting getInternalSetting() {
        return this.internalSetting;
    }

    public final int getRemuxFileSize() {
        return this.remuxFileSize;
    }

    public final List<String> getUnsupportedMagic() {
        return this.unsupportedMagic;
    }

    public final void setFeature(Feature r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.feature = r100;
    }

    public final void setInternalSetting(InternalSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.internalSetting = r100;
    }

    public final void setRemuxFileSize(int r100) {
        this.remuxFileSize = r100;
    }

    public final void setUnsupportedMagic(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unsupportedMagic = r100;
    }

    public VeConfig(int r100, InternalSetting r101, Feature r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r101, "internalSetting");
        Intrinsics.checkNotNullParameter(r102, "feature");
        Intrinsics.checkNotNullParameter(r103, "unsupportedMagic");
        this.remuxFileSize = r100;
        this.internalSetting = r101;
        this.feature = r102;
        this.unsupportedMagic = r103;
    }

    public /* synthetic */ VeConfig(int r100, InternalSetting r101, Feature r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = 157286400;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = new InternalSetting(0, 0, 0, null, 15, null);
    L9:
        if ((r112 & 4) == 0) goto L12;
        r110 = new Feature(null, null, null, 0, 15, null);
    L12:
        if ((r112 & 8) == 0) goto L14;
        r111 = CollectionsKt.listOf("EXTM3U");
    L14:
        this(r100, r101, r110, r111);
    }
}
