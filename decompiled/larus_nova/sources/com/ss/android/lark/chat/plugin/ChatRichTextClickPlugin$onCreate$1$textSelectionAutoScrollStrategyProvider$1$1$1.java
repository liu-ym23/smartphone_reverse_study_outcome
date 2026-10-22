package com.ss.android.lark.chat.plugin;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.widget.select.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/select/TextSelectionScrollBounds;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatRichTextClickPlugin$onCreate$1$textSelectionAutoScrollStrategyProvider$1$1$1 extends Lambda implements Function0<s> {
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ int $topOffsetPx;

    public ChatRichTextClickPlugin$onCreate$1$textSelectionAutoScrollStrategyProvider$1$1$1(RecyclerView r100, int r101) {
        this.$recyclerView = r100;
        this.$topOffsetPx = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final s invoke() {
        RecyclerView r100 = this.$recyclerView;
        int[] r101 = new int[2];
        if (r100 == null) goto L5;
        r100.getLocationOnScreen(r101);
    L5:
        float r102 = r101[1] + this.$topOffsetPx;
        RecyclerView r103 = this.$recyclerView;
        int[] r104 = new int[2];
        if (r103 == null) goto L8;
        r103.getLocationOnScreen(r104);
    L8:
        int r105 = r104[1];
        if (r103 == null) goto L11;
        int r106 = r103.getHeight();
    L13:
        return new s(r102, r105 + r106);
    L11:
        r106 = 0;
        goto L13
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ s invoke() {
        return invoke();
    }
}
