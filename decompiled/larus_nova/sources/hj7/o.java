package hj7;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.storage.ContainerLocalStorage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class o {
    public o() {
    }

    @BridgeMethod("luckycatGetStorageItem")
    public void getStorageItem(@BridgeContext IBridgeContext r100, @BridgeParam("key") String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r100.callback(a.a(-1, null, "msg_is_null"));
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L16;
    L13:
        r100.callback(a.a(1, r102, ""));
        return;
    L16:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L15
        r103.put("data", ContainerLocalStorage.a().b(r101));     // Catch: Throwable -> L15
        r102 = r103;
        goto L13
    }

    @BridgeMethod("luckycatRemoveStorageItem")
    public void removeStorageItem(@BridgeContext IBridgeContext r100, @BridgeParam("key") String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r100.callback(a.a(-1, null, "msg_is_null"));
        return;
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        ContainerLocalStorage.a().c(r101);
    L12:
        r100.callback(a.a(1, null, ""));
    }

    @BridgeMethod("luckycatSetStorageItem")
    public void setStorageItem(@BridgeContext IBridgeContext r110, @BridgeParam("key") String r111, @BridgeParam("data") String r112, @BridgeParam(defaultLong = -1, value = AiBotPollingAuthResult.STATUS_EXPIRED) long r113) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == false) goto L9;
        r110.callback(a.a(-1, null, "msg_is_null"));
        return;
    L9:
        if (TextUtils.isEmpty(r112) == false) goto L11;
        String r100 = "";
    L13:
        if (r113 >= 0) goto L15;
        r113 = -1;
    L15:
        long r101 = r113;
        if (TextUtils.isEmpty(r111) == true) goto L26;
        if (r100 == null) goto L26;
        ContainerLocalStorage r102 = ContainerLocalStorage.a();
        r102.getClass();
        if (TextUtils.isEmpty(r111) == true) goto L26;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L25;
        rj7.c.a(new com.bytedance.ug.sdk.luckycat.impl.storage.a(r102, r111, r100, r101));
        goto L26
    L25:
        r102.f271489a.edit().putString(r111, ContainerLocalStorage.d(r100, r101)).apply();
    L26:
        r110.callback(a.a(1, null, ""));
        return;
    L11:
        r100 = r112;
        goto L13
    }
}
