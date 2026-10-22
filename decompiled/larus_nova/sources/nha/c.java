package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements cy7.b {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // cy7.b
    public final void intercept(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, "obric_click_speak_start") == false) goto L8;
    L9:
        IObricTraceParam r102 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r102 == null) goto L14;
        r102.h(r101);
        return;
    L14:
        return;
    L8:
        if (Intrinsics.areEqual(r100, "obric_click_speak_end") == true) goto L9;
    }
}
