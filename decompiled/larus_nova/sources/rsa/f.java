package rsa;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.view.Display;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f539155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.a f539156b;

    public final void a() {
        Object r100 = g.f539157a;
        monitor-enter(r100);
    L105:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        DisplayManager r101 = (DisplayManager) this.f539155a.getSystemService(DisplayManager.class);     // Catch: Throwable -> L105
    L7:
        DisplayManager r102 = r101;
        Display[] r103 = r102.getDisplays();     // Catch: Throwable -> L105
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L105
        int r105 = r103.length;     // Catch: Throwable -> L105
        int r106 = 0;
    L10:
        VirtualDisplay r110 = null;
        String r111 = null;
        if (r106 >= r105) goto L121;
        Display r107 = r103[r106];     // Catch: Throwable -> L105
        if (r107.getDisplayId() != 0) goto L16;
    L30:
        r104.add(Integer.valueOf(r107.getDisplayId()));     // Catch: Throwable -> L105
        r106 = r106 + 1;
        goto L10
    L16:
        if ((r107.getFlags() & 8) == 0) goto L30;
        Object[] r108 = new Object[0];     // Catch: Throwable -> L109
        Method r109 = g.b.b(Display.class, "getOwnerPackageName", null, r108);     // Catch: Exception -> L108 Throwable -> L109
        if (r109 == null) goto L22;
        Object r112 = r109.invoke(r107, r108);     // Catch: Exception -> L108 Throwable -> L109
    L23:
        r111 = (String) r112;     // Catch: Throwable -> L109
    L22:
        r112 = null;
    L25:
        g.a r113 = this.f539156b;     // Catch: Throwable -> L105
        if (r113 == null) goto L28;
        ((com.ss.android.bytedcert.face.c.f.a) r113).a(true, r111);     // Catch: Throwable -> L105
    L28:
        monitor-exit(r100);     // Catch: Throwable -> L105
        return;
    L121:
        Object[] r114 = {"display"};     // Catch: Throwable -> L113
        Method r115 = g.b.b(g.b.a("android.os.ServiceManager"), "getService", null, r114);     // Catch: Exception -> L112 Throwable -> L113
        if (r115 == null) goto L37;
        Object r116 = r115.invoke(null, r114);     // Catch: Exception -> L112 Throwable -> L113
    L39:
        if ((r116 instanceof IBinder) == false) goto L50;
        Object[] r117 = {r116};     // Catch: Throwable -> L113
        Method r118 = g.b.b(g.b.a("android.hardware.display.IDisplayManager$Stub"), "asInterface", null, r117);     // Catch: Exception -> L111 Throwable -> L113
        if (r118 == null) goto L45;
        Object r119 = r118.invoke(null, r117);     // Catch: Exception -> L111 Throwable -> L113
    L47:
        if ((r119 instanceof IInterface) == false) goto L50;
        IInterface r120 = (IInterface) r119;     // Catch: Throwable -> L113
    L131:
        VirtualDisplay r121 = r102.createVirtualDisplay("Test", 1, 1, 1, null, 8);     // Catch: Throwable -> L57 RuntimeException -> L61
        int r122 = r121.getDisplay().getDisplayId();     // Catch: Throwable -> L54 RuntimeException -> L56
        r121.release();     // Catch: Throwable -> L105
    L65:
        if (r120 != null) goto L116;
        g.a r123 = this.f539156b;     // Catch: Throwable -> L105
        if (r123 == null) goto L69;
        ((com.ss.android.bytedcert.face.c.f.a) r123).a(false, null);     // Catch: Throwable -> L105
    L69:
        monitor-exit(r100);     // Catch: Throwable -> L105
        return;
    L116:
        Method r124 = g.b.b(r120.getClass(), "isMinimalPostProcessingRequested", new Class[]{Integer.TYPE}, new Object[0]);     // Catch: Throwable -> L73
    L74:
        if (r124 != null) goto L80;
        g.a r125 = this.f539156b;     // Catch: Throwable -> L105
        if (r125 == null) goto L78;
        ((com.ss.android.bytedcert.face.c.f.a) r125).a(false, null);     // Catch: Throwable -> L105
    L78:
        monitor-exit(r100);     // Catch: Throwable -> L105
        return;
    L80:
        SharedPreferences r126 = this.f539155a.getSharedPreferences("record_check", 0);     // Catch: Throwable -> L105
        int r127 = r126.getInt("last_check_display_id", 0);     // Catch: Throwable -> L105
        if (r127 <= r122) goto L83;
        r127 = 0;
    L83:
        if (r127 >= r122) goto L100;
        Object r128 = r124.invoke(r120, new Object[]{Integer.valueOf(r127)});     // Catch: Throwable -> L110
        if ((r128 instanceof Boolean) == true) goto L87;
        byte r129 = -1;
    L91:
        if (r129 == (-1)) goto L99;
        if (r104.contains(Integer.valueOf(r127)) == true) goto L99;
        r126.edit().putInt("last_check_display_id", r127).apply();     // Catch: Throwable -> L110
        g.a r130 = this.f539156b;     // Catch: Throwable -> L110
        if (r130 == null) goto L97;
        ((com.ss.android.bytedcert.face.c.f.a) r130).a(true, null);     // Catch: Throwable -> L110
    L97:
        monitor-exit(r100);     // Catch: Throwable -> L105
        return;
    L87:
        if (((Boolean) r128).booleanValue() == false) goto L89;
        r129 = 1;
        goto L91
    L89:
        r129 = 0;
    L99:
        r127 = r127 + 1;     // Catch: Throwable -> L105
        goto L83
    L100:
        r126.edit().putInt("last_check_display_id", r127).apply();     // Catch: Throwable -> L105
        g.a r131 = this.f539156b;     // Catch: Throwable -> L105
        if (r131 == null) goto L103;
        ((com.ss.android.bytedcert.face.c.f.a) r131).a(false, null);     // Catch: Throwable -> L105
    L103:
        monitor-exit(r100);     // Catch: Throwable -> L105
        return;
    L73:
        r124 = null;
        goto L74
    L54:
        th = th;
        r110 = r121;
    L58:
        if (r110 == null) goto L60;
        r110.release();     // Catch: Throwable -> L105
    L60:
        throw th;     // Catch: Throwable -> L105
    L62:
        if (r121 == null) goto L64;
        r121.release();     // Catch: Throwable -> L105
    L64:
        r122 = 0;
        goto L65
    L61:
        r121 = null;
    L57:
        th = th;
    L45:
        r119 = null;
    L37:
        r116 = null;
    L50:
        r120 = null;
        goto L131
    L8:
        r101 = (DisplayManager) this.f539155a.getSystemService("display");     // Catch: Throwable -> L105
        goto L7
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

    public f(Context r100, com.ss.android.bytedcert.face.c.f.a r101) {
        this.f539155a = r100;
        this.f539156b = r101;
    }
}
