package vb4;

import android.text.TextUtils;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements b {
    public final /* synthetic */ TuringLiveDetectActivity a;

    public v(TuringLiveDetectActivity r1) {
        this.a = r1;
    }

    public final void a(JSONObject r12) {
        boolean r0 = r12.optBoolean("success");
        this.a.h.setText("PTY运行正常:" + r0);
        StringBuilder r1 = new StringBuilder("totalTime:");
        long r2 = r12.optLong("convert_camera_data_time_use");
        long r4 = r12.optLong("pty_time_use");
        int r8 = r12.optInt("status", -1);
        String r10 = "";
        String r9 = r12.optString("debugInfo", "");
        r1.append(r2 + r4);
        r1.append("\ncameraTime:");
        r1.append(r2);
        r1.append("\nptyTime:");
        r1.append(r4);
        r1.append("\n---------\nstatus:");
        r1.append(r8);
        r1.append("\ndebug:");
        r1.append(r9);
        r1.append("\n");
        this.a.m.setText(r1.toString());
        if (r0 == false) goto L7;
        this.a.i.setText("");
        return;
    L7:
        if (r12.opt("ptyError") == null) goto L10;
        r10 = r12.opt("ptyError").toString();
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        if (r10.contains("Continuous 3 exceptions") == true) goto L16;
        this.a.i.setText("PTYError:\n".concat(r10));
        return;
    }
}
