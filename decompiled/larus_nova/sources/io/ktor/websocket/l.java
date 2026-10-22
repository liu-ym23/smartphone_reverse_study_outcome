package io.ktor.websocket;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f492180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f492181b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f492180a);
        r100.append(' ');
        if (this.f492181b.isEmpty() == false) goto L5;
        String r101 = "";
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r101 = ", " + CollectionsKt.joinToString$default(this.f492181b, ",", null, null, 0, null, null, 62, null);
        goto L6
    }

    public l(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "parameters");
        this.f492180a = r100;
        this.f492181b = r101;
    }
}
