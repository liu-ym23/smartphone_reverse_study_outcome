package lm9;

import com.larus.network.bean.BizResponse;
import com.larus.network.http.AsyncThrowable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509902a = 0;

    static {
    }

    public static String a(AsyncThrowable r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultErrorMsg");
        if (r100 != null) goto L5;
        return r101;
    L5:
        BizResponse.Companion.getClass();
        if (ArraysKt.contains(BizResponse.access$getCODE_RISK_CONTROL$cp(), r100.getCode()) == false) goto L21;
        String r102 = r100.getMessage();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L22;
        String r104 = r100.getMessage();
        if (r104 != null) goto L20;
        return r101;
    L20:
        return r104;
    L22:
        return r101;
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
        goto L14
    L21:
        return r101;
    }
}
