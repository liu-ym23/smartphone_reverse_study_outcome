package com.larus.bmhome.bot.share;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f296751a = null;

        static {
            f296751a = new a();
        }

        public a() {
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f296752a = null;

        static {
            f296752a = new b();
        }

        public b() {
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f296753a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f296753a, ((c) r100).f296753a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f296753a.hashCode();
        }

        public final String toString() {
            return "Success(bitmap=" + this.f296753a + ')';
        }

        public c(Bitmap r100) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            this.f296753a = r100;
        }
    }

    public i() {
    }
}
