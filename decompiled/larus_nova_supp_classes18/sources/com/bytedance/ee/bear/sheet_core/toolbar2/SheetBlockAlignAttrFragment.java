package com.bytedance.ee.bear.sheet_core.toolbar2;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockToolbarV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockAlignAttrFragment extends BaseSubToolbarV2Fragment<SheetBlockToolbarV2> {
    public static final /* synthetic */ int v = 0;

    public final BaseToolbarV2PanelViewModel<SheetBlockToolbarV2> Z90() {
        return q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    public final BaseSubToolbarAdapter ca0() {
        return new SheetBlockAlignAttrAdapter(W90((SheetBlockToolbarV2) Z90().getToolbar().getValue()));
    }

    static {
    }

    public SheetBlockAlignAttrFragment() {
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        RecyclerView r4 = ((BaseSubToolbarV2Fragment) this).f;
        if (r4 == null) goto L7;
        if (r2 != 0) goto L8;
        r4.post(new rn5.a(this));
        return;
    L8:
        return;
    }
}
