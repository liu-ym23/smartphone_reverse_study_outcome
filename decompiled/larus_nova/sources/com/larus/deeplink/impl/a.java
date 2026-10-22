package com.larus.deeplink.impl;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.platform.api.ExternalRouteEntry;
import com.larus.platform.api.ExternalRouteLaunchMode;
import com.larus.platform.api.q;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f330492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f330493b = null;

    /* JADX INFO: renamed from: com.larus.deeplink.impl.a$a, reason: collision with other inner class name */
    public static final class C4199a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f330494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f330495b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4199a) == true) goto L8;
            return false;
        L8:
            C4199a r101 = (C4199a) r100;
            if (Intrinsics.areEqual(this.f330494a, r101.f330494a) == true) goto L12;
            return false;
        L12:
            if (this.f330495b == r101.f330495b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f330494a.hashCode() * 31;
            if (this.f330495b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "StartResult(session=" + this.f330494a + ", shouldReportStart=" + this.f330495b + ')';
        }

        public C4199a(q r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            this.f330494a = r100;
            this.f330495b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330496a = null;

        static {
            int[] r100 = new int[ExternalRouteEntry.values().length];
            r100[ExternalRouteEntry.NEW_INTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ExternalRouteEntry.EXISTING_STACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ExternalRouteEntry.INITIAL_ACTIVITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f330496a = r100;
        }
    }

    static {
        f330492a = new AtomicLong();
        f330493b = Integer.toString(Process.myPid(), CharsKt.checkRadix(36)) + '-' + Long.toString(SystemClock.elapsedRealtimeNanos(), CharsKt.checkRadix(36)) + '-';
    }

    public static q a(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        if (Intrinsics.areEqual(r100.getAction(), CommonConstant.ACTION.HWID_SCHEME_URL) == false) goto L5;
        Intent r101 = r100;
    L6:
        if (r101 == null) goto L22;
        Uri r102 = r101.getData();
        if (r102 == null) goto L23;
        String r103 = r102.toString();
        if (r103 == null) goto L24;
        String r104 = r100.getStringExtra("com.larus.deeplink.extra.ROUTE_SESSION_ID");
        boolean r105 = false;
        if (r104 != null) goto L15;
    L17:
        if (r105 == true) goto L21;
        r100.removeExtra("com.larus.deeplink.extra.ROUTE_SESSION_STARTED");
        r104 = f330493b + Long.toString(f330492a.incrementAndGet(), CharsKt.checkRadix(36));
        r100.putExtra("com.larus.deeplink.extra.ROUTE_SESSION_ID", r104);
    L21:
        return new q(r104, ExternalRouteLaunchMode.UNKNOWN, r103);
    L15:
        if (StringsKt.startsWith$default(r104, f330493b, false, 2, null) != true) goto L17;
        r105 = true;
        goto L17
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}
