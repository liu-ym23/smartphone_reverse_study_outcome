package com.ss.android.lark.keyboard.edittext2.span;

import android.text.Editable;

/* JADX INFO: loaded from: classes36.dex */
public interface k {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f429225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f429226b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f429225a == r101.f429225a) goto L12;
            return false;
        L12:
            if (this.f429226b == r101.f429226b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f429225a * 31) + this.f429226b;
        }

        public final String toString() {
            return "SelectResult(updateStart=" + this.f429225a + ", updateEnd=" + this.f429226b + ')';
        }

        public a(int r100, int r101) {
            this.f429225a = r100;
            this.f429226b = r101;
        }
    }

    a e(int r100, int r101, Editable r102);
}
