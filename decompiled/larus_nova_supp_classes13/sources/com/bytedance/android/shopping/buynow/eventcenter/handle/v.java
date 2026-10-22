package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v extends com.bytedance.kmp.ec.yata.event.common.b {
    public final AndroidYaTaInstance a;
    public final BuyNowViewModel b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r19) {
        Intrinsics.checkNotNullParameter(r19, "input");
        BuyNowLog.d("selfRegexCheck", "selfRegexCheck start");
        Object r3 = r19.p(Reflection.getOrCreateKotlinClass(List.class), "regex_rules");
        if ((r3 instanceof List) == true) goto L5;
        r3 = null;
    L5:
        List r4 = (List) r3;
        List r5 = r4;
        boolean r6 = true;
        if (r5 != null) goto L8;
    L11:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L16;
        BuyNowLog.d("selfRegexCheck", "regex_rules is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfRegexCheck", "regex rules is empty", r19);
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L16:
        com.bytedance.kmp.ec.yata.store.node.c r8 = r19.j();
        if (r8 == null) goto L19;
        Map r9 = r8.s();
    L20:
        Iterator r10 = r4.iterator();
    L22:
        if (r10.hasNext() == false) goto L51;
        Map r11 = (Map) r10.next();
        Lazy r12 = BuyNowLog.a;
        BuyNowLog.d("selfRegexCheck", "executing, currrent rule is " + r11);
        String r13 = (String) r11.get("regex");
        if (r13 != null) goto L26;
        r13 = "";
    L26:
        String r14 = (String) r11.get("field_path");
        if (r14 != null) goto L29;
    L32:
        boolean r15 = true;
    L33:
        if (r15 == false) goto L35;
        BuyNowLog.d("selfRegexCheck", "field_path is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfRegexCheck", "field_path is empty", r19);
    L35:
        if (r14 == null) goto L37;
        List r16 = StringsKt.split$default(r14, new String[]{"."}, false, 0, 6, null);
    L38:
        Object r17 = com.bytedance.android.shopping.buynow.utils.n.a(r9, r16, 0);
        if (r17 != null) goto L42;
        BuyNowLog.d("selfRegexCheck", "field_value is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfRegexCheck", "target " + r14 + " is empty", r19);
    L42:
        if (new Regex(r13).matches(String.valueOf(r17)) == true) goto L22;
        BuyNowLog.d("selfRegexCheck", "validate fails");
        String r18 = (String) r11.get("failed_trigger");
        if (com.bytedance.android.shopping.extensions.k.c(r18) == false) goto L50;
        YataEventCenter r20 = this.a.k();
        com.bytedance.kmp.ec.yata.event.common.e.a r21 = com.bytedance.kmp.ec.yata.event.common.e.a;
        AndroidYaTaInstance r110 = this.a;
        com.bytedance.kmp.ec.yata.store.node.c r2 = r19.j();
        if (r2 == null) goto L48;
        String r111 = r2.getKey();
    L49:
        r20.d(r21.a(r110, null, r111, r18, null, "selfRegexCheck"));
        goto L50
    L48:
        r111 = null;
    L50:
        r6 = false;
        goto L51
    L37:
        r16 = null;
        goto L38
    L29:
        if (r14.length() == 0) goto L32;
        r15 = false;
    L51:
        BuyNowLog.d("selfRegexCheck", "selfRegexCheck finishes");
        if (r6 == false) goto L54;
        int r22 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L54:
        int r23 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, null, null, null, 57);
    L19:
        r9 = null;
        goto L20
    L8:
        if (r5.isEmpty() == true) goto L11;
        r7 = false;
        goto L13
    }

    public v(AndroidYaTaInstance r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
