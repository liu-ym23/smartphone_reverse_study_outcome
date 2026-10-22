package psa;

import android.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends BCThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f530569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f530570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f530571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f530572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ psa.a f530573e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CertResponse f530574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f530575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f530576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f530577d;

        public final void a() {
            this.f530577d.f530572d.onRequestFinish(new BDResponse(this.f530574a));
            JSONObject r100 = this.f530575b;     // Catch: Exception -> L13
            if (this.f530574a.success == false) goto L6;
            String r101 = "success";
        L7:
            r100.put("result", r101);     // Catch: Exception -> L13
            CertResponse r102 = this.f530574a;     // Catch: Exception -> L13
            if (r102.success == true) goto L10;
            this.f530575b.put("fail_reason", r102.errorMsg);     // Catch: Exception -> L13
        L10:
            this.f530575b.put("duration", System.currentTimeMillis() - this.f530576c);     // Catch: Exception -> L13
            goto L11
        L6:
            r101 = "fail";
        L11:
            this.f530577d.f530573e.f530473a.onEvent("face_detection_data_upload", this.f530575b);
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

        public a(j r100, CertResponse r101, JSONObject r102, long r103) {
            this.f530577d = r100;
            this.f530574a = r101;
            this.f530575b = r102;
            this.f530576c = r103;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f530578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f530579b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f530579b.f530572d.onRequestFinish(new BDResponse(this.f530578a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(j r100, Pair r101) {
            this.f530579b = r100;
            this.f530578a = r101;
        }
    }

    public final void a() {
        Map<String, String> r100 = this.f530569a;     // Catch: Exception -> L35
        if (r100 != null) goto L7;
        r100 = new HashMap();     // Catch: Exception -> L35
    L7:
        HashMap r101 = new HashMap();     // Catch: Exception -> L35
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L35
        long r103 = System.currentTimeMillis();     // Catch: Exception -> L35
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: Exception -> L35
        String r105 = "";
        byte[] r106 = this.f530570b.getBytes();     // Catch: Exception -> L35
        ZipOutputStream r110 = null;
        ZipOutputStream r111 = new ZipOutputStream(r104);     // Catch: Exception -> L14
        r111.putNextEntry(new ZipEntry("sdk_data"));     // Catch: Exception -> L12
        r111.write(r106);     // Catch: Exception -> L12
        r111.closeEntry();     // Catch: Exception -> L12
    L39:
        r104.close();     // Catch: Exception -> L38
        if (r111 == null) goto L20;
        r111.close();     // Catch: Exception -> L38
    L20:
        byte[] r107 = r104.toByteArray();     // Catch: Exception -> L35
        if (r107.length <= 0) goto L23;
        boolean r112 = true;
    L24:
        long r113 = System.currentTimeMillis() - r103;     // Catch: Exception -> L35
        r102.put("compress_duration", r113);     // Catch: Exception -> L35
        r102.put("size", r106.length);     // Catch: Exception -> L35
        r102.put("compress_duration", r113);     // Catch: Exception -> L35
        if (r112 == false) goto L27;
        String r114 = "success";
    L28:
        r102.put("compress_result", r114);     // Catch: Exception -> L35
        if (r112 == false) goto L32;
        Pair r108 = new Pair("sdk_data", r107);     // Catch: Exception -> L35
        r100.put(VideoTools.ERROR_TYPE_COMPRESS, "1");     // Catch: Exception -> L35
        r102.put("compress_size", r107.length);     // Catch: Exception -> L35
    L33:
        r101.put("sdk_data", r108);     // Catch: Exception -> L35
        CertResponse r109 = this.f530573e.f530473a.postMultiPart(this.f530571c, r100, r101);     // Catch: Exception -> L35
        BytedCertManager.getInstance().executeInMainThread(new a(this, r109, r102, r103));     // Catch: Exception -> L35
        return;
    L32:
        Pair r115 = new Pair("sdk_data", r106);     // Catch: Exception -> L35
        r102.put(VideoTools.ERROR_TYPE_COMPRESS, "0");     // Catch: Exception -> L35
        r102.put("compress_fail_reason", r105);     // Catch: Exception -> L35
        r108 = r115;
        goto L33
    L27:
        r114 = "fail";
        goto L28
    L23:
        r112 = false;
    L12:
        e = e;
        r110 = r111;
    L15:
        r105 = e.getMessage();     // Catch: Exception -> L35
        r111 = r110;
    L14:
        e = e;
    L35:
        e = move-exception;
        e.printStackTrace();
        int r116 = ErrorConstant.checkClientException(e);
        this.f530573e.f530473a.onExceptionEvent(e, r116);
        Pair r117 = new Pair(Integer.valueOf(r116), CertLog.getStackTraceString(e));
        BytedCertManager.getInstance().executeInMainThread(new b(this, r117));
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

    public j(psa.a r100, Map r101, String r102, String r103, SDKCallBack.CommonRequestCallback r104) {
        this.f530573e = r100;
        this.f530569a = r101;
        this.f530570b = r102;
        this.f530571c = r103;
        this.f530572d = r104;
    }
}
