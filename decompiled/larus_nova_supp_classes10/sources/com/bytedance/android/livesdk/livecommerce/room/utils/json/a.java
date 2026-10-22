package com.bytedance.android.livesdk.livecommerce.room.utils.json;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final Function1<JSONObject, Unit> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function1<JSONObject, Unit> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "JSONObjectEnvPair(init=" + this.a + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super JSONObject, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        this.a = r2;
    }
}
