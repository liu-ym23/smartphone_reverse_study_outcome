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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SubPanelInsertFragment extends BaseSubPanelFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f238202m = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OperationListAdapter f238203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f238204l;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return SubPanelEnum.insert.name();
    }

    public SubPanelInsertFragment() {
        this.f238203k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r100) {
        boolean r101 = false;
        if (OperationEnum.uploadImage.name().equals(r100) == true) goto L5;
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
        this.f238130h.openSelectImageFragment(r102, new f0(), this.f238204l.getHeight());
        return true;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ga0(SheetItem[] r100) {
        this.f238203k.y2(r100);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.BaseSubPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.insert_list);
        OperationListAdapter r103 = new OperationListAdapter();
        this.f238203k = r103;
        r103.f238200c = new d0(this);
        r103.f238199b = new e0(this);
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r102.setAdapter(this.f238203k);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.sheet_oppanel_insert_fragment, r101, false);
        this.f238204l = r103;
        return r103;
    }
}
