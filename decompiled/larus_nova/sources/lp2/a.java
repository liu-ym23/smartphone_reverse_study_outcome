package lp2;

import com.bytedance.android.livesdk.commonpop.i;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements com.bytedance.android.live.base.model.push.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.push.b f510204a;

    @Override // com.bytedance.android.live.base.model.push.a
    public final void a() {
        int r100 = b.f510205a;
        b.a(this.f510204a, "click");
    }

    @Override // com.bytedance.android.live.base.model.push.a
    public final void c() {
        int r100 = b.f510205a;
        b.a(this.f510204a, "show");
    }

    @Override // com.bytedance.android.live.base.model.push.a
    public final void b() {
        xs2.b.a().post(new i(this.f510204a));
    }

    public a(com.bytedance.android.live.base.model.push.b r100) {
        this.f510204a = r100;
    }
}
