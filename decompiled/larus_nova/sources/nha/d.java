package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements cy7.b {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // cy7.b
    public final void intercept(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, "input_function_switch") == false) goto L11;
        IObricTraceParam r102 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r102 == null) goto L12;
        r102.k(r101);
        return;
    L12:
        return;
    }
}
