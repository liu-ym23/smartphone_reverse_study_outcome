package t51;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.link.player.DeviceType;
import com.dtf.face.config.IConstValues;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR4\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR4\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR4\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lt51/g;", "", "", "", "Lt51/a;", "adjustRules", "Ljava/util/Map;", "b", "()Ljava/util/Map;", ce.f26391f, "(Ljava/util/Map;)V", "", "Lt51/e;", "regions", "e", RXScreenCaptureService.KEY_INDEX, "Lt51/b;", "mixStreamRegions", "d", "h", "seiRegions", "f", ce.f26395j, "", "configID", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setConfigID", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("adjust_map")
    private Map<Integer, t51.a> adjustRules;

    @SerializedName("config_id")
    private String configID;

    @SerializedName("mix_stream_regions")
    private Map<Integer, ? extends List<? extends b>> mixStreamRegions;

    @SerializedName("regions")
    private Map<Integer, ? extends List<e>> regions;

    @SerializedName("sei_regions")
    private Map<Integer, ? extends List<? extends b>> seiRegions;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "RevLayoutConfig={adjustRules=" + this.adjustRules + ",regions=" + this.regions + ",mixStreamRegions=" + this.mixStreamRegions + ",seiRegions=" + this.seiRegions + ",configID=" + this.configID + com.alipay.sdk.m.u.i.f25855d;
    }

    public g() {
        this.adjustRules = MapsKt.emptyMap();
        this.regions = MapsKt.emptyMap();
        this.mixStreamRegions = MapsKt.emptyMap();
        this.seiRegions = MapsKt.emptyMap();
        this.configID = "";
    }

    public final Map<Integer, t51.a> b() {
        return this.adjustRules;
    }

    public final String c() {
        return this.configID;
    }

    public final Map<Integer, List<b>> d() {
        return this.mixStreamRegions;
    }

    public final Map<Integer, List<e>> e() {
        return this.regions;
    }

    public final Map<Integer, List<b>> f() {
        return this.seiRegions;
    }

    public final void g(Map<Integer, t51.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adjustRules = r100;
    }

    public final void h(Map<Integer, ? extends List<? extends b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mixStreamRegions = r100;
    }

    public final void i(Map<Integer, ? extends List<e>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.regions = r100;
    }

    public final void j(Map<Integer, ? extends List<? extends b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.seiRegions = r100;
    }

    public final t51.a a(DeviceType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        if (r101 <= 0) goto L5;
        int r102 = 1 << (r101 + 6);
    L6:
        t51.a r103 = this.adjustRules.get(Integer.valueOf(r100.ordinal() + r102));
        if (r103 != null) goto L9;
        r103 = this.adjustRules.get(Integer.valueOf(r100.ordinal()));
    L9:
        if (r103 != null) goto L11;
        r103 = this.adjustRules.get(Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal() + r102));
    L11:
        if (r103 == null) goto L13;
        return r103;
    L13:
        return this.adjustRules.get(Integer.valueOf(DeviceType.NORMAL_MOBILE.ordinal()));
    L5:
        r102 = 0;
        goto L6
    }
}
