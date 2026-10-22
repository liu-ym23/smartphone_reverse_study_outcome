package com.larus.business.markdown.impl.markwon;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "node", "Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EmojiReader$isEmojiOfCharIndex$visionIdx$1 extends Lambda implements Function1<EmojiReader$Node, Integer> {
    final /* synthetic */ int $idx;

    public EmojiReader$isEmojiOfCharIndex$visionIdx$1(int r100) {
        this.$idx = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(EmojiReader$Node r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        int r101 = this.$idx;
        r100.getClass();
        if (r101 >= 0) goto L6;
        int r102 = 1;
    L10:
        return Integer.valueOf(r102);
    L6:
        if (this.$idx < 0) goto L8;
        r102 = -1;
        goto L10
    L8:
        r102 = 0;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(EmojiReader$Node r100) {
        return invoke2(r100);
    }
}
