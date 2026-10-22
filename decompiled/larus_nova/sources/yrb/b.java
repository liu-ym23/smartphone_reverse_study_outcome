package yrb;

import com.bytedance.lark.view_flow_wrapper.v;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.o;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.h;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f568944b;

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i<Unit> f568946b;

        /* JADX INFO: renamed from: yrb.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C8377a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f568947a = null;

            static {
                int[] r100 = new int[UserState.values().length];
                r100[UserState.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f568947a = r100;
            }
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        public final void a(h r100) {
            this.f568945a.f568944b.c(this);
            if (this.f568946b.isActive() == true) goto L5;
            return;
        L5:
            UserState r101 = r100.f475035a;
            if (C8377a.f568947a[r101.ordinal()] != 1) goto L8;
            i<Unit> r102 = this.f568946b;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
            return;
        L8:
            i<Unit> r104 = this.f568946b;
            Result.Companion r105 = Result.Companion;
            r104.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("user is not online"))));
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            a(r100);
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            a(r100);
        }

        public a(b r100, j r101) {
            this.f568945a = r100;
            this.f568946b = r101;
        }
    }

    public b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f568944b = r100;
    }

    @Override // com.bytedance.lark.view_flow_wrapper.v
    public final Object a(Continuation<? super Unit> r100) {
        if (this.f568944b.getState().f475035a == UserState.ONLINE) goto L5;
        j r101 = new j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        this.f568944b.d(new a(this, r101));
        Object r102 = r101.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L10:
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r102;
    L13:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
