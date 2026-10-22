package com.larksuite.component.card.navigation;

import android.content.Context;
import com.larksuite.component.card.utils.h;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UniversalCardLargeScreenAdapt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f283725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f283726b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f283727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f283728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f283729c;

        public a(int r100, int r101, int r102) {
            this.f283727a = r100;
            this.f283728b = r101;
            this.f283729c = r102;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283730a = null;

        static {
            int[] r100 = new int[CardContent.WidthMode.values().length];
            r100[CardContent.WidthMode.FILL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CardContent.WidthMode.COMPACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f283730a = r100;
        }
    }

    static {
        f283725a = LazyKt.lazy(UniversalCardLargeScreenAdapt$enable$2.INSTANCE);
        f283726b = LazyKt.lazy(UniversalCardLargeScreenAdapt$screenConfig$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) f283725a.getValue()).booleanValue();
    }

    public static boolean c(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (b() == true) goto L5;
        return false;
    L5:
        int r102 = h.f283983a;
        Context r103 = UIUtils.getActivityFromContext(r100);
        if (r103 != null) goto L10;
        r103 = LarkContext.getApplication();
    L10:
        if (h.a(r103) == true) goto L13;
        return false;
    L13:
        if (r101 < ((a) f283726b.getValue()).f283729c) goto L16;
        return true;
    L16:
        return false;
    }

    public static boolean d(Context r100, CardContent.WidthMode r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "widthMode");
        if (b() == true) goto L5;
        return true;
    L5:
        int r102 = h.f283983a;
        Context r103 = UIUtils.getActivityFromContext(r100);
        if (r103 != null) goto L10;
        r103 = LarkContext.getApplication();
    L10:
        if (h.a(r103) == true) goto L13;
        return true;
    L13:
        if (b.f283730a[r101.ordinal()] == 1) goto L17;
        return false;
    L17:
        return true;
    }

    public static int a(Context r100, int r101, CardContent.WidthMode r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "widthMode");
        if (b() == true) goto L5;
        return r101;
    L5:
        int r103 = h.f283983a;
        Context r104 = UIUtils.getActivityFromContext(r100);
        if (r104 != null) goto L10;
        r104 = LarkContext.getApplication();
    L10:
        if (h.a(r104) == true) goto L12;
        return r101;
    L12:
        int r105 = b.f283730a[r102.ordinal()];
        if (r105 != 1) goto L15;
        return r101;
    L15:
        if (r105 == 2) goto L18;
        return Math.min(r101, ((a) f283726b.getValue()).f283727a);
    L18:
        return Math.min(r101, ((a) f283726b.getValue()).f283728b);
    }
}
