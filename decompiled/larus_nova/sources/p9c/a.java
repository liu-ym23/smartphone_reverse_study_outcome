package p9c;

import com.bytedance.apm.ApmAgent;
import com.ss.android.lark.ug.scheduler.common.exception.RuleException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f528333a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scenarioId");
        ApmAgent.monitorEvent(RuleException.METRIC_KEY, new JSONObject().put("errorCode", "500"), null, new JSONObject().put("scenarioId", r100).put("errorMsg", r101));
    }
}
