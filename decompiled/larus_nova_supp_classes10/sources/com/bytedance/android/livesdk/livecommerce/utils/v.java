package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "subTitle");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        View r0 = LayoutInflater.from(r4).inflate(2131560782, null);
        View r1 = r0.findViewById(2131388953);
        if (r1 == null) goto L15;
        TextView r2 = (TextView) r1;
        View r3 = r0.findViewById(2131388951);
        if (r3 == null) goto L13;
        r2.setText(r5);
        ((TextView) r3).setText(r6);
        Toast r7 = new Toast(r4);
        r7.setView(r0);
        r7.setGravity(17, 0, 0);
        r7.setDuration(0);
        r7.show();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
