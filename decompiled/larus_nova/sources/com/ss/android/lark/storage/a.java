package com.ss.android.lark.storage;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f440941c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f440943b;

    /* JADX INFO: renamed from: com.ss.android.lark.storage.a$a, reason: collision with other inner class name */
    public static final class C5306a {
    }

    static {
    }

    public final String a() {
        Intrinsics.checkNotNullParameter(".", "separate");
        String[] r100 = new String[2];
        a r101 = this.f440943b;
        if (r101 == null) goto L5;
        String r102 = r101.a();
    L6:
        r100[0] = r102;
        r100[1] = this.f440942a;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r100), File.separator, null, null, 0, null, null, 62, null);
    L5:
        r102 = null;
        goto L6
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f440942a = r100;
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L11;
        if (StringsKt.contains$default(r100, HTTP.URL_DEFAULT, false, 2, null) == true) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("domain name not valid");
    L5:
        r101 = false;
        goto L6
    }
}
