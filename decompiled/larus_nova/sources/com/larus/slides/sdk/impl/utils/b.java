package com.larus.slides.sdk.impl.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f369786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f369787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f369788c;

    public static final class a {
        public static String a(String r100, String r101) {
            if (r101 != null) goto L5;
            r100 = URLEncoder.encode(r100, "ISO_8859_1");     // Catch: UnsupportedEncodingException -> L10
        L8:
            Intrinsics.checkNotNull(r100);     // Catch: UnsupportedEncodingException -> L10
            return r100;
        L5:
            if (Intrinsics.areEqual(r101, "null_encoding") == true) goto L8;
            r100 = URLEncoder.encode(r100, r101);     // Catch: UnsupportedEncodingException -> L10
        L10:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }
    }

    static {
    }

    public final String a() {
        if (this.f369786a.isEmpty() == true) goto L5;
        HashMap<String, String> r100 = this.f369786a;
        String r101 = this.f369788c;
        StringBuilder r102 = new StringBuilder();
        Set<String> r103 = r100.keySet();
        boolean r104 = false;
        String r105 = "";
        if (r103 != null) goto L9;
    L27:
        String r106 = this.f369787b;
        if (r106 != null) goto L30;
    L39:
        return r105;
    L30:
        if (r106.length() != 0) goto L32;
        r104 = true;
    L32:
        if (r104 == true) goto L39;
        if (StringsKt.indexOf$default(this.f369787b, '?', 0, false, 6, null) < 0) goto L38;
        return this.f369787b + Typography.amp + r105;
    L38:
        return this.f369787b + '?' + r105;
    L9:
        if (r103.isEmpty() == true) goto L27;
        Iterator<String> r107 = r103.iterator();
    L13:
        if (r107.hasNext() == false) goto L26;
        String r108 = r107.next();
        String r109 = a.a(r108, r101);
        String r110 = r100.get(r108);
        if (r110 == null) goto L18;
        String r111 = a.a(r110, r101);
        if (r111 == null) goto L18;
    L20:
        if (r102.length() <= 0) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == false) goto L25;
        r102.append("&");
    L25:
        r102.append(r109);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r111);
        goto L13
    L22:
        r112 = false;
    L18:
        r111 = "";
        goto L20
    L26:
        r105 = r102.toString();
        goto L27
    L5:
        return this.f369787b;
    }

    public b() {
        Intrinsics.checkNotNullParameter("https://www.feishu.cn/space/api/slide/pages/client_vars", "url");
        this.f369786a = new HashMap();
        this.f369788c = "UTF-8";
        this.f369787b = "https://www.feishu.cn/space/api/slide/pages/client_vars";
    }

    public final String toString() {
        return a();
    }
}
