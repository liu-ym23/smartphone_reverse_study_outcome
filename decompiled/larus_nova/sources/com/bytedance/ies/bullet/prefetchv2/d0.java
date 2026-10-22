package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f247524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t36.d f247526c;

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f247526c.c().get(r100);
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() != 2) goto L24;
        boolean r102 = false;
        String r103 = a((String) ListProtector.get(r101, 0));
        if (r103 != null) goto L7;
        return null;
    L7:
        JSONObject r104 = new JSONObject(r103);
        String r105 = (String) ListProtector.get(r101, 1);
        Map<String, Map<Class<?>, Object>> r106 = x26.a.f562251a;
        w26.g r107 = (w26.g) x26.a.a(w26.g.class);
        if (r107 == null) goto L14;
        w26.e r108 = (w26.e) r107.n0(w26.e.class);
        if (r108 == null) goto L14;
        Boolean r109 = r108.d2();
        if (r109 == null) goto L14;
        boolean r110 = r109.booleanValue();
    L15:
        if (r110 == false) goto L22;
        String r111 = r104.optString(r105);
        if (r111.length() <= 0) goto L19;
        r102 = true;
    L19:
        if (r102 == true) goto L26;
        return null;
    L26:
        return r111;
    L22:
        return r104.optString(r105);
    L14:
        r110 = true;
        goto L15
    L24:
        throw new PrefetchException("配置错误，格式应该为a.b: " + r100);
    }

    public d0(boolean r100, String r101, t36.d r102) {
        Intrinsics.checkNotNullParameter(r102, "rawData");
        this.f247524a = r100;
        this.f247525b = r101;
        this.f247526c = r102;
    }
}
