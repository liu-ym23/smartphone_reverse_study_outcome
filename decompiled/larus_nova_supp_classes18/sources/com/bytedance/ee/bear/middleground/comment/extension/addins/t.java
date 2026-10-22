package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends com.ss.android.lark.appcontext.applifecycle.a {
    public final /* synthetic */ s.b a;
    public final /* synthetic */ Ref.ObjectRef<Boolean> b;
    public final /* synthetic */ ef5.o c;

    public static final class a implements Runnable {
        public final /* synthetic */ ef5.o a;

        public a(ef5.o r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.b.isAttachedToWindow() == false) goto L9;
            rcb.c.h(this.a.b, null);     // Catch: Throwable -> L6
            return;
        }
    }

    public final void onActivityDestroyed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        s.b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (Intrinsics.areEqual(r3, r1.a.getContext().getConfig().getActivity()) == false) goto L6;
        AppLifecycle.a.a.j(this);
        return;
    }

    public final void onActivityPaused(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (StringsKt.contains$default(r5.getClass().getName(), "Profile", false, 2, null) == false) goto L6;
        Ref.ObjectRef<Boolean> r6 = this.b;
        r6.element = Boolean.TRUE;
        return;
    }

    public final void onActivityResumed(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (StringsKt.contains$default(r7.getClass().getName(), "Profile", false, 2, null) == false) goto L5;
        Ref.ObjectRef<Boolean> r1 = this.b;
        r1.element = Boolean.FALSE;
    L5:
        s.b r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (Intrinsics.areEqual(r7, r2.a.getContext().getConfig().getActivity()) == false) goto L11;
        AppLifecycle.a.a.j(this);
        this.c.a.c("InputCommentClickMentionAddin");
        if (Intrinsics.areEqual(this.b.element, Boolean.TRUE) == false) goto L12;
        rcb.e.a(new a(this.c), 100);
        return;
    L12:
        return;
    }

    public t(s.b r1, Ref.ObjectRef<Boolean> r2, ef5.o r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
