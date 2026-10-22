package com.bytedance.ies.tools.prefetch;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class w implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PrefetchProcess f248838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<m> f248839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f248840c;

    @Override // com.bytedance.ies.tools.prefetch.x
    public final void a(i.b r100) {
        PrefetchProcess r101 = this.f248838a;
        if (r101 == null) goto L7;
        PrefetchProcess.HitState r102 = r101.f248736b;
        if (r102 == null) goto L7;
    L8:
        r100.f248825f = r102.ordinal();
        m r103 = this.f248839b.get();
        if (r103 != null) goto L11;
        return;
    L11:
        if ((r103 instanceof m.a) == false) goto L13;
        ((m.a) r103).b(r100);
        return;
    L13:
        r103.a(r100.b());
        return;
    L7:
        r102 = PrefetchProcess.HitState.FALLBACK;
        goto L8
    }

    public final void b(JSONObject r100) {
        PrefetchRequest r101 = new PrefetchRequest(r100);
        PrefetchProcess r102 = this.f248840c.a(r101, this);
        this.f248838a = r102;
        if (r102 == null) goto L11;
        r102.f248735a.add(this);
        i.b r103 = r102.f248738d;
        if (r103 == null) goto L7;
        a(r103);
    L7:
        Throwable r104 = r102.f248737c;
        if (r104 == null) goto L12;
        onFailed(r104);
        return;
    L12:
        return;
    }

    public final void c(JSONObject r100) {
        PrefetchRequest r101 = new PrefetchRequest(r100);
        PrefetchProcess r102 = this.f248840c.b(r101, this);
        this.f248838a = r102;
        if (r102 == null) goto L11;
        r102.f248735a.add(this);
        i.b r103 = r102.f248738d;
        if (r103 == null) goto L7;
        a(r103);
    L7:
        Throwable r104 = r102.f248737c;
        if (r104 == null) goto L12;
        onFailed(r104);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.tools.prefetch.x
    public final void onFailed(Throwable r100) {
        m r101 = this.f248839b.get();
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    public w(l r100, m r101) {
        this.f248840c = r100;
        this.f248839b = new WeakReference(r101);
    }
}
