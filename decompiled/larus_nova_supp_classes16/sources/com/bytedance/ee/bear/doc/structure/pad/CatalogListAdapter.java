package com.bytedance.ee.bear.doc.structure.pad;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.structure.Structure;
import com.bytedance.ee.util.ui.n;
import h18.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010+\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010,\u001a\u00020\rH\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u00182\u0006\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0002J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\rH\u0016J\u0018\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/structure/pad/ParagraphViewHolder;", "Lcom/bytedance/ee/bear/doc/structure/pad/ICatalogAbility;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "structure", "Lcom/bytedance/ee/bear/doc/structure/Structure;", "inflater", "Landroid/view/LayoutInflater;", "<set-?>", "", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "selectedPosition$delegate", "Lkotlin/properties/ReadWriteProperty;", "itemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/bytedance/ee/bear/doc/structure/Structure$Paragraph;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "itemHoverListener", "Landroid/view/View$OnHoverListener;", "getItemHoverListener", "()Landroid/view/View$OnHoverListener;", "setItemHoverListener", "(Landroid/view/View$OnHoverListener;)V", "value", "", "activeContentId", "getActiveContentId", "()Ljava/lang/String;", "setActiveContentId", "(Ljava/lang/String;)V", "setStructure", "getItemCount", "getItem", "position", "getActivePosition", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogListAdapter extends RecyclerView.Adapter<ParagraphViewHolder> {
    public static final /* synthetic */ KProperty<Object>[] h = null;
    public static final int i = 0;
    public static final int j = 0;
    public final RecyclerView a;
    public Structure b;
    public LayoutInflater c;
    public final b d;
    public Function2<? super View, ? super Structure.Paragraph, Unit> e;
    public View.OnHoverListener f;
    public String g;

    public static final class a {
    }

    public static final class b extends ObservableProperty<Integer> {
        public final /* synthetic */ CatalogListAdapter a;

        public b(Object r1, CatalogListAdapter r2) {
            this.a = r2;
            super(r1);
        }

        public final void afterChange(KProperty<?> r2, Integer r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            int r5 = r4.intValue();
            int r6 = r3.intValue();
            this.a.notifyItemChanged(r6);
            this.a.notifyItemChanged(r5);
            CenterLayoutManager r7 = this.a.a.getLayoutManager();
            if ((r7 instanceof CenterLayoutManager) == false) goto L5;
            CenterLayoutManager r8 = r7;
        L6:
            if (r8 == null) goto L14;
            RecyclerView r9 = this.a.a;
            Intrinsics.checkNotNullParameter(r9, "recyclerView");
            if (r5 >= 0) goto L10;
            return;
        L10:
            if (r5 >= r8.getItemCount()) goto L16;
            r8.scrollToPosition(r5);
            r9.post(new c(r8, r5, r9));
            return;
        L16:
            return;
        L14:
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    static {
        h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(CatalogListAdapter.class, "selectedPosition", "getSelectedPosition()I", 0))};
        i = n.d(12);
        n.d(16);
        j = n.d(20);
        n.d(24);
    }

    public final int getItemCount() {
        Structure r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getParagraphCount();
    }

    public CatalogListAdapter(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
        Delegates r3 = Delegates.INSTANCE;
        this.d = new b(0, this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ParagraphViewHolder r10 = (ParagraphViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Structure r0 = this.b;
        if (r0 == null) goto L5;
        Structure.Paragraph r1 = r0.getParagraph(r9);
    L6:
        if (r1 == null) goto L17;
        View r2 = r10.a;
        View r3 = r10.b;
        TextView r11 = r10.c;
        r11.setText(r1.title);
        boolean r4 = false;
        r11.setSelected(false);
        r3.setSelected(false);
        if (r1.level != 1) goto L11;
        int r5 = e.a;
        Typeface r6 = e.b(r11.getContext(), 1);
    L12:
        r11.setTypeface(r6);
        if (((Number) this.d.getValue(this, h[0])).intValue() != r9) goto L15;
        r4 = true;
    L15:
        r11.setSelected(r4);
        r3.setSelected(r4);
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.width = i + ((r1.level - 1) * j);
        r2.setLayoutParams(r13);
        r11.setOnClickListener(new com.bytedance.ee.bear.doc.structure.pad.a(this, r1));
        r11.setOnHoverListener(new com.bytedance.ee.bear.doc.structure.pad.b(this));
        return;
    L11:
        int r7 = e.a;
        r6 = e.b(r11.getContext(), 0);
        goto L12
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (this.c != null) goto L5;
        this.c = LayoutInflater.from(r3.getContext());
    L5:
        LayoutInflater r5 = this.c;
        if (r5 != null) goto L9;
        r5 = LayoutInflater.from(r3.getContext());
        this.c = r5;
    L9:
        return new ParagraphViewHolder(r5.inflate(2131564158, r3, false));
    }
}
