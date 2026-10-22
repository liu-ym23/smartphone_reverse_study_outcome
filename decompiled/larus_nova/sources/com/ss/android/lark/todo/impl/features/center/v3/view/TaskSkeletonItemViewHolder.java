package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskSkeletonItemViewHolder;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$BaseViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;)V", "getView", "()Landroid/view/View;", "getListener", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "bind", "", "baseItem", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/BaseItem;", "bindBackground", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskSkeletonItem;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSkeletonItemViewHolder extends TaskListAdapter.BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f441979c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f441981b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.BaseViewHolder
    public final void T3(com.ss.android.lark.todo.impl.features.center.v3.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, "baseItem");
        if ((r100 instanceof com.ss.android.lark.todo.impl.features.center.v3.data.g) == false) goto L5;
        com.ss.android.lark.todo.impl.features.center.v3.data.g r101 = (com.ss.android.lark.todo.impl.features.center.v3.data.g) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        this.f441981b.l(r101.f441571a);
        ViewGroup.LayoutParams r102 = this.f441980a.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r101.f441575e == false) goto L11;
        int r104 = y9c.d.a(16);
    L12:
        r103.setMargins(0, 0, 0, r104);
        this.f441980a.setLayoutParams(r103);
        View r105 = this.f441980a;
        r105.setBackground(y9c.d.e(r105.getContext(), TaskListAdapter.BaseViewHolder.U3(r101)));
        com.larksuite.framework.section.utils.a.d(this.f441980a.findViewById(R.id.divider_todo_item), !r101.f441575e);
        lt7.d.a r106 = new lt7.d.a(this.f441980a.findViewById(R.id.taskSkeletonFl));
        r106.f510707b = R.layout.task_list_task_skeleton_item;
        r106.f510708c = true;
        r106.f510711f = 20;
        r106.f510710e = 1000;
        r106.b();
        return;
    L11:
        r104 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public TaskSkeletonItemViewHolder(View r100, u0 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f441980a = r100;
        this.f441981b = r101;
    }
}
