package com.ss.android.lark.blueprint.recyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.blueprint.d;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.n;
import com.ss.android.lark.blueprint.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vza.e;
import wza.c;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tH$J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u001e\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0010\u001a\u00020\tH\u0016J,\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/blueprint/recyclerview/BlueprintAdapter;", "Data", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/blueprint/recyclerview/BlueprintCellViewHolder;", "<init>", "()V", "viewTypeToSpec", "", "", "Lcom/ss/android/lark/blueprint/ICellSpec;", "blueprint", "Lcom/ss/android/lark/blueprint/Blueprint;", "getBlueprint", "()Lcom/ss/android/lark/blueprint/Blueprint;", "getItemData", "position", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "onViewRecycled", "blueprint_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BlueprintAdapter<Data> extends RecyclerView.Adapter<BlueprintCellViewHolder<? super Data>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, n> f410657a;

    public abstract d y2();

    public abstract Object z2(int r100);

    public BlueprintAdapter() {
        this.f410657a = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Object r101 = z2(r100);
        d r102 = y2();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r102.f410637a.getDataType().isAssignableFrom(r101.getClass()) == false) goto L5;
        o<?> r103 = r102.f410637a;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.blueprint.ICellSpecMapper<Data of com.ss.android.lark.blueprint.Blueprint.getCellSpec>");
        n r104 = r103.a(r101);
    L6:
        if (r104 == null) goto L10;
        int r105 = r104.getId();
        this.f410657a.put(Integer.valueOf(r105), r104);
        return r105;
    L10:
        throw new IllegalStateException("Cannot find cell spec for data at position: " + r100 + ", class: " + r101.getClass());
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        BlueprintCellViewHolder r101 = (BlueprintCellViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.f410658a.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BlueprintCellViewHolder r102 = (BlueprintCellViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Object r103 = z2(r101);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type Data of com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.f410658a.update(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.ss.android.lark.blueprint.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [wza.c] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        n r102 = (n) ((LinkedHashMap) this.f410657a).get(Integer.valueOf(r101));
        if (r102 == null) goto L13;
        d r103 = y2();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "cellSpec");
        e r104 = r103.f410638b;
        Class<?> r105 = r102.getClass();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "dataClz");
        Object r106 = ((LinkedHashMap) r104.f557759a).get(r105);
        if ((r106 instanceof c) == false) goto L7;
        ?? r107 = (c) r106;
    L8:
        if (r107 != 0) goto L10;
        r107 = new com.ss.android.lark.blueprint.e(r102.getClass());
        e r108 = r103.f410638b;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "cellFactory");
        r108.f557759a.put(r107.b(), (c<?, ?>) r107);
    L10:
        m r109 = r107.a(r103.f410639c, r102);
        return new BlueprintCellViewHolder(r109.b(r100), r109);
    L7:
        r107 = 0;
        goto L8
    L13:
        throw new IllegalStateException("Cannot find cell spec for viewType: " + r101);
    }

    public void A2(BlueprintCellViewHolder<? super Data> r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        Object r103 = z2(r101);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type Data of com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter");
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        Intrinsics.checkNotNullParameter(r102, "patchList");
        r100.f410658a.d(r103, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        A2((BlueprintCellViewHolder) r100, r101, r102);
    }
}
