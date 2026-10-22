package me5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.NetworkConstant$RequestErrorCode;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.network.NetworkConstant$RequestErrorMsg;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f513482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j66.a.InterfaceC6395a f513483b;

    public c(a r100, j66.a.b r101) {
        this.f513482a = r100;
        this.f513483b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f513482a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        Integer r103 = Integer.valueOf(ax4.c.a(r101));
        if (r103.intValue() == (-3)) goto L5;
        int r104 = NetworkConstant$RequestErrorCode.NET_ERROR;
    L7:
        if (r104 != (-113000)) goto L15;
        int r105 = ax4.b.f16631a;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if ((r101 instanceof NetService.HttpErrorException) == false) goto L11;
        int r106 = ((NetService.HttpErrorException) r101).getCode();
    L12:
        r103 = Integer.valueOf(r106);
        if (r103.intValue() == (-1)) goto L15;
        r104 = NetworkConstant$RequestErrorCode.HTTP_ERROR;
        goto L15
    L11:
        r106 = -1;
    L15:
        if (r104 != (-113000)) goto L19;
        r103 = Integer.valueOf(ax4.d.a(r101));
        if (r103.intValue() == (-1)) goto L19;
        r104 = NetworkConstant$RequestErrorCode.SERVER_ERROR;
    L19:
        if (r104 != (-113000)) goto L21;
        r103 = null;
    L21:
        Pair r107 = new Pair(Integer.valueOf(r104), r103);
        this.f513482a.getClass();
        int r108 = ax4.b.f16631a;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if ((r101 instanceof NetService.HttpErrorException) == false) goto L24;
        int r109 = ((NetService.HttpErrorException) r101).getCode();
    L25:
        if (r109 == (-1)) goto L33;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if ((r101 instanceof NetService.HttpErrorException) == false) goto L29;
        String r110 = ((NetService.HttpErrorException) r101).getHttpStr();
    L30:
        if (r110 == null) goto L39;
    L43:
        a.f(r107, r110, this.f513483b);
        return;
    L39:
        r110 = "";
        goto L43
    L29:
        r110 = r101.getMessage();
        goto L30
    L33:
        if (ax4.d.a(r101) != (-1)) goto L35;
        r110 = r101.getMessage();
        if (r110 != null) goto L43;
        r110 = NetworkConstant$RequestErrorMsg.INNER_ERROR_MSG;
        goto L43
    L35:
        if ((r101 instanceof NetService.ServerErrorException) == false) goto L37;
        r110 = ((NetService.ServerErrorException) r101).getMsg();
    L38:
        if (r110 != null) goto L43;
    L37:
        r110 = r101.getMessage();
        goto L38
    L24:
        r109 = -1;
        goto L25
    L5:
        r104 = NetworkConstant$RequestErrorCode.INNER_ERROR;
        goto L7
    }
}
