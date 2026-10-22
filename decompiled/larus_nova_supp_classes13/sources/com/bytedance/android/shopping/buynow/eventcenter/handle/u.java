package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u extends com.bytedance.kmp.ec.yata.event.common.b {
    public final AndroidYaTaInstance a;
    public final BuyNowViewModel b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r13) {
        Intrinsics.checkNotNullParameter(r13, "input");
        BuyNowLog.d("selfReadFieldAndTrigger", "selfReadFieldAndTrigger start");
        Object r1 = r13.p(Reflection.getOrCreateKotlinClass(String.class), "field_path");
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r2 = (String) r1;
        r13.q();
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        BuyNowLog.d("selfReadFieldAndTrigger", "field_path is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfReadFieldAndTrigger", "field_path is empty", r13);
    L14:
        com.bytedance.kmp.ec.yata.store.node.c r5 = r13.j();
        if (r5 == null) goto L17;
        Map r10 = r5.s();
    L18:
        if (r2 == null) goto L20;
        List r6 = StringsKt.split$default(r2, new String[]{"."}, false, 0, 6, null);
    L21:
        Object r7 = com.bytedance.android.shopping.buynow.utils.n.a(r10, r6, 0);
        if (r7 != null) goto L24;
        BuyNowLog.d("selfReadFieldAndTrigger", "trigger is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfReadFieldAndTrigger", "target " + r2 + " is empty", r13);
    L24:
        BuyNowLog.d("selfReadFieldAndTrigger", "about to execute yata event");
        YataEventCenter r3 = this.a.k();
        com.bytedance.kmp.ec.yata.event.common.e.a r8 = com.bytedance.kmp.ec.yata.event.common.e.a;
        AndroidYaTaInstance r9 = this.a;
        com.bytedance.kmp.ec.yata.store.node.c r14 = r13.j();
        if (r14 == null) goto L27;
        String r11 = r14.getKey();
    L28:
        if (r7 == null) goto L30;
        String r12 = r7.toString();
    L31:
        r3.d(r8.a(r9, null, r11, r12, null, "selfReadFieldAndTrigger"));
        BuyNowLog.d("selfReadFieldAndTrigger", "selfReadFieldAndTrigger finishes");
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L30:
        r12 = null;
        goto L31
    L27:
        r11 = null;
        goto L28
    L20:
        r6 = null;
        goto L21
    L17:
        r10 = null;
        goto L18
    L8:
        if (r2.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public u(AndroidYaTaInstance r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
