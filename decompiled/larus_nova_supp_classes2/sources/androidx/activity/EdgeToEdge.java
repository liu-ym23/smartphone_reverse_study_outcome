package androidx.activity;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0011\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DefaultDarkScrim", "", "getDefaultDarkScrim$annotations", "()V", "getDefaultDarkScrim", "()I", "DefaultLightScrim", "getDefaultLightScrim$annotations", "getDefaultLightScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "enable", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EdgeToEdge {
    private static final int DefaultDarkScrim = 0;
    private static final int DefaultLightScrim = 0;
    private static EdgeToEdgeImpl Impl;

    public static final void enable(ComponentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        enable$default(r2, null, null, 3, null);
    }

    public static final void enable(ComponentActivity r2, SystemBarStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "statusBarStyle");
        enable$default(r2, r3, null, 2, null);
    }

    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    static {
        DefaultLightScrim = Color.argb(230, 255, 255, 255);
        DefaultDarkScrim = Color.argb(128, 27, 27, 27);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    public static View INVOKEVIRTUAL_androidx_activity_EdgeToEdge_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final void enable(ComponentActivity r8, SystemBarStyle r9, SystemBarStyle r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "statusBarStyle");
        Intrinsics.checkNotNullParameter(r10, "navigationBarStyle");
        View r5 = INVOKEVIRTUAL_androidx_activity_EdgeToEdge_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r8.getWindow());
        boolean r6 = ((Boolean) r9.getDetectDarkMode$activity_release().invoke(r5.getResources())).booleanValue();
        boolean r7 = ((Boolean) r10.getDetectDarkMode$activity_release().invoke(r5.getResources())).booleanValue();
        EdgeToEdgeImpl r0 = Impl;
        if (r0 != null) goto L14;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 29) goto L8;
        r0 = new EdgeToEdgeApi29();
        goto L14
    L8:
        if (r1 < 26) goto L11;
        r0 = new EdgeToEdgeApi26();
        goto L14
    L11:
        if (r1 < 23) goto L13;
        r0 = new EdgeToEdgeApi23();
        goto L14
    L13:
        r0 = new EdgeToEdgeApi21();
        Impl = r0;
    L14:
        r0.setUp(r9, r10, r8.getWindow(), r5, r6, r7);
    }

    public static /* synthetic */ void enable$default(ComponentActivity r6, SystemBarStyle r7, SystemBarStyle r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r7 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
    L6:
        if ((r9 & 2) == 0) goto L8;
        r8 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
    L8:
        enable(r6, r7, r8);
    }
}
