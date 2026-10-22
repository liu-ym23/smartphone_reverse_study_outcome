package com.ss.android.lark.image.compose.common.avatar;

import androidx.compose.ui.graphics.painter.Painter;
import com.ss.android.lark.image.compose.android_platform.DrawablePainter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f426266a = null;

        static {
            f426266a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -1759575281;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Painter f426267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.image.compose.common.avatar.b f426268b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f426267a, r101.f426267a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f426268b, r101.f426268b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Painter r100 = this.f426267a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f426268b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(painter=" + this.f426267a + ", result=" + this.f426268b + ')';
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return this.f426267a;
        }

        public b(Painter r100) {
            com.ss.android.lark.image.compose.common.avatar.b r101 = com.ss.android.lark.image.compose.common.avatar.b.f426265a;
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f426267a = r100;
            this.f426268b = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.image.compose.common.avatar.c$c, reason: collision with other inner class name */
    public static final class C5043c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Painter f426269a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5043c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426269a, ((C5043c) r100).f426269a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Painter r100 = this.f426269a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Loading(painter=" + this.f426269a + ')';
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return this.f426269a;
        }

        public C5043c(Painter r100) {
            this.f426269a = r100;
        }
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Painter f426270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.image.compose.common.avatar.d f426271b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f426270a, r101.f426270a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f426271b, r101.f426271b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f426270a.hashCode() * 31) + this.f426271b.hashCode();
        }

        public final String toString() {
            return "Success(painter=" + this.f426270a + ", result=" + this.f426271b + ')';
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return this.f426270a;
        }

        public d(DrawablePainter r100) {
            com.ss.android.lark.image.compose.common.avatar.d r101 = com.ss.android.lark.image.compose.common.avatar.d.f426272a;
            Intrinsics.checkNotNullParameter(r100, "painter");
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f426270a = r100;
            this.f426271b = r101;
        }
    }

    Painter a();
}
