package xx9;

import com.larus.trace.tracespan.span.b;
import com.larus.utils.logger.FLogger;
import io.opentelemetry.context.c;
import io.opentelemetry.context.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final wx9.a a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        vx9.b.f557496a.getClass();
        if (vx9.b.f557502g == true) goto L6;
        wx9.b r101 = wx9.b.f561852c;
        return wx9.b.f561852c;
    L6:
        zx9.a r102 = null;
        c r103 = g.f492702b;     // Catch: Throwable -> L11
        if ((r103 instanceof zx9.a) == false) goto L13;
        r102 = (zx9.a) r103;     // Catch: Throwable -> L11
    L13:
        if (r102 == null) goto L16;
        wx9.a r104 = r102.getContext(r100.getTraceId(), r100.a());
        if (r104 == null) goto L16;
        return r104;
    L16:
        wx9.b r105 = wx9.b.f561852c;
        return wx9.b.f561852c;
    L11:
        th = move-exception;
        FLogger.f375446a.e("SpanExt", "get ContextStorage failed:" + th);
        goto L13
    }
}
