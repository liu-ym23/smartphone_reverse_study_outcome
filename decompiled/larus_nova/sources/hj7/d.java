package hj7;

import android.app.Activity;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @BridgeMethod("luckycatAddBackKey")
    public final void addBackKeyInterceptor(@BridgeContext IBridgeContext r100) {
        if (r100 == null) goto L5;
        Activity r101 = r100.getActivity();
    L7:
        if (r101 != null) goto L12;
        if (r100 == null) goto L17;
        r100.callback(hj7.a.a(1, null, "activity is null"));
        return;
    L17:
        return;
    L12:
        if ((r101 instanceof com.bytedance.ug.sdk.luckycat.impl.manager.f) == false) goto L14;
        Map<WeakReference<Activity>, WeakReference<com.bytedance.ug.sdk.luckycat.impl.manager.f>> r102 = com.bytedance.ug.sdk.luckycat.impl.manager.k.f271329a;
        com.bytedance.ug.sdk.luckycat.impl.manager.k.f271329a.put(new WeakReference(r101), new WeakReference((com.bytedance.ug.sdk.luckycat.impl.manager.f) r101));
    L14:
        if (r100 == null) goto L18;
        r100.callback(hj7.a.a(1, null, ""));
        return;
    L18:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @BridgeMethod("luckycatRemoveBackKey")
    public final void removeBackKeyInterceptor(@BridgeContext IBridgeContext r100) {
        if (r100 == null) goto L5;
        Activity r101 = r100.getActivity();
    L7:
        if (r101 != null) goto L11;
        if (r100 == null) goto L25;
        r100.callback(hj7.a.a(1, null, "activity is null"));
        return;
    L25:
        return;
    L11:
        Map<WeakReference<Activity>, WeakReference<com.bytedance.ug.sdk.luckycat.impl.manager.f>> r102 = com.bytedance.ug.sdk.luckycat.impl.manager.k.f271329a;
        Iterator r103 = ((LinkedHashMap) com.bytedance.ug.sdk.luckycat.impl.manager.k.f271329a).keySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        WeakReference r104 = (WeakReference) r103.next();
        if (Intrinsics.areEqual((Activity) r104.get(), r101) == false) goto L13;
        com.bytedance.ug.sdk.luckycat.impl.manager.k.f271329a.remove(r104);
        goto L13
    L17:
        if (r100 == null) goto L26;
        r100.callback(hj7.a.a(1, null, ""));
        return;
    L26:
        return;
    L5:
        r101 = null;
        goto L7
    }
}
