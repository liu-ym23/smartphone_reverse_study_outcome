package com.bytedance.applet.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x0 {
    public static final x0 a = null;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public final String a;
        public final Function1<String, Unit> b;
        public final Application c;
        public final Handler d;
        public final AtomicBoolean e;
        public Activity f;
        public final v0 g;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
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
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void a(String r4) {
            if (this.e.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.d.removeCallbacks(this.g);
            this.c.unregisterActivityLifecycleCallbacks(this);
            this.f = null;
            this.b.invoke(r4);
        }

        public final void b(final Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
            this.d.post(new w0(this, r5));
            return;
        L6:
            this.c.registerActivityLifecycleCallbacks(this);
            this.d.postDelayed(this.g, 5000);
            x0 r0 = x0.a;
            String r1 = this.a;
            r0.getClass();
            Exception r6 = x0.a(r5, r1);
            if (r6 == null) goto L13;
            String r2 = r6.getMessage();
            if (r2 != null) goto L11;
            r2 = r6.getClass().getSimpleName();
        L11:
            a("failed to open settings page: ".concat(r2));
            return;
        }

        public final void c(Activity r3) {
            int r0 = ts9.b.a;
            Intent r1 = r3.getIntent();
            if (r1 == null) goto L5;
            Bundle r2 = r1.getExtras();
        L6:
            String r4 = ts9.b.a(r2);
            if (com.larus.platform.service.q.a.g(r3) == true) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r4, this.a) == false) goto L13;
            this.f = r3;
            this.d.removeCallbacks(this.g);
            return;
        L13:
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            if (r2 == this.f) goto L6;
            return;
        L6:
            if (r2.isChangingConfigurations() == false) goto L9;
            this.f = null;
            return;
        L9:
            a(null);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            c(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.applet.impl.v0] */
        public a(String r2, Function1<? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "settingsUrl");
            Intrinsics.checkNotNullParameter(r3, "completion");
            this.a = r2;
            this.b = r3;
            gd9.i r4 = com.larus.im.b.a;
            Intrinsics.checkNotNull(r4);
            this.c = r4.getApplication();
            this.d = new Handler(Looper.getMainLooper());
            this.e = new AtomicBoolean(false);
            this.g = new v0(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            c(r1);
        }
    }

    static {
        a = new x0();
    }

    public x0() {
    }

    public static Exception a(Context r3, String r4) {
        com.larus.platform.service.q.a.e(r3, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r4), TuplesKt.to("hide_title_bar", CommentScene.COMMENTSCENE_NO_AWEME)}), null);     // Catch: Exception -> L4
        return null;
    L4:
        e = move-exception;
        return e;
    }

    public static void b(Context r8, String r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r10 == null) goto L13;
        if (r9 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        r10.invoke("appletId is empty");
        return;
    L6:
        if (StringsKt.isBlank(r9) == true) goto L9;
        r1 = false;
    L13:
        String r2 = com.larus.platform.api.f2.a.t();
        String r3 = null;
        Object r4 = null;
        r3 = null;
        if (r2 == null) goto L45;
        if (StringsKt.isBlank(r2) == true) goto L45;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L37
        Uri r6 = UriProtector.parse(r2);     // Catch: Throwable -> L37
        Uri.Builder r7 = r6.buildUpon().clearQuery().appendPath("detail");     // Catch: Throwable -> L37
        Iterator r11 = UriProtector.getQueryParameterNames(r6).iterator();     // Catch: Throwable -> L37
    L22:
        if (r11.hasNext() == false) goto L31;
        String r12 = (String) r11.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r12, "from") == true) goto L22;
        if (Intrinsics.areEqual(r12, "doubao_apps_key") == true) goto L22;
        Iterator r13 = UriProtector.getQueryParameters(r6, r12).iterator();     // Catch: Throwable -> L37
    L29:
        if (r13.hasNext() == false) goto L22;
        r7.appendQueryParameter(r12, (String) r13.next());     // Catch: Throwable -> L37
        goto L29
    L31:
        String r14 = r7.appendQueryParameter("doubao_apps_key", r9).appendQueryParameter("from", "doubao_apps_detail").toString();     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L37
        if ((true ^ StringsKt.isBlank(r14)) == true) goto L35;
        r14 = null;
    L35:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r15) == true) goto L43;
        r4 = r15;
    L43:
        r3 = (String) r4;
    L37:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L45:
        if (r3 != null) goto L50;
        if (r10 == null) goto L48;
        com.bytedance.ai.utils.g.a.e("AppletSettingsNavigator", "setting page is empty, but completion is not null");
        r10.invoke("settings URL is unavailable");
        return;
    L48:
        com.bytedance.ai.utils.g.a.e("AppletSettingsNavigator", "setting page is empty, and completion is null");
        return;
    L50:
        if (r10 != null) goto L55;
        Exception r16 = a(r8, r3);
        if (r16 == null) goto L67;
        com.bytedance.ai.utils.g.a.e("AppletSettingsNavigator", "navigate to setting page error: " + r16);
        return;
    L67:
        return;
    L55:
        new a(r3, r10).b(r8);
    }
}
