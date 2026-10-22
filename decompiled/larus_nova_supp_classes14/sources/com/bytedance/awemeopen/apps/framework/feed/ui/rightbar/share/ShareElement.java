package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.card.video.j;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShareElement extends BaseElement<d, f, tz3.a, jz3.a> {
    public final Activity g;
    public final o h;
    public r14.c i;
    public jz3.a j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.i = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new d();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new f();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new c(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        d r0 = g();
        Observer<Unit> r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.e;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r7) {
        jz3.a r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "data");
        this.i = r8.a;
        o r0 = this.h;
        boolean r2 = true;
        if ((r0 instanceof j) == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        d14.a r3 = b14.a.a;
        if (b14.a.a(i34.a.class).l() == true) goto L14;
        if (r1 == true) goto L14;
        j();
    L55:
        this.j = r8;
        return;
    L14:
        r14.c r4 = r8.a;
        x14.a r5 = r4.J();
        String r6 = null;
        if (r5 == null) goto L17;
        String r9 = r5.d();
    L18:
        x14.a r10 = r4.J();
        if (r10 == null) goto L21;
        String r11 = r10.a();
    L22:
        x14.a r12 = r4.J();
        if (r12 == null) goto L25;
        r6 = r12.c();
    L25:
        if (r9 != null) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r13 == true) goto L47;
        if (r11 != null) goto L34;
    L37:
        boolean r14 = true;
    L38:
        if (r14 == true) goto L47;
        if (r6 != null) goto L41;
    L44:
        boolean r15 = true;
    L45:
        if (r15 == true) goto L47;
    L48:
        if (r2 == false) goto L54;
        p();
        f r16 = h();
        r14.j r17 = r8.a.L();
        if (r17 == null) goto L52;
        long r18 = r17.e();
    L53:
        r16.a.b(Long.valueOf(r18));
        goto L55
    L52:
        r18 = 0;
        goto L53
    L54:
        j();
        goto L55
    L41:
        if (r6.length() == 0) goto L44;
        r15 = false;
        goto L45
    L34:
        if (r11.length() == 0) goto L37;
        r14 = false;
    L47:
        r2 = false;
        goto L48
    L27:
        if (r9.length() == 0) goto L30;
        r13 = false;
        goto L31
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L5:
        if (r0.getPageConfig().isCardMode() == false) goto L9;
        if (this.h.forceEnableShareInCardMode() == false) goto L9;
        r1 = true;
        goto L10
    }

    public ShareElement(Activity r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
    }
}
