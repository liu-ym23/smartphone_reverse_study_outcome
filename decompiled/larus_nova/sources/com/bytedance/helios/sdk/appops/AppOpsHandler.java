package com.bytedance.helios.sdk.appops;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.common.utils.e;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.bytedance.helios.sdk.p;
import e06.f;
import hz5.a;
import hz5.k;
import hz5.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class AppOpsHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f245487a = null;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/sdk/appops/AppOpsHandler$OpType;", "", "sdk_release"}, k = 1, mv = {1, 1, 16})
    public @interface OpType {
    }

    public AppOpsHandler() {
    }

    static {
        f245487a = new LinkedHashSet();
    }

    public static final void a(String r110, Throwable r111, int r112, int r113) {
        if (r112 == 0) goto L5;
        k.e("Helios-Log-AppOps", "appOps apiType=" + r113 + " async -> " + r110 + " calledTime=" + System.currentTimeMillis(), null);
        return;
    L5:
        String r100 = "unknown-api";
        if (r111 == null) goto L33;
        Package r101 = HeliosEnvImpl.class.getPackage();
        if (r101 == null) goto L13;
        String r102 = r101.getName();
        if (r102 == null) goto L13;
    L14:
        Iterator r103 = ArraysKt.toMutableList(r111.getStackTrace()).iterator();
    L16:
        if (r103.hasNext() == false) goto L33;
        StackTraceElement r104 = (StackTraceElement) r103.next();
        if (StringsKt.isBlank(r104.getClassName()) == true) goto L16;
        if (StringsKt.startsWith$default(r104.getClassName(), r102, false, 2, null) == true) goto L16;
        if (StringsKt.startsWith$default(r104.getClassName(), "java.", false, 2, null) == true) goto L16;
        if (StringsKt.startsWith$default(r104.getClassName(), "kotlin.", false, 2, null) == true) goto L16;
        if (StringsKt.startsWith$default(r104.getClassName(), "android.", false, 2, null) == false) goto L30;
    L32:
        r100 = r104.getClassName() + "." + r104.getMethodName();
        goto L16
    L30:
        if (StringsKt.startsWith$default(r104.getClassName(), "com.android.", false, 2, null) == true) goto L32;
    L13:
        r102 = "com.bytedance.helios.sdk";
    L33:
        k.e("Helios-Log-AppOps", "appOps api=" + r100 + " apiType=" + r113 + " op=" + r110 + " calledTime=" + System.currentTimeMillis(), null);
        if (HeliosEnvImpl.get().f245470m.s().contains(r110) == true) goto L37;
        return;
    L37:
        if (HeliosEnvImpl.get().f245470m.i() == false) goto L43;
        if (r112 != 0) goto L43;
        if (f.f470645a.containsKey(r100) == false) goto L43;
        return;
    L43:
        if (f245487a.add(r100) == false) goto L45;
        a r114 = a.d("helios_appops_api_count");
        r114.a("appops_api_name", r100 + "-" + r110);
        l.b(r114);
    L45:
        PrivacyEvent r115 = e06.a.a("appops");
        boolean r105 = p.f245593n.e();
        StringBuilder r106 = new StringBuilder("AppOpsException_");
        if (r112 == 0) goto L55;
        if (r112 == 1) goto L54;
        if (r112 != 2) goto L50;
        String r116 = "OnAsyncNoted";
    L56:
        r106.append(r116);
        r115.f245379p = r106.toString();
        r115.f245368e = r110;
        r115.f245372i = !r105;
        r115.f245369f = r111;
        r115.f245367d = r100;
        r115.f245376m = System.currentTimeMillis();
        r115.f245383t = 7;
        int r117 = e.f245397a;
        r115.f245370g = e.a(r111, r115.f245367d);
        r115.toString();
        l.b(r115);
        return;
    L50:
        if (r112 == 3) goto L52;
        r116 = "unknown";
        goto L56
    L52:
        r116 = "OnActiveNoted";
        goto L56
    L54:
        r116 = "OnSelfNoted";
        goto L56
    L55:
        r116 = "OnNoted";
        goto L56
    }
}
