package com.bytedance.ee.bear.office.common.screenmenu;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ScreenMenu$show$2 extends Lambda implements Function0<View> {
    final /* synthetic */ Function0<View> $menuViewHolder;

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenMenu$show$2(Function0<? extends View> r100) {
        this.$menuViewHolder = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        return this.$menuViewHolder.invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }
}
