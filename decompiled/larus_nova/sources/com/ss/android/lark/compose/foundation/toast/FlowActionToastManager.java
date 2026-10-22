package com.ss.android.lark.compose.foundation.toast;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FlowActionToastManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f417620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<a> f417621b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f417622c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f417623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f417624b;

        public final int hashCode() {
            return this.f417624b;
        }

        public a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            this.f417623a = r100;
            this.f417624b = r100.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.compose.foundation.toast.FlowActionToastManager.ToastInfo");
            if (Intrinsics.areEqual(this.f417623a, ((a) r100).f417623a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r101 = null;
            goto L10
        }
    }

    public FlowActionToastManager() {
    }

    static {
        f417621b = new LinkedList();
        f417622c = LazyKt.lazy(FlowActionToastManager$activityLifecycleCallbacks$2.INSTANCE);
    }

    public static void b() {
        LinkedList<a> r100 = f417621b;
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        a r101 = r100.getFirst();
        b r102 = r101.f417623a;
        if (r102.f417640b != 2) goto L8;
        return;
    L8:
        Handler r103 = null;
        if (r102.f417639a.isFinishing() == false) goto L11;
    L14:
        Handler r104 = f417620a;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L18:
        r103.sendEmptyMessageDelayed(r101.f417624b, r102.f417647i);
        return;
    L17:
        r103 = r104;
        goto L18
    L11:
        if (r102.f417639a.isDestroyed() == true) goto L14;
        r102.f417642d.b();
        WindowManager.LayoutParams r105 = new WindowManager.LayoutParams();
        r105.width = -2;
        r105.height = -2;
        r105.type = 2;
        r105.format = 1;
        r105.flags = 8;
        r105.gravity = r102.f417644f;
        r105.x = r102.f417645g;
        r105.y = r102.f417646h;
        WindowManager r106 = r102.f417641c;
        UDShadowLayout r107 = r102.f417643e;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r107, r105);
        r106.addView(r107, r105);
        r102.f417640b = 2;
        i r108 = r102.f417642d;
        r108.f417659b.f424293a.setAlpha(0.0f);
        ViewPropertyAnimator r109 = r108.f417659b.f424293a.animate().setDuration(200).alpha(1.0f).setListener(new j(null, r108, null));
        r109.start();
        r108.f417660c = r109;
        goto L14
    }

    public static final void a(Activity r100) {
    L2:
        LinkedList<a> r101 = f417621b;
        if ((!r101.isEmpty()) == false) goto L13;
        a r102 = r101.getFirst();
        b r103 = r102.f417623a;
        if (Intrinsics.areEqual(r103.f417639a, r100) == false) goto L18;
        if (r103.f417640b != 2) goto L12;
        r103.b();
        Handler r104 = f417620a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r104 = null;
    L11:
        r104.removeMessages(r102.f417624b);
    L12:
        r101.remove(r102);
        goto L2
    L18:
        return;
    }
}
