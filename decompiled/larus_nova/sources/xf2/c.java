package xf2;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f563442a = null;

    public c() {
    }

    static {
        f563442a = new c();
    }

    @JvmStatic
    public static final boolean delete(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        return f563442a.delete(r101);
    }

    public final boolean delete(File r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.exists() == false) goto L8;
        if (r100.delete() == false) goto L8;
        return true;
    }
}
