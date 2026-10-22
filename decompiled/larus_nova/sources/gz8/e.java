package gz8;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class e {
    public static final String a(JSONObject r100) {
        Integer r101 = b(r100, "hour");
        if (r101 == null) goto L16;
        int r102 = r101.intValue();
        Integer r103 = b(r100, "minute");
        if (r103 == null) goto L18;
        int r104 = r103.intValue();
        d r105 = d.f483418a;
        Integer r106 = Integer.valueOf(r102);
        Integer r107 = Integer.valueOf(r104);
        r105.getClass();
        Calendar r108 = Calendar.getInstance(Locale.getDefault());
        if (r106 == null) goto L9;
        int r109 = RangesKt.coerceIn(r106.intValue(), 0, 23);
    L10:
        r108.set(11, r109);
        if (r107 == null) goto L13;
        int r110 = RangesKt.coerceIn(r107.intValue(), 0, 59);
    L14:
        r108.set(12, r110);
        r108.set(13, 0);
        r108.set(14, 0);
        Date r111 = r108.getTime();
        return DateFormat.getTimeInstance(3, Locale.getDefault()).format(r111);
    L13:
        r110 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L18:
        return null;
    L16:
        return null;
    }

    public static final Integer b(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L7:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L7;
        return Integer.valueOf(r100.optInt(r101));
    }
}
