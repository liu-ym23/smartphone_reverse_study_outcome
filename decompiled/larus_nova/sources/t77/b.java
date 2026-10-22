package t77;

import com.bytedance.common.push.BaseJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f544901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f544902b;

    public final String toString() {
        JSONObject r100 = new JSONObject();
        add(r100, "callback_msg_arrive", this.f544901a);
        add(r100, "callback_msg_click", this.f544902b);
        return r100.toString();
    }

    public b() {
        this.f544901a = false;
        this.f544902b = false;
    }

    public b(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L5
        this.f544901a = r101.optBoolean("callback_msg_arrive", false);     // Catch: Throwable -> L5
        this.f544902b = r101.optBoolean("callback_msg_click", false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        this.f544901a = false;
        this.f544902b = false;
    }
}
