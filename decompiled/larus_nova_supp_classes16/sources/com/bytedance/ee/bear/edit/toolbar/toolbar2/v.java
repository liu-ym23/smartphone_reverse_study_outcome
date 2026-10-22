package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v {

    public static final class a {
    }

    public interface b {
        void a(boolean r1);
    }

    static {
    }

    public v() {
    }

    public final void b(FragmentActivity r11, b r12) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "delegate");
        Lazy r0 = ForsetiHelper.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.enable_fix_leak_window_info_tracker") == false) goto L5;
        WeakReference r2 = new WeakReference(r11);
        final Job r13 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), Dispatchers.getMain(), null, new ToolbarFoldingService$onViewCreated$1$collectJob$1(r2, r11, this, r12, null), 2, null);
        r11.getLifecycle().addObserver(new ToolbarFoldingService$onViewCreated$1$1(r13));
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), Dispatchers.getMain(), null, new ToolbarFoldingService$onViewCreated$2$1(r11, r11, this, r12, null), 2, null);
    }

    public static final void a(v r4, WindowLayoutInfo r5, b r6) {
        r4.getClass();
        if ((!r5.getDisplayFeatures().isEmpty()) == false) goto L18;
        FoldingFeature r7 = (DisplayFeature) ListProtector.get(r5.getDisplayFeatures(), 0);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.window.layout.FoldingFeature");
        FoldingFeature r8 = r7;
        if ((r7 instanceof FoldingFeature) == true) goto L8;
        r8 = null;
    L8:
        if (r8 != null) goto L10;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
        r6.a(true);
        tt5.a.b("ToolbarFoldingService", "onFoldingChanged true");
        return;
    L17:
        r6.a(false);
        tt5.a.b("ToolbarFoldingService", "onFoldingChanged false");
        return;
    L10:
        if (r8.isSeparating() == false) goto L14;
        if (Intrinsics.areEqual(r8.getOrientation(), FoldingFeature.Orientation.HORIZONTAL) == false) goto L14;
        r9 = true;
        goto L15
    L18:
        r6.a(false);
        tt5.a.b("ToolbarFoldingService", "onFoldingChanged false");
    }
}
