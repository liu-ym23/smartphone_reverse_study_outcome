package com.bytedance.awemeopen.apps.framework.feed.ui.information.music.title;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.x;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends BaseElement<g, h, tz3.a, jz3.a> {
    public final o g;
    public a h;
    public String i;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new h();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new f(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        a r0 = this.h;
        if (r0 == null) goto L5;
        this.g.removePlayStateListener(r0);
    L5:
        this.h = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        h().a.b(Boolean.TRUE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        h().a.b(Boolean.FALSE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.k;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r11) {
        jz3.a r12 = r11;
        Intrinsics.checkNotNullParameter(r12, "data");
        this.i = r12.a.c();
        int r0 = x.a;
        Context r1 = getContext();
        e24.b r2 = r12.a.z();
        User r3 = r12.a.f();
        r14.c r13 = r12.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r13, "aweme");
        boolean r4 = true;
        String r5 = "";
        if (r2 != null) goto L5;
        Resources r14 = r1.getResources();
        Object[] r6 = new Object[2];
        r6[0] = r1.getResources().getString(2131894236);
        if (r3 != null) goto L39;
        String r7 = "";
    L40:
        r6[1] = r7;
        String r15 = r14.getString(2131894237, r6);
    L41:
        if (r15 == null) goto L45;
        r5 = r15;
    L45:
        if (r5.length() == 0) goto L48;
        r4 = false;
    L48:
        if (r4 == false) goto L50;
    L63:
        j();
        return;
    L50:
        if (this.g.getPageConfig().isTeenagerModel() == true) goto L63;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.e == false) goto L56;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.g == false) goto L63;
    L56:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.h == true) goto L63;
        if (Intrinsics.areEqual(this.g.getPageConfig().getEnterFrom(), "volc_agent_card") == true) goto L63;
        p();
        h r16 = h();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r5, "title");
        r16.c.b(r5);
        if (this.h != null) goto L65;
        a r17 = new a(this);
        this.g.addPlayStateListener(r17);
        this.h = r17;
        return;
    L65:
        return;
    L39:
        r7 = r3.t();
        goto L40
    L5:
        if (TextUtils.isEmpty(r13.A()) == true) goto L9;
        r15 = r13.A();
        if (r15 != null) goto L41;
        r15 = "";
        goto L41
    L9:
        t14.a r8 = r2.g();
        String r9 = null;
        if (r8 == null) goto L12;
        List r10 = r8.g();
    L14:
        if (r13.S() == false) goto L16;
    L35:
        r15 = r1.getResources().getString(2131894238, new Object[]{r2.d(), r2.a()});
        goto L41
    L16:
        if (r2.c() == null) goto L35;
        e24.a r18 = r2.c();
        if (r18 == null) goto L20;
        String r19 = r18.a();
    L22:
        if (TextUtils.isEmpty(r19) == true) goto L35;
        if (r2.e() == 0) goto L35;
        if (r10 == null) goto L35;
        if (r10.size() <= 0) goto L35;
        if (r3 == null) goto L35;
        if (r3.P() == true) goto L35;
        StringBuilder r110 = new StringBuilder();
        r110.append(r1.getResources().getString(2131894238, new Object[]{r2.d(), r2.a()}));
        r110.append(65288);
        r110.append(r1.getResources().getString(2131894279));
        r110.append(65306);
        e24.a r20 = r2.c();
        if (r20 == null) goto L34;
        r9 = r20.a();
    L34:
        r110.append(r9);
        r110.append(65289);
        r15 = r110.toString();
        goto L41
    L20:
        r19 = null;
        goto L22
    L12:
        r10 = null;
        goto L14
    }

    public b(Context r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r3;
    }
}
