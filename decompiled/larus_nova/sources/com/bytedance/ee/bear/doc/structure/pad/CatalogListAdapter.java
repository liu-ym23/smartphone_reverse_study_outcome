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
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010+\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010,\u001a\u00020\rH\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u00182\u0006\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0002J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\rH\u0016J\u0018\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/doc/structure/pad/ParagraphViewHolder;", "Lcom/bytedance/ee/bear/doc/structure/pad/ICatalogAbility;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "structure", "Lcom/bytedance/ee/bear/doc/structure/Structure;", "inflater", "Landroid/view/LayoutInflater;", "<set-?>", "", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "selectedPosition$delegate", "Lkotlin/properties/ReadWriteProperty;", "itemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/bytedance/ee/bear/doc/structure/Structure$Paragraph;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "itemHoverListener", "Landroid/view/View$OnHoverListener;", "getItemHoverListener", "()Landroid/view/View$OnHoverListener;", "setItemHoverListener", "(Landroid/view/View$OnHoverListener;)V", "value", "", "activeContentId", "getActiveContentId", "()Ljava/lang/String;", "setActiveContentId", "(Ljava/lang/String;)V", "setStructure", "getItemCount", "getItem", "position", "getActivePosition", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogListAdapter extends RecyclerView.Adapter<ParagraphViewHolder> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f218201h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f218202i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f218203j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f218204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Structure f218205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f218206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f218207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super View, ? super Structure.Paragraph, Unit> f218208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnHoverListener f218209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f218210g;

    public static final class a {
    }

    public static final class b extends ObservableProperty<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CatalogListAdapter f218211a;

        public b(Object r100, CatalogListAdapter r101) {
            this.f218211a = r101;
            super(r100);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Integer r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            int r103 = r102.intValue();
            int r104 = r101.intValue();
            this.f218211a.notifyItemChanged(r104);
            this.f218211a.notifyItemChanged(r103);
            RecyclerView.LayoutManager r105 = this.f218211a.f218204a.getLayoutManager();
            if ((r105 instanceof CenterLayoutManager) == false) goto L5;
            CenterLayoutManager r106 = (CenterLayoutManager) r105;
        L6:
            if (r106 == null) goto L14;
            RecyclerView r107 = this.f218211a.f218204a;
            Intrinsics.checkNotNullParameter(r107, "recyclerView");
            if (r103 >= 0) goto L10;
            return;
        L10:
            if (r103 >= r106.getItemCount()) goto L16;
            r106.scrollToPosition(r103);
            r107.post(new c(r106, r103, r107));
            return;
        L16:
            return;
        L14:
            return;
        L5:
            r106 = null;
            goto L6
        }
    }

    static {
        f218201h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(CatalogListAdapter.class, "selectedPosition", "getSelectedPosition()I", 0))};
        f218202i = n.d(12);
        n.d(16);
        f218203j = n.d(20);
        n.d(24);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Structure r100 = this.f218205b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getParagraphCount();
    }

    public CatalogListAdapter(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f218204a = r100;
        Delegates r101 = Delegates.INSTANCE;
        this.f218207d = new b(0, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ParagraphViewHolder r102 = (ParagraphViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Structure r103 = this.f218205b;
        if (r103 == null) goto L5;
        Structure.Paragraph r104 = r103.getParagraph(r101);
    L6:
        if (r104 == null) goto L17;
        View r105 = r102.f218216a;
        View r106 = r102.f218217b;
        TextView r107 = r102.f218218c;
        r107.setText(r104.title);
        boolean r108 = false;
        r107.setSelected(false);
        r106.setSelected(false);
        if (r104.level != 1) goto L11;
        int r109 = e.f483540a;
        Typeface r110 = e.b(r107.getContext(), 1);
    L12:
        r107.setTypeface(r110);
        if (this.f218207d.getValue(this, f218201h[0]).intValue() != r101) goto L15;
        r108 = true;
    L15:
        r107.setSelected(r108);
        r106.setSelected(r108);
        ViewGroup.LayoutParams r111 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r111;
        r112.width = f218202i + ((r104.level - 1) * f218203j);
        r105.setLayoutParams(r112);
        r107.setOnClickListener(new com.bytedance.ee.bear.doc.structure.pad.a(this, r104));
        r107.setOnHoverListener(new com.bytedance.ee.bear.doc.structure.pad.b(this));
        return;
    L11:
        int r113 = e.f483540a;
        r110 = e.b(r107.getContext(), 0);
        goto L12
    L17:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.f218206c != null) goto L5;
        this.f218206c = LayoutInflater.from(r100.getContext());
    L5:
        LayoutInflater r102 = this.f218206c;
        if (r102 != null) goto L9;
        r102 = LayoutInflater.from(r100.getContext());
        this.f218206c = r102;
    L9:
        return new ParagraphViewHolder(r102.inflate(R.layout.pad_catalog_structure_paragraph, r100, false));
    }
}
