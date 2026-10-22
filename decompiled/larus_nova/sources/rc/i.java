package rc;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lrc/i;", "", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Ljava/lang/String;", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "biz", "getBiz", "setBiz", "Lrc/k;", "events", "Lrc/k;", "getEvents", "()Lrc/k;", "", "exposureRepeatedly", "Z", "getExposureRepeatedly", "()Z", "setExposureRepeatedly", "(Z)V", "", "exposureScale", FaceService.girlLabel, "getExposureScale", "()F", "setExposureScale", "(F)V", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class i {

    @SerializedName("biz")
    private String biz;

    @SerializedName("events")
    private final k events;

    @SerializedName("exposure_repeatedly")
    private boolean exposureRepeatedly;

    @SerializedName("exposure_scale")
    private float exposureScale;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private String model;

    public final int hashCode() {
        return (this.model.hashCode() * 31) + this.biz.hashCode();
    }

    public final String toString() {
        return "BstModelConfig(model='" + this.model + "', biz='" + this.biz + "',  events=" + this.events + ", exposureRepeatedly=" + this.exposureRepeatedly + ", exposureScale=" + this.exposureScale + ')';
    }

    public i() {
        this.model = "shopping";
        this.biz = "ecommerce";
        this.events = new k();
        this.exposureScale = 0.25f;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.biz, r101.biz) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
