package pfc;

import android.content.Context;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static boolean a(Context r100, float r101, float r102, float r103, float r104) {
        if (((float) Math.sqrt(Math.pow(r103 - r101, 2.0d) + Math.pow(r104 - r102, 2.0d))) <= (((double) ViewConfiguration.get(r100).getScaledTouchSlop()) * 1.5d)) goto L5;
        return true;
    L5:
        return false;
    }
}
