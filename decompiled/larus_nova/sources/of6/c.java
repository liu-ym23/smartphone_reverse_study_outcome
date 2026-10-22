package of6;

import com.bytedance.live.artist.render.e;

/* JADX INFO: loaded from: classes45.dex */
public class c<T> extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f523105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f523106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b<T> f523107e;

    @Override // com.bytedance.live.artist.render.e
    public void d() {
        a r100 = this.f523105c;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.bytedance.live.artist.render.e
    public void e() {
        T r100 = this.f523106d;
        if (r100 == null) goto L13;
        this.f523107e.b(r100, c());
        a r101 = this.f523105c;
        if (r101 == null) goto L7;
        r101.d();
    L7:
        com.bytedance.live.zdanmaku.render.canvas.a r102 = this.f523107e.a();
        if (r102 == null) goto L10;
        r102.f254850a = c();
        r102.e();
    L11:
        this.f523105c = r102;
        return;
    L10:
        r102 = null;
        goto L11
    }

    @Override // com.bytedance.live.artist.render.e
    public void f() {
        a r100 = this.f523105c;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        if (r100 == null) goto L11;
        r100.f();
        return;
    L11:
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object r100, tk6.e r101) {
        this.f523106d = r100;
        this.f523107e = r101;
    }
}
