package yp9;

import com.larus.platform.service.o;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568724a;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f568724a = r100;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "param");
        FLogger.f375446a.i(this.f568724a, "[" + r100 + "] " + r101);
        o.f365780a.b(this.f568724a, f.c(new Pair[]{TuplesKt.to("tag", r100), TuplesKt.to("param", r101)}));
    }
}
