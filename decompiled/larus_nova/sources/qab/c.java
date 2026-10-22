package qab;

import android.content.Context;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static int a(Context r100, int r101) {
        return r100.getResources().getColor(r101);
    }

    public static String b(Context r100, int r101, int r102) {
        return r100.getResources().getQuantityString(r101, r102, new Object[]{Integer.valueOf(r102)});
    }
}
