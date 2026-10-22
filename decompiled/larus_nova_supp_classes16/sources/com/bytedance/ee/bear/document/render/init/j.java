package com.bytedance.ee.bear.document.render.init;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements z5 {
    public final ChameleonPluginHost a;

    public static final class a {
    }

    static {
    }

    public j(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Serializable, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v14, types: [com.bytedance.ee.bear.document.container.a] */
    @Override // com.bytedance.ee.bear.document.z5
    public final void reloadDocumentFragment(String r5, Map<String, String> r6) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        tt5.a.k("CompatDocumentReloadAbilityImpl", "the documentFragment or its origin url is null");
        return;
    L8:
        ?? r0 = new Bundle();
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L11;
        r0.putString("chameleon_url", r5);
    L11:
        r0.putString("url", r5);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r7 = Result.constructor-impl(((t45.c) this.a.getUserComponent().a(t45.c.class)).Z(r5));     // Catch: Throwable -> L14
    L17:
        if (Result.isSuccess-impl(r7) == false) goto L19;
        r0.putParcelable("bear_url", (BearUrl) r7);
    L19:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L46;
        tt5.a.l("CompatDocumentReloadAbilityImpl", "parse reload url failed", r8);
    L46:
        Serializable r3 = r0.getSerializable("extra_data_map");     // Catch: Throwable -> L32
        if (TypeIntrinsics.isMutableMap(r3) == false) goto L26;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String?, kotlin.String?>");     // Catch: Throwable -> L32
        ?? r4 = TypeIntrinsics.asMutableMap(r3);     // Catch: Throwable -> L32
    L27:
        if (r4 != 0) goto L29;
        r4 = new HashMap();     // Catch: Throwable -> L32
        r0.putSerializable("extra_data_map", r4);     // Catch: Throwable -> L32
    L29:
        if (r6 == null) goto L35;
        ((Map) r4).putAll(r6);     // Catch: Throwable -> L32
    L35:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L40;
        ?? r9 = (com.bytedance.ee.bear.document.container.a) this.a.getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r9 == 0) goto L40;
        r9.o0(r0);
        return;
    L40:
        vv4.k r10 = this.a.getChameleonWeb();
        if (r10 != null) goto L44;
        tt5.a.k("CompatDocumentReloadAbilityImpl", "reloadDocumentFragment failed, chameleonWeb is null");
        return;
    L44:
        r10.o(this.a);
        return;
    L26:
        r4 = 0;
    L32:
        th = move-exception;
        tt5.a.e("CompatDocumentReloadAbilityImpl", "parse route extra data error!", th, false);
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
