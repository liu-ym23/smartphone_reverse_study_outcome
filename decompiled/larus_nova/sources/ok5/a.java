package ok5;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static final ArrayList b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("attachmentIDs", "key");
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "attachmentIDs");
        ArrayList r102 = new ArrayList(r101.length());
        int r103 = r101.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(JSONArrayProtectorUtils.getString(r101, r104));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final String[] a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.has(r101) == true) goto L6;
        return null;
    L6:
        int r102 = 0;
        if (r100.isNull(r101) == true) goto L9;
        JSONArray r103 = JSONObjectProtectorUtils.getJSONArray(r100, r101);
        int r104 = r103.length();
        String[] r105 = new String[r104];
    L11:
        if (r102 >= r104) goto L13;
        r105[r102] = JSONArrayProtectorUtils.getString(r103, r102);
        r102 = r102 + 1;
        goto L11
    L13:
        return r105;
    L9:
        return new String[0];
    }
}
