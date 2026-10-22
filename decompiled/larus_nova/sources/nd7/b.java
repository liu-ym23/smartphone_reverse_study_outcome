package nd7;

import com.bytedance.sdk.xbridge.cn.auth.g;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f518797b;

    @Override // nd7.a
    public final JSONObject b() {
        g r100 = this.f518796a;
        if (r100 == null) goto L5;
        r100.f();
        String r101 = "";
    L6:
        if (r101 != null) goto L12;
    L11:
        return null;
    L12:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        return new JSONObject(r101);
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public b() {
        this.f518797b = "BuiltInPermissionConfigLoader";
    }

    @Override // nd7.a
    public final String a() {
        return this.f518797b;
    }
}
