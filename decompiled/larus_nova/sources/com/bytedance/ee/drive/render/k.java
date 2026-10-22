package com.bytedance.ee.drive.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface k {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f242739a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f242739a == ((a) r100).f242739a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f242739a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Container(showTitleBar=" + this.f242739a + ')';
        }

        public a(boolean r100) {
            this.f242739a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f242740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f242741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f242742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f242743d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f242740a == r101.f242740a) goto L12;
            return false;
        L12:
            if (this.f242741b == r101.f242741b) goto L15;
            return false;
        L15:
            if (this.f242742c == r101.f242742c) goto L18;
            return false;
        L18:
            if (this.f242743d == r101.f242743d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f242740a * 31) + this.f242741b) * 31) + this.f242742c) * 31) + this.f242743d;
        }

        public final String toString() {
            return "Downloading(hintFontSizePx=" + this.f242740a + ", hintFontColorInt=" + this.f242741b + ", progressBgColorInt=" + this.f242742c + ", progressFgColorInt=" + this.f242743d + ')';
        }

        public b(int r100, int r101, int r102, int r103) {
            this.f242740a = r100;
            this.f242741b = r101;
            this.f242742c = r102;
            this.f242743d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f242744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f242745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f242746c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f242744a == r101.f242744a) goto L12;
            return false;
        L12:
            if (this.f242745b == r101.f242745b) goto L15;
            return false;
        L15:
            if (this.f242746c == r101.f242746c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f242744a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f242745b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f242746c;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "DrivePreview(mediaImmersiveEnable=" + this.f242744a + ", thumbnailEnable=" + this.f242745b + ", imageThumbLoadingActionBottomMarginDp=" + this.f242746c + ')';
        }

        public c() {
            this(false, false, 65);
        }

        public c(boolean r100, boolean r101, int r102) {
            this.f242744a = r100;
            this.f242745b = r101;
            this.f242746c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f242747a;

        public d() {
            this(true);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f242747a == ((d) r100).f242747a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f242747a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Fullscreen(enableFooterScrollFullScreen=" + this.f242747a + ')';
        }

        public d(boolean r100) {
            this.f242747a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f242748a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f242748a, ((e) r100).f242748a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Boolean r100 = this.f242748a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "OpenExternal(hideOpenWithOtherAppsButton=" + this.f242748a + ')';
        }

        public e() {
            this(Boolean.FALSE);
        }

        public e(Boolean r100) {
            this.f242748a = r100;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f242749a;

        public f() {
            this(true);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f242749a == ((f) r100).f242749a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f242749a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Text(enableClickFullScreen=" + this.f242749a + ')';
        }

        public f(boolean r100) {
            this.f242749a = r100;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f242750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f242751b;

        public g() {
            this(true, true);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f242750a == r101.f242750a) goto L12;
            return false;
        L12:
            if (this.f242751b == r101.f242751b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f242750a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f242751b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "TitleBarConfig(showNotificationButton=" + this.f242750a + ", showPagerCounter=" + this.f242751b + ')';
        }

        public g(boolean r100, boolean r101) {
            this.f242750a = r100;
            this.f242751b = r101;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f242752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f242753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f242754c;

        public h() {
            boolean r100 = false;
            this(r100, r100, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f242752a == r101.f242752a) goto L12;
            return false;
        L12:
            if (this.f242753b == r101.f242753b) goto L15;
            return false;
        L15:
            if (this.f242754c == r101.f242754c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f242752a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f242753b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f242754c == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Video(enableLandscape=" + this.f242752a + ", enableControllerAutoHideInDriveFilePreview=" + this.f242753b + ", enableVideoControlBarV2=" + this.f242754c + ')';
        }

        public /* synthetic */ h(boolean r100, boolean r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = true;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = true;
        L8:
            this(r100, r101, false);
        }

        public h(boolean r100, boolean r101, boolean r102) {
            this.f242752a = r100;
            this.f242753b = r101;
            this.f242754c = r102;
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
