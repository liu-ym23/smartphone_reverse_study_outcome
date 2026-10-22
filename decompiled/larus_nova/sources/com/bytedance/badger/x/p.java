package com.bytedance.badger.x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.security.keystore.KeyGenParameterSpec;
import com.alipay.sdk.m.n.d;
import com.bm.badgervi.b;
import com.bytedance.badger.BadgerCore;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import el9.a;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile D f199394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static o f199395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f199396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f199397d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f199398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f199399f;

    static {
        f199397d = new n();
    }

    public static boolean e(String r100) {
        KeyStore r101 = KeyStore.getInstance(f199399f);     // Catch: Exception -> L7
        r101.load(null);     // Catch: Exception -> L7
        if (r101.getCertificate(r100) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        com.bytedance.badger.e.e("DeviceFp1", "hasAskProvider exception: " + e.getMessage());
        return false;
    }

    public static String f() {
        BadgerCore.Companion.getClass();
        if (e(com.bytedance.badger.j.b(1765516356418565358L)) == true) goto L5;
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(com.bytedance.badger.j.b(7079072508190704276L), f199399f);
        r100.initialize(new KeyGenParameterSpec.Builder(com.bytedance.badger.j.b(6610488371976417976L), 16).setDigests(new String[]{"SHA-256"}).setSignaturePaddings(new String[]{"PSS"}).build());
        r100.generateKeyPair();
    L5:
        KeyStore r101 = KeyStore.getInstance(f199399f);
        r101.load(null);
        return JSONObjectProtectorUtils.getString(new JSONObject(new String(b.h((X509Certificate) r101.getCertificate(com.bytedance.badger.j.b(1765516356418565358L))))), com.bytedance.badger.j.b(3852863012899441828L));
    }

    public static String g() {
        if (h() == false) goto L28;
        boolean r100 = true;
        if (f199399f.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN).length > 1) goto L8;
        r100 = false;
    L8:
        BadgerCore.Companion.getClass();
        String r101 = com.bytedance.badger.j.b(6652161667115517076L);
        KeyStore r102 = KeyStore.getInstance(f199399f);
        r102.load(null);
        if (e(r101) == true) goto L15;
        String r103 = com.bytedance.badger.j.b(5819945665527921280L);
        if (r100 == false) goto L13;
        r103 = f199399f;
        int r104 = 16;
    L14:
        KeyPairGenerator r105 = KeyPairGenerator.getInstance(d.f25615a, r103);
        r105.initialize(new KeyGenParameterSpec.Builder(r101 + com.bytedance.badger.j.b(9130210732707849621L), r104).setDigests(new String[]{"SHA-256"}).setSignaturePaddings(new String[]{"PSS"}).build());
        r105.generateKeyPair();
        goto L15
    L13:
        r104 = 4;
    L15:
        if (r100 == false) goto L22;
        Certificate[] r106 = r102.getCertificateChain(r101);
        if (r106 != null) goto L19;
    L26:
        return null;
    L19:
        if (r106.length <= 0) goto L26;
        return JSONObjectProtectorUtils.getString(b.e((X509Certificate) r106[0]), com.bytedance.badger.j.b(3852863012899441828L));
    L22:
        Key r107 = r102.getKey(r101, com.bytedance.badger.j.b(7897631484142453971L).toCharArray());
        if (r107 == null) goto L26;
        return c(r107.getEncoded());
    L28:
        throw new Exception(" provider not found");
    }

    public static boolean h() {
        if (f199398e == true) goto L5;
        i();
    L5:
        Provider[] r100 = Security.getProviders();
        if (r100 != null) goto L9;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: no provider supported");
        return false;
    L9:
        int r101 = r100.length;
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L18;
        String r103 = r100[r102].getName();
        if (r103 == null) goto L17;
        BadgerCore.Companion.getClass();
        if (r103.startsWith(com.bytedance.badger.j.b(5819945665527921280L)) == false) goto L17;
        com.bytedance.badger.e.f("DeviceFp1", "dfp1: found provider:".concat(r103));
        f199399f = r103;
        return true;
    L17:
        r102 = r102 + 1;
        goto L10
    L18:
        com.bytedance.badger.e.f("DeviceFp1", "dfp1: provider not found");
        return false;
    }

    public static void i() {
        BadgerCore.Companion.getClass();     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        Class r100 = a(com.bytedance.badger.j.b(7391467690378216735L));     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        com.bytedance.badger.e.f("DeviceFp1", "dfp1 provider: " + r100);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        Method r101 = r100.getMethod(com.bytedance.badger.j.b(2478331542442269988L), new Class[0]);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        r101.setAccessible(true);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
        r101.invoke(null, new Object[0]);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L8 NoSuchMethodException -> L9 ClassNotFoundException -> L10
    L12:
        f199398e = true;
        return;
    L5:
        th = move-exception;
        f199398e = true;
        throw th;
    L10:
        String r102 = "dfp1: no DeviceFp1Provider found";
    L11:
        com.bytedance.badger.e.f("DeviceFp1", r102);     // Catch: Throwable -> L5
    L8:
        r102 = "dfp1: cannot access";
    L9:
        r102 = "dfp1: function not found";
    L7:
        r102 = "dfp1: InvocationTargetException";
        goto L11
    }

    public static String b() {
        if (f199394a.c(0) == true) goto L5;
        f199394a.b(0);
    L5:
        A r100 = f199394a.d(0);
        if (r100 != null) goto L8;
    L28:
        return "";
    L8:
        if (r100.f199359a != 0) goto L28;
        byte[] r101 = r100.f199360b;
        byte[] r102 = new byte[4];
        System.arraycopy(r101, 0, r102, 0, 4);
        int r103 = 0;
        int r104 = 0;
    L11:
        if (r103 >= 4) goto L13;
        r104 = r104 + ((r102[r103] & 255) << (r103 * 8));
        r103 = r103 + 1;
        goto L11
    L13:
        byte[] r105 = new byte[r104];
        if (r101.length >= (r104 + 4)) goto L16;
        return "";
    L16:
        System.arraycopy(r101, 4, r105, 0, r104);
        JSONObject r106 = new JSONObject(new String(r105));
        BadgerCore.Companion.getClass();
        if (r106.has(com.bytedance.badger.j.b(1859995745272754240L)) == true) goto L27;
        if (r106.has(com.bytedance.badger.j.b(5910110494103413445L)) == false) goto L22;
        String r107 = JSONArrayProtectorUtils.getString(JSONObjectProtectorUtils.getJSONArray(r106, com.bytedance.badger.j.b(5910110494103413445L)), 0);
    L23:
        if (r107 != null) goto L25;
        return "";
    L25:
        r106 = new JSONObject(new String(b.h((X509Certificate) CertificateFactory.getInstance(com.bytedance.badger.j.b(939243110723885964L)).generateCertificate(new ByteArrayInputStream(r107.getBytes())))));
        goto L27
    L22:
        r107 = "";
    L27:
        return JSONObjectProtectorUtils.getString(r106, com.bytedance.badger.j.b(3852863012899441828L));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String c(byte[] r100) {
        if (r100 != null) goto L5;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: raw data is null");
        throw new IllegalArgumentException("raw data is null");
    L5:
        if (r100.length >= 4) goto L7;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: raw data length smaller than RAW_LENGTH_PREFIX");
    L7:
        byte[] r101 = new byte[4];
        System.arraycopy(r100, 0, r101, 0, 4);
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r102 >= 4) goto L11;
        r103 = r103 + ((r101[r102] & 255) << (r102 * 8));
        r102 = r102 + 1;
        goto L8
    L11:
        if (r103 > 1048576) goto L32;
        byte[] r104 = new byte[r103];
        if (r100.length < (r103 + 4)) goto L30;
        System.arraycopy(r100, 4, r104, 0, r103);
        JSONObject r105 = new JSONObject(new String(r104));     // Catch: Exception -> L27
        BadgerCore.Companion.getClass();     // Catch: Exception -> L27
        String r106 = com.bytedance.badger.j.b(5910110494103413445L);     // Catch: Exception -> L27
        if (r105.has(r106) == false) goto L26;
        JSONArray r107 = r105.optJSONArray(r106);     // Catch: Exception -> L27
        if (r107 != null) goto L20;
    L23:
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: array size too small");     // Catch: Exception -> L27
        throw new IllegalArgumentException("certs size too small");     // Catch: Exception -> L27
    L20:
        if (r107.length() < 2) goto L23;
        return JSONObjectProtectorUtils.getString(b.e((X509Certificate) CertificateFactory.getInstance(com.bytedance.badger.j.b(939243110723885964L)).generateCertificate(new ByteArrayInputStream(r107.optString(0).getBytes()))), com.bytedance.badger.j.b(3852863012899441828L));
    L26:
        return r105.optString(com.bytedance.badger.j.b(3852863012899441828L));
    L27:
        e = move-exception;
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: to convert json exception: " + e.getMessage());
        throw e;
    L30:
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: length not correct 2");
        throw new IllegalArgumentException("length not correct 2");
    L32:
        com.bytedance.badger.e.e("DeviceFp1", "dfp1: too large json result!");
        throw new IllegalArgumentException("too large json result!");
    }

    public static boolean d(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        Intent r102 = new Intent();
        com.bytedance.badger.j r103 = BadgerCore.Companion;
        r103.getClass();
        String r104 = com.bytedance.badger.j.b(8129550834698778238L);
        r103.getClass();
        r102.setComponent(new ComponentName(r104, com.bytedance.badger.j.b(1078607345834032513L)));
        return !r101.queryIntentServices(r102, 0).isEmpty();
    }
}
