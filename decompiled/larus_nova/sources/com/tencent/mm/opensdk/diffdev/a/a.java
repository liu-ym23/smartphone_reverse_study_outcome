package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class a implements IDiffDevOAuth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f461600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<OAuthListener> f461601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f461602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OAuthListener f461603d;

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.diffdev.a.a$a, reason: collision with other inner class name */
    public class C5540a implements OAuthListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f461604a;

        /* JADX INFO: renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a, reason: collision with other inner class name */
        public class RunnableC5541a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C5540a f461605a;

            public RunnableC5541a(C5540a r100) {
                this.f461605a = r100;
            }

            public void com_tencent_mm_opensdk_diffdev_a_a$a$a__run$___twin___() {
                ArrayList r100 = new ArrayList();
                r100.addAll(a.a(this.f461605a.f461604a));
                Iterator r101 = r100.iterator();
            L4:
                if (r101.hasNext() == false) goto L6;
                ((OAuthListener) r101.next()).onQrcodeScanned();
                goto L4
            }

            @Override // java.lang.Runnable
            public void run() {
                com_tencent_mm_opensdk_diffdev_a_a$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_tencent_mm_opensdk_diffdev_a_a$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC5541a r100) {
                r100.com_tencent_mm_opensdk_diffdev_a_a$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public C5540a(a r100) {
            this.f461604a = r100;
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(OAuthErrCode r100, String r101) {
            Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{r100.toString(), r101}));
            a.a(this.f461604a, null);
            ArrayList r102 = new ArrayList();
            r102.addAll(a.a(this.f461604a));
            Iterator r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((OAuthListener) r103.next()).onAuthFinish(r100, r101);
            goto L4
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(String r100, byte[] r101) {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + r100);
            ArrayList r102 = new ArrayList();
            r102.addAll(a.a(this.f461604a));
            Iterator r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((OAuthListener) r103.next()).onAuthGotQrcode(r100, r101);
            goto L4
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (a.b(this.f461604a) == null) goto L6;
            a.b(this.f461604a).post(new RunnableC5541a(this));
            return;
        }
    }

    public a() {
        this.f461600a = null;
        this.f461601b = new ArrayList();
        this.f461603d = new C5540a(this);
    }

    public static /* synthetic */ b a(a r100, b r101) {
        r100.f461602c = r101;
        return r101;
    }

    public static /* synthetic */ List a(a r100) {
        return r100.f461601b;
    }

    public static /* synthetic */ Handler b(a r100) {
        return r100.f461600a;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(OAuthListener r100) {
        if (this.f461601b.contains(r100) == true) goto L6;
        this.f461601b.add(r100);
        return;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f461601b.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        this.f461601b.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(OAuthListener r100) {
        this.f461601b.remove(r100);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        b r100 = this.f461602c;     // Catch: Exception -> L8
        if (r100 != null) goto L6;
        boolean r101 = true;
    L10:
        this.f461602c = null;
        return r101;
    L6:
        r101 = r100.a();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
        r101 = false;
        goto L10
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(String r110, String r111, String r112, String r113, String r114, OAuthListener r115) {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + r110);
        if (r110 != null) goto L5;
    L22:
        Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{r110, r111}));
        return false;
    L5:
        if (r110.length() <= 0) goto L22;
        if (r111 == null) goto L22;
        if (r111.length() <= 0) goto L22;
        if (this.f461600a != null) goto L14;
        this.f461600a = new Handler(Looper.getMainLooper());
    L14:
        if (this.f461601b.contains(r115) == true) goto L17;
        this.f461601b.add(r115);
    L17:
        if (this.f461602c == null) goto L20;
        Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
        return true;
    L20:
        b r116 = new b(r110, r111, r112, r113, r114, this.f461603d);
        this.f461602c = r116;
        r116.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }
}
