package x29;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f562262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f562263b = null;

    public d() {
    }

    static {
        f562262a = new d();
        f562263b = new Regex("^[0-9]+$");
    }

    public static Long a(JsonElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonPrimitive() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L40;
        JsonPrimitive r101 = r100.getAsJsonPrimitive();
        if (r101 == null) goto L43;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        if (r101.isNumber() == false) goto L16;
        Long r103 = Long.valueOf(new BigDecimal(r101.getAsString()).toBigIntegerExact().longValueExact());     // Catch: Throwable -> L23
    L21:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r104) == false) goto L28;
        r104 = null;
    L28:
        Long r105 = (Long) r104;
        if (r105 != null) goto L31;
        return null;
    L31:
        if (r105.longValue() < 0) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == true) goto L36;
        return null;
    L36:
        return r105;
    L33:
        r106 = false;
        goto L34
    L16:
        if (r101.isString() == true) goto L18;
    L20:
        r103 = null;
        goto L21
    L18:
        if (f562263b.matches(r101.getAsString()) == false) goto L20;
        r103 = StringsKt.toLongOrNull(r101.getAsString());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L43:
        return null;
    L40:
        return null;
    }
}
