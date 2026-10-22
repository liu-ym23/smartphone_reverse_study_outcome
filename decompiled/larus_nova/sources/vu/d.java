package vu;

import android.content.Context;
import android.content.Intent;
import com.bytedance.android.gamecp.common.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends a {
    @Override // vu.a, vu.c
    public final boolean b() {
        return LiveInfraSettingKeys.LIVE_ENABLE_BY_CHECKER.getValue().booleanValue();
    }

    public d() {
    }

    @Override // vu.a, vu.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        r101.addCategory("android.intent.category.DEFAULT");
        r101.putExtra("packageName", r100.getPackageName());
        return r101;
    }
}
