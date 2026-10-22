package eo4;

import com.bytedance.ee.bear.bitable.anniex.env.BitableLynxUrlUtil;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements zm4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.anniex.env.a f473314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableLynxUrlUtil f473315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.anniex.env.b f473316c;

    public b() {
        this.f473314a = new com.bytedance.ee.bear.bitable.anniex.env.a();
        this.f473315b = new BitableLynxUrlUtil(0);
        this.f473316c = new com.bytedance.ee.bear.bitable.anniex.env.b();
    }

    @Override // zm4.b
    public final com.bytedance.ee.bear.bitable.anniex.env.a a() {
        return this.f473314a;
    }

    @Override // zm4.b
    public final BitableLynxUrlUtil b() {
        return this.f473315b;
    }

    @Override // zm4.b
    public final com.bytedance.ee.bear.bitable.anniex.env.b getGeckoConfig() {
        return this.f473316c;
    }
}
