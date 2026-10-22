package com.bytedance.ee.bear.bitable.itemview.record.menu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f214165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f214166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f214167c;

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.e
    public final String a() {
        return this.f214167c;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.e
    public final String getBaseId() {
        return this.f214165a;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.e
    public final String getTableId() {
        return this.f214166b;
    }

    public f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "baseId");
        Intrinsics.checkNotNullParameter(r101, "tableId");
        this.f214165a = r100;
        this.f214166b = r101;
        this.f214167c = r102;
    }
}
