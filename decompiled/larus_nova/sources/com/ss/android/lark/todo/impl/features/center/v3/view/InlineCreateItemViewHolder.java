package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/InlineCreateItemViewHolder;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$BaseViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;)V", "getView", "()Landroid/view/View;", "getListener", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "bind", "", "baseItem", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/BaseItem;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InlineCreateItemViewHolder extends TaskListAdapter.BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f441851c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f441853b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f441854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InlineCreateItemViewHolder f441855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.todo.impl.features.center.v3.data.d f441856c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f441854a;
            long r102 = System.currentTimeMillis();
            this.f441854a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            t r103 = this.f441855b.f441853b;
            com.ss.android.lark.todo.impl.features.center.v3.data.d r104 = this.f441856c;
            r103.g(r104.f441550a, r104.f441551b);
        }

        public b(InlineCreateItemViewHolder r100, com.ss.android.lark.todo.impl.features.center.v3.data.d r101) {
            this.f441855b = r100;
            this.f441856c = r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.BaseViewHolder
    public final void T3(com.ss.android.lark.todo.impl.features.center.v3.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, "baseItem");
        if ((r100 instanceof com.ss.android.lark.todo.impl.features.center.v3.data.d) == false) goto L5;
        com.ss.android.lark.todo.impl.features.center.v3.data.d r101 = (com.ss.android.lark.todo.impl.features.center.v3.data.d) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r102 = this.f441852a.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.setMargins(0, 0, 0, y9c.d.a(16));
        this.f441852a.setLayoutParams(r103);
        View r104 = this.f441852a;
        r104.setBackground(y9c.d.e(r104.getContext(), TaskListAdapter.BaseViewHolder.U3(r101)));
        this.f441852a.setOnClickListener(new b(this, r101));
        return;
    L5:
        r101 = null;
        goto L6
    }

    public InlineCreateItemViewHolder(View r100, u0 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f441852a = r100;
        this.f441853b = r101;
    }
}
