package xn;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.android.shopping.extensions.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final JSONObject c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$readEntranceInfoAsJSON");
        if ((r100 instanceof com.bytedance.android.ec.window.base.common.activity.b) == true) goto L6;
        ConcurrentHashMap<Integer, JSONObject> r101 = a.f564599a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        return a.f564599a.get(Integer.valueOf(r100.hashCode()));
    L6:
        return k.w(d(r100));
    }

    public static final String d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$readEntranceInfoAsString");
        if ((r100 instanceof com.bytedance.android.ec.window.base.common.activity.b) == true) goto L5;
        ConcurrentHashMap<Integer, JSONObject> r101 = a.f564599a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        return String.valueOf(a.f564599a.get(Integer.valueOf(r100.hashCode())));
    L5:
        Intent r102 = r100.getIntent();
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getStringExtra(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    }

    public static final HashMap<String, String> e(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toStringMap");
        HashMap<String, String> r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.get(r103).toString());
        goto L4
    L6:
        return r101;
    }

    public static void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$merge");
        if (r101 == null) goto L19;
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L26;
        String r103 = r102.next();
        if (r100.has(r103) == false) goto L18;
        String r104 = r100.optString(r103);
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L18;
    L12:
        if (StringsKt.isBlank(r104) == true) goto L15;
        r105 = false;
    L18:
        r100.putOpt(r103, r101.opt(r103));
        goto L6
    L26:
        return;
    }

    public static final void b(JSONObject r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$mergeEntranceInfo");
        if (r101 == null) goto L8;
        JSONObject r102 = c(r101);
        if (r102 == null) goto L9;
        a(r100, r102);
        return;
    L9:
        return;
    }

    public static final void f(Intent r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$withEntranceInfo");
        if (r101 == null) goto L5;
        r100.putExtra(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r101);
    L5:
        if (r102 == null) goto L8;
        r100.putExtra("ec_shop_inner_info", r102.toString());
        return;
    }
}
