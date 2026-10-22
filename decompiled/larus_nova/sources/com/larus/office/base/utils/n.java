package com.larus.office.base.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f361174a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f361177c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361175a, r101.f361175a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361176b, r101.f361176b) == true) goto L15;
            return false;
        L15:
            if (this.f361177c == r101.f361177c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f361175a.hashCode() * 31) + this.f361176b.hashCode()) * 31;
            if (this.f361177c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "BitableSharePathInfo(scene=" + this.f361175a + ", token=" + this.f361176b + ", isLegacy=" + this.f361177c + ')';
        }

        public a(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "token");
            this.f361175a = r100;
            this.f361176b = r101;
            this.f361177c = r102;
        }
    }

    static {
        f361174a = LazyKt.lazy(new g());
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return k(r100, new i());
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getHost();
        List<String> r103 = r101.getPathSegments();
        if (e(r102) == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r103);
        List<String> r104 = r103;
        Intrinsics.checkNotNullParameter(r104, "path");
        if (Boolean.valueOf(d(r104)).booleanValue() == false) goto L11;
        return true;
    L7:
        if (f(r102) == true) goto L8;
    L11:
        return false;
    }

    public static boolean d(List r100) {
        if (r100.size() == 2) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r100, 0), DocumentType.DOCX_NAME) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(String r100) {
        if (Intrinsics.areEqual(r100, "feishu.doubao.com") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "www.doubao.com") == true) goto L8;
        return false;
    }

    public static boolean f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        IThirdPartyPlatformAuthorizationProvider r101 = (IThirdPartyPlatformAuthorizationProvider) f361174a.getValue();
        if (r101 == null) goto L20;
        List<String> r102 = r101.a();
        if (r102 == null) goto L20;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L20;
        String r104 = (String) r103.next();
        if (r100 != null) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L11;
        return true;
    L15:
        if (StringsKt.endsWith$default(r100, r104, false, 2, null) != true) goto L17;
        r105 = true;
    L20:
        return false;
    }

    public static boolean g(List r100) {
        if (r100.size() == 2) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r100, 0), "sheets") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getHost();
        List<String> r103 = r101.getPathSegments();
        if (e(r102) == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r103);
        List<String> r104 = r103;
        Intrinsics.checkNotNullParameter(r104, "path");
        if (Boolean.valueOf(g(r104)).booleanValue() == false) goto L11;
        return true;
    L7:
        if (f(r102) == true) goto L8;
    L11:
        return false;
    }

    public static boolean i(List r100) {
        if (r100.size() == 2) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r100, 0), "slides") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getHost();
        List<String> r103 = r101.getPathSegments();
        if (e(r102) == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r103);
        List<String> r104 = r103;
        Intrinsics.checkNotNullParameter(r104, "path");
        if (Boolean.valueOf(i(r104)).booleanValue() == false) goto L11;
        return true;
    L7:
        if (f(r102) == true) goto L8;
    L11:
        return false;
    }

    public static boolean l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return k(r100, new m());
    }

    public static a m(List r110) {
        if (r110.size() != 2) goto L15;
        if (Intrinsics.areEqual(ListProtector.get(r110, 0), "record") == false) goto L15;
        Object r111 = ListProtector.get(r110, 1);
        if ((!StringsKt.isBlank((String) r111)) == true) goto L10;
        r111 = null;
    L10:
        String r112 = (String) r111;
        if (r112 != null) goto L47;
        return null;
    L47:
        return new a("record", r112, true);
    L15:
        if (r110.size() != 3) goto L29;
        if (Intrinsics.areEqual(ListProtector.get(r110, 0), "base") == false) goto L29;
        if (Intrinsics.areEqual(ListProtector.get(r110, 1), "add") == false) goto L29;
        Object r113 = ListProtector.get(r110, 2);
        if ((!StringsKt.isBlank((String) r113)) == true) goto L24;
        r113 = null;
    L24:
        String r114 = (String) r113;
        if (r114 != null) goto L48;
        return null;
    L48:
        return new a("add", r114, true);
    L29:
        if (r110.size() == 4) goto L31;
        return null;
    L31:
        if (Intrinsics.areEqual(ListProtector.get(r110, 0), "share") == true) goto L33;
        return null;
    L33:
        if (Intrinsics.areEqual(ListProtector.get(r110, 1), "base") == true) goto L35;
        return null;
    L35:
        if (Intrinsics.areEqual(ListProtector.get(r110, 2), "record") == false) goto L37;
    L38:
        Object r100 = ListProtector.get(r110, 3);
        if ((!StringsKt.isBlank((String) r100)) == true) goto L42;
        r100 = null;
    L42:
        String r101 = (String) r100;
        if (r101 != null) goto L46;
        return null;
    L46:
        return new a((String) ListProtector.get(r110, 2), r101, false);
    L37:
        if (Intrinsics.areEqual(ListProtector.get(r110, 2), "add") == true) goto L38;
        return null;
    }

    public static String a(String r100, Function1 r101) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        Uri r102 = UriProtector.parse(r100);
        String r103 = r102.getHost();
        List<String> r104 = r102.getPathSegments();
        if (e(r103) == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r104);
        if (((Boolean) r101.invoke(r104)).booleanValue() == true) goto L11;
        return null;
    L11:
        return (String) ListProtector.get(r104, 1);
    L7:
        if (f(r103) == true) goto L8;
        return null;
    L12:
        return null;
    }

    public static boolean k(String r100, Function1 r101) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        Uri r102 = UriProtector.parse(r100);
        String r103 = r102.getHost();
        List<String> r104 = r102.getPathSegments();
        if (e(r103) == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r104);
        if (((Boolean) r101.invoke(r104)).booleanValue() == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (f(r103) == true) goto L8;
        return false;
    L12:
        return false;
    }
}
