package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public static final View a(Context r110, a r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "action");
        Intrinsics.checkNotNullParameter(r111, "action");
        if (r111.f387466b == false) goto L5;
        ProactiveActionDisplayState r100 = ProactiveActionDisplayState.ADOPTED;
    L7:
        if (r100 != ProactiveActionDisplayState.ADOPTED) goto L9;
        boolean r101 = true;
    L10:
        LinearLayout r102 = c4.e(r110);
        r102.setGravity(16);
        r102.setPadding(c4.c(r110, 11), c4.c(r110, 10), c4.c(r110, 11), c4.c(r110, 10));
        r102.setMinimumHeight(c4.c(r110, 44));
        r102.setBackground(c4.h(r110, -592141, 14, -1512723, 1));
        if (r101 == false) goto L13;
        TextView r103 = c4.f(r110, "已采纳", 11.5f, -1, 1);
        r103.setGravity(17);
        r103.setPadding(c4.c(r110, 10), c4.c(r110, 4), c4.c(r110, 10), c4.c(r110, 4));
        r103.setBackground(c4.h(r110, -14540254, 12, 0, 0));
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.setMargins(0, 0, c4.c(r110, 10), 0);
        Unit r105 = Unit.INSTANCE;
        r102.addView(r103, r104);
    L13:
        TextView r112 = c4.f(r110, r111.f387465a, 12.5f, -13946048, 1);
        r112.setGravity(16);
        r102.addView(r112, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return r102;
    L9:
        r101 = false;
        goto L10
    L5:
        r100 = ProactiveActionDisplayState.DEFAULT;
        goto L7
    }
}
