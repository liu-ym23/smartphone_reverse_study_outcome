package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0017¨\u0006\u000f"}, d2 = {"Landroidx/activity/EdgeToEdgeApi26;", "Landroidx/activity/EdgeToEdgeImpl;", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "window", "Landroid/view/Window;", "view", "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EdgeToEdgeApi26 implements EdgeToEdgeImpl {
    public EdgeToEdgeApi26() {
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle r2, SystemBarStyle r3, Window r4, View r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "statusBarStyle");
        Intrinsics.checkNotNullParameter(r3, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(r4, "window");
        Intrinsics.checkNotNullParameter(r5, "view");
        WindowCompat.setDecorFitsSystemWindows(r4, false);
        r4.setStatusBarColor(r2.getScrim$activity_release(r6));
        r4.setNavigationBarColor(r3.getScrim$activity_release(r7));
        WindowInsetsControllerCompat r8 = new WindowInsetsControllerCompat(r4, r5);
        r8.setAppearanceLightStatusBars(!r6);
        r8.setAppearanceLightNavigationBars(!r7);
    }
}
