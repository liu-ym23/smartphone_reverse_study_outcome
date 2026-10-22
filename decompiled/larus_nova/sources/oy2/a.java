package oy2;

import android.app.Application;
import bz2.d;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f527123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f527124b;

    public static void a(boolean r100, boolean r101) {
        f527123a = r100;
        Application r102 = HybridMonitor.getInstance().getApplication();
        if (r101 == false) goto L9;
        if (r102 == null) goto L9;
        PolarisFileWrapper r103 = new PolarisFileWrapper(d.a(r102, "monitor_data_switch"), "is_debug");
        if (r100 == false) goto L8;
        d.b(r103);
        goto L9
    L8:
        d.delete(r103);
    L9:
        if (r100 == false) goto L12;
        ty2.a.f547963a = true;
        return;
    }

    public static void b(boolean r100, boolean r101) {
        f527124b = r100;
        Application r102 = HybridMonitor.getInstance().getApplication();
        if (r101 == false) goto L10;
        if (r102 == null) goto L11;
        PolarisFileWrapper r103 = new PolarisFileWrapper(d.a(r102, "monitor_data_switch"), "is_output_file");
        if (r100 == false) goto L8;
        d.b(r103);
        return;
    L8:
        d.delete(r103);
        return;
    L11:
        return;
    }
}
