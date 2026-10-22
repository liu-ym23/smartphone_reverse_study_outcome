package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.sheet.borderline.BorderLineData;
import com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineFragment;
import com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.selectcolor.OfficeSheetSelectColorFragment;
import com.bytedance.ee.bear.sheet.selectcolor.OfficeSheetSelectColorViewModel;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSubPanelStyleFragment extends OfficeBaseSubPanelFragment {
    public static final /* synthetic */ int o = 0;
    public OfficeBorderLineViewModel k;
    public OfficeSheetSelectColorViewModel l;
    public OperationListAdapter m;
    public String n;

    public class a implements OfficeBorderLineViewModel.a {
        public final /* synthetic */ OfficeSubPanelStyleFragment a;

        public a(OfficeSubPanelStyleFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel.a
        public final void a(JSONObject r3) {
            this.a.h.clickItem("borderLine", r3);
        }
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return OfficeSubPanelEnum.style.name();
    }

    public OfficeSubPanelStyleFragment() {
        this.m = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.OfficeBaseSubPanelFragment
    public final void onDestroy() {
        super.onDestroy();
        OfficeSheetSelectColorViewModel r0 = this.l;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        OfficeBorderLineViewModel r1 = this.k;
        if (r1 == null) goto L9;
        r1.setCallback(null);
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void U90(SheetItem r6) {
        super.U90(r6);
        String r0 = r6.getId();
        if (TextUtils.equals(r0, OperationEnum.borderLine.name()) == false) goto L10;
        if (r6.getList() != null) goto L7;
        return;
    L7:
        if (r6.getList().length <= 0) goto L16;
        this.k.getBorderLineData().setValue(new BorderLineData(r0, r6.getTitle(), r6.getList()[0]));
        return;
    L16:
        return;
    L10:
        if (TextUtils.equals(r0, OperationEnum.foreColor.name()) == false) goto L12;
    L13:
        this.l.getSelectColorData(r0).setValue(new SheetSelectColorData(r6.getTitle(), r6.getValue(), r6.getList()));
        return;
    L12:
        if (TextUtils.equals(r0, OperationEnum.backColor.name()) == true) goto L13;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r4) {
        if (TextUtils.equals(r4, OperationEnum.borderLine.name()) == false) goto L7;
        this.h.openChildFragment(OfficeBorderLineFragment.class);
        return true;
    L7:
        if (TextUtils.equals(r4, OperationEnum.foreColor.name()) == false) goto L9;
    L13:
        this.n = r4;
        Bundle r0 = new Bundle();
        r0.putString(ResourceData.KEY_ID, r4);
        this.h.openChildFragment(OfficeSheetSelectColorFragment.class, r0);
        return true;
    L9:
        if (TextUtils.equals(r4, OperationEnum.backColor.name()) == true) goto L13;
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
        this.m.y2((SheetItem[]) r0.toArray(r7));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.OfficeBaseSubPanelFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        OfficeBorderLineViewModel r3 = (OfficeBorderLineViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeBorderLineViewModel.class);
        this.k = r3;
        r3.setCallback(new a(this));
        OfficeSheetSelectColorViewModel r4 = (OfficeSheetSelectColorViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeSheetSelectColorViewModel.class);
        this.l = r4;
        r4.setCallback(new c0(this));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ca0(String r3, String r4) {
        if (TextUtils.equals(r3, OperationEnum.borderLine.name()) == false) goto L8;
        if (TextUtils.isEmpty(r4) == false) goto L8;
        this.h.clickItem("borderLineEnter", r4);
    L19:
        if (ba0(r3) == true) goto L21;
        return;
    L21:
        if (W90(r3) == false) goto L25;
        V90();
        return;
    L25:
        return;
    L8:
        if (TextUtils.equals(r3, OperationEnum.foreColor.name()) == false) goto L13;
        if (TextUtils.isEmpty(r4) == false) goto L13;
        this.h.clickItem("foreColorBar", r4);
    L13:
        if (TextUtils.equals(r3, OperationEnum.backColor.name()) == true) goto L15;
    L17:
        this.h.clickItem(r3, r4);
        goto L19
    L15:
        if (TextUtils.isEmpty(r4) == false) goto L17;
        this.h.clickItem("backColorBar", r4);
        goto L19
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        RecyclerView r6 = r4.findViewById(2131387502);
        OperationListAdapter r7 = new OperationListAdapter();
        this.m = r7;
        r7.c = new a0(this);
        r7.b = new b0(this);
        r6.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r6.setAdapter(this.m);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564573, r3, false);
    }
}
