package m5;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f511946a;

    public static final class a {
    }

    static {
    }

    public f1() {
        this.f511946a = new JSONObject();
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JSONObject r101 = this.f511946a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Iterator<String> r103 = r100.keys();     // Catch: Throwable -> L12
        if (r103 != null) goto L6;
        Unit r104 = null;
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        com.bytedance.ai.utils.g.f37637a.e("Monitor-Timeline", "JsonUtils.wrap " + r106.getMessage());
        return;
    L21:
        return;
    L6:
        if (r103.hasNext() == false) goto L8;
        String r107 = r103.next();     // Catch: Throwable -> L12
        r101.put(r107, r100.opt(r107));     // Catch: Throwable -> L12
        goto L6
    L8:
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f511946a.optLong(r100) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r101 = this.f511946a.optLong(r100);
        if (r101 != 0) goto L6;
        com.bytedance.ai.utils.g.f37637a.w("Monitor-Timeline", "get null metric: ".concat(r100));
        return -1;
    L6:
        return r101;
    }

    public final void d(String r100, Long r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f511946a.optLong(r100) == 0) goto L6;
        com.bytedance.ai.utils.g.f37637a.w("Monitor-Timeline", "redundancy record: " + r100 + ", " + r110);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r110 != null) goto L9;
        com.bytedance.ai.utils.g.f37637a.w("Monitor-Timeline", "record with null metric: " + r100 + ", " + r110);
        return;
    L9:
        this.f511946a.put(r100, r110.longValue());
    }
}
