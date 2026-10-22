package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.filter.FilterFragment;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.operation.FreezeFragment;
import com.bytedance.ee.bear.sheet.sort.SortFragment;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class SubPanelOperationFragment extends BaseSubPanelFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f238205l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OperationListAdapter f238206k;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return SubPanelEnum.operation.name();
    }

    public SubPanelOperationFragment() {
        this.f238206k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r100) {
        if (OperationEnum.freezeSheet.name().equals(r100) == false) goto L7;
        this.f238130h.openChildFragment(FreezeFragment.class);
        return true;
    L7:
        if (OperationEnum.filter.name().equals(r100) == false) goto L11;
        this.f238130h.openChildFragment(FilterFragment.class);
        return true;
    L11:
        if (TextUtils.equals(r100, OperationEnum.sort.name()) == false) goto L14;
        this.f238130h.openChildFragment(SortFragment.class);
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ga0(SheetItem[] r100) {
        super.ga0(r100);
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        SheetItem r104 = r100[r103];
        if (r104 == null) goto L9;
        if (X90(r104.getId()) != null) goto L9;
        r101.add(r104);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        SheetItem[] r105 = new SheetItem[r101.size()];
        this.f238206k.y2((SheetItem[]) r101.toArray(r105));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.operation_list);
        OperationListAdapter r103 = new OperationListAdapter();
        this.f238206k = r103;
        r103.f238200c = new g0(this);
        r103.f238199b = new h0(this);
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r102.setAdapter(this.f238206k);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_oppanel_operation_fragment, r101, false);
    }
}
