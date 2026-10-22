package com.bytedance.ee.bear.widgets.collapse;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0011B\u0017\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter;", "T", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter$CollapsibleViewHolder;", WikiFolderPushPlugin.DATA, "", "<init>", "(Ljava/util/List;)V", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "position", "", "CollapsibleViewHolder", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CollapsibleAdapter<T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T, CollapsibleViewHolder> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter$CollapsibleViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleItemAnimator$ICollapsibleItem;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "groupIndex", "", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupChildCount", "getGroupChildCount", "setGroupChildCount", "getIndexInGroup", "getCountInGroup", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CollapsibleViewHolder extends BaseViewHolder implements CollapsibleItemAnimator.b {
        public int a;
        public int b;

        @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleItemAnimator.b
        public final int A2() {
            return this.a;
        }

        @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleItemAnimator.b
        public final int V() {
            return this.b;
        }

        public CollapsibleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = -1;
        }
    }

    public CollapsibleAdapter(List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        super(r2);
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.onAttachedToRecyclerView(r2);
        r2.setItemAnimator(new CollapsibleItemAnimator());
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((CollapsibleViewHolder) r1, r2);
    }

    public void y2(CollapsibleViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.onBindViewHolder(r6, r7);
        int r0 = getParentPositionInAll(r7);
        int r1 = getItemCount() - 1;
        int r2 = r7 + 1;
        int r3 = getItemCount();
    L3:
        if (r2 >= r3) goto L9;
        if (isExpandable((MultiItemEntity) getItem(r2)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = r2 - 1;
    L9:
        if (r0 != (-1)) goto L11;
        int r8 = 0;
    L12:
        r6.a = r8;
        r6.b = r1 - r0;
        return;
    L11:
        r8 = r7 - r0;
        goto L12
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(BaseViewHolder r1, int r2) {
        y2((CollapsibleViewHolder) r1, r2);
    }
}
