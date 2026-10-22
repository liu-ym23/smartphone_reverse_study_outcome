package oh;

import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: oh.a$a, reason: collision with other inner class name */
    public static final class C7054a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f523233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f523234b;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final k r() {
            r r100 = new r();
            r100.f48048c = true;
            return r100.f48052g.b();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f523233a.run();
            System.out.println("Django: Task: event async: " + this.f523234b);
        }

        public C7054a(Runnable r100, String r101) {
            this.f523233a = r100;
            this.f523234b = r101;
        }
    }

    public static final class b implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f523235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f523236b;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final k r() {
            r r100 = new r();
            r100.f48047b = true;
            return r100.f48051f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f523235a.run();
            System.out.println("Django: Task: fps event async: " + this.f523236b);
        }

        public b(Runnable r100, String r101) {
            this.f523235a = r100;
            this.f523236b = r101;
        }
    }

    public static final void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        b("", r100);
    }

    public static final void b(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        r101.run();
    }

    public static final void c(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        if (c.q() != 1) goto L5;
        t.b(new C7054a(r101, r100));
        return;
    L5:
        r101.run();
    }

    public static final void d(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        t.b(new b(r101, r100));
    }
}
