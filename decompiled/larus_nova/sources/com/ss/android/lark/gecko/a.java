package com.ss.android.lark.gecko;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f425767a;

    /* JADX INFO: renamed from: com.ss.android.lark.gecko.a$a, reason: collision with other inner class name */
    public static final class C5032a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f425768a = null;

        static {
            f425768a = new a();
        }
    }

    public a() {
        this.f425767a = new HashMap();
    }

    public static boolean a(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
        return true;
    L5:
        if (r100.isDirectory() == true) goto L7;
        return true;
    L7:
        if (r100.listFiles().length == 1) goto L9;
        return true;
    L9:
        if (TextUtils.isDigitsOnly(r100.getParentFile().getName()) == false) goto L16;
        return false;
    L16:
        return true;
    }
}
