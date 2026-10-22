package nj4;

import com.bytedance.dora.bwdl.session.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pk4.l;
import rj4.d;
import rj4.g;
import sj4.f;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f519434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f519435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Session.a f519436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Session f519437d;

    /* JADX INFO: renamed from: nj4.a$a, reason: collision with other inner class name */
    public static class C6935a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f519438a = null;

        static {
            f519438a = new a();
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
        qj4.a.c("BWDLManager", "unregisterRTCChannel called");     // Catch: Throwable -> L6
        c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f519434a = d.e();
        g.a();
        this.f519435b = new f();
    }

    public final synchronized void c() {
        monitor-enter(this);
        qj4.a.c("BWDLManager", "call stop");     // Catch: Throwable -> L20
        this.f519434a.b("bwdl_stop");     // Catch: Throwable -> L20
        Session r100 = this.f519437d;     // Catch: Throwable -> L20
        if (r100 != null) goto L25;
    L11:
        f r101 = this.f519435b;     // Catch: Throwable -> L20
        if (r101 != null) goto L23;
    L18:
        monitor-exit(this);
        return;
    L23:
        r101.b();     // Catch: Exception -> L15 Throwable -> L20
    L17:
        this.f519435b = new f();     // Catch: Throwable -> L20
        goto L18
    L15:
        e = move-exception;
        qj4.a.b("BWDLManager", "stop: error closing proxy " + e.getMessage());     // Catch: Throwable -> L20
        goto L17
    L25:
        r100.f204379a.close();     // Catch: Exception -> L8 Throwable -> L20
    L10:
        this.f519437d = null;     // Catch: Throwable -> L20
        goto L11
    L8:
        e = move-exception;
        qj4.a.b("BWDLManager", "stop: error closing session " + e.getMessage());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(List r100) {
        monitor-enter(this);
        qj4.a.c("BWDLManager", "registerRTCChannel called, config list: " + r100);     // Catch: Throwable -> L34
        ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L34
        if (r101.isEmpty() == false) goto L9;
        qj4.a.d("BWDLManager", "registerRTCChannel failed: config list is null or empty");     // Catch: Throwable -> L34
        this.f519434a.b("empty_config");     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L9:
        qj4.a.c("BWDLManager", "registerRTCChannel: Session is " + this.f519437d);     // Catch: Throwable -> L34
        if (this.f519437d != null) goto L14;
        qj4.a.c("BWDLManager", "registerRTCChannel: Session is not initialized, calling start()");     // Catch: Throwable -> L34
        b(r100);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L14:
        qj4.a.c("BWDLManager", "registerRTCChannel: Session already exists, dynamically adding new channels");     // Catch: Throwable -> L34
        if (this.f519435b == null) goto L31;
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L34
    L18:
        if (r102.hasNext() == false) goto L32;
        c r103 = (c) r102.next();     // Catch: Throwable -> L34
        if (r103 == null) goto L30;
    L22:
        if (this.f519435b.a(r103.f519440a, r103.f519441b, r103.f519442c, r103.f519443d) == true) goto L23;
        qj4.a.d("BWDLManager", "registerRTCChannel: Channel " + r103.f519440a + " already exists or failed to add");     // Catch: Exception -> L28 Throwable -> L34
        goto L18
    L23:
        qj4.a.c("BWDLManager", "registerRTCChannel: Successfully added or update channel " + r103.f519440a);     // Catch: Exception -> L28 Throwable -> L34
        if (r103.f519440a != 0) goto L18;
        this.f519434a.d();     // Catch: Exception -> L28 Throwable -> L34
    L28:
        e = move-exception;
        qj4.a.b("BWDLManager", "registerRTCChannel: Exception while adding channel " + r103.f519440a + ", error: " + e.getMessage());     // Catch: Throwable -> L34
        Map<String, Object> r104 = b.a(2);     // Catch: Throwable -> L34
        ((HashMap) r104).put("msg", e.toString());     // Catch: Throwable -> L34
        l.c("d_bt_rtc_error", r104);     // Catch: Throwable -> L34
        goto L18
    L30:
        qj4.a.d("BWDLManager", "registerRTCChannel: Encountered null config in the list");     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L31:
        qj4.a.b("BWDLManager", "registerRTCChannel: mBWDLSocketProxy is null");     // Catch: Throwable -> L34
        this.f519434a.b("proxy_null");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean b(List<c> r110) {
        monitor-enter(this);
        qj4.a.c("BWDLManager", "call start");     // Catch: Throwable -> L29
        this.f519436c = new Session.a(Session.SessionType.SESSION_TYPE_BYTE_LINK, new Session.DataType[]{Session.DataType.DATA_TYPE_MESSAGE, Session.DataType.DATA_TYPE_AUDIO, Session.DataType.DATA_TYPE_VIDEO}, new pj4.b());     // Catch: Throwable -> L29
        Session.a r100 = this.f519436c;     // Catch: Throwable -> L29
        Session r101 = new Session(r100);     // Catch: Throwable -> L29
        this.f519437d = r101;     // Catch: Throwable -> L29
        r101.f204379a.open(r100.f204383b);     // Catch: Throwable -> L29
        f r102 = this.f519435b;     // Catch: Throwable -> L29
        r102.f542294e = this.f519437d;     // Catch: Throwable -> L29
        r102.f542295f = true;     // Catch: Throwable -> L29
        Iterator r111 = ((ArrayList) r110).iterator();     // Catch: Throwable -> L29
        boolean r103 = true;
        boolean r104 = false;
    L5:
        if (r111.hasNext() == false) goto L16;
        c r105 = (c) r111.next();     // Catch: Throwable -> L29
        if (r105 == null) goto L8;
        boolean r106 = this.f519435b.a(r105.f519440a, r105.f519441b, r105.f519442c, r105.f519443d);     // Catch: Throwable -> L29
        r103 = r103 & r106;     // Catch: Throwable -> L29
        if (r106 == true) goto L12;
    L14:
        boolean r107 = false;
    L15:
        r104 = r104 | r107;     // Catch: Throwable -> L29
        goto L5
    L12:
        if (r105.f519440a != 0) goto L14;
        r107 = true;
        goto L15
    L8:
        qj4.a.d("BWDLManager", "start: Encountered null config in the list");     // Catch: Throwable -> L29
        r103 = false;
        goto L5
    L16:
        if (r103 == false) goto L22;
        if (r104 == false) goto L22;
        this.f519434a.d();     // Catch: Throwable -> L29
        this.f519435b.d();     // Catch: Throwable -> L29
        monitor-exit(this);
        return true;
    L22:
        d r112 = this.f519434a;     // Catch: Throwable -> L29
        if (r104 == false) goto L25;
        String r108 = "add_channel_failed";
    L26:
        r112.b(r108);     // Catch: Throwable -> L29
        c();     // Catch: Throwable -> L29
        monitor-exit(this);
        return false;
    L25:
        r108 = "sink_channel_not_ready";
    L29:
        th = move-exception;
        throw th;
    }
}
