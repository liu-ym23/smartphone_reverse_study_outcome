package com.ss.android.lark.forseti.animation;

import android.animation.Animator;
import android.view.View;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends com.ss.android.lark.forseti.animation.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f424305c = 0;

    public static final class a {
        public a() {
        }

        public static c a(View r100, float r101) {
            int r102 = c.f424305c;
            Intrinsics.checkNotNullParameter(r100, "view");
            b r103 = com.ss.android.lark.forseti.animation.a.f424301b;
            ForsetiAnimator$Companion$createAnimator$1 r104 = ForsetiAnimator$Companion$createAnimator$1.INSTANCE;
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r104, "factory");
            b r105 = com.ss.android.lark.forseti.animation.a.f424301b;
            boolean r106 = false;
            Animator r107 = null;
            if (r105 != null) goto L17;
        L12:
            c r108 = r104.invoke(r107, Boolean.valueOf(r106));
            new WeakReference(r100);
            r108.getClass();
            return r108;
        L17:
            r107 = r105.f424303a.newInstance(new Object[]{0, Float.valueOf(r101)});     // Catch: Throwable -> L14
        L7:
            b r109 = com.ss.android.lark.forseti.animation.a.f424301b;
            r109.getClass();
            r109.f424304b.invoke(r107, new Object[]{r100});     // Catch: Throwable -> L10
        L11:
            r106 = true;
        L10:
            Log.e("AsyncHandler", "assignTarget failed.");
            goto L11
        }
    }

    static {
        new a();
    }

    public c(Animator r100, boolean r101) {
        super(r100);
    }
}
