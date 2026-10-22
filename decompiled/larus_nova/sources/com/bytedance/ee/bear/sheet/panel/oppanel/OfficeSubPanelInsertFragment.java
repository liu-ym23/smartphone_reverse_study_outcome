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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeSubPanelInsertFragment extends OfficeBaseSubPanelFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f238186m = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OperationListAdapter f238187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f238188l;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return OfficeSubPanelEnum.insert.name();
    }

    public OfficeSubPanelInsertFragment() {
        this.f238187k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r100) {
        boolean r101 = false;
        if (TextUtils.equals(r100, OperationEnum.uploadImage.name()) == true) goto L5;
    L11:
        return false;
    L5:
        if (aa0(r100) == true) goto L11;
        Bundle r102 = new Bundle();
        if (((DocViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class)).getOpenSource() == DocsOpenSource.f216966vc) goto L9;
        r101 = true;
    L9:
        r102.putBoolean("EnableExternalSelect", r101);
        r102.putBoolean("is_from_sheet_insert_panel", true);
        r102.putString("panel_title", this.f238158h.getPanelTitle(r100));
        this.f238158h.openSelectImageFragment(r102, new x(), this.f238188l.getHeight());
        return true;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ga0(SheetItem[] r100) {
        this.f238187k.y2(r100);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.OfficeBaseSubPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.insert_list);
        OperationListAdapter r103 = new OperationListAdapter();
        this.f238187k = r103;
        r103.f238200c = new v(this);
        r103.f238199b = new w(this);
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r102.setAdapter(this.f238187k);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.sheet_oppanel_insert_fragment, r101, false);
        this.f238188l = r103;
        return r103;
    }
}
