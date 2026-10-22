package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.os.Bundle;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class OfficeBaseSubPanelFragment extends BaseCellPanelFragment<SheetItem> {
    public OfficeFabPanelViewModel h;
    public long i;
    public long j;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void da0() {
    }

    public void onDestroy() {
        super.onDestroy();
        if (getUserVisibleHint() == false) goto L6;
        V90();
        return;
    }

    public OfficeBaseSubPanelFragment() {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final BaseCellPanelViewModel<SheetItem> Z90() {
        return this.h;
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.h = com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeFabPanelViewModel.class);
    }

    public final void setUserVisibleHint(boolean r6) {
        if (r6 == false) goto L4;
        this.i = System.currentTimeMillis();
    L6:
        if (isVisible() == false) goto L11;
        if (r6 == true) goto L11;
        if ((this.j - this.i) <= 200) goto L11;
        V90();
    L11:
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r6);
        return;
    L4:
        this.j = System.currentTimeMillis();
        goto L6
    }
}
