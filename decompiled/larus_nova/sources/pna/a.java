package pna;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PolarisFileWrapper f529988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f529989b = false;

    static {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/self/task");
        f529988a = r100;
        new PolarisFileWrapper("/proc/self/limits");
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.isDirectory() == true) goto L7;
        return;
    L7:
        if (r100.canRead() == false) goto L12;
        f529989b = true;
        return;
    }
}
