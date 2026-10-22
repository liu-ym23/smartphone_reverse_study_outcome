package com.ss.android.lark.locationmessage.ui.navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class NavigateView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavigateView f431354a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        NavigateView r100 = this.f431354a;
        if (r100 == null) goto L7;
        this.f431354a = null;
        r100.mIvBack = null;
        r100.mIvMore = null;
        r100.mContainerLayout = null;
        r100.mTvRequestPermission = null;
        r100.mIvLocatePosition = null;
        r100.mTvNavigateTitle = null;
        r100.mTvNavigateDesc = null;
        r100.mIvGoToNavigate = null;
        r100.mViewTitleBar = null;
        r100.mBottomLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public NavigateView_ViewBinding(NavigateView r100, View r101) {
        this.f431354a = r100;
        r100.mIvBack = (ImageView) Utils.findRequiredViewAsType(r101, R.id.message_location_iv_back, "field 'mIvBack'", ImageView.class);
        r100.mIvMore = (ImageView) Utils.findRequiredViewAsType(r101, R.id.message_location_iv_more, "field 'mIvMore'", ImageView.class);
        r100.mContainerLayout = (LinearLayout) Utils.findRequiredViewAsType(r101, R.id.location_ll_map_container, "field 'mContainerLayout'", LinearLayout.class);
        r100.mTvRequestPermission = (TextView) Utils.findRequiredViewAsType(r101, R.id.tv_request_permission, "field 'mTvRequestPermission'", TextView.class);
        r100.mIvLocatePosition = (ImageView) Utils.findRequiredViewAsType(r101, R.id.location_iv_locate_position, "field 'mIvLocatePosition'", ImageView.class);
        r100.mTvNavigateTitle = (TextView) Utils.findRequiredViewAsType(r101, R.id.location_tv_navigate_title, "field 'mTvNavigateTitle'", TextView.class);
        r100.mTvNavigateDesc = (TextView) Utils.findRequiredViewAsType(r101, R.id.location_tv_navigate_desc, "field 'mTvNavigateDesc'", TextView.class);
        r100.mIvGoToNavigate = (ImageView) Utils.findRequiredViewAsType(r101, R.id.location_iv_go_to_navigate, "field 'mIvGoToNavigate'", ImageView.class);
        r100.mViewTitleBar = Utils.findRequiredView(r101, R.id.message_location_title_bar, "field 'mViewTitleBar'");
        r100.mBottomLayout = Utils.findRequiredView(r101, R.id.location_message_bottom_layout, "field 'mBottomLayout'");
    }
}
