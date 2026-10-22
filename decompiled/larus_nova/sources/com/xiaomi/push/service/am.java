package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static am f464214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<a> f1044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f1045a;

    public interface a {
        void a();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f464215a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Context f1046a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        IBinder.DeathRecipient f1047a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Messenger f1048a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private XMPushService.c f1049a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private XMPushService f1050a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final C5562b f1051a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        c f1052a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public h f1053a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1054a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f1055a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c f464216b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f1057b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f1058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f464217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f464218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f464219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f464220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f464221g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f464222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f464223i;

        public interface a {
            void a(c r100, c r101, int r102);
        }

        /* JADX INFO: renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        public class C5562b extends XMPushService.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f464225a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            String f1059a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f464226b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            String f1060b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f464227c;

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo9047a() {
                if (b.a(this.f464225a, this.f464226b, this.f464227c, this.f1060b) == false) goto L5;
                b.a(this.f464225a, this.f464226b, this.f464227c, this.f1059a, this.f1060b);
                return;
            L5:
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + this.f464225a.f464221g);
            }

            public C5562b(b r100) {
                this.f464225a = r100;
                super(0);
            }

            public XMPushService.j a(int r100, int r101, String r102, String r103) {
                this.f464226b = r100;
                this.f464227c = r101;
                this.f1060b = r103;
                this.f1059a = r102;
                return this;
            }
        }

        public class c implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Messenger f464228a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            final b f1061a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f464229b;

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f1061a.f464221g);
                final int r100 = 0;
                b.m9366a(this.f464229b).a(new AnonymousClass1(this, r100), 0);
                if (Constants.VIA_SHARE_TYPE_MINI_PROGRAM.equals(this.f1061a.f464221g) == true) goto L5;
                return;
            L5:
                if ("com.xiaomi.xmsf".equals(b.m9366a(this.f464229b).getPackageName()) == false) goto L9;
                b.m9366a(this.f464229b).a(new AnonymousClass2(this, r100), 60000);
                return;
            }

            public c(b r100, b r101, Messenger r102) {
                this.f464229b = r100;
                this.f1061a = r101;
                this.f464228a = r102;
            }
        }

        public String a(int r100) {
            if (r100 != 1) goto L5;
            return "OPEN";
        L5:
            if (r100 != 2) goto L7;
            return "CLOSE";
        L7:
            if (r100 == 3) goto L10;
            return "unknown";
        L10:
            return "KICK";
        }

        public b() {
            this.f1052a = c.f464232a;
            this.f464215a = 0;
            this.f1055a = new CopyOnWriteArrayList();
            this.f464216b = null;
            this.f1058b = false;
            this.f1049a = new XMPushService.c(this);
            this.f1047a = null;
            this.f1051a = new C5562b(this);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f464215a + 1) * 15))) * 1000;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m9367a() {
            Messenger r100 = this.f1048a;     // Catch: Exception -> L9
            if (r100 == null) goto L7;
            if (this.f1047a == null) goto L7;
            r100.getBinder().unlinkToDeath(this.f1047a, 0);     // Catch: Exception -> L9
        L7:
            this.f464216b = null;
        }

        public b(XMPushService r100) {
            this.f1052a = c.f464232a;
            this.f464215a = 0;
            this.f1055a = new CopyOnWriteArrayList();
            this.f464216b = null;
            this.f1058b = false;
            this.f1049a = new XMPushService.c(this);
            this.f1047a = null;
            this.f1051a = new C5562b(this);
            this.f1050a = r100;
            a(new AnonymousClass1(this));
        }

        public void a(Messenger r100) {
            m9367a();
            if (r100 == null) goto L5;
            this.f1048a = r100;     // Catch: Exception -> L7
            this.f1058b = true;     // Catch: Exception -> L7
            this.f1047a = new c(this, this, r100);     // Catch: Exception -> L7
            r100.getBinder().linkToDeath(this.f1047a, 0);     // Catch: Exception -> L7
        L10:
            return;
        L5:
            com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f464221g);     // Catch: Exception -> L7
        L7:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
            this.f1048a = null;
            this.f1058b = false;
        }

        public void b(a r100) {
            this.f1055a.remove(r100);
        }

        public static String a(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return "";
        L5:
            int r101 = r100.lastIndexOf(HTTP.URL_DEFAULT);
            if (r101 != (-1)) goto L8;
            return "";
        L8:
            return r100.substring(r101 + 1);
        }

        public void a(a r100) {
            this.f1055a.add(r100);
        }

        public static /* synthetic */ XMPushService.c a(b r100) {
            return r100.f1049a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public static /* synthetic */ XMPushService m9366a(b r100) {
            return r100.f1050a;
        }

        private boolean a(int r100, int r101, String r102) {
            c r103 = this.f464216b;
            if (r103 == null) goto L18;
            boolean r104 = this.f1058b;
            if (r104 == false) goto L18;
            if (r103 != this.f1052a) goto L12;
            com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.f464221g);
            return false;
        L12:
            if (this.f1048a == null) goto L16;
            if (r104 == false) goto L16;
            com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f464221g);
            return true;
        L16:
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.f464221g);
            return false;
        L18:
            return true;
        }

        private boolean b(int r100, int r101, String r102) {
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L12;
            if (r100 == 3) goto L10;
            return false;
        L10:
            return !"wait".equals(r102);
        L12:
            return this.f1050a.m9336c();
        L14:
            if (this.f1052a != c.f464234c) goto L17;
            return false;
        L17:
            if (this.f1050a.m9336c() == true) goto L20;
            return false;
        L20:
            if (r101 != 21) goto L22;
        L27:
            return false;
        L22:
            if (r101 == 7) goto L24;
        L26:
            return true;
        L24:
            if ("wait".equals(r102) == false) goto L26;
            goto L26
        }

        private void a(int r110, int r111, String r112, String r113) {
            c r100 = this.f1052a;
            this.f464216b = r100;
            if (r110 != 2) goto L6;
            this.f1053a.a(this.f1046a, this, r111);
            return;
        L6:
            if (r110 != 3) goto L9;
            this.f1053a.a(this.f1046a, this, r113, r112);
            return;
        L9:
            if (r110 == 1) goto L11;
            return;
        L11:
            if (r100 != c.f464234c) goto L13;
            boolean r101 = true;
        L14:
            if (r101 == false) goto L16;
        L18:
            if (r101 == false) goto L23;
            this.f464215a = 0;
            if (this.f1048a == null) goto L23;
            this.f1048a.send(Message.obtain(null, 16, this.f1050a.f991a));     // Catch: RemoteException -> L25
        L23:
            this.f1053a.a(this.f1050a, this, r101, r111, r112);
            return;
        L16:
            if ("wait".equals(r113) == false) goto L18;
            this.f464215a++;
            goto L23
        L13:
            r101 = false;
            goto L14
        }

        public static /* synthetic */ boolean a(b r100, int r101, int r102, String r103) {
            return r100.a(r101, r102, r103);
        }

        public void a(c r100, int r101, int r102, String r103, String r104) {
            Iterator<a> r105 = this.f1055a.iterator();
        L4:
            if (r105.hasNext() == false) goto L8;
            a r106 = r105.next();
            if (r106 == null) goto L4;
            r106.a(this.f1052a, r100, r102);
            goto L4
        L8:
            c r107 = this.f1052a;
            int r108 = 0;
            if (r107 == r100) goto L12;
            com.xiaomi.channel.commonutils.logger.b.m8718a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{r107, r100, a(r101), an.a(r102), r103, r104, this.f464221g}));
            this.f1052a = r100;
        L12:
            if (this.f1053a != null) goto L16;
            com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            return;
        L16:
            if (r100 != c.f464233b) goto L19;
            return;
        L19:
            if (this.f464216b == null) goto L28;
            boolean r109 = this.f1058b;
            if (r109 == false) goto L28;
            if (this.f1048a == null) goto L27;
            if (r109 == false) goto L27;
            r108 = 1000;
        L27:
            r108 = 10100;
        L28:
            this.f1050a.b(this.f1051a);
            if (b(r101, r102, r104) == false) goto L31;
            a(r101, r102, r103, r104);
            return;
        L31:
            this.f1050a.a(this.f1051a.a(r101, r102, r103, r104), r108);
        }

        public static /* synthetic */ void a(b r100, int r101, int r102, String r103, String r104) {
            r100.a(r101, r102, r103, r104);
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f464232a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private static final /* synthetic */ c[] f1062a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f464233b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f464234c = null;

        static {
            c r100 = new c("unbind", 0);
            f464232a = r100;
            c r101 = new c("binding", 1);
            f464233b = r101;
            c r102 = new c("binded", 2);
            f464234c = r102;
            f1062a = new c[]{r100, r101, r102};
        }

        public static c[] values() {
            return (c[]) f1062a.clone();
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        private c(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m9360a() {
        monitor-enter(this);
        ArrayList<b> r100 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<HashMap<String, b>> r101 = this.f1045a.values().iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L8;
        r100.addAll(r101.next().values());     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void b() {
        monitor-enter(this);
        this.f1044a.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private am() {
        this.f1045a = new ConcurrentHashMap();
        this.f1044a = new ArrayList();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m9363a() {
        monitor-enter(this);
        Iterator<b> r100 = m9360a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r100.hasNext() == false) goto L7;
        r100.next().m9367a();     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f1045a.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized am a() {
        monitor-enter(am.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f464214a != null) goto L7;
        f464214a = new am();     // Catch: Throwable -> L10
    L7:
        am r100 = f464214a;     // Catch: Throwable -> L10
        monitor-exit(am.class);
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m9359a() {
        monitor-enter(this);
        int r100 = this.f1045a.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(b r100) {
        monitor-enter(this);
        HashMap<String, b> r101 = this.f1045a.get(r100.f464221g);     // Catch: Throwable -> L14
        if (r101 != null) goto L7;
        r101 = new HashMap();     // Catch: Throwable -> L14
        this.f1045a.put(r100.f464221g, r101);     // Catch: Throwable -> L14
    L7:
        r101.put(a(r100.f1057b), r100);     // Catch: Throwable -> L14
        com.xiaomi.channel.commonutils.logger.b.m8718a("add active client. " + r100.f1054a);     // Catch: Throwable -> L14
        Iterator<a> r102 = this.f1044a.iterator();     // Catch: Throwable -> L14
    L8:
        if (r102.hasNext() == false) goto L12;
        r102.next().a();     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m9364a(String r100) {
        monitor-enter(this);
        HashMap<String, b> r101 = this.f1045a.get(r100);     // Catch: Throwable -> L17
        if (r101 == null) goto L10;
        Iterator<b> r102 = r101.values().iterator();     // Catch: Throwable -> L17
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().m9367a();     // Catch: Throwable -> L17
        goto L7
    L9:
        r101.clear();     // Catch: Throwable -> L17
        this.f1045a.remove(r100);     // Catch: Throwable -> L17
    L10:
        Iterator<a> r103 = this.f1044a.iterator();     // Catch: Throwable -> L17
    L11:
        if (r103.hasNext() == false) goto L15;
        r103.next().a();     // Catch: Throwable -> L17
        goto L11
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m9362a(String r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<HashMap<String, b>> r102 = this.f1045a.values().iterator();     // Catch: Throwable -> L15
    L5:
        if (r102.hasNext() == false) goto L13;
        Iterator<b> r103 = r102.next().values().iterator();     // Catch: Throwable -> L15
    L8:
        if (r103.hasNext() == false) goto L5;
        b r104 = r103.next();     // Catch: Throwable -> L15
        if (r100.equals(r104.f1054a) == false) goto L8;
        r101.add(r104.f464221g);     // Catch: Throwable -> L15
        goto L8
    L13:
        monitor-exit(this);
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void a(Context r100) {
        monitor-enter(this);
        Iterator<HashMap<String, b>> r101 = this.f1045a.values().iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        Iterator<b> r102 = r101.next().values().iterator();     // Catch: Throwable -> L13
    L8:
        if (r102.hasNext() == false) goto L5;
        r102.next().a(c.f464232a, 1, 3, null, null);     // Catch: Throwable -> L13
        goto L8
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m9361a(String r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1045a.containsKey(r100) == true) goto L8;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        Collection<b> r102 = ((HashMap) this.f1045a.get(r100).clone()).values();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    }

    private String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        int r101 = r100.indexOf("@");
        if (r101 > 0) goto L9;
        return r100;
    L9:
        return r100.substring(0, r101);
    }

    public synchronized void a(a r100) {
        monitor-enter(this);
        this.f1044a.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m9365a(String r100, String r101) {
        monitor-enter(this);
        HashMap<String, b> r102 = this.f1045a.get(r100);     // Catch: Throwable -> L18
        if (r102 == null) goto L11;
        b r103 = r102.get(a(r101));     // Catch: Throwable -> L18
        if (r103 == null) goto L8;
        r103.m9367a();     // Catch: Throwable -> L18
    L8:
        r102.remove(a(r101));     // Catch: Throwable -> L18
        if (r102.isEmpty() == false) goto L11;
        this.f1045a.remove(r100);     // Catch: Throwable -> L18
    L11:
        Iterator<a> r104 = this.f1044a.iterator();     // Catch: Throwable -> L18
    L12:
        if (r104.hasNext() == false) goto L16;
        r104.next().a();     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized void a(Context r100, int r110) {
        monitor-enter(this);
        Iterator<HashMap<String, b>> r101 = this.f1045a.values().iterator();     // Catch: Throwable -> L13
    L5:
        if (r101.hasNext() == false) goto L11;
        Iterator<b> r102 = r101.next().values().iterator();     // Catch: Throwable -> L13
    L8:
        if (r102.hasNext() == false) goto L5;
        r102.next().a(c.f464232a, 2, r110, null, null);     // Catch: Throwable -> L13
        goto L8
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized b a(String r100, String r101) {
        monitor-enter(this);
        HashMap<String, b> r102 = this.f1045a.get(r100);     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        b r103 = r102.get(a(r101));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }
}
