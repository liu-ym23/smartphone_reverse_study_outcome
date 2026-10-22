package ok7;

import android.text.TextUtils;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatGetSettingsInfo", owner = "pengweitao")
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523694a;

    public l() {
        this.f523694a = "luckycatGetSettingsInfo";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f523694a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r110, i r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatGetSettingsInfo on call");
        String r100 = s.f(r110, "activity_id", "");
        String r101 = s.f(r110, "key", "");
        String r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        i.b(r111, 0, null, "key_is_null", 2);
        return;
    L6:
        if (r101 == null) goto L8;
        List r112 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);
    L9:
        if (r112 == null) goto L11;
        String r103 = (String) CollectionsKt.getOrNull(r112, 0);
    L13:
        if (r112 == null) goto L15;
        String r104 = (String) CollectionsKt.getOrNull(r112, 1);
    L16:
        if (r112 == null) goto L18;
        r102 = (String) CollectionsKt.getOrNull(r112, 2);
    L18:
        Object r113 = b.c(r100, r103, r104, r102);
        JSONObject r105 = new JSONObject();
        r105.put("setting", r113);     // Catch: Throwable -> L21
    L23:
        r111.a(1, r105, "success");
        return;
    L21:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("luckydog_js_tag", th.getMessage());
        goto L23
    L15:
        r104 = null;
        goto L16
    L11:
        r103 = null;
        goto L13
    L8:
        r112 = null;
        goto L9
    }
}
