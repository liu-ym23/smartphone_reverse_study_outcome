package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "onInserted", "", "position", "", "count", "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", "payload", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiListUpdateCallback implements ListUpdateCallback {
    public final BaseQuickAdapter<?, ?> a;

    public WikiListUpdateCallback(WikiTreeView.WikiAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        this.a = r2;
    }

    public final void onInserted(int r3, int r4) {
        BaseQuickAdapter<?, ?> r0 = this.a;
        r0.notifyItemRangeInserted(r3 + r0.getHeaderLayoutCount(), r4);
    }

    public final void onMoved(int r3, int r4) {
        BaseQuickAdapter<?, ?> r0 = this.a;
        r0.notifyItemMoved(r3 + r0.getHeaderLayoutCount(), r4);
    }

    public final void onRemoved(int r3, int r4) {
        BaseQuickAdapter<?, ?> r0 = this.a;
        r0.notifyItemRangeRemoved(r3 + r0.getHeaderLayoutCount(), r4);
    }

    public final void onChanged(int r3, int r4, Object r5) {
        BaseQuickAdapter<?, ?> r0 = this.a;
        r0.notifyItemRangeChanged(r3 + r0.getHeaderLayoutCount(), r4, r5);
    }
}
