package com.ss.android.lark.todo.impl.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444280a = 0;

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f444281a = null;

        static {
            f444281a = new a();
        }

        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "insets");
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            r100.setPadding(r100.getPaddingLeft(), r102.top, r100.getPaddingRight(), r102.bottom);
            return r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.suite.lark.component.navroute.forseti.g f444282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.suite.lark.component.navroute.api.c<Bundle> f444283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ForsetiNavOptions.a f444284c;

        public b(com.suite.lark.component.navroute.forseti.g r100, com.suite.lark.component.navroute.api.c<Bundle> r101, ForsetiNavOptions.a r102) {
            this.f444282a = r100;
            this.f444283b = r101;
            this.f444284c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f444282a.i(this.f444283b, this.f444284c.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f444285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f444286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f444287c;

        public c(Fragment r100, Integer r101, Intent r102) {
            this.f444285a = r100;
            this.f444286b = r101;
            this.f444287c = r102;
        }

        public final void a() {
            if (this.f444285a.isAdded() == false) goto L8;
            Integer r100 = this.f444286b;
            if (r100 == null) goto L7;
            this.f444285a.startActivityForResult(this.f444287c, r100.intValue());
            return;
        L7:
            this.f444285a.startActivity(this.f444287c);
            return;
        L8:
            Log.e("ForsetiUtils", "Fragment is not added: ".concat(this.f444285a.getClass().getSimpleName()));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public e() {
    }

    public static void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        ViewCompat.setOnApplyWindowInsetsListener(r100, a.f444281a);
    }

    public static /* synthetic */ void c(Context r100, Fragment r101, Intent r102, com.suite.lark.component.navroute.api.c r103, Integer r110) {
        b(r100, r101, r102, r103, r110, ForsetiNavOptions.DestinationStyle.NORMAL);
    }

    public static void b(Context r100, Fragment r101, Intent r102, com.suite.lark.component.navroute.api.c r103, Integer r104, ForsetiNavOptions.DestinationStyle r105) {
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "intent");
        Intrinsics.checkNotNullParameter(r103, "fragmentDirection");
        Intrinsics.checkNotNullParameter(r105, "style");
        if (r100 != null) goto L6;
        return;
    L6:
        if (ForsetiConfig.a(r100) == false) goto L14;
        ForsetiNavOptions.a r106 = new ForsetiNavOptions.a();
        Intrinsics.checkNotNullParameter(r105, "value");
        r106.f460326e = r105;
        if (r104 == null) goto L10;
        r104.intValue();
        r106.f460325d = r104.intValue();
    L10:
        com.suite.lark.component.navroute.forseti.g r107 = com.suite.lark.component.navroute.forseti.f.b(r101);
        if (r107 == null) goto L14;
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new b(r107, r103, r106));
        return;
    L14:
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new c(r101, r104, r102));
    }
}
