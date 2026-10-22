package xf2;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @JvmStatic
    public static final boolean delete(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return false;
    L6:
        File r0 = new PolarisFileWrapper(r1);
        return a.delete(r0);
    }

    public final boolean delete(File r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.exists() == false) goto L8;
        if (r2.delete() == false) goto L8;
        return true;
    }
}
