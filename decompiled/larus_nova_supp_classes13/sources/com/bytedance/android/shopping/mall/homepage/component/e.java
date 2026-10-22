package com.bytedance.android.shopping.mall.homepage.component;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.popup.ECPopupManager;
import com.bytedance.android.ec.hybrid.popup.f;
import com.bytedance.android.ec.hybrid.popup.j;
import com.bytedance.android.ec.hybrid.popup.o;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends b {

    public static final class a implements e93.b {
        public ECPopupManager a;

        public a() {
        }

        public final ViewGroup b() {
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L6:
            return r0.o;
        }

        public final void release() {
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L5:
            r0.release();
        }

        public final Pair a(gk.b r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L6:
            return r0.a(r3);
        }

        public final void f(j r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L5:
            r0.f(r3);
        }

        public final void finish(String r3) {
            Intrinsics.checkNotNullParameter(r3, "taskID");
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L5:
            r0.finish(r3);
        }

        public final void g(boolean r3) {
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L5:
            r0.g(r3);
        }

        public final Pair e(o r3, f r4, com.bytedance.android.ec.hybrid.popup.d r5) {
            Intrinsics.checkNotNullParameter(r3, "taskConfig");
            Intrinsics.checkNotNullParameter(r4, "popupConfig");
            ECPopupManager r0 = this.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("popupManager");
        L6:
            return r0.e(r3, r4, r5);
        }

        @Override // e93.b
        public final void h(com.bytedance.android.ec.hybrid.card.api.f r11, FrameLayout r12, FrameLayout r13, ik.a r14, com.bytedance.android.ec.hybrid.popup.e r15, String r16, boolean r17, Function3<? super String, ? super String, ? super String, Unit> r18) {
            Intrinsics.checkNotNullParameter(r11, "lynxCardLoader");
            Intrinsics.checkNotNullParameter(r12, "globalLayout");
            Intrinsics.checkNotNullParameter(r13, "localLayout");
            Intrinsics.checkNotNullParameter(r14, "appStateManager");
            Intrinsics.checkNotNullParameter(r15, "popupStateManager");
            Intrinsics.checkNotNullParameter(r16, "sceneId");
            Intrinsics.checkNotNullParameter(r18, "reportPopupHideByDrift");
            this.a = new ECPopupManager(r11, r12, r13, r14, r15, r16, r17, r18);
        }
    }

    public e() {
    }

    @Override // u93.b, u93.c
    public final void onCreate(Bundle r3) {
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r4 = MallAbilityManager.a;
        MallAbilityManager.a(e93.b.class, new a(), p().z);
    }
}
