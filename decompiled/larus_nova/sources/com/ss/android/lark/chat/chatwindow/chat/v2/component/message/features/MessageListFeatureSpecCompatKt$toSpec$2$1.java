package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import androidx.arch.core.util.Function;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "vo", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/chat/vo/ChatMessageVO;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class MessageListFeatureSpecCompatKt$toSpec$2$1 extends Lambda implements Function1<y6b.c<?>, Boolean> {
    final /* synthetic */ Function<y6b.c<?>, Boolean> $listener;

    public MessageListFeatureSpecCompatKt$toSpec$2$1(Function<y6b.c<?>, Boolean> r100) {
        this.$listener = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(y6b.c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        return this.$listener.apply(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(y6b.c<?> r100) {
        return invoke2(r100);
    }
}
