package nk9;

import android.graphics.Rect;
import android.util.Range;
import android.view.View;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.larus.media.focus.CardContextState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f519488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f519489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f519490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f519491d;

    @Override // nk9.d
    public final void A3(CardContextState r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        this.f519488a.A3(r100, r101);
    }

    @Override // nk9.d
    public final float C0() {
        return this.f519488a.C0();
    }

    @Override // nk9.d
    public final float E2() {
        return this.f519488a.E2();
    }

    @Override // nk9.d
    public final float F2() {
        return this.f519488a.F2();
    }

    @Override // nk9.d
    public final void F3(CardContextState r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        this.f519488a.F3(r100, r101);
    }

    @Override // nk9.d
    public final View I0() {
        return this.f519488a.I0();
    }

    @Override // nk9.d
    public final float X1() {
        return this.f519488a.X1();
    }

    @Override // nk9.d
    public final float h2() {
        return this.f519488a.h2();
    }

    @Override // nk9.d
    public final float h3() {
        return this.f519488a.h3();
    }

    @Override // nk9.d
    public final void q2(CardContextState r100, Range<Float> r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        this.f519488a.q2(r100, r101);
    }

    @Override // nk9.d
    public final String S0() {
        if (Intrinsics.areEqual(this.f519490c, this.f519488a.S0()) == true) goto L6;
        this.f519490c = this.f519488a.S0();
        this.f519491d = false;
    L6:
        return this.f519490c;
    }

    public final Rect a() {
        int[] r100 = n.f519505a;
        n.b(this.f519488a.I0(), this.f519489b);
        Rect r101 = this.f519489b;
        n.a(r101, F2(), X1(), h2(), E2());
        return r101;
    }

    public final boolean b() {
        if (Intrinsics.areEqual(this.f519490c, this.f519488a.S0()) == true) goto L6;
        this.f519490c = this.f519488a.S0();
        this.f519491d = false;
    L6:
        return this.f519491d;
    }

    public b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f519488a = r100;
        this.f519489b = new Rect();
        this.f519490c = "";
        boolean r101 = r100 instanceof b;
    }

    @Override // nk9.d
    public final void A0(CardContextState r100) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        this.f519491d = false;
        this.f519488a.A0(r100);
    }

    @Override // nk9.d
    public final void c2(CardContextState r100, go2.g r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r101, "cardCallback");
        this.f519491d = true;
        this.f519488a.c2(r100, r101);
    }
}
