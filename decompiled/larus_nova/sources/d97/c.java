package d97;

import android.text.TextUtils;
import com.bytedance.reparo.core.exception.JavaPatchParseException;
import com.bytedance.reparo.core.h;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import e97.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f467629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c97.d f467630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f467631d;

    public final void a(b r110) throws JavaPatchParseException {
        if (this.f467630c.f22868f == true) goto L54;
        long r100 = System.currentTimeMillis();
        c97.d r101 = this.f467630c;
        r101.getClass();
        r110.b("parse_patch_io");
        if (w87.b.f(r101.f22867e) == true) goto L53;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.f22867e, "patch_classes_methods.txt");
        if (w87.b.g(r102) == false) goto L51;
        Map<String, Map<String, Set<String>>> r103 = c97.d.c(r102);     // Catch: IOException -> L47
        Map<String, Map<String, Set<String>>> r104 = c97.d.c(r101.b());     // Catch: IOException -> L47
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(r101.f22867e, "added_classes.txt")));     // Catch: Throwable -> L26
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L20
    L12:
        String r107 = r105.readLine();     // Catch: Throwable -> L20
        if (r107 == null) goto L18;
        if (TextUtils.isEmpty(r107) == true) goto L12;
        r106.add(r107);     // Catch: Throwable -> L20
    L18:
        r105.close();     // Catch: Throwable -> L26
    L27:
        r101.f22865c = r106;
        r110.a("parse_patch_io");
        r110.b("parse_patch_load");
        c97.d.a r108 = r101.d(r103, true);
        Map<Class, h> r109 = r101.f22863a;
        HashMap r111 = (HashMap) r109;
        r111.putAll(r108.f22869a);
        List<String> r112 = r101.f22864b;
        ArrayList r113 = (ArrayList) r112;
        r113.addAll(r108.f22870b);
        List<Object> r114 = r101.f22866d;
        ArrayList r115 = new ArrayList();
        Iterator r116 = ((HashMap) r101.d(r104, false).f22869a).values().iterator();
    L29:
        if (r116.hasNext() == false) goto L42;
        h r117 = (h) r116.next();
        if (r117 == null) goto L29;
        List<Method> r118 = r117.f267370c;
        if (r118 != null) goto L35;
    L37:
        List<Constructor> r119 = r117.f267369b;
        if (r119 == null) goto L29;
        if (((ArrayList) r119).isEmpty() == true) goto L29;
        r115.addAll(r119);
        goto L29
    L35:
        if (((ArrayList) r118).isEmpty() == true) goto L37;
        r115.addAll(r118);
        goto L37
    L42:
        ((ArrayList) r114).addAll(r115);
        r101.f22868f = true;
        r110.a("parse_patch_load");
        long r120 = System.currentTimeMillis() - r100;
        if (i.f471528e == true) goto L45;
        return;
    L45:
        if (r120 < 300) goto L77;
        i.f471528e = false;
        return;
    L77:
        return;
    L20:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26
    L26:
        r106 = null;
    L47:
        e = move-exception;
        throw new JavaPatchParseException("loadPatchConfig failed", e, 111);
    L51:
        throw new JavaPatchParseException("Failed to parse java patch, patch_classes_methods.txt not exist", 107);
    L53:
        throw new JavaPatchParseException("Failed to parse java patch, java patch root dir is empty", 106);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof c) == true) goto L12;
        return false;
    L12:
        return w87.b.e(this.f467629b, ((c) r100).f467629b);
    }

    public c(File r100, d r101) {
        this.f467629b = r100;
        this.f467630c = new c97.d(r100);
        this.f467631d = r101;
    }
}
