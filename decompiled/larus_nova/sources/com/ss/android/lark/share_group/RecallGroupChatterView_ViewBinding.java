package com.ss.android.lark.share_group;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes38.dex */
public class RecallGroupChatterView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecallGroupChatterView f440519a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        RecallGroupChatterView r100 = this.f440519a;
        if (r100 == null) goto L7;
        this.f440519a = null;
        r100.mRecallChatterRV = null;
        r100.mRecallTitleBar = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public RecallGroupChatterView_ViewBinding(RecallGroupChatterView r100, View r101) {
        this.f440519a = r100;
        r100.mRecallChatterRV = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.recall_chatter_rv, "field 'mRecallChatterRV'", RecyclerView.class);
        r100.mRecallTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r101, R.id.recall_titlebar, "field 'mRecallTitleBar'", CommonTitleBar.class);
    }
}
