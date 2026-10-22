package com.bytedance.ies.web.jsbridge2;

import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class h0 implements n56.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f249356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f249357b;

    public h0(q0 r100, Set<String> r101) {
        this.f249356a = r101;
        this.f249357b = r100;
    }

    @Override // n56.c
    public void call(n56.f r100, JSONObject r101) throws Exception {
        if (this.f249356a.contains(r100.f518031c) == false) goto L6;
        r101.put("code", "-1");
        return;
    L6:
        r100.f518038j = false;
        c0.a r102 = c0.a();
        r102.f249329c = r100.f518031c;
        r102.f249328b = r100.f518029a;
        r102.f249330d = r100.f518032d.toString();
        r102.f249331e = r100.f518030b;
        r102.f249327a = String.valueOf(r100.f518033e);
        r102.f249332f = r100.f518034f;
        r102.f249333g = r100.f518035g;
        r102.f249334h = r100.f518036h;
        c0 r103 = r102.a();
        this.f249357b.o(r103);
        r100.toString();
    }
}
