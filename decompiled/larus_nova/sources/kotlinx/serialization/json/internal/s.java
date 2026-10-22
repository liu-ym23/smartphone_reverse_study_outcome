package kotlinx.serialization.json.internal;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class s {
    public static final JsonEncodingException b(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + r100.f() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + r100.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonEncodingException a(Number r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        return new JsonEncodingException("Unexpected special floating-point value " + r100 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + f(r101, -1));
    }

    public static final JsonDecodingException c(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r100 < 0) goto L6;
        r101 = "Unexpected JSON token at offset " + r100 + ": " + r101;
    L6:
        return new JsonDecodingException(r101);
    }

    public static final void e(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "entity");
        r100.l("Trailing comma before the end of JSON " + r101, r100.f505376a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence f(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() >= 200) goto L5;
        return r100;
    L5:
        String r102 = ".....";
        if (r101 != (-1)) goto L12;
        int r103 = r100.length() - 60;
        if (r103 > 0) goto L11;
        return r100;
    L11:
        return "....." + r100.subSequence(r103, r100.length()).toString();
    L12:
        int r104 = r101 - 30;
        int r105 = r101 + 30;
        if (r104 > 0) goto L15;
        String r106 = "";
    L17:
        if (r105 < r100.length()) goto L20;
        r102 = "";
    L20:
        return r106 + r100.subSequence(RangesKt.coerceAtLeast(r104, 0), RangesKt.coerceAtMost(r105, r100.length())).toString() + r102;
    L15:
        r106 = ".....";
        goto L17
    }

    public static final void g(a r100, Number r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "result");
        a.m(r100, "Unexpected special floating-point value " + r101 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final JsonDecodingException d(int r100, String r101, CharSequence r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "input");
        return c(r100, r101 + "\nJSON input: " + f(r102, r100));
    }

    public static final String h(Number r100, String r101, String r102) {
        return "Unexpected special floating-point value " + r100 + " with key " + r101 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + f(r102, -1);
    }
}
