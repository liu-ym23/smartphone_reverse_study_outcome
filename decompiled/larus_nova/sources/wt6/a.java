package wt6;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.jato.api.IJato;
import kotlin.jvm.internal.Intrinsics;
import rx6.d;
import rx6.e;
import rx6.f;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends im6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f561226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C8161a f561227b = null;

    /* JADX INFO: renamed from: wt6.a$a, reason: collision with other inner class name */
    public static final class C8161a extends ThreadLocal<Integer> {
        @Override // java.lang.ThreadLocal
        public final Integer initialValue() {
            return 0;
        }

        public C8161a() {
        }
    }

    static {
        f561226a = new a();
        f561227b = new C8161a();
    }

    @Override // im6.b, ut6.c
    public final void a() {
        Intrinsics.checkNotNullParameter("WholeProcessOptimization1", "scene");
        int r100 = rx6.b.f539824a;
        Intrinsics.checkNotNullParameter("WholeProcessOptimization1", "scene");
        f.a();
        IJato.f351658a.r();
    }

    @Override // im6.b, ut6.c
    public final void bindBigCore() {
        b.f561228a.getClass();
        if (b.a() == true) goto L5;
        return;
    L5:
        C8161a r100 = f561227b;
        Integer r101 = r100.get();
        if (r101 == null) goto L8;
        int r102 = r101.intValue();
    L9:
        r100.set(Integer.valueOf(r102 + 1));
        if (r102 != 0) goto L13;
        IJato.f351658a.bindBigCore();
        return;
    L13:
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // im6.b, ut6.c
    public final void d() {
        int r100 = rx6.b.f539824a;
        f.a();
        IJato.f351658a.b(2000);
    }

    @Override // im6.b, ut6.c
    public final void e() {
        b.f561228a.getClass();
        if (b.a() == true) goto L5;
        return;
    L5:
        C8161a r100 = f561227b;
        Integer r101 = r100.get();
        if (r101 == null) goto L8;
        int r102 = r101.intValue();
    L9:
        if (r102 > 0) goto L11;
        return;
    L11:
        int r103 = r102 - 1;
        if (r103 != 0) goto L14;
        r100.remove();
        IJato.f351658a.resetCoreBind();
        return;
    L14:
        r100.set(Integer.valueOf(r103));
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // im6.b, ut6.c
    public final void g() {
        int r100 = e.f539826a;
        TTExecutors.getIOThreadPool().execute(new d());
    }

    public a() {
    }

    @Override // im6.b, ut6.c
    public final void f() {
        int r100 = rx6.a.f539823a;
    }

    @Override // im6.b, ut6.c
    public final void h() {
        int r100 = rx6.a.f539823a;
    }

    @Override // im6.b, ut6.c
    public final void b(final long r100) {
        int r101 = e.f539826a;
        TTExecutors.getIOThreadPool().execute(new rx6.c(r100));
    }

    @Override // im6.b, ut6.c
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        int r101 = rx6.b.f539824a;
        Intrinsics.checkNotNullParameter(r100, "scene");
        f.a();
        IJato.f351658a.stopBlockGc(r100);
    }
}
