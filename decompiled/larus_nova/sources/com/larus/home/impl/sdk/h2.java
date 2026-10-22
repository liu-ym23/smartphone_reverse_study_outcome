package com.larus.home.impl.sdk;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.platform.api.y3;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class h2 implements y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f346184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f346185b = null;

    public h2() {
    }

    static {
        f346184a = new h2();
        f346185b = MapsKt.mapOf(new Pair[]{TuplesKt.to("signversion", "Sve"), TuplesKt.to("signinfo", "Si"), TuplesKt.to("lid", "Lid"), TuplesKt.to("signvalue", "Sva"), TuplesKt.to("frametype", "Ft")});
    }

    @Override // com.larus.platform.api.y3
    public final void a() {
        SecurityService r100 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r100 == null) goto L6;
        r100.e(AppHost.f326268a.getApplication());
        return;
    }

    public final String c() {
        SecurityService r100 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.i();
    }

    @Override // com.larus.platform.api.y3
    public final boolean isBasicMode() {
        SecurityService r100 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isBasicMode();
    }

    @Override // com.larus.platform.api.y3
    public final String b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        SecurityService r104 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r104 == null) goto L9;
        Map<String, String> r105 = r104.v(r101.toString());
    L10:
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L30;
        JSONObject r107 = new JSONObject();
        Iterator<Map.Entry<String, String>> r108 = r105.entrySet().iterator();
    L19:
        if (r108.hasNext() == false) goto L29;
        Map.Entry<String, String> r109 = r108.next();
        if (r109.getKey() == null) goto L19;
        if (r109.getValue() == null) goto L19;
        String r110 = f346185b.get(r109.getKey());
        if (r110 != null) goto L27;
        r110 = r109.getKey();
    L27:
        r107.put(r110, r109.getValue());
        goto L19
    L29:
        return r107.toString();
    L30:
        return null;
    L12:
        if (r105.isEmpty() == true) goto L15;
        r106 = false;
        goto L16
    L9:
        r105 = null;
        goto L10
    }

    public final void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L6:
        if (r101 == null) goto L11;
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 == null) goto L12;
        r102.k(r101);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
