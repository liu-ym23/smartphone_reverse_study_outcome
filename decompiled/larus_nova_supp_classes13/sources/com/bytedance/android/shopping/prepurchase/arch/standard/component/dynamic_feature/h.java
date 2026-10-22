package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.action.p;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class h implements p {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> a;

    public static final class a {
    }

    static {
    }

    public h(com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public static jq.a h(jq.a r6, String r7) {
        String r0 = r6.h();
        if (r0 == null) goto L8;
        String r1 = r6.f();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r2 = StringsKt.replace$default(r0, r1, r7, false, 4, null);
    L10:
        return jq.a.a(r6, r7, r2);
    L8:
        r2 = null;
        goto L10
    }

    public final void e(Context r4, iq.b r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "toastParam");
        com.bytedance.android.ec.sdk.helper.i r0 = com.bytedance.android.ec.sdk.helper.i.a;
        String r1 = r5.a();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.e(r4, r1, r5.b(), false);
    }

    public final void g(jq.a r8, Map<String, ? extends Object> r9, View r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r9 == null) goto L5;
        r0.putAll(r9);
    L5:
        Integer r1 = r8.d();
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L45;
        if (r10 == null) goto L59;
        String r4 = r8.e();
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        String r5 = r8.f();
        String r6 = r8.h();
        i r7 = new i(this, r8, r9);
        if (r4.length() != 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L23;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L23:
        com.bytedance.android.bst.api.d r12 = new com.bytedance.android.bst.api.d(r10);
        r12.a = r4;
        if (r5 == null) goto L44;
        r12.b = r5;
        r12.c = r6;
        r12.d = "shopping";
        r12.e = -1;
        r12.f = r7;
        Integer r13 = r8.d();
        if (r13 != null) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L34;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r12);
        return;
    L34:
        Integer r15 = r8.d();
        if (r15 != null) goto L38;
    L40:
        r2 = false;
    L41:
        if (r2 == false) goto L57;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r12);
        return;
    L57:
        return;
    L38:
        if (r15.intValue() != 2) goto L40;
    L29:
        if (r13.intValue() != 1) goto L31;
        r14 = true;
        goto L32
    L44:
        throw new AndroidRuntimeException("event is empty");
    L20:
        r11 = false;
        goto L21
    L59:
        return;
    L45:
        LinkedHashMap r16 = new LinkedHashMap();
        if (r9 == null) goto L48;
        r16.putAll(r9);
    L48:
        Map r17 = r8.i();
        if (r17 == null) goto L51;
        r16.putAll(r17);
    L51:
        String r18 = r8.e();
        if (r18 == null) goto L54;
        r16.put("btm", r18);
    L54:
        ContainerTrackAbility.a r19 = this.a.a().m();
        r19.a = r16;
        String r20 = r8.g();
        String r21 = r8.h();
        r19.a(r20, r8.c(), r21, PageFinder.via(r10));
        return;
    L8:
        if (r1.intValue() <= 0) goto L10;
        r3 = true;
        goto L11
    }
}
