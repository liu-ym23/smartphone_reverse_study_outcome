package com.larus.dora.dorag.res;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/dorag/res/DoraByteCastManager$registerWifiStateReceiver$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dorag-res_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraByteCastManager$registerWifiStateReceiver$receiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f331841b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraByteCastManager f331842a;

    public DoraByteCastManager$registerWifiStateReceiver$receiver$1(DoraByteCastManager r100) {
        this.f331842a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L4;
        String r102 = r101.getAction();
    L6:
        if (Intrinsics.areEqual(r102, "android.net.wifi.WIFI_STATE_CHANGED") == true) goto L8;
        return;
    L8:
        int r103 = r101.getIntExtra("wifi_state", 4);
        if (r103 != 1) goto L11;
        final DoraByteCastManager r104 = this.f331842a;
        DoraByteCastManager.n(r104, new i(r104));
        return;
    L11:
        if (r103 != 3) goto L17;
        final DoraByteCastManager r105 = this.f331842a;
        DoraByteCastManager.n(r105, new h(r105));
        return;
    L17:
        return;
    L4:
        r102 = null;
        goto L6
    }
}
