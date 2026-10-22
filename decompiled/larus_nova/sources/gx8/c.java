package gx8;

import com.larus.platform.service.o;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f483126a;

    public c() {
    }

    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extraAttributes");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        d r103 = this.f483126a;     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        Iterator<String> r104 = r103.a().keys();     // Catch: Throwable -> L11
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = r104.next();     // Catch: Throwable -> L11
        r101.put(r105, r103.a().get(r105));     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L11
    L13:
        Object r107 = r101;
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L16;
        r107 = r106;
    L16:
        o r108 = o.f365780a;
        r108.reportEvent(r100, (JSONObject) r107);
        return;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
