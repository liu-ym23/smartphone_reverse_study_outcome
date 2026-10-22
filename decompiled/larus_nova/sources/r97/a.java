package r97;

import com.bytedance.router.SmartRouter;
import com.bytedance.router.c;
import com.bytedance.router.listener.error.ErrorType;
import com.bytedance.router.listener.error.SmartRouterException;
import com.larus.init.task.i0;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static void b(String r100) {
        if (r100 != null) goto L4;
        r100 = "no message";
    L4:
        b r101 = SmartRouter.getErrorListener();
        if (r101 == null) goto L8;
        i0 r102 = (i0) r101;
        r102.a(null, null, new SmartRouterException(r100));
        return;
    }

    public static void a(ErrorType r100, c r101, String r102) {
        if (r102 != null) goto L4;
        r102 = "no message";
    L4:
        b r103 = SmartRouter.getErrorListener();
        if (r103 == null) goto L8;
        i0 r104 = (i0) r103;
        r104.a(r100, r101, new SmartRouterException(r102));
        return;
    }
}
