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
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Adapter;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import gy4.b;
import gy4.c;
import h18.d;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class HighlightPanel extends BaseBlockEditPanel {
    public static final /* synthetic */ int v = 0;
    public View o;
    public Highlight p;
    public SelectColorV2Adapter q;
    public SelectColorV2Adapter r;
    public GridLayoutManager s;
    public GridLayoutManager t;
    public TextView u;

    public class a extends t {
        public final /* synthetic */ SelectColorItemDivider c;
        public final /* synthetic */ SelectColorItemDivider d;
        public final /* synthetic */ HighlightPanel e;

        public final void a(View r4) {
            if (this.e.p == null) goto L6;
            SelectColorItemDivider r5 = this.c;
            Objects.requireNonNull(r5);
            r5.c = -1;
            SelectColorItemDivider r6 = this.d;
            Objects.requireNonNull(this.c);
            r6.c = -1;
            this.e.q.y2(null);
            this.e.r.y2(null);
            HighlightPanel r7 = this.e;
            r7.e.onClickColorMenuItem(null, null, r7.p.getClear(), this.e.p.getReset());
            return;
        }

        public a(HighlightPanel r1, SelectColorItemDivider r2, SelectColorItemDivider r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void c(BlockEditPanelMenusModel.BlockEditPanel r1) {
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public View getContentView() {
        View r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        View r1 = LayoutInflater.from(getContext()).inflate(2131563709, null);
        this.o = r1;
        r1.findViewById(2131388881).setVisibility(8);
        RecyclerView r2 = this.o.findViewById(2131388371);
        RecyclerView r3 = this.o.findViewById(2131363763);
        GridLayoutManager r4 = new GridLayoutManager(getContext(), 7);
        this.t = r4;
        r2.setLayoutManager(r4);
        GridLayoutManager r5 = new GridLayoutManager(getContext(), 7);
        this.s = r5;
        r3.setLayoutManager(r5);
        r2.setNestedScrollingEnabled(false);
        r3.setNestedScrollingEnabled(false);
        int r6 = d.d(getContext(), 2131168297);
        final SelectColorItemDivider r7 = new SelectColorItemDivider(getContext());
        r7.b = r6;
        r2.addItemDecoration(r7);
        final SelectColorItemDivider r8 = new SelectColorItemDivider(getContext());
        r8.b = r6;
        r3.addItemDecoration(r8);
        int r9 = d.d(getContext(), 2131168369);
        SelectColorV2Adapter r10 = new SelectColorV2Adapter("text", null, null, r9);
        this.q = r10;
        r2.setAdapter(r10);
        SelectColorV2Adapter r11 = new SelectColorV2Adapter(RectColorView.RectColorType.TYPE_BACKGROUND, null, null, r9);
        this.r = r11;
        r3.setAdapter(r11);
        SelectColorV2Adapter r12 = this.q;
        r12.f = new gy4.a(this);
        r12.g = new b(r7);
        SelectColorV2Adapter r13 = this.r;
        r13.f = new c(this);
        r13.g = new gy4.d(r8);
        TextView r14 = (TextView) this.o.findViewById(2131366928);
        this.u = r14;
        r14.setOnClickListener(new a(this, r7, r8));
        l.b(this.o, 2131100548);
        return this.o;
    }

    public HighlightPanel(Context r2) {
        this(r2, null);
    }

    public final void d(Highlight r6) {
        this.p = r6;
        if (r6 == null) goto L20;
        int r0 = r6.getTextColorSpanCount();
        int r1 = 7;
        if (r0 > 0) goto L7;
        r0 = 7;
    L7:
        int r2 = r6.getBackgroundSpanCount();
        if (r2 <= 0) goto L11;
        r1 = r2;
    L11:
        this.q.a = r0;
        this.r.a = r1;
        this.t.setSpanCount(r0);
        this.s.setSpanCount(r1);
        Highlight.Selected r3 = r6.getSelected();
        Highlight.ColorItem[] r4 = r6.getText();
        Highlight.ColorItem[] r5 = r6.getBackground();
        if (r3 == null) goto L14;
        this.q.z2(r4, r3.getText());
        this.r.z2(r5, r3.getBackground());
    L16:
        if (r6.getReset() == null) goto L18;
        this.u.setText(2131887136);
        return;
    L18:
        this.u.setText(2131887658);
        return;
    L14:
        this.q.z2(r4, null);
        this.r.z2(r5, null);
        goto L16
    }

    public HighlightPanel(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public HighlightPanel(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
