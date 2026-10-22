package com.ss.android.lark.chameleonv2.debug;

import android.preference.Preference;
import com.ss.android.lark.officesdk.utils.di.s;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Preference.OnPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChameleonDebugActivity f411376a;

    public a(ChameleonDebugActivity r100) {
        this.f411376a = r100;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "newValue");
        boolean r102 = ((Boolean) r101).booleanValue();
        com.ss.android.lark.storage.a r103 = CmlDebugSettingUtil.f411374a;
        Intrinsics.checkNotNullParameter("chameleon_disable_debug_view", "key");
        ((KVRepo) CmlDebugSettingUtil.f411375b.getValue()).putBoolean("chameleon_disable_debug_view", r102);
        int r104 = s.f437234a;
        ChameleonDebugActivity r105 = this.f411376a;
        if (r102 == false) goto L5;
        String r106 = "已禁用调试信息面板";
    L6:
        s.a.a(r105, r106);
        return true;
    L5:
        r106 = "已启用调试信息面板";
        goto L6
    }
}
