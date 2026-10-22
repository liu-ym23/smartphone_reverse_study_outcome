package com.getkeepsafe.relinker;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.ZipFile;
import ou7.i;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f274233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReLinker.b f274234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReLinker.a f274235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f274236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f274237e;

    public b() {
        c r100 = new c();
        a r101 = new a();
        this.f274233a = new HashSet();
        this.f274234b = r100;
        this.f274235c = r101;
    }

    public static void d(String r100, Object... r101) {
        String.format(Locale.US, r100, r101);
    }

    public final PolarisFileWrapper a(Context r100, String r101, String r102) {
        String r103 = ((c) this.f274234b).b(r101);
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L14;
        return new PolarisFileWrapper(r100.getDir("lib", 0), r103);
    L14:
        return new PolarisFileWrapper(r100.getDir("lib", 0), r103 + "." + r102);
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L10
    }

    public final void b(Context r100, String r101, String r102) {
        if (r100 == null) goto L16;
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L14;
        d("Beginning load of %s...", new Object[]{r101});
        c(r100, r101, r102);
        return;
    L14:
        throw new IllegalArgumentException("Given library is either null or empty");
    L6:
        if (r101.length() == 0) goto L9;
        r103 = false;
        goto L10
    L16:
        throw new IllegalArgumentException("Given context is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Context r210, String r211, String r212) {
        int r100 = 1;
        if (((HashSet) this.f274233a).contains(r211) == false) goto L146;
        if (this.f274236d == true) goto L146;
        d("%s already loaded previously!", new Object[]{r211});
        return;
    L146:
        ((c) this.f274234b).a(r211);     // Catch: UnsatisfiedLinkError -> L11
        ((HashSet) this.f274233a).add(r211);     // Catch: UnsatisfiedLinkError -> L11
        d("%s (%s) was loaded normally!", new Object[]{r211, r212});     // Catch: UnsatisfiedLinkError -> L11
        return;
    L11:
        e = move-exception;
        d("Loading the library normally failed: %s", new Object[]{Log.getStackTraceString(e)});
        d("%s (%s) was not loaded normally, re-linking...", new Object[]{r211, r212});
        PolarisFileWrapper r101 = a(r210, r211, r212);
        if (r101.exists() == false) goto L17;
        if (this.f274236d == true) goto L17;
    L143:
        if (this.f274237e == false) goto L106;
        i r102 = new i(r101);     // Catch: Throwable -> L101
        List<String> r103 = r102.a();     // Catch: Throwable -> L99
        r102.close();     // Catch: IOException -> L124
        Iterator<String> r104 = r103.iterator();     // Catch: IOException -> L124
    L97:
        if (r104.hasNext() == false) goto L106;
        String r105 = r104.next();     // Catch: IOException -> L124
        ((c) this.f274234b).getClass();     // Catch: IOException -> L124
        b(r210, r105.substring(3, r105.length() - 3), null);     // Catch: IOException -> L124
    L99:
        th = th;
    L103:
        if (r102 == null) goto L105;
        r102.close();     // Catch: IOException -> L124
    L105:
        throw th;     // Catch: IOException -> L124
    L101:
        th = th;
        r102 = null;
    L106:
        ReLinker.b r106 = this.f274234b;
        String r107 = r101.getAbsolutePath();
        ((c) r106).getClass();
        System.load(r107);
        ((HashSet) this.f274233a).add(r211);
        d("%s (%s) was re-linked!", new Object[]{r211, r212});
        return;
    L17:
        if (this.f274236d == false) goto L19;
        d("Forcing a re-link of %s (%s)...", new Object[]{r211, r212});
    L19:
        File r108 = r210.getDir("lib", 0);
        PolarisFileWrapper r109 = a(r210, r211, r212);
        File[] r110 = r108.listFiles(new nu7.a(((c) this.f274234b).b(r211)));
        if (r110 == null) goto L30;
        int r111 = r110.length;
        int r112 = 0;
    L23:
        if (r112 >= r111) goto L30;
        File r113 = r110[r112];
        if (this.f274236d == false) goto L27;
    L28:
        r113.delete();
    L29:
        r112 = r112 + 1;
        goto L23
    L27:
        if (r113.getAbsolutePath().equals(r109.getAbsolutePath()) == true) goto L29;
    L30:
        ReLinker.a r114 = this.f274235c;
        ((c) this.f274234b).getClass();
        String[] r115 = Build.SUPPORTED_ABIS;
        if (r115.length > 0) goto L43;
        String r116 = Build.CPU_ABI2;
        if (r116 != null) goto L36;
    L39:
        boolean r117 = true;
    L40:
        if (r117 == true) goto L42;
        r115 = new String[]{Build.CPU_ABI, r116};
        goto L43
    L42:
        r115 = new String[]{Build.CPU_ABI};
        goto L43
    L36:
        if (r116.length() == 0) goto L39;
        r117 = false;
    L43:
        String r118 = ((c) this.f274234b).b(r211);
        ((a) r114).getClass();
        a.C3842a r119 = a.b(r210, r115, r118, this);     // Catch: Throwable -> L116
        if (r119 == null) goto L128;
        int r120 = 0;
    L47:
        int r121 = r120 + 1;
        if (r120 >= 5) goto L88;
        Object[] r122 = new Object[r100];     // Catch: Throwable -> L69
        r122[0] = r118;     // Catch: Throwable -> L69
        d("Found %s! Extracting...", r122);     // Catch: Throwable -> L69
        if (r101.exists() == true) goto L148;
        if (r101.createNewFile() == false) goto L87;
    L148:
        InputStream r123 = r119.f274231a.getInputStream(r119.f274232b);     // Catch: Throwable -> L78 Throwable -> L82
    L150:
        PolarisFileOutputStreamWrapper r124 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L75 Throwable -> L126
        goto L83
    L135:
        byte[] r125 = new byte[4096];     // Catch: Throwable -> L73 Throwable -> L125
        long r126 = 0;
        boolean r127 = r100;
    L59:
        int r128 = r123.read(r125);     // Catch: Throwable -> L73 Throwable -> L125
        if (r128 == (-1)) goto L61;
        r124.write(r125, 0, r128);     // Catch: Throwable -> L73 Throwable -> L125 Throwable -> L125
        r126 = r126 + ((long) r128);
        r127 = 1;
        goto L59
    L61:
        r124.flush();     // Catch: Throwable -> L73 Throwable -> L125
        r124.getFD().sync();     // Catch: Throwable -> L73 Throwable -> L125
        if (r126 != r101.length()) goto L84;
        a.a(r123);     // Catch: Throwable -> L69
        a.a(r124);     // Catch: Throwable -> L69
        r101.setReadable(r127, false);     // Catch: Throwable -> L69
        r101.setExecutable(r127, false);     // Catch: Throwable -> L69
        r101.setWritable(r127);     // Catch: Throwable -> L69
        ZipFile r129 = r119.f274231a;     // Catch: IOException -> L123
        if (r129 == null) goto L143;
    L90:
        r129.close();     // Catch: IOException -> L123
        goto L143
    L73:
        th = th;
        PolarisFileOutputStreamWrapper r130 = r124;
    L77:
        PolarisFileOutputStreamWrapper r131 = r130;
        InputStream r132 = r123;
    L80:
        a.a(r132);     // Catch: Throwable -> L69
        a.a(r131);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L84:
        a.a(r123);     // Catch: Throwable -> L69
        a.a(r124);     // Catch: Throwable -> L69
    L75:
        th = th;
        r130 = null;
    L83:
        r124 = null;
    L82:
        r123 = null;
    L78:
        th = th;
        r132 = null;
        r131 = null;
    L87:
        r120 = r121;
        r100 = 1;
        goto L47
    L88:
        r129 = r119.f274231a;     // Catch: IOException -> L123
        if (r129 == null) goto L143;
    L128:
        String[] r133 = a.c(r210, r118);     // Catch: Throwable -> L69 Exception -> L110
    L114:
        throw new MissingLibraryException(r118, r115, r133);     // Catch: Throwable -> L69
    L110:
        e = move-exception;
        r133 = new String[]{e.toString()};     // Catch: Throwable -> L69
    L69:
        th = th;
        a.C3842a r134 = r119;
    L118:
        if (r134 != null) goto L133;
    L122:
        throw th;
    L133:
        ZipFile r135 = r134.f274231a;     // Catch: IOException -> L127
        if (r135 == null) goto L122;
        r135.close();     // Catch: IOException -> L127
    L116:
        th = th;
        r134 = null;
        goto L118
    }
}
