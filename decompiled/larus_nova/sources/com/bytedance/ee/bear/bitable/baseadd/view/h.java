package com.bytedance.ee.bear.bitable.baseadd.view;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.bitable.baseadd.FastAddErrorCode;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class h extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableFastAddTipsFragment f207043c;

    public h(BitableFastAddTipsFragment r100) {
        this.f207043c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        BitableFastAddTipsFragment.b r101 = this.f207043c.f207035r;
        if (r101 == null) goto L6;
        r101.X0();
    L6:
        if (TextUtils.equals(this.f207043c.f207022e, "no_add_access") == false) goto L13;
        BitableFastAddTipsFragment.b r102 = this.f207043c.f207035r;
        if (r102 == null) goto L46;
        BitableAnalytic r103 = r102.q0();
        if (r103 == null) goto L47;
        r103.x("back");
        return;
    L47:
        return;
    L46:
        return;
    L13:
        if (TextUtils.equals(this.f207043c.f207022e, "submit_timeout") == false) goto L19;
        BitableFastAddTipsFragment.b r104 = this.f207043c.f207035r;
        if (r104 == null) goto L49;
        BitableAnalytic r105 = r104.q0();
        if (r105 == null) goto L50;
        r105.h("back");
        return;
    L50:
        return;
    L49:
        return;
    L19:
        Integer r106 = this.f207043c.f207023f;
        int r107 = FastAddErrorCode.FAST_ADD_ERR_CODE_NO_ADD_ACCESS.getCode();
        if (r106 != null) goto L23;
    L24:
        Integer r108 = this.f207043c.f207023f;
        int r109 = FastAddErrorCode.FAST_ADD_ERR_CODE_NO_ADD_ACCESS_1.getCode();
        if (r108 != null) goto L28;
    L30:
        Integer r110 = this.f207043c.f207023f;
        int r111 = FastAddErrorCode.FAST_ADD_ERR_CODE_SUBMIT_TIMEOUT_OR_OTHER.getCode();
        if (r110 != null) goto L34;
        return;
    L34:
        if (r110.intValue() != r111) goto L52;
        BitableFastAddTipsFragment.b r112 = this.f207043c.f207035r;
        if (r112 == null) goto L53;
        BitableAnalytic r113 = r112.q0();
        if (r113 == null) goto L54;
        r113.h("back");
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L28:
        if (r108.intValue() != r109) goto L30;
    L40:
        BitableFastAddTipsFragment.b r114 = this.f207043c.f207035r;
        if (r114 == null) goto L56;
        BitableAnalytic r115 = r114.q0();
        if (r115 == null) goto L57;
        r115.x("back");
        return;
    L57:
        return;
    L56:
        return;
    L23:
        if (r106.intValue() == r107) goto L40;
        goto L24
    }
}
