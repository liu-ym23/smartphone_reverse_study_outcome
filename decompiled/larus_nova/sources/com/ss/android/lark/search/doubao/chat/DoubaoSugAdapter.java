package com.ss.android.lark.search.doubao.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB?\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0007J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/DoubaoSugAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/search/doubao/chat/DoubaoSugAdapter$VH;", "items", "", "Lcom/ss/android/lark/search/doubao/chat/DoubaoSugAdapter$HistoryItem;", "onItemClick", "Lkotlin/Function1;", "", "onDeleteClick", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "submitList", "newItems", "", "deleteItem", MapController.ITEM_LAYER_TAG, "HistoryItem", "VH", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoSugAdapter extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f440045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<a, Unit> f440046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<a, Unit> f440047c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/DoubaoSugAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "leftIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getLeftIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "rightIcon", "getRightIcon", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VH extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f440048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatImageView f440049b;

        public VH(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f440048a = (TextView) r100.findViewById(R.id.sug_title);
            AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.sug_left_icon);
            this.f440049b = (AppCompatImageView) r100.findViewById(R.id.sug_right_icon);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f440050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f440051b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f440050a, r101.f440050a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f440051b, r101.f440051b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f440050a.hashCode() * 31) + this.f440051b.hashCode();
        }

        public final String toString() {
            return "HistoryItem(title=" + this.f440050a + ", id=" + this.f440051b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "id");
            this.f440050a = r100;
            this.f440051b = r101;
        }
    }

    public DoubaoSugAdapter() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f440045a.size();
    }

    public DoubaoSugAdapter(Function1 r100, Function1 r101) {
        ArrayList r102 = new ArrayList();
        Intrinsics.checkNotNullParameter(r102, "items");
        Intrinsics.checkNotNullParameter(r100, "onItemClick");
        Intrinsics.checkNotNullParameter(r101, "onDeleteClick");
        this.f440045a = r102;
        this.f440046b = r100;
        this.f440047c = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VH r102 = (VH) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        a r103 = (a) ListProtector.get(this.f440045a, r101);
        r102.f440048a.setText(r103.f440050a);
        r102.itemView.setOnClickListener(new t(this, r103));
        r102.f440049b.setOnClickListener(new u(this, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_doubao_chat_sug, r100, false);
        Intrinsics.checkNotNull(r102);
        return new VH(r102);
    }
}
