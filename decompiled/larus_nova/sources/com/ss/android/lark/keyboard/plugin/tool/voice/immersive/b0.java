package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b0 implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f430263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f430264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f430265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f430266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f430267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImmersiveVoiceView f430268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f430269g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final Pair<Integer, Integer> getLayoutParamAttributes() {
        return new Pair(-1, -1);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final View getContentView() {
        return this.f430268f;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a
    public final void t5(Function0<Unit> r100) {
        r100.invoke();
    }

    public static final void a(b0 r100, int r101) {
        Context r102 = r100.f430263a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        FlowToast.a r103 = FlowToast.a(r102);
        r103.e(r101);
        r103.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r102, R.drawable.ud_icon_info_outlined));
        View r104 = r100.f430268f.findViewById(R.id.send_asr_all_result);
        if (r104 != null) goto L6;
    L11:
        int r105 = 0;
    L12:
        r103.c(80, 0, r105);
        r103.a().show();
        return;
    L6:
        if (r104.getHeight() <= 0) goto L11;
        if (r100.f430264b.getHeight() <= 0) goto L11;
        int[] r106 = new int[2];
        int[] r107 = new int[2];
        r104.getLocationOnScreen(r106);
        r100.f430264b.getLocationOnScreen(r107);
        r105 = RangesKt.coerceAtLeast(((r107[1] + r100.f430264b.getHeight()) - r106[1]) + UIUtils.dp2px(r100.f430263a, 8.0f), 0);
        goto L12
    }

    public static final void b(b0 r100, int r101) {
        Context r102 = r100.f430263a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        FlowToast.a r103 = FlowToast.a(r102);
        r103.e(r101);
        r103.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r102, R.drawable.ud_icon_info_outlined));
        r103.c(17, 0, 0);
        r103.a().show();
    }

    public b0(Context r110, AudioPopupWindowImpl.b r111, Fragment r112, FragmentActivity r113, Float r114, IVoiceFaceDependency r115, Function0 r116, a0 r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "decorView");
        Intrinsics.checkNotNullParameter(r116, "isContainerRootView");
        Intrinsics.checkNotNullParameter(r210, "keyboardMenuConfig");
        this.f430263a = r110;
        this.f430264b = r111;
        this.f430265c = r112;
        this.f430266d = r116;
        this.f430267e = "ImmersiveVoicePopupView";
        this.f430268f = new ImmersiveVoiceView(r110, r111, r112, r113, r114, r115, r116, r210);
        Lazy r100 = LazyKt.lazy(new ImmersiveVoicePopupView$immersiveVoiceViewModel$2(this));
        this.f430269g = r100;
        ImmersiveVoiceViewModel r101 = (ImmersiveVoiceViewModel) r100.getValue();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r101.getVoiceRecordTooShort().observe(r112, new c0(this));
        r101.getShouldShowAsrWaitingPoorNetTips().observe(r112, new d0(this));
        r101.getShouldShowPoorNetTips().observe(r112, new e0(this));
        r101.getRecordingOccurException().observe(r112, new f0(this));
    }
}
