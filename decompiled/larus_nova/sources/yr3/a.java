package yr3;

import android.content.ContentValues;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends xr3.a<ms3.a> implements xr3.a.InterfaceC8265a<ms3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f568906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f568907f = null;

    @Override // xr3.a
    public final void e() {
    }

    @Override // xr3.a
    public final void f() {
    }

    static {
        f568907f = new String[]{DBDefinition.ID, NewBroadcastMonitor.CAPTURE.FRONT, "type", "timestamp", "accumulation", InvRouter.VERSION_ID, "source", "status", "scene", "process", "main_process", WsConstants.KEY_SESSION_ID};
    }

    public a() {
    }

    public final ms3.a h(xr3.a.b r210) {
        long r100 = r210.b(DBDefinition.ID);
        long r101 = r210.b(NewBroadcastMonitor.CAPTURE.FRONT);
        String r110 = r210.c("type");
        long r102 = r210.b("timestamp");
        long r111 = r210.b("accumulation");
        long r112 = r210.b(InvRouter.VERSION_ID);
        String r103 = r210.c("source");
        long r104 = r210.b("status");
        String r113 = r210.c("scene");
        int r114 = r210.f564852a.getInt(r210.a("main_process"));     // Catch: Throwable -> L5
    L6:
        String r115 = r210.c("process");
        boolean r105 = true;
        if (r101 == 0) goto L9;
        boolean r106 = true;
    L11:
        if (r104 == 0) goto L13;
        boolean r107 = true;
    L14:
        int r211 = r114;
        ms3.a r116 = new ms3.a(r106, r102, r110, r107, r111, r113, r103);
        r116.f515473j = r115;
        r116.f515464a = r100;
        r116.f515472i = r112;
        if (r211 == 1) goto L18;
        r105 = false;
    L18:
        r116.f515474k = r105;
        r116.f515475l = r210.c(WsConstants.KEY_SESSION_ID);
        return r116;
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = false;
    L5:
        r114 = -1;
        goto L6
    }

    public final synchronized void i(ms3.a r100) {
        monitor-enter(this);
        ContentValues r101 = new ContentValues();     // Catch: Throwable -> L17 Exception -> L20
        int r102 = 0;
        if (r100.f515465b == false) goto L6;
        int r103 = 1;
    L7:
        r101.put(NewBroadcastMonitor.CAPTURE.FRONT, Integer.valueOf(r103));     // Catch: Throwable -> L17 Exception -> L20
        r101.put("source", r100.f515471h);     // Catch: Throwable -> L17 Exception -> L20
        r101.put("type", r100.getType());     // Catch: Throwable -> L17 Exception -> L20
        r101.put("timestamp", Long.valueOf(r100.f515466c));     // Catch: Throwable -> L17 Exception -> L20
        r101.put("accumulation", Long.valueOf(r100.f515470g));     // Catch: Throwable -> L17 Exception -> L20
        r101.put(InvRouter.VERSION_ID, Long.valueOf(r100.f515472i));     // Catch: Throwable -> L17 Exception -> L20
        if (r100.f515468e == false) goto L10;
        int r104 = 1;
    L11:
        r101.put("status", Integer.valueOf(r104));     // Catch: Throwable -> L17 Exception -> L20
        r101.put("scene", r100.f515469f);     // Catch: Throwable -> L17 Exception -> L20
        if (r100.f515474k == false) goto L14;
        r102 = 1;
    L14:
        r101.put("main_process", Integer.valueOf(r102));     // Catch: Throwable -> L17 Exception -> L20
        r101.put("process", r100.f515473j);     // Catch: Throwable -> L17 Exception -> L20
        r101.put(WsConstants.KEY_SESSION_ID, r100.f515475l);     // Catch: Throwable -> L17 Exception -> L20
        insert(r101);     // Catch: Throwable -> L17 Exception -> L20
        monitor-exit(this);
        return;
        goto L21
    L10:
        r104 = 0;
        goto L11
    L6:
        r103 = 0;
    L17:
        th = move-exception;
        throw th;
    }
}
