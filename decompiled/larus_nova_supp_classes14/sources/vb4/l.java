package vb4;

import android.text.TextUtils;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.live.Config;
import com.bytedance.bdturing.live.TuringLive;
import com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity;
import com.bytedance.bdturing.livedetect.a;
import com.bytedance.bdturing.setting.e;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements Runnable {
    public final /* synthetic */ TuringLiveByteNNActivity a;

    /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity, java.lang.Object] */
    public final void a() {
        long r0 = System.currentTimeMillis();
        e r2 = e.a;
        String r3 = e.f("model_threshold");
        Config r4 = null;
        if (TextUtils.isEmpty(r3) == false) goto L23;
    L12:
        if (r4 != null) goto L14;
        r4 = new Config();
        r4.detect_model_path = a.f().d();
        r4.kpt_model_path = a.f().h();
    L14:
        int r5 = TuringLive.getInstance().init(r4);
        long r6 = System.currentTimeMillis() - r0;
        jc4.a r1 = this.a.v;
        JSONObject r7 = r4.toJson();
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L17
        r8.put("key", "bytenn_init_result");     // Catch: Exception -> L17
        r8.put("result", r5);     // Catch: Exception -> L17
        r8.put("duration", r6);     // Catch: Exception -> L17
        r8.put("custom", r7);     // Catch: Exception -> L17
        EventReport.w("turing_verify_sdk", r8, r1);     // Catch: Exception -> L17
    L19:
        ?? r9 = this.a;
        int r10 = TuringLiveByteNNActivity.D;
        r9.getClass();
        r9.runOnUiThread(new n(r9, r5));
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L23:
        Config r11 = new Config(new JSONObject(r3));     // Catch: Exception -> L9
        r11.kpt_model_path = a.f().h();     // Catch: Exception -> L7
        r11.detect_model_path = a.f().d();     // Catch: Exception -> L7
        r4 = r11;
    L7:
        Exception e = e;
        r4 = r11;
    L11:
        e.printStackTrace();
    L9:
        e = move-exception;
        e = e;
        goto L11
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

    public l(TuringLiveByteNNActivity r1) {
        this.a = r1;
    }
}
