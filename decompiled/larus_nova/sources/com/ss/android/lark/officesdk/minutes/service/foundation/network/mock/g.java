package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f433953h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<mub.a> f433954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f433955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<i> f433956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f433957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<b, MutableSharedFlow<Object>> f433958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<b, List<c>> f433959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<b, List<Job>> f433960g;

    public static final class a {
        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.RecordingNetworkMockScenarios");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f433961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f433962b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f433961a, r101.f433961a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f433962b, r101.f433962b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f433961a.hashCode() * 31) + this.f433962b.hashCode();
        }

        public final String toString() {
            return "MockPushKey(type=" + this.f433961a + ", key=" + this.f433962b + ')';
        }

        public final String getType() {
            return this.f433961a;
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.f433961a = r100;
            this.f433962b = r101;
        }
    }

    public static final class c {
    }

    public g() {
        throw null;
    }

    static {
        f433953h = new a();
    }

    public final void a() {
        mub.a r100 = this.f433954a.invoke();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f433955b.invoke().booleanValue() == true) goto L8;
        return;
    L8:
        if (r100.isEnabled() == false) goto L16;
        i r101 = this.f433956c.invoke();
        if (r101 == null) goto L15;
        r101.build();
        return;
    L15:
        return;
    }

    public g(Function0 r100) {
        MmRecordingNetworkMockEngine$1 r101 = MmRecordingNetworkMockEngine$1.INSTANCE;
        MmRecordingNetworkMockEngine$2 r102 = MmRecordingNetworkMockEngine$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "providerProvider");
        Intrinsics.checkNotNullParameter(r101, "debugEnabledProvider");
        Intrinsics.checkNotNullParameter(r102, "scenarioProviderProvider");
        this.f433954a = r100;
        this.f433955b = r101;
        this.f433956c = r102;
        this.f433957d = CoroutineScopeKt.CoroutineScope(MMCoroutines.b("MmRecordingNetworkMockEngine"));
        this.f433958e = new ConcurrentHashMap();
        this.f433959f = new ConcurrentHashMap();
        this.f433960g = new ConcurrentHashMap();
    }

    public final e b(d r100, Continuation r101) {
        if ((r101 instanceof MmRecordingNetworkMockEngine$mockRequest$1) == false) goto L7;
        MmRecordingNetworkMockEngine$mockRequest$1 r102 = (MmRecordingNetworkMockEngine$mockRequest$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r106 = null;
        if (r105 != 0) goto L11;
        ResultKt.throwOnFailure(r104);
        a();
        c(r100.getType(), r100.f433948b, false, null);
        return e.b.f433952a;
    L11:
        if (r105 != 1) goto L13;
        h r107 = (h) r102.L$2;
        Class r108 = (Class) r102.L$1;
        d r109 = (d) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L17
        r107.getClass();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r109, "request");     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Object r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9456isSuccessimpl(r112) == true) goto L28;
        String r113 = r109.getType();
        String r114 = r109.f433948b;
        if (Result.m9456isSuccessimpl(r112) == false) goto L23;
        r107.getClass();
        r106 = "scenario=null";
    L26:
        c(r113, r114, true, r106);
        return new e.a(r112);
    L23:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r112);
        if (r115 == null) goto L26;
        r106 = r115.getMessage();
        goto L26
    L28:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Any");
        r107.getClass();
        throw null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r102 = new MmRecordingNetworkMockEngine$mockRequest$1(this, r101);
        goto L8
    }

    public final boolean d(String r100, String r101) {
        b r102 = new b(r100, r101);
        boolean r103 = true;
        if (this.f433958e.remove(r102) == null) goto L5;
    L16:
        a();
        return r103;
    L5:
        if (this.f433959f.remove(r102) != null) goto L16;
        List<Job> r104 = this.f433960g.remove(r102);
        if (r104 == null) goto L12;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L13;
        Job.DefaultImpls.cancel$default((Job) r105.next(), null, 1, null);
    L13:
        if (r104 != null) goto L16;
        r103 = false;
        goto L16
    L12:
        r104 = null;
        goto L13
    }

    public final void c(String r100, String r101, boolean r102, String r103) {
        mub.a r104 = this.f433954a.invoke();
        if (r104 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        r104.M1();
        return;
    }
}
