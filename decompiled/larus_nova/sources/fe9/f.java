package fe9;

import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public f() {
    }

    public abstract String d();

    public static String h(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return r101;
    L11:
        return "<" + r100 + "> " + r101;
    L4:
        if (StringsKt.isBlank(r101) == true) goto L7;
        r102 = false;
        goto L8
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        b.f476621b.i(d(), h(r100, r101));
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        b.f476621b.e(d(), h(r100, r101));
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        b.f476621b.i(d(), h(r100, r101));
    }

    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        b.f476621b.w(d(), h(r100, r101));
    }

    public final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        b r103 = b.f476621b;
        r103.e(d(), h(r100, r101));
        String r104 = d();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r105 = ExceptionsKt.stackTraceToString(r102);
    L6:
        r103.e(r104, h(r100, r105));
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void g(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        b r103 = b.f476621b;
        r103.w("FlowLinkLogger", h(r100, r101));
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r103.w("FlowLinkLogger", h(r100, ExceptionsKt.stackTraceToString(r102)));
    }
}
