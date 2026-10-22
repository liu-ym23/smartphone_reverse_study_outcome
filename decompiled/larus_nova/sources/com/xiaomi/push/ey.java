package com.xiaomi.push;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class ey implements fi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f463510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ez f541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fc f542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SimpleDateFormat f544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f463511b;

    public class a implements fe, fj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ey f463513a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f545a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f546a;

        @Override // com.xiaomi.push.fj
        /* JADX INFO: renamed from: a */
        public boolean mo8908a(fn r100) {
            return true;
        }

        @Override // com.xiaomi.push.fe
        public void a(eq r100) {
            if (ey.f463510a == false) goto L5;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.m9078a(this.f463513a).format(new Date()) + this.f545a + r100.toString());
        L6:
            if (r100 != null) goto L8;
            return;
        L8:
            if (r100.a() != 99999) goto L33;
            String r101 = r100.m9058a();
            eq r102 = null;
            if (this.f546a == false) goto L12;
        L20:
            if (r102 == null) goto L34;
            Iterator<Map.Entry<fe, ez.a>> r103 = ey.m9077a(this.f463513a).m9083a().entrySet().iterator();
        L23:
            if (r103.hasNext() == false) goto L35;
            Map.Entry<fe, ez.a> r104 = r103.next();
            if (ey.a(this.f463513a) == r104.getKey()) goto L23;
            r104.getValue().a(r102);
            goto L23
        L35:
            return;
        L34:
            return;
        L12:
            if ("BIND".equals(r101) == false) goto L15;
            com.xiaomi.channel.commonutils.logger.b.m8718a("build binded result for loopback.");
            Cdo.d r105 = new Cdo.d();
            r105.a(true);
            r105.c("login success.");
            r105.b("success");
            r105.a("success");
            eq r106 = new eq();
            r106.a(r105.m9042a(), null);
            r106.a(2);
            r106.a(99999);
            r106.a("BIND", null);
            r106.a(r100.e());
            r106.b(null);
            r106.c(r100.g());
            r102 = r106;
            goto L20
        L15:
            if ("UBND".equals(r101) == true) goto L20;
            if ("SECMSG".equals(r101) == false) goto L20;
            eq r107 = new eq();
            r107.a(99999);
            r107.a("SECMSG", null);
            r107.c(r100.g());
            r107.a(r100.e());
            r107.a(r100.m9060a());
            r107.b(r100.f());
            r107.a(r100.m9063a(com.xiaomi.push.service.am.a().a(String.valueOf(99999), r100.g()).f464222h), null);
            r102 = r107;
            goto L20
        L33:
            return;
        L5:
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.m9078a(this.f463513a).format(new Date()) + this.f545a + " Blob [" + r100.m9058a() + "," + r100.a() + "," + com.xiaomi.push.service.aj.a(r100.e()) + "]");
            goto L6
        }

        @Override // com.xiaomi.push.fe
        public void a(fn r100) {
            if (ey.f463510a == false) goto L5;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.m9078a(this.f463513a).format(new Date()) + this.f545a + " PKT " + r100.mo9099a());
            return;
        L5:
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ey.m9078a(this.f463513a).format(new Date()) + this.f545a + " PKT [" + r100.k() + "," + r100.j() + "]");
        }

        public a(ey r100, boolean r101) {
            this.f463513a = r100;
            this.f546a = r101;
            if (r101 == false) goto L5;
            String r102 = " RCV ";
        L6:
            this.f545a = r102;
            return;
        L5:
            r102 = " Sent ";
            goto L6
        }
    }

    private void a() {
        this.f540a = new a(this, true);
        this.f463511b = new a(this, false);
        ez r100 = this.f541a;
        a r101 = this.f540a;
        r100.a(r101, r101);
        ez r102 = this.f541a;
        a r103 = this.f463511b;
        r102.b(r103, r103);
        this.f542a = new AnonymousClass1(this);
    }

    public ey(ez r100) {
        this.f544a = new SimpleDateFormat("hh:mm:ss aaa");
        this.f540a = null;
        this.f463511b = null;
        this.f542a = null;
        this.f543a = "[Slim] ";
        this.f541a = r100;
        a();
    }

    public static /* synthetic */ a a(ey r100) {
        return r100.f540a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ ez m9077a(ey r100) {
        return r100.f541a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ SimpleDateFormat m9078a(ey r100) {
        return r100.f544a;
    }
}
