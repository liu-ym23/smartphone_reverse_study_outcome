package com.bytedance.ee.bear.lark.selector.base;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: classes16.dex */
public class SelectorView_ViewBinding implements Unbinder {
    @Override // butterknife.Unbinder
    public final void unbind() {
        throw new IllegalStateException("Bindings already cleared.");
    }

    public SelectorView_ViewBinding(SelectorView r100, View r101) {
        r100.f227495a = (LinearLayout) Utils.findRequiredViewAsType(r101, R.id.search_bar, "field 'mSearchBar'", LinearLayout.class);
        r100.f227496b = (SpaceEditText) Utils.findRequiredViewAsType(r101, R.id.search_et, "field 'mSearchEt'", SpaceEditText.class);
        r100.f227497c = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r101, R.id.inbox_ptr_layout, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r100.f227498d = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.search_result_rv, "field 'mSearchResultRV'", RecyclerView.class);
        r100.f227499e = Utils.findRequiredView(r101, R.id.load_empty, "field 'mLoadEmptyView'");
        r100.f227500f = (TextView) Utils.findRequiredViewAsType(r101, R.id.text_empty_tip, "field 'mSearchEmptyHintTV'", TextView.class);
        r100.f227501g = Utils.findRequiredView(r101, R.id.load_fail, "field 'mLoadFailView'");
        r100.f227502h = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.titlebar, "field 'mTitleBar'", CommonTitleBar.class);
        r100.f227503i = (TextView) Utils.findRequiredViewAsType(r101, R.id.select_count, "field 'mSelectCountTV'", TextView.class);
        r100.f227504j = (RelativeLayout) Utils.findRequiredViewAsType(r101, R.id.show_bottom, "field 'mBottomSelectActionRL'", RelativeLayout.class);
        r100.f227505k = (Button) Utils.findRequiredViewAsType(r101, R.id.confirm, "field 'mConfirmBtn'", Button.class);
    }
}
