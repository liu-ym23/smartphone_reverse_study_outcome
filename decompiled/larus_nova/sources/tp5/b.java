package tp5;

import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static boolean c(int r100) {
        if (r100 != 920004001) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 920004002) goto L10;
        if (r100 == 920004121) goto L10;
        return false;
    }

    public static int a(Throwable r100) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L7;
        NetService.ServerErrorException r101 = (NetService.ServerErrorException) r100;
    L12:
        if (r101 == null) goto L18;
        int r102 = r101.getCode();
        if (r102 == 0) goto L19;
        return r102;
    L19:
        return -1;
    L18:
        return -1;
    L7:
        if (r100.getCause() != null) goto L9;
    L11:
        r101 = null;
        goto L12
    L9:
        if ((r100.getCause() instanceof NetService.ServerErrorException) == false) goto L11;
        r101 = (NetService.ServerErrorException) r100.getCause();
        goto L12
    }

    public static boolean d(Throwable r100) {
        int r101 = a(r100);
        if (r101 != 920004003) goto L5;
    L12:
        return true;
    L5:
        if (r101 == 920004004) goto L12;
        if (r101 == 920004007) goto L12;
        if (r101 == 920004012) goto L12;
        return false;
    }

    public static boolean b(Throwable r100, int r101) {
        if (a(r100) != r101) goto L5;
        return true;
    L5:
        return false;
    }
}
