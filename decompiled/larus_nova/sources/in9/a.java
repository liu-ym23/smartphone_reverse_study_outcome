package in9;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.office.base.plugins.toolbar.model.FlowDocColorStop;
import com.larus.office.base.plugins.toolbar.model.RectData;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012Jt\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\t\u00103\u001a\u000204HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/ColorItem;", "", "angle", "", "colorStops", "", "Lcom/larus/office/base/plugins/toolbar/model/FlowDocColorStop;", "fillToRect", "Lcom/larus/office/base/plugins/toolbar/model/RectData;", "tileRect", "r", "", ce.f26391f, "b", "alpha", "<init>", "(Ljava/lang/Float;Ljava/util/List;Lcom/larus/office/base/plugins/toolbar/model/RectData;Lcom/larus/office/base/plugins/toolbar/model/RectData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)V", "getAngle", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getColorStops", "()Ljava/util/List;", "getFillToRect", "()Lcom/larus/office/base/plugins/toolbar/model/RectData;", "getTileRect", "getR", "()Ljava/lang/Integer;", "setR", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getG", "setG", "getB", "setB", "getAlpha", "setAlpha", "(Ljava/lang/Float;)V", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Float;Ljava/util/List;Lcom/larus/office/base/plugins/toolbar/model/RectData;Lcom/larus/office/base/plugins/toolbar/model/RectData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lcom/larus/office/base/plugins/toolbar/model/ColorItem;", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("alpha")
    private Float alpha;

    @SerializedName("angle")
    private final Float angle;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("b")
    private Integer f490623b;

    @SerializedName("color_stops")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FlowDocColorStop> colorStops;

    @SerializedName("fill_to_rect")
    private final RectData fillToRect;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SerializedName(ce.f26391f)
    private Integer f490624g;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @SerializedName("r")
    private Integer f490625r;

    @SerializedName("tile_rect")
    private final RectData tileRect;

    public final String toString() {
        return "ColorItem(angle=" + this.angle + ", colorStops=" + this.colorStops + ", fillToRect=" + this.fillToRect + ", tileRect=" + this.tileRect + ", r=" + this.f490625r + ", g=" + this.f490624g + ", b=" + this.f490623b + ", alpha=" + this.alpha + ')';
    }

    public final int hashCode() {
        Float r100 = this.angle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<FlowDocColorStop> r104 = this.colorStops;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        RectData r107 = this.fillToRect;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        RectData r110 = this.tileRect;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f490625r;
        if (r113 == null) goto L21;
        int r114 = r113.intValue();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f490624g;
        if (r116 == null) goto L25;
        int r117 = r116.intValue();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f490623b;
        if (r119 == null) goto L29;
        int r120 = r119.intValue();
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.alpha;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public a() {
        this.angle = null;
        this.colorStops = null;
        this.fillToRect = null;
        this.tileRect = null;
        this.f490625r = null;
        this.f490624g = null;
        this.f490623b = null;
        this.alpha = null;
    }

    public final Float a() {
        return this.alpha;
    }

    public final Float b() {
        return this.angle;
    }

    public final Integer c() {
        return this.f490623b;
    }

    public final List<FlowDocColorStop> d() {
        return this.colorStops;
    }

    public final Integer e() {
        return this.f490624g;
    }

    public final Integer f() {
        return this.f490625r;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.angle, r101.angle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorStops, r101.colorStops) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fillToRect, r101.fillToRect) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tileRect, r101.tileRect) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f490625r, r101.f490625r) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f490624g, r101.f490624g) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f490623b, r101.f490623b) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.alpha, r101.alpha) == true) goto L32;
        return false;
    L32:
        return true;
    }
}
