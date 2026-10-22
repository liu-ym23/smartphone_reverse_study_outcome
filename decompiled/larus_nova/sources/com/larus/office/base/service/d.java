package com.larus.office.base.service;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f361097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<a> f361098b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IOfficeSdkServiceV2 f361099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f361101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Boolean> f361102d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361099a, r101.f361099a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361100b, r101.f361100b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f361101c, r101.f361101c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f361102d, r101.f361102d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f361099a.hashCode() * 31) + this.f361100b.hashCode()) * 31) + this.f361101c.hashCode()) * 31) + this.f361102d.hashCode();
        }

        public final String toString() {
            return "DeferredPrefetch(officeSdkService=" + this.f361099a + ", tag=" + this.f361100b + ", resourceId=" + this.f361101c + ", action=" + this.f361102d + ')';
        }

        public a(IOfficeSdkServiceV2 r100, String r101, String r102, Function0<Boolean> r103) {
            Intrinsics.checkNotNullParameter(r100, "officeSdkService");
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.checkNotNullParameter(r102, "resourceId");
            Intrinsics.checkNotNullParameter(r103, "action");
            this.f361099a = r100;
            this.f361100b = r101;
            this.f361101c = r102;
            this.f361102d = r103;
        }
    }

    static {
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        f361097a = r100;
        f361098b = SharedFlowKt.MutableSharedFlow$default(0, 64, BufferOverflow.DROP_OLDEST, 1, null);
        BuildersKt.launch$default(r100, null, CoroutineStart.UNDISPATCHED, new OfficePreloadHelper$startDeferredPrefetchCollector$1(null), 1, null);
    }

    public static boolean a(String r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "resourceId");
        Intrinsics.checkNotNullParameter(r102, "prefetchAction");
        if (StringsKt.isBlank(r101) == false) goto L7;
        FLogger.f375446a.i("OfficePreloadHelper", "[" + r100 + "] prefetch skipped, resourceId is empty");
        return false;
    L7:
        if (z2.f365865a.enableOfficeDataPrefetch() == true) goto L10;
        FLogger.f375446a.i("OfficePreloadHelper", "[" + r100 + "] prefetch disabled by settings, resId=" + r101);
        return false;
    L10:
        IOfficeSdkServiceV2 r103 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r103 != null) goto L22;
        return false;
    L22:
        if (r103.f0() == false) goto L17;
        FLogger.f375446a.i("OfficePreloadHelper", "[" + r100 + "] prefetch docSdk data, resId=" + r101);
        return ((Boolean) r102.invoke()).booleanValue();
    L17:
        f361098b.tryEmit(new a(r103, r100, r101, r102));
        return false;
    L19:
        e = move-exception;
        FLogger.f375446a.i("OfficePreloadHelper", "[" + r100 + "] check docSdk ready failed, resId=" + r101 + ", error=" + e);
        return false;
    }

    public static boolean b(String r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "resourceId");
        Intrinsics.checkNotNullParameter(r102, "preloadAction");
        IOfficeSdkServiceV2 r103 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == true) goto L11;
        FLogger.f375446a.i("OfficePreloadHelper", "[" + r100 + "] docSdk not ready, defer preload, resId=" + r101);
        return false;
    L11:
        FLogger.f375446a.i("OfficePreloadHelper", "[" + r100 + "] preload docSdk data, resId=" + r101);
        r102.invoke();
        return true;
    L5:
        if (r103.f0() != true) goto L7;
        r104 = true;
        goto L9
    }
}
