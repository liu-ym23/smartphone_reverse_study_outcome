package ov6;

import com.bytedance.locallife.live.experiment.k;
import com.bytedance.locallife.live.msgcenter.interfaces.ReleaseScene;
import com.bytedance.locallife.live.util.m;
import com.bytedance.locallife.live.util.n;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements pv6.b {

    /* JADX INFO: renamed from: ov6.a$a, reason: collision with other inner class name */
    public static final class C7116a {
    }

    static {
    }

    public a() {
    }

    @Override // pv6.b
    public final boolean b(com.bytedance.locallife.live.msgcenter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        m r101 = n.f260724a;
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_name", r100.f260628a)});
        if (k.a() == true) goto L5;
        r102.put("msg_extra", String.valueOf(r100.f260629b));
    L5:
        Unit r103 = Unit.INSTANCE;
        n.a("register_msg_subscriber", r102);
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        return true;
    }

    @Override // pv6.b
    public final void c(com.bytedance.locallife.live.msgcenter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        m r101 = n.f260724a;
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_name", r100.f260628a)});
        if (k.a() == true) goto L5;
        r102.put("msg_extra", String.valueOf(r100.f260629b));
    L5:
        Unit r103 = Unit.INSTANCE;
        n.a("unregister_msg_subscriber", r102);
        Intrinsics.checkNotNullParameter(r100, "subscriber");
    }

    @Override // pv6.b
    public final boolean a(com.bytedance.locallife.live.msgcenter.a r100, com.bytedance.locallife.live.msgcenter.b r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        m r102 = n.f260724a;
        Pair[] r103 = new Pair[2];
        r103[0] = TuplesKt.to("msg_name", r100.f260624a);
        if (r101 == null) goto L6;
        String r104 = r101.toString();
        if (r104 == null) goto L6;
    L7:
        r103[1] = TuplesKt.to("msg_target", r104);
        Map r105 = MapsKt.mutableMapOf(r103);
        if (k.a() == true) goto L10;
        r105.put("msg_params", String.valueOf(r100.f260625b));
        r105.put("msg_extra", String.valueOf(r100.f260626c));
    L10:
        Unit r106 = Unit.INSTANCE;
        n.a("post_live_life_msg", r105);
        return false;
    L6:
        r104 = "";
        goto L7
    }

    @Override // pv6.b
    public final void d(ReleaseScene r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        m r102 = n.f260724a;
        Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_release_scene", r100.toString())});
        if (k.a() == true) goto L5;
        r103.put("msg_extra", String.valueOf(r101));
    L5:
        Unit r104 = Unit.INSTANCE;
        n.a("release_msg_center", r103);
    }
}
