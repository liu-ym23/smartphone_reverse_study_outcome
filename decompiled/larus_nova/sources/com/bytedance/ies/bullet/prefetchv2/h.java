package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f247544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f247545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t> f247546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f247547d;

    public static final class a {
    }

    static {
    }

    public h(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.f247544a = r100;
        this.f247545b = "unknown";
        this.f247546c = new ArrayList();
        JSONArray r101 = r100.optJSONArray("apis");
        if (r101 == null) goto L7;
        this.f247546c = new ArrayList();
        int r102 = r101.length();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r101, r103);
        List<t> r105 = this.f247546c;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new t(r104));
        r103 = r103 + 1;
    L7:
        this.f247547d = "default_bid";
    }
}
