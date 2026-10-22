package com.larus.platform.service.watermark;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f365848a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365848a, ((a) r100).f365848a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365848a.hashCode();
        }

        public final String toString() {
            return "AsBitmap(bitmap=" + this.f365848a + ')';
        }

        public a(Bitmap r100) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            this.f365848a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365849a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365849a, ((b) r100).f365849a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365849a.hashCode();
        }

        public final String toString() {
            return "AsPath(localPath=" + this.f365849a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "localPath");
            this.f365849a = r100;
        }
    }

    public c() {
    }
}
