package t3;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f0 {
    public static final <Result extends ResultModel> void a(f3.h<Result> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "msg");
        e0.f544279a.getClass();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r102.toLowerCase(Locale.ROOT);
        if (StringsKt.contains$default(r103, "permission denied", false, 2, null) == false) goto L9;
    L61:
        f3.a r104 = f3.a.f475269j;
    L62:
        f3.h.a.a(r100, r101, r104, null, 10);
        return;
    L9:
        if (StringsKt.contains$default(r103, "unauthorized", false, 2, null) == true) goto L61;
        if (StringsKt.contains$default(r103, "invalid", false, 2, null) == false) goto L14;
    L60:
        r104 = f3.a.f475267h;
        goto L62
    L14:
        if (StringsKt.contains$default(r103, "empty", false, 2, null) == true) goto L60;
        if (StringsKt.contains$default(r103, "not support", false, 2, null) == false) goto L19;
    L59:
        r104 = f3.a.f475266g;
        goto L62
    L19:
        if (StringsKt.contains$default(r103, "unsupported", false, 2, null) == true) goto L59;
        if (StringsKt.contains$default(r103, "timeout", false, 2, null) == false) goto L25;
        r104 = f3.a.f475275p;
        goto L62
    L25:
        if (StringsKt.contains$default(r103, "not found", false, 2, null) == false) goto L27;
    L58:
        r104 = f3.a.f475276q;
        goto L62
    L27:
        if (StringsKt.contains$default(r103, "unavailable", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "not available", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "doesn't exist", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "powered off", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "disabled", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "not initialized", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "not started", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "not paired", false, 2, null) == true) goto L58;
        if (StringsKt.contains$default(r103, "already", false, 2, null) == false) goto L46;
    L57:
        r104 = f3.a.f475277r;
        goto L62
    L46:
        if (StringsKt.contains$default(r103, AiBotPollingAuthResult.STATUS_PENDING, false, 2, null) == true) goto L57;
        if (StringsKt.contains$default(r103, "cancel", false, 2, null) == false) goto L51;
    L56:
        r104 = f3.a.f475274o;
        goto L62
    L51:
        if (StringsKt.contains$default(r103, PTYSocketStateCallback.CLOSED, false, 2, null) == true) goto L56;
        if (StringsKt.contains$default(r103, "disconnect", false, 2, null) == true) goto L56;
        r104 = f3.a.f475265f;
        goto L62
    L5:
        r102 = r101;
        goto L6
    }
}
