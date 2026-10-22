package uw0;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.panel.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tw0.i;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f551916a;

    public a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        this.f551916a = r100;
    }

    @Override // uw0.b
    public final k a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "orderOptions");
        j r101 = r100.f90118a;
        Map<String, String> r102 = this.f551916a.J8();
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        r101.putAll(r102);
        Map<String, String> r103 = r100.f90129l;
        Map<String, String> r104 = this.f551916a.G0();
        if (r104 != null) goto L8;
        r104 = MapsKt.emptyMap();
    L8:
        r103.putAll(r104);
        Map<String, String> r105 = r100.f90130m;
        Map<String, String> r106 = this.f551916a.I4();
        if (r106 != null) goto L11;
        r106 = MapsKt.emptyMap();
    L11:
        r105.putAll(r106);
        com.bytedance.android.live.recharge.panel.context.c r107 = g.a();
        if (r107 == null) goto L14;
        com.bytedance.android.live.recharge.model.d r108 = r107.a();
    L15:
        if (r108 == null) goto L22;
        Map<String, String> r109 = r108.f90024m;
        if (r109 == null) goto L22;
        Iterator<Map.Entry<String, String>> r110 = r109.entrySet().iterator();
    L20:
        if (r110.hasNext() == false) goto L22;
        Map.Entry<String, String> r111 = r110.next();
        d60.b.a(r100.f90127j, r111.getKey(), r111.getValue());
    L22:
        if (r108 != null) goto L24;
    L34:
        Map<String, String> r112 = this.f551916a.getBizExtra();
        if (r112 == null) goto L40;
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L38:
        if (r113.hasNext() == false) goto L40;
        Map.Entry<String, String> r114 = r113.next();
        d60.b.a(r100.f90127j, r114.getKey(), r114.getValue());
    L40:
        int r115 = com.bytedance.android.live.recharge.order.i.f90105d;
        com.bytedance.android.live.recharge.order.i r116 = com.bytedance.android.live.recharge.order.i.a.a(r108);
        r100.f90129l.put("recharge_channel", r116.a());
        return r100;
    L24:
        if (com.bytedance.android.live.recharge.nopassword.g.c(r108) == false) goto L26;
    L32:
        RechargeBizScene r117 = RechargeBizScene.SCENE_FANS_NOPASSWORD;
    L33:
        d60.b.a(r100.f90127j, DyVerifyEventConstants.EventParam.BIZ_SCENE, String.valueOf(r117.getScene()));
        goto L34
    L26:
        if (com.bytedance.android.live.recharge.nopassword.g.a(r108) == true) goto L32;
        if (com.bytedance.android.live.recharge.nopassword.g.b() == false) goto L31;
        r117 = RechargeBizScene.SCENE_PK_NOPASSWORD;
        goto L33
    L31:
        r117 = RechargeBizScene.SCENE_NORMAL;
        goto L33
    L14:
        r108 = null;
        goto L15
    }
}
