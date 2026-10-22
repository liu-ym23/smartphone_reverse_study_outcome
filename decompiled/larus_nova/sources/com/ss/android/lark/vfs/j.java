package com.ss.android.lark.vfs;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444831a = 0;

    static {
    }

    public static Uri a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        boolean r101 = false;
        if (StringsKt.startsWith$default(r100, File.separator, false, 2, null) == false) goto L6;
        Uri r102 = Uri.fromFile(new PolarisFileWrapper(r100));
        Intrinsics.checkNotNull(r102);
        return r102;
    L6:
        Uri r103 = UriProtector.parse(r100);
        if (r103.isHierarchical() == false) goto L15;
        String r104 = r103.getScheme();
        if (r104 != null) goto L11;
    L12:
        r101 = true;
    L13:
        if (r101 == true) goto L15;
        Intrinsics.checkNotNull(r103);
        return r103;
    L11:
        if (r104.length() != 0) goto L13;
    L15:
        Uri r105 = Uri.fromFile(new PolarisFileWrapper(r100));
        Intrinsics.checkNotNull(r105);
        return r105;
    }
}
