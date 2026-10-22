package nd6;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f518790b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f518791a;

    public static final class a {
    }

    static {
        f518790b = new c(MapsKt.emptyMap());
    }

    public c(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "overrides");
        this.f518791a = r100;
    }

    public final boolean a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "switch");
        Intrinsics.checkNotNullParameter(r100, "feature");
        Object r101 = this.f518791a.get(r100.f518793a);
        Object r102 = null;
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        if (r101 != null) goto L19;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(b.a(r100));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L15;
        r102 = r104;
    L15:
        if (r102 == null) goto L17;
        r101 = r102;
        goto L19
    L17:
        r101 = r100.getDefaultValue();
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        return ((Boolean) r101).booleanValue();
    }
}
