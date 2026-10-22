package y67;

import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f566359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f566360d;

    public a(Map<String, String> r100) {
        if (r100 != null) goto L5;
        r100 = new HashMap();
    L5:
        this.f566357a = r100.get("callback_intent");
        this.f566358b = r100.get("harmony_listen_method");
        this.f566360d = ToolUtils.parseInt(r100.get("kill_process_mode"), 1);
        this.f566359c = ToolUtils.stringDividedByCommaToList(r100.get("listen_type"));
    }
}
