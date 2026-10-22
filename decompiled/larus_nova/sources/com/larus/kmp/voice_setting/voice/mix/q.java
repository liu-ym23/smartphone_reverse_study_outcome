package com.larus.kmp.voice_setting.voice.mix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface q {

    public static final class a implements q {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Float.compare(0.0f, 0.0f) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(0.0f);
        }

        public final String toString() {
            return "ChangePitch(value=0.0)";
        }
    }

    public static final class b implements q {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Float.compare(0.0f, 0.0f) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(0.0f);
        }

        public final String toString() {
            return "ChangeSpeechRate(value=0.0)";
        }
    }

    public static final class c implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f353903a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f353903a, ((c) r100).f353903a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f353903a);
        }

        public final String toString() {
            return "CommitPitch(value=" + this.f353903a + ')';
        }

        public c(float r100) {
            this.f353903a = r100;
        }
    }

    public static final class d implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f353904a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f353904a, ((d) r100).f353904a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f353904a);
        }

        public final String toString() {
            return "CommitSpeechRate(value=" + this.f353904a + ')';
        }

        public d(float r100) {
            this.f353904a = r100;
        }
    }

    public static final class e implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f353905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f353906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f353907c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f353905a, r101.f353905a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f353906b, r101.f353906b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f353907c, r101.f353907c) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f353905a.hashCode() * 31) + Float.floatToIntBits(this.f353906b)) * 31) + Float.floatToIntBits(this.f353907c);
        }

        public final String toString() {
            return "ReportEditResult(scene=" + this.f353905a + ", pitch=" + this.f353906b + ", rate=" + this.f353907c + ')';
        }

        public e(String r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f353905a = r100;
            this.f353906b = r101;
            this.f353907c = r102;
        }
    }

    public static final class f implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f353908a = null;

        static {
            f353908a = new f();
        }

        public f() {
        }
    }

    public static final class g implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f353909a = null;

        static {
            f353909a = new g();
        }

        public g() {
        }
    }
}
