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
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f530548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f530549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f530550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ psa.a f530552f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CertResponse f530553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f530554b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530554b.f530551e.onRequestFinish(new BDResponse(this.f530553a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r100, CertResponse r101) {
            this.f530554b = r100;
            this.f530553a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f530555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f530556b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530556b.f530551e.onRequestFinish(new BDResponse(this.f530555a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(h r100, Pair r101) {
            this.f530556b = r100;
            this.f530555a = r101;
        }
    }

    public final void a() {
        Map<String, String> r100 = this.f530547a;     // Catch: Exception -> L21
        if (r100 != null) goto L6;
        r100 = new HashMap();     // Catch: Exception -> L21
    L6:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L21
        int r102 = this.f530548b;     // Catch: Exception -> L21
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
        r103.put("front_image", new Pair("front_image.jpg", psa.a.a(this.f530552f, this.f530549c, r107, r101.toByteArray())));     // Catch: Exception -> L21
    L14:
        osa.c r108 = (osa.c) ((HashMap) r104).get("back");     // Catch: Exception -> L21
        if (r108 != null) goto L17;
    L19:
        CertResponse r109 = this.f530552f.f530473a.postMultiPart(UrlConstant.getOcrPathV2(this.f530550d), r100, r103);     // Catch: Exception -> L21
        BytedCertManager.getInstance().executeInMainThread(new a(this, r109));     // Catch: Exception -> L21
        return;
    L17:
        if (r108.f526593a == null) goto L19;
        ByteArrayOutputStream r110 = new ByteArrayOutputStream();     // Catch: Exception -> L21
        r108.f526593a.compress(Bitmap.CompressFormat.JPEG, r102, r110);     // Catch: Exception -> L21
        ExifInterface r111 = r108.f526594b;     // Catch: Exception -> L21
        r103.put("back_image", new Pair("back_image.jpg", psa.a.a(this.f530552f, this.f530549c, r111, r110.toByteArray())));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        int r112 = ErrorConstant.checkClientException(e);
        this.f530552f.f530473a.onExceptionEvent(e, r112);
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

    public h(psa.a r100, Map r101, Context r102, boolean r103, SDKCallBack.CommonRequestCallback r104) {
        this.f530552f = r100;
        this.f530547a = r101;
        this.f530548b = 0;
        this.f530549c = r102;
        this.f530550d = r103;
        this.f530551e = r104;
    }
}
