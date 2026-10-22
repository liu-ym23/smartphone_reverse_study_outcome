package t3;

import com.google.gson.JsonPrimitive;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f544357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f544358b = null;

    public p0() {
    }

    static {
        f544357a = new p0();
        f544358b = CollectionsKt.listOf(new String[]{"Hardware", "Processor", "model name", "cpu model"});
    }

    public static Double a(Object r100) {
        if ((r100 instanceof Number) == false) goto L6;
        return Double.valueOf(((Number) r100).doubleValue());
    L6:
        if ((r100 instanceof String) == true) goto L24;
        Object r101 = null;
        if ((r100 instanceof JsonPrimitive) == false) goto L20;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl(Double.valueOf(((JsonPrimitive) r100).getAsDouble()));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r103) == true) goto L25;
        r101 = r103;
    L25:
        return (Double) r101;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L20:
        return null;
    L24:
        return StringsKt.toDoubleOrNull((String) r100);
    }
}
