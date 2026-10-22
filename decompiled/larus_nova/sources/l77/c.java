package l77;

import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f507813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507814b;

    public c() {
        this.f507813a = false;
        this.f507814b = 5000;
    }

    public c(JSONObject r100) {
        if (r100 != null) goto L5;
        this.f507813a = false;
        this.f507814b = 5000;
        return;
    L5:
        this.f507813a = r100.optBoolean("enable_client_intelligence_local_push", false);
        r100.optInt("max_try_pull_times", 5);
        this.f507814b = r100.optInt("check_client_feature_interval_in_mill", 5000);
    }
}
