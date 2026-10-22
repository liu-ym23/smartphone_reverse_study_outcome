package com.lynx.tasm.animation.keyframe;

import android.text.TextUtils;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<LynxUI> f381824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s6a.a[] f381825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, LynxKeyframeAnimator> f381826c;

    public final void a() {
        this.f381824a = null;
        HashMap<String, LynxKeyframeAnimator> r100 = this.f381826c;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<LynxKeyframeAnimator> r101 = r100.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        LynxKeyframeAnimator r102 = r101.next();
        r102.e();
        r102.k();
        r102.f381794b = null;
        r102.f381795c = null;
        goto L7
    }

    public final void b() {
        HashMap<String, LynxKeyframeAnimator> r100 = this.f381826c;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<LynxKeyframeAnimator> r101 = r100.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().f();
        goto L7
    L9:
        this.f381826c = null;
        this.f381825b = null;
    }

    public final void c() {
        if (this.f381825b != null) goto L5;
        return;
    L5:
        if (this.f381824a.get().getHeight() == 0) goto L7;
    L9:
        HashMap<String, LynxKeyframeAnimator> r100 = new HashMap();
        s6a.a[] r101 = this.f381825b;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r104 >= r102) goto L25;
        s6a.a r105 = r101[r104];
        if (r105 == null) goto L24;
        if (TextUtils.isEmpty(r105.f540860a) == true) goto L24;
        HashMap<String, LynxKeyframeAnimator> r106 = this.f381826c;
        if (r106 == null) goto L19;
        LynxKeyframeAnimator r107 = r106.get(r105.f540860a);
    L20:
        if (r107 != null) goto L22;
        r107 = new LynxKeyframeAnimator(this.f381824a.get().getView(), this.f381824a.get());
    L23:
        r100.put(r105.f540860a, r107);
        goto L24
    L22:
        this.f381826c.remove(r105.f540860a);
        goto L23
    L19:
        r107 = null;
    L24:
        r104 = r104 + 1;
        goto L10
    L25:
        HashMap<String, LynxKeyframeAnimator> r108 = this.f381826c;
        if (r108 == null) goto L31;
        Iterator<LynxKeyframeAnimator> r109 = r108.values().iterator();
    L29:
        if (r109.hasNext() == false) goto L31;
        r109.next().f();
    L31:
        s6a.a[] r110 = this.f381825b;
        int r111 = r110.length;
    L32:
        if (r103 >= r111) goto L40;
        s6a.a r112 = r110[r103];
        if (r112 == null) goto L39;
        if (TextUtils.isEmpty(r112.f540860a) == true) goto L39;
        r100.get(r112.f540860a).a(r112);
    L39:
        r103 = r103 + 1;
        goto L32
    L40:
        this.f381826c = r100;
        return;
    L7:
        if (this.f381824a.get().getWidth() != 0) goto L9;
    }

    public a(LynxUI r100) {
        this.f381824a = new WeakReference(r100);
        this.f381826c = new HashMap();
    }

    public final void d(String r100, Object r101) {
        HashMap<String, LynxKeyframeAnimator> r102 = this.f381826c;
        if (r102 != null) goto L5;
        return;
    L5:
        Iterator<LynxKeyframeAnimator> r103 = r102.values().iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        LynxKeyframeAnimator r104 = r103.next();
        if (r104.f381796d.containsKey(r100) == false) goto L12;
        r104.f381796d.put(r100, r101);
    L12:
        if (r100.equals("BackgroundColor") == false) goto L7;
        if (r104.f381796d.containsKey("Color") == false) goto L7;
        r104.f381796d.put("Color", r101);
        goto L7
    }
}
