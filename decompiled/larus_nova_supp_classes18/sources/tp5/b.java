package tp5;

import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static boolean c(int r1) {
        if (r1 != 920004001) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 920004002) goto L10;
        if (r1 == 920004121) goto L10;
        return false;
    }

    public static int a(Throwable r1) {
        if (r1 != null) goto L4;
        return -1;
    L4:
        if ((r1 instanceof NetService.ServerErrorException) == false) goto L7;
        NetService.ServerErrorException r2 = (NetService.ServerErrorException) r1;
    L12:
        if (r2 == null) goto L18;
        int r3 = r2.getCode();
        if (r3 == 0) goto L19;
        return r3;
    L19:
        return -1;
    L18:
        return -1;
    L7:
        if (r1.getCause() != null) goto L9;
    L11:
        r2 = null;
        goto L12
    L9:
        if ((r1.getCause() instanceof NetService.ServerErrorException) == false) goto L11;
        r2 = (NetService.ServerErrorException) r1.getCause();
        goto L12
    }

    public static boolean d(Throwable r1) {
        int r2 = a(r1);
        if (r2 != 920004003) goto L5;
    L12:
        return true;
    L5:
        if (r2 == 920004004) goto L12;
        if (r2 == 920004007) goto L12;
        if (r2 == 920004012) goto L12;
        return false;
    }

    public static boolean b(Throwable r0, int r1) {
        if (a(r0) != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
