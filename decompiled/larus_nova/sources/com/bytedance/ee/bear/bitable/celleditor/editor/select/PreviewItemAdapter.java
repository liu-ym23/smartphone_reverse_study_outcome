package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTagView;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTextView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004&'()B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J(\u0010!\u001a\u00020\u001d2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0#J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$PreviewViewHolder;", "<init>", "()V", "selectOptionIds", "", "", "optionItemMap", "", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;", "mActionListener", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$ActionListener;", "getMActionListener", "()Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$ActionListener;", "setMActionListener", "(Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$ActionListener;)V", "itemLayoutRes", "", "getItemLayoutRes", "()I", "createViewHolder", "itemView", "Landroid/view/View;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "setData", "", "", "setActionListener", "actionListener", "PreviewViewHolder", "PreviewViewHolderV2", "ActionListener", "V2", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PreviewItemAdapter extends RecyclerView.Adapter<PreviewViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f209442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, SelectEditorModel.IEditorOption> f209443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f209444c;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$PreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "actionListenerProvider", "Lkotlin/Function0;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$ActionListener;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "selectItem", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "getSelectItem", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "closeIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "optionItem", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;", "renderItem", "", "applyItemPadding", "bindPreviewTagAppearance", "option", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class PreviewViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<a> f209445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SelectTextView f209446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f209447c;

        public void T3() {
            this.f209446b.setPadding(n.d(8), n.d(2), n.d(24), n.d(2));
        }

        public void U3(SelectEditorModel.IEditorOption r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            String r101 = r100.getTextColor();
            if (r101 == null) goto L6;
            this.f209447c.setImageTintList(ColorStateList.valueOf(ColorUtils.h(r101)));
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewViewHolder(View r100, Function0<? extends a> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "actionListenerProvider");
            super(r100);
            this.f209445a = r101;
            SelectTextView r102 = (SelectTextView) r100.findViewById(R.id.option_item);
            this.f209446b = r102;
            this.f209447c = (AppCompatImageView) r100.findViewById(R.id.closeIcon);
            T3();
            r102.V1 = false;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$PreviewViewHolderV2;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$PreviewViewHolder;", "itemView", "Landroid/view/View;", "actionListenerProvider", "Lkotlin/Function0;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$ActionListener;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "applyItemPadding", "", "bindPreviewTagAppearance", "option", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/SelectEditorModel$IEditorOption;", "applyCloseIconStyle", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreviewViewHolderV2 extends PreviewViewHolder {
        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.PreviewItemAdapter.PreviewViewHolder
        public final void T3() {
            SelectTextView r100 = this.f209446b;
            if ((r100 instanceof SelectTagView) == false) goto L5;
            SelectTagView r101 = (SelectTagView) r100;
        L6:
            if (r101 == null) goto L8;
            r101.U(BaseTagSize.LARGE);
        L8:
            this.f209447c.setImageResource(R.drawable.ud_icon_close_bold_outlined);
            this.f209447c.setAlpha(1.0f);
            ViewGroup.LayoutParams r102 = this.f209447c.getLayoutParams();
            BaseTagSize r103 = BaseTagSize.LARGE;
            r102.width = n.d(r103.getRightIconSizeDp());
            r102.height = n.d(r103.getRightIconSizeDp());
            if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            int r104 = n.d(r103.getRightIconPaddingDp());
            ((ViewGroup.MarginLayoutParams) r102).rightMargin = r104;
        L11:
            this.f209447c.setLayoutParams(r102);
            int r105 = (r103.getRightIconSizeDp() + r103.getRightIconGapDp()) + r103.getRightIconPaddingDp();
            this.f209446b.setPadding(n.d(r103.getTextPaddingHorizontalDp()), 0, n.d(r105), 0);
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.PreviewItemAdapter.PreviewViewHolder
        public final void U3(SelectEditorModel.IEditorOption r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            SelectTextView r101 = this.f209446b;
            String r102 = null;
            if ((r101 instanceof SelectTagView) == false) goto L5;
            SelectTagView r103 = (SelectTagView) r101;
        L6:
            if (r103 == null) goto L8;
            r103.S(r100.getBorderColor());
        L8:
            String r104 = r100.getIconColor();
            if (r104 != null) goto L11;
        L17:
            r102 = r100.getTextColor();
        L18:
            if (r102 == null) goto L21;
            this.f209447c.setImageTintList(ColorStateList.valueOf(BaseTagSize.LARGE.closeIconTint(ColorUtils.h(r102))));
            return;
        L21:
            return;
        L11:
            if (r104.length() <= 0) goto L13;
            boolean r105 = true;
        L14:
            if (r105 == false) goto L16;
            r102 = r104;
        L16:
            if (r102 != null) goto L18;
        L13:
            r105 = false;
            goto L14
        L5:
            r103 = null;
            goto L6
        }

        public PreviewViewHolderV2(View r100, Function0<? extends a> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "actionListenerProvider");
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$V2;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter;", "<init>", "()V", "itemLayoutRes", "", "getItemLayoutRes", "()I", "createViewHolder", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/select/PreviewItemAdapter$PreviewViewHolder;", "itemView", "Landroid/view/View;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class V2 extends PreviewItemAdapter {
        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.PreviewItemAdapter
        public final int z2() {
            return R.layout.select_item_preview_layout_v2;
        }

        public V2() {
        }

        @Override // com.bytedance.ee.bear.bitable.celleditor.editor.select.PreviewItemAdapter
        public final PreviewViewHolder y2(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            return new PreviewViewHolderV2(r100, new PreviewItemAdapter$V2$createViewHolder$1(this));
        }
    }

    public interface a {
        void a(String r100);
    }

    public int z2() {
        return R.layout.select_item_preview_layout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f209442a).size();
    }

    public PreviewItemAdapter() {
        this.f209442a = new ArrayList();
        this.f209443b = new LinkedHashMap();
    }

    public PreviewViewHolder y2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        return new PreviewViewHolder(r100, new PreviewItemAdapter$createViewHolder$1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PreviewViewHolder r102 = (PreviewViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = (String) ListProtector.get(this.f209442a, r101);
        SelectEditorModel.IEditorOption r104 = (SelectEditorModel.IEditorOption) ((LinkedHashMap) this.f209443b).get(r103);
        if (r104 == null) goto L5;
        r102.f209446b.setData(r104.toOptionEntity());
        r102.U3(r104);
        r102.itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.celleditor.editor.select.a(r102, r104));
        return;
    L5:
        r102.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(z2(), r100, false);
        Intrinsics.checkNotNull(r102);
        return y2(r102);
    }
}
