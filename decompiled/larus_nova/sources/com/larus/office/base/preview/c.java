package com.larus.office.base.preview;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.office.base.utils.f;
import com.larus.office.base.utils.n;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f361026a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f361029c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361027a, r101.f361027a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361028b, r101.f361028b) == true) goto L15;
            return false;
        L15:
            if (this.f361029c == r101.f361029c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f361027a.hashCode() * 31) + this.f361028b.hashCode()) * 31;
            if (this.f361029c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "OfficePathInfo(urlType=" + this.f361027a + ", token=" + this.f361028b + ", skipCcmResolve=" + this.f361029c + ')';
        }

        public a(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "urlType");
            Intrinsics.checkNotNullParameter(r101, "token");
            this.f361027a = r100;
            this.f361028b = r101;
            this.f361029c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficePreviewType f361030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f361032c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f361030a == r101.f361030a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361031b, r101.f361031b) == true) goto L15;
            return false;
        L15:
            if (this.f361032c == r101.f361032c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f361030a.hashCode() * 31) + this.f361031b.hashCode()) * 31;
            if (this.f361032c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "OfficeUrlInfo(previewType=" + this.f361030a + ", token=" + this.f361031b + ", skipCcmResolve=" + this.f361032c + ')';
        }

        public b(OfficePreviewType r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "previewType");
            Intrinsics.checkNotNullParameter(r101, "token");
            this.f361030a = r100;
            this.f361031b = r101;
            this.f361032c = r102;
        }
    }

    /* JADX INFO: renamed from: com.larus.office.base.preview.c$c, reason: collision with other inner class name */
    public /* synthetic */ class C4436c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361033a = null;

        static {
            int[] r100 = new int[OfficePreviewType.values().length];
            r100[OfficePreviewType.DOCX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[OfficePreviewType.SHEETS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[OfficePreviewType.SLIDES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[OfficePreviewType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[OfficePreviewType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[OfficePreviewType.WIKI.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f361033a = r100;
        }
    }

    static {
        f361026a = new c();
    }

    public c() {
    }

    public static boolean c(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r100, "feishu.doubao.com") == false) goto L14;
        return true;
    L14:
        if (Intrinsics.areEqual(r100, "www.doubao.com") == false) goto L16;
        return true;
    L16:
        if (Intrinsics.areEqual(r100, "my.feishu.cn") == false) goto L18;
        return true;
    L18:
        if (n.f(r100) == true) goto L25;
        return false;
    L25:
        return true;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static OfficePreviewType f(String r100) {
        if (Intrinsics.areEqual(r100, DocumentType.DOC.type) == true) goto L35;
        if (Intrinsics.areEqual(r100, DocumentType.DOCX.type) == true) goto L35;
        if (Intrinsics.areEqual(r100, OfficePreviewType.DOCX.getRouteType()) == true) goto L35;
        if (Intrinsics.areEqual(r100, DocumentType.SHEET.type) == true) goto L39;
        if (Intrinsics.areEqual(r100, OfficePreviewType.SHEETS.getRouteType()) == true) goto L39;
        if (Intrinsics.areEqual(r100, DocumentType.SLIDES.type) == true) goto L38;
        if (Intrinsics.areEqual(r100, OfficePreviewType.SLIDES.getRouteType()) == true) goto L38;
        if (Intrinsics.areEqual(r100, DocumentType.WIKI.type) == true) goto L37;
        if (Intrinsics.areEqual(r100, OfficePreviewType.WIKI.getRouteType()) == true) goto L37;
        OfficePreviewType r101 = OfficePreviewType.FILE;
        if (Intrinsics.areEqual(r100, r101.getRouteType()) == true) goto L40;
        OfficePreviewType r102 = OfficePreviewType.BITABLE;
        if (Intrinsics.areEqual(r100, r102.getRouteType()) == false) goto L36;
        return r102;
    L36:
        return OfficePreviewType.UNKNOWN;
    L40:
        return r101;
    L37:
        return OfficePreviewType.WIKI;
    L38:
        return OfficePreviewType.SLIDES;
    L39:
        return OfficePreviewType.SHEETS;
    L35:
        return OfficePreviewType.DOCX;
    }

    public static a g(List r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Lazy r101 = n.f361174a;
        Intrinsics.checkNotNullParameter(r100, "pathSegments");
        n.a r102 = n.m(r100);
        if (r102 == null) goto L8;
        String r103 = r102.f361176b;
    L10:
        if (r103 == null) goto L14;
        return new a(OfficePreviewType.BITABLE.getRouteType(), r103, true);
    L14:
        if (r100.size() != 2) goto L28;
        Object r104 = ListProtector.get(r100, 1);
        if ((true ^ StringsKt.isBlank((String) r104)) == true) goto L19;
        r104 = null;
    L19:
        String r105 = (String) r104;
        if (r105 != null) goto L23;
        return null;
    L23:
        if (Intrinsics.areEqual((String) ListProtector.get(r100, 0), "app") == false) goto L25;
        String r106 = OfficePreviewType.BITABLE.getRouteType();
    L42:
        return new a(r106, r105, false);
    L25:
        r106 = (String) ListProtector.get(r100, 0);
        goto L42
    L28:
        if (r100.size() == 3) goto L30;
        return null;
    L30:
        if (Intrinsics.areEqual(ListProtector.get(r100, 0), "drive") == false) goto L44;
        Object r107 = ListProtector.get(r100, 1);
        OfficePreviewType r108 = OfficePreviewType.FILE;
        if (Intrinsics.areEqual(r107, r108.getRouteType()) == false) goto L45;
        Object r109 = ListProtector.get(r100, 2);
        if ((!StringsKt.isBlank((String) r109)) == true) goto L37;
        r109 = null;
    L37:
        String r110 = (String) r109;
        if (r110 != null) goto L41;
        return null;
    L41:
        return new a(r108.getRouteType(), r110, false);
    L45:
        return null;
    L44:
        return null;
    L8:
        r103 = null;
        goto L10
    }

    public static boolean l(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L23;
        return false;
    L23:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r100), "ccm_skip_officesdk_route"), "1")));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        FLogger.f375446a.w("OfficePreviewResolver", "shouldSkipOfficeSdkRoute failed: " + r104.getMessage());
    L18:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L22;
        r103 = r105;
    L22:
        return ((Boolean) r103).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final OfficePreviewType b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        b r101 = h(this, r100);
        if (r101 == null) goto L7;
        OfficePreviewType r102 = r101.f361030a;
        if (r102 == null) goto L7;
        return r102;
    L7:
        return OfficePreviewType.UNKNOWN;
    }

    public static boolean d(String r100, OfficePreviewType r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "type");
        Uri r102 = UriProtector.parse(r100);
        if (c(r102.getHost()) == false) goto L11;
        a r103 = g(r102.getPathSegments());
        if (r103 != null) goto L7;
        boolean r104 = false;
    L8:
        if (r104 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r104 = i(r103.f361027a, r101);
        goto L8
    L11:
        return false;
    }

    public static String e(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "targetUrl");
        boolean r101 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L54;
        return r100;
    L54:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L46
        Uri r111 = UriProtector.parse(r110);     // Catch: Throwable -> L46
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L46
        Set<String> r105 = UriProtector.getQueryParameterNames(r104);     // Catch: Throwable -> L46
        Uri.Builder r106 = r104.buildUpon();     // Catch: Throwable -> L46
        Iterator<T> r107 = UriProtector.getQueryParameterNames(r111).iterator();     // Catch: Throwable -> L46
    L13:
        if (r107.hasNext() == false) goto L25;
        String r108 = (String) r107.next();     // Catch: Throwable -> L46
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L46
        if (r108.length() <= 0) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == false) goto L13;
        if (r105.contains(r108) == true) goto L13;
        Iterator<T> r112 = UriProtector.getQueryParameters(r111, r108).iterator();     // Catch: Throwable -> L46
    L23:
        if (r112.hasNext() == false) goto L13;
        r106.appendQueryParameter(r108, (String) r112.next());     // Catch: Throwable -> L46
        goto L23
    L17:
        r109 = false;
        goto L18
    L25:
        String r113 = r104.getFragment();     // Catch: Throwable -> L46
        if (r113 != null) goto L28;
    L31:
        boolean r114 = true;
    L32:
        if (r114 == false) goto L44;
        String r115 = r111.getFragment();     // Catch: Throwable -> L46
        if (r115 == null) goto L44;
        if (r115.length() > 0) goto L39;
        r101 = false;
    L39:
        if (r101 == true) goto L42;
        r115 = null;
    L42:
        if (r115 == null) goto L44;
        r106.fragment(r115);     // Catch: Throwable -> L46
    L44:
        Object r116 = Result.m9449constructorimpl(r106.build().toString());     // Catch: Throwable -> L46
    L48:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L51;
        Object r118 = r116;
    L53:
        return (String) r118;
    L51:
        FLogger.f375446a.e("OfficePreviewResolver", "mergeMissingQueryParams failed: " + r117.getMessage());
        r118 = r100;
        goto L53
    L28:
        if (r113.length() == 0) goto L31;
        r114 = false;
    L46:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static b h(c r100, String r101) {
        OfficePreviewType r102 = OfficePreviewType.UNKNOWN;
        r100.getClass();
        if (l(r101) == true) goto L35;
        Uri r103 = UriProtector.parse(r101);
        if (c(r103.getHost()) == false) goto L35;
        a r104 = g(r103.getPathSegments());
        if (r104 == null) goto L35;
        String r105 = r104.f361027a;
        if (i(r105, r102) == false) goto L35;
        OfficePreviewType r106 = OfficePreviewType.DOCX;
        if (Intrinsics.areEqual(r105, r106.getRouteType()) == true) goto L33;
        r106 = OfficePreviewType.SHEETS;
        if (Intrinsics.areEqual(r105, r106.getRouteType()) == true) goto L33;
        r106 = OfficePreviewType.SLIDES;
        if (Intrinsics.areEqual(r105, r106.getRouteType()) == true) goto L33;
        r106 = OfficePreviewType.BITABLE;
        if (Intrinsics.areEqual(r105, r106.getRouteType()) == true) goto L33;
        r106 = OfficePreviewType.FILE;
        if (Intrinsics.areEqual(r105, r106.getRouteType()) == true) goto L33;
        r106 = OfficePreviewType.WIKI;
        if (Intrinsics.areEqual(r105, r106.getRouteType()) == true) goto L33;
        r106 = r102;
    L33:
        String r107 = r104.f361028b;
        if (r106 == r102) goto L35;
        return new b(r106, r107, r104.f361029c);
    L35:
        return null;
    }

    public static boolean i(String r100, OfficePreviewType r101) {
        switch(C4436c.f361033a[r101.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            default: goto L5;
        };
    L5:
        if (Intrinsics.areEqual(r100, OfficePreviewType.DOCX.getRouteType()) == false) goto L7;
    L24:
        return true;
    L7:
        if (Intrinsics.areEqual(r100, OfficePreviewType.SHEETS.getRouteType()) == true) goto L24;
        if (Intrinsics.areEqual(r100, OfficePreviewType.SLIDES.getRouteType()) == true) goto L24;
        if (Intrinsics.areEqual(r100, OfficePreviewType.BITABLE.getRouteType()) == true) goto L24;
        if (Intrinsics.areEqual(r100, OfficePreviewType.FILE.getRouteType()) == true) goto L24;
        if (Intrinsics.areEqual(r100, OfficePreviewType.WIKI.getRouteType()) == true) goto L24;
        return false;
    L26:
        return Intrinsics.areEqual(r100, OfficePreviewType.WIKI.getRouteType());
    L27:
        return Intrinsics.areEqual(r100, OfficePreviewType.FILE.getRouteType());
    L28:
        return Intrinsics.areEqual(r100, OfficePreviewType.BITABLE.getRouteType());
    L29:
        return Intrinsics.areEqual(r100, OfficePreviewType.SLIDES.getRouteType());
    L30:
        return Intrinsics.areEqual(r100, OfficePreviewType.SHEETS.getRouteType());
    L31:
        return Intrinsics.areEqual(r100, OfficePreviewType.DOCX.getRouteType());
    }

    public static String j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetUrl");
        if (r101 != null) goto L5;
    L10:
        String r102 = null;
    L11:
        if (r102 != null) goto L14;
        return e(r100, r101);
    L14:
        return e(r102, r100);
    L5:
        if (f361026a.b(r101) != OfficePreviewType.WIKI) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        r102 = r101;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public final e k(String r110, Integer r111, String r112) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        String r102 = null;
        if (r101 == false) goto L14;
        return a(r111, r112, null, null, null);
    L14:
        if (l(r110) == false) goto L16;
        return null;
    L16:
        b r103 = h(this, r110);
        if (r103 == null) goto L19;
        OfficePreviewType r104 = r103.f361030a;
        e r113 = new e(r104, r104.getPreviewTypeValue(), r103.f361031b, r110, r110, r110, TemplateNodeType.RAW);
    L22:
        if (r103 != null) goto L24;
    L26:
        boolean r114 = false;
    L27:
        if (r114 == true) goto L95;
        String r115 = r113.f361038d;
        if (r115 == null) goto L96;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L78
        IOfficeSdkServiceV2 r117 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Throwable -> L78
        if (r117 == null) goto L91;
        gk5.e r118 = r117.q0();     // Catch: Throwable -> L78
        if (r118 == null) goto L92;
        String r105 = r118.f6(r115, Integer.valueOf(r113.f361036b));     // Catch: Throwable -> L78
        if (r105 != null) goto L40;
    L43:
        boolean r106 = true;
    L44:
        if (r106 == false) goto L46;
        return r113;
    L46:
        if (Intrinsics.areEqual(r105, r115) == true) goto L94;
        BearUrl r119 = r118.Z(r105);     // Catch: Throwable -> L78
        OfficePreviewType r107 = f(r119.f222560a);     // Catch: Throwable -> L78
        OfficePreviewType r108 = OfficePreviewType.UNKNOWN;     // Catch: Throwable -> L78
        if (r107 == r108) goto L51;
        r100 = true;
    L51:
        if (r100 == true) goto L54;
        r107 = null;
    L54:
        if (r107 != null) goto L61;
        b r109 = h(this, r105);     // Catch: Throwable -> L78
        if (r109 == null) goto L58;
        r107 = r109.f361030a;     // Catch: Throwable -> L78
    L59:
        if (r107 != null) goto L61;
        r107 = r113.f361035a;     // Catch: Throwable -> L78
        goto L61
    L58:
        r107 = null;
    L61:
        OfficePreviewType r120 = r107;
        if (r120 == r108) goto L64;
        int r121 = r120.getPreviewTypeValue();     // Catch: Throwable -> L78
    L65:
        String r122 = r119.f222561b;     // Catch: Throwable -> L78
        if (r122 != null) goto L68;
    L71:
        b r123 = h(this, r105);     // Catch: Throwable -> L78
        if (r123 == null) goto L74;
        String r124 = r123.f361031b;     // Catch: Throwable -> L78
    L75:
        r102 = r124;
    L76:
        String r125 = e(r105, r115);     // Catch: Throwable -> L78
        Object r126 = Result.m9449constructorimpl(new e(r120, r121, r102, r125, r113.f361039e, r125, ChameleonResConstants.CCM_ROOT_DIR));     // Catch: Throwable -> L78
    L80:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L83;
        FLogger r128 = FLogger.f375446a;
        StringBuilder r129 = new StringBuilder("resolveByCcm failed: token=");
        int r130 = f.f361173a;
        r129.append(f.b(r113.f361037c));
        r129.append(", msg=");
        r129.append(r127.getMessage());
        r128.w("OfficePreviewResolver", r129.toString());
    L83:
        Object r131 = r113;
        if (Result.m9455isFailureimpl(r126) == true) goto L88;
        r131 = r126;
    L88:
        return (e) r131;
    L74:
        r124 = r113.f361037c;     // Catch: Throwable -> L78
        goto L75
    L68:
        if ((true ^ StringsKt.isBlank(r122)) == false) goto L70;
        r102 = r122;
    L70:
        if (r102 != null) goto L76;
    L64:
        r121 = r113.f361036b;     // Catch: Throwable -> L78
        goto L65
    L94:
        return r113;
    L40:
        if (StringsKt.isBlank(r105) == true) goto L43;
        r106 = false;
        goto L44
    L92:
        return r113;
    L91:
        return r113;
    L78:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L80
    L96:
        return r113;
    L95:
        return r113;
    L24:
        if (r103.f361032c != true) goto L26;
        r114 = true;
        goto L27
    L19:
        e r133 = a(r111, r112, r110, r110, r110);
        r113 = r133;
        if (r133 != null) goto L22;
        return null;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static e a(Integer r110, String r111, String r112, String r113, String r114) {
        OfficePreviewType r100 = null;
        if (r111 != null) goto L5;
    L37:
        return null;
    L5:
        if ((!StringsKt.isBlank(r111)) == false) goto L7;
        String r101 = r111;
    L8:
        if (r101 == null) goto L37;
        if (r110 == null) goto L37;
        int r102 = r110.intValue();
        if (r102 != 2) goto L14;
    L31:
        r100 = OfficePreviewType.DOCX;
    L32:
        if (r100 != null) goto L34;
        OfficePreviewType r103 = OfficePreviewType.UNKNOWN;
    L36:
        return new e(r103, r102, r101, r112, r113, r114, "fallback");
    L34:
        r103 = r100;
        goto L36
    L14:
        if (r102 != 3) goto L16;
        r100 = OfficePreviewType.SHEETS;
        goto L32
    L16:
        if (r102 != 8) goto L18;
        r100 = OfficePreviewType.BITABLE;
        goto L32
    L18:
        if (r102 != 12) goto L20;
        r100 = OfficePreviewType.FILE;
        goto L32
    L20:
        if (r102 != 16) goto L22;
        r100 = OfficePreviewType.WIKI;
        goto L32
    L22:
        if (r102 == 22) goto L31;
        if (r102 != 30) goto L32;
        r100 = OfficePreviewType.SLIDES;
        goto L32
    L7:
        r101 = null;
        goto L8
    }
}
