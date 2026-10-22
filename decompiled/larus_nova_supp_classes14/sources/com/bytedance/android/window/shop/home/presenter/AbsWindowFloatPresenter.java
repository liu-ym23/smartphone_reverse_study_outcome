package com.bytedance.android.window.shop.home.presenter;

import android.animation.Animator;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AbsWindowFloatPresenter extends QPresenter {
    public Fragment e;
    public final Lazy f;
    public final Lazy g;
    public Boolean h;
    public Animator i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AbsWindowFloatPresenter a;

        public a(AbsWindowFloatPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ((h2) this.a.g.getValue()).onClick();
        }
    }

    public abstract boolean D();

    public abstract h2 E();

    public abstract i2 F();

    public final i2 G() {
        return (i2) this.f.getValue();
    }

    public void K(int r1) {
    }

    public final LifecycleOwner I() {
        Fragment r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public final void N() {
        if (Intrinsics.areEqual(this.h, Boolean.TRUE) == true) goto L5;
    L40:
        int r1 = 4;
    L42:
        if (y().getVisibility() == r1) goto L59;
        y().setVisibility(r1);
        if (r1 != 0) goto L56;
        View r0 = y();
        Integer r2 = (Integer) G().a().getValue();
        if (r2 == null) goto L51;
        if (r2.intValue() != 0) goto L51;
    L54:
        float r3 = 1.0f;
    L55:
        r0.setAlpha(r3);
        ((h2) this.g.getValue()).a();
    L57:
        K(y().getVisibility());
        return;
    L51:
        if (G().a().getValue() == null) goto L54;
        r3 = 0.5f;
        goto L55
    L56:
        ((h2) this.g.getValue()).onHidden();
        goto L57
    L59:
        return;
    L5:
        if (D() == false) goto L40;
        r1 = 0;
        if (G().f().getValue() == null) goto L37;
        Object r4 = G().f().getValue();
        if ((r4 instanceof Pair) == false) goto L24;
        Pair r5 = (Pair) r4;
        if ((r5.getFirst() instanceof Integer) == false) goto L24;
        if ((r5.getSecond() instanceof Integer) == false) goto L24;
        Object r6 = r5.getFirst();
        if (r6 == null) goto L22;
        float r7 = Math.abs(((Integer) r6).intValue()) + G().d();
        Object r8 = r5.getSecond();
        if (r8 == null) goto L20;
        float r9 = r7 / Math.abs(((Integer) r8).intValue());
    L34:
        if (r9 > 0.95f) goto L37;
        boolean r10 = false;
    L38:
        if (r10 == false) goto L40;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L24:
        if ((r4 instanceof Triple) == false) goto L32;
        Triple r11 = (Triple) r4;
        if ((r11.getThird() instanceof Float) == false) goto L32;
        Object r12 = r11.getThird();
        if (r12 == null) goto L31;
        r9 = ((Float) r12).floatValue();
        goto L34
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L32:
        r9 = 0.0f;
    L37:
        r10 = true;
        goto L38
    }

    public AbsWindowFloatPresenter() {
        this.f = LazyKt.lazy(new AbsWindowFloatPresenter$viewModelAdapter$2(this));
        this.g = LazyKt.lazy(new AbsWindowFloatPresenter$behavior$2(this));
    }

    public void A(QModel r4) {
        this.h = Boolean.TRUE;
        y().setOnClickListener(new a(this));
        G().f().a(I(), new com.bytedance.android.window.shop.home.presenter.a(this), false);
        zn.b r5 = G().b();
        if (r5 == null) goto L5;
        r5.a(I(), new b(this), false);
    L5:
        G().a().a(I(), new d(this), false);
    }
}
