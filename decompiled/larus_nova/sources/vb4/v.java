package vb4;

import android.text.TextUtils;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class v implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554049a;

    public v(TuringLiveDetectActivity r100) {
        this.f554049a = r100;
    }

    public final void a(JSONObject r110) {
        boolean r100 = r110.optBoolean("success");
        this.f554049a.f201833h.setText("PTY运行正常:" + r100);
        StringBuilder r101 = new StringBuilder("totalTime:");
        long r102 = r110.optLong("convert_camera_data_time_use");
        long r103 = r110.optLong("pty_time_use");
        int r104 = r110.optInt("status", -1);
        String r111 = "";
        String r105 = r110.optString("debugInfo", "");
        r101.append(r102 + r103);
        r101.append("\ncameraTime:");
        r101.append(r102);
        r101.append("\nptyTime:");
        r101.append(r103);
        r101.append("\n---------\nstatus:");
        r101.append(r104);
        r101.append("\ndebug:");
        r101.append(r105);
        r101.append("\n");
        this.f554049a.f201838m.setText(r101.toString());
        if (r100 == false) goto L7;
        this.f554049a.f201834i.setText("");
        return;
    L7:
        if (r110.opt("ptyError") == null) goto L10;
        r111 = r110.opt("ptyError").toString();
    L10:
        if (TextUtils.isEmpty(r111) == false) goto L12;
        return;
    L12:
        if (r111.contains("Continuous 3 exceptions") == true) goto L16;
        this.f554049a.f201834i.setText("PTYError:\n".concat(r111));
        return;
    }
}
