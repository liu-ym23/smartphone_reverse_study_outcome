package y67;

import android.text.TextUtils;
import androidx.camera.core.RetryPolicy;
import com.bytedance.mira.conig.Constants;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f566362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f566363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f566364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f566365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f566366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f566367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f566368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f566369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f566370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f566371k;

    public b(Map<String, String> r100) {
        if (r100 != null) goto L5;
        r100 = new HashMap();
    L5:
        this.f566361a = r100.get("callback_intent");
        String r101 = r100.get("screen_action");
        if (TextUtils.isEmpty(r101) == true) goto L8;
        this.f566362b = r101.split(",");
    L8:
        this.f566363c = ToolUtils.parseLong(r100.get("delay_report_in_mill"), 0);
        this.f566364d = ToolUtils.parseLong(r100.get("kill_self_delay_in_mill"), RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        this.f566365e = ToolUtils.parseBool(r100.get("kill_self_after_signal_report"), true);
        this.f566367g = ToolUtils.parseLong(r100.get("min_install_time_in_mill"), Constants.DOWNLOAD_TEMP_FILE_PAST_TIME);
        this.f566368h = ToolUtils.parseLong(r100.get("min_signal_interval_in_mill"), 3600000);
        this.f566366f = ToolUtils.parseBool(r100.get("filter_debug_device"), true);
        this.f566369i = ToolUtils.parseBool(r100.get("filter_sim_card"), true);
        this.f566370j = ToolUtils.parseBool(r100.get("unregister_for_risk_signal"), true);
        this.f566371k = ToolUtils.parseBool(r100.get("unregister_for_un_risk_signal"), false);
        ToolUtils.parseInt(r100.get("kill_process_mode"), 1);
    }
}
