package com.bytedance.ee.bear.middleground.docsdk.plugins.subpanel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarCompatFragment;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorViewModel;
import com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKItemId;
import com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKToolbarViewModel;
import com.bytedance.ee.bear.widgets.RoundColorView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocSDKTxtAttrSubPanelFragment extends BaseAttrSubToolbarCompatFragment {
    public static final /* synthetic */ int m = 0;
    public DocSDKToolbarViewModel j;
    public SelectColorViewModel k;
    public RoundColorView l;

    public class a extends t {
        public final /* synthetic */ DocSDKTxtAttrSubPanelFragment c;

        public a(DocSDKTxtAttrSubPanelFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r8) {
            final DocSDKTxtAttrSubPanelFragment r9 = this.c;
            int r0 = DocSDKTxtAttrSubPanelFragment.m;
            r9.getClass();
            DocSDKTxtAttrId r1 = DocSDKTxtAttrId.highlight;
            Item r2 = r9.aa0(r1);
            if (r2 != null) goto L5;
            tt5.a.d("DocSDKTxtAttrSubPanelFragment", "selectColor while color item invalid ");
            return;
        L5:
            r9.j.processToolbarItemClick(r1, r2.getValue());
            SelectColorViewModel r3 = r9.k;
            FragmentActivity r4 = r9.getActivity();
            String r5 = r9.getString(2131887697);
            if (TextUtils.equals(r2.getValue(), "#clear") == false) goto L8;
            String r6 = "#ffffff";
        L9:
            r3.selectColor(r4, new SelectColorViewModel.b(r5, r6, r2.getList()), new pf5.a(r9));
            return;
        L8:
            r6 = r2.getValue();
            goto L9
        }
    }

    public final int ca0() {
        return 2131560110;
    }

    public final View getContentView() {
        View r0 = super.getContentView();
        this.l = (RoundColorView) r0.findViewById(2131374343);
        r0.findViewById(2131385766).setOnClickListener(new a(this));
        return r0;
    }

    static {
    }

    public DocSDKTxtAttrSubPanelFragment() {
    }

    public final ItemId ba0() {
        return DocSDKItemId.attribution;
    }

    public final BaseToolbarPanelViewModel da0() {
        return this.j;
    }

    public final void ea0(String r3) {
        if (getContext() == null) goto L9;
        boolean r0 = TextUtils.equals(r3, "#clear");
        if (r0 == false) goto L7;
        r3 = "#ffffff";
    L7:
        this.l.setClear(r0);
        this.l.setColor(r3);
        this.k.updateSelectedColor(r3);
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment*/.onCreate(r3);
        FragmentActivity r4 = getActivity();
        this.j = ViewModelProviders.of(r4).get(DocSDKToolbarViewModel.class);
        this.k = ViewModelProviders.of(r4).get(SelectColorViewModel.class);
    }

    public final void Z90(Item[] r1, View r2) {
        super/*com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment*/.Z90(r1, r2);
        Item r3 = aa0(DocSDKTxtAttrId.highlight);
        if (r3 == null) goto L6;
        ea0(r3.getValue());
        return;
    }
}
