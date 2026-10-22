package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorV2Adapter extends RecyclerView.Adapter<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f222375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f222376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f222377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Highlight.ColorItem[] f222378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Highlight.ColorItem f222379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f222380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f222381g;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f222382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f222383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f222384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f222385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f222386e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f222387f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float[] f222388g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SelectColorV2Adapter f222389h;

        public a(SelectColorV2Adapter r110, int r111) {
            this.f222389h = r110;
            float r112 = r111;
            this.f222382a = new float[]{r112, r112, 0.0f, 0.0f, 0.0f, 0.0f, r112, r112};
            this.f222383b = new float[]{0.0f, 0.0f, r112, r112, r112, r112, 0.0f, 0.0f};
            this.f222384c = new float[]{r112, r112, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f222385d = new float[]{0.0f, 0.0f, r112, r112, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f222386e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r112, r112, 0.0f, 0.0f};
            this.f222387f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r112, r112};
            this.f222388g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
    }

    public interface b {
        void a(Highlight.ColorItem r100);
    }

    public interface c {
        void onItemSelected(int r100);
    }

    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectColorView f222390a;

        public d(View r100) {
            super(r100);
            this.f222390a = (RectColorView) r100.findViewById(R.id.rectColorView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Highlight.ColorItem[] r100 = this.f222378d;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public final void y2(Highlight.ColorItem r100) {
        this.f222379e = r100;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        d r112 = (d) r110;
        Highlight.ColorItem r100 = this.f222378d[r111];
        RectColorView r101 = r112.f222390a;
        String r102 = this.f222377c;
        a r103 = this.f222376b;
        int r104 = (int) Math.ceil((r103.f222389h.getItemCount() * 1.0f) / r103.f222389h.f222375a);
        if (r104 != 1) goto L10;
        if (r111 != 0) goto L7;
        float[] r105 = r103.f222382a;
    L22:
        r101.b(r102, r100, r105);
        r112.itemView.setOnClickListener(new com.bytedance.ee.bear.document.toolbar.selectcolor.impl.d(this, r100, r111));
        c r113 = this.f222381g;
        if (r113 == null) goto L34;
        Highlight.ColorItem r106 = this.f222379e;
        if (r106 != null) goto L29;
        r113.onItemSelected(-1);
        return;
    L29:
        if (TextUtils.equals(r106.getKey(), r100.getKey()) == false) goto L33;
        this.f222381g.onItemSelected(r111);
        return;
    L33:
        return;
    L34:
        return;
    L7:
        if ((r103.f222389h.getItemCount() - 1) != r111) goto L9;
        r105 = r103.f222383b;
        goto L22
    L9:
        r105 = r103.f222388g;
        goto L22
    L10:
        if (r111 != 0) goto L12;
        r105 = r103.f222384c;
        goto L22
    L12:
        SelectColorV2Adapter r107 = r103.f222389h;
        int r108 = r107.f222375a;
        if (r111 != (r108 - 1)) goto L16;
        r105 = r103.f222385d;
        goto L22
    L16:
        if (((r104 - 1) * r108) != r111) goto L19;
        r105 = r103.f222387f;
        goto L22
    L19:
        if ((r107.getItemCount() - 1) != r111) goto L21;
        r105 = r103.f222386e;
        goto L22
    L21:
        r105 = r103.f222388g;
        goto L22
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new d(LayoutInflater.from(r100.getContext()).inflate(R.layout.new_select_color_item, r100, false));
    }

    public final void z2(Highlight.ColorItem[] r100, Highlight.ColorItem r101) {
        this.f222378d = r100;
        this.f222379e = r101;
        notifyDataSetChanged();
    }

    public SelectColorV2Adapter(String r100, Highlight.ColorItem[] r101, Highlight.ColorItem r102, int r103) {
        this.f222378d = r101;
        this.f222377c = r100;
        this.f222379e = r102;
        this.f222375a = 7;
        this.f222376b = new a(this, r103);
    }
}
