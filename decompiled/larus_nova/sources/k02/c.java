package k02;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import or2.j;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f501248a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static boolean b() {
        j r100 = ((or2.e) vh6.c.b(or2.e.class)).getCurrentClient();
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isEffectInited());
    L7:
        return Intrinsics.areEqual(r101, Boolean.TRUE);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean a() {
        if (b() == true) goto L6;
        return false;
    L6:
        j r100 = ((or2.e) vh6.c.b(or2.e.class)).getCurrentClient();
        if (r100 == null) goto L9;
        Boolean r101 = Boolean.valueOf(r100.M());
    L11:
        return Intrinsics.areEqual(r101, Boolean.TRUE);
    L9:
        r101 = null;
        goto L11
    }

    public static String[] c(String[] r110) {
        Intrinsics.checkNotNullParameter(r110, "nodes");
        ArrayList r100 = new ArrayList();
        int r101 = r110.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.add(StringsKt.replace$default(r110[r102], MSkiaImageRegionDecoder.FILE_PREFIX, "", false, 4, null));
        r102 = r102 + 1;
        goto L3
    L5:
        Object[] r111 = r100.toArray(new String[0]);
        if (r111 == null) goto L10;
        return (String[]) r111;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
