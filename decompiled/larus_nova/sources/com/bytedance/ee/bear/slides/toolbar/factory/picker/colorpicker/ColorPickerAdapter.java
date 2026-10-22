package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB5\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem;", "selectedColor", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "onColorSelected", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "updateData", "newItems", "updateSelectedColor", "TitleViewHolder", "ColorViewHolder", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorPickerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends ColorPickerListItem> f238616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorValueItem f238617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ColorValueItem, Unit> f238618c;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter;Landroid/view/View;)V", "colorCircleView", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/CircleColorView;", "selectedBorderView", "bind", "", "colorItem", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$ColorItem;", "onColorSelected", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ColorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CircleColorView f238619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f238620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ColorPickerAdapter f238621c;

        public ColorViewHolder(ColorPickerAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f238621c = r100;
            super(r101);
            this.f238619a = (CircleColorView) r101.findViewById(R.id.circle_color_view);
            this.f238620b = r101.findViewById(R.id.view_selected_border);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "titleTextView", "Landroid/widget/TextView;", "bind", "", "titleItem", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$TitleItem;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f238622a;

        public TitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f238622a = (TextView) r100.findViewById(R.id.tv_title_item);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238623a = null;

        static {
            int[] r100 = new int[ColorPickerItemType.values().length];
            r100[ColorPickerItemType.TITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ColorPickerItemType.COLOR_ITEM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f238623a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f238616a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((ColorPickerListItem) ListProtector.get(this.f238616a, r100)).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof TitleViewHolder) == false) goto L6;
        Object r102 = ListProtector.get(this.f238616a, r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerListItem.TitleItem");
        ColorPickerListItem.TitleItem r103 = (ColorPickerListItem.TitleItem) r102;
        TitleViewHolder r104 = (TitleViewHolder) r100;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "titleItem");
        r104.f238622a.setText(r103.getTitle());
        return;
    L6:
        if ((r100 instanceof ColorViewHolder) == false) goto L14;
        Object r105 = ListProtector.get(this.f238616a, r101);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerListItem.ColorItem");
        ColorPickerListItem.ColorItem r106 = (ColorPickerListItem.ColorItem) r105;
        ColorViewHolder r107 = (ColorViewHolder) r100;
        Function1<ColorValueItem, Unit> r108 = this.f238618c;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "colorItem");
        Intrinsics.checkNotNullParameter(r108, "onColorSelected");
        ColorValueItem r109 = r106.getColorValueItem();
        r107.f238619a.setColor(r109);
        View r110 = r107.f238620b;
        if (Intrinsics.areEqual(r107.f238621c.f238617b, r109) == false) goto L10;
        int r111 = 0;
    L11:
        r110.setVisibility(r111);
        CircleColorView r112 = r107.f238619a;
        c r113 = c.f238659a;
        Context r114 = r112.getContext();
        r113.getClass();
        r112.setBoard(c.d(r114, r109));
        r107.itemView.setOnClickListener(new com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.a(r108, r109));
        return;
    L10:
        r111 = 4;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ColorPickerItemType r102 = ColorPickerItemType.values()[r101];
        int r103 = a.f238623a[r102.ordinal()];
        if (r103 != 1) goto L5;
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.slides_color_picker_title_item, r100, false);
        Intrinsics.checkNotNull(r104);
        return new TitleViewHolder(r104);
    L5:
        if (r103 != 2) goto L8;
        View r105 = LayoutInflater.from(r100.getContext()).inflate(R.layout.slides_color_picker_item_layout, r100, false);
        Intrinsics.checkNotNull(r105);
        return new ColorViewHolder(this, r105);
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ColorPickerAdapter(List<? extends ColorPickerListItem> r100, ColorValueItem r101, Function1<? super ColorValueItem, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r102, "onColorSelected");
        this.f238616a = r100;
        this.f238617b = r101;
        this.f238618c = r102;
    }
}
