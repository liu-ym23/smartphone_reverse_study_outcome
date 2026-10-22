package mh2;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class r {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f513936a = null;

        static {
            f513936a = new a();
        }

        public a() {
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f513937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f513938b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f513937a == r101.f513937a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f513938b, r101.f513938b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f513937a * 31;
            Bitmap r101 = this.f513938b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "SuccessBitmap(index=" + this.f513937a + ", bitmap=" + this.f513938b + ")";
        }

        public b(int r100, Bitmap r101) {
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            this.f513937a = r100;
            this.f513938b = r101;
        }
    }

    public r() {
    }
}
