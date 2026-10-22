package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.highlight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Adapter;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import gy4.b;
import gy4.c;
import h18.d;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class HighlightPanel extends BaseBlockEditPanel {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f217700v = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f217701o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Highlight f217702p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SelectColorV2Adapter f217703q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SelectColorV2Adapter f217704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public GridLayoutManager f217705s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GridLayoutManager f217706t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f217707u;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SelectColorItemDivider f217708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SelectColorItemDivider f217709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ HighlightPanel f217710e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f217710e.f217702p == null) goto L6;
            SelectColorItemDivider r101 = this.f217708c;
            Objects.requireNonNull(r101);
            r101.f217713c = -1;
            SelectColorItemDivider r102 = this.f217709d;
            Objects.requireNonNull(this.f217708c);
            r102.f217713c = -1;
            this.f217710e.f217703q.y2(null);
            this.f217710e.f217704r.y2(null);
            HighlightPanel r103 = this.f217710e;
            r103.f217674e.onClickColorMenuItem(null, null, r103.f217702p.getClear(), this.f217710e.f217702p.getReset());
            return;
        }

        public a(HighlightPanel r100, SelectColorItemDivider r101, SelectColorItemDivider r102) {
            this.f217710e = r100;
            this.f217708c = r101;
            this.f217709d = r102;
        }
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void c(BlockEditPanelMenusModel.BlockEditPanel r100) {
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public View getContentView() {
        View r100 = this.f217701o;
        if (r100 == null) goto L5;
        return r100;
    L5:
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.new_select_color_fragment, null);
        this.f217701o = r101;
        r101.findViewById(R.id.title_layout).setVisibility(8);
        RecyclerView r102 = (RecyclerView) this.f217701o.findViewById(R.id.textColorList);
        RecyclerView r103 = (RecyclerView) this.f217701o.findViewById(R.id.backColorList);
        GridLayoutManager r104 = new GridLayoutManager(getContext(), 7);
        this.f217706t = r104;
        r102.setLayoutManager(r104);
        GridLayoutManager r105 = new GridLayoutManager(getContext(), 7);
        this.f217705s = r105;
        r103.setLayoutManager(r105);
        r102.setNestedScrollingEnabled(false);
        r103.setNestedScrollingEnabled(false);
        int r106 = d.d(getContext(), R.dimen.space_kit_len_1);
        final SelectColorItemDivider r107 = new SelectColorItemDivider(getContext());
        r107.f217712b = r106;
        r102.addItemDecoration(r107);
        final SelectColorItemDivider r108 = new SelectColorItemDivider(getContext());
        r108.f217712b = r106;
        r103.addItemDecoration(r108);
        int r109 = d.d(getContext(), R.dimen.space_kit_len_8);
        SelectColorV2Adapter r110 = new SelectColorV2Adapter("text", null, null, r109);
        this.f217703q = r110;
        r102.setAdapter(r110);
        SelectColorV2Adapter r111 = new SelectColorV2Adapter("background", null, null, r109);
        this.f217704r = r111;
        r103.setAdapter(r111);
        SelectColorV2Adapter r112 = this.f217703q;
        r112.f222380f = new gy4.a(this);
        r112.f222381g = new b(r107);
        SelectColorV2Adapter r113 = this.f217704r;
        r113.f222380f = new c(this);
        r113.f222381g = new gy4.d(r108);
        TextView r114 = (TextView) this.f217701o.findViewById(R.id.clearBtn);
        this.f217707u = r114;
        r114.setOnClickListener(new a(this, r107, r108));
        l.b(this.f217701o, R.color.bg_body);
        return this.f217701o;
    }

    public HighlightPanel(Context r100) {
        this(r100, null);
    }

    public final void d(Highlight r100) {
        this.f217702p = r100;
        if (r100 == null) goto L20;
        int r101 = r100.getTextColorSpanCount();
        int r102 = 7;
        if (r101 > 0) goto L7;
        r101 = 7;
    L7:
        int r103 = r100.getBackgroundSpanCount();
        if (r103 <= 0) goto L11;
        r102 = r103;
    L11:
        this.f217703q.f222375a = r101;
        this.f217704r.f222375a = r102;
        this.f217706t.setSpanCount(r101);
        this.f217705s.setSpanCount(r102);
        Highlight.Selected r104 = r100.getSelected();
        Highlight.ColorItem[] r105 = r100.getText();
        Highlight.ColorItem[] r106 = r100.getBackground();
        if (r104 == null) goto L14;
        this.f217703q.z2(r105, r104.getText());
        this.f217704r.z2(r106, r104.getBackground());
    L16:
        if (r100.getReset() == null) goto L18;
        this.f217707u.setText(R.string.CreationMobile_Common_Reset);
        return;
    L18:
        this.f217707u.setText(R.string.Doc_Doc_ColorSelectClear);
        return;
    L14:
        this.f217703q.z2(r105, null);
        this.f217704r.z2(r106, null);
        goto L16
    }

    public HighlightPanel(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public HighlightPanel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
