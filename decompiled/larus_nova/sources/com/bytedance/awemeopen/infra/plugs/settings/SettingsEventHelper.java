package com.bytedance.awemeopen.infra.plugs.settings;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class SettingsEventHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198877a = 0;

    static {
    }

    public static void a(final String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "aoAppId");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "reason");
        AoPool.a(new SettingsEventHelper$monitorWriteFailed$1(r100, r101, r102));
    }

    public static void b(final String r110, final long r111, final String r112, final int r113, final String r114, final String r115, final int r116) {
        final long r100 = 0;
        Intrinsics.checkNotNullParameter(r110, "bdpAppId");
        Intrinsics.checkNotNullParameter(r112, "result");
        Intrinsics.checkNotNullParameter(r114, "errorMsg");
        Intrinsics.checkNotNullParameter(r115, "from");
        AoPool.a(new SettingsEventHelper$mpSettingsRequestResult$1(r110, r111, r112, r100, r113, r114, r115, r116));
    }
}
