package com.bytedance.ee.bear.edit.component.toolbar2;

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

/* JADX INFO: loaded from: classes16.dex */
public class DocSubToolbarAdapter extends BaseSubToolbarAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f226095c;

    public static class HighlightViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f226096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f226097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f226098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f226099d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HighlightViewHolder f226100a;

            public final void a() {
                Rect r100 = new Rect(this.f226100a.f226096a.getRight(), this.f226100a.f226096a.getTop(), this.f226100a.f226097b.getRight(), this.f226100a.f226097b.getBottom());
                this.f226100a.f226097b.setTouchDelegate(new TouchDelegate(r100, this.f226100a.f226099d));
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
                this.f226100a = r100;
            }
        }

        public HighlightViewHolder(View r100) {
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_icon);
            this.f226096a = r101;
            ImageView r102 = (ImageView) r100.findViewById(R.id.allow);
            View r103 = r100.findViewById(R.id.parent);
            this.f226097b = r103;
            this.f226098c = r100.findViewById(R.id.selected);
            this.f226099d = r100.findViewById(R.id.openPanel);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        ItemV2[] r101 = this.f226050a;
        if (r101 != null) goto L5;
        return 0;
    L5:
        ItemV2 r102 = r101[r100];
        if (ItemIdV2.ConstId.separator.name().equals(r102.getId()) == false) goto L10;
        return 1;
    L10:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.name().equals(r102.id().name()) == false) goto L14;
        return 4;
    L14:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.name().equals(r102.id().name()) == false) goto L17;
        return 6;
    L17:
        return 0;
    }

    public static int A2(Highlight.ColorRgba r100, HighlightViewHolder r101) {
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

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        super.onBindViewHolder(r100, r101);
        if ((r100 instanceof BaseSubToolbarAdapter.DividerViewHolder) == true) goto L28;
        ItemV2[] r102 = this.f226050a;
        if (r102 == null) goto L34;
        final ItemV2 r103 = r102[r101];
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.name().equals(r103.getId()) == false) goto L21;
        r100.itemView.setOnClickListener(null);
        HighlightViewHolder r104 = (HighlightViewHolder) r100;
        r104.f226096a.setImageResource(w.a(r103.id()));
        String r105 = r103.getValue();
        if (TextUtils.isEmpty(r105) == false) goto L12;
        tt5.a.k("SelectColorV2Plugin", "bind highlight but value is empty");
        return;
    L12:
        Highlight.Selected r106 = Highlight.Selected.fromJson(r105);
        tt5.a.h("SelectColorV2Plugin", "item is selected " + r103.isSelected() + " highlight: =" + r106.toString());
        r104.f226098c.setSelected(r103.isSelected());
        r104.f226097b.setOnClickListener(new u(this, r103));
        r104.f226099d.setOnClickListener(new v(this, r103));
        Highlight.ColorItem r107 = r106.getBackground();
        if (r107 != null) goto L15;
        r104.f226096a.setBackground(null);
    L16:
        Highlight.ColorItem r108 = r106.getText();
        if (r108 != null) goto L19;
        ImageView r109 = r104.f226096a;
        r109.setColorFilter(r109.getResources().getColor(R.color.icon_n1));
        return;
    L19:
        r104.f226096a.setColorFilter(A2(r108.getValue(), r104));
        return;
    L15:
        int r110 = A2(r107.getValue(), r104);
        Drawable r111 = r104.f226096a.getResources().getDrawable(R.drawable.doc_toolbar_subitem_bg).mutate();
        DrawableCompat.setTint(r111, r110);
        r104.f226096a.setBackground(r111);
        goto L16
    L21:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.name().equals(r103.id().name()) == false) goto L26;
        BaseSubToolbarAdapter.TextColorViewHolder r112 = (BaseSubToolbarAdapter.TextColorViewHolder) r100;
        String r113 = r103.getValue();
        if (TextUtils.isEmpty(r113) == false) goto L25;
        tt5.a.k("SelectColorV2Plugin", "bind old highlight but value is empty");
        return;
    L25:
        tt5.a.h("SelectColorV2Plugin", "color: " + r113);
        r112.f226053a.setBackgroundColor(y2(r113, r112.itemView.getResources().getColor(R.color.lkui_N800)));
        r112.f226054b.setImageResource(R.drawable.ud_icon_style_fontcolor_outlined);
        return;
    L26:
        BaseSubToolbarAdapter.SubToolbarViewHolder r114 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r100;
        BaseSubToolbarAdapter.z2(r114, r103, w.a(r103.id()));
        r114.f226052a.setColorFilter(null);
        return;
    L34:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 1) goto L7;
        return new BaseSubToolbarAdapter.DividerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_sub_toolbar_item_divider, r100, false));
    L7:
        if (r101 != 4) goto L11;
        return new BaseSubToolbarAdapter.TextColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_sub_toolbar_item_text_color, r100, false));
    L11:
        if (r101 != 6) goto L15;
        return new HighlightViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_sub_toolbar_item_highlight, r100, false));
    L15:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_sub_toolbar_item_horizontal, r100, false));
    }
}
