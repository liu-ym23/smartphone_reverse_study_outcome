package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f195735a;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a
    public final void a() {
        this.f195735a.f195739a.a();
        u.a(this.f195735a);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a
    public final void b() {
        this.f195735a.f195739a.b();
        u r100 = this.f195735a;
        if (r100.f195759u == false) goto L7;
        View r101 = r100.f195741c;
        if (r101 == null) goto L7;
        r100.c(r101);
    L7:
        u r102 = this.f195735a;
        r102.f195761w = r102.f195753o;
        View r103 = r102.f195741c;
        float r104 = 0.0f;
        if (r103 == null) goto L10;
        float r105 = r103.getPivotX();
    L11:
        r102.f195762x = r105;
        u r106 = this.f195735a;
        View r107 = r106.f195741c;
        if (r107 == null) goto L14;
        r104 = r107.getPivotY();
    L14:
        r106.f195763y = r104;
        return;
    L10:
        r105 = 0.0f;
        goto L11
    }

    public r(u r100) {
        this.f195735a = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a
    public final boolean c(com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b r110) {
        u r100 = this.f195735a;
        if (r100.f195741c == null) goto L44;
        float r101 = r100.f195754p;
        int r102 = 0;
        if (r110.a() == false) goto L21;
        boolean r103 = r110.f195832p;
        if (r103 == true) goto L9;
    L10:
        if (r103 == false) goto L12;
    L14:
        boolean r104 = false;
    L15:
        float r105 = Math.abs(1.0f - (r110.f195822f / r110.f195823g)) * 0.5f;
        if (r110.f195823g <= 0.0f) goto L24;
        if (r104 == false) goto L20;
        float r106 = r105 + 1.0f;
    L25:
        float r107 = r101 * r106;
        r100.f195754p = r107;
        if (r107 >= 0.5f) goto L28;
        r107 = (((r107 * r107) * 0.5f) + (r107 * 0.15f)) + 0.3f;
    L28:
        r100.f195753o = r107;
        float r108 = Math.min(r107, 999.0f);
        r100.f195753o = r108;
        float r109 = Math.max(r108, 0.3f);
        r100.f195753o = r109;
        r100.f195755q = Math.max(r100.f195755q, r109);
        r100.f195756r = Math.min(r100.f195756r, r100.f195753o);
        float r111 = r110.f195818b;
        float r112 = r110.f195819c;
        View r113 = r100.f195741c;
        if (r113 == null) goto L43;
        r113.setScaleX(r100.f195753o);
        r113.setScaleY(r100.f195753o);
        if (r100.f195759u == true) goto L33;
    L35:
        r113.setPivotX(((r111 - r113.getTranslationX()) + r100.f195746h) - r113.getLeft());
        float r114 = ((r112 - r113.getTranslationY()) + r100.f195747i) - r113.getTop();
        Function0<Integer> r115 = r100.f195760v;
        if (r115 == null) goto L38;
        Integer r116 = r115.invoke();
    L39:
        if (r116 == null) goto L42;
        r102 = r116.intValue();
    L42:
        r113.setPivotY(r114 + r102);
        goto L43
    L38:
        r116 = null;
        goto L39
    L33:
        if (r100.f195753o <= 1.0f) goto L35;
        float r117 = 1;
        r113.setPivotX(((((((((r100.f195762x * (r100.f195761w - r117)) + r111) - r113.getTranslationX()) - r113.getLeft()) * (r100.f195753o / r100.f195761w)) - r111) + r113.getTranslationX()) + r113.getLeft()) / (r100.f195753o - r117));
        r113.setPivotY(((((((((r100.f195763y * (r100.f195761w - r117)) + r112) - r113.getTranslationY()) - r113.getTop()) * (r100.f195753o / r100.f195761w)) - r112) + r113.getTranslationY()) + r113.getTop()) / (r100.f195753o - r117));
        r100.f195761w = r100.f195753o;
        r100.f195762x = r113.getPivotX();
        r100.f195763y = r113.getPivotY();
    L43:
        r100.f195739a.m();
        goto L44
    L20:
        r106 = 1.0f - r105;
    L24:
        r106 = 1.0f;
        goto L25
    L12:
        if (r110.f195822f <= r110.f195823g) goto L14;
    L13:
        r104 = true;
        goto L15
    L9:
        if (r110.f195822f < r110.f195823g) goto L13;
    L21:
        float r118 = r110.f195823g;
        if (r118 <= 0.0f) goto L24;
        r106 = r110.f195822f / r118;
    L44:
        return true;
    }
}
