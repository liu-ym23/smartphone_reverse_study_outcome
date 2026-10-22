package com.bytedance.ee.bear.bitable.itemview.record.menu;

import com.bytedance.ee.bear.bitable.card.view.page.RecordSubscribeStatus;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, RecordSubscribeStatus> f214168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f214169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f214170c;

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final void addOperationListener(sq4.b.a r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final void closeAutoSubscribe() {
        this.f214170c = true;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final boolean isShowInRecord() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final void removeOperationListener(sq4.b.a r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final BitableAnalytic bitableAnalytic() {
        return new BitableAnalytic(new kr4.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), new BearUrl(""), null));
    }

    public h() {
        this.f214168a = new HashMap();
        this.f214169b = new HashSet();
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final boolean getCloseAutoSubscribe() {
        return this.f214170c;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final boolean getRecordCloseAutoSubscribe(String r100) {
        return this.f214169b.contains(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final RecordSubscribeStatus getSubscribeStatus(String r100) {
        return this.f214168a.get(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final void setRecordCloseAutoSubscribe(String r100) {
        this.f214169b.add(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.g
    public final void setSubscribeStatus(String r100, RecordSubscribeStatus r101) {
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f214168a.put(r100, r101);
    }
}
