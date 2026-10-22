package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f247542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f247543d;

    public final String getType() {
        return this.f247540a;
    }

    public g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.f247540a = "";
        this.f247541b = "";
        this.f247542c = "";
        this.f247543d = new ArrayList();
        this.f247540a = r100.optString("type");
        this.f247541b = r100.optString("key");
        this.f247542c = r100.optString(OnekeyLoginConstants.CU_KEY_OPERATOR);
        JSONArray r101 = r100.optJSONArray("value");
        if (r101 == null) goto L10;
        ArrayList r102 = new ArrayList();
        int r103 = r101.length();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r102.add(r101.optString(r104));
        r104 = r104 + 1;
        goto L5
    L7:
        this.f247543d = r102;
        return;
    }
}
