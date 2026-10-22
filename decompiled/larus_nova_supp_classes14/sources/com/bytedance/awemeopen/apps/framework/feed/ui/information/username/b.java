package com.bytedance.awemeopen.apps.framework.feed.ui.information.username;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFollowFeedViewModel;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.IconSettingUtils;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends BaseElement<g, i, tz3.a, jz3.a> {
    public final Activity g;
    public final o h;
    public final boolean i;
    public jz3.a j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new f(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        g r0 = g();
        Observer<Unit> r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.h;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r11) {
        jz3.a r12 = r11;
        Intrinsics.checkNotNullParameter(r12, "data");
        p();
        this.j = r12;
        h().a.b(Boolean.valueOf(this.h instanceof AosFollowFeedViewModel));
        if (IconSettingUtils.a() != (-1)) goto L17;
        if (this.i == false) goto L8;
    L18:
        boolean r0 = true;
    L20:
        i r1 = h();
        Context r5 = getContext();
        Object[] r2 = new Object[1];
        User r6 = r12.a.f();
        if (r6 == null) goto L24;
        String r7 = r6.t();
        if (r7 == null) goto L24;
    L25:
        r2[0] = r7;
        String r3 = r5.getString(2131894200, r2);
        String r4 = " · " + k0.b(y54.a.a(), r12.a.o() * 1000);
        d14.a r8 = b14.a.a;
        h r9 = new h(r3, r4, b14.a.a(x24.a.class).v3(r12.a), r0);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "userNameInfo");
        r1.b.b(r9);
        return;
    L24:
        r7 = "";
        goto L25
    L8:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.e == true) goto L18;
        if (this.h.getEnableFollowChannel() == true) goto L18;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.h == true) goto L18;
        if (this.h.getNeedDouyinFlag() == true) goto L18;
    L19:
        r0 = false;
        goto L20
    L17:
        if (IconSettingUtils.a() != 1) goto L19;
        goto L18
    }

    public b(Activity r2, o r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
