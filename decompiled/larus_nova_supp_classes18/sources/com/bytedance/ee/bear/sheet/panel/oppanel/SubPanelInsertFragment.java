package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SubPanelInsertFragment extends BaseSubPanelFragment {
    public static final /* synthetic */ int m = 0;
    public OperationListAdapter k;
    public View l;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return SubPanelEnum.insert.name();
    }

    public SubPanelInsertFragment() {
        this.k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r5) {
        boolean r1 = false;
        if (OperationEnum.uploadImage.name().equals(r5) == true) goto L5;
    L11:
        return false;
    L5:
        if (aa0(r5) == true) goto L11;
        Bundle r6 = new Bundle();
        if (com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class).getOpenSource() == DocsOpenSource.vc) goto L9;
        r1 = true;
    L9:
        r6.putBoolean("EnableExternalSelect", r1);
        r6.putBoolean("is_from_sheet_insert_panel", true);
        this.h.openSelectImageFragment(r6, new f0(), this.l.getHeight());
        return true;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ga0(SheetItem[] r2) {
        this.k.y2(r2);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.BaseSubPanelFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        RecyclerView r6 = r4.findViewById(2131375438);
        OperationListAdapter r7 = new OperationListAdapter();
        this.k = r7;
        r7.c = new d0(this);
        r7.b = new e0(this);
        r6.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r6.setAdapter(this.k);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131564571, r3, false);
        this.l = r5;
        return r5;
    }
}
