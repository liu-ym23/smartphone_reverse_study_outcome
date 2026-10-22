package eia;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class e extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f472792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f472793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f472794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f472795g;

    public static final class a {
    }

    static {
    }

    public void f(boolean r100) {
    }

    public void g() {
    }

    public final void c() {
        ICoreInputAbility r100 = (ICoreInputAbility) this.f472792d.getValue();
        if (r100 == null) goto L7;
        CoreInputAbility r101 = r100.JO();
        if (r101 == null) goto L7;
        r101.w9(false);
    L7:
        ICoreInputAbility r102 = (ICoreInputAbility) this.f472792d.getValue();
        if (r102 == null) goto L12;
        CoreInputAbility r103 = r102.JO();
        if (r103 == null) goto L12;
        r103.n9(true);
    L12:
        va8.c r104 = e();
        View r105 = null;
        if (r104 == null) goto L15;
        GradientMaskView r106 = ((com.larus.bmhome.chat.component.bottom.core.a) r104).a();
    L16:
        if (r106 == null) goto L18;
        e1.o(r106);
    L18:
        va8.c r107 = e();
        if (r107 == null) goto L21;
        RecyclerView r108 = ((com.larus.bmhome.chat.component.bottom.core.a) r107).d();
    L22:
        if (r108 == null) goto L24;
        e1.o(r108);
    L24:
        FrameLayout r109 = (FrameLayout) this.f472795g.getValue();
        if (r109 == null) goto L27;
        r105 = r109.findViewById(R.id.obric_window_action_view);
    L27:
        if (r105 == null) goto L30;
        e1.o(r105);
        return;
    L30:
        return;
    L21:
        r108 = null;
        goto L22
    L15:
        r106 = null;
        goto L16
    }

    public final void d() {
        ICoreInputAbility r100 = (ICoreInputAbility) this.f472792d.getValue();
        if (r100 == null) goto L7;
        CoreInputAbility r101 = r100.JO();
        if (r101 == null) goto L7;
        r101.w9(true);
    L7:
        ICoreInputAbility r102 = (ICoreInputAbility) this.f472792d.getValue();
        if (r102 == null) goto L12;
        CoreInputAbility r103 = r102.JO();
        if (r103 == null) goto L12;
        r103.n9(false);
    L12:
        va8.c r104 = e();
        View r105 = null;
        if (r104 == null) goto L15;
        GradientMaskView r106 = ((com.larus.bmhome.chat.component.bottom.core.a) r104).a();
    L16:
        if (r106 == null) goto L18;
        e1.x(r106);
    L18:
        va8.c r107 = e();
        if (r107 == null) goto L21;
        RecyclerView r108 = ((com.larus.bmhome.chat.component.bottom.core.a) r107).d();
    L22:
        if (r108 == null) goto L24;
        e1.x(r108);
    L24:
        FrameLayout r109 = (FrameLayout) this.f472795g.getValue();
        if (r109 == null) goto L27;
        r105 = r109.findViewById(R.id.obric_window_action_view);
    L27:
        if (r105 == null) goto L30;
        e1.x(r105);
        return;
    L30:
        return;
    L21:
        r108 = null;
        goto L22
    L15:
        r106 = null;
        goto L16
    }

    public final va8.c e() {
        va8.o r100 = (va8.o) this.f472794f.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Uv();
    }

    public e(Context r100, final t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        super(r100, r101);
        this.f472792d = LazyKt.lazy(new eia.a(r101));
        this.f472793e = LazyKt.lazy(new b(r101));
        this.f472794f = LazyKt.lazy(new c(r101));
        this.f472795g = LazyKt.lazy(new d(this));
    }
}
