package com.larus.common_ui.utils;

import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.bottom.core.l5;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/larus/common_ui/utils/ViewExtKt$watchOnImeInsetsAnimationInternal$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "isImeShow", "", WidgetCostModule.TYPE_ON_START, "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/core/view/WindowInsetsAnimationCompat;", "bounds", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onEnd", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt$watchOnImeInsetsAnimationInternal$1 extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f327841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f327842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2<Boolean, WindowInsetsAnimationCompat, Unit> f327843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Insets, Unit> f327844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function2<Insets, Boolean, Unit> f327845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f327846f;

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.i("watchOnImeInsetsAnimationEnd", "onEnd:" + this.f327841a);
        Function1<Boolean, Unit> r101 = this.f327846f;
        if (r101 == null) goto L6;
        r101.invoke(Boolean.valueOf(this.f327841a));
        return;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat r100, List<WindowInsetsAnimationCompat> r101) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        Intrinsics.checkNotNullParameter(r101, "runningAnimations");
        this.f327841a = r100.isVisible(WindowInsetsCompat.Type.ime());
        FLogger.f375446a.i("watchOnImeInsetsAnimationEnd", "onProgress:" + this.f327841a);
        Insets r102 = r100.getInsets(WindowInsetsCompat.Type.ime());
        Function1<Insets, Unit> r103 = this.f327844d;
        if (r103 == null) goto L5;
        r103.invoke(r102);
    L5:
        Function2<Insets, Boolean, Unit> r104 = this.f327845e;
        if (r104 == null) goto L8;
        r104.invoke(r102, Boolean.valueOf(this.f327841a));
    L8:
        return r100;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r100, WindowInsetsAnimationCompat.BoundsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Intrinsics.checkNotNullParameter(r101, "bounds");
        FLogger.f375446a.i("watchOnImeInsetsAnimationEnd", "onStart:" + this.f327841a);
        Function1<Boolean, Unit> r102 = this.f327842b;
        if (r102 == null) goto L5;
        r102.invoke(Boolean.valueOf(!this.f327841a));
    L5:
        Function2<Boolean, WindowInsetsAnimationCompat, Unit> r103 = this.f327843c;
        if (r103 == null) goto L8;
        r103.invoke(Boolean.valueOf(!this.f327841a), r100);
    L8:
        return r101;
    }

    public ViewExtKt$watchOnImeInsetsAnimationInternal$1(Function1 r100, l5 r101, Function1 r102, Function2 r103, Function1 r104) {
        this.f327842b = r100;
        this.f327843c = r101;
        this.f327844d = r102;
        this.f327845e = r103;
        this.f327846f = r104;
        super(1);
    }
}
