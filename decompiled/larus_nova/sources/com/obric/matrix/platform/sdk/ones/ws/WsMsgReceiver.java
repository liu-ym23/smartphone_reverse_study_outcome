package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alipay.sdk.m.p.e;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public abstract class WsMsgReceiver extends BroadcastReceiver {

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public WsMsgReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Objects.toString(r100);
        Objects.toString(r101);
        Serializable r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getIntExtra("channel_id", 0));
    L7:
        if (r101 == null) goto L9;
        Long r104 = Long.valueOf(r101.getLongExtra("seq_id", 0));
    L10:
        if (r101 == null) goto L12;
        Long r105 = Long.valueOf(r101.getLongExtra("log_id", 0));
    L13:
        if (r101 == null) goto L15;
        Integer r106 = Integer.valueOf(r101.getIntExtra("service", 0));
    L16:
        if (r101 == null) goto L18;
        Integer r107 = Integer.valueOf(r101.getIntExtra(e.f25671s, 0));
    L19:
        if (r101 == null) goto L21;
        r102 = r101.getSerializableExtra("ws_headers");
    L21:
        if (r102 == null) goto L32;
        HashMap r108 = (HashMap) r102;
        if (r101 == null) goto L25;
        r101.getStringExtra("payload_type");
    L25:
        if (r101 == null) goto L27;
        r101.getStringExtra("payload_encoding");
    L27:
        if (r101 == null) goto L29;
        r101.getByteArrayExtra(WsConstants.KEY_PAYLOAD);
    L29:
        Intrinsics.checkNotNull(r103);
        r103.intValue();
        Intrinsics.checkNotNull(r104);
        r104.longValue();
        Intrinsics.checkNotNull(r105);
        r105.longValue();
        Intrinsics.checkNotNull(r106);
        r106.intValue();
        Intrinsics.checkNotNull(r107);
        r107.intValue();
        a();
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L18:
        r107 = null;
        goto L19
    L15:
        r106 = null;
        goto L16
    L12:
        r105 = null;
        goto L13
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }
}
