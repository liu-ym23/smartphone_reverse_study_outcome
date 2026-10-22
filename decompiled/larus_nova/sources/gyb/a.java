package gyb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OPTrace f483358a = null;

    static {
        f483358a = new OPTrace();
    }

    @JvmStatic
    public static final OPTrace a() {
        return f483358a.subTrace();
    L4:
        e = move-exception;
        Log.e("OPTraceService", "generateTrace " + e.getMessage());
        return new OPTrace().subTrace();
    }
}
