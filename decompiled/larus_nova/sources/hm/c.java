package hm;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    @Deprecated(message = "别用这个傻逼实现了,现在店铺有折叠屏，都是fragment实现的，数据不在intent里！把数据放到argument里面自己拿自己传，虽然骂但不敢改")
    public static final JSONObject d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$readEntranceInfoAsJSON");
        if ((r100 instanceof com.bytedance.android.ec.store.common.activity.b) == true) goto L6;
        ConcurrentHashMap<Integer, JSONObject> r101 = a.f485706a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        return a.f485706a.get(Integer.valueOf(r100.hashCode()));
    L6:
        return k.w(e(r100));
    }

    @Deprecated(message = "别用这个傻逼实现了,现在店铺有折叠屏，都是fragment实现的，数据不在intent里！把数据放到argument里面自己拿自己传，虽然骂但不敢改")
    public static final String e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$readEntranceInfoAsString");
        if ((r100 instanceof com.bytedance.android.ec.store.common.activity.b) == true) goto L5;
        ConcurrentHashMap<Integer, JSONObject> r101 = a.f485706a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        return String.valueOf(a.f485706a.get(Integer.valueOf(r100.hashCode())));
    L5:
        Intent r102 = r100.getIntent();
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getStringExtra(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    }

    public static final HashMap<String, String> f(JSONObject r100) throws JSONException {
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

    @Deprecated(message = "别用这个傻逼实现了,现在店铺有折叠屏，都是fragment实现的，数据不在intent里！把数据放到argument里面自己拿自己传，虽然骂但不敢改")
    public static final void a(FragmentActivity r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendIfNotExistInEntranceInfo");
        Intrinsics.checkNotNullParameter("live_guide_store", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        JSONObject r102 = d(r100);
        if (r102 != null) goto L6;
        r102 = new JSONObject();
    L6:
        if (r102.has("live_guide_store") == true) goto L14;
        r102.putOpt("live_guide_store", r101);
        if ((r100 instanceof com.bytedance.android.ec.store.common.activity.b) == true) goto L10;
        a.f485706a.put(Integer.valueOf(r100.hashCode()), r102);
        return;
    L10:
        Intent r103 = r100.getIntent();
        if (r103 == null) goto L16;
        r103.putExtra(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r102.toString());
        return;
    L16:
        return;
    }

    @Deprecated(message = "别用这个傻逼实现了,现在店铺有折叠屏，都是fragment实现的，数据不在intent里！把数据放到argument里面自己拿自己传，虽然骂但不敢改")
    public static final void c(JSONObject r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$mergeEntranceInfo");
        if (r101 == null) goto L8;
        JSONObject r102 = d(r101);
        if (r102 == null) goto L9;
        b(r100, r102, false);
        return;
    L9:
        return;
    }

    public static final void b(JSONObject r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$merge");
        if (r101 == null) goto L19;
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L27;
        String r104 = r103.next();
        if (r100.has(r104) == false) goto L18;
        String r105 = JSONObjectProtectorUtils.getString(r100, r104);
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        if (r102 == false) goto L6;
    L12:
        if (StringsKt.isBlank(r105) == true) goto L15;
        r106 = false;
    L18:
        r100.putOpt(r104, r101.get(r104));
        goto L6
    L27:
        return;
    }
}
