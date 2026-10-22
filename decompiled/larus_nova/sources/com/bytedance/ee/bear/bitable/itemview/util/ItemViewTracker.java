package com.bytedance.ee.bear.bitable.itemview.util;

import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes15.dex */
public final class ItemViewTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f214261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lu4.a f214262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f214263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f214264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f214265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f214266f;

    public ItemViewTracker() {
        this.f214261a = org.koin.java.a.d(com.bytedance.ee.bear.bitable.statistic.m.class);
        SettingsBitableConfig r100 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        if (r100 != null) goto L5;
        r100 = new SettingsBitableConfig();
    L5:
        this.f214262b = r100.f();
        this.f214263c = LazyKt.lazy(new ItemViewTracker$openFpsTrace$2(this));
        this.f214264d = LazyKt.lazy(new ItemViewTracker$openProcessTrace$2(this));
        this.f214265e = LazyKt.lazy(new ItemViewTracker$scrollFpsTrace$2(this));
        this.f214266f = LazyKt.lazy(new ItemViewTracker$switchFpsTrace$2(this));
    }
}
