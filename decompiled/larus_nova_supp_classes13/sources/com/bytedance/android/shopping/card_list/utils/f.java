package com.bytedance.android.shopping.card_list.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.ec.core.utils.AccessibilityUtil;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.bytedance.android.ec.core.utils.a.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public final void a(AccessibilityNodeInfoCompat r2) {
            if (r2 == null) goto L4;
            r2.setClassName(this.a);
        L4:
            if (r2 == null) goto L6;
            r2.setContentDescription(this.b);
        L6:
            if (r2 == null) goto L9;
            r2.setHeading(this.c);
            return;
        }

        public a(String r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public static Boolean a(AndroidYaTaInstance r4, Boolean r5) {
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r1 = r4.i("pagination");
    L7:
        if ((r1 instanceof Map) == true) goto L9;
        r1 = null;
    L9:
        Map r2 = (Map) r1;
        if (r2 == null) goto L12;
        Object r3 = r2.get("has_more");
    L14:
        if ((r3 instanceof Boolean) == true) goto L16;
        r3 = null;
    L16:
        Boolean r6 = (Boolean) r3;
        if (r4 == null) goto L19;
        Object r7 = r4.i("has_more");
    L21:
        if ((r7 instanceof Boolean) == false) goto L24;
        r0 = r7;
    L24:
        Boolean r8 = (Boolean) r0;
        if (r6 != null) goto L27;
        r6 = r8;
    L27:
        if (r6 != null) goto L30;
        return r5;
    L30:
        return r6;
    L19:
        r7 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public static void b(View r1, @AccessibilityType String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$setAccessibilityInfo");
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "content");
        a r0 = new a(com.bytedance.android.ec.core.utils.a.b(r2), r3, r4);
        if (r1 == null) goto L7;
        ViewCompat.setAccessibilityDelegate(r1, new AccessibilityUtil.setAccessibilityDelegate.1(r0));
        return;
    }
}
