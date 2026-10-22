package com.larus.home.impl.route;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f346102a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 == null) goto L21;
        Uri r101 = UriProtector.parse(r100);
        if (r101 == null) goto L7;
        String r102 = r101.getSchemeSpecificPart();
    L8:
        if (r102 == null) goto L12;
        List r103 = StringsKt.split$default(r102, new String[]{"?"}, false, 0, 6, null);
        if (r103 == null) goto L12;
        String r104 = (String) CollectionsKt.first(r103);
    L13:
        boolean r105 = false;
        if (r104 != null) goto L16;
    L18:
        if (r105 == true) goto L20;
        return null;
    L20:
        return r104;
    L16:
        if (StringsKt.startsWith$default(r104, "//", false, 2, null) != true) goto L18;
        r105 = true;
    L12:
        r104 = null;
        goto L13
    L7:
        r102 = null;
        goto L8
    L21:
        return null;
    }
}
