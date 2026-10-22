package com.larus.dora.impl.device.settings.general;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f334328a = 0;

    static {
    }

    public static void a(DoraDevice r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "device");
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).sendBroadcast(new Intent("com.larus.dora.impl.action.WEAR_DETECTION_CHANGED").putExtra("device_serial_number", r100.getSerialNumber()).putExtra("device_mac", r100.f204389mac).putExtra("enabled", r101));
    }
}
