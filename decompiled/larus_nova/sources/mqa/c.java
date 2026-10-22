package mqa;

import android.app.servertransaction.ClientTransaction;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.LaunchActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f514906k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uqa.a f514907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f514908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f514909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f514910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f514911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f514912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f514913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Integer> f514914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f514915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f514916j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f514917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f514918b;

        public final void a() {
            Object r100 = this.f514918b.f514916j;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            nqa.b r101 = new nqa.b();     // Catch: Throwable -> L7
            r101.f520152b = this.f514917a;     // Catch: Throwable -> L7
            r101.f520153c = ToolUtils.currentTimeMillis();     // Catch: Throwable -> L7
            nqa.a.a(this.f514918b.f514908b).c(r101);     // Catch: Throwable -> L7
            this.f514918b.f514915i = true;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
        L17:
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, String r101) {
            this.f514918b = r100;
            this.f514917a = r101;
        }
    }

    public final void c() {
        this.f514911e = true;
        com.bytedance.push.utils.f.b("ActivityThreadHandler", "processLogEnd,mProcessStartInfo is " + this.f514913g.a().toString());
        Context r100 = this.f514908b;
        if (g.f514930c != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g.f514930c != null) goto L9;
        g.f514930c = new g(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        if (g.f514930c.a().f514933a == true) goto L18;
        return;
    L18:
        if (d.a(this.f514908b).f514922c == true) goto L20;
        return;
    L20:
        String r101 = this.f514913g.a().toString();
        if (com.bytedance.push.utils.f.f267065a == false) goto L23;
        com.bytedance.push.utils.f.e("ActivityThreadHandler", "processLogEnd: " + r101);
    L23:
        ThreadPlus.submitRunnable(new a(this, r101));
    }

    public static int a(Object r100) {
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return 0;
    L4:
        if ((r100 instanceof ClientTransaction) == true) goto L6;
        return 0;
    L6:
        if ((qqa.c.b(ClientTransaction.class, new Class[0]).invoke(r100, new Object[0]) instanceof ResumeActivityItem) == false) goto L12;
        return 3;
    }

    public final void b(Message r100) {
        if (f514906k == 3) goto L5;
        return;
    L5:
        Object r101 = r100.obj;
        int r102 = r100.what;     // Catch: Throwable -> L25
        if (r102 != 100) goto L10;
        Field r103 = r101.getClass().getDeclaredField("intent");     // Catch: Throwable -> L25
        r103.setAccessible(true);     // Catch: Throwable -> L25
        Intent r104 = (Intent) r103.get(r101);     // Catch: Throwable -> L25
        i r105 = this.f514913g;     // Catch: Throwable -> L25
        r105.f514940e = 4;     // Catch: Throwable -> L25
        r105.f514941f = r104;     // Catch: Throwable -> L25
        c();     // Catch: Throwable -> L25
        return;
    L10:
        if (r102 == 159) goto L12;
        return;
    L12:
        if ((r101 instanceof ClientTransaction) == true) goto L14;
        return;
    L14:
        if ((qqa.c.b(ClientTransaction.class, new Class[0]).invoke(r101, new Object[0]) instanceof ResumeActivityItem) == false) goto L35;
        Method r106 = ClientTransaction.class.getDeclaredMethod("getCallbacks", new Class[0]);     // Catch: Throwable -> L25
        r106.setAccessible(true);     // Catch: Throwable -> L25
        Iterator r107 = ((List) r106.invoke(r101, new Object[0])).iterator();     // Catch: Throwable -> L25
    L17:
        if (r107.hasNext() == false) goto L21;
        ClientTransactionItem r108 = (ClientTransactionItem) r107.next();     // Catch: Throwable -> L25
        if (TextUtils.equals(r108.getClass().getCanonicalName(), LaunchActivityItem.class.getCanonicalName()) == false) goto L17;
    L22:
        if (r108 == null) goto L36;
        Field r109 = qqa.a.a(LaunchActivityItem.class, "mIntent");     // Catch: Throwable -> L25
        Field r110 = qqa.a.a(LaunchActivityItem.class, "mInfo");     // Catch: Throwable -> L25
        r109.setAccessible(true);     // Catch: Throwable -> L25
        r110.setAccessible(true);     // Catch: Throwable -> L25
        Intent r111 = (Intent) r109.get(r108);     // Catch: Throwable -> L25
        r111.setExtrasClassLoader(c.class.getClassLoader());     // Catch: Throwable -> L25
        i r112 = this.f514913g;     // Catch: Throwable -> L25
        r112.f514940e = 4;     // Catch: Throwable -> L25
        r112.f514941f = r111;     // Catch: Throwable -> L25
        c();     // Catch: Throwable -> L25
        return;
    L36:
        return;
    L21:
        r108 = null;
        goto L22
    L35:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
    }

    public final void d(Message r100) {
        if (f514906k == 1) goto L19;
        return;
    L19:
        Object r101 = r100.obj;     // Catch: Throwable -> L15
        int r102 = r100.what;     // Catch: Throwable -> L15
        if (r102 != 114) goto L9;
        Field r103 = r101.getClass().getDeclaredField("info");     // Catch: Throwable -> L15
        r103.setAccessible(true);     // Catch: Throwable -> L15
        this.f514913g.f514939d = (ServiceInfo) r103.get(r101);     // Catch: Throwable -> L15
    L18:
        return;
    L9:
        if (r102 != 115) goto L12;
        Field r104 = r101.getClass().getDeclaredField("args");     // Catch: Throwable -> L15
        r104.setAccessible(true);     // Catch: Throwable -> L15
        Intent r105 = (Intent) r104.get(r101);     // Catch: Throwable -> L15
        i r106 = this.f514913g;     // Catch: Throwable -> L15
        r106.f514941f = r105;     // Catch: Throwable -> L15
        r106.f514940e = 1;     // Catch: Throwable -> L15
        c();     // Catch: Throwable -> L15
        goto L18
    L12:
        if (r102 != 121) goto L18;
        Field r107 = r101.getClass().getDeclaredField("intent");     // Catch: Throwable -> L15
        r107.setAccessible(true);     // Catch: Throwable -> L15
        Intent r108 = (Intent) r107.get(r101);     // Catch: Throwable -> L15
        i r109 = this.f514913g;     // Catch: Throwable -> L15
        r109.f514941f = r108;     // Catch: Throwable -> L15
        r109.f514940e = 2;     // Catch: Throwable -> L15
        c();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        c();
    }

    public c(Context r100, uqa.a r101) {
        this.f514909c = 0;
        this.f514910d = true;
        this.f514911e = false;
        this.f514912f = "";
        this.f514913g = new i();
        ArrayList r102 = new ArrayList();
        this.f514914h = r102;
        this.f514915i = false;
        this.f514916j = new Object();
        this.f514908b = r100;
        this.f514907a = r101;
        r102.add(100);
        r102.add(113);
        r102.add(114);
        r102.add(115);
        r102.add(121);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r102.add(159);
        return;
    }
}
