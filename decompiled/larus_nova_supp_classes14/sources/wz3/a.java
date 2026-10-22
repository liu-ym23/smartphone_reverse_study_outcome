package wz3;

import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final b a = null;
    public static final C0184a b = null;

    /* JADX INFO: renamed from: wz3.a$a, reason: collision with other inner class name */
    public static final class C0184a extends d {
        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final int b() {
            return 2;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final int c() {
            return 6;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final int d() {
            return 2;
        }

        public C0184a() {
        }
    }

    public static final class b extends d {
        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final d[] a() {
            return new d[]{a.b};
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final int b() {
            return 1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final int c() {
            return 5;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d
        public final int d() {
            return 1;
        }

        public b() {
        }
    }

    static {
        a = new b();
        b = new C0184a();
    }
}
