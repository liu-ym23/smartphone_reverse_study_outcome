package com.bytedance.sdk.account.bus.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;

/* JADX INFO: loaded from: classes22.dex */
public final class Version implements Comparable<Version> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f268874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f268875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VersionType f268876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f268877e;

    public static final enum VersionType extends Enum<VersionType> {
        public static final VersionType ALPHA = null;
        public static final VersionType RC = null;
        public static final VersionType STABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionType[] f268878a = null;

        static {
            VersionType r100 = new VersionType("STABLE", 0);
            STABLE = r100;
            VersionType r101 = new VersionType("RC", 1);
            RC = r101;
            VersionType r102 = new VersionType("ALPHA", 2);
            ALPHA = r102;
            f268878a = new VersionType[]{r100, r101, r102};
        }

        public static VersionType[] values() {
            return (VersionType[]) f268878a.clone();
        }

        public static VersionType valueOf(String r100) {
            return (VersionType) r27.a.a(VersionType.class, r100);
        }

        public VersionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Version(String r100) {
        this.f268874b = null;
        this.f268875c = null;
        this.f268876d = VersionType.STABLE;
        this.f268877e = 0;
        this.f268873a = r100;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String[] r101 = r100.split("-");
        this.f268874b = r101[0].split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101.length <= 1) goto L14;
        String[] r102 = r101[1].split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        this.f268875c = r102;
        if ("rc".equalsIgnoreCase(r102[0]) == false) goto L11;
        this.f268876d = VersionType.RC;
        return;
    L11:
        if ("alpha".equalsIgnoreCase(r102[0]) == false) goto L16;
        this.f268876d = VersionType.ALPHA;
        return;
    L16:
        return;
    }

    public final int a(Version r100) {
        int r101 = this.f268877e - r100.f268877e;
        if (r101 == 0) goto L6;
        return r101;
    L6:
        if (TextUtils.isEmpty(this.f268873a) == false) goto L11;
        if (TextUtils.isEmpty(r100.f268873a) == false) goto L11;
        return 0;
    L11:
        if (TextUtils.isEmpty(r100.f268873a) == false) goto L14;
        return 1;
    L14:
        if (TextUtils.isEmpty(this.f268873a) == false) goto L17;
        return -1;
    L17:
        if (this.f268873a.equals(r100.f268873a) == false) goto L19;
        return 0;
    L19:
        int r102 = Math.min(this.f268874b.length, r100.f268874b.length);
        int r103 = 0;
    L20:
        if (r103 >= r102) goto L26;
        int r104 = CastIntegerProtector.parseInt(this.f268874b[r103]) - CastIntegerProtector.parseInt(r100.f268874b[r103]);
        if (r104 != 0) goto L23;
        r103 = r103 + 1;
        goto L20
    L23:
        return r104;
    L26:
        if (this.f268874b.length <= r102) goto L29;
        return 1;
    L29:
        if (r100.f268874b.length <= r102) goto L31;
        return -1;
    L31:
        VersionType r105 = this.f268876d;
        VersionType r106 = VersionType.STABLE;
        if (r105 == r106) goto L34;
    L36:
        VersionType r107 = VersionType.RC;
        if (r105 == r107) goto L39;
    L40:
        VersionType r108 = VersionType.ALPHA;
        if (r105 == r108) goto L43;
    L46:
        if (r105 != r106) goto L49;
        return 1;
    L49:
        if (r100.f268876d != r106) goto L51;
        return -1;
    L51:
        if (r105 != r107) goto L53;
        return 1;
    L53:
        return -1;
    L43:
        if (r100.f268876d != r108) goto L46;
    L45:
        return CastIntegerProtector.parseInt(this.f268875c[1]) - CastIntegerProtector.parseInt(r100.f268875c[1]);
    L39:
        if (r100.f268876d == r107) goto L45;
    L34:
        if (r100.f268876d != r106) goto L36;
        return 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Version r100) {
        return a(r100);
    }
}
