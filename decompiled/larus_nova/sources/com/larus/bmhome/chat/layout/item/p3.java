package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p3 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<View, Drawable> f304556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f304557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l3 f304558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f304559d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Map<View, Drawable> r101 = this.f304556a;
        l3 r102 = this.f304558c;
        Iterator<Map.Entry<View, Drawable>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Drawable r104 = r103.next().getValue();
        r102.f304467a.getOverlay().remove(r104);
        goto L4
    L6:
        int r105 = this.f304557b;
        l3 r106 = this.f304558c;
        if (r105 == r106.f304481o) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r106.f304474h, r100) == false) goto L14;
        l3 r107 = this.f304558c;
        r107.f304474h = null;
        r107.f(Integer.valueOf(this.f304559d));
        return;
    }

    public p3(Map<View, Drawable> r100, int r101, l3 r102, int r103) {
        this.f304556a = r100;
        this.f304557b = r101;
        this.f304558c = r102;
        this.f304559d = r103;
    }
}
