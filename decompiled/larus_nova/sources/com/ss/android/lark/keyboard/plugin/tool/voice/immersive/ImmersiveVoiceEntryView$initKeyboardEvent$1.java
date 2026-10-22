package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.keyboard.event.ImeState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/event/IEventContext;", "from", "Lcom/ss/android/lark/keyboard/event/ImeState;", RemoteMessageConst.TO, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImmersiveVoiceEntryView$initKeyboardEvent$1 extends Lambda implements Function3<com.ss.android.lark.keyboard.event.g, ImeState, ImeState, Unit> {
    final /* synthetic */ v this$0;

    public ImmersiveVoiceEntryView$initKeyboardEvent$1(v r100) {
        this.this$0 = r100;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.ss.android.lark.keyboard.event.g r100, ImeState r101, ImeState r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectTransform");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        if (r101 == ImeState.NONE) goto L5;
        return;
    L5:
        if (r102 != ImeState.PANEL) goto L7;
    L9:
        this.this$0.getClass();
        throw null;
    L7:
        if (r102 == ImeState.IME) goto L9;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(com.ss.android.lark.keyboard.event.g r100, ImeState r101, ImeState r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
