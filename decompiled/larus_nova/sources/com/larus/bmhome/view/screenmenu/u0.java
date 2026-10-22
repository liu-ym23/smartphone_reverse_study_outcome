package com.larus.bmhome.view.screenmenu;

import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class u0 {
    public static final void a(CommonMenu r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L6;
        r100.f317228f = ContextCompat.getDrawable(r100.getContext(), R.drawable.larus_message_menu_divider_6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<ot8.a> b(List<? extends ot8.a> r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == true) goto L5;
        return r100;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return r100;
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L19;
        List r104 = CollectionsKt.createListBuilder(r100.size() + 1);
        r104.add(new s0(r102));
        r104.addAll(r100);
        return CollectionsKt.build(r104);
    L19:
        return r100;
    L9:
        if (StringsKt.isBlank(r102) == true) goto L12;
        r103 = false;
        goto L13
    }
}
