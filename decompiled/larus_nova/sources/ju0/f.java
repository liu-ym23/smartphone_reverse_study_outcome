package ju0;

import com.bytedance.ies.bullet.service.base.x;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f500405b;

    public f(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(r100);
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        JSONArray r103 = r100.optJSONArray(Constants.EXTRA_KEY_TOPICS);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        List<String> r104 = x.b(r103);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        List<String> r106 = (List) r101;
        if (r106 != null) goto L18;
        r106 = CollectionsKt.emptyList();
    L18:
        this.f500405b = r106;
        return;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
