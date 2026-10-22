package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements cy7.b {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // cy7.b
    public final void intercept(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r100.hashCode();
        if (r102 == (-624136624)) goto L19;
        if (r102 == 1268229313) goto L16;
        if (r102 == 1633612112) goto L13;
        return;
    L13:
        if (r100.equals("send_message_response") == false) goto L25;
    L21:
        IObricTraceParam r103 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r103 == null) goto L26;
        int r104 = com.obric.assistant.reporter.utils.g.f391449a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.optString("action_bar_key", "");
        r103.c(r101, r100);
        return;
    L26:
        return;
    L25:
        return;
    L16:
        if (r100.equals(ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS) == true) goto L21;
        return;
    L19:
        if (r100.equals("send_message") == true) goto L21;
    }
}
