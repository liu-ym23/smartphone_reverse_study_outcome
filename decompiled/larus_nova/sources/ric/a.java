package ric;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.SubInfoSimpleCallBack;
import com.ss.ttvideoengine.utils.Error;
import nic.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends SubInfoSimpleCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qic.b f537941a;

    /* JADX INFO: renamed from: ric.a$a, reason: collision with other inner class name */
    public class RunnableC7488a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f537942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Error f537943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f537944c;

        @Override // java.lang.Runnable
        public final void run() {
            qic.b r100 = this.f537944c.f537941a;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            String r101 = this.f537942a;     // Catch: Throwable -> L8
            Error r102 = this.f537943b;     // Catch: Throwable -> L8
            l r103 = r100.f533236l;     // Catch: Throwable -> L8
            if (r103 == null) goto L15;
            r103.M(r100.f533239o, r100.f533228d, r101, r102);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public RunnableC7488a(a r100, String r101, Error r102) {
            this.f537944c = r100;
            this.f537942a = r101;
            this.f537943b = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f537945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f537946b;

        @Override // java.lang.Runnable
        public final void run() {
            qic.b r100 = this.f537946b.f537941a;     // Catch: Throwable -> L12
            if (r100 != null) goto L19;
            return;
        L19:
            String r101 = new JSONObject(this.f537945a).optString("info");     // Catch: Exception -> L7 Throwable -> L12
        L8:
            l r102 = r100.f533236l;     // Catch: Throwable -> L12
            if (r102 == null) goto L21;
            r102.g(r100.f533239o, r100.f533228d, r101);     // Catch: Throwable -> L12
            return;
        L21:
            return;
        L7:
            r101 = "";
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public b(a r100, int r101, String r102) {
            this.f537946b = r100;
            this.f537945a = r102;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f537947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f537948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f537949c;

        @Override // java.lang.Runnable
        public final void run() {
            qic.b r100 = this.f537949c.f537941a;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            int r101 = this.f537947a;     // Catch: Throwable -> L8
            int r102 = this.f537948b;     // Catch: Throwable -> L8
            l r103 = r100.f533236l;     // Catch: Throwable -> L8
            if (r103 == null) goto L15;
            r103.P(r100.f533239o, r100.f533228d, r101, r102);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public c(a r100, int r101, int r102) {
            this.f537949c = r100;
            this.f537947a = r101;
            this.f537948b = r102;
        }
    }

    @Override // com.ss.ttvideoengine.SubInfoSimpleCallBack, com.ss.ttvideoengine.SubInfoCallBack
    public final void onSubLoadFinished(int r100) {
    }

    public a(qic.b r100) {
        this.f537941a = r100;
    }

    @Override // com.ss.ttvideoengine.SubInfoSimpleCallBack, com.ss.ttvideoengine.SubInfoCallBack
    public final void onSubInfoCallback(int r100, String r101) {
        fjc.a.a().post(new b(this, r100, r101));
    }

    @Override // com.ss.ttvideoengine.SubInfoSimpleCallBack, com.ss.ttvideoengine.SubInfoCallBack
    public final void onSubPathInfo(String r100, Error r101) {
        fjc.a.a().post(new RunnableC7488a(this, r100, r101));
    }

    @Override // com.ss.ttvideoengine.SubInfoSimpleCallBack, com.ss.ttvideoengine.SubInfoCallBack
    public final void onSubSwitchCompleted(int r100, int r101) {
        fjc.a.a().post(new c(this, r100, r101));
    }
}
