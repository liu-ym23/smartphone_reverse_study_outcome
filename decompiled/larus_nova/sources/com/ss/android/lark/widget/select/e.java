package com.ss.android.lark.widget.select;

import android.view.View;
import android.widget.ScrollView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f448420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScrollView f448421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f448422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f448423d;

    public final void a() {
        if (this.f448420a.element == true) goto L6;
        return;
    L6:
        if (this.f448421b.canScrollVertically(this.f448422c) == false) goto L48;
        this.f448423d.f448403c.invoke();
        ScrollView r100 = this.f448421b;
        c r101 = this.f448423d;
        int r102 = this.f448422c;
        s r103 = r101.f448402b.invoke();
        boolean r104 = true;
        if (r102 != 1) goto L10;
        float r105 = r101.f448407g;
        float r106 = r103.f448515b - r101.f448412l;
    L11:
        float r107 = RangesKt.coerceIn((r105 - r106) / r101.f448412l, 0.0f, 1.0f);
        int r108 = r101.f448415o;
        r100.scrollBy(0, MathKt.roundToInt(r108 + ((r101.f448416p - r108) * r107)) * this.f448422c);
        c r109 = this.f448423d;
        int r110 = r109.f448408h;
        View r111 = r109.f448404d;
        if (r111 == null) goto L46;
        r.a r112 = r109.f448405e;
        if (r112 == null) goto L46;
        if (r110 == 0) goto L46;
        s r113 = r109.f448402b.invoke();
        if (r110 != 1) goto L22;
        float r114 = r113.f448515b - r109.f448413m;
    L23:
        float r115 = r109.f448406f;
        m r116 = ((k) r112).f448436a;
        m.b r117 = r116.f448453p;
        if (r117 == null) goto L32;
        int r118 = m.b.f448461q;
        r117.c(r115, r114, r110);
        m.b r119 = r116.f448444g;
        if (r119 == null) goto L29;
        r119.d();
    L29:
        m.b r120 = r116.f448445h;
        if (r120 == null) goto L32;
        r120.d();
    L32:
        r111.getLocationOnScreen(r109.f448411k);
        float r121 = r109.f448411k[1];
        float r122 = r111.getHeight() + r121;
        if (r110 != 1) goto L38;
        if (r122 <= (r113.f448515b - r109.f448414n)) goto L41;
    L40:
        r104 = false;
    L41:
        if (r104 == false) goto L43;
    L44:
        r109.stop();
        goto L46
    L43:
        if (r109.f448401a.canScrollVertically(r110) == true) goto L46;
    L38:
        if (r121 < (r113.f448514a + r109.f448414n)) goto L40;
    L22:
        r114 = r113.f448514a + r109.f448413m;
    L46:
        if (this.f448420a.element == false) goto L50;
        this.f448421b.postOnAnimation(this);
        return;
    L50:
        return;
    L10:
        r105 = r103.f448514a + r101.f448412l;
        r106 = r101.f448407g;
        goto L11
    L48:
        this.f448423d.stop();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(Ref.BooleanRef r100, ScrollView r101, int r102, c r103) {
        this.f448420a = r100;
        this.f448421b = r101;
        this.f448422c = r102;
        this.f448423d = r103;
    }
}
