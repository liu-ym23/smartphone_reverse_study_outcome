package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/event/IEventContext;", "it", "Lcom/ss/android/lark/keyboard/biz/notify/MentionDoubaoNotify;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1 extends Lambda implements Function2<com.ss.android.lark.keyboard.event.g, znb.c, Unit> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    final /* synthetic */ a this$0;

    public FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1(a r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r101) {
        this.this$0 = r100;
        this.$chatApp = r101;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.ss.android.lark.keyboard.event.g r100, znb.c r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$selectNotify");
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f573010a == true) goto L6;
        Log.d("FlowMentionDoubaoTipPlugin", "observeKeyboardEvent: isMentionDoubao is false");
        return;
    L6:
        a r102 = this.this$0;
        com.ss.android.lark.storage.a r103 = a.f422879g;
        r102.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.ss.android.lark.keyboard.event.g r100, znb.c r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
