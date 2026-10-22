package h18;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483540a = 0;

    static {
    }

    public static Typeface a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedArray r101 = r100.obtainStyledAttributes(0, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        int r102 = r101.getResourceId(10, 0);
        if (r102 > 0) goto L12;
        Typeface r103 = Typeface.DEFAULT;
    L8:
        if (r103 != null) goto L10;
        r103 = Typeface.DEFAULT;
    L10:
        r101.recycle();
        return r103;
    L12:
        r103 = ResourcesCompat.getFont(r100, r102);     // Catch: Resources.NotFoundException -> L6
    L6:
        r103 = Typeface.DEFAULT;
        goto L8
    }

    public static Typeface b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Typeface.create(a(r100), r101);
    }
}
