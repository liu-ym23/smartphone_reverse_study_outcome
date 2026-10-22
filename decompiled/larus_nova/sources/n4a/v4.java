package n4a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Set;
import kotlin.UByte;

/* JADX INFO: loaded from: classes32.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f517831a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f517832b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f517833c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f517834d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f517835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f517836f;

    public class a extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f517837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f517838c;

        public a(Context r100, String r101) {
            this.f517837b = r100;
            this.f517838c = r101;
        }

        @Override // n4a.l1
        public final void a() {
            PolarisFileOutputStreamWrapper r100 = null;
            PolarisFileWrapper r101 = new PolarisFileWrapper(p.c(this.f517837b, "k.store"));     // Catch: Throwable -> L15
            if (r101.getParentFile().exists() == true) goto L6;
            r101.getParentFile().mkdirs();     // Catch: Throwable -> L15
        L6:
            PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L15
            r102.write(f5.j(this.f517838c));     // Catch: Throwable -> L13
            r102.close();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        L13:
            th = move-exception;
            th = th;
            r100 = r102;
        L40:
            n.a(th, "AI", "stf");     // Catch: Throwable -> L23
            if (r100 == null) goto L42;
            r100.close();     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
            return;
        L42:
            return;
        L23:
            th = move-exception;
            if (r100 != null) goto L32;
        L29:
            throw th;
        L32:
            r100.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.printStackTrace();
        L15:
            th = th;
            goto L40
        }
    }

    public static boolean a() {
        if (f517836f == false) goto L7;
        return true;
    L7:
        if (c(f517835e) == false) goto L11;
        f517836f = true;     // Catch: Throwable -> L23
        return true;
    L11:
        if (TextUtils.isEmpty(f517835e) == true) goto L15;
        f517836f = false;     // Catch: Throwable -> L23
        f517835e = null;     // Catch: Throwable -> L23
        return false;
    L15:
        if (c(f517832b) == false) goto L19;
        f517836f = true;     // Catch: Throwable -> L23
        return true;
    L19:
        if (TextUtils.isEmpty(f517832b) == true) goto L22;
        f517836f = false;     // Catch: Throwable -> L23
        f517832b = null;     // Catch: Throwable -> L23
        return false;
    L22:
        return true;
    }

    public static String b(Context r100) {
    L8:
        th = move-exception;
        n.a(th, "AI", "gAN");
    L11:
        return f517831a;
    L3:
        if ("".equals(f517831a) == false) goto L5;
        PackageManager r101 = r100.getPackageManager();     // Catch: Throwable -> L8
        f517831a = (String) r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 0));     // Catch: Throwable -> L8
        goto L11
    L5:
        return f517831a;
    }

    public static String d(Context r100) {
        String r101 = f517832b;     // Catch: Throwable -> L12
        if (r101 != null) goto L5;
    L8:
        String r102 = r100.getPackageName();     // Catch: Throwable -> L12
        f517832b = r102;     // Catch: Throwable -> L12
        if (c(r102) == true) goto L15;
        f517832b = r100.getPackageName();     // Catch: Throwable -> L12
    L15:
        return f517832b;
    L5:
        if ("".equals(r101) == true) goto L8;
        return f517832b;
    L12:
        th = move-exception;
        n.a(th, "AI", "gpck");
        goto L15
    }

    public static String e(Context r100) {
    L9:
        th = move-exception;
        n.a(th, "AI", "gAV");
    L11:
        String r101 = f517833c;
        if (r101 != null) goto L14;
        return "";
    L14:
        return r101;
    L4:
        if ("".equals(f517833c) == false) goto L6;
        f517833c = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: Throwable -> L9
        goto L11
    L6:
        return f517833c;
    }

    public static String f(Context r100) {
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64);     // Catch: Throwable -> L18
        int r102 = 0;
        byte[] r103 = r101.signatures[0].toByteArray();     // Catch: Throwable -> L18
        byte[] r104 = MessageDigest.getInstance(f5.o("IU0hBMQ")).digest(r103);     // Catch: Throwable -> L18
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L18
    L4:
        if (r102 >= r104.length) goto L9;
        String r106 = Integer.toHexString(r104[r102] & UByte.MAX_VALUE).toUpperCase(Locale.US);     // Catch: Throwable -> L18
        if (r106.length() != 1) goto L8;
        r105.append("0");     // Catch: Throwable -> L18
    L8:
        r105.append(r106);     // Catch: Throwable -> L18
        r105.append(":");     // Catch: Throwable -> L18
        r102 = r102 + 1;     // Catch: Throwable -> L18
        goto L4
    L9:
        String r107 = r101.packageName;     // Catch: Throwable -> L18
        if (c(r107) == false) goto L13;
        r107 = r101.packageName;     // Catch: Throwable -> L18
    L13:
        if (TextUtils.isEmpty(f517832b) == true) goto L16;
        r107 = d(r100);     // Catch: Throwable -> L18
    L16:
        r105.append(r107);     // Catch: Throwable -> L18
        String r108 = r105.toString();     // Catch: Throwable -> L18
        f517835e = r108;     // Catch: Throwable -> L18
        return r108;
    L18:
        th = move-exception;
        n.a(th, "AI", "gsp");
        return f517835e;
    }

    public static boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L32;
        r100.toCharArray();
        char[] r101 = r100.toCharArray();
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L31;
        char r104 = r101[r103];
        if ('A' > r104) goto L12;
        if (r104 > 'z') goto L12;
    L30:
        r103 = r103 + 1;
    L12:
        if ('0' > r104) goto L16;
        if (r104 <= ':') goto L30;
    L16:
        if (r104 == '.') goto L30;
        String[] r105 = f5.f517286a;     // Catch: Throwable -> L33
        e5.a r106 = new e5.a("collection", "1.0", "AMap_collection_1.0");     // Catch: Throwable -> L33
        r106.f517273e = (String[]) new String[]{"com.amap.api.collection"}.clone();     // Catch: Throwable -> L33
        e5 r107 = r106.a();     // Catch: Throwable -> L33
        Set<Integer> r108 = r.f517629e;     // Catch: Throwable -> L33
        r r109 = n.f517542c;     // Catch: Throwable -> L33
        if (r109 == null) goto L29;
        Context r110 = r109.f517630d;     // Catch: Throwable -> L33
        if (r107.f517261c != 1) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L29;
        t.b(r110, r107, 1, "errorPackage", r100);     // Catch: Throwable -> L33
        goto L29
    L25:
        r112 = false;
        goto L26
    L22:
        r111 = false;
    L29:
        return false;
    L31:
        return true;
    L32:
        return false;
    }

    public static String g(Context r100) {
        int r101 = com.loc.i.f380094a;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        com.loc.i.f380096c = r100.getApplicationContext();     // Catch: Throwable -> L10
    L13:
        return h(r100);
    L7:
        th = move-exception;
        n.a(th, "AI", "gKy");
        return f517834d;
    }

    public static String h(Context r100) throws PackageManager.NameNotFoundException {
        String r101 = f517834d;
        String r102 = "";
        if (r101 != null) goto L5;
    L6:
        ApplicationInfo r103 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);
        if (r103 == null) goto L49;
        Bundle r104 = r103.metaData;
        if (r104 == null) goto L49;
        String r105 = r104.getString("com.amap.api.v2.apikey");
        f517834d = r105;
        if (r105 != null) goto L47;
        PolarisFileWrapper r106 = new PolarisFileWrapper(p.c(r100, "k.store"));
        if (r106.exists() == false) goto L38;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r106);     // Catch: Throwable -> L27
        byte[] r108 = new byte[r107.available()];     // Catch: Throwable -> L25
        r107.read(r108);     // Catch: Throwable -> L25
        String r109 = f5.d(r108);     // Catch: Throwable -> L25
        if (r109.length() != 32) goto L21;
        r102 = r109;
    L21:
        r107.close();     // Catch: Throwable -> L23
    L59:
    L25:
        Throwable th10 = th;
    L52:
        n.a(th10, "AI", "gKe");     // Catch: Throwable -> L39
    L34:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L39
    L36:
        if (r107 == null) goto L38;
        r107.close();     // Catch: Throwable -> L23
        goto L59
    L31:
        if (r106.exists() == false) goto L36;
        r106.delete();     // Catch: Throwable -> L34
    L39:
        th = move-exception;
        if (r107 != null) goto L57;
    L45:
        throw th;
    L57:
        r107.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = move-exception;
        th10 = th;
        r107 = null;
    L38:
        f517834d = r102;
    L23:
        th = move-exception;
        th.printStackTrace();
    L47:
        return f517834d;
    L49:
        return f517834d;
    L5:
        if (r101.equals("") == false) goto L47;
        goto L6
    }
}
