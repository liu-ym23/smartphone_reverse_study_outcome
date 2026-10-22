package com.larus.account.saas.jsb.core.auth;

import android.app.Activity;
import android.content.Intent;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, C3942a> f286380a = null;

    /* JADX INFO: renamed from: com.larus.account.saas.jsb.core.auth.a$a, reason: collision with other inner class name */
    public static final class C3942a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<ActivityResultAuthProxyActivity, Unit> f286381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Throwable, Unit> f286382b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3942a) == true) goto L8;
            return false;
        L8:
            C3942a r101 = (C3942a) r100;
            if (Intrinsics.areEqual(this.f286381a, r101.f286381a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286382b, r101.f286382b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f286381a.hashCode() * 31) + this.f286382b.hashCode();
        }

        public final String toString() {
            return "PendingLaunch(onActivityReady=" + this.f286381a + ", onLaunchError=" + this.f286382b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C3942a(Function1<? super ActivityResultAuthProxyActivity, Unit> r100, Function1<? super Throwable, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "onActivityReady");
            Intrinsics.checkNotNullParameter(r101, "onLaunchError");
            this.f286381a = r100;
            this.f286382b = r101;
        }
    }

    static {
        f286380a = new ConcurrentHashMap();
    }

    public static void a(Activity r100, Function1 r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "fromActivity");
        Intrinsics.checkNotNullParameter(r101, "onActivityReady");
        Intrinsics.checkNotNullParameter(r102, "onLaunchError");
        String r103 = UUID.randomUUID().toString();
        f286380a.put(r103, new C3942a(r101, r102));
        Intent r104 = new Intent(r100, ActivityResultAuthProxyActivity.class);     // Catch: Throwable -> L5
        r104.putExtra("account_saas_auth_request_id", r103);     // Catch: Throwable -> L5
        r100.startActivity(r104);     // Catch: Throwable -> L5
        r100.overridePendingTransition(0, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        C3942a r105 = f286380a.remove(r103);
        if (r105 == null) goto L14;
        Function1<Throwable, Unit> r106 = r105.f286382b;
        if (r106 == null) goto L15;
        r106.invoke(th);
        return;
    L15:
        return;
    }
}
