package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f397688a = null;

    static {
        f397688a = new a();
    }

    public a() {
    }

    public static String a(JSONObject r100, String r101) {
        String r102 = r100.optString(r101);
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == true) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    }
}
