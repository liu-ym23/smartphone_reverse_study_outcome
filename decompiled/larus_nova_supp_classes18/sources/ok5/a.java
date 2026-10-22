package ok5;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final ArrayList b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter("attachmentIDs", "key");
        JSONArray r5 = JSONObjectProtectorUtils.getJSONArray(r4, "attachmentIDs");
        ArrayList r0 = new ArrayList(r5.length());
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(JSONArrayProtectorUtils.getString(r5, r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final String[] a(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r3.has(r4) == true) goto L6;
        return null;
    L6:
        int r1 = 0;
        if (r3.isNull(r4) == true) goto L9;
        JSONArray r5 = JSONObjectProtectorUtils.getJSONArray(r3, r4);
        int r6 = r5.length();
        String[] r0 = new String[r6];
    L11:
        if (r1 >= r6) goto L13;
        r0[r1] = JSONArrayProtectorUtils.getString(r5, r1);
        r1 = r1 + 1;
        goto L11
    L13:
        return r0;
    L9:
        return new String[0];
    }
}
