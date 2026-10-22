package com.bytedance.ee.bear.core.toolbar.selectcolor.impl;

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
    public int f217223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f217224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Highlight.ColorItem[] f217226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Highlight.ColorItem f217227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f217228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f217229g;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f217230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f217231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f217232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f217233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f217234e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f217235f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float[] f217236g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SelectColorV2Adapter f217237h;

        public a(SelectColorV2Adapter r110, int r111) {
            this.f217237h = r110;
            float r112 = r111;
            this.f217230a = new float[]{r112, r112, 0.0f, 0.0f, 0.0f, 0.0f, r112, r112};
            this.f217231b = new float[]{0.0f, 0.0f, r112, r112, r112, r112, 0.0f, 0.0f};
            this.f217232c = new float[]{r112, r112, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f217233d = new float[]{0.0f, 0.0f, r112, r112, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f217234e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r112, r112, 0.0f, 0.0f};
            this.f217235f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r112, r112};
            this.f217236g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
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
        public final RectColorView f217238a;

        public d(View r100) {
            super(r100);
            this.f217238a = (RectColorView) r100.findViewById(R.id.rectColorView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Highlight.ColorItem[] r100 = this.f217226d;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        d r112 = (d) r110;
        Highlight.ColorItem r100 = this.f217226d[r111];
        RectColorView r101 = r112.f217238a;
        String r102 = this.f217225c;
        a r103 = this.f217224b;
        int r104 = (int) Math.ceil((r103.f217237h.getItemCount() * 1.0f) / r103.f217237h.f217223a);
        if (r104 != 1) goto L10;
        if (r111 != 0) goto L7;
        float[] r105 = r103.f217230a;
    L22:
        r101.b(r102, r100, r105);
        r112.itemView.setOnClickListener(new com.bytedance.ee.bear.core.toolbar.selectcolor.impl.a(this, r100, r111));
        c r113 = this.f217229g;
        if (r113 == null) goto L34;
        Highlight.ColorItem r106 = this.f217227e;
        if (r106 != null) goto L29;
        r113.onItemSelected(-1);
        return;
    L29:
        if (TextUtils.equals(r106.getKey(), r100.getKey()) == false) goto L33;
        this.f217229g.onItemSelected(r111);
        return;
    L33:
        return;
    L34:
        return;
    L7:
        if ((r103.f217237h.getItemCount() - 1) != r111) goto L9;
        r105 = r103.f217231b;
        goto L22
    L9:
        r105 = r103.f217236g;
        goto L22
    L10:
        if (r111 != 0) goto L12;
        r105 = r103.f217232c;
        goto L22
    L12:
        SelectColorV2Adapter r107 = r103.f217237h;
        int r108 = r107.f217223a;
        if (r111 != (r108 - 1)) goto L16;
        r105 = r103.f217233d;
        goto L22
    L16:
        if (((r104 - 1) * r108) != r111) goto L19;
        r105 = r103.f217235f;
        goto L22
    L19:
        if ((r107.getItemCount() - 1) != r111) goto L21;
        r105 = r103.f217234e;
        goto L22
    L21:
        r105 = r103.f217236g;
        goto L22
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new d(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_new_select_color_item, r100, false));
    }

    public SelectColorV2Adapter(String r100, Highlight.ColorItem[] r101, Highlight.ColorItem r102, int r103) {
        this.f217226d = r101;
        this.f217225c = r100;
        this.f217227e = r102;
        this.f217223a = 7;
        this.f217224b = new a(this, r103);
    }
}
