package com.larus.larkfeed.impl.gallery;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.OpenFeishuGalleryPermissionState;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f355202d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kza.a f355204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bza.a f355205c;

    public static final class a {
        public a() {
        }
    }

    static {
        f355202d = new a();
    }

    public final boolean b() {
        Object r100 = xp9.o.f564776a;
        Object r101 = xp9.o.f564776a;
        String r102 = null;
        if ((r101 instanceof OfficeSDKUserApi) == false) goto L5;
        OfficeSDKUserApi r103 = (OfficeSDKUserApi) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.getUserId();
    L8:
        String r104 = this.f355203a;
        if (r104 != null) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(r104, r102) == false) goto L13;
        return true;
    L5:
        r103 = null;
        goto L6
    }

    public static PreviewState d(kza.m r100) {
        if (r100 == null) goto L4;
        kza.o r101 = r100.f506783g;
    L5:
        if (r101 == null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        if (r100 == null) goto L33;
        kza.o r103 = r100.f506783g;
        if (r103 == null) goto L33;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        OpenFeishuGalleryPermissionState.a r104 = OpenFeishuGalleryPermissionState.Companion;
        int r105 = r103.f506790a;
        r104.getClass();
        OpenFeishuGalleryPermissionState r106 = OpenFeishuGalleryPermissionState.a.a(r105);
        if (r106 != OpenFeishuGalleryPermissionState.MIDDLE_AUTHORIZATION_STATE) goto L18;
        PreviewState r107 = PreviewState.Loading;
    L31:
        if (r107 == null) goto L33;
        return r107;
    L18:
        if (r106 != OpenFeishuGalleryPermissionState.FINAL_AUTHORIZATION_STATE_DENY) goto L21;
        r107 = PreviewState.Deny;
        goto L31
    L21:
        if (r103.f506791b == true) goto L23;
    L30:
        r107 = PreviewState.Deny;
        goto L31
    L23:
        if (r103.f506792c == true) goto L30;
        if (r103.f506793d == true) goto L30;
        if (r103.f506794e == true) goto L30;
        r107 = PreviewState.Allow;
    L33:
        return PreviewState.Allow;
    L10:
        return PreviewState.Allow;
    L7:
        r102 = false;
        goto L8
    L4:
        r101 = null;
        goto L5
    }

    public final void a(kza.m r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getType() == GalleryType.Image) goto L7;
        return;
    L7:
        kza.o r101 = r100.f506783g;
        boolean r102 = true;
        String r103 = null;
        if (r101 == null) goto L37;
        kza.t r104 = r101.f506796g;
        if (r104 == null) goto L37;
        kza.q r105 = r104.f506823b;
        if (r105 == null) goto L23;
        String r106 = r105.f506810b;
        if (r106 == null) goto L23;
        if ((!StringsKt.isBlank(r106)) == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L23;
        r103 = r106;
    L23:
        if (r105 == null) goto L29;
        String r107 = r105.f506809a;
        if (r107 == null) goto L29;
        if ((!StringsKt.isBlank(r107)) == false) goto L29;
    L30:
        if (r107 != null) goto L36;
        String r108 = r104.f506822a.f506817d;
        if (r108 == null) goto L37;
        if ((!StringsKt.isBlank(r108)) == false) goto L37;
        r103 = r108;
        goto L37
    L36:
        r103 = r107;
    L29:
        r107 = null;
    L37:
        bza.a r109 = this.f355205c;
        if (r103 != null) goto L40;
    L45:
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("skip image download audit, keyReady=");
        if (r103 == null) goto L48;
        boolean r112 = true;
    L49:
        r111.append(r112);
        r111.append(" serviceReady=");
        if (r109 != null) goto L53;
        r102 = false;
    L53:
        r111.append(r102);
        r110.w("SocialGalleryMediaSecurityGuard", r111.toString());
        return;
    L48:
        r112 = false;
        goto L49
    L40:
        if (b() == false) goto L45;
        if (r109 == null) goto L45;
        r109.a(r103);
    }

    public static boolean c(kza.m r100, kza.m r101) {
        String r102 = c0.a(r100);
        String r103 = c0.a(r101);
        if (r102 != null) goto L15;
        if (r103 != null) goto L15;
        String r104 = null;
        if (r100 == null) goto L9;
        String r105 = c0.b(r100);
    L10:
        if (r101 == null) goto L13;
        r104 = c0.b(r101);
    L13:
        return Intrinsics.areEqual(r105, r104);
    L9:
        r105 = null;
    L15:
        return Intrinsics.areEqual(r102, r103);
    }

    public b0(String r100, kza.a r101, bza.a r102) {
        this.f355203a = r100;
        this.f355204b = r101;
        this.f355205c = r102;
    }
}
