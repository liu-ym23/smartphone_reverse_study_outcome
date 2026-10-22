package com.larus.gallery.api;

import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.larkfeed.impl.gallery.d0;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class p {

    public static final class a<T> extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f343876a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f343876a, ((a) r100).f343876a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f343876a.hashCode();
        }

        public final String toString() {
            return "AppendItems(newData=" + this.f343876a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "newData");
            this.f343876a = r100;
        }
    }

    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f343877a = null;

        static {
            f343877a = new b();
        }

        public b() {
        }
    }

    public static final class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f343878a = null;

        static {
            f343878a = new c();
        }

        public c() {
        }
    }

    public static final class d extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f343879a = null;

        static {
            f343879a = new d();
        }

        public d() {
        }
    }

    public static final class e extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f343880a = null;

        static {
            f343880a = new e();
        }

        public e() {
        }
    }

    public static final class f extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f343881a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f343881a, ((f) r100).f343881a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f343881a.hashCode();
        }

        public final String toString() {
            return "PreviewChanged(changeWay=" + this.f343881a + ')';
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "changeWay");
            this.f343881a = r100;
        }
    }

    public static final class g extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f343882a = null;

        static {
            f343882a = new g();
        }

        public g() {
        }
    }

    public static final class h extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f343883a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.f343883a == ((h) r100).f343883a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f343883a;
        }

        public final String toString() {
            return "RemoveItemAt(position=" + this.f343883a + ')';
        }

        public h(int r100) {
            this.f343883a = r100;
        }
    }

    public static final class i extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Object, Boolean> f343884a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f343884a, ((i) r100).f343884a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f343884a.hashCode();
        }

        public final String toString() {
            return "RemoveItems(predicate=" + this.f343884a + ')';
        }

        public i(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "predicate");
            this.f343884a = r100;
        }
    }

    public static final class j<T> extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f343885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f343886b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (Intrinsics.areEqual(this.f343885a, r101.f343885a) == true) goto L12;
            return false;
        L12:
            if (this.f343886b == r101.f343886b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f343885a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f343886b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReplaceCurrentItem(newData=" + this.f343885a + ", refreshVisibleMedia=" + this.f343886b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public j(xy8.d r100, boolean r101) {
            this.f343885a = r100;
            this.f343886b = r101;
        }
    }

    public static final class k extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f343887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageInfo f343888b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (this.f343887a == r101.f343887a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f343888b, r101.f343888b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f343887a * 31;
            ImageInfo r101 = this.f343888b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TriggerCurrentImageInfo(position=" + this.f343887a + ", imageInfo=" + this.f343888b + ')';
        }

        public k(int r100, ImageInfo r101) {
            this.f343887a = r100;
            this.f343888b = r101;
        }
    }

    public p() {
    }
}
