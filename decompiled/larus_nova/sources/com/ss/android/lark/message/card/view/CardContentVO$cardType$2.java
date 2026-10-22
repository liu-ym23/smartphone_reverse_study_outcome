package com.ss.android.lark.message.card.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$Type;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CardContentVO$cardType$2 extends Lambda implements Function0<CardContent.Type> {
    final /* synthetic */ CardContent $content;

    public CardContentVO$cardType$2(CardContent r100) {
        this.$content = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CardContent.Type invoke() {
        return this.$content.getType();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CardContent.Type invoke() {
        return invoke();
    }
}
