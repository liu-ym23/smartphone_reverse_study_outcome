package com.larus.common_ui.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/larus/common_ui/utils/ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "onPrepare", "", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/core/view/WindowInsetsAnimationCompat;", WidgetCostModule.TYPE_ON_START, "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onEnd", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1 extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f327839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f327840b;

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onPrepare(WindowInsetsAnimationCompat r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat r100, List<WindowInsetsAnimationCompat> r101) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        Intrinsics.checkNotNullParameter(r101, "runningAnimations");
        return r100;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r100, WindowInsetsAnimationCompat.BoundsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Intrinsics.checkNotNullParameter(r101, "bounds");
        return r101;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function0<Unit> r101 = this.f327839a;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        ViewCompat.setWindowInsetsAnimationCallback(this.f327840b, null);
    }

    public ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1(Function0<Unit> r100, View r101) {
        this.f327839a = r100;
        this.f327840b = r101;
        super(1);
    }
}
