package rx1;

import android.content.Intent;
import com.ss.android.ugc.route_monitor.utils.Logger;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f539807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f539808b;

    static {
        f539807a = "91101698";
    }

    @JvmStatic
    public static final void a(Intent r100) {
        if (f539808b == false) goto L13;
        int r101 = com.ss.android.ugc.route_monitor.impl.route_out.control.i.f454634a;
        String r102 = f539807a;
        Logger r103 = Logger.f454747c;
        r100.toString();
        r103.b();
        if (r102.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r103.e();
    L11:
        f539808b = false;
        f539807a = "";
        return;
    L10:
        r100.putExtra("ug_open_third_app_cert_id", r102);
        goto L11
    L7:
        r104 = false;
        goto L8
    }
}
