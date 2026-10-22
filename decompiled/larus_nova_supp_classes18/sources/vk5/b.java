package vk5;

import com.bytedance.ee.bear.document.onboarding.OnBoardingPlugin;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import sk5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements d.b {
    public final tk5.d<? extends c> a;
    public final tk5.b b;
    public final tk5.c c;
    public final d.a d;

    public final void a() {
        OnBoardingPlugin.a r0 = this.b;
        if (r0 == null) goto L5;
        tk5.d<? extends c> r1 = this.a;
        OnBoardingPlugin.access$300(r0.a, r1.getId(), "skipped");
    L5:
        tk5.c r2 = this.c;
        if (r2 == null) goto L9;
        r2.c(this.a);
        return;
    }

    public final void b() {
        OnBoardingPlugin.a r0 = this.b;
        if (r0 == null) goto L5;
        tk5.d<? extends c> r1 = this.a;
        OnBoardingPlugin.access$300(r0.a, r1.getId(), "success");
    L5:
        tk5.c r2 = this.c;
        if (r2 == null) goto L9;
        r2.a(this.a);
        return;
    }

    public final void c(boolean r4) {
        tk5.c r0 = this.c;
        if (r0 == null) goto L5;
        r0.b(this.a);
    L5:
        if (r4 == true) goto L9;
        OnBoardingPlugin.a r1 = this.b;
        if (r1 == null) goto L9;
        tk5.d<? extends c> r2 = this.a;
        OnBoardingPlugin.access$300(r1.a, r2.getId(), DocFeed$Value$Result.FAIL);
    L9:
        d.a r3 = this.d;
        if (r3 == null) goto L13;
        r3.a(this.a, r4);
        return;
    }

    public b(tk5.d<? extends c> r1, tk5.b r2, tk5.c r3, d.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
