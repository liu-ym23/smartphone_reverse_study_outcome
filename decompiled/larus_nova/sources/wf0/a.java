package wf0;

import com.bytedance.android.live.broadcast.api.model.t;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f559458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qz.a f559459b;

    /* JADX INFO: renamed from: wf0.a$a, reason: collision with other inner class name */
    public static final class C8103a {
    }

    static {
    }

    public a() {
    }

    public final qz.a a() {
        if (b.e() == false) goto L9;
        qz.a r100 = this.f559459b;
        if (r100 != null) goto L7;
    L8:
        this.f559459b = new c();
    L15:
        return this.f559459b;
    L7:
        if ((r100 instanceof d) == false) goto L15;
    L9:
        qz.a r101 = this.f559459b;
        if (r101 != null) goto L12;
    L13:
        this.f559459b = new d();
        goto L15
    L12:
        if ((r101 instanceof c) == false) goto L15;
        goto L13
    }
}
