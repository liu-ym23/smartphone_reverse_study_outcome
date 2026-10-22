package com.larus.bot.impl.feature.edit.feature.autofill;

import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bot.impl.common.propertyconfig.Visibility;
import com.larus.bot.impl.databinding.LarusLayoutAutoFillBtnBinding;
import com.larus.common_ui.view.b0;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
public final class BotAutoFillUIBinder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f318400f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TraceFragment f318401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0<LarusLayoutAutoFillBtnBinding> f318402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f318403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dv8.b f318404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f318405e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f318406a = null;

        static {
            int[] r100 = new int[Visibility.values().length];
            r100[Visibility.VISIBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Visibility.DISABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Visibility.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f318406a = r100;
        }
    }

    static {
    }

    public final void a() {
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(this.f318403c.getUiEvent(), new BotAutoFillUIBinder$bindUIEvent$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this.f318401a.getViewLifecycleOwner()));
    }

    public final void b() {
        if (z2.f365865a.createBotAutoFillEnable() == false) goto L18;
        this.f318402b.b();
        if (this.f318405e == true) goto L11;
        LarusLayoutAutoFillBtnBinding r100 = (LarusLayoutAutoFillBtnBinding) this.f318402b.f328321c;
        if (r100 == null) goto L11;
        LinearLayout r101 = r100.f317815a;
        if (r101 == null) goto L11;
        r101.setBackgroundResource(R.drawable.larus_bg_bot_create_auto_fill);
    L11:
        LarusLayoutAutoFillBtnBinding r102 = (LarusLayoutAutoFillBtnBinding) this.f318402b.f328321c;
        if (r102 == null) goto L16;
        LinearLayout r103 = r102.f317815a;
        if (r103 == null) goto L16;
        e1.d(r103, new d(this));
    L16:
        LifecycleOwnerKt.getLifecycleScope(this.f318401a.getViewLifecycleOwner()).launchWhenStarted(new BotAutoFillUIBinder$initView$2(this, null));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f318401a.getViewLifecycleOwner()), null, null, new BotAutoFillUIBinder$bindObservers$1(this, null), 3, null);
        a();
        return;
    }

    public BotAutoFillUIBinder(TraceFragment r100, b0<LarusLayoutAutoFillBtnBinding> r101, j r102, dv8.b r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "viewStub");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f318401a = r100;
        this.f318402b = r101;
        this.f318403c = r102;
        this.f318404d = r103;
        this.f318405e = r104;
    }
}
