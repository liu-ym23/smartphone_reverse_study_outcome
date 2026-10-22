package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements com.bytedance.ee.bear.more.protocol3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f219643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f219644b;

    @Override // com.bytedance.ee.bear.more.protocol3.a
    public final View.OnClickListener a() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.a
    public final String b() {
        if (this.f219643a == true) goto L6;
        tt5.a.d("EditionListItemV2New2", "FG false");
    L6:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L9;
        tt5.a.d("EditionListItemV2New2", "net not work.");
        return this.f219644b.e(R.string.CreationMobile_Common_NoInternet);
    L9:
        return "";
    }

    @Override // com.bytedance.ee.bear.more.protocol3.a
    public final boolean isEnable() {
        if (this.f219643a == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == false) goto L7;
        return true;
    }

    public h(boolean r100, g r101) {
        this.f219643a = r100;
        this.f219644b = r101;
    }
}
