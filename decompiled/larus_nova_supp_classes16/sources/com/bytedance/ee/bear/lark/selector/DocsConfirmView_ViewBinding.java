package com.bytedance.ee.bear.lark.selector;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsConfirmView_ViewBinding implements Unbinder {
    public DocsConfirmView a;

    public final void unbind() {
        DocsConfirmView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTitleBar = null;
        r0.mRecyclerView = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public DocsConfirmView_ViewBinding(DocsConfirmView r4, View r5) {
        this.a = r4;
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131388928, "field 'mTitleBar'", CommonTitleBar.class);
        r4.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131367849, "field 'mRecyclerView'", RecyclerView.class);
    }
}
