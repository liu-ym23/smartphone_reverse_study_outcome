package com.bytedance.creativex.mediaimport.repository.api;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;
import ki4.r;
import ki4.z;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ri4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final r a(IFolderItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        IGroupItem r101 = (IGroupItem) CollectionsKt.firstOrNull(IFolderItem.a.a(r100, null, 3));
        if (r101 == null) goto L8;
        List<r> r102 = r101.x();
        if (r102 != null) goto L7;
        return null;
    L7:
        return (r) CollectionsKt.firstOrNull(r102);
    L8:
        return null;
    }

    public static final String b(IMediaItem r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.getFolderName();
        if (r100 != null) goto L24;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (b.b() == false) goto L13;
        String r111 = r110.getRelativePath();
        if (r111 != null) goto L9;
    L19:
        String r101 = "Unknown";
    L20:
        String r102 = (String) CollectionsKt.lastOrNull(StringsKt.split$default(r101, new String[]{File.separator}, false, 0, 6, null));
        if (r102 == null) goto L23;
        return r102;
    L23:
        return "Unknown";
    L9:
        if (StringsKt.endsWith$default(r111, File.separator, false, 2, null) == false) goto L11;
        r111 = StringsKt.dropLast(r111, 1);
    L11:
        if (r111 == null) goto L19;
    L18:
        r101 = r111;
        goto L20
    L13:
        File r112 = new PolarisFileWrapper(r110.getPath()).getParentFile();
        if (r112 == null) goto L19;
        r111 = r112.getPath();
        if (r111 != null) goto L18;
    L24:
        return r100;
    }

    public static final boolean c(z r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        BuiltInMaterialType r101 = r100.a();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101 != BuiltInMaterialType.IMAGE) goto L5;
    L10:
        return true;
    L5:
        if (r101 == BuiltInMaterialType.VIDEO) goto L10;
        if (r101 == BuiltInMaterialType.ALL) goto L10;
        return false;
    }

    public static final boolean d(r r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getType() != MediaType.VIDEO) goto L5;
        return true;
    L5:
        return false;
    }
}
