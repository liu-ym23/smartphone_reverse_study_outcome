package com.bytedance.ies.web.jsbridge2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class r extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n56.c f249427b;

    public r(n56.c r100) {
        this.f249427b = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.e
    public final void j(c0 r100, i0 r101) throws Exception {
        n56.f r102 = new n56.f();
        r102.f518031c = r100.f249319d;
        r102.f518032d = new JSONObject(r100.f249320e);
        r102.f518030b = r100.f249321f;
        r102.f518029a = r100.f249318c;
        r102.f518033e = 0;
        r102.f518034f = r100.f249322g;
        r102.f518035g = r100.f249323h;
        r102.f518038j = true;
        PermissionGroup r103 = r101.f249362b;
        if (r103 == null) goto L5;
        r102.f518037i = r103.toString();
    L5:
        JSONObject r104 = new JSONObject();
        r102.toString();
        this.f249427b.call(r102, r104);     // Catch: Exception -> L8
    L10:
        if (r102.f518038j == true) goto L12;
        r102.toString();
        return;
    L12:
        String r105 = r104.toString();
        if (r101.f249364d == true) goto L18;
        IllegalStateException r106 = new IllegalStateException("Jsb async call already finished: " + r101.f249361a + ", stub: " + r101.hashCode());
        if (m.f249390a == false) goto L18;
        throw r106;
    L18:
        j r107 = (j) r101.f249363c;
        if (r105 == null) goto L23;
        b r108 = r107.f249366b.f249380i;
        if (r108 == null) goto L24;
        r108.e(r105, r107.f249365a);
    L24:
        r101.f249364d = false;
        if (m.f249390a == true) goto L27;
        return;
    L27:
        if (r104.optInt("code", 0) != 1) goto L29;
        r102.toString();
        return;
    L29:
        r102.toString();
        return;
    L23:
        r107.getClass();
        goto L24
    }
}
