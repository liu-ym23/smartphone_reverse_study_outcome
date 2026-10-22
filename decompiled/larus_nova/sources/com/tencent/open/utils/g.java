package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f461847a;

    public static final File e() {
        return a(null);
    }

    public static final Context a() {
        Context r100 = f461847a;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    public static final String b() {
        if (a() != null) goto L7;
        return "";
    L7:
        return a().getPackageName();
    }

    public static final File c() {
        if (a() != null) goto L7;
        return null;
    L7:
        return a().getFilesDir();
    }

    public static final File d() {
        Context r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCacheDir();
    }

    public static final File a(String r100) {
        return m.h(a(), r100);
    }

    public static final void a(Context r100) {
        f461847a = r100;
    }
}
