package w09;

import com.larus.common.venue.impl.venue.api.Pocket;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final Integer a(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        return (Integer) r100;
    L9:
        if ((r100 instanceof Number) == false) goto L12;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Number");
        return Integer.valueOf(((Number) r100).intValue());
    L12:
        if ((r100 instanceof String) == true) goto L14;
        return null;
    L14:
        return StringsKt.toIntOrNull((String) r100);
    }

    public static final String b(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == false) goto L9;
        return (String) r100;
    L9:
        if ((r100 instanceof Number) == false) goto L12;
        return ((Number) r100).toString();
    L12:
        if ((r100 instanceof Boolean) == true) goto L14;
        return null;
    L14:
        return String.valueOf(((Boolean) r100).booleanValue());
    }

    public static final Pocket c(Map<String, ? extends Object> r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        String r100 = b(r210.get("pocket_id"));
        String r101 = b(r210.get("prompt_for_display"));
        String r110 = b(r210.get("prompt_for_chat"));
        return new Pocket(r100, r101, null, null, a(r210.get("pocket_type")), a(r210.get("pocket_tag")), null, null, null, null, null, null, null, b(r210.get("ext")), r110, null, null, 106444, null);
    }
}
