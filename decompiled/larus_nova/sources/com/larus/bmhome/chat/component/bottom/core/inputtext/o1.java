package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class o1 {
    public static final void a(TextView r100, String r101, List<n1> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "ranges");
        if (r102.isEmpty() == false) goto L6;
        r100.setText(r101);
        return;
    L6:
        SpannableString r103 = new SpannableString(r101);
        int r104 = ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_primary_50, r100.getContext(), R.color.larus_primary_50));
        Iterator<T> r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L16;
        n1 r106 = (n1) r105.next();
        int r107 = r106.f299006a;
        if (r107 < 0) goto L8;
        int r108 = r106.f299007b;
        if (r107 >= r108) goto L8;
        if (r108 > r101.length()) goto L8;
        r103.setSpan(new ForegroundColorSpan(r104), r106.f299006a, r106.f299007b, 33);
        goto L8
    L16:
        r100.setText(r103);
    }

    public static final void b(TextView r110, String r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "value");
        Intrinsics.checkNotNullParameter(r112, "keywords");
        ArrayList r100 = new ArrayList();
        Iterator<T> r113 = r112.iterator();
    L3:
        boolean r101 = false;
        if (r113.hasNext() == false) goto L14;
        String r102 = StringsKt.trim((String) r113.next()).toString();
        if (r102.length() <= 0) goto L8;
        r101 = true;
    L8:
        if (r101 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L3;
        r100.add(r102);
        goto L3
    L14:
        if (r100.isEmpty() == false) goto L16;
    L15:
        r101 = true;
    L21:
        if (r101 == false) goto L24;
        r110.setText(r111);
        return;
    L24:
        SpannableString r114 = new SpannableString(r111);
        int r103 = ContextCompat.getColor(r110.getContext(), v19.c.b(R.attr.larus_primary_50, r110.getContext(), R.color.larus_primary_50));
        Iterator r104 = r100.iterator();
    L26:
        if (r104.hasNext() == false) goto L30;
        String r105 = (String) r104.next();
        int r106 = StringsKt.indexOf$default(r111, r105, 0, true, 2, null);
    L28:
        if (r106 < 0) goto L26;
        int r107 = r105.length() + r106;
        r114.setSpan(new ForegroundColorSpan(r103), r106, r107, 33);
        r106 = StringsKt.indexOf(r111, r105, r107, true);
        goto L28
    L30:
        r110.setText(r114);
        return;
    L16:
        Iterator r115 = r100.iterator();
    L18:
        if (r115.hasNext() == false) goto L15;
        if (StringsKt.contains(r111, (String) r115.next(), true) == false) goto L18;
        goto L21
    }
}
