package dk8;

import android.graphics.Color;
import com.larus.im.bean.message.block.DisplayColor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d {
    public static final Integer a(DisplayColor r100, boolean r101) {
        Object r102 = null;
        if (r101 == false) goto L11;
        String r103 = r100.getColorDark();
        if (r103 == null) goto L11;
        if ((!StringsKt.isBlank(r103)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L11;
    L12:
        if (r103 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r103)) == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L40;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L41;
        String r105 = StringsKt.removePrefix(r104, "#");
        int r106 = r105.length();
        if (r106 != 6) goto L23;
        String r107 = "#".concat(r105);
    L37:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L29
        Object r109 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r107)));     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r109) == true) goto L36;
        r102 = r109;
    L36:
        return (Integer) r102;
    L29:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L23:
        if (r106 != 8) goto L42;
        r107 = "#" + StringsKt.takeLast(r105, 2) + StringsKt.take(r105, 6);
        goto L37
    L42:
        return null;
    L41:
        return null;
    L40:
        return null;
    L11:
        r103 = r100.getColor();
        goto L12
    }
}
