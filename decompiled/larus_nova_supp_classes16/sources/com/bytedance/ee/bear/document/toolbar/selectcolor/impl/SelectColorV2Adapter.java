package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorV2Adapter extends RecyclerView.Adapter<d> {
    public int a;
    public final a b;
    public final String c;
    public Highlight.ColorItem[] d;
    public Highlight.ColorItem e;
    public b f;
    public c g;

    public class a {
        public final float[] a;
        public final float[] b;
        public final float[] c;
        public final float[] d;
        public final float[] e;
        public final float[] f;
        public final float[] g;
        public final /* synthetic */ SelectColorV2Adapter h;

        public a(SelectColorV2Adapter r11, int r12) {
            this.h = r11;
            float r13 = r12;
            this.a = new float[]{r13, r13, 0.0f, 0.0f, 0.0f, 0.0f, r13, r13};
            this.b = new float[]{0.0f, 0.0f, r13, r13, r13, r13, 0.0f, 0.0f};
            this.c = new float[]{r13, r13, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.d = new float[]{0.0f, 0.0f, r13, r13, 0.0f, 0.0f, 0.0f, 0.0f};
            this.e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r13, r13, 0.0f, 0.0f};
            this.f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r13, r13};
            this.g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
    }

    public interface b {
        void a(Highlight.ColorItem r1);
    }

    public interface c {
        void onItemSelected(int r1);
    }

    public static class d extends RecyclerView.ViewHolder {
        public final RectColorView a;

        public d(View r2) {
            super(r2);
            this.a = (RectColorView) r2.findViewById(2131384061);
        }
    }

    public final int getItemCount() {
        Highlight.ColorItem[] r0 = this.d;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public final void y2(Highlight.ColorItem r1) {
        this.e = r1;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        d r12 = (d) r10;
        Highlight.ColorItem r0 = this.d[r11];
        RectColorView r1 = r12.a;
        String r2 = this.c;
        a r3 = this.b;
        int r4 = (int) Math.ceil((r3.h.getItemCount() * 1.0f) / r3.h.a);
        if (r4 != 1) goto L10;
        if (r11 != 0) goto L7;
        float[] r5 = r3.a;
    L22:
        r1.b(r2, r0, r5);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new com.bytedance.ee.bear.document.toolbar.selectcolor.impl.d(this, r0, r11));
        c r13 = this.g;
        if (r13 == null) goto L34;
        Highlight.ColorItem r6 = this.e;
        if (r6 != null) goto L29;
        r13.onItemSelected(-1);
        return;
    L29:
        if (TextUtils.equals(r6.getKey(), r0.getKey()) == false) goto L33;
        this.g.onItemSelected(r11);
        return;
    L33:
        return;
    L34:
        return;
    L7:
        if ((r3.h.getItemCount() - 1) != r11) goto L9;
        r5 = r3.b;
        goto L22
    L9:
        r5 = r3.g;
        goto L22
    L10:
        if (r11 != 0) goto L12;
        r5 = r3.c;
        goto L22
    L12:
        SelectColorV2Adapter r7 = r3.h;
        int r8 = r7.a;
        if (r11 != (r8 - 1)) goto L16;
        r5 = r3.d;
        goto L22
    L16:
        if (((r4 - 1) * r8) != r11) goto L19;
        r5 = r3.f;
        goto L22
    L19:
        if ((r7.getItemCount() - 1) != r11) goto L21;
        r5 = r3.e;
        goto L22
    L21:
        r5 = r3.g;
        goto L22
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new d(LayoutInflater.from(r3.getContext()).inflate(2131563710, r3, false));
    }

    public final void z2(Highlight.ColorItem[] r1, Highlight.ColorItem r2) {
        this.d = r1;
        this.e = r2;
        notifyDataSetChanged();
    }

    public SelectColorV2Adapter(String r1, Highlight.ColorItem[] r2, Highlight.ColorItem r3, int r4) {
        this.d = r2;
        this.c = r1;
        this.e = r3;
        this.a = 7;
        this.b = new a(this, r4);
    }
}
