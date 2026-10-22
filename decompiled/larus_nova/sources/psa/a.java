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
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.BCNetworkUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BCNetworkUtils f530473a;

    /* JADX INFO: renamed from: psa.a$a, reason: collision with other inner class name */
    public class C7237a extends BCThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f530474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f530475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f530476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.CommonRequestCallback f530477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f530478e;

        /* JADX INFO: renamed from: psa.a$a$a, reason: collision with other inner class name */
        public class RunnableC7238a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CertResponse f530479a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C7237a f530480b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f530480b.f530477d.onRequestFinish(new BDResponse(this.f530479a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7238a(C7237a r100, CertResponse r101) {
                this.f530480b = r100;
                this.f530479a = r101;
            }
        }

        public final void a() {
            if ("POST".equalsIgnoreCase(this.f530474a) == false) goto L5;
            CertResponse r100 = this.f530478e.f530473a.fetchPost(this.f530475b, null, this.f530476c, null);
        L6:
            BytedCertManager.getInstance().executeInMainThread(new RunnableC7238a(this, r100));
            return;
        L5:
            r100 = this.f530478e.f530473a.fetchGet(this.f530475b, null, this.f530476c, null);
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

        public C7237a(a r100, String r101, String r102, Map r103, SDKCallBack.CommonRequestCallback r104) {
            this.f530478e = r100;
            this.f530474a = r101;
            this.f530475b = r102;
            this.f530476c = r103;
            this.f530477d = r104;
        }
    }

    public class b extends BCThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f530481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f530482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f530483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f530484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f530485e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.CommonRequestCallback f530486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f530487g;

        /* JADX INFO: renamed from: psa.a$b$a, reason: collision with other inner class name */
        public class RunnableC7239a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CertResponse f530488a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f530489b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f530489b.f530486f.onRequestFinish(new BDResponse(this.f530488a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7239a(b r100, CertResponse r101) {
                this.f530489b = r100;
                this.f530488a = r101;
            }
        }

        /* JADX INFO: renamed from: psa.a$b$b, reason: collision with other inner class name */
        public class RunnableC7240b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f530490a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f530491b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f530491b.f530486f.onRequestFinish(new BDResponse(this.f530490a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7240b(b r100, Pair r101) {
                this.f530491b = r100;
                this.f530490a = r101;
            }
        }

        public final void a() {
            Map<String, String> r100 = this.f530481a;     // Catch: Exception -> L24
            if (r100 != null) goto L7;
            r100 = new HashMap();     // Catch: Exception -> L24
        L7:
            if (TextUtils.isEmpty(this.f530482b) == true) goto L9;
            r100.put("image_type", this.f530482b);     // Catch: Exception -> L24
        L9:
            ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L24
            int r102 = this.f530483c;     // Catch: Exception -> L24
            if (r102 != 0) goto L12;
            r102 = 85;
        L12:
            Map<String, osa.c> r103 = gsa.a.f482481a;     // Catch: Exception -> L24
            HashMap r104 = (HashMap) r103;     // Catch: Exception -> L24
            osa.c r105 = (osa.c) r104.get(this.f530482b);     // Catch: Exception -> L24
            if (r105 == null) goto L17;
            Bitmap r106 = r105.f526593a;     // Catch: Exception -> L24
            if (r106 == null) goto L17;
            r106.compress(Bitmap.CompressFormat.JPEG, r102, r101);     // Catch: Exception -> L24
            ExifInterface r107 = r105.f526594b;     // Catch: Exception -> L24
        L18:
            byte[] r108 = a.a(this.f530487g, this.f530484d, r107, r101.toByteArray());     // Catch: Exception -> L24
            HashMap r109 = new HashMap();     // Catch: Exception -> L24
            r109.put("image", new Pair("image.jpg", r108));     // Catch: Exception -> L24
            BCNetworkUtils r110 = this.f530487g.f530473a;     // Catch: Exception -> L24
            if (this.f530485e == false) goto L21;
            String r111 = UrlConstant.getOcrPathV2(true);     // Catch: Exception -> L24
        L22:
            CertResponse r112 = r110.postMultiPart(r111, r100, r109);     // Catch: Exception -> L24
            BytedCertManager.getInstance().executeInMainThread(new RunnableC7239a(this, r112));     // Catch: Exception -> L24
            return;
        L21:
            r111 = UrlConstant.getOcrPath();     // Catch: Exception -> L24
        L17:
            r107 = null;
        L24:
            e = move-exception;
            e.printStackTrace();
            int r113 = ErrorConstant.checkClientException(e);
            this.f530487g.f530473a.onExceptionEvent(e, r113);
            Pair r114 = new Pair(Integer.valueOf(r113), CertLog.getStackTraceString(e));
            BytedCertManager.getInstance().executeInMainThread(new RunnableC7240b(this, r114));
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

        public b(a r100, Map r101, String r102, int r103, Context r104, boolean r105, SDKCallBack.CommonRequestCallback r106) {
            this.f530487g = r100;
            this.f530481a = r101;
            this.f530482b = r102;
            this.f530483c = r103;
            this.f530484d = r104;
            this.f530485e = r105;
            this.f530486f = r106;
        }
    }

    public class c extends BCThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f530492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f530493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f530494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.CommonRequestCallback f530495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f530496e;

        /* JADX INFO: renamed from: psa.a$c$a, reason: collision with other inner class name */
        public class RunnableC7241a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CertResponse f530497a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f530498b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f530498b.f530495d.onRequestFinish(new BDResponse(this.f530497a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7241a(c r100, CertResponse r101) {
                this.f530498b = r100;
                this.f530497a = r101;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f530499a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f530500b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f530500b.f530495d.onRequestFinish(new BDResponse(this.f530499a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(c r100, Pair r101) {
                this.f530500b = r100;
                this.f530499a = r101;
            }
        }

        public final void a() {
            Map<String, String> r100 = this.f530492a;     // Catch: Exception -> L12
            if (r100 != null) goto L7;
            r100 = new HashMap();     // Catch: Exception -> L12
        L7:
            HashMap r101 = new HashMap();     // Catch: Exception -> L12
            if (TextUtils.isEmpty(this.f530493b) == true) goto L10;
            r101.put("sdk_data", new Pair("sdk_data", this.f530493b.getBytes()));     // Catch: Exception -> L12
        L10:
            CertResponse r102 = this.f530496e.f530473a.postMultiPart(this.f530494c, r100, r101);     // Catch: Exception -> L12
            BytedCertManager.getInstance().executeInMainThread(new RunnableC7241a(this, r102));     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
            int r103 = ErrorConstant.checkClientException(e);
            this.f530496e.f530473a.onExceptionEvent(e, r103);
            Pair r104 = new Pair(Integer.valueOf(r103), CertLog.getStackTraceString(e));
            BytedCertManager.getInstance().executeInMainThread(new b(this, r104));
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

        public c(a r100, Map r101, String r102, String r103, SDKCallBack.CommonRequestCallback r104) {
            this.f530496e = r100;
            this.f530492a = r101;
            this.f530493b = r102;
            this.f530494c = r103;
            this.f530495d = r104;
        }
    }

    public a(BCNetworkUtils.NetworkEventProcessor r100) {
        this.f530473a = new BCNetworkUtils(r100);
    }

    public static byte[] a(a r100, Context r101, ExifInterface r102, byte[] r103) {
        r100.getClass();
        if (r102 != null) goto L15;
    L14:
        return r103;
    L15:
        String r104 = rsa.d.n(r101, r103, "img_tmp_" + System.nanoTime() + ".jpg");     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r104) == true) goto L14;
        rsa.d.e(r102, r104);     // Catch: Exception -> L12
        byte[] r105 = rsa.d.m(r104);     // Catch: Exception -> L12
        if (r105 == null) goto L10;
        r103 = r105;
    L10:
        rsa.d.g(r104);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public final void c(SDKCallBack.CommonRequestCallback r100, String r101, String r110, Map<String, String> r111) {
        new C7237a(this, r101, r110, r111, r100).start();
    }

    public final void d(SDKCallBack.CommonRequestCallback r100, String r101, String r110, Map<String, String> r111) {
        new c(this, r111, r110, r101, r100).start();
    }

    public final void b(Context r110, SDKCallBack.CommonRequestCallback r111, String r112, int r113, boolean r114, Map<String, String> r115) {
        new b(this, r115, r112, r113, r110, r114, r111).start();
    }
}
