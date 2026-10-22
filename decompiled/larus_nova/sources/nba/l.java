package nba;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.applog.AppLogIDLStub;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements com.bytedance.applog.h {
    public l() {
    }

    @Override // com.bytedance.applog.h
    public final void a(boolean r100, JSONObject r101) {
    }

    @Override // com.bytedance.applog.h
    public final void onIdLoaded(final String r100, final String r101, final String r102) {
        FLogger.f375446a.i(AppLogIDLStub.TAG, "onIdLoaded, did: " + r100 + ", iid: " + r101 + ", ssid: " + r102);
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        c r104 = c.f518562a;
        if (c.b(r104, r100) == false) goto L22;
        Object r105 = c.f518566e;
        monitor-enter(r105);
        c.f518568g = c.f();     // Catch: Throwable -> L19
        c.f518571j = 0;     // Catch: Throwable -> L19
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r105);
        c.g("onIdLoaded", r100, "external", null);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        c.c(r104, "onIdLoaded");
        com.obric.aiagent.ipc.utils.d.a(c.f518565d, new j(r100, r101, r102));
        c.d(r104, r100, r101, r102);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.applog.h
    public final void onRemoteIdGet(final boolean r110, final String r111, final String r112, final String r113, final String r114, final String r210, final String r211) {
        FLogger.f375446a.i(AppLogIDLStub.TAG, "addDataObserver onRemoteIdGet, changed: " + r110 + ", oldDid: " + r111 + ", newDid: " + r112 + ", oldIid: " + r113 + ", newIid: " + r114 + ", oldSsid: " + r210 + ", newSsid: " + r211);
        c r115 = c.f518562a;
        if (c.b(r115, r112) == false) goto L13;
        Object r100 = c.f518566e;
        monitor-enter(r100);
        c.f518568g = c.f();     // Catch: Throwable -> L10
        c.f518571j = 0;     // Catch: Throwable -> L10
        c.f518570i = false;     // Catch: Throwable -> L10
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        c.g("onRemoteIdGet", r112, "external", null);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        c.c(r115, "onRemoteIdGet");
        com.obric.aiagent.ipc.utils.d.a(c.f518565d, new k(r110, r111, r112, r113, r114, r210, r211));
        c.d(r115, r112, r114, r211);
    }
}
