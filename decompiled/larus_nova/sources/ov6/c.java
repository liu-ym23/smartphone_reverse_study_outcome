package ov6;

import com.bytedance.locallife.live.msgcenter.interfaces.ReleaseScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements pv6.b {
    public c() {
    }

    @Override // pv6.b
    public final boolean b(com.bytedance.locallife.live.msgcenter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        return true;
    }

    @Override // pv6.b
    public final void c(com.bytedance.locallife.live.msgcenter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
    }

    @Override // pv6.b
    public final boolean a(com.bytedance.locallife.live.msgcenter.a r100, com.bytedance.locallife.live.msgcenter.b r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (Intrinsics.areEqual(r100.f260624a, "poi_live_message_deliver") == false) goto L26;
        Map<String, Object> r102 = r100.f260625b;
        Integer r103 = null;
        if (r102 == null) goto L7;
        Object r104 = r102.get("type");
    L9:
        if ((r104 instanceof Integer) == false) goto L11;
        Integer r105 = (Integer) r104;
    L12:
        if (r101 == null) goto L16;
        Map<String, Object> r106 = r101.f260629b;
        if (r106 == null) goto L16;
        Object r107 = r106.get("expect_type");
    L18:
        if ((r107 instanceof Integer) == false) goto L20;
        r103 = (Integer) r107;
    L20:
        if (r103 != null) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r103, r105) == false) goto L28;
        com.bytedance.locallife.live.msgcenter.b.a(r101, r100.f260624a, r100.f260625b);
        return true;
    L28:
        return true;
    L16:
        r107 = null;
        goto L18
    L11:
        r105 = null;
        goto L12
    L7:
        r104 = null;
        goto L9
    L26:
        return false;
    }

    @Override // pv6.b
    public final void d(ReleaseScene r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }
}
