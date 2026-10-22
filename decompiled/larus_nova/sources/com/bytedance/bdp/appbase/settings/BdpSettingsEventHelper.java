package com.bytedance.bdp.appbase.settings;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpSettingsEventHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f201003a = 0;

    static {
    }

    public static void a(final String r100, final String r101, final String r102) {
        BdpPool.execute(BdpTask.TaskType.IO, new BdpSettingsEventHelper$monitorWriteFailed$1(r100, r101, r102));
    }

    public static void b(final String r110, final long r111, final String r112, final long r113, final int r114, final String r115, final String r210, final int r211) {
        BdpPool.executeQuickly(new BdpSettingsEventHelper$mpSettingsRequestResult$1(r110, r111, r112, r113, r114, r115, r210, r211));
    }
}
