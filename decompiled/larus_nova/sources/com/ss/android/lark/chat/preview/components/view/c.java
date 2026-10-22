package com.ss.android.lark.chat.preview.components.view;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416185a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f416186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f416187b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f416186a, r101.f416186a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f416187b, r101.f416187b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f416186a) * 31) + Float.floatToIntBits(this.f416187b);
        }

        public final String toString() {
            return "AlignmentResult(iconTranslationY=" + this.f416186a + ", titleTranslationY=" + this.f416187b + ')';
        }

        public a(float r100, float r101) {
            this.f416186a = r100;
            this.f416187b = r101;
        }
    }

    static {
    }
}
