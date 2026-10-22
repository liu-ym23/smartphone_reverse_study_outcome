package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.collect.serviceapi.AoCollectService;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CollectionSuccessSnackBarManager {
    public static final List<Function0<Unit>> a = null;
    public static wx3.a b;
    public static final Lazy c = null;

    static {
        a = new ArrayList();
        com.bytedance.awemeopen.apps.framework.utils.a.a(new l());
        c = LazyKt.lazy(CollectionSuccessSnackBarManager$bdpCollectService$2.INSTANCE);
    }

    public static void b() {
        wx3.a r0 = b;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (r0.b.isShowing() == true) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L12;
        AoPool.g(new CollectionSuccessSnackBarManager$runOnUi$1(CollectionSuccessSnackBarManager$tryDismiss$1.INSTANCE));
        return;
    }

    public static void a(final Activity r11, final FeedPageConfig r12, int r13, View r14, final String r15, final Function0 r16, final Function0 r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r16, "clickCallback");
        Intrinsics.checkNotNullParameter(r17, "showCallback");
        if (r12 == null) goto L5;
        boolean r4 = r12.isTeenagerModel();
    L7:
        if (r4 == true) goto L15;
        AoCollectService r5 = (AoCollectService) c.getValue();
        if (r5 == null) goto L11;
        boolean r6 = r5.u();
    L13:
        if ((!r6) == false) goto L15;
        boolean r7 = true;
    L16:
        b();
        wx3.a.C0183a r8 = new wx3.a.C0183a(r11);
        Intrinsics.checkNotNullParameter(r11, "context");
        Object r0 = r11.getSystemService("window");
        DisplayMetrics r9 = new DisplayMetrics();
        if ((r0 instanceof WindowManager) == false) goto L19;
        ((WindowManager) r0).getDefaultDisplay().getRealMetrics(r9);
    L19:
        Pair r1 = TuplesKt.to(Integer.valueOf(r9.widthPixels), Integer.valueOf(r9.heightPixels));
        r8.n = Math.min(((Number) r1.component1()).intValue(), ((Number) r1.component2()).intValue());
        r8.p = false;
        r8.q = true;
        Drawable r2 = ContextCompat.getDrawable(r8.a, 2131231503);
        if (r2 == null) goto L22;
        r8.b = r2;
    L22:
        r8.c = r8.a.getString(2131894172);
        if (r7 == false) goto L25;
        int r3 = 2131894286;
    L26:
        r8.f = r8.a.getString(r3);
        CollectionSuccessSnackBarManager$realTryShow$1 r10 = CollectionSuccessSnackBarManager$realTryShow$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r10, "attrs");
        r8.d = r10;
        CollectionSuccessSnackBarManager$realTryShow$2 r18 = CollectionSuccessSnackBarManager$realTryShow$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r18, "attrs");
        r8.g = r18;
        Drawable r19 = ContextCompat.getDrawable(r8.a, 2131231395);
        if (r19 == null) goto L29;
        r8.e = r19;
    L29:
        ContextCompat.getDrawable(r8.a, 2131231568);
        r8.o = (int) n0.a(r11, 48.0f);
        r8.h = r14;
        r8.j = 0;
        r8.k = r13;
        wx3.a.b r20 = new CollectionSuccessSnackBarManager$realTryShow$3();
        Intrinsics.checkNotNullParameter(r20, "callback");
        r8.m = r20;
        wx3.a r21 = new wx3.a(r8);
        b = r21;
        View r22 = r21.c;
        if (r22 == null) goto L32;
        final boolean r23 = r7;
        r22.setOnClickListener(new j(r16, r23, r11, r12, r15));
    L32:
        AoPool.g(new CollectionSuccessSnackBarManager$runOnUi$1(new CollectionSuccessSnackBarManager$realTryShow$5(r17)));
        return;
    L25:
        r3 = 2131894173;
        goto L26
    L11:
        r6 = false;
    L15:
        r7 = false;
        goto L16
    L5:
        r4 = false;
        goto L7
    }
}
