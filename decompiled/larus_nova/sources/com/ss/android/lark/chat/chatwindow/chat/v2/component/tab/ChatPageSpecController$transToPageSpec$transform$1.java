package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.chat.ChatTab;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/IChatTabPageSpec;", "it", "Lcom/ss/android/lark/chat/entity/chat/ChatTab;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatPageSpecController$transToPageSpec$transform$1 extends Lambda implements Function1<ChatTab, b<?, ?>> {
    final /* synthetic */ long $firstTabId;
    final /* synthetic */ a this$0;

    public ChatPageSpecController$transToPageSpec$transform$1(a r100, long r101) {
        this.this$0 = r100;
        this.$firstTabId = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b<?, ?> invoke2(ChatTab r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.this$0.getClass();
        new Ref.ObjectRef();
        r100.getId();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ b<?, ?> invoke(ChatTab r100) {
        return invoke2(r100);
    }
}
