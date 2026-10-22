package vl1;

import android.content.Context;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.network.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.g;
import com.larus.nova.R;
import fq1.j;
import kotlin.jvm.internal.Intrinsics;
import pm1.h;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements LiveNetworkBroadcastReceiver.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f555632a;

    public f(e r100) {
        this.f555632a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.network.LiveNetworkBroadcastReceiver.a
    public final void a(NetworkUtils.NetworkType r100) {
        if (r100 == NetworkUtils.NetworkType.NONE) goto L5;
    L8:
        e r101 = this.f555632a;
        Context r102 = r101.f555630e;
        if (r102 != null) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == true) goto L14;
        return;
    L14:
        if (NetworkUtils.d(r102, r101.f555628c) == false) goto L17;
        this.f555632a.a();
        return;
    L17:
        if (NetworkUtils.g(this.f555632a.f555630e) == false) goto L22;
        e.f555625h = true;
        Object r103 = h.f529822d.c(g.class);
        Intrinsics.checkNotNull(r103);
        g r104 = (g) r103;
        return;
    L22:
        return;
    L5:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == true) goto L7;
        y.a(R.string.ttlive_replay_toast_network_exception);
    L7:
        j.a().L();
        goto L8
    }
}
