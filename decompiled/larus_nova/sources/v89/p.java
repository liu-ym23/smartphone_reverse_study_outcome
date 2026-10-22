package v89;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f553743a = null;

    static {
        f553743a = LazyKt.lazy(new h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String r100, String r101, long r102, String r103, String r104, Context r110) {
        Unit r105 = null;
        if ((r110 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r111 = (LifecycleOwner) r110;
    L6:
        if (r111 == null) goto L13;
        Lifecycle r112 = r111.getLifecycle();
        if (r112 == null) goto L13;
        Lifecycle.State r113 = r112.getCurrentState();
        if (r113 == null) goto L13;
        String r114 = r113.name();
        if (r114 == null) goto L13;
    L14:
        FLogger.f375446a.i("FlowTransferRedirect", "[report] status=" + r100 + ", reason=" + r101 + ", duration=" + r102 + "ms, source=" + r104 + ", url=" + r103 + ", lifecycle=" + r114);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L20
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L20
        r107.put("status", r100);     // Catch: Throwable -> L20
        r107.put("reason", r101);     // Catch: Throwable -> L20
        r107.put("duration", r102);     // Catch: Throwable -> L20
        r107.put("url", r103);     // Catch: Throwable -> L20
        r107.put("source", r104);     // Catch: Throwable -> L20
        r107.put("lifecycle_state", r114);     // Catch: Throwable -> L20
        IApplog r108 = (IApplog) ServiceManager.get().getService(IApplog.class);     // Catch: Throwable -> L20
        if (r108 == null) goto L18;
        r108.reportEvent("flow_web_transfer_redirect_result", r107);     // Catch: Throwable -> L20
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L20
    L22:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r109);
        if (r115 == null) goto L28;
        FLogger.f375446a.e("FlowTransferRedirect", "[report] error: " + r115.getMessage(), r115);
        return;
    L28:
        return;
    L20:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        r114 = "unknown";
        goto L14
    L5:
        r111 = null;
        goto L6
    }
}
