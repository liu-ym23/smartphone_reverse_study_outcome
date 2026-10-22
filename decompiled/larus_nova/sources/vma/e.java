package vma;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final <T extends View> T a(Context r100, int r101, Function3<? super Context, ? super Integer, ? super Integer, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "ofStyle");
        ContextThemeWrapper r103 = new ContextThemeWrapper(r100, r101);
        TypedArray r104 = r103.obtainStyledAttributes(null, new int[]{R.attr.layout_width, R.attr.layout_height}, 0, r101);
        int r105 = r104.getLayoutDimension(0, -2);     // Catch: Throwable -> L6
        int r106 = r104.getLayoutDimension(1, -2);     // Catch: Throwable -> L6
        T r107 = r102.invoke(r103, Integer.valueOf(r105), Integer.valueOf(r106));     // Catch: Throwable -> L6
        r104.recycle();
        return r107;
    L6:
        th = move-exception;
        r104.recycle();
        throw th;
    }
}
