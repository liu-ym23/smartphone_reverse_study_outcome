package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB5\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem;", "selectedColor", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "onColorSelected", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "updateData", "newItems", "updateSelectedColor", "TitleViewHolder", "ColorViewHolder", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorPickerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<? extends ColorPickerListItem> a;
    public ColorValueItem b;
    public final Function1<ColorValueItem, Unit> c;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter;Landroid/view/View;)V", "colorCircleView", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/CircleColorView;", "selectedBorderView", "bind", "", "colorItem", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$ColorItem;", "onColorSelected", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ColorViewHolder extends RecyclerView.ViewHolder {
        public final CircleColorView a;
        public final View b;
        public final /* synthetic */ ColorPickerAdapter c;

        public ColorViewHolder(ColorPickerAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.c = r2;
            super(r3);
            this.a = (CircleColorView) r3.findViewById(2131365720);
            this.b = r3.findViewById(2131392585);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "titleTextView", "Landroid/widget/TextView;", "bind", "", "titleItem", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerListItem$TitleItem;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TitleViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public TitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131391615);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ColorPickerItemType.values().length];
            r0[ColorPickerItemType.TITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ColorPickerItemType.COLOR_ITEM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        return ((ColorPickerListItem) ListProtector.get(this.a, r2)).getType().ordinal();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        if ((r5 instanceof TitleViewHolder) == false) goto L6;
        Object r7 = ListProtector.get(this.a, r6);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerListItem.TitleItem");
        ColorPickerListItem.TitleItem r8 = (ColorPickerListItem.TitleItem) r7;
        TitleViewHolder r9 = (TitleViewHolder) r5;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "titleItem");
        r9.a.setText(r8.getTitle());
        return;
    L6:
        if ((r5 instanceof ColorViewHolder) == false) goto L14;
        Object r10 = ListProtector.get(this.a, r6);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.ColorPickerListItem.ColorItem");
        ColorPickerListItem.ColorItem r11 = (ColorPickerListItem.ColorItem) r10;
        ColorViewHolder r12 = (ColorViewHolder) r5;
        Function1<ColorValueItem, Unit> r0 = this.c;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "colorItem");
        Intrinsics.checkNotNullParameter(r0, "onColorSelected");
        ColorValueItem r13 = r11.getColorValueItem();
        r12.a.setColor(r13);
        View r1 = r12.b;
        if (Intrinsics.areEqual(r12.c.b, r13) == false) goto L10;
        int r2 = 0;
    L11:
        r1.setVisibility(r2);
        CircleColorView r3 = r12.a;
        c r4 = c.a;
        Context r14 = r3.getContext();
        r4.getClass();
        r3.setBoard(c.d(r14, r13));
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.a(r0, r13));
        return;
    L10:
        r2 = 4;
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ColorPickerItemType r5 = ColorPickerItemType.values()[r4];
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        View r7 = LayoutInflater.from(r3.getContext()).inflate(2131564885, r3, false);
        Intrinsics.checkNotNull(r7);
        return new TitleViewHolder(r7);
    L5:
        if (r6 != 2) goto L8;
        View r8 = LayoutInflater.from(r3.getContext()).inflate(2131564884, r3, false);
        Intrinsics.checkNotNull(r8);
        return new ColorViewHolder(this, r8);
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ColorPickerAdapter(List<? extends ColorPickerListItem> r2, ColorValueItem r3, Function1<? super ColorValueItem, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r4, "onColorSelected");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
