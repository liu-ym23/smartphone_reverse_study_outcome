package hs1;

import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends AbilityCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486942a;

    public a() {
        Intrinsics.checkNotNullParameter("BroadcastStreamPage", "tag");
        this.f486942a = "BroadcastStreamPage";
    }

    @Override // com.bytedance.android.livesdk.ability.AbilityCenter, com.bytedance.android.livesdk.ability.IAbilityCenter
    public final <T extends IAbility> T getAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) super.getAbility(r100);
        if (r101 == null) goto L5;
    L7:
        ALogger.i(this.f486942a, "getAbility: ".concat(r100.getSimpleName()));
        return r101;
    L5:
        if (v.a() == false) goto L7;
        SafetyGuard.a(null, null, this.f486942a + " getAbility " + r100.getSimpleName() + " is null");
        ALogger.e(this.f486942a, Log.getStackTraceString(new Exception()));
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ability.AbilityCenter, com.bytedance.android.livesdk.ability.IAbilityCenter
    public final <T extends IAbility> void unregisterAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ALogger.i(this.f486942a, "registerAbility: ".concat(r100.getSimpleName()));
        super.unregisterAbility(r100);
    }

    @Override // com.bytedance.android.livesdk.ability.AbilityCenter, com.bytedance.android.livesdk.ability.IAbilityCenter
    public final <T extends IAbility> void registerAbility(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        ALogger.i("StartLiveSceneAbilityCenter", "registerAbility: ".concat(r100.getSimpleName()));
        super.registerAbility(r100, r101);
    }
}
