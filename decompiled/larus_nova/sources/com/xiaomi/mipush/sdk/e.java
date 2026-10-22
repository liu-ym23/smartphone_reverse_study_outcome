package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class e implements AbstractPushManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f463059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PushConfiguration f173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<d, AbstractPushManager> f174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f175a;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f463061a = null;

        static {
            int[] r100 = new int[d.values().length];
            f463061a = r100;
            r100[d.f463055a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f463061a[d.f463056b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f463061a[d.f463057c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f463061a[d.f463058d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private void a() {
        PushConfiguration r100 = this.f173a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getOpenHmsPush() == false) goto L8;
        StringBuilder r101 = new StringBuilder("ASSEMBLE_PUSH : ");
        r101.append(" HW user switch : " + this.f173a.getOpenHmsPush() + " HW online switch : " + f.m8767a(this.f172a, d.f463055a) + " HW isSupport : " + h.m8771a(this.f172a));
        com.xiaomi.channel.commonutils.logger.b.m8718a(r101.toString());
    L8:
        if (this.f173a.getOpenHmsPush() == false) goto L17;
        Context r102 = this.f172a;
        d r103 = d.f463055a;
        if (f.m8767a(r102, r103) == false) goto L17;
        if (h.m8771a(this.f172a) == false) goto L17;
        if (m8761a(r103) == true) goto L16;
        a(r103, s.a(this.f172a, r103));
    L16:
        com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
    L23:
        if (this.f173a.getOpenFCMPush() == false) goto L26;
        StringBuilder r104 = new StringBuilder("ASSEMBLE_PUSH : ");
        r104.append(" FCM user switch : " + this.f173a.getOpenFCMPush() + " FCM online switch : " + f.m8767a(this.f172a, d.f463056b) + " FCM isSupport : " + h.b(this.f172a));
        com.xiaomi.channel.commonutils.logger.b.m8718a(r104.toString());
    L26:
        if (this.f173a.getOpenFCMPush() == false) goto L35;
        Context r105 = this.f172a;
        d r106 = d.f463056b;
        if (f.m8767a(r105, r106) == false) goto L35;
        if (h.b(this.f172a) == false) goto L35;
        if (m8761a(r106) == true) goto L34;
        a(r106, s.a(this.f172a, r106));
    L34:
        com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
    L41:
        if (this.f173a.getOpenCOSPush() == false) goto L44;
        StringBuilder r107 = new StringBuilder("ASSEMBLE_PUSH : ");
        r107.append(" COS user switch : " + this.f173a.getOpenCOSPush() + " COS online switch : " + f.m8767a(this.f172a, d.f463057c) + " COS isSupport : " + h.c(this.f172a));
        com.xiaomi.channel.commonutils.logger.b.m8718a(r107.toString());
    L44:
        if (this.f173a.getOpenCOSPush() == false) goto L50;
        Context r108 = this.f172a;
        d r109 = d.f463057c;
        if (f.m8767a(r108, r109) == false) goto L50;
        if (h.c(this.f172a) == false) goto L50;
        a(r109, s.a(this.f172a, r109));
    L56:
        if (this.f173a.getOpenFTOSPush() == false) goto L62;
        Context r110 = this.f172a;
        d r111 = d.f463058d;
        if (f.m8767a(r110, r111) == false) goto L62;
        if (h.d(this.f172a) == false) goto L62;
        a(r111, s.a(this.f172a, r111));
        return;
    L62:
        d r112 = d.f463058d;
        if (m8761a(r112) == false) goto L70;
        AbstractPushManager r113 = a(r112);
        if (r113 == null) goto L71;
        m8760a(r112);
        r113.unregister();
        return;
    L71:
        return;
    L70:
        return;
    L50:
        d r114 = d.f463057c;
        if (m8761a(r114) == false) goto L56;
        AbstractPushManager r115 = a(r114);
        if (r115 == null) goto L56;
        m8760a(r114);
        r115.unregister();
    L35:
        d r116 = d.f463056b;
        if (m8761a(r116) == false) goto L41;
        AbstractPushManager r117 = a(r116);
        if (r117 == null) goto L41;
        m8760a(r116);
        r117.unregister();
    L17:
        d r118 = d.f463055a;
        if (m8761a(r118) == false) goto L23;
        AbstractPushManager r119 = a(r118);
        if (r119 == null) goto L23;
        m8760a(r118);
        r119.unregister();
        goto L23
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : assemble push register");
        if (this.f174a.size() > 0) goto L6;
        a();
    L6:
        if (this.f174a.size() <= 0) goto L20;
        Iterator<AbstractPushManager> r100 = this.f174a.values().iterator();
    L9:
        if (r100.hasNext() == false) goto L13;
        AbstractPushManager r101 = r100.next();
        if (r101 == null) goto L9;
        r101.register();
        goto L9
    L13:
        f.m8763a(this.f172a);
        return;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : assemble push unregister");
        Iterator<AbstractPushManager> r100 = this.f174a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        AbstractPushManager r101 = r100.next();
        if (r101 == null) goto L4;
        r101.unregister();
        goto L4
    L8:
        this.f174a.clear();
    }

    private e(Context r100) {
        this.f175a = false;
        this.f174a = new HashMap();
        this.f172a = r100.getApplicationContext();
    }

    public void a(PushConfiguration r100) {
        this.f173a = r100;
        this.f175a = ah.a(this.f172a).a(gj.f463726ao.a(), true);
        if (this.f173a.getOpenHmsPush() == false) goto L5;
    L10:
        final int r101 = 101;
        final String r102 = "assemblePush";
        ah.a(this.f172a).a(new AnonymousClass1(this, r101, r102));
        return;
    L5:
        if (this.f173a.getOpenFCMPush() == true) goto L10;
        if (this.f173a.getOpenCOSPush() == true) goto L10;
        if (this.f173a.getOpenFTOSPush() == true) goto L10;
    }

    public boolean b(d r100) {
        int r101 = AnonymousClass2.f463061a[r100.ordinal()];
        boolean r102 = false;
        if (r101 != 1) goto L5;
        PushConfiguration r103 = this.f173a;
        if (r103 != null) goto L23;
        return false;
    L23:
        return r103.getOpenHmsPush();
    L5:
        if (r101 != 2) goto L7;
        PushConfiguration r104 = this.f173a;
        if (r104 != null) goto L27;
        return false;
    L27:
        return r104.getOpenFCMPush();
    L7:
        if (r101 != 3) goto L9;
        PushConfiguration r105 = this.f173a;
        if (r105 == null) goto L14;
        r102 = r105.getOpenCOSPush();
    L14:
        PushConfiguration r106 = this.f173a;
        if (r106 != null) goto L25;
        return r102;
    L25:
        return r106.getOpenFTOSPush();
    L9:
        if (r101 == 4) goto L14;
        return false;
    }

    public static e a(Context r100) {
        if (f463059a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463059a != null) goto L9;
        f463059a = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f463059a;
    }

    public AbstractPushManager a(d r100) {
        return this.f174a.get(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8761a(d r100) {
        return this.f174a.containsKey(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8760a(d r100) {
        this.f174a.remove(r100);
    }

    public static /* synthetic */ Context a(e r100) {
        return r100.f172a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ boolean m8759a(e r100) {
        return r100.f175a;
    }

    public void a(d r100, AbstractPushManager r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.f174a.containsKey(r100) == false) goto L6;
        this.f174a.remove(r100);
    L6:
        this.f174a.put(r100, r101);
    }

    public static /* synthetic */ boolean a(e r100, boolean r101) {
        r100.f175a = r101;
        return r101;
    }
}
