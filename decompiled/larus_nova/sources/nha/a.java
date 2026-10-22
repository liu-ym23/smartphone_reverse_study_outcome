package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements cy7.b {

    /* JADX INFO: renamed from: nha.a$a, reason: collision with other inner class name */
    public static final class C6928a {
    }

    static {
    }

    public a() {
    }

    @Override // cy7.b
    public final void intercept(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r100.hashCode();
        if (r102 == (-1739677286)) goto L25;
        if (r102 == (-1579666261)) goto L19;
        if (r102 == 1374191827) goto L13;
        return;
    L13:
        if (r100.equals("action_bar_option_click") == false) goto L37;
        IObricTraceParam r103 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r103 == null) goto L31;
        r103.e(r101);
        return;
    L31:
        return;
    L37:
        return;
    L19:
        if (r100.equals("chat_action_bar_show") == false) goto L38;
        IObricTraceParam r104 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r104 == null) goto L33;
        r104.o(r101);
        return;
    L33:
        return;
    L38:
        return;
    L25:
        if (r100.equals("chat_action_bar_click") == false) goto L39;
        IObricTraceParam r105 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r105 == null) goto L35;
        r105.l(r101);
        r105.o(r101);
        return;
    L35:
        return;
    }
}
