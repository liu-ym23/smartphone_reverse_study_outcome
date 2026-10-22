package ax4;

import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static int a(Throwable r2) {
        if ((r2 instanceof NetService.ServerErrorException) == false) goto L7;
        int r3 = ((NetService.ServerErrorException) r2).getCode();
        tt5.a.h("ServerErrorCode", "exceptionToCode(): code = " + r3);
        if (r3 == 0) goto L9;
        return r3;
    L9:
        return -1;
    L7:
        return -1;
    }

    public static boolean b(Throwable r3, int r4) {
        if ((r3 instanceof NetService.ServerErrorException) == false) goto L8;
        int r5 = ((NetService.ServerErrorException) r3).getCode();
        tt5.a.h("ServerErrorCode", "isErrorCodeEqual(): code = " + r5);
        if (r5 != r4) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }
}
