package com.xiaomi;

import a87.k;
import android.content.Context;
import android.content.SharedPreferences;
import j77.a;
import j77.c;

/* JADX INFO: loaded from: classes41.dex */
public class MiPushSettings$$SettingImpl implements MiPushSettings {
    private Context mContext;
    private final c mInstanceCreator;
    private k mStorage;

    @Override // com.xiaomi.MiPushSettings
    public boolean hasUpgradeTo3616() {
        k r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("mipush_upgrade_3616") == false) goto L7;
        return this.mStorage.getBoolean("mipush_upgrade_3616");
    }

    @Override // com.xiaomi.MiPushSettings
    public void setUpgradeTo3616(boolean r100) {
        k r101 = this.mStorage;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.putBoolean("mipush_upgrade_3616", r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void unregisterValChanged(a r100) {
        k r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.unregisterValChanged(r100);
        return;
    }

    public MiPushSettings$$SettingImpl(Context r100, k r101) {
        this.mInstanceCreator = new AnonymousClass1(this);
        this.mContext = r100;
        this.mStorage = r101;
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void registerValChanged(Context r100, String r101, String r102, a r103) {
        k r104 = this.mStorage;
        if (r104 == null) goto L6;
        r104.registerValChanged(r100, r101, r102, r103);
        return;
    }
}
