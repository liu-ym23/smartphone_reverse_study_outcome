package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/larksuite/component/universe_design/button/ButtonDrawableParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AbsAudioPopupView$setMainBtnIcon$1 extends Lambda implements Function1<com.larksuite.component.universe_design.button.a, Unit> {
    public static final AbsAudioPopupView$setMainBtnIcon$1 INSTANCE = null;

    static {
        INSTANCE = new AbsAudioPopupView$setMainBtnIcon$1();
    }

    public AbsAudioPopupView$setMainBtnIcon$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.larksuite.component.universe_design.button.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$showDrawable");
        r100.f284589c = 2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.larksuite.component.universe_design.button.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
