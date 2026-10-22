package com.ss.android.lark.contact.impl.group.manage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class MyManageGroupView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MyManageGroupView f419512a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        MyManageGroupView r100 = this.f419512a;
        if (r100 == null) goto L7;
        this.f419512a = null;
        r100.mPtrFrame = null;
        r100.mMyManageGroupRV = null;
        r100.mEmptyLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public MyManageGroupView_ViewBinding(MyManageGroupView r100, View r101) {
        this.f419512a = r100;
        r100.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r101, R.id.my_group_ptr_layout, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r100.mMyManageGroupRV = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.my_group_rv, "field 'mMyManageGroupRV'", RecyclerView.class);
        r100.mEmptyLayout = Utils.findRequiredView(r101, R.id.empty_layout, "field 'mEmptyLayout'");
    }
}
