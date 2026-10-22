package com.bytedance.ee.bear.list.folder.complaint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes18.dex */
public class FolderComplaintSuccessFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f228073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f228074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f228075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f228076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f228077i;

    public FolderComplaintSuccessFragment() {
        this.f228077i = Boolean.FALSE;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("FolderComplaintSuccessFragment", "onDestroy()...");
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("FolderComplaintSuccessFragment", "onCreate()...");
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        this.f228073e = r101.getString("title");
        this.f228074f = r101.getString(SocialConstants.PARAM_APP_DESC);
        this.f228075g = r101.getBoolean(SocialConstants.PARAM_APP_DESC);
        this.f228077i = Boolean.valueOf(r101.getBoolean("file"));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        tt5.a.h("FolderComplaintSuccessFragment", "initMVP()...");
        ((TextView) this.f228076h.findViewById(R.id.list_folder_name)).setText(this.f228073e);
        TextView r102 = (TextView) this.f228076h.findViewById(R.id.list_folder_desc_title);
        TextView r103 = (TextView) this.f228076h.findViewById(R.id.list_folder_desc);
        if (this.f228075g == false) goto L5;
        r102.setVisibility(0);
        r103.setVisibility(0);
        r103.setText(this.f228074f);
    L6:
        SpaceEmptyState r104 = (SpaceEmptyState) this.f228076h.findViewById(R.id.list_complaint_state);
        if (this.f228077i.booleanValue() == false) goto L9;
        r104.setDesc(getContext().getText(R.string.LarkCCM_Appeal_SubmitToFS_Submitted_Descrip));
    L9:
        ((BaseTitleBar) this.f228076h.findViewById(R.id.list_folder_title_bar)).setLeftClickListener(new g(this));
        return;
    L5:
        r102.setVisibility(8);
        r103.setVisibility(8);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.list_folder_complaint_success_layout, r101, false);
        this.f228076h = r103;
        return r103;
    }
}
