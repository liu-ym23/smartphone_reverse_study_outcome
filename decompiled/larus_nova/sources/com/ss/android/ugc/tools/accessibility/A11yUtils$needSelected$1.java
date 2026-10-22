package com.ss.android.ugc.tools.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/tools/accessibility/A11yUtils$needSelected$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class A11yUtils$needSelected$1 extends AccessibilityDelegateCompat {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ A11yUtils$needSelected$1 f454801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f454802b;

        public a(A11yUtils$needSelected$1 r100, View r101) {
            this.f454801a = r100;
            this.f454802b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f454802b;     // Catch: Throwable -> L4
            this.f454801a.getClass();     // Catch: Throwable -> L4
            r100.setContentDescription(null);     // Catch: Throwable -> L4
            this.f454802b.sendAccessibilityEvent(16384);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        if (r101 != null) goto L5;
    L7:
        super.onInitializeAccessibilityEvent(r100, r101);
        return;
    L5:
        if (r101.getEventType() != 1) goto L7;
        r100.postDelayed(new a(this, r100), 1000);
        goto L7
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        if (r101 == null) goto L5;
        r101.setContentDescription(null);
    L5:
        if (r101 == null) goto L7;
        r101.setClassName(Button.class.getName());
    L7:
        if (r101 == null) goto L10;
        r101.setClickable(true);
        return;
    }
}
