package com.larus.canvas.feature.component.resultdisplay.image;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface s extends com.larus.canvas.feature.component.base.b {

    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f323562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f323563b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f323562a, r101.f323562a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f323563b, r101.f323563b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f323562a.hashCode() * 31) + this.f323563b.hashCode();
        }

        public final String toString() {
            return "OnClickCompare(data=" + this.f323562a + ", clickFrom=" + this.f323563b + ')';
        }

        public a(y r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "clickFrom");
            this.f323562a = r100;
            this.f323563b = r101;
        }
    }

    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f323564a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f323564a, ((b) r100).f323564a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f323564a.hashCode();
        }

        public final String toString() {
            return "OnClickRegenerate(data=" + this.f323564a + ')';
        }

        public b(y r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f323564a = r100;
        }
    }

    public static final class c implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f323565a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f323565a, ((c) r100).f323565a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f323565a.hashCode();
        }

        public final String toString() {
            return "OnClickSave(data=" + this.f323565a + ')';
        }

        public c(y r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f323565a = r100;
        }
    }

    public static final class d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f323566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f323567b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f323566a, r101.f323566a) == true) goto L12;
            return false;
        L12:
            if (this.f323567b == r101.f323567b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f323566a.hashCode() * 31;
            if (this.f323567b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "OnImageLoaded(data=" + this.f323566a + ", isSuccess=" + this.f323567b + ')';
        }

        public d(y r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f323566a = r100;
            this.f323567b = r101;
        }
    }

    public static final class e implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f323568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f323569b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f323568a, r101.f323568a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f323569b, r101.f323569b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f323568a.hashCode() * 31) + this.f323569b.hashCode();
        }

        public final String toString() {
            return "OnItemClick(data=" + this.f323568a + ", view=" + this.f323569b + ')';
        }

        public e(y r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f323568a = r100;
            this.f323569b = r101;
        }
    }

    public static final class f implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f323570a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f323570a, ((f) r100).f323570a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f323570a.hashCode();
        }

        public final String toString() {
            return "OnItemLongClick(data=" + this.f323570a + ')';
        }

        public f(y r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f323570a = r100;
        }
    }

    public static final class g implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f323571a = null;

        static {
            f323571a = new g();
        }

        public g() {
        }
    }
}
