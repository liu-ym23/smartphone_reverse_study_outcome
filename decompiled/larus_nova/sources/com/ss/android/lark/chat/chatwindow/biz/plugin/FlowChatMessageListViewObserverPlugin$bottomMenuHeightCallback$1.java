package com.ss.android.lark.chat.chatwindow.biz.plugin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FlowChatMessageListViewObserverPlugin$bottomMenuHeightCallback$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    public FlowChatMessageListViewObserverPlugin$bottomMenuHeightCallback$1(Object r100) {
        super(2, r100, FlowChatMessageListViewObserverPlugin.class, "updateBottomMenuHeight", "updateBottomMenuHeight(II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Integer r101) {
        invoke(r100.intValue(), r101.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, int r101) {
        FlowChatMessageListViewObserverPlugin.F((FlowChatMessageListViewObserverPlugin) this.receiver, r100, r101);
    }
}
