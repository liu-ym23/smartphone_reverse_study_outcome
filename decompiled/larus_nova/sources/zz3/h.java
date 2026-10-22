package zz3;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tz3.b<Long> f574085a;

    public final long a() {
        Long r100 = this.f574085a.f548046c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.longValue();
    }

    public h() {
        this.f574085a = new tz3.b();
    }

    public final void b(long r100) {
        this.f574085a.b(Long.valueOf(r100));
    }
}
