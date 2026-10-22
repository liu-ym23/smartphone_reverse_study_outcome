package com.bytedance.android.shopping.api.window;

import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AwemeInfo {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final JsonObject b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return (String) this.a.getValue();
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public AwemeInfo(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        this.b = r2;
        this.a = LazyKt.lazy(new AwemeInfo$awemeId$2(this));
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if ((!Intrinsics.areEqual(AwemeInfo.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        if ((!Intrinsics.areEqual(a(), ((AwemeInfo) r4).a())) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.api.window.AwemeInfo");
    L8:
        r2 = null;
        goto L10
    }
}
