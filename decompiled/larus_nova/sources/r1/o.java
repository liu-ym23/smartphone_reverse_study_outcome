package r1;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static o f535577e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f535578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f535579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f535580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f535581d;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f535582a;

        public a(String r100) {
            this.f535582a = r100;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            if (r101.endsWith(this.f535582a) == true) goto L5;
        L7:
            return false;
        L5:
            if (PatternProtector.compile("^\\d{1,13}-\\d{1,13}.*").matcher(r101).matches() == false) goto L7;
            return true;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f535583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f535584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File f535585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f535586d;

        public b(File r100) {
            this.f535586d = null;
            this.f535585c = r100;
            String[] r101 = r100.getName().split("-|\\.");
            if (r101.length < 2) goto L5;
            this.f535583a = CastLongProtector.parseLong(r101[0]);
            long r102 = CastLongProtector.parseLong(r101[1]);
        L12:
            this.f535584b = r102;
            return;
        L5:
            String r103 = r100.getName();
            if (TextUtils.isEmpty(r103) == false) goto L8;
            return;
        L8:
            if (r103.length() < 13) goto L15;
            String r104 = r103.substring(0, 13);
            if (TextUtils.isDigitsOnly(r104) == false) goto L16;
            r102 = CastLongProtector.parseLong(r104);
            this.f535583a = r102;
            goto L12
        L16:
            return;
        }
    }

    public final void c(long r100, long r101, JSONObject r110, JSONArray r111) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f535578a, "" + r100 + "-" + r101 + ".ctx");
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f535578a, "" + r100 + "-" + r101 + ".allData");
        com.apm.lite.k.h.g(r102, r110);     // Catch: IOException -> L5
        com.apm.lite.k.h.f(r103, r111);     // Catch: IOException -> L5
        this.f535581d = new b(r102);     // Catch: IOException -> L5
        return;
    L5:
        com.apm.lite.c.a();
    }

    public static o b() {
        if (f535577e != null) goto L6;
        f535577e = new o(com.apm.lite.e.f29909a);
    L6:
        return f535577e;
    }

    public o(Context r100) {
        this.f535581d = null;
        PolarisFileWrapper r101 = new PolarisFileWrapper(com.apm.lite.k.n.g(r100), "apmlite/RuntimeContext");
        if (r101.exists() == true) goto L5;
    L8:
        r101.mkdirs();
        s1.c.f540079x = true;
    L9:
        this.f535578a = r101;
        this.f535579b = new PolarisFileWrapper(r101, com.bytedance.android.ec.core.event.a.KEY_DID);
        this.f535580c = new PolarisFileWrapper(r101, "device_uuid");
        return;
    L5:
        if (r101.isDirectory() == true) goto L9;
        if (r101.delete() == false) goto L9;
        goto L8
    }

    public final JSONObject a(long r110) {
        Iterator<b> r100 = f(".ctx").iterator();
    L3:
        JSONObject r101 = null;
        if (r100.hasNext() == false) goto L10;
        b r102 = r100.next();
        if (r110 < r102.f535583a) goto L3;
        if (r110 > r102.f535584b) goto L3;
        File r103 = r102.f535585c;
    L12:
        if (r103 != null) goto L25;
        Iterator<b> r104 = f(".ctx").iterator();
        b r105 = null;
    L15:
        if (r104.hasNext() == false) goto L21;
        b r106 = r104.next();
        if (r105 == null) goto L20;
        if (Math.abs(r105.f535584b - r110) <= Math.abs(r106.f535584b - r110)) goto L15;
    L20:
        r105 = r106;
        goto L15
    L21:
        if (r105 != null) goto L23;
        r103 = null;
    L24:
        boolean r111 = true;
    L26:
        if (r103 != null) goto L43;
    L35:
        if (r101 == null) goto L40;
        if (r111 == false) goto L40;
        r101.put("unauthentic_version", 1);     // Catch: JSONException -> L39
    L39:
        com.apm.lite.c.a();
    L40:
        return r101;
    L43:
        String r112 = com.apm.lite.k.h.b(r103.getAbsolutePath());     // Catch: Throwable -> L32
        r101 = new JSONObject(r112);     // Catch: Throwable -> L30
    L30:
        Throwable th10 = th;
    L34:
        com.apm.lite.c.a();
        new IOException("content :" + r112, th10);
    L32:
        th = move-exception;
        th10 = th;
        r112 = null;
        goto L34
    L23:
        r103 = r105.f535585c;
        goto L24
    L25:
        r111 = false;
        goto L26
    L10:
        r103 = null;
        goto L12
    }

    public final JSONArray e(long r110) {
        Iterator<b> r100 = f(".allData").iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        b r101 = r100.next();
        if (r110 < r101.f535583a) goto L4;
        if (r110 > r101.f535584b) goto L4;
        File r102 = r101.f535585c;
    L11:
        if (r102 != null) goto L23;
        Iterator<b> r103 = f(".allData").iterator();
        b r104 = null;
    L14:
        if (r103.hasNext() == false) goto L20;
        b r105 = r103.next();
        if (r104 == null) goto L19;
        if (Math.abs(r104.f535584b - r110) <= Math.abs(r105.f535584b - r110)) goto L14;
    L19:
        r104 = r105;
        goto L14
    L20:
        if (r104 != null) goto L22;
        r102 = null;
        goto L23
    L22:
        r102 = r104.f535585c;
    L23:
        if (r102 == null) goto L49;
        String r111 = com.apm.lite.k.h.b(r102.getAbsolutePath());     // Catch: Throwable -> L29
        return new JSONArray(r111);
    L27:
        Throwable th10 = th;
    L31:
        com.apm.lite.c.a();
        new IOException("content :" + r111, th10);
        return null;
    L29:
        th = move-exception;
        th10 = th;
        r111 = null;
        goto L31
    L49:
        return null;
    L10:
        r102 = null;
        goto L11
    }

    public final ArrayList<b> f(String r110) {
        File[] r100 = this.f535578a.listFiles(new a(r110));
        ArrayList<b> r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        com.apm.lite.k.p.a("foundRuntimeContextFiles " + r100.length);
        int r102 = r100.length;
        b r103 = null;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L21;
        b r105 = new b(r100[r104]);     // Catch: Throwable -> L18
        r101.add(r105);     // Catch: Throwable -> L18
        if (this.f535581d != null) goto L19;
        if (".ctx".equals(r110) == false) goto L19;
        if (r103 == null) goto L17;
        if (r105.f535584b < r103.f535584b) goto L19;
    L17:
        r103 = r105;
    L19:
        r104 = r104 + 1;
    L18:
        com.apm.lite.c.a();
        goto L19
    L21:
        if (this.f535581d != null) goto L24;
        if (r103 == null) goto L24;
        this.f535581d = r103;
    L24:
        return r101;
    }

    public final void d(Map<String, Object> r110, JSONArray r111) {
        JSONObject r100 = k1.c.a().c(r110);
        if (k1.c.k(r100) == false) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis();
        if (this.f535581d != null) goto L8;
        f(".ctx");
    L8:
        b r112 = this.f535581d;
        if (r112 != null) goto L13;
        c(r101, r101, r100, r111);
        return;
    L13:
        if (r112.f535586d == null) goto L78;
    L20:
        JSONObject r102 = r112.f535586d;
        if (k1.c.k(r102) == false) goto L24;
    L42:
        char r103 = 2;
    L43:
        if (r103 == 1) goto L50;
        if (r103 != 2) goto L46;
        c(r101, r101, r100, r111);
    L80:
        ArrayList<b> r113 = f("");     // Catch: Throwable -> L74
        if (r113.size() <= 6) goto L87;
        Iterator<b> r114 = r113.iterator();     // Catch: Throwable -> L74
    L55:
        if (r114.hasNext() == false) goto L88;
        b r115 = r114.next();     // Catch: Throwable -> L74
        long r104 = r115.f535583a;     // Catch: Throwable -> L74
        if (r104 > r101) goto L60;
    L61:
        long r105 = r115.f535584b;     // Catch: Throwable -> L74
        if (r105 >= r101) goto L66;
        if ((r101 - r105) <= 604800000) goto L66;
    L69:
        boolean r106 = true;
    L71:
        if (r106 == false) goto L55;
        r115.f535585c.delete();     // Catch: Throwable -> L74
    L66:
        if (r115.f535585c.lastModified() < r101) goto L68;
    L70:
        r106 = false;
        goto L71
    L68:
        if ((r101 - r115.f535585c.lastModified()) <= 604800000) goto L70;
    L60:
        if ((r104 - r101) > 604800000) goto L69;
    L88:
        return;
    L87:
        return;
    L74:
        com.apm.lite.c.a();
        return;
    L46:
        if (r103 != 3) goto L80;
        r112.f535584b = r101;
        r112.f535585c.renameTo(new PolarisFileWrapper(r112.f535585c.getParent(), r112.f535583a + "-" + r112.f535584b + ".ctx"));
        goto L80
    L50:
        c(r112.f535583a, r101, r100, r111);
        com.apm.lite.k.h.k(r112.f535585c);
        goto L80
    L24:
        if (k1.c.k(r100) == false) goto L27;
        r103 = 0;
        goto L43
    L27:
        if (String.valueOf(r100.opt("update_version_code")).equals(String.valueOf(r102.opt("update_version_code"))) == false) goto L42;
        if (r102.length() == 0) goto L39;
        String r107 = r102.optString("aid");
        if (TextUtils.isEmpty(r107) == true) goto L39;
        if (CastIntegerProtector.parseInt(r107) <= 0) goto L39;
        boolean r108 = false;
    L40:
        if (r108 == false) goto L42;
        r103 = 1;
    L39:
        r108 = true;
        goto L40
    L78:
        r112.f535586d = new JSONObject(com.apm.lite.k.h.b(r112.f535585c.getAbsolutePath()));     // Catch: Throwable -> L16
    L18:
        if (r112.f535586d != null) goto L20;
        r112.f535586d = new JSONObject();
        goto L20
    }
}
