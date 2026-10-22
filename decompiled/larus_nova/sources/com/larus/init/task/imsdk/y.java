package com.larus.init.task.imsdk;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements gd9.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f351413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile JSONObject f351414b;

    static {
        f351413a = new y();
    }

    public y() {
    }

    public static JSONObject f() {
        SettingsData r100 = SettingsManager.obtainSettingsFast(AppHost.f326268a.getApplication());
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getAppSettings();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new JSONObject();
    }

    @Override // gd9.y
    public final double a(final String r100, final double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = com.larus.utils.l0.f375430a;
        return ((Number) com.larus.utils.l0.a(Double.valueOf(r101), new x(r100, r101))).doubleValue();
    }

    @Override // gd9.y
    public final int b(final String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = com.larus.utils.l0.f375430a;
        return ((Number) com.larus.utils.l0.a(Integer.valueOf(r101), new u(r100, r101))).intValue();
    }

    @Override // gd9.y
    public final long c(final String r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = com.larus.utils.l0.f375430a;
        return ((Number) com.larus.utils.l0.a(Long.valueOf(r101), new w(r100, r101))).longValue();
    }

    @Override // gd9.y
    public final boolean d(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = com.larus.utils.l0.f375430a;
        return ((Boolean) com.larus.utils.l0.a(Boolean.valueOf(r101), new t(r100, r101))).booleanValue();
    }

    @Override // gd9.y
    public final String getValue(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return (String) com.larus.utils.l0.a(r101, new v(r100, r101));
    }

    @Override // gd9.y
    public final ouc.d0 e(final String r100, final ouc.d0 r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return (ouc.d0) com.larus.utils.l0.a(r101, new s(r102, r100, r101));
    }
}
