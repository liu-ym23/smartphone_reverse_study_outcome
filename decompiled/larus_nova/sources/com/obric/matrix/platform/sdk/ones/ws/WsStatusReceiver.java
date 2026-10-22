package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "Landroid/content/BroadcastReceiver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public class WsStatusReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Boolean, Unit> f397013a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WsStatusReceiver(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f397013a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Objects.toString(r100);
        Objects.toString(r101);
        Boolean r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r101 == null) goto L8;
        Integer r104 = Integer.valueOf(r101.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r101 == null) goto L11;
        Integer r105 = Integer.valueOf(r101.getIntExtra("ws_connection_state", 0));
    L12:
        if (r101 == null) goto L14;
        r102 = Boolean.valueOf(r101.getBooleanExtra("ws_is_connected", false));
    L14:
        Function4<Integer, Integer, Integer, Boolean, Unit> r106 = this.f397013a;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNull(r102);
        r106.invoke(r104, r105, r103, r102);
        return;
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
