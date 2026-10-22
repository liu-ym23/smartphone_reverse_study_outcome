package dy6;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends e<Boolean> {
    @Override // dy6.e
    public final Boolean b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((r100 instanceof Boolean) == false) goto L5;
        Boolean r101 = (Boolean) r100;
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (Boolean) super.b(r100);
    L5:
        r101 = null;
        goto L6
    }

    @Override // dy6.e
    public final Boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        int r101 = r100.hashCode();
        if (r101 == 48) goto L22;
        if (r101 == 49) goto L18;
        if (r101 == 3569038) goto L15;
        if (r101 == 97196323) goto L12;
    L23:
        return null;
    L12:
        if (r100.equals("false") == false) goto L23;
    L25:
        return Boolean.FALSE;
    L15:
        if (r100.equals("true") == false) goto L23;
    L26:
        return Boolean.TRUE;
    L18:
        if (r100.equals("1") == true) goto L26;
    L22:
        if (r100.equals("0") == true) goto L25;
        goto L23
    }

    public a(Bundle r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        a(r100, r101, r102);
    }
}
