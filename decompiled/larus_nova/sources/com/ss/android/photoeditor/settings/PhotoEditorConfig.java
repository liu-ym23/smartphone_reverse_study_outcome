package com.ss.android.photoeditor.settings;

import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ss/android/photoeditor/settings/PhotoEditorConfig;", "", GearStrategyConsts.EV_QUALITY, "", "Lcom/ss/android/photoeditor/settings/QualityItem;", "improveWay", "Lcom/ss/android/photoeditor/settings/ImproveWay;", "<init>", "(Ljava/util/List;Lcom/ss/android/photoeditor/settings/ImproveWay;)V", "getQuality", "()Ljava/util/List;", "setQuality", "(Ljava/util/List;)V", "getImproveWay", "()Lcom/ss/android/photoeditor/settings/ImproveWay;", "setImproveWay", "(Lcom/ss/android/photoeditor/settings/ImproveWay;)V", "toString", "", "photoeditor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoEditorConfig {

    @SerializedName("improve_way")
    private ImproveWay improveWay;

    @SerializedName(FrescoMonitorConst.IMAGE_QUALITY)
    private List<QualityItem> quality;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoEditorConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "quality=" + this.quality + ",improveWay=" + this.improveWay;
    }

    public final ImproveWay getImproveWay() {
        return this.improveWay;
    }

    public final List<QualityItem> getQuality() {
        return this.quality;
    }

    public final void setImproveWay(ImproveWay r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.improveWay = r100;
    }

    public final void setQuality(List<QualityItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.quality = r100;
    }

    public PhotoEditorConfig(List<QualityItem> r100, ImproveWay r101) {
        Intrinsics.checkNotNullParameter(r100, GearStrategyConsts.EV_QUALITY);
        Intrinsics.checkNotNullParameter(r101, "improveWay");
        this.quality = r100;
        this.improveWay = r101;
    }

    public /* synthetic */ PhotoEditorConfig(List r100, ImproveWay r101, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = CollectionsKt.mutableListOf(new QualityItem[]{new QualityItem(CollectionsKt.mutableListOf(new Integer[]{0, 1}), TECameraUtils.CAPTURE_HQ_2X, 1440), new QualityItem(CollectionsKt.mutableListOf(new Integer[]{2, 3}), TECameraUtils.CAPTURE_NORMAL, 1080), new QualityItem(CollectionsKt.mutableListOf(new Integer[]{4, 5}), 1280, 720)});
    L6:
        if ((r110 & 2) == 0) goto L8;
        r101 = new ImproveWay(null, null, 3, null);
    L8:
        this(r100, r101);
    }
}
