package com.bytedance.ee.bear.document.quota;

import com.bytedance.ee.bear.appsetting.c;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShowQuotaBannerPlugin f221249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f221250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f221251c;

    public a(ShowQuotaBannerPlugin r100, long r101, boolean r102) {
        this.f221249a = r100;
        this.f221250b = r101;
        this.f221251c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(this.f221249a, "<this>");
        long r102 = 0;
        r102 = new JSONObject((String) c.a.f206237a.d("ccm_platform_tenant_quota_oversize_limit_transition_dead_line", "")).optLong("time", 0);     // Catch: Throwable -> L5
    L7:
        if (Math.abs((this.f221250b * ((long) 1000)) - System.currentTimeMillis()) < 60000) goto L9;
        return;
    L9:
        if (this.f221251c == true) goto L11;
        return;
    L11:
        if (r101.booleanValue() == true) goto L13;
        return;
    L13:
        if (System.currentTimeMillis() >= r102) goto L21;
        ShowQuotaBannerPlugin.access$showQuotaBanner(this.f221249a, r102);
        return;
    }
}
