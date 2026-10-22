package v43;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.CheckOrderTriggerOrigin;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.CheckStatus;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p43.a f553053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckStatus f553054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f553055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f553056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w33.f<w33.a<CheckOrderTriggerOrigin>> f553057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w33.f<w33.a<p43.b>> f553058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f553059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w33.f<p43.c> f553060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f553061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f553062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k33.a f553063k;

    public e() {
        this.f553054b = CheckStatus.INIT;
        this.f553057e = new w33.f(new w33.a(null));
        this.f553058f = new w33.f(new w33.a(null));
        this.f553059g = true;
        this.f553060h = new w33.f(p43.c.f.f527661a);
    }

    @Override // v43.l
    public final boolean C() {
        return this.f553056d;
    }

    @Override // v43.l
    public final boolean E() {
        return this.f553059g;
    }

    @Override // v43.l
    public final Map<String, Object> H() {
        return this.f553055c;
    }

    @Override // v43.l
    public final p43.a N() {
        return this.f553053a;
    }

    @Override // v43.l
    public final k33.a P() {
        return this.f553063k;
    }

    @Override // v43.l
    public final boolean f() {
        return this.f553061i;
    }

    @Override // v43.l
    public final w33.f<p43.c> o() {
        return this.f553060h;
    }

    @Override // v43.l
    public final String r() {
        return this.f553062j;
    }

    @Override // v43.l
    public final w33.f<w33.a<p43.b>> w() {
        return this.f553058f;
    }

    @Override // v43.l
    public final CheckStatus y() {
        return this.f553054b;
    }

    @Override // v43.l
    public final w33.f<w33.a<CheckOrderTriggerOrigin>> z() {
        return this.f553057e;
    }

    @Override // v43.l
    public final void G(k33.a r100) {
        this.f553063k = r100;
    }

    @Override // v43.l
    public final void J(p43.a r100) {
        this.f553053a = r100;
    }

    @Override // v43.l
    public final void Q(CheckStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f553054b = r100;
    }

    @Override // v43.l
    public final void R(boolean r100) {
        this.f553061i = r100;
    }

    @Override // v43.l
    public final void j(Map<String, ? extends Object> r100) {
        this.f553055c = r100;
    }

    @Override // v43.l
    public final void m(boolean r100) {
        this.f553059g = r100;
    }

    @Override // v43.l
    public final void q(String r100) {
        this.f553062j = r100;
    }

    @Override // v43.l
    public final void s(boolean r100) {
        this.f553056d = r100;
    }
}
