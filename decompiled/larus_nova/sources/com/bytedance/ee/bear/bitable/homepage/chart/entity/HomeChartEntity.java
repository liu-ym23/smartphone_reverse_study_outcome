package com.bytedance.ee.bear.bitable.homepage.chart.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rs4.d;
import y28.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0000H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0000H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomeChartEntity;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;", "Lcom/larksuite/framework/utils/diff/Diffable;", "<init>", "()V", "entity", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;)V", "initPosition", "", "getInitPosition", "()I", "setInitPosition", "(I)V", "isEditMode", "", "()Z", "setEditMode", "(Z)V", "isItemSame", "diffable", "isContentSame", "deepClone", "withChartData", "migrateFromOld", "", "old", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeChartEntity extends ChartEntity implements b<HomeChartEntity> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile transient int f212476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile transient boolean f212477d;

    public HomeChartEntity() {
    }

    public final int getInitPosition() {
        return this.f212476c;
    }

    public final boolean isEditMode() {
        return this.f212477d;
    }

    public HomeChartEntity(ChartEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        this();
        setBaseToken(r100.getBaseToken());
        setBaseName(r100.getBaseName());
        setBaseUrl(r100.getBaseUrl());
        setTemplate(r100.isTemplate());
        setDashboardToken(r100.getDashboardToken());
        setChartToken(r100.getChartToken());
        setChartType(r100.getChartType());
        setChartName(r100.getChartName());
        setStatus(r100.getStatus());
        setChartData(r100.getChartData());
    }

    public final HomeChartEntity deepClone(boolean r100) {
        HomeChartEntity r101 = new HomeChartEntity(this);
        r101.f212477d = this.f212477d;
        r101.f212476c = this.f212476c;
        r101.setHasExposed(getHasExposed());
        d r102 = null;
        if (r100 == false) goto L8;
        d r103 = getChartData();
        if (r103 == null) goto L7;
        r102 = new d(r103.f539106a);
    L7:
        r101.setChartData(r102);
    L9:
        return r101;
    L8:
        r101.setChartData(null);
        goto L9
    }

    public boolean isContentSame(HomeChartEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "diffable");
        if (Intrinsics.areEqual(getChartToken(), r100.getChartToken()) == true) goto L5;
    L27:
        return false;
    L5:
        if (Intrinsics.areEqual(getChartType(), r100.getChartType()) == false) goto L27;
        if (Intrinsics.areEqual(getBaseName(), r100.getBaseName()) == false) goto L27;
        if (Intrinsics.areEqual(getBaseUrl(), r100.getBaseUrl()) == false) goto L27;
        if (Intrinsics.areEqual(getBaseToken(), r100.getBaseToken()) == false) goto L27;
        if (isTemplate() != r100.isTemplate()) goto L27;
        if (Intrinsics.areEqual(getDashboardToken(), r100.getDashboardToken()) == false) goto L27;
        if (Intrinsics.areEqual(getChartName(), r100.getChartName()) == false) goto L27;
        if (getStatus() != r100.getStatus()) goto L27;
        if (this.f212477d != r100.f212477d) goto L27;
        if (this.f212476c != r100.f212476c) goto L27;
        if (Intrinsics.areEqual(getChartData(), r100.getChartData()) == false) goto L27;
        return true;
    }

    public boolean isItemSame(HomeChartEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "diffable");
        return Intrinsics.areEqual(getChartToken(), r100.getChartToken());
    }

    public final void migrateFromOld(HomeChartEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "old");
        setChartData(r100.getChartData());
        this.f212477d = r100.f212477d;
        setHasExposed(r100.getHasExposed());
    }

    public final void setEditMode(boolean r100) {
        this.f212477d = r100;
    }

    public final void setInitPosition(int r100) {
        this.f212476c = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((HomeChartEntity) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((HomeChartEntity) r100);
    }

    public static /* synthetic */ HomeChartEntity deepClone$default(HomeChartEntity r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = true;
    L6:
        return r100.deepClone(r101);
    }
}
