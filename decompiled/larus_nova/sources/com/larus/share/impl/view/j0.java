package com.larus.share.impl.view;

import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes31.dex */
public final class j0 implements IShareDoubaoForwardService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Long> f368844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<kw9.a> f368845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tx9.v0.b f368846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h0 f368847d;

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void a(kw9.a r110) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("doubao to lark forward attempt, entry=direct_contact, stage=result, success=true, messageCount=");
        r101.append(this.f368844a.size());
        r101.append(", targetCount=");
        r101.append(this.f368845b.size());
        r101.append(", hasTargetInfo=");
        if (r110 == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r100.i("SharePanelView", r101.toString());
        ConcurrentHashMap<String, tx9.v0.c> r103 = tx9.v0.f547891a;
        tx9.v0.b r104 = this.f368846c;
        h0 r105 = this.f368847d;
        List<kw9.a> r106 = this.f368845b;
        r105.getClass();
        tx9.v0.j(r104, true, h0.j(r106), null, null, 24);
        h0.q(this.f368847d, true, r110, 2);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void onFailure(Integer r100, String r101) {
        FLogger.f375446a.e("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=result, success=false, reason=host_forward_failed, messageCount=" + this.f368844a.size() + ", targetCount=" + this.f368845b.size() + ", errorCode=" + r100 + ", errorMessage=" + r101);
        ConcurrentHashMap<String, tx9.v0.c> r102 = tx9.v0.f547891a;
        tx9.v0.b r103 = this.f368846c;
        h0 r104 = this.f368847d;
        List<kw9.a> r105 = this.f368845b;
        r104.getClass();
        List r106 = h0.j(r105);
        if (r100 == null) goto L5;
        String r107 = r100.toString();
    L6:
        tx9.v0.i(r103, false, r106, r107, r101);
        h0.q(this.f368847d, false, null, 4);
        return;
    L5:
        r107 = null;
        goto L6
    }

    public j0(List<Long> r100, List<kw9.a> r101, tx9.v0.b r102, h0 r103) {
        this.f368844a = r100;
        this.f368845b = r101;
        this.f368846c = r102;
        this.f368847d = r103;
    }
}
