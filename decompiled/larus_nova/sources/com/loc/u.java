package com.loc;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import n4a.f5;
import n4a.l1;
import n4a.y;
import n4a.y4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f380160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f380161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f380162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f380163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f380164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f380165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f380166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile String f380167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String f380168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f380169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile long f380170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f380171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f380172m;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f380173a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f380174b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f380175c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f380176e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f380177d;

        static {
            a r100 = new a("Unknow", 0, -1);
            f380173a = r100;
            a r101 = new a("NotAgree", 1, 0);
            f380174b = r101;
            a r102 = new a("DidAgree", 2, 1);
            f380175c = r102;
            f380176e = new a[]{r100, r101, r102};
        }

        public a(String r100, int r101, int r102) {
            super(r100, r101);
            this.f380177d = r102;
        }

        public static a a(int r100) {
            a r101 = f380174b;
            if (r100 != r101.a()) goto L5;
            return r101;
        L5:
            a r102 = f380175c;
            if (r100 != r102.a()) goto L9;
            return r102;
        L9:
            return f380173a;
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f380176e.clone();
        }

        public final int a() {
            return this.f380177d;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f380178a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f380179b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f380180c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ b[] f380181e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f380182d;

        static {
            b r100 = new b("Unknow", 0, -1);
            f380178a = r100;
            b r101 = new b("NotContain", 1, 0);
            f380179b = r101;
            b r102 = new b("DidContain", 2, 1);
            f380180c = r102;
            f380181e = new b[]{r100, r101, r102};
        }

        public b(String r100, int r101, int r102) {
            super(r100, r101);
            this.f380182d = r102;
        }

        public static b a(int r100) {
            b r101 = f380179b;
            if (r100 != r101.a()) goto L5;
            return r101;
        L5:
            b r102 = f380180c;
            if (r100 != r102.a()) goto L9;
            return r102;
        L9:
            return f380178a;
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        public static b[] values() {
            return (b[]) f380181e.clone();
        }

        public final int a() {
            return this.f380182d;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f380183a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f380184b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f380185c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f380186d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f380187e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f380188f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f380189g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f380190h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f380191i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ c[] f380192k = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f380193j;

        static {
            c r100 = new c("SuccessCode", 0, 0);
            f380183a = r100;
            c r101 = new c("ShowUnknowCode", 1, 555570);
            f380184b = r101;
            c r102 = new c("ShowNoShowCode", 2, 555571);
            f380185c = r102;
            c r103 = new c("InfoUnknowCode", 3, 555572);
            f380186d = r103;
            c r104 = new c("InfoNotContainCode", 4, 555573);
            f380187e = r104;
            c r105 = new c("AgreeUnknowCode", 5, 555574);
            f380188f = r105;
            c r110 = new c("AgreeNotAgreeCode", 6, 555575);
            f380189g = r110;
            c r111 = new c("InvaildUserKeyCode", 7, 10001);
            f380190h = r111;
            c r112 = new c("IllegalArgument", 8, 20001);
            f380191i = r112;
            f380192k = new c[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public c(String r100, int r101, int r102) {
            super(r100, r101);
            this.f380193j = r102;
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        public static c[] values() {
            return (c[]) f380192k.clone();
        }

        public final int a() {
            return this.f380193j;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f380194a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f380195b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f380196c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ d[] f380197e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f380198d;

        static {
            d r100 = new d("Unknow", 0, -1);
            f380194a = r100;
            d r101 = new d("NotShow", 1, 0);
            f380195b = r101;
            d r102 = new d("DidShow", 2, 1);
            f380196c = r102;
            f380197e = new d[]{r100, r101, r102};
        }

        public d(String r100, int r101, int r102) {
            super(r100, r101);
            this.f380198d = r102;
        }

        public static d a(int r100) {
            d r101 = f380195b;
            if (r100 != r101.a()) goto L5;
            return r101;
        L5:
            d r102 = f380196c;
            if (r100 != r102.a()) goto L9;
            return r102;
        L9:
            return f380194a;
        }

        public static d valueOf(String r100) {
            return (d) r27.a.a(d.class, r100);
        }

        public static d[] values() {
            return (d[]) f380197e.clone();
        }

        public final int a() {
            return this.f380198d;
        }
    }

    public class e extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f380199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f380200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f380201d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f380202e;

        public e(boolean r100, Context r101, long r102, JSONObject r103) {
            this.f380199b = r100;
            this.f380200c = r101;
            this.f380201d = r102;
            this.f380202e = r103;
        }

        @Override // n4a.l1
        public final void a() {
            if (this.f380199b == false) goto L8;
            Iterator<File> r100 = u.c(u.h(this.f380200c)).iterator();
        L6:
            if (r100.hasNext() == false) goto L8;
            u.a(this.f380200c, r100.next().getName());
        L8:
            u.f(this.f380200c);
            Context r101 = this.f380200c;
            JSONObject r102 = this.f380202e;
            long r103 = this.f380201d;
            byte[] r104 = r102.toString().getBytes();     // Catch: Throwable -> L28
            byte[] r105 = y.j(r101);     // Catch: Throwable -> L19
            byte[] r106 = y.f517956b;     // Catch: Throwable -> L19
            if (r106 != null) goto L14;
        L16:
            r106 = Arrays.copyOfRange(y.j(r101), 0, y.j(r101).length / 2);     // Catch: Throwable -> L19
            y.f517956b = r106;     // Catch: Throwable -> L19
        L17:
            byte[] r107 = y4.f(r105, r104, r106);     // Catch: Throwable -> L19
        L20:
            String r108 = u.b(r103);     // Catch: Throwable -> L28
            PolarisFileWrapper r109 = new PolarisFileWrapper(u.h(r101) + HTTP.URL_DEFAULT + r108);     // Catch: Throwable -> L28
            if (r109.getParentFile().exists() == true) goto L23;
            r109.getParentFile().mkdirs();     // Catch: Throwable -> L28
        L23:
            PolarisFileOutputStreamWrapper r110 = new PolarisFileOutputStreamWrapper(r109);     // Catch: Throwable -> L28
            r110.write(r107);     // Catch: Throwable -> L26
        L69:
            r110.close();     // Catch: Throwable -> L34
        L36:
            boolean r111 = u.e(this.f380200c, this.f380202e);
            if (r111 != true) goto L51;
            Context r112 = this.f380200c;
            String r113 = u.b(this.f380201d);
            if (r113 == null) goto L51;
            if (r113.length() == 0) goto L51;
            PolarisFileWrapper r114 = new PolarisFileWrapper(u.h(r112) + HTTP.URL_DEFAULT + r113);     // Catch: Throwable -> L48
            if (r114.exists() == false) goto L51;
            r114.delete();     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            th.printStackTrace();
        L51:
            if (this.f380199b == false) goto L53;
            u.d(this.f380200c);
        L53:
            if (r111 == true) goto L78;
            u.a(this.f380200c, u.b(this.f380201d));
            return;
        L78:
            return;
        L34:
            th = move-exception;
            th.printStackTrace();
        L26:
            Throwable th10 = th;
        L73:
            th10.printStackTrace();     // Catch: Throwable -> L56
            if (r110 == null) goto L36;
        L56:
            th = move-exception;
            if (r110 != null) goto L67;
        L62:
            throw th;
        L67:
            r110.close();     // Catch: Throwable -> L60
        L60:
            th = move-exception;
            th.printStackTrace();
            goto L62
        L14:
            if (r106.length <= 0) goto L16;
        L19:
            r107 = new byte[0];     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            th10 = th;
            r110 = null;
            goto L73
        }
    }

    static {
        f380160a = b.f380178a;
        f380161b = d.f380194a;
        f380162c = "";
        f380163d = "";
        f380164e = -1;
        f380165f = a.f380173a;
        f380166g = -1;
        f380167h = "";
        f380168i = "";
        f380169j = 0;
        f380170k = 0;
        f380171l = false;
        f380172m = true;
    }

    public static String b(long r100) {
        return String.format("%d-%s", new Object[]{Long.valueOf(r100), "privacy.data"});
    }

    public static ArrayList<File> c(String r100) {
        ArrayList<File> r101 = new ArrayList();
        if (r100 != null) goto L5;
    L17:
        return r101;
    L5:
        if (r100.length() == 0) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L10;
        return r101;
    L10:
        File[] r103 = r102.listFiles();
        int r104 = 0;
    L12:
        if (r104 >= r103.length) goto L17;
        File r105 = r103[r104];
        if (r105.isFile() == false) goto L16;
        r101.add(r105);
    L16:
        r104 = r104 + 1;
        goto L12
    }

    public static synchronized void f(Context r100) {
        monitor-enter(u.class);
        if (r100 != null) goto L22;
        monitor-exit(u.class);
        return;
    L22:
    L17:
        th = move-exception;
        throw th;
    L8:
        if (f380171l == true) goto L20;
        g(r100);     // Catch: Throwable -> L17
        f380171l = true;     // Catch: Throwable -> L17
    L20:
        y.d(r100, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", new Object[]{Integer.valueOf(f380160a.a()), Integer.valueOf(f380161b.a()), Long.valueOf(f380164e), f380162c, f380163d, Integer.valueOf(f380165f.a()), Long.valueOf(f380166g), f380167h, f380168i, Long.valueOf(f380169j), Long.valueOf(f380170k)}));     // Catch: Throwable -> L13
        monitor-exit(u.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    }

    public static void g(Context r100) {
        if (r100 != null) goto L22;
        return;
    L22:
        String r101 = y.c(r100, "AMap.privacy.data", "AMap.privacy.data");     // Catch: Throwable -> L7
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        String[] r102 = r101.split("&");
        if (r102.length == 11) goto L20;
        return;
    L20:
        f380160a = b.a(CastIntegerProtector.parseInt(r102[0]));     // Catch: Throwable -> L17
        f380161b = d.a(CastIntegerProtector.parseInt(r102[1]));     // Catch: Throwable -> L17
        f380164e = CastLongProtector.parseLong(r102[2]);     // Catch: Throwable -> L17
        f380163d = r102[3];     // Catch: Throwable -> L17
        f380163d = r102[4];     // Catch: Throwable -> L17
        f380165f = a.a(CastIntegerProtector.parseInt(r102[5]));     // Catch: Throwable -> L17
        f380166g = CastLongProtector.parseLong(r102[6]);     // Catch: Throwable -> L17
        f380167h = r102[7];     // Catch: Throwable -> L17
        f380168i = r102[8];     // Catch: Throwable -> L17
        f380169j = CastLongProtector.parseLong(r102[9]);     // Catch: Throwable -> L17
        f380170k = CastLongProtector.parseLong(r102[10]);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L9
    }

    public static String h(Context r100) {
        return r100.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    public static void d(Context r100) {
        Iterator<File> r101 = c(r100.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload").iterator();     // Catch: Throwable -> L36
    L3:
        if (r101.hasNext() == false) goto L35;
        File r102 = r101.next();     // Catch: Throwable -> L36
        String r103 = r102.getName();     // Catch: Throwable -> L26
        if (r103.endsWith("-privacy.data") == false) goto L31;
        String[] r104 = r103.split("-");     // Catch: Throwable -> L26
        if (r104 != null) goto L15;
        if (r104.length != 2) goto L31;
    L15:
        if (CastLongProtector.parseLong(r104[0]) <= 0) goto L31;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L26
        byte[] r106 = new byte[r105.available()];     // Catch: Throwable -> L26
        r105.read(r106);     // Catch: Throwable -> L26
        byte[] r107 = y.j(r100);     // Catch: Throwable -> L26 Exception -> L28
        byte[] r108 = y.f517956b;     // Catch: Throwable -> L26 Exception -> L28
    L19:
        if (r108 != null) goto L21;
    L23:
        r108 = Arrays.copyOfRange(y.j(r100), 0, y.j(r100).length / 2);     // Catch: Throwable -> L26 Exception -> L28
        y.f517956b = r108;     // Catch: Throwable -> L26 Exception -> L28
    L24:
        byte[] r109 = y4.c(r107, r106, r108);     // Catch: Throwable -> L26 Exception -> L28
    L30:
        if (e(r100, new JSONObject(new String(r109))) == false) goto L3;
    L21:
        if (r108.length <= 0) goto L23;
    L28:
        r109 = new byte[0];     // Catch: Throwable -> L26
    L31:
        r102.delete();     // Catch: Throwable -> L26
        goto L3
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        goto L3
    L35:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(Context r100, String r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() == 0) goto L21;
        PolarisFileWrapper r102 = new PolarisFileWrapper(h(r100) + HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L15
        if (r102.exists() == true) goto L10;
        return;
    L10:
        PolarisFileWrapper r103 = new PolarisFileWrapper((r100.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload") + HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L15
        if (r103.getParentFile().exists() == true) goto L13;
        r103.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L13:
        r102.renameTo(r103);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static boolean e(Context r100, JSONObject r101) {
        n4a.u r102 = new n4a.u();     // Catch: Throwable -> L9
        r102.f517766l = r100;     // Catch: Throwable -> L9
        r102.f517765k = r101;     // Catch: Throwable -> L9
        i.x();     // Catch: Throwable -> L9
        JSONObject r103 = new JSONObject(f5.d(com.loc.c.a(r102).f517453a));     // Catch: Throwable -> L9
        if (r103.has("status") == false) goto L14;
        if (JSONObjectProtectorUtils.getInt(r103, "status") != 1) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
