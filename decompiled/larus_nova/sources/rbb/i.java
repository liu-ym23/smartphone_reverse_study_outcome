package rbb;

import android.graphics.Bitmap;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements g {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f537017a = null;

        static {
            int[] r100 = new int[IconShape.values().length];
            r100[IconShape.CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[IconShape.SQUARE_OUTLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f537017a = r100;
        }
    }

    public i() {
    }

    @Override // rbb.g
    public final Bitmap c(obb.b r100, IconShape r101, obb.a r102) {
        return g.a.b(this, r100, r101, r102);
    }

    @Override // rbb.g
    public final Bitmap a(int r100, String r101, IconShape r102, obb.a r103) {
        Intrinsics.checkNotNullParameter(r102, "shape");
        if (r103 == null) goto L5;
        Bitmap r104 = r103.a();
    L7:
        if (r104 == null) goto L10;
        Log.i("DOCS_ICON_WikiIconProducer", "loadShortCutIcon, use default custom icon, shape= " + r102);
        return r104;
    L10:
        Log.i("DOCS_ICON_WikiIconProducer", "loadShortCutIcon " + r102);
        int r105 = a.f537017a[r102.ordinal()];
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L18;
        int r106 = b.d(r100);
        int r107 = rbb.a.f537002a;
        return rbb.a.b(r106, Integer.valueOf(R.color.icon_n2));
    L18:
        return rbb.a.e(g.a.c(this, r100, r101, r102, r103));
    L17:
        return rbb.a.e(g.a.a(this, r100, r101, r102, r103));
    L5:
        r104 = null;
        goto L7
    }

    @Override // rbb.g
    public final Bitmap b(int r100, String r101, IconShape r102, obb.a r103) {
        Intrinsics.checkNotNullParameter(r102, "shape");
        if (r103 == null) goto L5;
        Bitmap r104 = r103.a();
    L7:
        if (r104 == null) goto L10;
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareOutlineIcon, use default custom icon, shape= " + r102);
        return r104;
    L10:
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareOutlineIcon " + r100);
        int r105 = rbb.a.f537002a;
        return rbb.a.b(R.drawable.ud_icon_wiki_outlined, Integer.valueOf(R.color.icon_n2));
    L5:
        r104 = null;
        goto L7
    }

    @Override // rbb.g
    public final Bitmap d(int r100, String r101, IconShape r102, obb.a r103, Long r104) {
        Intrinsics.checkNotNullParameter(r102, "shape");
        if (r103 == null) goto L5;
        Bitmap r105 = r103.a();
    L6:
        if (r105 == null) goto L9;
        Log.i("DOCS_ICON_WikiIconProducer", "loadCircleIcon, use default custom icon, shape= " + r102);
        return r105;
    L9:
        int r106 = rbb.a.f537002a;
        return rbb.a.c(R.drawable.ud_icon_wiki_colorful, b.a(sbb.e.f541294e.f541317b, null), null);
    L5:
        r105 = null;
        goto L6
    }

    @Override // rbb.g
    public final Bitmap e(int r100, String r101, IconShape r102, obb.a r103, Long r104) {
        Intrinsics.checkNotNullParameter(r102, "shape");
        if (r103 == null) goto L5;
        Bitmap r105 = r103.a();
    L7:
        if (r105 == null) goto L10;
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareIcon, use default custom icon, shape= " + r102);
        return r105;
    L10:
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareIcon " + r100);
        return rbb.a.b(R.drawable.ud_icon_wiki_colorful, null);
    L5:
        r105 = null;
        goto L7
    }
}
