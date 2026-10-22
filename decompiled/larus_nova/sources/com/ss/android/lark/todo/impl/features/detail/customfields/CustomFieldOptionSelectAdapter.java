package com.ss.android.lark.todo.impl.features.detail.customfields;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z7c.e;
import z7c.g;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cBI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001c\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/customfields/CustomFieldOptionSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/customfields/CustomFieldOptionSelectAdapter$ViewHolder;", "enableMultiSelect", "", "selectOptions", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/todo/v1/SelectFieldOption;", "Lkotlin/collections/ArrayList;", "allOptions", "", "isEditable", "listener", "Lcom/ss/android/lark/todo/impl/features/common/dialog/CustomFieldOptionDialogBuilder$IOptionUpdateListener;", "<init>", "(ZLjava/util/ArrayList;Ljava/util/List;ZLcom/ss/android/lark/todo/impl/features/common/dialog/CustomFieldOptionDialogBuilder$IOptionUpdateListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "getItemCount", "ViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomFieldOptionSelectAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f443032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<SelectFieldOption> f443033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<SelectFieldOption> f443034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f443035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e.a f443036e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/customfields/CustomFieldOptionSelectAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/customfields/CustomFieldOptionSelectAdapter;Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f443037a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f443037a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f443034c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return ((SelectFieldOption) ListProtector.get(this.f443034c, r100)).guid.hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        SelectFieldOption r103 = (SelectFieldOption) ListProtector.get(this.f443034c, r101);
        ((LinearLayout) r102.itemView.findViewById(R.id.option_tag_layout)).post(new b(r102, r103));
        Iterator<T> r104 = this.f443033b.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((SelectFieldOption) r105).guid, r103.guid) == false) goto L4;
    L9:
        if (r105 == null) goto L11;
        boolean r106 = true;
    L12:
        com.larksuite.framework.section.utils.a.e(r102.f443037a.findViewById(R.id.option_select_check), r106);
        r102.f443037a.findViewById(R.id.option_layout).setOnClickListener(new a(this, r103));
        return;
    L11:
        r106 = false;
        goto L12
    L8:
        r105 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.detail_custom_field_option_item, r100, false));
    }

    public CustomFieldOptionSelectAdapter(boolean r100, ArrayList r101, List r102, boolean r103, g r104) {
        Intrinsics.checkNotNullParameter(r101, "selectOptions");
        Intrinsics.checkNotNullParameter(r102, "allOptions");
        this.f443032a = r100;
        this.f443033b = r101;
        this.f443034c = r102;
        this.f443035d = r103;
        this.f443036e = r104;
        setHasStableIds(true);
    }
}
