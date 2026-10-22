package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements com.bytedance.ee.bear.more.protocol3.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ g b;

    public final View.OnClickListener a() {
        return null;
    }

    public final String b() {
        if (this.a == true) goto L6;
        tt5.a.d("EditionListItemV2New2", "FG false");
    L6:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L9;
        tt5.a.d("EditionListItemV2New2", "net not work.");
        return this.b.e(2131887130);
    L9:
        return "";
    }

    public final boolean isEnable() {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L7;
        return true;
    }

    public h(boolean r1, g r2) {
        this.a = r1;
        this.b = r2;
    }
}
