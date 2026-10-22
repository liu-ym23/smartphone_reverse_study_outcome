package com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.u;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    static {
    }

    public static void c(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Iterator r3 = UtilityKotlinExtentionsKt.g(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        u r0 = (View) r3.next();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        c((ViewGroup) r0);
    L9:
        if ((r0 instanceof u) == false) goto L4;
        r0.onVHPaused();
        goto L4
    }

    public static void d(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Iterator r3 = UtilityKotlinExtentionsKt.g(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        u r0 = (View) r3.next();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        d((ViewGroup) r0);
    L9:
        if ((r0 instanceof u) == false) goto L4;
        r0.onVHResume();
        goto L4
    }

    public static void e(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Iterator r3 = UtilityKotlinExtentionsKt.g(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        u r0 = (View) r3.next();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        e((ViewGroup) r0);
    L9:
        if ((r0 instanceof u) == false) goto L4;
        r0.onVHSelected();
        goto L4
    }

    public static void f(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Iterator r3 = UtilityKotlinExtentionsKt.g(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        u r0 = (View) r3.next();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        f((ViewGroup) r0);
    L9:
        if ((r0 instanceof u) == false) goto L4;
        r0.onVHUnSelected();
        goto L4
    }

    public static void a(ViewGroup r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "logMsg");
        Iterator r4 = UtilityKotlinExtentionsKt.g(r2).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        u r0 = (View) r4.next();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        a((ViewGroup) r0, r3);
    L9:
        if ((r0 instanceof u) == false) goto L4;
        r0.attachFromWindow(r3);
        goto L4
    }

    public static void b(ViewGroup r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "logMsg");
        Iterator r4 = UtilityKotlinExtentionsKt.g(r2).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        u r0 = (View) r4.next();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        b((ViewGroup) r0, r3);
    L9:
        if ((r0 instanceof u) == false) goto L4;
        r0.detachFromWindow(r3);
        goto L4
    }
}
