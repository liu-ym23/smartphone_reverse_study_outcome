package q94;

import android.app.Application;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.f;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import g94.b;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f532095a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f532096b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f532097c;

    public a() {
    }

    public static boolean b() {
        if (f532097c != (-1)) goto L17;
        monitor-enter(a.class);
        boolean r100 = c(((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication());     // Catch: Throwable -> L13
        BdpManager.getInst().setDebugMode(r100);     // Catch: Throwable -> L13
        if (r100 == false) goto L9;
        int r101 = 1;
    L10:
        f532097c = r101;     // Catch: Throwable -> L13
        b.d("DebugUtil", new Object[]{"Debug:", Boolean.valueOf(r100)});     // Catch: Throwable -> L13
        monitor-exit(a.class);     // Catch: Throwable -> L13
        goto L17
    L9:
        r101 = 0;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (f532097c != 1) goto L22;
        return true;
    L22:
        return false;
    }

    static {
        boolean r100 = true;
        if (b() == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        f532095a = r101;
        if (b() == false) goto L12;
    L15:
        f532096b = r100;
        f532097c = -1;
        return;
    L12:
        if (b.c().isLocalTest() == true) goto L15;
        r100 = false;
        goto L15
    L5:
        if (b.c().isLocalTest() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean a(String r100) {
        PrivateKey r101 = KeyFactory.getInstance(d.f25615a).generatePrivate(new PKCS8EncodedKeySpec(f.e(r100)));     // Catch: Throwable -> L5
        Signature r102 = Signature.getInstance("MD5withRSA");     // Catch: Throwable -> L5
        r102.initSign(r101);     // Catch: Throwable -> L5
        r102.update("hello bdp debug".getBytes());     // Catch: Throwable -> L5
        byte[] r103 = r102.sign();     // Catch: Throwable -> L5
        PublicKey r104 = KeyFactory.getInstance(d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKUjAAuFnt+qL1wJkAffJRTrBSAnCf/n4aoLPgpq4BjyWaWzxeXVUwhKadPFjNePa6P5v7jmvZVejvLTq77HlqkCAwEAAQ==", 0)));     // Catch: Throwable -> L5
        Signature r105 = Signature.getInstance("MD5withRSA");     // Catch: Throwable -> L5
        r105.initVerify(r104);     // Catch: Throwable -> L5
        r105.update("hello bdp debug".getBytes());     // Catch: Throwable -> L5
        return r105.verify(r103);
    L5:
        th = move-exception;
        b.b("DebugUtil", new Object[]{th.toString()});
        return false;
    }

    public static boolean c(Application r100) {
        boolean r101 = ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).isDebugMode();
        BdpManager.getInst().setDebugMode(r101);
        if (r101 == false) goto L13;
        return true;
    L13:
        PolarisFileWrapper r102 = new PolarisFileWrapper((r100.getExternalCacheDir() + HTTP.URL_DEFAULT) + "debug.flag");     // Catch: Throwable -> L10
        if (r102.exists() == false) goto L12;
        b.d("DebugUtil", new Object[]{"debug.flag exists"});     // Catch: Throwable -> L10
        return a(r102.getAbsolutePath());
    L12:
        return false;
    L10:
        th = move-exception;
        b.b("DebugUtil", new Object[]{"shouldDebug", th.getStackTrace()});
        goto L12
    }
}
