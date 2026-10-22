package com.bytedance.android.livesdk.live;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.g41;
import com.bytedance.android.livesdk.slideuptip.LiveSlideUpTipsGuideStrategy;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveInnerCommonController {
    public final Lazy a;
    public String b;
    public String c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public final LiveSlideUpTipsGuideStrategy a() {
        return (LiveSlideUpTipsGuideStrategy) this.d.getValue();
    }

    public final boolean c() {
        if (((g41) this.a.getValue()).b() == true) goto L5;
        return false;
    L5:
        String r0 = this.b + '-' + this.c;
        if (r0 == null) goto L37;
        String r1 = r0.toLowerCase();
        g41 r2 = (g41) this.a.getValue();
        if (r2 == null) goto L35;
        List r3 = r2.c();
        if (r3 == null) goto L35;
        if ((!r3.isEmpty()) == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L35;
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L35;
        String r5 = (String) r4.next();
        if (Intrinsics.areEqual(r5, r1) == true) goto L21;
        if (Intrinsics.areEqual(r5, "*") == true) goto L24;
        if (StringsKt.startsWith$default(r5, "*", false, 2, null) == false) goto L31;
        if (StringsKt.endsWith$default(r1, StringsKt.replace$default(r5, "*", "", false, 4, null), false, 2, null) == false) goto L31;
        return true;
    L31:
        if (StringsKt.endsWith$default(r5, "*", false, 2, null) == false) goto L18;
        if (StringsKt.startsWith$default(r1, StringsKt.replace$default(r5, "*", "", false, 4, null), false, 2, null) == false) goto L18;
        return true;
    L24:
        return true;
    L21:
        return true;
    L35:
        return false;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public LiveInnerCommonController() {
        this.a = LazyKt.lazy(LiveInnerCommonController$config$2.INSTANCE);
        this.d = LazyKt.lazy(LiveInnerCommonController$liveSlideUpTipsGuideStrategyProxy$2.INSTANCE);
    }

    public final boolean b(ILiveRoomPlayFragment r3, String r4) {
        boolean r1 = false;
        if (c() == false) goto L19;
        if (r4 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == true) goto L19;
        if (r3 == null) goto L18;
        Fragment r6 = r3.getFragment();
        if (r6 == null) goto L18;
        Bundle r7 = r6.getArguments();
        if (r7 == null) goto L18;
        r1 = r7.getBoolean("live_inner_is_enter_room", false);
    L18:
        ALogger.i("LiveInnerCommonController", "isFirstClickRoom: " + r1);
        goto L19
    L6:
        if (r4.length() == 0) goto L9;
        r5 = false;
    L19:
        return r1;
    }

    public final void d(int r4, boolean r5) {
        LiveSlideUpTipsGuideStrategy r0 = a();
        r0.i = true;
        if (r5 == true) goto L5;
        r0.j = false;
        r0.n = false;
        r0.c("onPageSelected");
    L5:
        LiveSlideUpTipsGuideStrategy.b("onPageSelected, position: " + r4 + ", isFirstRun: " + r5 + ", isLiveGuideWidgetShown: " + r0.n);
        r0.k = r4;
    }
}
