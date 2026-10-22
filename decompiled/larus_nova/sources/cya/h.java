package cya;

import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.event.m;

/* JADX INFO: loaded from: classes34.dex */
public abstract class h implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f465973b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f465974c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.ss.android.lark.keyboard.base.m<Boolean> f465975d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.ss.android.lark.keyboard.base.m<Boolean> f465976e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.ss.android.lark.keyboard.base.m<Integer> f465977f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f465978a;

    public static final class a {
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f465979g;

        public b() {
            this.f465979g = -1;
        }

        @Override // cya.h
        public final int a() {
            return this.f465979g;
        }
    }

    public abstract int a();

    static {
        f465973b = new b();
        f465974c = new b();
        f465975d = new com.ss.android.lark.keyboard.base.m();
        f465976e = new com.ss.android.lark.keyboard.base.m();
        f465977f = new com.ss.android.lark.keyboard.base.m();
    }

    public h() {
        this.f465978a = new n();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return com.ss.android.lark.keyboard.event.c.a.a(this);
    }
}
