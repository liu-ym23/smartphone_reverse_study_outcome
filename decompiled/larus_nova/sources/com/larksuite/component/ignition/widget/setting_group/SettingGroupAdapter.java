package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0016J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "adapter", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "value", "", "itemBackgroundColorResources", "getItemBackgroundColorResources", "()I", "setItemBackgroundColorResources", "(I)V", "isItemStateful", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setItemStateful", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "bindBackground", "getItemViewType", "setHasStableIds", "hasStableIds", "getItemId", "", "getItemCount", "lastItemIndex", "onViewRecycled", "onFailedToRecycleView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "registerAdapterDataObserver", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "unregisterAdapterDataObserver", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "ignition-widget-settinggroup_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f284003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f284004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Integer, Boolean> f284006d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f284004b.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return this.f284004b.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f284004b.getItemViewType(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f284004b.onAttachedToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f284004b.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return this.f284004b.onFailedToRecycleView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f284004b.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f284004b.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f284004b.onViewRecycled(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f284004b.registerAdapterDataObserver(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r100) {
        this.f284004b.setHasStableIds(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f284004b.unregisterAdapterDataObserver(r100);
    }

    public SettingGroupAdapter(Context r100, RecyclerView.Adapter<RecyclerView.ViewHolder> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "adapter");
        this.f284003a = r100;
        this.f284004b = r101;
        this.f284005c = R.color.bg_setting_group_item;
        this.f284006d = SettingGroupAdapter$isItemStateful$1.INSTANCE;
        r101.registerAdapterDataObserver(new AnonymousClass1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f284004b.onBindViewHolder(r100, r101);
        y2(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f284004b.onCreateViewHolder(r100, r101);
    }

    public final void y2(RecyclerView.ViewHolder r100, int r101) {
        Drawable r102 = r100.itemView.getBackground();
        if ((r102 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r103 = (GradientDrawable) r102;
    L6:
        if (r103 != null) goto L11;
        r103 = new GradientDrawable();
        if (this.f284006d.invoke(Integer.valueOf(r101)).booleanValue() == false) goto L10;
        r103.setColor(UIUtils.getColorStateList(this.f284003a, this.f284005c));
        goto L11
    L10:
        r103.setColor(UIUtils.getColor(this.f284003a, this.f284005c));
    L11:
        int r104 = b.f284022a;
        Context r105 = this.f284003a;
        int r106 = getItemCount();
        float r107 = d.b(r105, 10);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r108 = false;
        if (r101 != 0) goto L14;
        boolean r109 = true;
    L16:
        if (r101 != (r106 - 1)) goto L18;
        r108 = true;
    L18:
        b.a(r103, r105, r109, r108, r107);
        r100.itemView.setBackground(r103);
        return;
    L14:
        r109 = false;
        goto L16
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        this.f284004b.onBindViewHolder(r100, r101, r102);
        y2(r100, r101);
    }
}
