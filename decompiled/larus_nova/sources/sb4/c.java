package sb4;

import com.bytedance.bdturing.EventReport;
import org.json.JSONObject;
import qb4.g0;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f541215a;

    @Override // qb4.g0
    public final void c() {
        long r100 = System.currentTimeMillis() - this.f541215a;
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("key", "common_web_load_success");     // Catch: Exception -> L5
        r101.put("duration", r100);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r101, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public c(long r100) {
        this.f541215a = r100;
    }

    @Override // qb4.g0
    public final void b(int r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("key", "common_web_load_fail");     // Catch: Exception -> L5
        r102.put("custom", "errorCode:" + r100 + ";errorMessage:" + r101);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r102, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // qb4.g0
    public final void a(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        r103.put("key", "common_web_error");     // Catch: Exception -> L5
        r103.put("custom", "errorCode:" + r100 + ";errorMessage:" + r102 + ";url=" + r101);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r103, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
