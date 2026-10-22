package sra;

import android.content.Intent;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements ora.a {
    public b() {
    }

    public static String b(Intent r100) {
        if (r100 != null) goto L4;
        return "null";
    L4:
        StringBuilder r101 = new StringBuilder(128);
        r101.append("Intent { ");
        wra.b.c(r100, r101);
        r101.append(" }");
        return r101.toString();
    }

    @Override // ora.a
    public final /* bridge */ /* synthetic */ String a(Object r100) {
        return b((Intent) r100);
    }
}
