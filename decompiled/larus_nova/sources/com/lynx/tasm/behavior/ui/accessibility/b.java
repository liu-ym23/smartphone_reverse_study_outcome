package com.lynx.tasm.behavior.ui.accessibility;

import android.view.accessibility.AccessibilityManager;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityManager f382448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f382449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccessibilityManagerTouchExplorationStateChangeListenerC4564b f382450c;

    public static class a implements AccessibilityManager.AccessibilityStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<c> f382451a;

        public a(c r100) {
            this.f382451a = new WeakReference(r100);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean r100) {
            LLog.i("LynxAccessibilityStateHelper", "onAccessibilityStateChanged: " + r100);
            WeakReference<c> r101 = this.f382451a;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.get() == null) goto L9;
            this.f382451a.get().b(r100);
            return;
        }
    }

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.accessibility.b$b, reason: collision with other inner class name */
    public static class AccessibilityManagerTouchExplorationStateChangeListenerC4564b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<c> f382452a;

        public AccessibilityManagerTouchExplorationStateChangeListenerC4564b(c r100) {
            this.f382452a = new WeakReference(r100);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public final void onTouchExplorationStateChanged(boolean r100) {
            LLog.i("LynxAccessibilityStateHelper", "onTouchExplorationStateChanged: " + r100);
            WeakReference<c> r101 = this.f382452a;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.get() == null) goto L9;
            this.f382452a.get().a(r100);
            return;
        }
    }

    public interface c {
        void a(boolean r100);

        void b(boolean r100);
    }

    public b(AccessibilityManager r100, c r101) {
        this.f382448a = null;
        this.f382449b = null;
        this.f382450c = null;
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.f382448a = r100;
        boolean r102 = r100.isEnabled();
        boolean r103 = r100.isTouchExplorationEnabled();
        r101.b(r102);
        r101.a(r103);
        a r104 = new a(r101);
        this.f382449b = r104;
        r100.addAccessibilityStateChangeListener(r104);
        AccessibilityManagerTouchExplorationStateChangeListenerC4564b r105 = new AccessibilityManagerTouchExplorationStateChangeListenerC4564b(r101);
        this.f382450c = r105;
        r100.addTouchExplorationStateChangeListener(r105);
        return;
    L8:
        return;
    }
}
