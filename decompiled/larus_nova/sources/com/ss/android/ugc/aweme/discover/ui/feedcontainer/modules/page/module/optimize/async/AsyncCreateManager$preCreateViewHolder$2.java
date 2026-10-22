package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AsyncCreateManager$preCreateViewHolder$2 extends Lambda implements Function0<RecyclerView.ViewHolder> {
    final /* synthetic */ int $type;
    final /* synthetic */ AsyncCreateManager this$0;

    public AsyncCreateManager$preCreateViewHolder$2(AsyncCreateManager r100, int r101) {
        this.this$0 = r100;
        this.$type = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RecyclerView.ViewHolder invoke() {
        return this.this$0.f450629a.invoke(Integer.valueOf(this.$type), Boolean.TRUE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder invoke() {
        return invoke();
    }
}
