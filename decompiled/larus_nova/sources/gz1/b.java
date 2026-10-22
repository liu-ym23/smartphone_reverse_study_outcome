package gz1;

import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.j;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final JSONObject b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convertToJSONObject");
        Float r101 = r100.f126387a;
        Float r102 = r100.f126388b;
        Float r103 = r100.f126389c;
        Float r104 = r100.f126390d;
        JSONObject r105 = new JSONObject();
        float r106 = 0.0f;
        if (r101 == null) goto L5;
        float r107 = r101.floatValue();
    L6:
        r105.put("x", Float.valueOf(r107));
        if (r102 == null) goto L9;
        float r108 = r102.floatValue();
    L10:
        r105.put("y", Float.valueOf(r108));
        if (r103 == null) goto L13;
        float r109 = r103.floatValue();
    L14:
        r105.put("width", Float.valueOf(r109));
        if (r104 == null) goto L17;
        r106 = r104.floatValue();
    L17:
        r105.put("height", Float.valueOf(r106));
        return r105;
    L13:
        r109 = 0.0f;
        goto L14
    L9:
        r108 = 0.0f;
        goto L10
    L5:
        r107 = 0.0f;
        goto L6
    }

    public static final void a(j r100, JSONObject r101) {
        if (r101 != null) goto L9;
        return;
    L9:
        r100.f126387a = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "x"));     // Catch: Exception -> L6
        r100.f126388b = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "y"));     // Catch: Exception -> L6
        r100.f126389c = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "width"));     // Catch: Exception -> L6
        r100.f126390d = Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r101, "height"));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        jy0.b.c(sz1.a.TAG, "cell frame convertToFrame exception: " + e.getMessage() + " source: " + r101, null, 4);
    }

    public static final boolean c(n r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSameCard");
        ArrayList<e3> r102 = c.g(r100);
        if (r101 == null) goto L5;
        ArrayList<e3> r103 = c.g(r101);
    L7:
        return c.h(r102, r103);
    L5:
        r103 = null;
        goto L7
    }

    public static final boolean d(n r100, ArrayList<e3> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSameCard");
        if (c.h(c.g(r100), r101) == true) goto L26;
        String r103 = r100.getCardName();
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L24;
        if (r102 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L24;
        String r106 = r100.getCardName();
        if (r106 == null) goto L24;
        if (r106.equals(r102) != true) goto L24;
        return true;
    L14:
        if (r102.length() == 0) goto L17;
        r105 = false;
    L24:
        return false;
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    L26:
        return true;
    }
}
