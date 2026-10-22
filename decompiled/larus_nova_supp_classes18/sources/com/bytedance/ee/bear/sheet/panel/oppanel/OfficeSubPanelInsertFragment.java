package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSubPanelInsertFragment extends OfficeBaseSubPanelFragment {
    public static final /* synthetic */ int m = 0;
    public OperationListAdapter k;
    public View l;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return OfficeSubPanelEnum.insert.name();
    }

    public OfficeSubPanelInsertFragment() {
        this.k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r6) {
        boolean r1 = false;
        if (TextUtils.equals(r6, OperationEnum.uploadImage.name()) == true) goto L5;
    L11:
        return false;
    L5:
        if (aa0(r6) == true) goto L11;
        Bundle r0 = new Bundle();
        if (com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class).getOpenSource() == DocsOpenSource.vc) goto L9;
        r1 = true;
    L9:
        r0.putBoolean("EnableExternalSelect", r1);
        r0.putBoolean("is_from_sheet_insert_panel", true);
        r0.putString("panel_title", this.h.getPanelTitle(r6));
        this.h.openSelectImageFragment(r0, new x(), this.l.getHeight());
        return true;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ga0(SheetItem[] r2) {
        this.k.y2(r2);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.OfficeBaseSubPanelFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        RecyclerView r6 = r4.findViewById(2131375438);
        OperationListAdapter r7 = new OperationListAdapter();
        this.k = r7;
        r7.c = new v(this);
        r7.b = new w(this);
        r6.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r6.setAdapter(this.k);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131564571, r3, false);
        this.l = r5;
        return r5;
    }
}
