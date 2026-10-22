package zz3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {
    public final tz3.b<Long> a;

    public final long a() {
        Long r0 = this.a.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.longValue();
    }

    public h() {
        this.a = new tz3.b();
    }

    public final void b(long r2) {
        this.a.b(Long.valueOf(r2));
    }
}
