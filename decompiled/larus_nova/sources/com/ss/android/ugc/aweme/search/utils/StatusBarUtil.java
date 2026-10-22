package com.ss.android.ugc.aweme.search.utils;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/StatusBarUtil;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class StatusBarUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StatusBarUtil f453420a = null;

    static {
        f453420a = new StatusBarUtil();
    }

    private StatusBarUtil() {
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(FragmentActivity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r100, "activity");
        Window r102 = r100.getWindow();
        Intrinsics.checkNotNullParameter(r102, LiveEndPageData.TAG_WINDOW);
        r102.clearFlags(67108864);
        r102.addFlags(Integer.MIN_VALUE);
        int r103 = a(r102).getSystemUiVisibility();
        a(r102).setSystemUiVisibility(r103 | 1280);
        r102.setStatusBarColor(0);
        Window r104 = r100.getWindow();
        View r105 = r104.findViewById(R.id.content);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r106 = (ViewGroup) r105;
        View r107 = r106.findViewWithTag("TAG_STATUS_BAR");
        if (r107 != null) goto L5;
        Context r108 = r104.getContext();
        View r109 = new View(r108);
        r109.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtils.c(r108)));
        r109.setBackgroundColor(r101);
        r109.setTag("TAG_STATUS_BAR");
        r106.addView(r109);
        return;
    L5:
        if (r107.getVisibility() != 8) goto L7;
        r107.setVisibility(0);
    L7:
        r107.setBackgroundColor(r101);
    }
}
