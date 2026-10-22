package com.bytedance.android.shopping.api.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/accessibility/AccessibilityDelegateCompatImpl;", "Landroidx/core/view/AccessibilityDelegateCompat;", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AccessibilityDelegateCompatImpl extends AccessibilityDelegateCompat {
    public final View a;
    public CharSequence b;
    public final String c;

    public AccessibilityDelegateCompatImpl(View r3) {
        String r0 = Button.class.getName();
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        this.b = null;
        this.c = r0;
    }

    public final void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "event");
        super.onInitializeAccessibilityEvent(r2, r3);
        CharSequence r0 = this.b;
        if (r0 != null) goto L5;
        r0 = r2.getContentDescription();
    L5:
        r3.setContentDescription(r0);
        r3.setClassName(this.c);
    }

    public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "info");
        super.onInitializeAccessibilityNodeInfo(r2, r3);
        CharSequence r0 = this.b;
        if (r0 != null) goto L5;
        r0 = r2.getContentDescription();
    L5:
        r3.setContentDescription(r0);
        r3.setClassName(this.c);
    }
}
