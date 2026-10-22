package com.ss.android.lark.contact.base.common_ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001c2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005JJ\u0010\r\u001a\u00020\u000e\"\b\b\u0000\u0010\u000f*\u00020\u0003\"\u0010\b\u0001\u0010\u0010*\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\u00022\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000f0\f2\u0016\u0010\u0012\u001a\u0012\u0012\u0006\b\u0001\u0012\u0002H\u000f\u0012\u0006\b\u0001\u0012\u0002H\u00100\tJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u001e\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0016RN\u0010\u0006\u001aB\u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\t0\u0007j \u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u000b\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\f\u0012\u0004\u0012\u00020\b0\u0007j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\f\u0012\u0004\u0012\u00020\b`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/contact/base/common_ui/BaseItemListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/base/common_ui/ItemViewHolder;", "", "<init>", "()V", "viewType2CellMapper", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/contact/base/common_ui/ItemCell;", "Lkotlin/collections/HashMap;", "dataClazz2ViewTypeMapper", "Ljava/lang/Class;", "registerItemCell", "", "Value", "VH", "clazz", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "getItemData", "position", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseItemListAdapter extends RecyclerView.Adapter<ItemViewHolder<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, d<Object, ItemViewHolder<Object>>> f418535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Class<? extends Object>, Integer> f418536b;

    public static final class a {
    }

    static {
    }

    public abstract Object y2(int r100);

    public BaseItemListAdapter() {
        this.f418535a = new HashMap();
        this.f418536b = new HashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Object r101 = y2(r100);
        if (r101 == null) goto L7;
        Integer r102 = this.f418536b.get(r101.getClass());
        if (r102 == null) goto L7;
        return r102.intValue();
    L7:
        return -1000;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Object r103 = y2(r101);
        if (r103 == null) goto L8;
        Function2<? super Value, ? super Integer, Unit> r104 = r102.f418549b;
        if (r104 == 0) goto L9;
        r104.invoke((Object) r103, Integer.valueOf(r101));
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        final d<Object, ItemViewHolder<Object>> r102 = this.f418535a.get(Integer.valueOf(r101));
        if (r102 == null) goto L6;
        final ItemViewHolder r103 = r102.b();
        r103.f418549b = new BaseItemListAdapter$onCreateViewHolder$1$1$1(r102, r103);
        return r103;
    L6:
        return new ItemViewHolder(new View(r100.getContext()));
    }
}
