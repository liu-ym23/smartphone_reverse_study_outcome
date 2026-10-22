package s6c;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import com.ss.android.lark.tangram.engine.TangramNative;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f540882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TCStyle f540883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Props f540884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f540885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f540886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f540887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<a> f540888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b.a f540889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b.a f540890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f540891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f540892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f540893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f540894o;

    public abstract a b();

    public long c(int r100) {
        return 0;
    }

    public abstract View d();

    public abstract boolean g(a r100);

    public final void i() {
        this.f540892m = false;
        this.f540891l = false;
        TCStyle r100 = this.f540883d;
        if (r100 == null) goto L5;
        r100.setDataChange(false);
    L5:
        this.f540884e.setDataChange(false);
    }

    public abstract void n(View r100);

    public final RectF a() {
        RectF r100 = this.f540893n;
        float r101 = r100.left;
        PointF r102 = this.f540894o;
        float r103 = r102.x;
        float r104 = r100.top;
        float r105 = r102.y;
        return new RectF(r101 + r103, r104 + r105, r100.right + r103, r100.bottom + r105);
    }

    public final boolean h() {
        if (this.f540891l == false) goto L5;
    L13:
        return true;
    L5:
        if (this.f540892m == true) goto L13;
        if (this.f540884e.isDataChange() == true) goto L13;
        TCStyle r100 = this.f540883d;
        if (r100 == null) goto L11;
        boolean r101 = r100.isDataChange();
    L12:
        if (r101 == true) goto L13;
        return false;
    L11:
        r101 = false;
        goto L12
    }

    public static float e(Value r100) {
        if (r100 == null) goto L6;
        Float r101 = r100.getValue();
        if (r101 == null) goto L6;
        return r101.floatValue();
    L6:
        return 0.0f;
    }

    public static int f(ValueType r100) {
        if (r100 != null) goto L6;
        r100 = ValueType.AUTO;
    L6:
        return r100.getValue();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(r101, r102) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.tangram.base.node.BaseVirtualNode");
        if (Intrinsics.areEqual(this.f540880a, ((a) r100).f540880a) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r102 = null;
        goto L10
    }

    public final void j(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(this.f540893n, r100) == true) goto L6;
        this.f540891l = true;
        this.f540893n = r100;
        return;
    }

    public final void k(PointF r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(this.f540894o, r100) == true) goto L6;
        this.f540892m = true;
        this.f540894o = r100;
        return;
    }

    public final b.a l(b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        if (this.f540884e.getForceUpdateLayout() == false) goto L5;
    L16:
        b r101 = this.f540882c;
        if (r101 == null) goto L19;
        b.a r102 = r101.d(r100);
    L20:
        this.f540890k = r100;
        if (r102 != null) goto L23;
        b.a r103 = this.f540889j;
    L24:
        this.f540889j = r103;
        this.f540884e.setForceUpdateLayout(false);
        float r104 = 0.0f;
        if (r102 == null) goto L27;
        float r105 = r102.f540895a;
    L28:
        if (r102 == null) goto L31;
        r104 = r102.f540896b;
    L31:
        return new b.a(r105, r104);
    L27:
        r105 = 0.0f;
        goto L28
    L23:
        r103 = r102;
        goto L24
    L19:
        r102 = null;
        goto L20
    L5:
        if (this.f540884e.isDataChange() == true) goto L16;
        TCStyle r106 = this.f540883d;
        if (r106 == null) goto L11;
        boolean r107 = true;
        if (r106.isDataChange() != true) goto L11;
    L12:
        if (r107 == true) goto L16;
        if (Intrinsics.areEqual(r100, this.f540890k) == false) goto L16;
        b.a r108 = this.f540889j;
        return new b.a(r108.f540895a, r108.f540896b);
    L11:
        r107 = false;
        goto L12
    }

    public final void m(long r100) {
        TCStyle r101 = this.f540883d;
        if (r101 == null) goto L46;
        Float r102 = r101.getScaleWidth().getValue();
        if (r102 == null) goto L8;
        float r103 = r102.floatValue();
    L10:
        if (r103 <= 0.0f) goto L12;
        Value r104 = r101.getScaleWidth();
    L13:
        float r105 = e(r104);
        Value r106 = r101.getWidth();
        ValueType r107 = null;
        if (r106 == null) goto L16;
        ValueType r108 = r106.getValueType();
    L17:
        TangramNative.setStyleWidth(r100, r105, f(r108));
        Float r109 = r101.getScaleHeight().getValue();
        if (r109 == null) goto L20;
        float r110 = r109.floatValue();
    L22:
        if (r110 <= 0.0f) goto L24;
        Value r111 = r101.getScaleHeight();
    L25:
        float r112 = e(r111);
        Value r113 = r101.getHeight();
        if (r113 == null) goto L28;
        ValueType r114 = r113.getValueType();
    L29:
        TangramNative.setStyleHeight(r100, r112, f(r114));
        float r115 = e(r101.getMaxHeight());
        Value r116 = r101.getMaxHeight();
        if (r116 == null) goto L32;
        ValueType r117 = r116.getValueType();
    L33:
        TangramNative.setStyleMaxHeight(r100, r115, f(r117));
        float r118 = e(r101.getMaxWidth());
        Value r119 = r101.getMaxWidth();
        if (r119 == null) goto L36;
        ValueType r120 = r119.getValueType();
    L37:
        TangramNative.setStyleMaxWidth(r100, r118, f(r120));
        float r121 = e(r101.getMinWidth());
        Value r122 = r101.getMinWidth();
        if (r122 == null) goto L40;
        ValueType r123 = r122.getValueType();
    L41:
        TangramNative.setStyleMinWidth(r100, r121, f(r123));
        float r124 = e(r101.getMinHeight());
        Value r125 = r101.getMinHeight();
        if (r125 == null) goto L44;
        r107 = r125.getValueType();
    L44:
        TangramNative.setStyleMinHeight(r100, r124, f(r107));
        TangramNative.setStyleAspectRatio(r100, r101.getAspectRatio());
        TangramNative.setStyleGrowWeight(r100, r101.getGrowWeight());
        TangramNative.setStyleShrinkWeight(r100, r101.getShrinkWeight());
        TangramNative.setStyleAlign(r100, r101.getAlign_self().getValue());
        return;
    L40:
        r123 = null;
        goto L41
    L36:
        r120 = null;
        goto L37
    L32:
        r117 = null;
        goto L33
    L28:
        r114 = null;
        goto L29
    L24:
        r111 = r101.getHeight();
        goto L25
    L20:
        r110 = 0.0f;
        goto L22
    L16:
        r108 = null;
        goto L17
    L12:
        r104 = r101.getWidth();
        goto L13
    L8:
        r103 = 0.0f;
        goto L10
    }

    public a(String r100, String r101, b r102, TCStyle r103, Props r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        Intrinsics.checkNotNullParameter(r101, "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r104, SlcElement.KEY_PROPS);
        this.f540880a = r100;
        this.f540881b = r101;
        this.f540882c = r102;
        this.f540883d = r103;
        this.f540884e = r104;
        this.f540885f = r105;
        this.f540888i = new ArrayList();
        this.f540889j = new b.a(0.0f, 0.0f);
        this.f540890k = new b.a(0.0f, 0.0f);
        this.f540893n = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f540894o = new PointF(0.0f, 0.0f);
    }
}
