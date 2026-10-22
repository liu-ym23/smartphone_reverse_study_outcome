package com.ss.android.lark.todo.impl.features.detail.at.view.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.todo.impl.features.detail.at.view.e;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q28.c;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u0004:\u0002 !B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtSelectAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtBean;", "Lcom/larksuite/framework/ui/stickyheader/StickyRecyclerHeadersAdapter;", "mListener", "Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtSelectAdapter$OnItemSelectListener;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtSelectAdapter$OnItemSelectListener;)V", "mLabelMap", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtLabelBean;", "Lkotlin/collections/HashMap;", "binderProvider", "Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtSelectAdapter$BinderProvider;", "initLabelData", "", "getItemId", "", "position", "initBinderMap", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getHeaderId", "onCreateHeaderViewHolder", "onBindHeaderViewHolder", "getItemViewType", "BinderProvider", "OnItemSelectListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtSelectAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, AtBean> implements c<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, f8c.b> f442809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f442810b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<f8c.c<? extends AtBean, ? extends RecyclerView.ViewHolder>> f442811a;

        public a() {
            this.f442811a = new SparseArray();
        }

        public final <D extends AtBean, VH extends RecyclerView.ViewHolder> f8c.c<D, VH> a(int r100) {
            Object r101 = this.f442811a.get(r100);
            if ((r101 instanceof f8c.c) == false) goto L5;
            f8c.c<D, VH> r102 = (f8c.c) r101;
        L6:
            if (r102 == null) goto L9;
            return r102;
        L9:
            throw new IllegalArgumentException("No accessor found for " + r100);
        L5:
            r102 = null;
            goto L6
        }
    }

    public interface b {
        void a(f8c.a r100);

        String b(f8c.a r100);
    }

    public AtSelectAdapter(e r100) {
        Intrinsics.checkNotNullParameter(r100, "mListener");
        HashMap<Integer, f8c.b> r101 = new HashMap();
        this.f442809a = r101;
        a r102 = new a();
        this.f442810b = r102;
        AtLabelBinder r103 = new AtLabelBinder(r100);
        Intrinsics.checkNotNullParameter(r103, "value");
        r102.f442811a.put(0, r103);
        AtDataBinder r104 = new AtDataBinder(r100);
        Intrinsics.checkNotNullParameter(r104, "value");
        r102.f442811a.put(1, r104);
        i r105 = i.f444291a;
        r101.put(0, new f8c.b(r105.g(R.string.Todo_Task_ProbabilityAtPersonHint), 0));
        r101.put(1, new f8c.b(r105.g(R.string.Todo_Task_ChatMembers), 1));
        r101.put(2, new f8c.b(r105.g(R.string.Todo_Task_ChatMembers), 2));
        r101.put(3, new f8c.b("", 3));
    }

    @Override // q28.c
    public final long getHeaderId(int r100) {
        int r101 = getItemViewType(r100);
        return this.f442810b.a(r101).a(getItem(r100));
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return CastLongProtector.parseLong(getItem(r100).a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return getItem(r100).getType();
    }

    @Override // q28.c
    public final RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f442810b.a(0).n(r100);
    }

    @Override // q28.c
    public final void onBindHeaderViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = getItem(r101).f442801a;
        f8c.c r103 = this.f442810b.a(0);
        f8c.b r104 = this.f442809a.get(Integer.valueOf(r102));
        if (r104 == null) goto L6;
        r103.b(r100, r104);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = getItemViewType(r101);
        f8c.c r103 = this.f442810b.a(r102);
        AtBean r104 = getItem(r101);
        Intrinsics.checkNotNull(r104);
        r103.b(r100, r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f442810b.a(r101).n(r100);
    }
}
