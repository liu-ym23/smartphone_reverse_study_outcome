package com.larus.platform.service.watermark;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f365846a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365846a, ((a) r100).f365846a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365846a.hashCode();
        }

        public final String toString() {
            return "FromBitmap(bitmap=" + this.f365846a + ')';
        }

        public a(Bitmap r100) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            this.f365846a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.platform.service.watermark.b$b, reason: collision with other inner class name */
    public static final class C4473b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365847a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4473b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365847a, ((C4473b) r100).f365847a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365847a.hashCode();
        }

        public final String toString() {
            return "FromPath(localPath=" + this.f365847a + ')';
        }

        public C4473b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "localPath");
            this.f365847a = r100;
        }
    }

    public b() {
    }
}
