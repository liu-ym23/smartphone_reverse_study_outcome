package com.bytedance.awemeopen.apps.framework.feed.ui.information.createtime;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFollowFeedViewModel;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends BaseElement<b, c, tz3.a, jz3.a> {
    public final o g;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new c();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new e(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.l;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r7) {
        jz3.a r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "data");
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.e == true) goto L5;
    L7:
        j();
        return;
    L5:
        if ((this.g instanceof AosFollowFeedViewModel) == false) goto L7;
        c r0 = h();
        String r9 = k0.b(y54.a.a(), r8.a.o() * 1000);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "createTime");
        r0.a.b(r9);
        p();
    }

    public a(Context r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r3;
    }
}
