package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class PolicyDeniedView extends SpaceEmptyState {
    public final void a() {
        Context r100 = getContext();
        setImageRes(Integer.valueOf(R.drawable.ccm_empty_negative_load_failed));
        setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        setTitle(r100.getString(R.string.Drive_Drive_DisableAccessByPolicyTitle));
        setDesc(r100.getString(R.string.Drive_Drive_DisableAccessByPolicyText));
        setBackgroundColor(getResources().getColor(R.color.bg_body));
        setFitsSystemWindows(true);
    }

    public PolicyDeniedView(Context r100) {
        super(r100);
        a();
    }

    public PolicyDeniedView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public PolicyDeniedView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
