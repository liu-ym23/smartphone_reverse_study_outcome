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
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSubPanelOperationFragment extends OfficeBaseSubPanelFragment {
    public static final /* synthetic */ int l = 0;
    public OperationListAdapter k;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return OfficeSubPanelEnum.operation.name();
    }

    public OfficeSubPanelOperationFragment() {
        this.k = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r3) {
        if (TextUtils.equals(r3, OperationEnum.freezeSheet.name()) == false) goto L7;
        this.h.openChildFragment(OfficeFreezeFragment.class);
        return true;
    L7:
        if (TextUtils.equals(r3, OperationEnum.filter.name()) == false) goto L11;
        this.h.openChildFragment(OfficeFilterFragment.class);
        return true;
    L11:
        if (TextUtils.equals(r3, OperationEnum.sort.name()) == false) goto L14;
        this.h.openChildFragment(OfficeSortFragment.class);
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ga0(SheetItem[] r6) {
        super.ga0(r6);
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        SheetItem r3 = r6[r2];
        if (r3 == null) goto L9;
        if (X90(r3.getId()) != null) goto L9;
        r0.add(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        SheetItem[] r7 = new SheetItem[r0.size()];
        this.k.y2((SheetItem[]) r0.toArray(r7));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        RecyclerView r6 = r4.findViewById(2131381562);
        OperationListAdapter r7 = new OperationListAdapter();
        this.k = r7;
        r7.c = new y(this);
        r7.b = new z(this);
        r6.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r6.setAdapter(this.k);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564572, r3, false);
    }
}
