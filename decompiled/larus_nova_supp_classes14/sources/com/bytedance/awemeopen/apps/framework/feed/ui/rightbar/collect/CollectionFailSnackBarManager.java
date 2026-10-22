package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CollectionFailSnackBarManager {
    public static final List<Function0<Unit>> a = null;
    public static wx3.a b;

    static {
        a = new ArrayList();
        com.bytedance.awemeopen.apps.framework.utils.a.a(new k());
    }

    public static void a(Activity r6, int r7, View r8, Function0 r9, final Function0 r10) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "anchorView");
        Intrinsics.checkNotNullParameter(r9, "clickCallback");
        Intrinsics.checkNotNullParameter(r10, "showCallback");
        wx3.a r11 = b;
        if (r11 != null) goto L6;
    L11:
        wx3.a.C0183a r3 = new wx3.a.C0183a(r6);
        Intrinsics.checkNotNullParameter(r6, "context");
        Object r0 = r6.getSystemService("window");
        DisplayMetrics r4 = new DisplayMetrics();
        if ((r0 instanceof WindowManager) == false) goto L14;
        ((WindowManager) r0).getDefaultDisplay().getRealMetrics(r4);
    L14:
        Pair r1 = TuplesKt.to(Integer.valueOf(r4.widthPixels), Integer.valueOf(r4.heightPixels));
        r3.n = Math.min(((Number) r1.component1()).intValue(), ((Number) r1.component2()).intValue());
        r3.p = false;
        r3.q = true;
        Drawable r2 = ContextCompat.getDrawable(r3.a, 2131231504);
        if (r2 == null) goto L17;
        r3.b = r2;
    L17:
        r3.c = r3.a.getString(2131894175);
        CollectionFailSnackBarManager$realTryShow$1 r5 = CollectionFailSnackBarManager$realTryShow$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "attrs");
        r3.d = r5;
        ContextCompat.getDrawable(r3.a, 2131231568);
        r3.o = (int) n0.a(r6, 48.0f);
        r3.h = r8;
        r3.j = 0;
        r3.k = r7;
        wx3.a.b r12 = new CollectionFailSnackBarManager$realTryShow$2();
        Intrinsics.checkNotNullParameter(r12, "callback");
        r3.m = r12;
        b = new wx3.a(r3);
        AoPool.g(new CollectionFailSnackBarManager$runOnUi$1(new CollectionFailSnackBarManager$realTryShow$3(r10)));
        return;
    L6:
        if (r11.b.isShowing() != true) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        AoPool.g(new CollectionFailSnackBarManager$runOnUi$1(CollectionFailSnackBarManager$tryDismiss$1.INSTANCE));
        goto L11
    L8:
        r13 = false;
        goto L9
    }
}
