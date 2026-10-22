package rg4;

import com.bytedance.component.lyric_v2.core.LyricComponentManager$parseCallback$1;
import com.bytedance.component.lyric_v2.util.LyricType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ng4.k;
import ng4.l;
import pg4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements k {
    public b() {
    }

    @Override // ng4.k
    public final void a(l r100, LyricComponentManager$parseCallback$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = r100.f519078j;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        Intrinsics.checkNotNullParameter(r102, "path");
        boolean r104 = false;
        if (r102.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L17;
        r101.a(r100, "file not exist");
        return;
    L17:
        LyricType r107 = r100.f519070b;
        if (StringsKt.endsWith(r102, ".lrc", true) == false) goto L21;
        r107 = LyricType.LRC;
    L23:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f519070b = r107;
        List<d> r108 = null;
        int r109 = a.f537691a[r107.ordinal()];     // Catch: Exception -> L40
        if (r109 != 1) goto L27;
        sg4.c r110 = new sg4.b();     // Catch: Exception -> L40
    L31:
        if (r110 == null) goto L41;
        sg4.d r111 = r110.a(r103);     // Catch: Exception -> L40
        if (r111 == null) goto L41;
        TreeMap<Integer, d> r112 = r111.f541832a;     // Catch: Exception -> L40
        if (r112 == null) goto L41;
        Collection<d> r113 = r112.values();     // Catch: Exception -> L40
        if (r113 == null) goto L41;
        r108 = CollectionsKt.toList(r113);     // Catch: Exception -> L40
        goto L41
    L27:
        if (r109 == 2) goto L29;
        r110 = null;
        goto L31
    L29:
        r110 = new sg4.a();     // Catch: Exception -> L40
    L41:
        List<d> r114 = r108;
        if (r114 != null) goto L44;
    L45:
        r104 = true;
    L46:
        if (r104 == false) goto L48;
        r101.a(r100, "parse empty");
        return;
    L48:
        r100.f519069a = r108;
        r101.b(r100);
        return;
    L44:
        if (r114.isEmpty() == false) goto L46;
    L21:
        if (StringsKt.endsWith(r102, ".krc", true) == false) goto L23;
        r107 = LyricType.KRC;
        goto L23
    L9:
        if (new PolarisFileWrapper(r102).exists() == false) goto L13;
        if (new PolarisFileWrapper(r102).isFile() == false) goto L13;
        r106 = true;
        goto L14
    L5:
        r105 = false;
        goto L6
    }
}
