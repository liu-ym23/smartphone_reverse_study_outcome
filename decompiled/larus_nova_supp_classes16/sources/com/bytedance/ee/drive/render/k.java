package com.bytedance.ee.drive.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface k {

    public static final class a {
        public final boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Container(showTitleBar=" + this.a + ')';
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "Downloading(hintFontSizePx=" + this.a + ", hintFontColorInt=" + this.b + ", progressBgColorInt=" + this.c + ", progressFgColorInt=" + this.d + ')';
        }

        public b(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c {
        public final boolean a;
        public final boolean b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return ((r2 + r1) * 31) + this.c;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "DrivePreview(mediaImmersiveEnable=" + this.a + ", thumbnailEnable=" + this.b + ", imageThumbLoadingActionBottomMarginDp=" + this.c + ')';
        }

        public c() {
            this(false, false, 65);
        }

        public c(boolean r1, boolean r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d {
        public final boolean a;

        public d() {
            this(true);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.a == ((d) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Fullscreen(enableFooterScrollFullScreen=" + this.a + ')';
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public static final class e {
        public final Boolean a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Boolean r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "OpenExternal(hideOpenWithOtherAppsButton=" + this.a + ')';
        }

        public e() {
            this(Boolean.FALSE);
        }

        public e(Boolean r1) {
            this.a = r1;
        }
    }

    public static final class f {
        public final boolean a;

        public f() {
            this(true);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.a == ((f) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Text(enableClickFullScreen=" + this.a + ')';
        }

        public f(boolean r1) {
            this.a = r1;
        }
    }

    public static final class g {
        public final boolean a;
        public final boolean b;

        public g() {
            this(true, true);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "TitleBarConfig(showNotificationButton=" + this.a + ", showPagerCounter=" + this.b + ')';
        }

        public g(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public h() {
            boolean r0 = false;
            this(r0, r0, 7);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == true) goto L15;
            r1 = 1237;
        L15:
            return r4 + r1;
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Video(enableLandscape=" + this.a + ", enableControllerAutoHideInDriveFilePreview=" + this.b + ", enableVideoControlBarV2=" + this.c + ')';
        }

        public /* synthetic */ h(boolean r3, boolean r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = true;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = true;
        L8:
            this(r3, r4, false);
        }

        public h(boolean r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    b a();

    d b();

    e c();

    c d();

    a getContainer();

    f getText();

    g getTitleBar();

    h getVideo();
}
