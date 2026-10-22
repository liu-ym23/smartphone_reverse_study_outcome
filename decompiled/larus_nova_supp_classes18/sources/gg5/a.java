package gg5;

import android.R;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements vf5.a {
    public final i0 a;
    public final m b;
    public MessageConfig c;

    public final MessageConfig a() {
        MessageConfig r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new MessageConfig();
    }

    public final void b() {
        i0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.d(false);
        return;
    }

    public final boolean c() {
        i0 r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d.getParent() == null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public final void d(boolean r7) {
        final i0 r0 = this.a;
        if (r0 == null) goto L16;
        bg5.a.b();
        bg5.a.j.set(r7);
        r0.e();
        r0.k.e();
        r0.k.f();
        tt5.a.h("PanelViewV2", "showPanel, auto: " + r0.m.d().isAuto());
        sa5.b r8 = r0.c();
        if (r8 == null) goto L7;
        r8.e(r0.s);
    L7:
        r0.m.c.b(true, false);
        r0.d.setTranslationX(0.0f);
        r0.d.setTranslationY(0.0f);
        if (r0.d.getParent() != null) goto L14;
        ViewGroup r9 = r0.c;
        if (r9 == null) goto L12;
        r9.addView(r0.d);
    L13:
        r0.b(r0.a.getResources().getConfiguration());
        r0.m.f.observe(r0.b, new r(r0));
        r0.m.d.observe(r0.b, new s(r0));
        r0.m.e.observe(r0.b, new t(r0));
        r0.m.g.observe(r0.b, new u(r0));
        goto L14
    L12:
        ((ViewGroup) r0.a.findViewById(R.id.content)).addView(r0.d);
    L14:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.bear.facade.common.widget.d.q, 0.0f});
        r10.addUpdateListener(new y(r0));
        r10.setDuration(200);
        r10.start();
        View r11 = r0.d;
        com.bytedance.ee.bear.facade.common.widget.d r3 = r0.k;
        Objects.requireNonNull(r3);
        r11.post(new dg5.t(r3));
        r0.v = true;
        r0.h.getLayoutManager().scrollToPositionWithOffset(0, 0);
        r0.m.h(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(FragmentActivity r2, Fragment r3, ViewGroup r4, l15.l r5, MessageConfig r6, vf5.b r7) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r4, "parentView");
        Intrinsics.checkNotNullParameter(r5, "feedListener");
        Intrinsics.checkNotNullParameter(r6, "messageConfig");
        Intrinsics.checkNotNullParameter(r7, "model");
        this.c = r6;
        LifecycleOwner r8 = r3;
        if (r3 != null) goto L5;
        r8 = r2;
    L5:
        m r0 = new m(r5, r6, r8, r7);
        this.a = new i0(r2, r8, r4, r0);
        this.b = r0;
    }
}
