package com.bytedance.awemeopen.apps.framework.feed.ui.information.warning;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.bizmodels.feed.ModelRate;
import kotlin.jvm.internal.Intrinsics;
import r14.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends BaseElement<f, g, tz3.a, jz3.a> {
    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new f();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new d(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.m;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r6) {
        jz3.a r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        i r0 = r7.a.h();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L34;
        i r3 = r7.a.h();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L34;
        if (r7.a.G() != ModelRate.NotRecommended) goto L19;
    L20:
        i r5 = r7.a.h();
        String r8 = null;
        if (r5 == null) goto L23;
        String r9 = r5.a();
    L24:
        if (r9 != null) goto L26;
    L27:
        r1 = true;
    L28:
        if (r1 == false) goto L30;
        j();
        return;
    L30:
        p();
        g r10 = h();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r9, "warningText");
        r10.a.b(r9);
        g r11 = h();
        i r12 = r7.a.h();
        if (r12 == null) goto L33;
        r8 = r12.b();
    L33:
        r11.b.b(r8);
        return;
    L26:
        if (r9.length() != 0) goto L28;
    L23:
        r9 = null;
        goto L24
    L19:
        if (r7.a.G() == ModelRate.Fresh) goto L20;
        return;
    L12:
        if (r3.d() != true) goto L14;
        r4 = true;
    L34:
        j();
        return;
    L5:
        if (r0.c() == true) goto L7;
        r2 = true;
        goto L8
    }
}
