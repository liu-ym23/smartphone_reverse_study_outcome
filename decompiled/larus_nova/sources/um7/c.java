package um7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static Set<DataUnionStrategy> a(List<String> r100) {
        HashSet r101 = new HashSet();
        if (r100 != null) goto L5;
    L47:
        return r101;
    L5:
        if (r100.size() <= 0) goto L47;
        Iterator<String> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L47;
        String r103 = r102.next();
        DataUnionStrategy r104 = null;
        if (TextUtils.isEmpty(r103) == true) goto L43;
        r103.getClass();
        byte r105 = -1;
        switch(r103.hashCode()) {
            case -1971701722: goto L33;
            case -1488502548: goto L29;
            case 133170815: goto L25;
            case 801642849: goto L21;
            case 1235699901: goto L17;
            default: goto L36;
        };
    L36:
        switch(r105) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            default: goto L43;
        };
    L38:
        r104 = DataUnionStrategy.UNION_ACCOUNT;
        goto L43
    L39:
        r104 = DataUnionStrategy.UNION_PROVIDER;
        goto L43
    L40:
        r104 = DataUnionStrategy.UNION_ACTIVITY;
        goto L43
    L41:
        r104 = DataUnionStrategy.UNION_FILE;
        goto L43
    L42:
        r104 = DataUnionStrategy.UNION_CLIPBOARD;
        goto L43
    L17:
        if (r103.equals("union_account") == false) goto L36;
        r105 = 4;
        goto L36
    L21:
        if (r103.equals("union_provider") == false) goto L36;
        r105 = 3;
        goto L36
    L25:
        if (r103.equals("union_activity") == false) goto L36;
        r105 = 2;
        goto L36
    L29:
        if (r103.equals("union_file") == false) goto L36;
        r105 = 1;
        goto L36
    L33:
        if (r103.equals("union_clipboard") == false) goto L36;
        r105 = 0;
    L43:
        if (r104 == null) goto L9;
        if (r101.contains(r104) == true) goto L9;
        r101.add(r104);
        goto L9
    }

    public static String c(JSONObject r100) {
        if (r100 != null) goto L14;
        return "";
    L14:
        JSONObject r101 = r100.optJSONObject("sdk_key_LuckyDog");     // Catch: Throwable -> L11
        if (r101 == null) goto L13;
        JSONObject r102 = r101.optJSONObject("luckyunion_account_sdk");     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return r102.optString("passport_data", "");
    L13:
        return "";
    L11:
        th = move-exception;
        th.getLocalizedMessage();
        goto L13
    }

    public static String b(JSONObject r100, boolean r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r101 == false) goto L7;
        String r102 = "block_path_prefix_list";
    L19:
        JSONObject r103 = r100.optJSONObject("sdk_key_LuckyDog");     // Catch: Throwable -> L16
        if (r103 == null) goto L18;
        JSONObject r104 = r103.optJSONObject("luckyunion_account_sdk");     // Catch: Throwable -> L16
        if (r104 == null) goto L18;
        JSONObject r105 = r104.optJSONObject("intercept_regulation");     // Catch: Throwable -> L16
        if (r105 == null) goto L18;
        return r105.optString(r102, "");
    L18:
        return "";
    L16:
        th = move-exception;
        e.b(th.getLocalizedMessage());
        goto L18
    L7:
        r102 = "path_prefix_list";
        goto L19
    }

    public static Set<String> d(List<String> r100, boolean r101) {
        HashSet r102 = new HashSet();
        if (r100 != null) goto L5;
    L14:
        return r102;
    L5:
        if (r100.size() <= 0) goto L14;
        Iterator<String> r103 = r100.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        if (TextUtils.isEmpty(r104) == true) goto L9;
        if (r101 == false) goto L9;
        r102.add("boe" + r104);
        goto L9
    }
}
