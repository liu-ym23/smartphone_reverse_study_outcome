package sma;

import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542607a = 0;

    static {
    }

    public static c a(CharSequence r110, TextPaint r111, float r112, TextUtils.TruncateAt r113, Function1 r114, Function1 r115) {
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r111, "paint");
        Intrinsics.checkNotNullParameter(r114, "startXForWidth");
        Intrinsics.checkNotNullParameter(r115, "gradientFactory");
        if (r113 != null) goto L5;
    L7:
        CharSequence r100 = r110;
    L8:
        char[] r101 = r100.toString().toCharArray();
        float[] r102 = new float[r101.length];
        if (r101.length != 0) goto L11;
        boolean r103 = true;
    L13:
        if ((!r103) == false) goto L15;
        r111.getTextWidths(r101, 0, r101.length, r102);
    L15:
        float r116 = ArraysKt.sum(r102);
        c r104 = new c(r110, r100, r101, r102, r112, r113, r111.getTextSize(), r116, ((Number) r114.invoke(Float.valueOf(r116))).floatValue());
        r104.f542606j = (LinearGradient) r115.invoke(r104);
        return r104;
    L11:
        r103 = false;
        goto L13
    L5:
        if (r112 <= 0.0f) goto L7;
        r100 = TextUtils.ellipsize(r110, r111, r112, r113);
        goto L8
    }
}
