package com.bytedance.ee.bear.bitable.card.view.cell.progress;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import yp4.j;

/* JADX INFO: loaded from: classes15.dex */
public class ProgressItemsAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f207943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f207944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f207945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f207946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<NumberModel> f207947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f207948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Double f207949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Double f207950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FieldConfigMetaModel.CommonColor f207951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f207952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f207953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f207954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f207955m;

    public interface a {
        void a();
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f207956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UDProgress f207957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f207958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f207959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f207960e;

        public b(ProgressItemsAdapter r100, View r101) {
            super(r101);
            this.f207956a = r101;
            this.f207957b = (UDProgress) r101.findViewById(R.id.progress_bar);
            TextView r102 = (TextView) r101.findViewById(R.id.progress_text);
            this.f207958c = r102;
            if (r100.f207945c == false) goto L6;
            r102.setMaxWidth(n.d(100));
        L6:
            if (r100.f207944b == false) goto L8;
            this.f207960e = (TextView) r101.findViewById(R.id.progress_text_placeholder);
            return;
        L8:
            this.f207959d = r101.findViewById(R.id.unedit_placeholder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (((ArrayList) this.f207947e).size() != 0) goto L6;
        return 1;
    L6:
        return ((ArrayList) this.f207947e).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        if (this.f207944b == false) goto L5;
        ViewGroup.LayoutParams r103 = r102.f207956a.getLayoutParams();
        if (this.f207946d == false) goto L11;
        int r104 = -1;
    L12:
        r103.width = r104;
    L14:
        if (this.f207944b == true) goto L16;
    L18:
        int r105 = 0;
    L19:
        r102.f207958c.setVisibility(r105);
        TextView r106 = r102.f207960e;
        if (r106 == null) goto L24;
        if (r105 != 8) goto L23;
        r106.setVisibility(0);
        goto L24
    L23:
        r106.setVisibility(8);
    L24:
        String r107 = "";
        if (((ArrayList) this.f207947e).size() != 0) goto L35;
        r102.f207958c.setText("");
        r102.f207957b.setProgress(0);
        if (this.f207944b == true) goto L29;
    L34:
        r102.f207956a.setOnClickListener(new e(this));
        return;
    L29:
        if (this.f207946d == false) goto L34;
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r102.f207957b.getLayoutParams();
        if (r108 != null) goto L33;
        r108 = new LinearLayout.LayoutParams(-1, -2);
    L33:
        r108.width = -1;
        r102.f207957b.setLayoutParams(r108);
        goto L34
    L35:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r102.f207956a.getLayoutParams();
        if (r109 != null) goto L38;
        r109 = new ViewGroup.MarginLayoutParams(-1, -1);
    L38:
        if (r101 <= 0) goto L40;
        r109.topMargin = n.d(2);
    L41:
        r102.f207956a.setLayoutParams(r109);
        NumberModel r110 = (NumberModel) ListProtector.get(this.f207947e, r101);
        TextView r111 = r102.f207958c;
        if (r110 != null) goto L45;
    L51:
        r111.setText(r107);
        Double r112 = r110.getNumberValue();
        Double r113 = this.f207949g;
        Double r114 = this.f207950h;
        if (r112 == null) goto L62;
        if (r113 == null) goto L62;
        if (r114 == null) goto L62;
        BigDecimal r115 = BigDecimal.valueOf(r112.doubleValue());
        BigDecimal r116 = BigDecimal.valueOf(r113.doubleValue());
        BigDecimal r117 = BigDecimal.valueOf(r114.doubleValue());
        if (r115.compareTo(r116) <= 0) goto L62;
        if (r115.compareTo(r117) < 0) goto L61;
        double r118 = 1.0d;
    L63:
        double r119 = r118 * 100.0d;
        r102.f207957b.setProgress((int) r119);
        r102.f207957b.setIndicatorColor(j.c(r119, this.f207951i));
        r102.f207956a.setOnClickListener(new f(this, r110));
        return;
    L61:
        r118 = (r112.doubleValue() - r113.doubleValue()) / (r114.doubleValue() - r113.doubleValue());
    L62:
        r118 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L63
    L45:
        if (this.f207953k == false) goto L47;
    L50:
        r107 = r110.getFormatterValue();
        goto L51
    L47:
        if (TextUtils.isEmpty(r110.getFormatterValue()) == false) goto L50;
        r107 = j.e(this.f207948f, r110.getNumberValue().doubleValue());
        goto L51
    L40:
        r109.topMargin = n.d(0);
        goto L41
    L16:
        if (((ArrayList) this.f207947e).size() != 0) goto L18;
        r105 = 8;
        goto L19
    L11:
        r104 = -2;
        goto L12
    L5:
        if (this.f207952j == true) goto L7;
        r102.f207959d.setVisibility(0);
        goto L14
    L7:
        r102.f207959d.setVisibility(8);
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        LayoutInflater r102 = LayoutInflater.from(this.f207943a);
        if (this.f207944b == false) goto L5;
        int r103 = R.layout.bitable_page_cell_progress_item_inner_content;
    L7:
        return new b(this, r102.inflate(r103, r100, false));
    L5:
        r103 = R.layout.bitable_cell_progress_item_inner_content;
        goto L7
    }

    public ProgressItemsAdapter(Context r100, boolean r101, boolean r102) {
        this.f207947e = new ArrayList();
        this.f207952j = true;
        this.f207953k = false;
        Paint r103 = new Paint();
        this.f207955m = r103;
        this.f207943a = r100;
        this.f207944b = r101;
        this.f207945c = r102;
        if (r101 == false) goto L6;
        r103.setTextSize(n.d(16));
        return;
    }
}
