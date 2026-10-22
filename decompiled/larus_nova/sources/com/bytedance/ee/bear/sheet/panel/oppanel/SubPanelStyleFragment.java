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
import com.bytedance.ee.bear.sheet.borderline.BorderLineFragment;
import com.bytedance.ee.bear.sheet.borderline.BorderLineViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorFragment;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorViewModel;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class SubPanelStyleFragment extends BaseSubPanelFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f238207o = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BorderLineViewModel f238208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SheetSelectColorViewModel f238209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OperationListAdapter f238210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f238211n;

    public class a implements BorderLineViewModel.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubPanelStyleFragment f238212a;

        public a(SubPanelStyleFragment r100) {
            this.f238212a = r100;
        }

        @Override // com.bytedance.ee.bear.sheet.borderline.BorderLineViewModel.a
        public final void a(JSONObject r100) {
            this.f238212a.f238130h.clickItem("borderLine", r100);
        }
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return SubPanelEnum.style.name();
    }

    public SubPanelStyleFragment() {
        this.f238210m = new OperationListAdapter();
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.BaseSubPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        SheetSelectColorViewModel r100 = this.f238209l;
        if (r100 == null) goto L5;
        r100.setCallback(null);
    L5:
        BorderLineViewModel r101 = this.f238208k;
        if (r101 == null) goto L9;
        r101.setCallback(null);
        return;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void U90(SheetItem r100) {
        super.U90(r100);
        String r101 = r100.getId();
        if (OperationEnum.borderLine.name().equals(r101) == false) goto L10;
        if (r100.getList() != null) goto L7;
        return;
    L7:
        if (r100.getList().length <= 0) goto L16;
        this.f238208k.getBorderLineData().setValue(new BorderLineData(r101, r100.getTitle(), r100.getList()[0]));
        return;
    L16:
        return;
    L10:
        if (OperationEnum.foreColor.name().equals(r101) == false) goto L12;
    L13:
        this.f238209l.getSelectColorData(r101).setValue(new SheetSelectColorData(r100.getTitle(), r100.getValue(), r100.getList()));
        return;
    L12:
        if (OperationEnum.backColor.name().equals(r101) == true) goto L13;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final boolean W90(String r100) {
        if (OperationEnum.borderLine.name().equals(r100) == false) goto L7;
        this.f238130h.openChildFragment(BorderLineFragment.class);
        return true;
    L7:
        if (OperationEnum.foreColor.name().equals(r100) == false) goto L9;
    L13:
        this.f238211n = r100;
        Bundle r101 = new Bundle();
        r101.putString("id", r100);
        this.f238130h.openChildFragment(SheetSelectColorFragment.class, r101);
        return true;
    L9:
        if (OperationEnum.backColor.name().equals(r100) == true) goto L13;
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
        this.f238210m.y2((SheetItem[]) r101.toArray(r105));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.oppanel.BaseSubPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        BorderLineViewModel r101 = (BorderLineViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, BorderLineViewModel.class);
        this.f238208k = r101;
        r101.setCallback(new a(this));
        SheetSelectColorViewModel r102 = (SheetSelectColorViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, SheetSelectColorViewModel.class);
        this.f238209l = r102;
        r102.setCallback(new k0(this));
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void ca0(String r100, String r101) {
        if (OperationEnum.borderLine.name().equals(r100) == false) goto L8;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        this.f238130h.clickItem("borderLineEnter", r101);
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
        if (OperationEnum.foreColor.name().equals(r100) == false) goto L13;
        if (TextUtils.isEmpty(r101) == false) goto L13;
        this.f238130h.clickItem("foreColorBar", r101);
    L13:
        if (OperationEnum.backColor.name().equals(r100) == true) goto L15;
    L17:
        this.f238130h.clickItem(r100, r101);
        goto L19
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        this.f238130h.clickItem("backColorBar", r101);
        goto L19
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.style_list);
        OperationListAdapter r103 = new OperationListAdapter();
        this.f238210m = r103;
        r103.f238200c = new i0(this);
        r103.f238199b = new j0(this);
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r102.setAdapter(this.f238210m);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_oppanel_style_fragment, r101, false);
    }
}
