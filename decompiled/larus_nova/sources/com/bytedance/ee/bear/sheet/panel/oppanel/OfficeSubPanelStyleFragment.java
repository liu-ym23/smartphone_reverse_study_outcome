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
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeSubPanelStyleFragment extends OfficeBaseSubPanelFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f238191o = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OfficeBorderLineViewModel f238192k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OfficeSheetSelectColorViewModel f238193l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OperationListAdapter f238194m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f238195n;

    public class a implements OfficeBorderLineViewModel.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubPanelStyleFragment f238196a;

        public a(OfficeSubPanelStyleFragment r100) {
            this.f238196a = r100;
        }

        @Override // com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel.a
        public final void a(JSONObject r100) {
            this.f238196a.f238158h.clickItem("borderLine", r100);
        }
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return OfficeSubPanelEnum.style.name();
    }

    public OfficeSubPanelStyleFragment() {
        this.f238194m = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.OfficeBaseSubPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        OfficeSheetSelectColorViewModel r100 = this.f238193l;
        if (r100 == null) goto L5;
        r100.setCallback(null);
    L5:
        OfficeBorderLineViewModel r101 = this.f238192k;
        if (r101 == null) goto L9;
        r101.setCallback(null);
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void U90(SheetItem r100) {
        super.U90(r100);
        String r101 = r100.getId();
        if (TextUtils.equals(r101, OperationEnum.borderLine.name()) == false) goto L10;
        if (r100.getList() != null) goto L7;
        return;
    L7:
        if (r100.getList().length <= 0) goto L16;
        this.f238192k.getBorderLineData().setValue(new BorderLineData(r101, r100.getTitle(), r100.getList()[0]));
        return;
    L16:
        return;
    L10:
        if (TextUtils.equals(r101, OperationEnum.foreColor.name()) == false) goto L12;
    L13:
        this.f238193l.getSelectColorData(r101).setValue(new SheetSelectColorData(r100.getTitle(), r100.getValue(), r100.getList()));
        return;
    L12:
        if (TextUtils.equals(r101, OperationEnum.backColor.name()) == true) goto L13;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r100) {
        if (TextUtils.equals(r100, OperationEnum.borderLine.name()) == false) goto L7;
        this.f238158h.openChildFragment(OfficeBorderLineFragment.class);
        return true;
    L7:
        if (TextUtils.equals(r100, OperationEnum.foreColor.name()) == false) goto L9;
    L13:
        this.f238195n = r100;
        Bundle r101 = new Bundle();
        r101.putString("id", r100);
        this.f238158h.openChildFragment(OfficeSheetSelectColorFragment.class, r101);
        return true;
    L9:
        if (TextUtils.equals(r100, OperationEnum.backColor.name()) == true) goto L13;
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
        this.f238194m.y2((SheetItem[]) r101.toArray(r105));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.OfficeBaseSubPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        OfficeBorderLineViewModel r101 = (OfficeBorderLineViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeBorderLineViewModel.class);
        this.f238192k = r101;
        r101.setCallback(new a(this));
        OfficeSheetSelectColorViewModel r102 = (OfficeSheetSelectColorViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeSheetSelectColorViewModel.class);
        this.f238193l = r102;
        r102.setCallback(new c0(this));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ca0(String r100, String r101) {
        if (TextUtils.equals(r100, OperationEnum.borderLine.name()) == false) goto L8;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        this.f238158h.clickItem("borderLineEnter", r101);
    L19:
        if (ba0(r100) == true) goto L21;
        return;
    L21:
        if (W90(r100) == false) goto L25;
        V90();
        return;
    L25:
        return;
    L8:
        if (TextUtils.equals(r100, OperationEnum.foreColor.name()) == false) goto L13;
        if (TextUtils.isEmpty(r101) == false) goto L13;
        this.f238158h.clickItem("foreColorBar", r101);
    L13:
        if (TextUtils.equals(r100, OperationEnum.backColor.name()) == true) goto L15;
    L17:
        this.f238158h.clickItem(r100, r101);
        goto L19
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        this.f238158h.clickItem("backColorBar", r101);
        goto L19
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.style_list);
        OperationListAdapter r103 = new OperationListAdapter();
        this.f238194m = r103;
        r103.f238200c = new a0(this);
        r103.f238199b = new b0(this);
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r102.setAdapter(this.f238194m);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_oppanel_style_fragment, r101, false);
    }
}
