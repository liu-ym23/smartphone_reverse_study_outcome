package sb4;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.comonui.VerifyConfirmDialogActivity;
import org.json.JSONObject;
import qb4.g0;

/* JADX INFO: loaded from: classes12.dex */
public final class n implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f541249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VerifyConfirmDialogActivity f541250b;

    @Override // qb4.g0
    public final void c() {
        long r100 = System.currentTimeMillis() - this.f541249a;
        jc4.m r101 = this.f541250b.f201781f;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("key", "confirm_dialog_load_success");     // Catch: Exception -> L5
        r102.put("duration", r100);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r102, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public n(VerifyConfirmDialogActivity r100, long r101) {
        this.f541250b = r100;
        this.f541249a = r101;
    }

    @Override // qb4.g0
    public final void b(int r100, String r101) {
        jc4.m r102 = this.f541250b.f201781f;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        r103.put("key", "confirm_dialog_load_fail");     // Catch: Exception -> L5
        r103.put("custom", "errorCode:" + r100 + ";errorMessage:" + r101);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L5
    L7:
        VerifyConfirmDialogActivity.f201778p = 2;
        this.f541250b.finish();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // qb4.g0
    public final void a(int r100, String r101, String r102) {
        jc4.m r103 = this.f541250b.f201781f;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L5
        r104.put("key", "confirm_dialog_error");     // Catch: Exception -> L5
        r104.put("custom", "errorCode:" + r100 + ";errorMessage:" + r102 + ";url=" + r101);     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r104, r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
