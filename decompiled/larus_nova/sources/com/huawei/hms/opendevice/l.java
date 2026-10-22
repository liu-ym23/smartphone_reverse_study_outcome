package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import com.larus.nova.R;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277544a = "l";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, String> f277545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277546c = null;

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    static {
        f277545b = new HashMap();
        f277546c = new Object();
    }

    private static String c() {
        return a("d");
    }

    private static String d() {
        return a("m");
    }

    private static String e() {
        return a("p");
    }

    private static String f() {
        return a("s");
    }

    private static String g() {
        return a("t");
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    private static RootKeyUtil h() {
        return RootKeyUtil.newInstance(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static byte[] a(Context r100) {
        byte[] r101 = d.a(r100.getString(R.string.push_cat_head));
        byte[] r102 = d.a(r100.getString(R.string.push_cat_body));
        byte[] r103 = d.a(a());
        return a(a(a(r101, r102), r103));
    }

    public static String b(Context r100) {
        if (i() == true) goto L5;
        HMSLog.i(f277544a, "work key is empty, execute init.");
        c(r100);
    L5:
        String r101 = WorkKeyCryptUtil.decryptWorkKey(f(), b());
        if (n.a(new String[]{r101}) == false) goto L9;
        return r101;
    L9:
        return e(r100);
    }

    public static void c(Context r110) {
        Object r100 = f277546c;
        monitor-enter(r100);
        d(r110.getApplicationContext());     // Catch: Throwable -> L15
        if (i() == false) goto L9;
        HMSLog.i(f277544a, "The local secret is already in separate file mode.");     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L9:
        PolarisFileWrapper r101 = new PolarisFileWrapper(e.c(r110.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");     // Catch: Throwable -> L15
        if (r101.exists() == false) goto L12;
        IOUtil.deleteSecure(r101);     // Catch: Throwable -> L15
        HMSLog.i(f277544a, "destroy C, delete file LocalAvengers.xml.");     // Catch: Throwable -> L15
    L12:
        byte[] r102 = EncryptUtil.generateSecureRandom(32);     // Catch: Throwable -> L15
        byte[] r103 = EncryptUtil.generateSecureRandom(32);     // Catch: Throwable -> L15
        byte[] r104 = EncryptUtil.generateSecureRandom(32);     // Catch: Throwable -> L15
        byte[] r105 = EncryptUtil.generateSecureRandom(32);     // Catch: Throwable -> L15
        String r106 = d.a(r102);     // Catch: Throwable -> L15
        String r107 = d.a(r103);     // Catch: Throwable -> L15
        String r108 = d.a(r104);     // Catch: Throwable -> L15
        String r109 = d.a(r105);     // Catch: Throwable -> L15
        a(r106, r107, r108, r109, WorkKeyCryptUtil.encryptWorkKey(d.a(EncryptUtil.generateSecureRandom(32)), a(r106, r107, r108, r109)), r110);     // Catch: Throwable -> L15
        HMSLog.i(f277544a, "generate D.");     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static void d(Context r100) {
        if (i() == false) goto L6;
        HMSLog.i(f277544a, "secretKeyCache not empty.");
        return;
    L6:
        f277545b.clear();
        String r101 = e.c(r100);
        if (TextUtils.isEmpty(r101) == true) goto L12;
        String r102 = m.a(r101 + "/files/math/m");
        String r103 = m.a(r101 + "/files/panda/p");
        String r104 = m.a(r101 + "/files/panda/d");
        String r105 = m.a(r101 + "/files/math/t");
        String r106 = m.a(r101 + "/files/s");
        if (n.a(new String[]{r102, r103, r104, r105, r106}) == false) goto L13;
        f277545b.put("m", r102);
        f277545b.put("p", r103);
        f277545b.put("d", r104);
        f277545b.put("t", r105);
        f277545b.put("s", r106);
        return;
    L13:
        return;
    }

    private static synchronized String e(Context r110) {
        monitor-enter(l.class);
        String r100 = WorkKeyCryptUtil.decryptWorkKey(f(), b());     // Catch: Throwable -> L22
        if (n.a(new String[]{r100}) == false) goto L9;
        HMSLog.i(f277544a, "keyS has been upgraded, no require operate again.");     // Catch: Throwable -> L22
        monitor-exit(l.class);
        return r100;
    L9:
        String r101 = WorkKeyCryptUtil.decryptWorkKey(f(), h());     // Catch: Throwable -> L22
        if (n.a(new String[]{r101}) == false) goto L14;
        HMSLog.i(f277544a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");     // Catch: Throwable -> L22
        a(WorkKeyCryptUtil.encryptWorkKey(r101, b()), r110);     // Catch: Throwable -> L22
        monitor-exit(l.class);
        return r101;
    L14:
        String r102 = WorkKeyCryptUtil.decryptWorkKey(f(), BaseKeyUtil.exportRootKey(d(), e(), c(), g(), 32, false));     // Catch: Throwable -> L22
        if (n.a(new String[]{r102}) == false) goto L19;
        HMSLog.i(f277544a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");     // Catch: Throwable -> L22
        a(WorkKeyCryptUtil.encryptWorkKey(r102, b()), r110);     // Catch: Throwable -> L22
        monitor-exit(l.class);
        return r102;
    L19:
        HMSLog.e(f277544a, "all mode unable to decrypt root key.");     // Catch: Throwable -> L22
        monitor-exit(l.class);
        return "";
    L22:
        th = move-exception;
        throw th;
    }

    private static byte[] a(byte[] r100) {
        int r101 = 0;
        if (r100 == null) goto L12;
        if (r100.length == 0) goto L12;
    L8:
        if (r101 >= r100.length) goto L10;
        r100[r101] = (byte) (r100[r101] >> 2);
        r101 = r101 + 1;
        goto L8
    L10:
        return r100;
    L12:
        return new byte[0];
    }

    private static String a(String r100) {
        String r101 = f277545b.get(r100);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "";
    L6:
        return r101;
    }

    private static void a(String r100, Context r101) {
        String r102 = e.c(r101.getApplicationContext());
        if (TextUtils.isEmpty(r102) == true) goto L10;
        a("s", r100, r102 + "/files/s");     // Catch: IOException -> L6
        return;
    L6:
        HMSLog.e(f277544a, "save keyS IOException.");
        return;
    }

    private static byte[] a(byte[] r100, byte[] r101) {
        int r102 = 0;
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        if (r100.length == 0) goto L19;
        if (r101.length == 0) goto L19;
        int r103 = r100.length;
        if (r103 != r101.length) goto L13;
        byte[] r104 = new byte[r103];
    L15:
        if (r102 >= r103) goto L17;
        r104[r102] = (byte) (r100[r102] ^ r101[r102]);
        r102 = r102 + 1;
        goto L15
    L17:
        return r104;
    L13:
        return new byte[0];
    L19:
        return new byte[0];
    }

    private static void a(String r100, String r101, String r102) throws IOException {
        HMSLog.i(f277544a, "save local secret key.");
        BufferedWriter r103 = null;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102);     // Catch: Throwable -> L12
        m.a(r104);     // Catch: Throwable -> L12
        OutputStreamWriter r105 = new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r104), "UTF-8");     // Catch: Throwable -> L12
        BufferedWriter r106 = new BufferedWriter(r105);     // Catch: Throwable -> L10
        r106.write(r101);     // Catch: Throwable -> L8
        r106.flush();     // Catch: Throwable -> L8
        f277545b.put(r100, r101);     // Catch: Throwable -> L8
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r106);
        return;
    L8:
        th = th;
        r103 = r106;
    L14:
        IOUtils.closeQuietly(r105);
        IOUtils.closeQuietly(r103);
        throw th;
    L10:
        th = th;
    L12:
        th = th;
        r105 = null;
        goto L14
    }

    private static byte[] a(String r100, String r101, String r110, String r111) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return BaseKeyUtil.exportRootKey(r100, r101, r110, r111, 32, true);
    L6:
        return BaseKeyUtil.exportRootKey(r100, r101, r110, r111, 32, false);
    }

    private static void a(String r100, String r101, String r102, String r103, String r104, Context r105) {
        String r106 = e.c(r105.getApplicationContext());
        if (TextUtils.isEmpty(r106) == true) goto L10;
        a("m", r100, r106 + "/files/math/m");     // Catch: IOException -> L6
        a("p", r101, r106 + "/files/panda/p");     // Catch: IOException -> L6
        a("d", r102, r106 + "/files/panda/d");     // Catch: IOException -> L6
        a("t", r103, r106 + "/files/math/t");     // Catch: IOException -> L6
        a("s", r104, r106 + "/files/s");     // Catch: IOException -> L6
        return;
    L6:
        HMSLog.e(f277544a, "save key IOException.");
        return;
    }
}
