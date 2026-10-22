package tx9;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f547912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f547913b = null;

    public x() {
    }

    static {
        f547912a = new x();
        f547913b = new String[]{"app_key", "app_name", "app_type"};
    }

    public static void a(Map r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        if (r100 != null) goto L6;
        return;
    L6:
        String[] r103 = f547913b;     // Catch: Throwable -> L14
        int r104 = r103.length;     // Catch: Throwable -> L14
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        String r106 = r103[r105];     // Catch: Throwable -> L14
        String r107 = (String) r100.get(r106);     // Catch: Throwable -> L14
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        r101.put(r106, r107);     // Catch: Throwable -> L14
        r105 = r105 + 1;     // Catch: Throwable -> L14
        goto L7
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
