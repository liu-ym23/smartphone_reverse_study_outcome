package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "getFrame";
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> e(HashMap<String, Object> r100) {
        if (r100 != null) goto L5;
        return a.b("params is null");
    L5:
        return f(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Map<String, m16.b> r101 = c36.a.f22277a;
        String r102 = y.d(r100, "containerID");
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        m16.c r103 = c36.a.a(r102).a(LiveLocalLifeLynxView.class);
        if (r103 == null) goto L8;
        LiveLocalLifeLynxView r104 = (LiveLocalLifeLynxView) r103.provideInstance();
    L9:
        LinkedHashMap r105 = new LinkedHashMap();
        if (r104 == null) goto L12;
        int[] r106 = {0, 0};
        r104.getLocationInWindow(r106);
        r105.put("x", Integer.valueOf(j0.f(r106[0])));
        r105.put("y", Integer.valueOf(j0.f(r106[1])));
        r105.put("width", Integer.valueOf(j0.f(r104.getWidth())));
        r105.put("height", Integer.valueOf(j0.f(r104.getHeight())));
        return a.d(this, r105, 1);
    L12:
        return a.b("get view fail");
    L8:
        r104 = null;
        goto L9
    }
}
