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
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectorView_ViewBinding implements Unbinder {
    public final void unbind() {
        throw new IllegalStateException("Bindings already cleared.");
    }

    public SelectorView_ViewBinding(SelectorView r4, View r5) {
        r4.a = (LinearLayout) Utils.findRequiredViewAsType(r5, 2131385326, "field 'mSearchBar'", LinearLayout.class);
        r4.b = (SpaceEditText) Utils.findRequiredViewAsType(r5, 2131385429, "field 'mSearchEt'", SpaceEditText.class);
        r4.c = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r5, 2131375202, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r4.d = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131385582, "field 'mSearchResultRV'", RecyclerView.class);
        r4.e = Utils.findRequiredView(r5, 2131378942, "field 'mLoadEmptyView'");
        r4.f = (TextView) Utils.findRequiredViewAsType(r5, 2131388429, "field 'mSearchEmptyHintTV'", TextView.class);
        r4.g = Utils.findRequiredView(r5, 2131378944, "field 'mLoadFailView'");
        r4.h = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388928, "field 'mTitleBar'", CommonTitleBar.class);
        r4.i = (TextView) Utils.findRequiredViewAsType(r5, 2131385788, "field 'mSelectCountTV'", TextView.class);
        r4.j = (RelativeLayout) Utils.findRequiredViewAsType(r5, 2131386382, "field 'mBottomSelectActionRL'", RelativeLayout.class);
        r4.k = (Button) Utils.findRequiredViewAsType(r5, 2131367639, "field 'mConfirmBtn'", Button.class);
    }
}
