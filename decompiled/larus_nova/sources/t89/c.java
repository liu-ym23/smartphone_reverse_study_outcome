package t89;

import com.bytedance.ies.commerce.common_utils.event.EventCenter;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.s;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uq9.i;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements JsEventSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f545060a;

    public static final class a {
    }

    static {
    }

    public c(i r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f545060a = r100;
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        FLogger.f375446a.i("ECEventSubscriber", "Receive event, name=" + r100.getEventName());
        XReadableMap r101 = r100.getParams();
        if (r101 == null) goto L34;
        String r102 = s.f(r101, "event_context", "");
        if (r102 == null) goto L35;
        String r103 = p0.a(r102);
        if (r103 == null) goto L37;
        String r104 = this.f545060a.a();
        if (r104 == null) goto L36;
        String r105 = p0.a(r104);
        if (r105 == null) goto L38;
        Object r106 = null;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L21
        XReadableMap r108 = r100.getParams();     // Catch: Throwable -> L21
        if (r108 == null) goto L18;
        JSONObject r109 = new JSONObject(s.h(r108));     // Catch: Throwable -> L21
    L19:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r110) == true) goto L27;
        r106 = r110;
    L27:
        JSONObject r111 = (JSONObject) r106;
        if (r111 != null) goto L30;
        r111 = new JSONObject();
    L30:
        EventCenter.a(r103, r105, r111);
        FLogger.f375446a.i("ECEventSubscriber", "Dispatch event, name=" + r105 + ", params=" + r111);
        return;
    L18:
        r109 = null;
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L38:
        return;
    L36:
        return;
    L37:
        return;
    L35:
        return;
    }
}
