package com.bytedance.android.shopping.card_list.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class CardListExtentionsKt$scrollToBottom$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RecyclerView $this_scrollToBottom;

    public CardListExtentionsKt$scrollToBottom$1(RecyclerView r1) {
        this.$this_scrollToBottom = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m572invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m572invoke() {
        RecyclerView.Adapter r0 = this.$this_scrollToBottom.getAdapter();
        if (r0 == null) goto L14;
        Integer r1 = Integer.valueOf(r0.getItemCount());
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L15;
        int r3 = r1.intValue();
        this.$this_scrollToBottom.scrollToPosition(r3 - 1);
        return;
    L15:
        return;
    L7:
        r2 = false;
        goto L8
    }
}
