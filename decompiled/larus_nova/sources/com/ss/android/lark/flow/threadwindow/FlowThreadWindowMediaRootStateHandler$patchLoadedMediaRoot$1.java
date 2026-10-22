package com.ss.android.lark.flow.threadwindow;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.message.SendStatus;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/chat/entity/message/SendStatus;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/chat/entity/message/SendStatus;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1 extends Lambda implements Function1<SendStatus, Boolean> {
    public static final FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1 INSTANCE = null;

    static {
        INSTANCE = new FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1();
    }

    public FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(SendStatus r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(SendStatus r100) {
        return Boolean.TRUE;
    }
}
