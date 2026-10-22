package nuc;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.MissingFieldException;

/* JADX INFO: loaded from: classes42.dex */
public final class b2 {
    @InternalSerializationApi
    public static final void a(int[] r100, int[] r101, luc.f r102) {
        Intrinsics.checkNotNullParameter(r100, "seenArray");
        Intrinsics.checkNotNullParameter(r101, "goldenMaskArray");
        Intrinsics.checkNotNullParameter(r102, "descriptor");
        ArrayList r103 = new ArrayList();
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L15;
        int r106 = r101[r105] & (~r100[r105]);
        if (r106 == 0) goto L13;
        int r107 = 0;
    L8:
        if (r107 >= 32) goto L13;
        if ((r106 & 1) == 0) goto L12;
        r103.add(r102.b((r105 * 32) + r107));
    L12:
        r106 = r106 >>> 1;
        r107 = r107 + 1;
    L13:
        r105 = r105 + 1;
        goto L3
    L15:
        throw new MissingFieldException(r103, r102.f());
    }

    @InternalSerializationApi
    public static final void b(int r100, int r101, luc.f r102) {
        Intrinsics.checkNotNullParameter(r102, "descriptor");
        ArrayList r103 = new ArrayList();
        int r104 = (~r100) & r101;
        int r105 = 0;
    L4:
        if (r105 >= 32) goto L10;
        if ((r104 & 1) == 0) goto L8;
        r103.add(r102.b(r105));
    L8:
        r104 = r104 >>> 1;
        r105 = r105 + 1;
        goto L4
    L10:
        throw new MissingFieldException(r103, r102.f());
    }
}
