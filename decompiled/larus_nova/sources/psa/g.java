package psa;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f530536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f530537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f530538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f530539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f530540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ psa.a f530542h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CertResponse f530543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f530544b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530544b.f530541g.onRequestFinish(new BDResponse(this.f530543a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g r100, CertResponse r101) {
            this.f530544b = r100;
            this.f530543a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f530545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f530546b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530546b.f530541g.onRequestFinish(new BDResponse(this.f530545a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(g r100, Pair r101) {
            this.f530546b = r100;
            this.f530545a = r101;
        }
    }

    public final void a() {
        Map<String, String> r100 = this.f530535a;     // Catch: Exception -> L24
        if (r100 != null) goto L7;
        r100 = new HashMap();     // Catch: Exception -> L24
    L7:
        if (TextUtils.isEmpty(this.f530536b) == true) goto L9;
        r100.put("image_type", this.f530536b);     // Catch: Exception -> L24
    L9:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L24
        int r102 = this.f530537c;     // Catch: Exception -> L24
        if (r102 != 0) goto L12;
        r102 = 85;
    L12:
        Map<String, osa.c> r103 = gsa.a.f482481a;     // Catch: Exception -> L24
        HashMap r104 = (HashMap) r103;     // Catch: Exception -> L24
        osa.c r105 = (osa.c) r104.get(this.f530536b);     // Catch: Exception -> L24
        if (r105 == null) goto L17;
        Bitmap r106 = r105.f526593a;     // Catch: Exception -> L24
        if (r106 == null) goto L17;
        r106.compress(Bitmap.CompressFormat.JPEG, r102, r101);     // Catch: Exception -> L24
        ExifInterface r107 = r105.f526594b;     // Catch: Exception -> L24
    L18:
        byte[] r108 = psa.a.a(this.f530542h, this.f530538d, r107, r101.toByteArray());     // Catch: Exception -> L24
        HashMap r109 = new HashMap();     // Catch: Exception -> L24
        Pair r110 = new Pair("image.jpg", r108);     // Catch: Exception -> L24
        if (TextUtils.isEmpty(this.f530539e) == false) goto L21;
        r109.put("image", r110);     // Catch: Exception -> L24
    L22:
        CertResponse r111 = this.f530542h.f530473a.postMultiPartWithUrl(this.f530540f, r100, r109);     // Catch: Exception -> L24
        BytedCertManager.getInstance().executeInMainThread(new a(this, r111));     // Catch: Exception -> L24
        return;
    L21:
        r109.put(this.f530539e, r110);     // Catch: Exception -> L24
    L17:
        r107 = null;
    L24:
        e = move-exception;
        e.printStackTrace();
        int r112 = ErrorConstant.checkClientException(e);
        this.f530542h.f530473a.onExceptionEvent(e, r112);
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

    public g(psa.a r100, Map r101, String r102, Context r103, String r104, String r105, SDKCallBack.CommonRequestCallback r106) {
        this.f530542h = r100;
        this.f530535a = r101;
        this.f530536b = r102;
        this.f530537c = 0;
        this.f530538d = r103;
        this.f530539e = r104;
        this.f530540f = r105;
        this.f530541g = r106;
    }
}
