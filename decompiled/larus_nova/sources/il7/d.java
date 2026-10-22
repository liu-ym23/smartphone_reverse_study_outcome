package il7;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f490317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.a f490318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f490319c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f490320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f490321b;

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (TextUtils.isEmpty(this.f490320a) == false) goto L7;
            f.a r100 = this.f490321b.f490318b;     // Catch: Throwable -> L11
            if (r100 == null) goto L16;
            r100.onError();     // Catch: Throwable -> L11
        L16:
            return;
        L7:
            f.a r101 = this.f490321b.f490318b;     // Catch: Throwable -> L11
            if (r101 == null) goto L16;
            r101.onSuccess(this.f490320a);     // Catch: Throwable -> L11
            goto L16
        }

        public a(d r100, String r101) {
            this.f490321b = r100;
            this.f490320a = r101;
        }
    }

    public final void a() {
        f r100 = this.f490319c;
        String r101 = this.f490317a;
        r100.getClass();
        String r102 = f.b(r101);
        f r103 = this.f490319c;
        String r104 = this.f490317a;
        String r105 = (String) ((HashMap) r103.f490330b).get(r102);
        if (r105 != null) goto L5;
    L7:
        String r106 = f.b(r104);
        StringBuilder r107 = new StringBuilder();
        String r110 = f.f490328e;
        r107.append(r110);
        r107.append(r106);
        String r111 = r107.toString();
        PolarisFileWrapper r108 = new PolarisFileWrapper(r111);
        if (r108.exists() == true) goto L10;
    L16:
        rk7.m.f538361o.e();
        if (((ConcurrentHashMap) r103.f490331c).get(r102) != null) goto L40;
        ((ConcurrentHashMap) r103.f490331c).put(r102, r111);
        String r112 = r111;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ImagePreloadManager", "loadImage, url: " + r104 + ", picDir: " + r110 + ", download result: " + RetrofitUtils.downloadFile(4194304, r104, r110, null, r106, null, r104.hashCode() + "", null, null, null, null));     // Catch: Exception -> L23 Throwable -> L25
    L33:
        ((ConcurrentHashMap) r103.f490331c).remove(r102);
        String r109 = r112;
        if (new PolarisFileWrapper(r109).isFile() == false) goto L40;
    L36:
        r105 = r109;
    L41:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ImagePreloadManager", "downloadImage, key= " + r102 + ", imagePath= " + r105);
        this.f490319c.f490329a.post(new a(this, r105));
        return;
    L23:
        e = e;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L37
    L30:
        e = e;
        r112 = r111;
    L25:
        th = move-exception;
        if ((th instanceof OutOfMemoryError) == false) goto L29;
        System.gc();     // Catch: Throwable -> L37
    L29:
        ((ConcurrentHashMap) r103.f490331c).remove(r102);
    L37:
        th = move-exception;
        ((ConcurrentHashMap) r103.f490331c).remove(r102);
        throw th;
    L40:
        r105 = null;
        goto L41
    L10:
        if (r108.isFile() == false) goto L16;
        if (((ConcurrentHashMap) r103.f490331c).get(r102) != null) goto L16;
        if (r108.length() <= 0) goto L16;
        ((HashMap) r103.f490330b).put(r102, r111);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ImagePreloadManager", "loadImage, url: " + r104 + ", file exist: " + r111);
        r109 = r111;
        goto L36
    L5:
        if (new PolarisFileWrapper(r105).isFile() == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ImagePreloadManager", "loadImage, url: " + r104 + ", already downloaded: " + r105);
        goto L41
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

    public d(f r100, String r101, f.a r102) {
        this.f490319c = r100;
        this.f490317a = r101;
        this.f490318b = r102;
    }
}
