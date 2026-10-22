package b04;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends BaseElement<i, j, tz3.a, jz3.a> {
    public final Activity g;
    public final o h;
    public a i;
    public String j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new h(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        a r0 = this.i;
        if (r0 == null) goto L5;
        this.h.removePlayStateListener(r0);
    L5:
        this.i = null;
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
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.f;
    }

    public final Activity getActivity() {
        return this.g;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.j = r4.a.c();
        if (this.h.getPageConfig().isTeenagerModel() == false) goto L5;
    L12:
        j();
        return;
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.e == true) goto L12;
        if (Intrinsics.areEqual(this.h.getPageConfig().getEnterFrom(), "volc_agent_card") == true) goto L12;
        e24.b r5 = r4.a.z();
        p();
        h().c.b(r5);
        if (this.i != null) goto L14;
        a r6 = new a(this);
        this.h.addPlayStateListener(r6);
        this.i = r6;
        return;
    }

    public b(Activity r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
    }
}
