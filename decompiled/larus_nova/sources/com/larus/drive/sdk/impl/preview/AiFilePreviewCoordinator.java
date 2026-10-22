package com.larus.drive.sdk.impl.preview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.larus.platform.model.office.AiFilePreviewScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes27.dex */
public final class AiFilePreviewCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AiFilePreviewCoordinator f341877a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f341878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f341879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f341880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f341881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final DrivePreviewResType f341882e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f341878a, r101.f341878a) == true) goto L12;
            return false;
        L12:
            if (this.f341879b == r101.f341879b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f341880c, r101.f341880c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f341881d, r101.f341881d) == true) goto L21;
            return false;
        L21:
            if (this.f341882e == r101.f341882e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f341878a.hashCode() * 31) + this.f341879b) * 31;
            String r101 = this.f341880c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((r100 + r102) * 31) + this.f341881d.hashCode()) * 31) + this.f341882e.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedIdentity(token=" + this.f341878a + ", objType=" + this.f341879b + ", mountPoint=" + this.f341880c + ", appId=" + this.f341881d + ", resType=" + this.f341882e + ')';
        }

        public a(String r100, String r101, DrivePreviewResType r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "appId");
            Intrinsics.checkNotNullParameter(r102, "resType");
            this.f341878a = r100;
            this.f341879b = 12;
            this.f341880c = "doubao_tmp_file";
            this.f341881d = r101;
            this.f341882e = r102;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341883a = null;

        static {
            int[] r100 = new int[AiFilePreviewScene.values().length];
            r100[AiFilePreviewScene.AI_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AiFilePreviewScene.P2P_CHAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f341883a = r100;
        }
    }

    static {
        f341877a = new AiFilePreviewCoordinator();
    }

    public AiFilePreviewCoordinator() {
    }

    public final Object e(String r110, Continuation<? super String> r111) {
        if ((r111 instanceof AiFilePreviewCoordinator$resolveResourceUri$1) == false) goto L7;
        AiFilePreviewCoordinator$resolveResourceUri$1 r100 = (AiFilePreviewCoordinator$resolveResourceUri$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        long r104 = r100.J$0;
        ResultKt.throwOnFailure(r112);     // Catch: TimeoutCancellationException -> L26
    L21:
        return (String) r112;
    L24:
        FLogger.f375446a.w("AiFilePreview", "resolve failed, reason=request_timeout, costMs=" + (SystemClock.elapsedRealtime() - r104));
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        long r105 = SystemClock.elapsedRealtime();
        AiFilePreviewCoordinator$resolveResourceUri$2 r113 = new AiFilePreviewCoordinator$resolveResourceUri$2(r110, r105, null);     // Catch: TimeoutCancellationException -> L23
        r100.J$0 = r105;     // Catch: TimeoutCancellationException -> L23
        r100.label = 1;     // Catch: TimeoutCancellationException -> L23
        r112 = TimeoutKt.b(3000, r113, r100);     // Catch: TimeoutCancellationException -> L23
        if (r112 != r102) goto L20;
        return r102;
    L20:
        r104 = r105;
    L23:
        r104 = r105;
    L7:
        r100 = new AiFilePreviewCoordinator$resolveResourceUri$1(this, r111);
        goto L8
    }

    public static final boolean b(Context r100, CoroutineScope r101, String r102) {
        if (CoroutineScopeKt.isActive(r101) == true) goto L5;
    L21:
        return false;
    L5:
        if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), r102) == false) goto L21;
    L8:
        if ((r100 instanceof Activity) == true) goto L9;
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L8
    L13:
        Activity r103 = null;
    L14:
        if (r103 != null) goto L17;
    L20:
        return true;
    L17:
        if (r103.isFinishing() == true) goto L21;
        if (r103.isDestroyed() == true) goto L21;
    L9:
        r103 = (Activity) r100;
        goto L14
    }

    public static final Object c(AiFilePreviewCoordinator r100, cr9.a r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof AiFilePreviewCoordinator$resolveRequest$1) == false) goto L7;
        AiFilePreviewCoordinator$resolveRequest$1 r103 = (AiFilePreviewCoordinator$resolveRequest$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (cr9.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        String r108 = (String) r105;
        if (r108 != null) goto L20;
        return null;
    L20:
        AiFilePreviewScene r109 = r101.f465108b;
        int r110 = b.f341883a[r109.ordinal()];
        if (r110 != 1) goto L23;
        String r111 = "doubao_ai_msg";
    L29:
        return new a(r108, r111, DrivePreviewResType.THIRD_PARTY_FILE);
    L23:
        if (r110 != 2) goto L26;
        r111 = "doubao_p2p_msg";
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        String r112 = r101.f465107a;
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r100.e(r112, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new AiFilePreviewCoordinator$resolveRequest$1(r100, r102);
        goto L8
    }

    public static final void a(Context r110, CoroutineScope r111, String r112, Function0 r113) {
        BuildersKt.launch$default(r111, Dispatchers.getMain().getImmediate(), null, new AiFilePreviewCoordinator$fallbackIfCurrent$1(r110, r111, r112, r113, null), 2, null);
    }

    public static void d(Context r110, CoroutineScope r111, cr9.a r112, q0 r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scope");
        Intrinsics.checkNotNullParameter(r112, "request");
        Intrinsics.checkNotNullParameter(r113, "fallback");
        BuildersKt.launch$default(r111, null, null, new AiFilePreviewCoordinator$open$1(r112, r110, r111, AccountService.f365697a.getUserId(), r113, null), 3, null);
    }
}
