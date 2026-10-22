package com.ss.android.dypay.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends Lambda implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f408380a = null;

    static {
        f408380a = new c();
    }

    public c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String r100) {
        JSONObject r101 = sta.a.f543575a;
        sta.a.g("start_activity_exception: " + r100 + " with h5 intent by continue pay");
        return Unit.INSTANCE;
    }
}
