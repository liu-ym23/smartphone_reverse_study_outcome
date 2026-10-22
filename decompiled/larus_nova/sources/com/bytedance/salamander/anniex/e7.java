package com.bytedance.salamander.anniex;

import android.webkit.MimeTypeMap;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f268050a;

    @Override // com.bytedance.salamander.anniex.d4
    public final Map<String, Object> getResult() {
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r100, "res_info", this.f268050a);
        return r100;
    }

    public e7() {
        this.f268050a = new LinkedHashMap();
    }

    @Override // com.bytedance.salamander.anniex.d4
    public final boolean a(SLEventType r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        if (r100 != SLEventType.RES_LOADER_PERF) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.salamander.anniex.d4
    public final void handle(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f268050a.size() < m1.f268232b) goto L5;
        return;
    L5:
        Object r101 = r100.get("res_info");
        if (r101 != null) goto L8;
        return;
    L8:
        if (TypeIntrinsics.isMutableMap(r101) == false) goto L42;
        Map r102 = TypeIntrinsics.asMutableMap(r101);
        Object r103 = r102.get("res_src");
        int r104 = com.bytedance.rts.foundation.v.f267594a;
        if ((r103 instanceof String) == true) goto L13;
        return;
    L13:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        String r105 = (String) r103;
        Intrinsics.checkNotNullParameter(r105, "url");
        String r106 = MimeTypeMap.getFileExtensionFromUrl(r105);     // Catch: Throwable -> L17
        if (r106 == null) goto L18;
    L20:
        if (com.bytedance.rts.foundation.j.f(m1.f268231a, r106) == true) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r106, "") == true) goto L43;
        LinkedHashMap r107 = new LinkedHashMap();
        if (com.bytedance.rts.foundation.m.b(r102, "gecko_access_key") == false) goto L28;
        Object r108 = r102.get("gecko_access_key");
        Intrinsics.checkNotNull(r108);
        com.bytedance.rts.foundation.m.e(r107, "gecko_access_key", r108);
    L28:
        if (com.bytedance.rts.foundation.m.b(r102, "gecko_channel") == false) goto L31;
        Object r109 = r102.get("gecko_channel");
        Intrinsics.checkNotNull(r109);
        com.bytedance.rts.foundation.m.e(r107, "gecko_channel", r109);
    L31:
        if (com.bytedance.rts.foundation.m.b(r102, ChameleonOpenTracker.ParamKey.RES_VERSION) == false) goto L34;
        Object r110 = r102.get(ChameleonOpenTracker.ParamKey.RES_VERSION);
        Intrinsics.checkNotNull(r110);
        com.bytedance.rts.foundation.m.e(r107, ChameleonOpenTracker.ParamKey.RES_VERSION, r110);
    L34:
        if (com.bytedance.rts.foundation.m.b(r102, "res_from") == false) goto L36;
        Object r111 = r102.get("res_from");
        Intrinsics.checkNotNull(r111);
        com.bytedance.rts.foundation.m.e(r107, "res_from", r111);
    L36:
        com.bytedance.rts.foundation.m.e(this.f268050a, r105, r107);
        return;
    L43:
        return;
    L18:
        r106 = "";
        goto L20
    }
}
