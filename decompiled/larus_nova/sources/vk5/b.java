package vk5;

import com.bytedance.ee.bear.document.onboarding.OnBoardingPlugin;
import sk5.d;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tk5.d<? extends c> f555508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tk5.b f555509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tk5.c f555510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d.a f555511d;

    public final void a() {
        tk5.b r100 = this.f555509b;
        if (r100 == null) goto L5;
        tk5.d<? extends c> r101 = this.f555508a;
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r100).f220699a, r101.getId(), "skipped");
    L5:
        tk5.c r102 = this.f555510c;
        if (r102 == null) goto L9;
        r102.c(this.f555508a);
        return;
    }

    public final void b() {
        tk5.b r100 = this.f555509b;
        if (r100 == null) goto L5;
        tk5.d<? extends c> r101 = this.f555508a;
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r100).f220699a, r101.getId(), "success");
    L5:
        tk5.c r102 = this.f555510c;
        if (r102 == null) goto L9;
        r102.a(this.f555508a);
        return;
    }

    public final void c(boolean r100) {
        tk5.c r101 = this.f555510c;
        if (r101 == null) goto L5;
        r101.b(this.f555508a);
    L5:
        if (r100 == true) goto L9;
        tk5.b r102 = this.f555509b;
        if (r102 == null) goto L9;
        tk5.d<? extends c> r103 = this.f555508a;
        OnBoardingPlugin.access$300(((OnBoardingPlugin.a) r102).f220699a, r103.getId(), "fail");
    L9:
        d.a r104 = this.f555511d;
        if (r104 == null) goto L13;
        r104.a(this.f555508a, r100);
        return;
    }

    public b(tk5.d<? extends c> r100, tk5.b r101, tk5.c r102, d.a r103) {
        this.f555508a = r100;
        this.f555509b = r101;
        this.f555510c = r102;
        this.f555511d = r103;
    }
}
