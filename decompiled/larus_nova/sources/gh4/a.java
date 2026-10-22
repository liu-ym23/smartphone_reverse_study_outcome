package gh4;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.p;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f481274a;

    /* JADX INFO: renamed from: gh4.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static class RunnableC6021a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f481275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f481276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f481277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f481278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f481279e;

        public final void a() {
            com.bytedance.crash.monitor.a r100 = j.f203315a;
            if (r100 != null) goto L11;
            return;
        L11:
            eh4.a r101 = b.a(r100, this.f481278d, this.f481275a, this.f481276b, this.f481277c, this.f481279e);     // Catch: Throwable -> L7
            boolean r102 = CrashUploader.h(n.f(CrashType.GAME, r101.f472654b.f203195a), r101.f472653a);     // Catch: Throwable -> L7
        L8:
            if (r102 == true) goto L13;
            p.d("upload failed!");
            return;
        L13:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6021a(String r100, long r101, String r102, String r103, String r104) {
            this.f481278d = r100;
            this.f481275a = r101;
            this.f481276b = r102;
            this.f481277c = r103;
            this.f481279e = r104;
        }
    }
}
