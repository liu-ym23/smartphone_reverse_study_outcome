package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ECShopAbsFloatPresenter extends QPresenter {
    public final Fragment e;
    public final Lazy f;
    public final Lazy g;
    public Boolean h;
    public Animator i;
    public final Lazy j;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopAbsFloatPresenter a;

        public a(ECShopAbsFloatPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Float r3 = (Float) r2;
            if ((!Intrinsics.areEqual(this.a.h, Boolean.TRUE)) == true) goto L7;
            this.a.Q();
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopAbsFloatPresenter a;

        public b(ECShopAbsFloatPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            if ((!Intrinsics.areEqual(this.a.h, Boolean.TRUE)) == true) goto L7;
            this.a.Q();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopAbsFloatPresenter a;

        public c(ECShopAbsFloatPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Integer r7 = (Integer) r6;
            if ((!Intrinsics.areEqual(this.a.h, Boolean.TRUE)) == false) goto L5;
            return;
        L5:
            if (this.a.y().getVisibility() != 0) goto L20;
            Animator r0 = this.a.i;
            if (r0 == null) goto L10;
            r0.cancel();
        L10:
            ECShopAbsFloatPresenter r1 = this.a;
            float[] r2 = new float[2];
            r2[0] = r1.y().getAlpha();
            if (r7 != null) goto L14;
        L16:
            float r8 = 0.5f;
        L17:
            r2[1] = r8;
            ValueAnimator r9 = ValueAnimator.ofFloat(r2);
            r9.setDuration(300);
            r9.addUpdateListener(new com.bytedance.android.shopping.store.home.presenter.c(this));
            r9.start();
            Unit r3 = Unit.INSTANCE;
            r1.i = r9;
            return;
        L14:
            if (r7.intValue() != 0) goto L16;
            r8 = 1.0f;
            goto L17
        }
    }

    public abstract boolean D();

    public abstract z3 E();

    public abstract a4 F();

    public final a4 G() {
        return (a4) this.f.getValue();
    }

    public void O(int r1) {
    }

    public final LifecycleOwner I() {
        Fragment r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public final ECStoreViewModel N() {
        Fragment r0 = this.e;
        if (r0 == null) goto L7;
        u().getClass();
        return QContext.h(ECStoreViewModel.class, r0);
    L7:
        return ECQuickUtilKt.c(u(), ECStoreViewModel.class);
    }

    public final void Q() {
        if (Intrinsics.areEqual(this.h, Boolean.TRUE) == true) goto L5;
    L22:
        int r2 = 4;
    L24:
        if (y().getVisibility() == r2) goto L41;
        y().setVisibility(r2);
        if (r2 != 0) goto L38;
        View r0 = y();
        Integer r1 = (Integer) G().a().getValue();
        if (r1 == null) goto L33;
        if (r1.intValue() != 0) goto L33;
    L36:
        float r3 = 1.0f;
    L37:
        r0.setAlpha(r3);
        ((z3) this.g.getValue()).a();
    L39:
        O(y().getVisibility());
        return;
    L33:
        if (G().a().getValue() == null) goto L36;
        r3 = 0.5f;
        goto L37
    L38:
        ((z3) this.g.getValue()).onHidden();
        goto L39
    L41:
        return;
    L5:
        if (D() == false) goto L22;
        jm.a<Float> r4 = G().c();
        Float r5 = null;
        if (r4 == null) goto L9;
        Float r6 = (Float) r4.getValue();
    L10:
        r2 = 0;
        if (r6 == null) goto L19;
        jm.a<Float> r7 = G().c();
        if (r7 == null) goto L16;
        r5 = (Float) r7.getValue();
    L16:
        if (com.bytedance.android.shopping.extensions.k.d(r5) > 0.95f) goto L19;
        boolean r8 = false;
    L20:
        if (r8 == false) goto L22;
    L19:
        r8 = true;
        goto L20
    L9:
        r6 = null;
        goto L10
    }

    public ECShopAbsFloatPresenter() {
        this.f = LazyKt.lazy(new ECShopAbsFloatPresenter$viewModelAdapter$2(this));
        this.g = LazyKt.lazy(new ECShopAbsFloatPresenter$behavior$2(this));
        this.j = LazyKt.lazy(new ECShopAbsFloatPresenter$topTipsH$2(this));
    }

    public final void K() {
        jm.a<Float> r0 = G().c();
        if (r0 == null) goto L5;
        r0.a(I(), new a(this), false);
    L5:
        jm.a<Pair<Integer, Integer>> r1 = G().b();
        if (r1 == null) goto L8;
        r1.a(I(), new b(this), false);
    L8:
        G().a().a(I(), new c(this), false);
    }

    public ECShopAbsFloatPresenter(Fragment r1) {
        this();
        this.e = r1;
    }
}
