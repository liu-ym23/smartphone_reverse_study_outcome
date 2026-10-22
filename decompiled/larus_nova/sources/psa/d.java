package psa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f530518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f530519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f530521e;

    public final void a() {
        if (this.f530517a == null) goto L5;
        HashMap r100 = new HashMap(this.f530517a);
    L6:
        CertResponse r101 = this.f530521e.f530473a.postMultiPart(this.f530518b, r100, this.f530519c);
        this.f530520d.onRequestFinish(new BDResponse(r101));
        return;
    L5:
        r100 = new HashMap();
        goto L6
    }

    @Override // com.ss.android.cert.manager.utils.thread.BCThread, java.lang.Runnable
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

    public d(a r100, Map r101, String r102, Map r103, SDKCallBack.CommonRequestCallback r104) {
        this.f530521e = r100;
        this.f530517a = r101;
        this.f530518b = r102;
        this.f530519c = r103;
        this.f530520d = r104;
    }
}
