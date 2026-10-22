package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends b {

    public static final class a {
    }

    static {
    }

    public m(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "action");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        Map r7 = r5.getParams();
        if (r7 == null) goto L5;
        Object r8 = r7.get("type");
    L7:
        if ((r8 instanceof String) == true) goto L9;
        r8 = null;
    L9:
        String r9 = (String) r8;
        if (r9 != null) goto L12;
        return false;
    L12:
        Map r10 = r5.getParams();
        if (r10 == null) goto L15;
        Object r11 = r10.get("link");
    L17:
        if ((r11 instanceof String) == true) goto L19;
        r11 = null;
    L19:
        String r12 = (String) r11;
        if (r12 != null) goto L23;
        return false;
    L23:
        if (StringsKt.startsWith$default(r12, "$", false, 2, null) == false) goto L27;
        r12 = this.c.s(r12);
    L27:
        if (r9.hashCode() == (-313440398)) goto L30;
    L34:
        return false;
    L30:
        if (r9.equals("feedback_popup") == false) goto L34;
        if (r12 != null) goto L33;
        return false;
    L33:
        this.c.g(r12, r9);
        goto L34
    L15:
        r11 = null;
        goto L17
    L5:
        r8 = null;
        goto L7
    }
}
