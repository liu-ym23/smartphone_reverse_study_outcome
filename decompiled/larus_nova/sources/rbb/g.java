package rbb;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface g {

    public static final class a {
        public static Bitmap b(g r100, obb.b r101, IconShape r102, obb.a r110) {
            Intrinsics.checkNotNullParameter(r101, "meta");
            Intrinsics.checkNotNullParameter(r102, "shape");
            if (r110 == null) goto L5;
            boolean r103 = Intrinsics.areEqual(r110.f522630a, Boolean.TRUE);
        L6:
            if (r103 == false) goto L9;
            return r100.a(r101.getType(), r101.f522639c, r102, r110);
        L9:
            if (r102 != IconShape.CIRCLE) goto L12;
            return r100.d(r101.getType(), r101.f522639c, r102, r110, r101.f522645i);
        L12:
            if (r102 != IconShape.SQUARE) goto L15;
            return r100.e(r101.getType(), r101.f522639c, r102, r110, r101.f522645i);
        L15:
            return r100.b(r101.getType(), r101.f522639c, r102, r110);
        L5:
            r103 = false;
            goto L6
        }

        public static /* synthetic */ Bitmap a(g r100, int r101, String r102, IconShape r103, obb.a r110) {
            return r100.d(r101, r102, r103, r110, null);
        }

        public static /* synthetic */ Bitmap c(g r100, int r101, String r102, IconShape r103, obb.a r110) {
            return r100.e(r101, r102, r103, r110, null);
        }
    }

    Bitmap a(int r100, String r101, IconShape r102, obb.a r103);

    Bitmap b(int r100, String r101, IconShape r102, obb.a r103);

    Bitmap c(obb.b r100, IconShape r101, obb.a r102);

    Bitmap d(int r100, String r101, IconShape r102, obb.a r103, Long r104);

    Bitmap e(int r100, String r101, IconShape r102, obb.a r103, Long r104);
}
