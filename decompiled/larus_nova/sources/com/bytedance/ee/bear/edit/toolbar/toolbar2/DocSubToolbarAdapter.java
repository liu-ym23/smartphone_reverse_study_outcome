package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class DocSubToolbarAdapter extends BaseSubToolbarAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f226233e;

    public static class HighlightViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f226234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f226235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f226236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f226237d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HighlightViewHolder f226238a;

            public final void a() {
                Rect r100 = new Rect(this.f226238a.f226234a.getRight(), this.f226238a.f226234a.getTop(), this.f226238a.f226235b.getRight(), this.f226238a.f226235b.getBottom());
                this.f226238a.f226235b.setTouchDelegate(new TouchDelegate(r100, this.f226238a.f226237d));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(HighlightViewHolder r100) {
                this.f226238a = r100;
            }
        }

        public HighlightViewHolder(View r100) {
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_icon);
            this.f226234a = r101;
            ImageView r102 = (ImageView) r100.findViewById(R.id.allow);
            View r103 = r100.findViewById(R.id.parent);
            this.f226235b = r103;
            this.f226236c = r100.findViewById(R.id.selected);
            this.f226237d = r100.findViewById(R.id.openPanel);
            r103.post(new a(this));
            r101.bringToFront();
            r102.bringToFront();
        }
    }

    public interface a {
    }

    public DocSubToolbarAdapter(ItemV2[] r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f226205a != null) goto L5;
        return 0;
    L5:
        int r101 = super.getItemViewType(r100);
        if (r101 == 0) goto L8;
        return r101;
    L8:
        ItemV2 r102 = this.f226205a[r100];
        if (ItemIdV2.ConstId.separator.name().equals(r102.getId()) == false) goto L13;
        return 1;
    L13:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.name().equals(r102.id().name()) == false) goto L17;
        return 4;
    L17:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.name().equals(r102.id().name()) == false) goto L20;
        return 6;
    L20:
        return 0;
    }

    public static int B2(Highlight.ColorRgba r100, HighlightViewHolder r101) {
        int r102 = r101.itemView.getResources().getColor(R.color.lkui_transparent);
        if (r100 != null) goto L10;
        return r102;
    L10:
        return Color.argb((int) (r100.getA() * 255.0f), r100.getR(), r100.getG(), r100.getB());
    L7:
        th = move-exception;
        tt5.a.f("SelectColorV2Plugin", th, false);
        return r102;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        super.onBindViewHolder(r100, r101);
        if ((r100 instanceof BaseSubToolbarAdapter.DividerViewHolder) == false) goto L5;
        return;
    L5:
        if ((r100 instanceof BaseSubToolbarAdapter.CustomViewHolder) == true) goto L31;
        ItemV2[] r102 = this.f226205a;
        if (r102 == null) goto L37;
        final ItemV2 r103 = r102[r101];
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.name().equals(r103.getId()) == false) goto L23;
        r100.itemView.setOnClickListener(null);
        HighlightViewHolder r104 = (HighlightViewHolder) r100;
        r104.f226234a.setImageResource(i.a(r103.id()));
        String r105 = r103.getValue();
        if (TextUtils.isEmpty(r105) == false) goto L14;
        tt5.a.k("SelectColorV2Plugin", "bind highlight but value is empty");
        return;
    L14:
        Highlight.Selected r106 = Highlight.Selected.fromJson(r105);
        tt5.a.h("SelectColorV2Plugin", "item is selected " + r103.isSelected() + " highlight: =" + r106.toString());
        r104.f226236c.setSelected(r103.isSelected());
        r104.f226235b.setOnClickListener(new g(this, r103));
        r104.f226237d.setOnClickListener(new h(this, r103));
        Highlight.ColorItem r107 = r106.getBackground();
        if (r107 != null) goto L17;
        r104.f226234a.setBackground(null);
    L18:
        Highlight.ColorItem r108 = r106.getText();
        if (r108 != null) goto L21;
        ImageView r109 = r104.f226234a;
        r109.setColorFilter(r109.getResources().getColor(R.color.icon_n1));
        return;
    L21:
        r104.f226234a.setColorFilter(B2(r108.getValue(), r104));
        return;
    L17:
        int r110 = B2(r107.getValue(), r104);
        Drawable r111 = r104.f226234a.getResources().getDrawable(R.drawable.core_doc_toolbar_subitem_bg).mutate();
        DrawableCompat.setTint(r111, r110);
        r104.f226234a.setBackground(r111);
        goto L18
    L23:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.name().equals(r103.id().name()) == false) goto L28;
        BaseSubToolbarAdapter.TextColorViewHolder r112 = (BaseSubToolbarAdapter.TextColorViewHolder) r100;
        String r113 = r103.getValue();
        if (TextUtils.isEmpty(r113) == false) goto L27;
        tt5.a.k("SelectColorV2Plugin", "bind old highlight but value is empty");
        return;
    L27:
        tt5.a.h("SelectColorV2Plugin", "color: " + r113);
        r112.f226210a.setBackgroundColor(z2(r113, r112.itemView.getResources().getColor(R.color.lkui_N800)));
        r112.f226211b.setImageResource(R.drawable.ud_icon_style_fontcolor_outlined);
        return;
    L28:
        BaseSubToolbarAdapter.SubToolbarViewHolder r114 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r100;
        A2(r114, r103, i.a(r103.id()));
        r114.f226209a.setColorFilter(null);
        return;
    L37:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        BaseSubToolbarAdapter.CustomViewHolder r102 = null;
        an4.b r103 = null;
        r102 = null;
        if (r101 < 1000) goto L11;
        an4.g r104 = y2(r101 - 1000);
        if (r104 == null) goto L11;
        an4.b r105 = this.f226208d;
        if (r105 == null) goto L9;
        r103 = r105;
    L10:
        r102 = new BaseSubToolbarAdapter.CustomViewHolder(r104.b(r103, r100));
        goto L11
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContext");
    L11:
        if (r102 == null) goto L14;
        return r102;
    L14:
        if (r101 != 1) goto L18;
        return new BaseSubToolbarAdapter.DividerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_divider, r100, false));
    L18:
        if (r101 != 4) goto L22;
        return new BaseSubToolbarAdapter.TextColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_text_color, r100, false));
    L22:
        if (r101 != 6) goto L26;
        return new HighlightViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_highlight, r100, false));
    L26:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_horizontal, r100, false));
    }
}
