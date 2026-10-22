package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f402408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f402409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.obric.oui.animation.easy.b<? extends View>> f402410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f402411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f402412e;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationCancel(r100);
        this.f402409b.setLayerType(0, null);
        com.obric.oui.animation.easy.b r101 = this.f402410c.element;
        if (r101 == null) goto L26;
        ((ArrayList) r101.f398739b).clear();
        List r102 = CollectionsKt.toList(((LinkedHashMap) r101.f398740c).values());
        ((LinkedHashMap) r101.f398740c).clear();
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        jla.d r104 = (jla.d) r103.next();
        r104.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L14;
        if (r104.f499583f == false) goto L7;
        r104.a(true);
        goto L7
    L14:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    L15:
        com.obric.oui.animation.easy.b.a<T> r105 = r101.f398743f;
        if (r105 == 0) goto L27;
        r105.a((com.obric.oui.animation.easy.b<T>) r101);
        return;
    L27:
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        this.f402409b.setLayerType(0, null);
        if (this.f402408a == true) goto L5;
        this.f402409b.setVisibility(8);
    L5:
        Function0<Unit> r101 = this.f402412e;
        if (r101 == null) goto L10;
        r101.invoke();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        if (this.f402408a == false) goto L5;
        this.f402409b.setLayerType(2, null);
    L5:
        com.obric.oui.animation.easy.b<? extends View> r101 = this.f402410c.element;
        if (r101 == null) goto L10;
        r101.e();
    L10:
        if (this.f402408a == false) goto L17;
        Function0<Unit> r102 = this.f402411d;
        if (r102 == null) goto L15;
        r102.invoke();
    L15:
        this.f402409b.setVisibility(0);
        return;
    }

    public g(boolean r100, ViewGroup r101, Ref.ObjectRef<com.obric.oui.animation.easy.b<? extends View>> r102, Function0<Unit> r103, Function0<Unit> r104) {
        this.f402408a = r100;
        this.f402409b = r101;
        this.f402410c = r102;
        this.f402411d = r103;
        this.f402412e = r104;
    }
}
