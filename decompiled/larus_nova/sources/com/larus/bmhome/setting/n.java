package com.larus.bmhome.setting;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.service.o2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements com.larus.platform.api.b {
    public n() {
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        UserSettingCacheManager r101 = UserSettingCacheManager.f313814a;
        UserSettingCacheManager.f313815b = new UserConfigItem(Integer.valueOf(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue()), "0", 0L);
        UserSettingCacheManager.f313816c = Keva.getRepo(r100.f364877c + '_' + o2.f365782a.e(), 0);
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        UserSettingCacheManager r101 = UserSettingCacheManager.f313814a;
        UserSettingCacheManager.f313815b = new UserConfigItem(Integer.valueOf(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue()), "0", 0L);
        UserSettingCacheManager.f313816c = null;
    }
}
