package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements cy7.b {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // cy7.b
    public final void intercept(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L6;
        return;
    L6:
        switch(r100.hashCode()) {
            case -1370848335: goto L18;
            case 958289050: goto L15;
            case 1391291968: goto L12;
            case 1479107676: goto L9;
            default: goto L26;
        };
    L26:
        return;
    L9:
        if (r100.equals("receive_stream") == false) goto L27;
    L20:
        IObricTraceParam r102 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r102 == null) goto L25;
        r102.d(r101, r100);
        return;
    L25:
        return;
    L27:
        return;
    L12:
        if (r100.equals("receive_prompt") == true) goto L20;
        return;
    L15:
        if (r100.equals("receive_answer") == true) goto L20;
        return;
    L18:
        if (r100.equals("vui_receive_stream") == true) goto L20;
    }
}
