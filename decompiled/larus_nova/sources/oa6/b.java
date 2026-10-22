package oa6;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final na6.c<String, ma6.a> f522547a;

    public b() {
        this.f522547a = new na6.c();
    }

    public final void a(String r100, ma6.a r101) {
        Intrinsics.checkNotNullParameter(r100, "expr");
        Intrinsics.checkNotNullParameter(r101, "exprProgram");
        na6.c<String, ma6.a> r102 = this.f522547a;
        String r103 = StringsKt.trim(r100).toString();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r102.f518469a.put(r103, r101);
    }
}
