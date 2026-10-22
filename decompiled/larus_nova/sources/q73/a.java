package q73;

import com.bytedance.android.shopping.monitor.d;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f531956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531957b;

    public final void a() {
        if (this.f531956a == false) goto L6;
        d r100 = d.f(this.f531957b);
        int r101 = com.bytedance.android.shopping.anchorv4.experiment.a.f166753a;
        r100.i("tech_version", "anchor_v4");
        r100.a("duration");
        r100.a("guessulike_api_duration");
        return;
    }

    public a() {
        this.f531956a = true;
        this.f531957b = d.c("ec_product_detail_guessulike_duration");
    }
}
