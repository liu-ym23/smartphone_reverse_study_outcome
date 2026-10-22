package qr5;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static InterfaceC0277a a;
    public static final AtomicBoolean b = null;

    /* JADX INFO: renamed from: qr5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0277a {
    }

    static {
        b = new AtomicBoolean(false);
    }

    public static boolean a(Request r4) {
        if ("GET".equals(r4.method().toUpperCase()) == false) goto L6;
    L4:
        boolean r0 = true;
    L9:
        String r5 = r4.headers().get("EENet-Request-Enable-Complex-Connect");
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r0 = Boolean.valueOf(r5).booleanValue();
    L12:
        if (r0 == true) goto L15;
        return false;
    L15:
        return true;
    L6:
        if ("HEAD".equals(r4.method().toUpperCase()) == true) goto L4;
        r0 = false;
        goto L9
    }
}
