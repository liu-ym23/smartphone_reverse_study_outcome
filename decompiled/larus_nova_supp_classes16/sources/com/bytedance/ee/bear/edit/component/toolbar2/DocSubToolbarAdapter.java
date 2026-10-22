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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocSubToolbarAdapter extends BaseSubToolbarAdapter {
    public a c;

    public static class HighlightViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final View b;
        public final View c;
        public final View d;

        public class a implements Runnable {
            public final /* synthetic */ HighlightViewHolder a;

            public final void a() {
                Rect r0 = new Rect(this.a.a.getRight(), this.a.a.getTop(), this.a.b.getRight(), this.a.b.getBottom());
                this.a.b.setTouchDelegate(new TouchDelegate(r0, this.a.d));
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

            public a(HighlightViewHolder r1) {
                this.a = r1;
            }
        }

        public HighlightViewHolder(View r5) {
            super(r5);
            ImageView r0 = (ImageView) r5.findViewById(2131387565);
            this.a = r0;
            ImageView r1 = (ImageView) r5.findViewById(2131362518);
            View r2 = r5.findViewById(2131381925);
            this.b = r2;
            this.c = r5.findViewById(2131385824);
            this.d = r5.findViewById(2131381495);
            r2.post(new a(this));
            r0.bringToFront();
            r1.bringToFront();
        }
    }

    public interface a {
    }

    public DocSubToolbarAdapter(ItemV2[] r1) {
        super(r1);
    }

    public final int getItemViewType(int r4) {
        ItemV2[] r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        ItemV2 r5 = r0[r4];
        if (ItemIdV2.ConstId.separator.name().equals(r5.getId()) == false) goto L10;
        return 1;
    L10:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.name().equals(r5.id().name()) == false) goto L14;
        return 4;
    L14:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.name().equals(r5.id().name()) == false) goto L17;
        return 6;
    L17:
        return 0;
    }

    public static int A2(Highlight.ColorRgba r3, HighlightViewHolder r4) {
        int r5 = ((RecyclerView.ViewHolder) r4).itemView.getResources().getColor(2131103546);
        if (r3 != null) goto L10;
        return r5;
    L10:
        return Color.argb((int) (r3.getA() * 255.0f), r3.getR(), r3.getG(), r3.getB());
    L7:
        th = move-exception;
        tt5.a.f("SelectColorV2Plugin", th, false);
        return r5;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        super.onBindViewHolder(r6, r7);
        if ((r6 instanceof BaseSubToolbarAdapter.DividerViewHolder) == true) goto L28;
        ItemV2[] r0 = this.a;
        if (r0 == null) goto L34;
        final ItemV2 r8 = r0[r7];
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.highlight.name().equals(r8.getId()) == false) goto L21;
        r6.itemView.setOnClickListener(null);
        HighlightViewHolder r9 = (HighlightViewHolder) r6;
        r9.a.setImageResource(w.a(r8.id()));
        String r1 = r8.getValue();
        if (TextUtils.isEmpty(r1) == false) goto L12;
        tt5.a.k("SelectColorV2Plugin", "bind highlight but value is empty");
        return;
    L12:
        Highlight.Selected r2 = Highlight.Selected.fromJson(r1);
        tt5.a.h("SelectColorV2Plugin", "item is selected " + r8.isSelected() + " highlight: =" + r2.toString());
        r9.c.setSelected(r8.isSelected());
        r9.b.setOnClickListener(new u(this, r8));
        r9.d.setOnClickListener(new v(this, r8));
        Highlight.ColorItem r10 = r2.getBackground();
        if (r10 != null) goto L15;
        r9.a.setBackground(null);
    L16:
        Highlight.ColorItem r11 = r2.getText();
        if (r11 != null) goto L19;
        ImageView r12 = r9.a;
        r12.setColorFilter(r12.getResources().getColor(2131102418));
        return;
    L19:
        r9.a.setColorFilter(A2(r11.getValue(), r9));
        return;
    L15:
        int r13 = A2(r10.getValue(), r9);
        Drawable r3 = r9.a.getResources().getDrawable(2131233884).mutate();
        DrawableCompat.setTint(r3, r13);
        r9.a.setBackground(r3);
        goto L16
    L21:
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.name().equals(r8.id().name()) == false) goto L26;
        BaseSubToolbarAdapter.TextColorViewHolder r14 = (BaseSubToolbarAdapter.TextColorViewHolder) r6;
        String r16 = r8.getValue();
        if (TextUtils.isEmpty(r16) == false) goto L25;
        tt5.a.k("SelectColorV2Plugin", "bind old highlight but value is empty");
        return;
    L25:
        tt5.a.h("SelectColorV2Plugin", "color: " + r16);
        r14.a.setBackgroundColor(y2(r16, ((RecyclerView.ViewHolder) r14).itemView.getResources().getColor(2131103461)));
        r14.b.setImageResource(2131255837);
        return;
    L26:
        BaseSubToolbarAdapter.SubToolbarViewHolder r17 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r6;
        BaseSubToolbarAdapter.z2(r17, r8, w.a(r8.id()));
        r17.a.setColorFilter(null);
        return;
    L34:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        if (r5 != 1) goto L7;
        return new BaseSubToolbarAdapter.DividerViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560101, r4, false));
    L7:
        if (r5 != 4) goto L11;
        return new BaseSubToolbarAdapter.TextColorViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560104, r4, false));
    L11:
        if (r5 != 6) goto L15;
        return new HighlightViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560102, r4, false));
    L15:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560103, r4, false));
    }
}
