package com.bytedance.android.shopping.buynow.eventcenter.common;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.utils.n;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public static com.bytedance.kmp.ec.yata.chain.event.b a(AndroidYaTaInstance r21, BuyNowViewModel r22, com.bytedance.kmp.ec.yata.event.core.a r23, final String r24) {
        Intrinsics.checkNotNullParameter(r21, "yataInstance");
        Intrinsics.checkNotNullParameter(r22, "viewModel");
        Intrinsics.checkNotNullParameter(r23, "input");
        Intrinsics.checkNotNullParameter(r24, "validateConfigKey");
        List r2 = CollectionsKt.sortedWith(r21.q(new RegexCheck$check$validateNodes$1(r24)), new a(r24));
        Lazy r3 = BuyNowLog.a;
        BuyNowLog.a("selfValidate", "validateNodes: " + r2);
        char r4 = 1;
        int r11 = 0;
        if (r2 == null) goto L64;
        Iterator r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L64;
        c r6 = (c) r5.next();
        Map r7 = r6.s();
        int r8 = n.a;
        String[] r9 = new String[2];
        r9[r11] = r24;
        r9[r4] = "validate_rules";
        Object r10 = n.a(r7, CollectionsKt.listOf(r9), r11);
        if ((r10 instanceof List) == false) goto L63;
        Iterator r12 = ((List) r10).iterator();
    L11:
        if (r12.hasNext() == false) goto L63;
        Map r13 = (Map) r12.next();
        String r14 = (String) r13.get("regex");
        if (r14 != null) goto L15;
        r14 = "";
    L15:
        String r15 = (String) r13.get("field_path");
        if (r15 != null) goto L18;
    L21:
        boolean r16 = true;
    L22:
        if (r16 == false) goto L24;
        BuyNowLog.a("selfValidate", "field_path is nullOrEmpty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(r22.getTracker(), "selfValidate", "field_path is empty", r23);
    L24:
        if (r15 == null) goto L26;
        List r17 = StringsKt.split$default(r15, new String[]{"."}, false, 0, 6, null);
    L27:
        Object r18 = n.a(r7, r17, r11);
        if (r18 != null) goto L30;
        BuyNowLog.a("selfValidate", "field_value nullOrEmpty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(r22.getTracker(), "selfValidate", "target " + r15 + " is empty", r23);
    L30:
        Regex r19 = new Regex(r14);
        if (r18 == null) goto L33;
        String r20 = r18.toString();
    L35:
        if (r19.matches(k.j(r20)) == false) goto L36;
        r11 = 0;
        goto L11
    L36:
        String r110 = (String) r13.get("failed_trigger");
        Object r0 = r13.get("trigger_match_vo");
        if ((r0 instanceof Map) == true) goto L39;
        r0 = null;
    L39:
        final Map r1 = (Map) r0;
        String r25 = (String) r13.get("is_not_pre_check");
        if (r25 == null) goto L42;
        Boolean r111 = Boolean.valueOf(k.n(r25, false));
    L43:
        if (r1 != null) goto L45;
    L48:
        boolean r26 = true;
    L50:
        if (r26 == true) goto L59;
        Iterator r112 = ((ArrayList) r21.q(new RegexCheck$check$1$1$1$1$matchedNodes$1(r1))).iterator();
    L53:
        if (r112.hasNext() == false) goto L57;
        c r27 = (c) r112.next();
        if (k.c(r110) == false) goto L53;
        r21.k().d(e.a.a(r21, null, r27.getKey(), r110, null, "RegexCheck1"));
        goto L53
    L57:
        r22.getTracker().j((String) r13.get("scene"), r22.getStaticState().g, r111);
    L61:
        r22.getTracker().j((String) r13.get("scene"), r22.getStaticState().g, r111);
        boolean r28 = false;
    L65:
        BuyNowLog.a("selfValidate", "selfValidate finishes");
        if (r28 == false) goto L69;
        int r29 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L69:
        int r30 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, null, null, null, 57);
    L59:
        if (k.c(r110) == false) goto L61;
        r21.k().d(e.a.a(r21, null, r6.getKey(), r110, null, "RegexCheck2"));
        goto L61
    L45:
        if (r1.isEmpty() == true) goto L48;
        r26 = false;
        goto L50
    L42:
        r111 = null;
        goto L43
    L33:
        r20 = null;
        goto L35
    L26:
        r17 = null;
        goto L27
    L18:
        if (r15.length() == 0) goto L21;
        r16 = false;
    L63:
        r4 = 1;
        r11 = 0;
    L64:
        r28 = true;
        goto L65
    }
}
