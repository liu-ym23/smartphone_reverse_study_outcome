package eq8;

import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f473546d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f473547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f473548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f473549c;

    /* JADX INFO: renamed from: eq8.a$a, reason: collision with other inner class name */
    public static final class C5803a {
    }

    static {
    }

    public a() {
        this.f473547a = "";
        this.f473548b = "";
        this.f473549c = "";
    }

    public static void b(a r100, String r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        r100.a("DEFAULT", r101, r102, null);
    }

    public final void c(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        a(SuggestPromptErrorType.ERROR_TYPE_SERIOUS_PROBLEMS, r100, r101, r102);
    }

    public final void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r101, "suggestActionType");
        Intrinsics.checkNotNullParameter(r102, "userPrompt");
        this.f473547a = r100;
        this.f473548b = r101;
        this.f473549c = r102;
    }

    public final void a(@SuggestPromptErrorType String r100, String r101, String r102, JSONObject r103) {
        if (r103 == null) goto L9;
    L4:
        r103.put("enter_method", this.f473547a);     // Catch: Exception -> L6
        r103.put("suggest_action_type", this.f473548b);     // Catch: Exception -> L6
        r103.put("user_prompt", this.f473549c);     // Catch: Exception -> L6
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L6
        r104.put("error_type", r100);     // Catch: Exception -> L6
        r104.put("action_type", r101);     // Catch: Exception -> L6
        r104.put("error_msg", r102);     // Catch: Exception -> L6
        r104.put("extra", r103);     // Catch: Exception -> L6
        o.f365780a.reportEvent("prompt_multi_actions_error_monitor", r104);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        g.f365738a.ensureNotReachHere(e);
        return;
    L9:
        r103 = new JSONObject();     // Catch: Exception -> L6
        goto L4
    }
}
