package com.ss.android.lark.chat.message.menu.v2.popup;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupMenu$rootView$2$1$2 extends FunctionReferenceImpl implements Function3<Boolean, MessageActionType, Boolean, Unit> {
    public PopupMenu$rootView$2$1$2(Object r100) {
        super(3, r100, PopupMenu.class, "dismiss", "dismiss(ZLcom/ss/android/lark/biz/im/extension/message_action/MessageActionType;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, MessageActionType r101, Boolean r102) {
        invoke(r100.booleanValue(), r101, r102.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100, MessageActionType r101, boolean r102) {
        ((PopupMenu) this.receiver).d(r100, r101, r102);
    }
}
