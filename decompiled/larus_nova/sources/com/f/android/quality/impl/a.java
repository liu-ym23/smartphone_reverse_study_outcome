package com.f.android.quality.impl;

import com.f.android.quality.base.QualityLogger;
import java.util.Map;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements rt7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f274084a = null;

    public a() {
    }

    static {
        f274084a = new a();
    }

    @Override // rt7.a
    public final void onReport(String r100, Map<String, ? extends Object> r101) {
        JSONObject r102 = new JSONObject(r101);
        Lazy r103 = QualityLogger.f274059a;
        QualityLogger.a("onReport " + r100 + " ==== start");
        QualityLogger.a(String.valueOf(r102.toString(4)));
        QualityLogger.a("onReport " + r100 + " ==== end");
    }
}
