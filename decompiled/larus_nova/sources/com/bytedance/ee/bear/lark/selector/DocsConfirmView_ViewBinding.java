package com.bytedance.ee.bear.lark.selector;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public class DocsConfirmView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DocsConfirmView f227478a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        DocsConfirmView r100 = this.f227478a;
        if (r100 == null) goto L7;
        this.f227478a = null;
        r100.mTitleBar = null;
        r100.mRecyclerView = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public DocsConfirmView_ViewBinding(DocsConfirmView r100, View r101) {
        this.f227478a = r100;
        r100.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.titlebar, "field 'mTitleBar'", CommonTitleBar.class);
        r100.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.content_rv, "field 'mRecyclerView'", RecyclerView.class);
    }
}
