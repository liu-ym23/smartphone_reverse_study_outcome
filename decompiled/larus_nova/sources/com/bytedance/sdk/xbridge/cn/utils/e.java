package com.bytedance.sdk.xbridge.cn.utils;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270259a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Object r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof String) == false) goto L9;
        return StringsKt.isBlank((CharSequence) r100);
    L9:
        if ((r100 instanceof JSONObject) == true) goto L11;
        return true;
    L11:
        if (((JSONObject) r100).length() == 0) goto L18;
        return false;
    L18:
        return true;
    }

    @JvmStatic
    public static final JSONObject b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if ((r100 instanceof JSONObject) == false) goto L6;
        return (JSONObject) r100;
    L6:
        if ((r100 instanceof String) == false) goto L9;
        return new JSONObject((String) r100);
    L9:
        return new JSONObject();
    }
}
