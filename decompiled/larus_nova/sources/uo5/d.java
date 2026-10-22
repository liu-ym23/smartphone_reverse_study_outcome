package uo5;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import h18.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (f.a(r100.getContext()) == false) goto L10;
        int r102 = ContextCompat.getColor(r100.getContext(), R.color.bg_float_overlay);
        Object r103 = r100.getTag(r101);
        if ((r103 instanceof Integer) == true) goto L8;
    L9:
        r100.setBackgroundTintList(ColorStateList.valueOf(r102));
        r100.setTag(r101, Integer.valueOf(r102));
    L11:
        r100.setBackgroundResource(r101);
        return;
    L8:
        if (r102 == ((Number) r103).intValue()) goto L11;
    L10:
        r100.setBackgroundTintList(null);
        r100.setTag(r101, null);
        goto L11
    }
}
