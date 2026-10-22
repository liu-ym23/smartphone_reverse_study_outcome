package p60;

import android.content.Context;
import android.content.Intent;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends a {
    @Override // p60.a, p60.c
    public final boolean b() {
        return LiveInfraSettingKeys.LIVE_ENABLE_BY_CHECKER.getValue().booleanValue();
    }

    public d() {
    }

    @Override // p60.a, p60.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        r101.addCategory("android.intent.category.DEFAULT");
        r101.putExtra("packageName", r100.getPackageName());
        return r101;
    }
}
