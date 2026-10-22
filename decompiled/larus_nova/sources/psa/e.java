package psa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.video.fragment.VideoPlayFragment;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f530523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f530525d;

    public final void a() {
        if (this.f530522a == null) goto L5;
        HashMap r100 = new HashMap(this.f530522a);
    L6:
        CertResponse r101 = this.f530525d.f530473a.postMultiPart(UrlConstant.getUploadShootVideoPath(), r100, this.f530523b);
        this.f530524c.onRequestFinish(new BDResponse(r101));
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

    public e(a r100, Map r101, Map r102, VideoPlayFragment.d r103) {
        this.f530525d = r100;
        this.f530522a = r101;
        this.f530523b = r102;
        this.f530524c = r103;
    }
}
