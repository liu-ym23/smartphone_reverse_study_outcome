package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BD\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/type/SearchSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/search/picker/filter/type/ViewHolder;", "typeItemList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/search/picker/filter/type/SelectTypeItem;", "Lkotlin/collections/ArrayList;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectTypeItem", "", "<init>", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "enableMultiSelect", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemList", "onBindViewHolder", "holder", "position", "handleSelected", "item", "isCheckBox", "enable", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSelectAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final ArrayList<e> a;
    public final Function1<e, Unit> b;
    public boolean c;

    public final int getItemCount() {
        return this.a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSelectAdapter(ArrayList<e> r2, Function1<? super e, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "typeItemList");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ViewHolder r5 = (ViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        e r6 = (e) ListProtector.get(this.a, r4);
        CheckBox r0 = r5.a;
        if (this.c == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        r5.a.setChecked(r6.c);
        r5.b.setText(r6.a);
        r5.a.setOnCheckedChangeListener(new a(this, r5, r6));
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new b(this, r5, r6));
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131564487, r4, false));
    }

    public static final void y2(SearchSelectAdapter r1, ViewHolder r2, e r3, boolean r4) {
        if (r1.c == false) goto L7;
        if (r4 == true) goto L6;
        CheckBox r5 = r2.a;
        r5.setChecked(!r5.isChecked());
    L6:
        r3.c = r2.a.isChecked();
        r1.b.invoke(null);
        return;
    L7:
        r1.b.invoke(r3);
    }
}
