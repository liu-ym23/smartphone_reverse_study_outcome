package pz3;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends pz3.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f531087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f531088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f531089n;

    public static final class a {
    }

    static {
    }

    public final void f() {
        View r100 = this.f531071g;
        if (r100 == null) goto L12;
        ViewGroup.LayoutParams r101 = this.f531069e;
        if (r101 == null) goto L8;
        b.b(r100, r101);
        c.b("resetParamByUnbind");
    L8:
        if (d(r100) == null) goto L12;
        if (this.f531070f == null) goto L12;
        b.b(d(r100), this.f531070f);
        c.b("resetParamByUnbind");
    L12:
        this.f531066b = x54.a.a(539);
        this.f531068d = 2.1474836E9f;
        this.f531069e = null;
        this.f531070f = null;
        this.f531071g = null;
        this.f531065a = true;
    }

    public static View b(View r100) {
        Object r101 = r100.getParent().getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        return ((View) r101).findViewById(R.id.fullvideo_play_background);
    }

    public static View c(View r100) {
        Object r101 = r100.getParent().getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        return ((View) r101).findViewById(R.id.videoview_bottom_mask);
    }

    public static View d(View r100) {
        Object r101 = r100.getParent().getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        return ((View) r101).findViewById(R.id.fullvideo_play_foreground);
    }

    public static View e(View r100) {
        Object r101 = r100.getParent().getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        return ((View) r101).findViewById(R.id.videoview_top_mask);
    }

    public final void a(float r100) {
        if (r100 <= 120) goto L11;
        if (this.f531065a == false) goto L17;
        Function0<Unit> r101 = this.f531089n.f531090a;
        if (r101 == null) goto L9;
        r101.invoke();
    L9:
        this.f531065a = false;
        return;
    L17:
        return;
    L11:
        if (this.f531065a == true) goto L19;
        Function0<Unit> r102 = this.f531089n.f531091b;
        if (r102 == null) goto L15;
        r102.invoke();
    L15:
        this.f531065a = true;
        return;
    }

    public e(View r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "mRootView");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f531087l = r100;
        this.f531088m = null;
        this.f531089n = r101;
    }
}
