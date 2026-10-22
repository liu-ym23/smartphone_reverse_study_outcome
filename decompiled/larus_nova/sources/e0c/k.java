package e0c;

import android.app.Application;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k {
    public static final <T> T a(Application r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) ((DwarfSPIEntryPoint) EntryPoints.get(r100, DwarfSPIEntryPoint.class)).dwarfSPI().get(r101);
    }

    public static final <T> T b(l r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) ((DwarfSPIEntryPoint) EntryPoints.get(r100, DwarfSPIEntryPoint.class)).dwarfSPI().get(r101);
    }
}
