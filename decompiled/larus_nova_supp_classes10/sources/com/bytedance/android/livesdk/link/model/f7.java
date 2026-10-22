package com.bytedance.android.livesdk.link.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f7 {
    public static final IBattleConfigSetting a(e7 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$battleConfigSetting");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        String r4 = r3.getBattleConfigSettingStr();     // Catch: Throwable -> L17
        if (r4 != null) goto L6;
    L15:
        Result.constructor-impl(null);     // Catch: Throwable -> L17
    L19:
        return null;
    L6:
        if (r4.length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L15;
        return (IBattleConfigSetting) l97.a.a.fromJson(r4, TypesJVMKt.getJavaType(Reflection.typeOf(IBattleConfigSetting.class)));
    L8:
        r2 = false;
    L17:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public static final String b(e7 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toSimpleString");
        StringBuilder r0 = new StringBuilder("MultiPKModeInfo{modeTab=");
        r0.append(r3.getModeTab());
        r0.append(", shellType=");
        IBattleConfigSetting r1 = a(r3);
        if (r1 == null) goto L7;
        w2 r2 = r1.getShellConfig();
        if (r2 == null) goto L7;
        long r4 = r2.getType();
    L8:
        r0.append(r4);
        r0.append(", userIdToTeamId=");
        Intrinsics.checkNotNullParameter(r3, "$this$userIdToTeamId");
        r0.append(r3.getRevUserIdToTeamId());
        r0.append(", version=");
        r0.append(r3.getVersion());
        if (r3.getSwitchSource() == 0) goto L11;
        String r5 = ", switchSource=" + r3.getSwitchSource();
    L12:
        r0.append(r5);
        r0.append('}');
        return r0.toString();
    L11:
        r5 = "";
    L7:
        r4 = 0;
        goto L8
    }
}
