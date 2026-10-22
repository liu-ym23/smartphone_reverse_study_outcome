package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class z0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f233094a;

    public z0(OfficeBitableApplyPermissionFragment r100) {
        this.f233094a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = ((SimpleRequestResult) r100).getCode();
        OfficeBitableApplyPermissionFragment.U90(this.f233094a, r101);
        if (r101 != 0) goto L7;
        SpaceEditText r102 = this.f233094a.f232944k;
        if (r102 == null) goto L7;
        r102.setText("");
    L7:
        this.f233094a.setLoading(false);
    }
}
