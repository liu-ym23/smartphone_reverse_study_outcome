package qb2;

import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    static {
    }

    public static LottieDrawable a(Spanned r100) {
        Intrinsics.checkNotNullParameter(r100, "spanned");
        DynamicDrawableSpan[] r101 = (DynamicDrawableSpan[]) r100.getSpans(0, r100.length(), DynamicDrawableSpan.class);
        if (r101 == null) goto L13;
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        Drawable r105 = r101[r104].getDrawable();
        if ((r105 instanceof LottieDrawable) == true) goto L9;
        r105 = null;
    L9:
        LottieDrawable r106 = (LottieDrawable) r105;
        if (r106 == null) goto L12;
        r102.add(r106);
    L12:
        r104 = r104 + 1;
    L14:
        if (r102 != null) goto L16;
        return null;
    L16:
        return (LottieDrawable) CollectionsKt.getOrNull(r102, 0);
    L13:
        r102 = null;
        goto L14
    }
}
