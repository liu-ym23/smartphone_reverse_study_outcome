package rn6;

import com.bytedance.frameworks.baselib.netx.partner.mutable.MutableRequest;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f538689a;

    /* JADX INFO: renamed from: rn6.a$a, reason: collision with other inner class name */
    public static final class C7504a {
    }

    static {
    }

    public a(Map<String, String> r100) {
        this.f538689a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        if (r100 == null) goto L5;
        Request r101 = r100.request();
    L6:
        Map<String, String> r102 = this.f538689a;
        if (r101 != null) goto L9;
        Request r103 = null;
    L23:
        if (r100 != null) goto L25;
        return null;
    L25:
        return r100.proceed(r103);
    L9:
        MutableRequest r104 = new MutableRequest(r101);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L20
        if (r102 == null) goto L17;
        Iterator<Map.Entry<String, String>> r106 = r102.entrySet().iterator();     // Catch: Throwable -> L20
    L14:
        if (r106.hasNext() == false) goto L16;
        Map.Entry<String, String> r107 = r106.next();     // Catch: Throwable -> L20
        r104.f244820b.b(r107.getKey(), r107.getValue());     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L20
    L22:
        r103 = r104.a();
        goto L23
    L17:
        r108 = null;
    L20:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        r101 = null;
        goto L6
    }
}
