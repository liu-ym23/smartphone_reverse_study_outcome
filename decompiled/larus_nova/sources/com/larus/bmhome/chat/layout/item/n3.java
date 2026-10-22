package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n3 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l3 f304539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<View, Drawable> f304540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<Pair<View, Rect>> f304541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<Pair<View, Integer>> f304542d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (Intrinsics.areEqual(this.f304539a.f304473g, r100) == false) goto L5;
        this.f304539a.f304473g = null;
    L5:
        Iterator<Map.Entry<View, Drawable>> r101 = this.f304540b.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<View, Drawable> r102 = r101.next();
        View r103 = r102.getKey();
        Drawable r104 = r102.getValue();
        r103.getOverlay().remove(r104);
        goto L7
    L9:
        Iterator<T> r105 = this.f304541c.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        Pair r106 = (Pair) r105.next();
        ((View) r106.component1()).setClipBounds((Rect) r106.component2());
        goto L11
    L13:
        Iterator<T> r107 = this.f304542d.iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        ((View) ((Pair) r107.next()).component1()).setAlpha(1.0f);
        goto L15
    L17:
        l3 r108 = this.f304539a;
        r108.f(r108.f304475i);
        int r109 = this.f304539a.f304481o;
    }

    public n3(l3 r100, Map<View, Drawable> r101, List<Pair<View, Rect>> r102, List<Pair<View, Integer>> r103, int r104) {
        this.f304539a = r100;
        this.f304540b = r101;
        this.f304541c = r102;
        this.f304542d = r103;
    }
}
