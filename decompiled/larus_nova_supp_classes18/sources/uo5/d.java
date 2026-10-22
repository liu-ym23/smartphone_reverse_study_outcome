package uo5;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.core.content.ContextCompat;
import h18.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final void a(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (f.a(r3.getContext()) == false) goto L10;
        int r0 = ContextCompat.getColor(r3.getContext(), 2131100559);
        Object r1 = r3.getTag(r4);
        if ((r1 instanceof Integer) == true) goto L8;
    L9:
        r3.setBackgroundTintList(ColorStateList.valueOf(r0));
        r3.setTag(r4, Integer.valueOf(r0));
    L11:
        r3.setBackgroundResource(r4);
        return;
    L8:
        if (r0 == ((Number) r1).intValue()) goto L11;
    L10:
        r3.setBackgroundTintList(null);
        r3.setTag(r4, null);
        goto L11
    }
}
