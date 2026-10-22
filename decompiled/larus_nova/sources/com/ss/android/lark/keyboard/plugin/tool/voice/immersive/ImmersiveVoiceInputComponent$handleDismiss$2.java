package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "popupWindow", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/popup/abs/IAudioPopupWindow;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImmersiveVoiceInputComponent$handleDismiss$2 extends Lambda implements Function1<com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> {
    final /* synthetic */ ImmersiveVoiceInputComponent this$0;

    public ImmersiveVoiceInputComponent$handleDismiss$2(ImmersiveVoiceInputComponent r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b r100) {
        Intrinsics.checkNotNullParameter(r100, "popupWindow");
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
