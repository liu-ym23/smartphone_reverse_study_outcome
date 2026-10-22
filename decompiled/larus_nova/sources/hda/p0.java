package hda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class p0 {
    public static final String a(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r101 = r100.f484747h;
        if (r101 > 0) goto L6;
        return "";
    L6:
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(r101));
    }

    public static final String b(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.has(r101) == true) goto L5;
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L18;
        String r102 = r100.optString(r101);
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
    L12:
        r103 = false;
    L13:
        if (r103 == true) goto L15;
        return null;
    L15:
        return r102;
    L10:
        if (Intrinsics.areEqual(r102, "null") == true) goto L12;
    L18:
        return null;
    }
}
