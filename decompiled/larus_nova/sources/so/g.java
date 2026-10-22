package so;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.s;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends com.bytedance.android.ec.window.base.dynamicview.renderer.a<ro.b, a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, GradientDrawable.Orientation> f542698d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f542699e = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lso/g$a;", "Lto/a;", "", "", "colorList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "radius", "e", "orientation", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends to.a {

        @SerializedName(EventConstant.Key.COLOR)
        private final List<String> colorList;

        @SerializedName("orientation")
        private final String orientation;

        @SerializedName("radius")
        private final List<Float> radius;

        public final List<String> c() {
            return this.colorList;
        }

        public final String d() {
            return this.orientation;
        }

        public final List<Float> e() {
            return this.radius;
        }
    }

    static {
        f542699e = new g();
        f542698d = MapsKt.mapOf(new Pair[]{TuplesKt.to("left_right", GradientDrawable.Orientation.LEFT_RIGHT), TuplesKt.to("tl_br", GradientDrawable.Orientation.TL_BR), TuplesKt.to("top_bottom", GradientDrawable.Orientation.TOP_BOTTOM), TuplesKt.to("tr_bl", GradientDrawable.Orientation.TR_BL), TuplesKt.to("right_left", GradientDrawable.Orientation.RIGHT_LEFT), TuplesKt.to("br_tl", GradientDrawable.Orientation.BR_TL), TuplesKt.to("bottom_top", GradientDrawable.Orientation.BOTTOM_TOP), TuplesKt.to("bl_tr", GradientDrawable.Orientation.BL_TR)});
    }

    public g() {
        super(ro.b.class, a.class, KFFeatureEffect.GRADIENT_JSON_FIELD);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void c(View r100) {
        ro.b r101 = (ro.b) r100;
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        int r102 = com.bytedance.android.ec.window.base.utils.c.f49722a;
        Intrinsics.checkNotNullParameter(r101, "$this$setBackgroundCompat");
        r101.setBackground(null);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final to.a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        return a(r100);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void b(View r100, to.a r110) {
        ro.b r101 = (ro.b) r100;
        a r111 = (a) r110;
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r111, "vo");
        GradientDrawable r102 = new GradientDrawable();
        List<String> r103 = r111.c();
        if (r103 == null) goto L10;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L12;
        Integer r106 = s.b((String) r105.next());
        if (r106 == null) goto L6;
        r104.add(r106);
    L12:
        if (r104 != null) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == false) goto L21;
        return;
    L21:
        if (r104.size() <= 1) goto L23;
        com.bytedance.android.ec.window.base.utils.c.e(r102, CollectionsKt.toIntArray(r104));
    L26:
        GradientDrawable.Orientation r108 = f542698d.get(r111.d());
        if (r108 != null) goto L29;
        r108 = GradientDrawable.Orientation.LEFT_RIGHT;
    L29:
        com.bytedance.android.ec.window.base.utils.c.f(r102, r108);
        List<Float> r112 = r111.e();
        if (r112 != null) goto L32;
        r112 = CollectionsKt.emptyList();
    L32:
        float r109 = 0.0f;
        if (r112.size() != 4) goto L43;
        float[] r113 = new float[8];
        int r114 = 0;
    L35:
        if (r114 >= 8) goto L41;
        Float r115 = (Float) CollectionsKt.getOrNull(r112, r114 / 2);
        if (r115 == null) goto L39;
        float r116 = q.a(r115);
    L40:
        r113[r114] = r116;
        r114 = r114 + 1;
        goto L35
    L39:
        r116 = 0.0f;
        goto L40
    L41:
        r102.setCornerRadii(r113);
    L43:
        if (r112.size() != 1) goto L48;
        Float r117 = (Float) CollectionsKt.getOrNull(r112, 0);
        if (r117 == null) goto L47;
        r109 = q.a(r117);
    L47:
        r102.setCornerRadius(r109);
    L48:
        Intrinsics.checkNotNullParameter(r101, "$this$setBackgroundCompat");
        r101.setBackground(r102);
        return;
    L23:
        Integer r118 = (Integer) CollectionsKt.getOrNull(r104, 0);
        if (r118 == null) goto L26;
        r102.setColor(r118.intValue());
        goto L26
    L14:
        if (r104.isEmpty() == true) goto L17;
        r107 = false;
        goto L18
    L10:
        r104 = null;
        goto L12
    }
}
