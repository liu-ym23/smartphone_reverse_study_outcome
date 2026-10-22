package com.bytedance.ee.bear.list.more.more3;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f228777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f228778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccountService$Account f228779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f228780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f228781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f228782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.list.list.f.a f228783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f228784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f228785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ShareFolderUserPermission f228786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f228787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f228788l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f228777a, r101.f228777a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f228778b, r101.f228778b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f228779c, r101.f228779c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f228780d, r101.f228780d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f228781e, r101.f228781e) == true) goto L24;
        return false;
    L24:
        if (this.f228782f == r101.f228782f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f228783g, r101.f228783g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f228784h, r101.f228784h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f228785i, r101.f228785i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f228786j, r101.f228786j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f228787k, r101.f228787k) == true) goto L42;
        return false;
    L42:
        if (this.f228788l == r101.f228788l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f228777a.hashCode() * 31) + this.f228778b.hashCode()) * 31) + this.f228779c.hashCode()) * 31;
        String r101 = this.f228780d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f228781e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f228782f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        com.bytedance.ee.bear.list.list.f.a r110 = this.f228783g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f228784h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f228785i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ShareFolderUserPermission r119 = this.f228786j;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f228787k;
        if (r122 == null) goto L35;
        r102 = r122.hashCode();
    L35:
        return ((r121 + r102) * 31) + this.f228788l;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShowMoreV3Param(fragment=" + this.f228777a + ", document=" + this.f228778b + ", account=" + this.f228779c + ", module=" + this.f228780d + ", submodule=" + this.f228781e + ", isGrid=" + this.f228782f + ", delegate=" + this.f228783g + ", listType=" + this.f228784h + ", parentToken=" + this.f228785i + ", parentPermission=" + this.f228786j + ", parentShareFolder=" + this.f228787k + ", position=" + this.f228788l + ')';
    }

    public /* synthetic */ m(Fragment r110, Document r111, AccountService$Account r112, String r113, String r114, boolean r115, com.bytedance.ee.bear.list.list.f.a r210, String r211) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, null, null, null, 0);
    }

    public m(Fragment r100, Document r101, AccountService$Account r102, String r103, String r104, boolean r105, com.bytedance.ee.bear.list.list.f.a r106, String r107, String r110, ShareFolderUserPermission r111, Boolean r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "document");
        Intrinsics.checkNotNullParameter(r102, "account");
        this.f228777a = r100;
        this.f228778b = r101;
        this.f228779c = r102;
        this.f228780d = r103;
        this.f228781e = r104;
        this.f228782f = r105;
        this.f228783g = r106;
        this.f228784h = r107;
        this.f228785i = r110;
        this.f228786j = r111;
        this.f228787k = r112;
        this.f228788l = r113;
    }
}
