package psa;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f530558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f530559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f530560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f530561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f530562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ psa.a f530564h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CertResponse f530565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f530566b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530566b.f530563g.onRequestFinish(new BDResponse(this.f530565a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(i r100, CertResponse r101) {
            this.f530566b = r100;
            this.f530565a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f530567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f530568b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530568b.f530563g.onRequestFinish(new BDResponse(this.f530567a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(i r100, Pair r101) {
            this.f530568b = r100;
            this.f530567a = r101;
        }
    }

    public final void a() {
        Map<String, String> r100 = this.f530557a;     // Catch: Exception -> L21
        if (r100 != null) goto L6;
        r100 = new HashMap();     // Catch: Exception -> L21
    L6:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L21
        int r102 = this.f530558b;     // Catch: Exception -> L21
        if (r102 != 0) goto L9;
        r102 = 85;
    L9:
        HashMap r103 = new HashMap();     // Catch: Exception -> L21
        Map<String, osa.c> r104 = gsa.a.f482481a;     // Catch: Exception -> L21
        osa.c r105 = (osa.c) ((HashMap) r104).get(NewBroadcastMonitor.CAPTURE.FRONT);     // Catch: Exception -> L21
        if (r105 == null) goto L14;
        Bitmap r106 = r105.f526593a;     // Catch: Exception -> L21
        if (r106 == null) goto L14;
        r106.compress(Bitmap.CompressFormat.JPEG, r102, r101);     // Catch: Exception -> L21
        ExifInterface r107 = r105.f526594b;     // Catch: Exception -> L21
        r103.put("front_image", new Pair("front_image.jpg", psa.a.a(this.f530564h, this.f530559c, r107, r101.toByteArray())));     // Catch: Exception -> L21
    L14:
        osa.c r108 = (osa.c) ((HashMap) r104).get("back");     // Catch: Exception -> L21
        if (r108 != null) goto L17;
    L19:
        r100.put(BytedCertConstant.CertKey.IDENTITY_CODE, this.f530560d);     // Catch: Exception -> L21
        r100.put(BytedCertConstant.CertKey.IDENTITY_NAME, this.f530561e);     // Catch: Exception -> L21
        r100.put("identity_type", this.f530562f);     // Catch: Exception -> L21
        CertResponse r109 = this.f530564h.f530473a.postMultiPart(UrlConstant.getPreManualCheck(), r100, r103);     // Catch: Exception -> L21
        BytedCertManager.getInstance().executeInMainThread(new a(this, r109));     // Catch: Exception -> L21
        return;
    L17:
        if (r108.f526593a == null) goto L19;
        ByteArrayOutputStream r110 = new ByteArrayOutputStream();     // Catch: Exception -> L21
        r108.f526593a.compress(Bitmap.CompressFormat.JPEG, r102, r110);     // Catch: Exception -> L21
        ExifInterface r111 = r108.f526594b;     // Catch: Exception -> L21
        r103.put("back_image", new Pair("back_image.jpg", psa.a.a(this.f530564h, this.f530559c, r111, r110.toByteArray())));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        int r112 = ErrorConstant.checkClientException(e);
        this.f530564h.f530473a.onExceptionEvent(e, r112);
        Pair r113 = new Pair(Integer.valueOf(r112), CertLog.getStackTraceString(e));
        BytedCertManager.getInstance().executeInMainThread(new b(this, r113));
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

    public i(psa.a r100, Map r101, Context r102, String r103, String r104, String r105, SDKCallBack.CommonRequestCallback r106) {
        this.f530564h = r100;
        this.f530557a = r101;
        this.f530558b = 0;
        this.f530559c = r102;
        this.f530560d = r103;
        this.f530561e = r104;
        this.f530562f = r105;
        this.f530563g = r106;
    }
}
