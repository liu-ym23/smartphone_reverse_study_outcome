package com.ss.android.lark.contact.impl.group.join;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class MyJoinGroupView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MyJoinGroupView f419490a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        MyJoinGroupView r100 = this.f419490a;
        if (r100 == null) goto L7;
        this.f419490a = null;
        r100.mPtrFrame = null;
        r100.mMyJoinGroupRV = null;
        r100.mEmptyLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public MyJoinGroupView_ViewBinding(MyJoinGroupView r100, View r101) {
        this.f419490a = r100;
        r100.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r101, R.id.my_group_ptr_layout, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r100.mMyJoinGroupRV = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.my_group_rv, "field 'mMyJoinGroupRV'", RecyclerView.class);
        r100.mEmptyLayout = Utils.findRequiredView(r101, R.id.empty_layout, "field 'mEmptyLayout'");
    }
}
