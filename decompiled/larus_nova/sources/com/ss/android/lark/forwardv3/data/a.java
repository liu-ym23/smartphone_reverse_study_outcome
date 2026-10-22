package com.ss.android.lark.forwardv3.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f425305g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f425306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f425307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f425308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f425309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f425310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f425311f;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.data.a$a, reason: collision with other inner class name */
    public static final class C5023a {
        public static String a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "titleBarShowInfo");
            StringBuilder r101 = new StringBuilder("title bar show info is:\n");
            r101.append("   right view show: " + r100.f425306a + '\n');
            r101.append("   right view enable: " + r100.f425307b + '\n');
            r101.append("   right view text: " + r100.f425308c + '\n');
            StringBuilder r102 = new StringBuilder("   left view show: ");
            if (r100.f425310e == false) goto L5;
            String r103 = "Cancel";
        L6:
            r102.append(r103);
            r102.append('\n');
            r101.append(r102.toString());
            StringBuilder r104 = new StringBuilder("   right view click action: ");
            ActionMode.a r105 = ActionMode.Companion;
            int r106 = r100.f425311f;
            r105.getClass();
            if (r106 != 0) goto L9;
            String r107 = "SINGLE_CHOICE";
        L16:
            r104.append(r107);
            r104.append('\n');
            r101.append(r104.toString());
            return r101.toString();
        L9:
            if (r106 != 1) goto L11;
            r107 = "MULTIPLE_CHOICE";
            goto L16
        L11:
            if (r106 == 2) goto L13;
            r107 = "UNDONE";
            goto L16
        L13:
            r107 = "DONE";
            goto L16
        L5:
            r103 = "X";
            goto L6
        }
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
        if (this.f425306a == r101.f425306a) goto L12;
        return false;
    L12:
        if (this.f425307b == r101.f425307b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f425308c, r101.f425308c) == true) goto L18;
        return false;
    L18:
        if (this.f425309d == r101.f425309d) goto L21;
        return false;
    L21:
        if (this.f425310e == r101.f425310e) goto L24;
        return false;
    L24:
        if (this.f425311f == r101.f425311f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f425306a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f425307b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((r102 + r103) * 31) + this.f425308c.hashCode()) * 31) + this.f425309d) * 31;
        if (this.f425310e == true) goto L15;
        r100 = 1237;
    L15:
        return ((r104 + r100) * 31) + this.f425311f;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TitleBarShowInfo(isShow=" + this.f425306a + ", isEnable=" + this.f425307b + ", text=" + this.f425308c + ", textColorResId=" + this.f425309d + ", isCancelState=" + this.f425310e + ", action=" + this.f425311f + ')';
    }

    public a(boolean r100, boolean r101, String r102, int r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f425306a = r100;
        this.f425307b = r101;
        this.f425308c = r102;
        this.f425309d = r103;
        this.f425310e = r104;
        this.f425311f = r105;
    }
}
