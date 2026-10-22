package com.larus.share.impl.view;

import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public final class k0 implements IShareDoubaoForwardService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<kw9.a> f368848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f368849b;

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void a(kw9.a r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("host file forward attempt, entry=direct_contact, stage=result, success=true, targetCount=");
        r102.append(this.f368848a.size());
        r102.append(", hasTargetInfo=");
        if (r100 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r101.i("SharePanelView", r102.toString());
        h0.q(this.f368849b, true, r100, 2);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public k0(List<kw9.a> r100, h0 r101) {
        this.f368848a = r100;
        this.f368849b = r101;
    }

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void onFailure(Integer r100, String r101) {
        FLogger.f375446a.e("SharePanelView", "host file forward attempt, entry=direct_contact, stage=result, success=false, targetCount=" + this.f368848a.size() + ", errorCode=" + r100);
        h0.q(this.f368849b, false, null, 4);
    }
}
