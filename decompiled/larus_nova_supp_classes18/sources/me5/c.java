package me5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.NetworkConstant$RequestErrorCode;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.NetworkConstant$RequestErrorMsg;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ j66.a.a b;

    public c(a r1, j66.a.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        NetService.HttpErrorException r8 = (Throwable) r7;
        a r0 = this.a;
        Intrinsics.checkNotNull(r8);
        r0.getClass();
        Integer r1 = Integer.valueOf(ax4.c.a(r8));
        if (r1.intValue() == (-3)) goto L5;
        int r2 = NetworkConstant$RequestErrorCode.NET_ERROR;
    L7:
        if (r2 != (-113000)) goto L15;
        int r3 = ax4.b.a;
        Intrinsics.checkNotNullParameter(r8, "throwable");
        if ((r8 instanceof NetService.HttpErrorException) == false) goto L11;
        int r4 = r8.getCode();
    L12:
        r1 = Integer.valueOf(r4);
        if (r1.intValue() == (-1)) goto L15;
        r2 = NetworkConstant$RequestErrorCode.HTTP_ERROR;
        goto L15
    L11:
        r4 = -1;
    L15:
        if (r2 != (-113000)) goto L19;
        r1 = Integer.valueOf(ax4.d.a(r8));
        if (r1.intValue() == (-1)) goto L19;
        r2 = NetworkConstant$RequestErrorCode.SERVER_ERROR;
    L19:
        if (r2 != (-113000)) goto L21;
        r1 = null;
    L21:
        Pair r5 = new Pair(Integer.valueOf(r2), r1);
        this.a.getClass();
        int r6 = ax4.b.a;
        Intrinsics.checkNotNullParameter(r8, "throwable");
        if ((r8 instanceof NetService.HttpErrorException) == false) goto L24;
        int r9 = r8.getCode();
    L25:
        if (r9 == (-1)) goto L33;
        Intrinsics.checkNotNullParameter(r8, "throwable");
        if ((r8 instanceof NetService.HttpErrorException) == false) goto L29;
        String r10 = r8.getHttpStr();
    L30:
        if (r10 == null) goto L39;
    L43:
        a.f(r5, r10, this.b);
        return;
    L39:
        r10 = "";
        goto L43
    L29:
        r10 = r8.getMessage();
        goto L30
    L33:
        if (ax4.d.a(r8) != (-1)) goto L35;
        r10 = r8.getMessage();
        if (r10 != null) goto L43;
        r10 = NetworkConstant$RequestErrorMsg.INNER_ERROR_MSG;
        goto L43
    L35:
        if ((r8 instanceof NetService.ServerErrorException) == false) goto L37;
        r10 = ((NetService.ServerErrorException) r8).getMsg();
    L38:
        if (r10 != null) goto L43;
    L37:
        r10 = r8.getMessage();
        goto L38
    L24:
        r9 = -1;
        goto L25
    L5:
        r2 = NetworkConstant$RequestErrorCode.INNER_ERROR;
        goto L7
    }
}
