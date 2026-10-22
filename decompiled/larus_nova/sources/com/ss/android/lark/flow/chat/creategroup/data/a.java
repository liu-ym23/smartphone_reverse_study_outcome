package com.ss.android.lark.flow.chat.creategroup.data;

import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f422041o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f422042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f422043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f422044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f422045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f422046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f422047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f422048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f422049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f422050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f422051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f422052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f422053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f422054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<DeniedReason> f422055n;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.creategroup.data.a$a, reason: collision with other inner class name */
    public static final class C4971a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f422042a == r101.f422042a) goto L12;
        return false;
    L12:
        if (this.f422043b == r101.f422043b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f422044c, r101.f422044c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f422045d, r101.f422045d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f422046e, r101.f422046e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f422047f, r101.f422047f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f422048g, r101.f422048g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f422049h, r101.f422049h) == true) goto L33;
        return false;
    L33:
        if (this.f422050i == r101.f422050i) goto L36;
        return false;
    L36:
        if (this.f422051j == r101.f422051j) goto L39;
        return false;
    L39:
        if (this.f422052k == r101.f422052k) goto L42;
        return false;
    L42:
        if (this.f422053l == r101.f422053l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f422054m, r101.f422054m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f422055n, r101.f422055n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f422042a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f422043b;
        int r103 = (((((((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f422044c.hashCode()) * 31) + this.f422045d.hashCode()) * 31) + this.f422046e.hashCode()) * 31) + this.f422047f.hashCode()) * 31) + this.f422048g.hashCode()) * 31) + this.f422049h.hashCode()) * 31;
        int r104 = 1231;
        if (this.f422050i == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (r103 + r105) * 31;
        if (this.f422051j == false) goto L9;
        int r107 = 1231;
    L10:
        int r108 = (r106 + r107) * 31;
        if (this.f422052k == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        if (this.f422053l == true) goto L18;
        r104 = 1237;
    L18:
        int r111 = (r110 + r104) * 31;
        e r112 = this.f422054m;
        int r113 = 0;
        if (r112 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r111 + r114) * 31;
        List<DeniedReason> r116 = this.f422055n;
        if (r116 == null) goto L27;
        r113 = r116.hashCode();
    L27:
        return r115 + r113;
    L21:
        r114 = r112.hashCode();
        goto L22
    L13:
        r109 = 1237;
        goto L14
    L9:
        r107 = 1237;
        goto L10
    L5:
        r105 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowGroupCreateContactItemModel(feishuUserId=" + this.f422042a + ", dbUserId=" + this.f422043b + ", name=" + this.f422044c + ", alias=" + this.f422045d + ", displayName=" + this.f422046e + ", displayNamePinyin=" + this.f422047f + ", avatarKey=" + this.f422048g + ", doubaoKey=" + this.f422049h + ", isBusinessUser=" + this.f422050i + ", isDeleted=" + this.f422051j + ", isInChat=" + this.f422052k + ", isResigned=" + this.f422053l + ", relation=" + this.f422054m + ", deniedReasons=" + this.f422055n + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(long r110, long r111, String r112, String r113, String r114, String r115, String r116, String r117, boolean r210, boolean r211, boolean r212, boolean r213, e r214, List<? extends DeniedReason> r215) {
        Intrinsics.checkNotNullParameter(r112, "name");
        Intrinsics.checkNotNullParameter(r113, "alias");
        Intrinsics.checkNotNullParameter(r114, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r115, "displayNamePinyin");
        Intrinsics.checkNotNullParameter(r116, "avatarKey");
        Intrinsics.checkNotNullParameter(r117, "doubaoKey");
        this.f422042a = r110;
        this.f422043b = r111;
        this.f422044c = r112;
        this.f422045d = r113;
        this.f422046e = r114;
        this.f422047f = r115;
        this.f422048g = r116;
        this.f422049h = r117;
        this.f422050i = r210;
        this.f422051j = r211;
        this.f422052k = r212;
        this.f422053l = r213;
        this.f422054m = r214;
        this.f422055n = r215;
    }
}
