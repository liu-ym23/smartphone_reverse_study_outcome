package com.bytedance.sdk.account.monitor;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final lc7.b f269189b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f269190c = null;

    static {
        f269188a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "monitorService", "getMonitorService()Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;"))};
        f269190c = new a();
        f269189b = new lc7.b(IAccountSdkMonitorService.class);
    }

    public a() {
    }

    @JvmStatic
    public static final void a(String r100, final JSONObject r101) {
        a r102 = f269190c;
        r102.getClass();
        IAccountSdkMonitorService r103 = (IAccountSdkMonitorService) f269189b.getValue(r102, f269188a[0]);
        MonitorProcessor r104 = MonitorProcessor.f269179d;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        r104.getClass();
        MonitorProcessor.b(r100, r103, new MonitorProcessor$handleEvent$1(r101));
    }
}
