package vl1;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.network.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.g;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import pm1.h;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f555624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f555625h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveNetworkBroadcastReceiver f555626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TokenCert f555627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TokenCert f555628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f555629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f555630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BaseFragment f555631f;

    public static final class a {
    }

    static {
        f555625h = true;
    }

    public final void a() {
        BaseFragment r100 = this.f555631f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isActive() != true) goto L32;
        h r101 = h.f529822d;
        Object r102 = r101.c(g.class);
        Intrinsics.checkNotNull(r102);
        if (((g) r102).isFreeFlow() == true) goto L10;
        Object r103 = r101.c(g.class);
        Intrinsics.checkNotNull(r103);
        g r104 = (g) r103;
        Context r105 = this.f555630e;
        if (r105 != null) goto L26;
        return;
    L26:
        if (f555625h == false) goto L31;
        r104.a(r105);
        f555625h = false;
        return;
    L31:
        return;
    L10:
        if (f555624g == true) goto L29;
        Context r106 = this.f555630e;
        if (r106 != null) goto L14;
        r106 = s1.getContext();
    L14:
        String r107 = r106.getString(R.string.ttlive_replay_free_flow_tip);
        if (TextUtils.isEmpty(r107) == false) goto L18;
    L20:
        f555624g = true;
        return;
    L18:
        if (r.x().c(r106, r107) == true) goto L20;
        Toast.makeText(r106, r107, 0).show();
        goto L20
    L29:
        return;
    }

    public e(Context r100, BaseFragment r101) {
        this.f555630e = r100;
        this.f555631f = r101;
        this.f555626a = new LiveNetworkBroadcastReceiver();
        TokenCert.Companion r102 = TokenCert.Companion;
        this.f555627b = r102.with("bpea-vsfragment_get_network_type");
        this.f555628c = r102.with("bpea-vs_enter_room_mobile_net_type");
        this.f555629d = new f(this);
    }
}
