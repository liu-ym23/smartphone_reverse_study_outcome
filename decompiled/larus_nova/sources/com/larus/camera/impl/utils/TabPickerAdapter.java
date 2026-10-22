package com.larus.camera.impl.utils;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.widget.TabPickerView;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/utils/TabPickerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/camera/impl/widget/TabPickerView$Tab;", "Lcom/larus/camera/impl/utils/TabPickerAdapter$PickerViewHolder;", "<init>", "()V", "scrollListener", "Lkotlin/Function1;", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "bindScrollListener", "Companion", "PickerViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabPickerAdapter extends ListAdapter<TabPickerView.a, PickerViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TabPickerAdapter$Companion$differ$1 f322707b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f322708a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/camera/impl/utils/TabPickerAdapter$PickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PickerViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f322709a;

        public PickerViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f322709a = r100;
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.camera.impl.utils.TabPickerAdapter$Companion$differ$1] */
    static {
        f322707b = new TabPickerAdapter$Companion$differ$1();
    }

    public TabPickerAdapter() {
        super(f322707b);
        this.f322708a = new h0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        PickerViewHolder r102 = (PickerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TextView r103 = (TextView) r102.f322709a.findViewById(R.id.item_text);
        r103.setTypeface(Typeface.defaultFromStyle(1));
        r103.setText(getItem(r101).f322900a);
        e1.d(r103, new i0(this, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PickerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_layout_view_tab_item, r100, false));
    }
}
