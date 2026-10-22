package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0007J\u001a\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/SelectButtonListView;", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentIndex", "totalCount", "onButtonSelected", "Lkotlin/Function1;", "", "show", "index", "total", "hide", "getCurrentIndex", "onIndexSelected", "listener", "updateSelection", "generateSelectButtonStateList", "", "Lcom/larus/bmhome/view/SelectButtonState;", "SelectButtonAdapter", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectButtonListView extends HorizontalOverScrollRV {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f315591l = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f315592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f315593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Integer, Unit> f315594k;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/view/SelectButtonListView$SelectButtonAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/SelectButtonState;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "(Lcom/larus/bmhome/view/SelectButtonListView;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "SelectButtonViewHolder", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SelectButtonAdapter extends ListAdapter<f4, RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectButtonListView f315595a;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/SelectButtonListView$SelectButtonAdapter$SelectButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/view/SelectButtonListView$SelectButtonAdapter;Landroid/view/View;)V", "textIndex", "Landroid/widget/TextView;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/view/SelectButtonState;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SelectButtonViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ int f315596c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f315597a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SelectButtonAdapter f315598b;

            public SelectButtonViewHolder(SelectButtonAdapter r100, View r101) {
                Intrinsics.checkNotNullParameter(r101, "itemView");
                this.f315598b = r100;
                super(r101);
                this.f315597a = (TextView) r101.findViewById(R.id.text_index);
            }
        }

        public SelectButtonAdapter(SelectButtonListView r100) {
            this.f315595a = r100;
            super(new AnonymousClass1());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            final f4 r102 = getItem(r101);
            if ((r100 instanceof SelectButtonViewHolder) == false) goto L6;
            SelectButtonViewHolder r103 = (SelectButtonViewHolder) r100;
            Intrinsics.checkNotNull(r102);
            r103.getClass();
            Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
            r103.f315597a.setText(String.valueOf(r102.f316928a + 1));
            r103.f315597a.setSelected(r102.f316929b);
            TextView r104 = r103.f315597a;
            final SelectButtonListView r105 = r103.f315598b.f315595a;
            com.larus.utils.e1.d(r104, new e4(r105, r102));
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_select_button, r100, false);
            Intrinsics.checkNotNull(r102);
            return new SelectButtonViewHolder(this, r102);
        }
    }

    public SelectButtonListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SelectButtonListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final List<f4> v() {
        ArrayList r100 = new ArrayList();
        int r101 = this.f315593j;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (r102 != this.f315592i) goto L7;
        boolean r103 = true;
    L8:
        r100.add(new f4(r102, r103));
        r102 = r102 + 1;
        goto L3
    L7:
        r103 = false;
        goto L8
    L9:
        return r100;
    }

    public final int getCurrentIndex() {
        return this.f315592i;
    }

    public SelectButtonListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOverScrollMode(2);
        setItemAnimator(null);
        setLayoutManager(new LinearLayoutManager(r100, 0, false));
        setAdapter(new SelectButtonAdapter(this));
    }

    public /* synthetic */ SelectButtonListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
