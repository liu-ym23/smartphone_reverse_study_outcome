package com.bytedance.ee.bear.document.toolbar;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseAttrSubToolbarCompatFragment extends BaseAttrSubToolbarFragment {
    @Override // com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment, com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment
    public View getContentView() {
        return n.b.f222348a.a(super.getContentView(), R.color.lkui_N00);
    }

    public BaseAttrSubToolbarCompatFragment() {
    }
}
