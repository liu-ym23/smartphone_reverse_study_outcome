package og7;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.sync.exc.SyncApiException;
import com.bytedance.sync.exc.SyncIOException;
import com.larus.apm.impl.protector.RunnableProtector;
import yf7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ag7.b f523200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yf7.a f523201b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f523202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ag7.a f523203b;

        public a(b r100, ag7.a r101) {
            this.f523202a = r100;
            this.f523203b = r101;
        }

        public final void a() {
            ag7.a r100 = this.f523203b;
            if (r100 != null) goto L9;
            yf7.a r101 = this.f523202a.f523201b;
            if (r101 == null) goto L18;
            d r102 = (d) r101;
            r102.b(new SyncApiException(1, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN));
            return;
        L18:
            return;
        L9:
            if (r100.b() == 0) goto L14;
            yf7.a r103 = this.f523202a.f523201b;
            if (r103 == null) goto L19;
            d r104 = (d) r103;
            r104.b(new SyncApiException(this.f523203b.b(), this.f523203b.a()));
            return;
        L19:
            return;
        L14:
            yf7.a r105 = this.f523202a.f523201b;
            if (r105 == null) goto L20;
            ((d) r105).c();
            return;
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
    }

    /* JADX INFO: renamed from: og7.b$b, reason: collision with other inner class name */
    public static final class RunnableC7051b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f523204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Exception f523205b;

        public RunnableC7051b(b r100, Exception r101) {
            this.f523204a = r100;
            this.f523205b = r101;
        }

        public final void a() {
            if ((this.f523205b instanceof CommonHttpException) == false) goto L7;
            yf7.a r100 = this.f523204a.f523201b;
            if (r100 == null) goto L11;
            d r101 = (d) r100;
            r101.b(new SyncIOException(((CommonHttpException) this.f523205b).getResponseCode(), this.f523205b.getMessage(), this.f523205b));
            return;
        L11:
            return;
        L7:
            yf7.a r102 = this.f523204a.f523201b;
            if (r102 == null) goto L13;
            d r103 = (d) r102;
            r103.b(new SyncIOException(1, this.f523205b.getMessage(), this.f523205b));
            return;
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
    }

    public b(ag7.b r100, d r101) {
        this.f523200a = r100;
        this.f523201b = r101;
    }

    public final void a() {
        ag7.a r100 = ((k) rgc.b.a(k.class)).f0(this.f523200a);     // Catch: Exception -> L5
        new Handler(Looper.getMainLooper()).post(new a(this, r100));
        return;
    L5:
        e = move-exception;
        new Handler(Looper.getMainLooper()).post(new RunnableC7051b(this, e));
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
}
