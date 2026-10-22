package com.larus.office.base.share;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j implements OfficeSdkSharePanelProvider.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSdkSharePanelProvider f361146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f361147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ km5.a f361148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ShareItemModel f361149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ShareItemModel.a f361150e;

    @Override // com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel.a
    public final boolean a(Context r100, ShareItemModel r101, com.bytedance.ee.bear.share.g r102) {
        Intrinsics.checkNotNullParameter(r102, "shareData");
        OfficeSdkSharePanelProvider r103 = this.f361146a;
        String r104 = this.f361147b;
        km5.a r105 = this.f361148c;
        r103.getClass();
        OfficeSdkSharePanelProvider.k(r104, r105);
        OfficeSdkSharePanelProvider r106 = this.f361146a;
        String r107 = this.f361147b;
        String r108 = this.f361149d.getItemId();
        r106.getClass();
        OfficeSdkSharePanelProvider.l(r107, r108, true);
        ShareItemModel.a r109 = this.f361150e;
        if (r109 != null) goto L7;
        return false;
    L7:
        return r109.a(r100, r101, r102);
    }

    public j(OfficeSdkSharePanelProvider r100, String r101, km5.a r102, ShareItemModel r103, ShareItemModel.a r104) {
        this.f361146a = r100;
        this.f361147b = r101;
        this.f361148c = r102;
        this.f361149d = r103;
        this.f361150e = r104;
    }
}
