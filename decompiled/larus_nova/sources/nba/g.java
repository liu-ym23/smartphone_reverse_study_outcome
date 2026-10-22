package nba;

import com.bytedance.applog.p;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.applog.AppLogIDLStub;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements p {
    public g() {
    }

    @Override // com.bytedance.applog.p
    public final void onSessionStart(final long r100, final String r101) {
        FLogger.f375446a.d(AppLogIDLStub.TAG, "onSessionStart, id: " + r100 + ", sessonId: " + r101);
        c.f518562a.getClass();
        com.obric.aiagent.ipc.utils.d.a(c.f518563b, new f(r100, r101));
    }

    @Override // com.bytedance.applog.p
    public final void a(final long r100, final String r101, JSONObject r102) {
        FLogger.f375446a.d(AppLogIDLStub.TAG, "onSessionTerminate, id: " + r100 + ", sessonId: " + r101 + ", appLog: " + r102);
        c.f518562a.getClass();
        com.obric.aiagent.ipc.utils.d.a(c.f518563b, new d(r100, r101));
    }

    @Override // com.bytedance.applog.p
    public final void b(final long r100, final String r101, JSONObject r102) {
        FLogger.f375446a.d(AppLogIDLStub.TAG, "onSessionBatchEvent, id: " + r100 + ", sessonId: " + r101 + ", appLog: " + r102);
        c.f518562a.getClass();
        com.obric.aiagent.ipc.utils.d.a(c.f518563b, new e(r100, r101));
    }
}
