package qr5;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Request;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC7384a f534618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f534619b = null;

    /* JADX INFO: renamed from: qr5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7384a {
    }

    static {
        f534619b = new AtomicBoolean(false);
    }

    public static boolean a(Request r100) {
        if ("GET".equals(r100.method().toUpperCase()) == false) goto L6;
    L4:
        boolean r101 = true;
    L9:
        String r102 = r100.headers().get("EENet-Request-Enable-Complex-Connect");
        if (TextUtils.isEmpty(r102) == true) goto L12;
        r101 = Boolean.valueOf(r102).booleanValue();
    L12:
        if (r101 == true) goto L15;
        return false;
    L15:
        return true;
    L6:
        if ("HEAD".equals(r100.method().toUpperCase()) == true) goto L4;
        r101 = false;
        goto L9
    }
}
