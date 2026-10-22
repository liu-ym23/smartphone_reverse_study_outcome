package gz8;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
public final class h {
    public static final void a() {
        s r100 = s.f544207a;
        Application r101 = AppHost.f326268a.getApplication();
        String r102 = f.b("toast_fail_retry");
        r100.getClass();
        s.c(r101, r102);
    }

    public static final void b(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getCode() != 710010702) goto L5;
        String r101 = f.b("toast_fail_retry");
    L18:
        s r102 = s.f544207a;
        Application r103 = AppHost.f326268a.getApplication();
        r102.getClass();
        s.c(r103, r101);
        return;
    L5:
        String r104 = r100.getTips();
        if (r104 == null) goto L17;
        r101 = StringsKt.trim(r104).toString();
        if (r101 == null) goto L17;
        if (r101.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        r101 = null;
    L16:
        if (r101 != null) goto L18;
    L12:
        r105 = false;
    L17:
        r101 = f.b("toast_fail_retry");
        goto L18
    }
}
