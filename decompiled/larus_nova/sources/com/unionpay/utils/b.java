package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f462195a = null;

    static {
        f462195a = new c();
    }

    public static String b(InputStream r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[2048];
    L12:
        int r103 = r100.read(r102);     // Catch: Throwable -> L11
        if (r103 <= 0) goto L9;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L11
        goto L12
    L9:
        return r101.toString("UTF-8");
    L15:
        return null;
    }

    public static String c(Context r100, String r101, String r102) {
        String r103 = null;
        if (r100 != null) goto L62;
        PackageManager r104 = null;
    L7:
        if (r104 != null) goto L60;
    L13:
        PackageInfo r105 = null;
    L14:
        if (r105 == null) goto L56;
        Signature[] r106 = r105.signatures;     // Catch: Exception -> L57
        if (r106 == null) goto L56;
        if (r106.length <= 0) goto L56;
        int r107 = 0;
        Signature r108 = r106[0];     // Catch: Exception -> L57
        if (r108 == null) goto L56;
        ByteArrayInputStream r109 = new ByteArrayInputStream(r108.toByteArray());     // Catch: Exception -> L57
        CertificateFactory r110 = CertificateFactory.getInstance("X509");     // Catch: CertificateException -> L24 Exception -> L57
    L27:
        if (r110 != null) goto L64;
    L32:
        X509Certificate r111 = null;
    L66:
        MessageDigest r112 = MessageDigest.getInstance(r102);     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
        if (r111 == null) goto L53;
        byte[] r113 = r112.digest(r111.getEncoded());     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
        StringBuilder r114 = new StringBuilder(r113.length * 2);     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
    L37:
        if (r107 >= r113.length) goto L47;
        String r115 = Integer.toHexString(r113[r107]);     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
        int r116 = r115.length();     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
        if (r116 != 1) goto L41;
        r115 = "0".concat(r115);     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
    L41:
        if (r116 <= 2) goto L43;
        r115 = r115.substring(r116 - 2, r116);     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
    L43:
        r114.append(r115.toUpperCase());     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
        if (r107 >= (r113.length - 1)) goto L46;
        r114.append(':');     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
    L46:
        r107 = r107 + 1;     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
        goto L37
    L47:
        r103 = r114.toString();     // Catch: CertificateEncodingException -> L49 NoSuchAlgorithmException -> L51 Exception -> L57
    L53:
        if (r103 == null) goto L56;
        return r103.replaceAll(":", "");
    L51:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L57
    L49:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L57
        goto L53
    L64:
        r111 = (X509Certificate) r110.generateCertificate(r109);     // Catch: CertificateException -> L30 Exception -> L57
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L57
        goto L32
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L57
        r110 = null;
    L56:
        return "";
    L60:
        r105 = r104.getPackageInfo(r101, 64);     // Catch: PackageManager.NameNotFoundException -> L11 Exception -> L57
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L57
        goto L13
    L62:
        r104 = r100.getPackageManager();     // Catch: Exception -> L57
        goto L7
    }

    public static String d(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        char[] r101 = "0123456789ABCDEF".toCharArray();
        StringBuilder r102 = new StringBuilder("");
        byte[] r103 = r100.getBytes();
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L9;
        byte r106 = r103[r105];
        r102.append(r101[(r106 & 240) >> 4]);
        r102.append(r101[r106 & 15]);
        r105 = r105 + 1;
        goto L6
    L9:
        return r102.toString().trim();
    }

    public static String a(Context r100) {
        String r101 = UPUtils.a(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        String r102 = UPUtils.a(r100, "mode");
        String r103 = UPUtils.a(r100, SRStrategy.KEY_ORIGIN_RESOLUTION);
        int r104 = 0;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L29:
        String r105 = "";
    L43:
        JSONArray r106 = new JSONArray(r105);     // Catch: Exception -> L41
        int r107 = r106.length();
    L32:
        if (r104 >= r107) goto L40;
        Object r108 = g.a(r106, r104);
        if (r108 == null) goto L39;
        JSONObject r109 = (JSONObject) r108;
        if ("app".equals(g.b(r109, "type")) == false) goto L39;
        return new String(Base64.decode(g.b(r109, "ca"), 2));
    L39:
        r104 = r104 + 1;
    L40:
        return "";
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L29;
        if (TextUtils.isEmpty(r103) == true) goto L29;
        JSONObject r110 = new JSONObject(r101);     // Catch: Exception -> L42
        String r111 = g.b(r110, "sign");     // Catch: Exception -> L42
        int r112 = CastIntegerProtector.parseInt(r102);     // Catch: Exception -> L11
    L12:
        r105 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r110, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY), 2));     // Catch: Exception -> L42
        if (r110.has("sePayConf") == false) goto L15;
        String r113 = new String(Base64.decode(JSONObjectProtectorUtils.getString(r110, "sePayConf"), 2));     // Catch: Exception -> L42
    L17:
        if (TextUtils.isEmpty(r113) == false) goto L19;
        r113 = "";
    L19:
        String r114 = d(UPUtils.b(r105 + r113 + r103));     // Catch: Exception -> L42
        String r115 = UPUtils.c(UPUtils.forConfig(r112, r111));     // Catch: Throwable -> L22
    L25:
        if (TextUtils.isEmpty(r115) == true) goto L29;
        if (r115.equals(r114) == false) goto L29;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L42
        r115 = null;
        goto L25
    L15:
        r113 = "";
    L11:
        r112 = 0;
        goto L12
    }
}
