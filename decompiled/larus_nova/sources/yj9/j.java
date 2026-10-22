package yj9;

import com.google.gson.Gson;
import com.larus.login.impl.lark_discover.PhoneLoginAccountDiscovery;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f568109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f568110b = null;

    public j() {
    }

    static {
        f568109a = new j();
        f568110b = new Gson();
    }

    public static PhoneLoginAccountDiscovery a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L26;
        return null;
    L26:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        Gson r104 = f568110b;     // Catch: Throwable -> L18
        k r105 = (k) r104.fromJson(r100, k.class);     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        PhoneLoginAccountDiscovery r106 = r105.a();     // Catch: Throwable -> L18
        if (r106 == null) goto L15;
    L16:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r107) == true) goto L25;
        r102 = r107;
    L25:
        return (PhoneLoginAccountDiscovery) r102;
    L15:
        r106 = (PhoneLoginAccountDiscovery) r104.fromJson(r100, PhoneLoginAccountDiscovery.class);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }
}
