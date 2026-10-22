package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.filter.OfficeFilterFragment;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.operation.OfficeFreezeFragment;
import com.bytedance.ee.bear.sheet.sort.OfficeSortFragment;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeSubPanelOperationFragment extends OfficeBaseSubPanelFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f238189l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OperationListAdapter f238190k;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return OfficeSubPanelEnum.operation.name();
    }

    public OfficeSubPanelOperationFragment() {
        this.f238190k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r100) {
        if (TextUtils.equals(r100, OperationEnum.freezeSheet.name()) == false) goto L7;
        this.f238158h.openChildFragment(OfficeFreezeFragment.class);
        return true;
    L7:
        if (TextUtils.equals(r100, OperationEnum.filter.name()) == false) goto L11;
        this.f238158h.openChildFragment(OfficeFilterFragment.class);
        return true;
    L11:
        if (TextUtils.equals(r100, OperationEnum.sort.name()) == false) goto L14;
        this.f238158h.openChildFragment(OfficeSortFragment.class);
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
        this.f238190k.y2((SheetItem[]) r101.toArray(r105));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.operation_list);
        OperationListAdapter r103 = new OperationListAdapter();
        this.f238190k = r103;
        r103.f238200c = new y(this);
        r103.f238199b = new z(this);
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r102.setAdapter(this.f238190k);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_oppanel_operation_fragment, r101, false);
    }
}
