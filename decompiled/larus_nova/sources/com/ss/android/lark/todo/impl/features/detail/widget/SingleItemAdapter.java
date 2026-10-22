package com.ss.android.lark.todo.impl.features.detail.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/widget/SingleItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/widget/SingleItemAdapter$InnerHolder;", "contentView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "currentWrapper", "Landroid/view/ViewGroup;", "onCreateViewHolder", "parent", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "Companion", "InnerHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleItemAdapter extends RecyclerView.Adapter<InnerHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f443917c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f443918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f443919b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/widget/SingleItemAdapter$InnerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "wrapper", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "getWrapper", "()Landroid/view/ViewGroup;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InnerHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f443920a;

        public InnerHolder(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "wrapper");
            super(r100);
            this.f443920a = r100;
            setIsRecyclable(false);
        }
    }

    public static final class a {
        @JvmStatic
        public static SingleItemAdapter a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            return new SingleItemAdapter(r100);
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 1;
    }

    public SingleItemAdapter(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        this.f443918a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter((InnerHolder) r100, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        FrameLayout r102 = new FrameLayout(this.f443918a.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ViewGroup r103 = this.f443919b;
        if (r103 == null) goto L6;
        r103.removeViewInLayout(this.f443918a);
        r103.endViewTransition(this.f443918a);
    L6:
        if (this.f443918a.getParent() != null) goto L8;
        r102.addView(this.f443918a);
    L8:
        this.f443919b = r102;
        return new InnerHolder(r102);
    }
}
