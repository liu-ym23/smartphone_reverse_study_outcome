package uh1;

import am2.n;
import android.os.Bundle;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.ui.i6;
import com.bytedance.android.livesdk.chatroom.ui.l8;
import com.bytedance.android.livesdk.chatroom.ui.s5;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.utils.s0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import os2.d;
import ts2.o;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends d<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public b() {
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r110, ts2.a r111) {
        boolean r101 = false;
        if (r110 != ContainerLifecycle.ON_ACTIVITY_CREATED) goto L10;
        Bundle r102 = ((o) r111).f547358a;
        if (r102 == null) goto L10;
        Bundle r103 = r100.f510519h;
        if (r103 == null) goto L10;
        r103.putBoolean("enter_from_dou_plus", r102.getBoolean("enter_from_dou_plus", false));
    L10:
        if (r110 != ContainerLifecycle.ON_DESTROY) goto L35;
        boolean r104 = l8.f113670a;
        if (tb1.c.f545231c == false) goto L31;
        if (l8.a() == false) goto L31;
        s5 r105 = l8.b();
        if (r105 == null) goto L21;
        i6 r106 = r105.b();
        if (r106 == null) goto L21;
        String r107 = r106.c();
    L22:
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == false) goto L31;
        f2.c(r107, 0);
        goto L31
    L24:
        if (r107.length() == 0) goto L27;
        r108 = false;
    L21:
        r107 = null;
    L31:
        if (l8.f113670a == false) goto L33;
        l8.f113670a = false;
        Map<String, String> r109 = s0.f159156a;
        Intrinsics.checkNotNullParameter("ecom_retain_data", "key");
        Map<String, String> r112 = s0.f159156a;
        String r113 = (String) ((HashMap) r112).remove("ecom_retain_data");
        Intrinsics.checkNotNullParameter("ad_reward_retain_data", "key");
        String r114 = (String) ((HashMap) r112).remove("ad_reward_retain_data");
    L33:
        n r115 = n.f();
        r115.f4313b = "";
        r115.f4315d = "";
        r115.f4316e = "";
        r115.f4317f = "";
        r115.f4319h = "";
        r115.f4318g = false;
        r115.f4314c = "";
    L35:
        if (r110 != ContainerLifecycle.ON_SAVE_INSTANCE_STATE) goto L42;
        Bundle r116 = ((o) r111).f547358a;
        Bundle r117 = r100.f510519h;
        if (r117 != null) goto L39;
    L41:
        r116.putBoolean("enter_from_dou_plus", r101);
        goto L42
    L39:
        if (r117.getBoolean("enter_from_dou_plus", false) == false) goto L41;
        r101 = true;
    L42:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
