package h70;

import android.content.Context;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z70.b f483964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f483965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IAbilityCenter f483966c;

    public IAbilityCenter a() {
        return this.f483966c;
    }

    public Context getContext() {
        return this.f483965b;
    }

    public b(Context r100) {
        AbilityCenter r101 = new AbilityCenter();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "abilityCenter");
        this.f483965b = r100;
        this.f483966c = r101;
    }
}
