package com.bytedance.push.sync.setting;

import a87.k;
import android.content.Context;
import j77.a;

/* JADX INFO: loaded from: classes21.dex */
public class FrontierLocalSetting$$SettingImpl implements FrontierLocalSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f267026a;

    @Override // com.bytedance.push.settings.ILocalSettings
    public final void unregisterValChanged(a r100) {
        k r101 = this.f267026a;
        if (r101 == null) goto L6;
        r101.unregisterValChanged(r100);
        return;
    }

    public FrontierLocalSetting$$SettingImpl(Context r100, k r101) {
        this.f267026a = r101;
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public final void registerValChanged(Context r100, String r101, String r102, a r103) {
        k r104 = this.f267026a;
        if (r104 == null) goto L6;
        r104.registerValChanged(r100, r101, r102, r103);
        return;
    }
}
