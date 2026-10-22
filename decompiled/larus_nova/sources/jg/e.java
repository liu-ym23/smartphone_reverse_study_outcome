package jg;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498944a = 0;

    static {
    }

    public static String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "originKey");
        Intrinsics.checkNotNullParameter(r102, "originValue");
        String r103 = Uri.encode(r101);
        String r104 = Uri.encode(r102);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return r100;
    L7:
        return new Regex("(" + r103 + "=[^&]*)").replace(r100, r103 + com.alipay.sdk.m.n.a.f25612h + r104);
    }

    public static String b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return r100;
    L7:
        if (StringsKt.contains$default(r100, r101, false, 2, null) == true) goto L17;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return r100;
    L12:
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return r100;
    L14:
        return UriProtector.parse(r100).buildUpon().appendQueryParameter(r101, r102).toString();
    L17:
        return a(r100, r101, r102);
    }

    public static String c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri r103 = UriProtector.parse(r100);
        if (r102 == null) goto L20;
        Uri.Builder r104 = r103.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r103, r101)) == false) goto L8;
        r104.appendQueryParameter(r101, r102);
    L18:
        r103 = r104.build();
        goto L20
    L8:
        r104.clearQuery();
        Iterator<String> r105 = UriProtector.getQueryParameterNames(r103).iterator();
    L10:
        if (r105.hasNext() == false) goto L18;
        String r106 = r105.next();
        if ((!Intrinsics.areEqual(r106, r101)) == true) goto L13;
        r104.appendQueryParameter(r106, r102);
        goto L10
    L13:
        Iterator<String> r107 = UriProtector.getQueryParameters(r103, r106).iterator();
    L15:
        if (r107.hasNext() == false) goto L10;
        r104.appendQueryParameter(r106, r107.next());
    L20:
        return String.valueOf(r103);
    }
}
