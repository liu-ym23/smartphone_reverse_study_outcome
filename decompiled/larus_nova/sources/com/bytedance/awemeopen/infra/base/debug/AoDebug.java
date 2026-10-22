package com.bytedance.awemeopen.infra.base.debug;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.util.f;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes46.dex */
public final class AoDebug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AoDebug f198589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f198590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f198591c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f198592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f198593e;

    public AoDebug() {
    }

    static {
        f198589a = new AoDebug();
        f198590b = LazyKt.lazy(AoDebug$aoHostService$2.INSTANCE);
        f198591c = LazyKt.lazy(AoDebug$aoLogService$2.INSTANCE);
        f198592d = -1;
    }

    @JvmStatic
    public static final boolean b() {
        if (f198592d != (-1)) goto L24;
        AoDebug r100 = f198589a;
        r100.getClass();
        boolean r101 = ((AoHostService) f198590b.getValue()).hostIsDebug();
        BdpManager.getInst().setDebugMode(r101);
        if (r101 == false) goto L8;
        f198592d = 1;
        return true;
    L8:
        r100.getClass();
        if (f198593e == true) goto L24;
        monitor-enter(AoDebug.class);
    L20:
        th = move-exception;
        throw th;
    L14:
        if (f198593e == false) goto L17;
        monitor-exit(AoDebug.class);
        goto L24
    L17:
        f198593e = true;     // Catch: Throwable -> L20
        AoPool.a(AoDebug$checkDebugFileExistAsync$1$1.INSTANCE);     // Catch: Throwable -> L20
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(AoDebug.class);
    L24:
        if (f198592d == 1) goto L30;
        return false;
    L30:
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        if (b() == false) goto L5;
    L8:
        return true;
    L5:
        if (AoEnv.i() == true) goto L8;
        return false;
    }

    public static boolean a(String r100) {
        PKCS8EncodedKeySpec r101 = new PKCS8EncodedKeySpec(f.c(r100));     // Catch: Throwable -> L5
        PrivateKey r102 = KeyFactory.getInstance(d.f25615a).generatePrivate(r101);     // Catch: Throwable -> L5
        Signature r103 = Signature.getInstance("MD5withRSA");     // Catch: Throwable -> L5
        r103.initSign(r102);     // Catch: Throwable -> L5
        Charset r104 = Charsets.UTF_8;     // Catch: Throwable -> L5
        r103.update("hello bdp debug".getBytes(r104));     // Catch: Throwable -> L5
        byte[] r105 = r103.sign();     // Catch: Throwable -> L5
        X509EncodedKeySpec r106 = new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKUjAAuFnt+qL1wJkAffJRTrBSAnCf/n4aoLPgpq4BjyWaWzxeXVUwhKadPFjNePa6P5v7jmvZVejvLTq77HlqkCAwEAAQ==", 0));     // Catch: Throwable -> L5
        PublicKey r107 = KeyFactory.getInstance(d.f25615a).generatePublic(r106);     // Catch: Throwable -> L5
        Signature r108 = Signature.getInstance("MD5withRSA");     // Catch: Throwable -> L5
        r108.initVerify(r107);     // Catch: Throwable -> L5
        r108.update("hello bdp debug".getBytes(r104));     // Catch: Throwable -> L5
        return r108.verify(r105);
    L5:
        th = move-exception;
        ((AoLogService) f198591c.getValue()).e("AoDebug", th.toString());
        return false;
    }
}
