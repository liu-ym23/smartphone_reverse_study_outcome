package ww7;

import android.content.Context;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f561668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f561669b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f561670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ww7.a f561671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k0 f561672c;

        public final void a() {
            Object r100 = this.f561670a.call();     // Catch: Exception -> L4 ApiException -> L5
            k0 r101 = this.f561672c;     // Catch: Exception -> L4 ApiException -> L5
            ww7.a r102 = this.f561671b;     // Catch: Exception -> L4 ApiException -> L5
            r101.getClass();     // Catch: Exception -> L4 ApiException -> L5
            h.a(new n0(r102, r100));     // Catch: Exception -> L4 ApiException -> L5
        L11:
            return;
        L5:
            e = move-exception;
            k0 r103 = this.f561672c;
            ww7.a r104 = this.f561671b;
            int r105 = e.getErrorCode();
            String r106 = e.getMessage();
            r103.getClass();
            h.a(new p0(r104, r105, r106));
            return;
        L4:
            k0 r107 = this.f561672c;
            ww7.a r108 = this.f561671b;
            HonorPushErrorEnum r109 = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            int r110 = r109.getErrorCode();
            String r111 = r109.getMessage();
            r107.getClass();
            h.a(new p0(r108, r110, r111));
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

        public a(k0 r100, Callable r101, ww7.a r102) {
            this.f561672c = r100;
            this.f561670a = r101;
            this.f561671b = r102;
        }
    }

    public k0(Context r100) {
        this.f561668a = r100;
        this.f561669b = new d();
    }

    public final <T> void a(Callable<T> r100, ww7.a<T> r101) {
        a r102 = new a(this, r100, r101);
        h r103 = h.f561658d;
        if (r103.f561660b != null) goto L14;
        Object r104 = r103.f561661c;
        monitor-enter(r104);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (r103.f561660b != null) goto L9;
        r103.f561660b = h.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r104);     // Catch: Throwable -> L11
    L14:
        r103.f561660b.execute(r102);
    }
}
