package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u0 extends sa5.e {
    public static final /* synthetic */ int b = 0;
    public WikiViewModel a;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ BaseActivity a;
        public final /* synthetic */ u0 b;
        public final /* synthetic */ ce5.a c;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            if (Intrinsics.areEqual(r2, this.a) == false) goto L6;
            eu5.b.a.unregisterActivityLifecycleCallbacks(this);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r7) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            if (Intrinsics.areEqual(r7, this.a) == false) goto L25;
            u0 r8 = this.b;
            BaseActivity r0 = this.a;
            ce5.a r1 = this.c;
            WikiViewModel r2 = r8.a;
            if (r2 == null) goto L26;
            String r3 = r2.getSpaceId();
            WikiViewModel r4 = r8.a;
            String r5 = null;
            if (r4 == null) goto L9;
            String r6 = r4.getWikiToken();
        L10:
            WikiViewModel r9 = r8.a;
            if (r9 == null) goto L14;
            r5 = r9.getUniqueUiId();
        L14:
            if (TextUtils.isEmpty(r3) == false) goto L16;
        L23:
            tt5.a.h("WikiTreeMenuExtension", "invalid params, return. ");
            return;
        L16:
            if (TextUtils.isEmpty(r6) == true) goto L23;
            int r10 = WikiTreePanelDialog.w;
            e3 r11 = WikiTreePanelDialog.a.a(r0, r1);
            g3.a.a.a(r11);
            StringBuilder r12 = new StringBuilder("activity destroy. treeSync, send tree changed. snapshot: ");
            if (r11 == null) goto L21;
            boolean r13 = true;
        L22:
            r12.append(r13);
            tt5.a.h("WikiTreeMenuExtension", r12.toString());
            NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r14 = WikiTreeObserver.a;
            Intrinsics.checkNotNull(r3);
            Intrinsics.checkNotNull(r6);
            r14.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.f(r3, r6, r5));
            return;
        L21:
            r13 = false;
            goto L22
        L9:
            r6 = null;
            goto L10
        L26:
            return;
        }

        public a(BaseActivity r1, u0 r2, ce5.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public u0(BaseActivity r3, ce5.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        eu5.b.a.registerActivityLifecycleCallbacks(new a(r3, this, r4));
    }
}
