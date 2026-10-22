package com.larus.bmhome.chat.component.bottom.multimodal;

/* JADX INFO: loaded from: classes25.dex */
public abstract class f1 {

    public static final class a extends f1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f299769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f299770b;

        public a() {
            this(false, 0, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f299769a == r101.f299769a) goto L12;
            return false;
        L12:
            if (this.f299770b == r101.f299770b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f299769a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f299770b;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Album(multiTake=" + this.f299769a + ", landingTabIndex=" + this.f299770b + ')';
        }

        public a(boolean r100, int r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = true;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this.f299769a = r100;
            this.f299770b = r101;
        }
    }

    public static final class b extends f1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f299771a = null;

        static {
            f299771a = new b();
        }

        public b() {
        }
    }

    public static final class c extends f1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f299772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f299773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f299774c;

        public c() {
            this(false, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f299772a == r101.f299772a) goto L12;
            return false;
        L12:
            if (this.f299773b == r101.f299773b) goto L15;
            return false;
        L15:
            if (this.f299774c == r101.f299774c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f299772a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f299773b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f299774c == true) goto L15;
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
            return "FileBrowser(multiTake=" + this.f299772a + ", supportAudio=" + this.f299773b + ", supportAudioOnly=" + this.f299774c + ')';
        }

        public c(boolean r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            boolean r102 = true;
        L7:
            if ((r101 & 2) == 0) goto L9;
            r100 = false;
        L9:
            this.f299772a = r102;
            this.f299773b = r100;
            this.f299774c = false;
            return;
        L5:
            r102 = false;
            goto L7
        }
    }

    public f1() {
    }
}
