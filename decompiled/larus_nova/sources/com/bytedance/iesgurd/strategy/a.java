package com.bytedance.iesgurd.strategy;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.larus.apm.impl.protector.RunnableProtector;
import ez5.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f250855a = null;

    static {
        f250855a = new a();
    }

    public a() {
    }

    public static void a() {
        AtomicBoolean r100 = ColdStartManager.f250850a;
        if (AppSettingsManager.b.f245071a.a() == false) goto L17;
        Set r101 = ((ConcurrentHashMap) GlobalManager.f250635d).keySet();
        Iterator r102 = CollectionsKt.toSet(ColdStartManager.a()).iterator();
    L7:
        if (r102.hasNext() == false) goto L23;
        String r103 = (String) r102.next();
        if (r101.contains(r103) == true) goto L7;
        GlobalManager r104 = GlobalManager.f250642k;
        Map<String, String> r105 = GlobalManager.f250635d;
        r104.a();
        GeckoGlobalConfig r106 = GlobalManager.f250638g;
        if (r106 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        ConcurrentHashMap r107 = (ConcurrentHashMap) r105;
        r107.put(r103, r106.getRootDir());
        AtomicBoolean r108 = ColdStartManager.f250850a;
        ColdStartManager.a().remove(r103);
        g.a.f474886a.c(r104.getContext(), "gecko_ak_with_custom_params", CollectionsKt.joinToString$default(ColdStartManager.a(), ",", null, null, 0, null, null, 62, null));
        EventSubType r109 = EventSubType.REGISTER_MISS;
        JSONObject r110 = new JSONObject();
        r110.put("sub_type", r109.getType());
        if (r103 == null) goto L16;
        r110.put("access_key", r103);
    L16:
        y86.a.c("geckosdk_event_message", r110);
        goto L7
    L23:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
