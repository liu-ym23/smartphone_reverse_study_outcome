package com.larus.init.task.accountsdk;

import com.larus.utils.l0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements d48.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f351146a = null;

    static {
        f351146a = new i();
    }

    public i() {
    }

    @Override // d48.e
    public final JSONObject a(final String r100, final JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return (JSONObject) l0.a(r101, new h(r100, r101));
    }
}
