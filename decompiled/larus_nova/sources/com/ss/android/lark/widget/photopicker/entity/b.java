package com.ss.android.lark.widget.photopicker.entity;

import com.ss.android.lark.pb.pan.ImageOCRResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageOCRResponse f447514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f447515b;

        public /* synthetic */ a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f447514a, r101.f447514a) == true) goto L12;
            return false;
        L12:
            if (this.f447515b == r101.f447515b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f447514a.hashCode() * 31;
            if (this.f447515b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Finish(ocrResponse=" + this.f447514a + ", showOCRMask=" + this.f447515b + ')';
        }

        public a(ImageOCRResponse r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "ocrResponse");
            this.f447514a = r100;
            this.f447515b = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photopicker.entity.b$b, reason: collision with other inner class name */
    public static final class C5418b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5418b f447516a = null;

        static {
            f447516a = new C5418b();
        }

        public C5418b() {
        }
    }
}
