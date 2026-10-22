package com.bytedance.ee.bear.doc.toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarCompatFragment;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsDocTxtAttrFragment extends BaseAttrSubToolbarCompatFragment {
    public static final /* synthetic */ int m = 0;
    public DocToolbarPanelViewModel j;
    public final List<FrameLayout> k;
    public RectColorView l;

    public class a extends t {
        public final /* synthetic */ AbsDocTxtAttrFragment c;

        public a(AbsDocTxtAttrFragment r1) {
            this.c = r1;
        }

        public final void a(View r6) {
            AbsDocTxtAttrFragment r7 = this.c;
            int r0 = AbsDocTxtAttrFragment.m;
            r7.getClass();
            DocTxtAttrId r1 = DocTxtAttrId.highlight;
            Item r2 = r7.aa0(r1);
            if (r2 != null) goto L5;
            tt5.a.d("AbsDocTxtAttrFragment", "selectColor while color item invalid ");
            return;
        L5:
            tt5.a.h("AbsDocTxtAttrFragment", "highlight process value:" + r2.getValue());
            r7.j.processToolbarItemClick(r1, r2.getValue());
        }
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment
    public final int ca0() {
        return 2131560110;
    }

    public abstract DocToolbarPanelViewModel ea0(FragmentActivity r1);

    public AbsDocTxtAttrFragment() {
        this.k = new ArrayList(9);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarCompatFragment, com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public final View getContentView() {
        View r0 = super.getContentView();
        HorizontalScrollView r1 = (HorizontalScrollView) r0.findViewById(2131374275);
        int r3 = 1;
    L4:
        if (r3 > 9) goto L7;
        ((ArrayList) this.k).add((FrameLayout) r1.findViewWithTag("h" + r3));
        r3 = r3 + 1;
        goto L4
    L7:
        if (((ArrayList) this.k).size() != 9) goto L18;
        int r2 = n.d(8);
        int r4 = (int) ((((double) ((n.v() - r2) - n.d(0))) - (((double) n.d(1)) * 4.0d)) / 4.5d);
        int r6 = n.d(1);
        int r7 = 1;
    L10:
        if (r7 > 9) goto L18;
        FrameLayout r8 = (FrameLayout) ListProtector.get(this.k, r7 - 1);
        r8.setVisibility(0);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        r9.width = r4;
        if (r7 != 1) goto L14;
        r8.setBackgroundResource(2131233885);
        ((LinearLayout.LayoutParams) r9).setMarginEnd(r6);
    L17:
        r8.setLayoutParams(r9);
        r7 = r7 + 1;
        goto L10
    L14:
        if (r7 != 9) goto L16;
        r8.setBackgroundResource(2131233890);
        ((LinearLayout.LayoutParams) r9).setMarginEnd(0);
        goto L17
    L16:
        r8.setBackgroundResource(2131233889);
        ((LinearLayout.LayoutParams) r9).setMarginEnd(r6);
    L18:
        r0.findViewById(2131385766).setVisibility(8);
        this.l = (RectColorView) r0.findViewById(2131374344);
        r0.findViewById(2131385767).setOnClickListener(new a(this));
        return r0;
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment
    public final ItemId ba0() {
        return DocItemId.attribution;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment
    public final BaseToolbarPanelViewModel da0() {
        return this.j;
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.j = ea0(getActivity());
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment
    public final void Z90(Item[] r5, View r6) {
        super.Z90(r5, r6);
        Item r7 = aa0(DocTxtAttrId.highlight);
        if (r7 == null) goto L22;
        Highlight.Selected r8 = Highlight.Selected.fromJson(r7.getValue());
        if (getContext() != null) goto L7;
        return;
    L7:
        if (this.l != null) goto L9;
        getContentView();
    L9:
        if (r8 == null) goto L24;
        RectColorView r9 = this.l;
        Highlight.ColorItem r0 = r8.getBackground();
        Highlight.ColorItem r10 = r8.getText();
        if (r0 != null) goto L13;
        r9.b.setBackground(null);
    L16:
        if (r10 != null) goto L18;
        r9.c.setColorFilter(r9.getResources().getColor(2131103546));
        r9.c.getDrawable().setAlpha(255);
        return;
    L18:
        Highlight.ColorRgba r11 = r10.getValue();
        if (r11 == null) goto L26;
        r9.c.setColorFilter(r9.a(r11));
        r9.c.getDrawable().setAlpha((int) (r11.getA() * 255.0f));
        return;
    L26:
        return;
    L13:
        Drawable r2 = r9.getResources().getDrawable(2131233852).mutate();
        Highlight.ColorRgba r1 = r0.getValue();
        if (r1 == null) goto L16;
        DrawableCompat.setTint(r2, r9.a(r1));
        r2.setAlpha((int) (r1.getA() * 255.0f));
        r9.b.setBackground(r2);
        goto L16
    L24:
        return;
    }
}
