package com.ss.android.dypay.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends Lambda implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f408379a = null;

    static {
        f408379a = new b();
    }

    public b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String r100) {
        JSONObject r101 = sta.a.f543575a;
        sta.a.g("start_activity_exception: " + r100 + " with h5 intent by default");
        return Unit.INSTANCE;
    }
}
