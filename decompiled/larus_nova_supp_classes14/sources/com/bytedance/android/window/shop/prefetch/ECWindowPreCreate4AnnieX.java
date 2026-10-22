package com.bytedance.android.window.shop.prefetch;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import com.bytedance.android.window.shop.home.ECWindowActivity;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowPreCreate4AnnieX implements Runnable {
    public static final Lazy c = null;
    public final Context a;
    public final ECWindowViewModel b;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        c = LazyKt.lazy(ECWindowPreCreate4AnnieX$Companion$lynxPreloadCardDataConfig$2.INSTANCE);
    }

    public final void a() {
        Lazy r1 = c;
        int r4 = 1;
        if (((String) r1.getValue()).length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        if (yq3.a.g() == 1) goto L42;
        String r3 = (String) r1.getValue();
        LinkedHashMap r5 = new LinkedHashMap();
        JSONArray r6 = z1.e(r3);
        if (r6 == null) goto L41;
        int r7 = r6.length();
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L43;
        JSONObject r9 = JSONArrayProtectorUtils.getJSONObject(r6, r8);
        int r16 = r9.optInt("item_type");
        if (r16 == 0) goto L33;
        String r15 = "schema";
        String r10 = r9.optString("schema");
        if (Intrinsics.areEqual(r10, "") == true) goto L33;
        if (yq3.a.e() != r4) goto L21;
        r10 = r10 + "&loader_name=forest";
    L21:
        String r14 = r10;
        String r13 = UploadTypeInf.COUNT;
        int r12 = r9.optInt(UploadTypeInf.COUNT);
        int r11 = 0;
    L22:
        if (r11 >= r12) goto L31;
        Lazy r17 = ECLynxAnnieXService.a;
        List r18 = (List) r5.get(Integer.valueOf(r16));
        if (r18 == null) goto L26;
        String r19 = (String) ListProtector.remove(r18, 0);
    L27:
        int r21 = r11;
        int r22 = r12;
        String r20 = r13;
        String r23 = r14;
        String r24 = r15;
        Pair r25 = ECLynxAnnieXService.e(new com.bytedance.android.ec.hybrid.card.cache.view.a(this.a, r14, r19, CollectionsKt.emptyList(), r16, "ec_window_lynx_card"));
        if (r25 == null) goto L30;
        ECLynxAnnieXService.f(this.a, "ec_window_lynx_card", r25);
    L30:
        r11 = r21 + 1;
        r13 = r20;
        r12 = r22;
        r14 = r23;
        r15 = r24;
        goto L22
    L26:
        r19 = null;
        goto L27
    L31:
        String r26 = r13;
        this.b.doEventAction("ec_window_use_preload", new Pair[]{TuplesKt.to(r26, String.valueOf(r9.optInt(r26))), TuplesKt.to("item_type", String.valueOf(r16)), TuplesKt.to(r15, r14)});
    L33:
        r8 = r8 + 1;
        r4 = 1;
        goto L13
    L43:
        return;
    L41:
        return;
    L42:
        return;
    L5:
        r2 = false;
        goto L6
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

    /* JADX WARN: Multi-variable type inference failed */
    public ECWindowPreCreate4AnnieX(ECWindowActivity r2, ECWindowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
