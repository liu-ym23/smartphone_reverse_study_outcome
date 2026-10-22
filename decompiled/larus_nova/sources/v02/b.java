package v02;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static void a(long r100, boolean r101, Function0 r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r101 = false;
    L8:
        Intrinsics.checkNotNullParameter(r102, "action");
        Handler r104 = new Handler(Looper.getMainLooper());
        if (r100 <= 0) goto L11;
        r104.postDelayed(new a(r102), r100);
        return;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        if (r101 == true) goto L14;
        r102.invoke();
        return;
    L14:
        r104.post(new a(r102));
    }
}
