package nb5;

import ak5.w;
import ak5.x;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.integrator.di.configs.net.container.OfficeUserNetServiceImpl;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.bear.net.HttpException;
import com.bytedance.ee.bear.net.ServerResultException;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<R extends Result> implements NetService.d {
    public final /* synthetic */ w<R> a;
    public final /* synthetic */ OfficeUserNetServiceImpl b;

    public static final class a<T> implements FlowableOnSubscribe {
        public final /* synthetic */ Flowable<R> a;

        /* JADX INFO: renamed from: nb5.c$a$a, reason: collision with other inner class name */
        public static final class C0261a<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<R> a;

            public C0261a(FlowableEmitter<R> r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Result r3 = (Result) r2;
                if (this.a.isCancelled() == true) goto L8;
                if (r3 == null) goto L6;
                this.a.onNext(r3);
            L6:
                this.a.onComplete();
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<R> a;

            public b(FlowableEmitter<R> r1) {
                this.a = r1;
            }

            public final void accept(Object r9) {
                ServerResultException r10 = (Throwable) r9;
                if (this.a.isCancelled() == false) goto L6;
                return;
            L6:
                if ((r10 instanceof ServerResultException) == false) goto L9;
                ServerResultException r11 = r10;
                this.a.onError(new NetService.ServerErrorException(r11.getCode(), r11.getMsg(), r11.getData(), r11.getJson(), r11.getLogId()));
            L18:
                this.a.onComplete();
                return;
            L9:
                if ((r10 instanceof CloudReqFun.OkHttpReqException) == false) goto L14;
                HttpException r0 = ((CloudReqFun.OkHttpReqException) r10).exceptionObj;
                if ((r0 instanceof HttpException) == false) goto L13;
                Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.net.HttpException");
                HttpException r1 = r0;
                this.a.onError(new NetService.HttpErrorException(r1.getCode(), r1.getHttpStr()));
                goto L18
            L13:
                this.a.onError(r10);
                goto L18
            L14:
                FlowableEmitter<R> r2 = this.a;
                if (r10 != null) goto L17;
                r10 = new NullPointerException("convertPuller error null");
            L17:
                r2.onError(r10);
                goto L18
            }
        }

        public a(Flowable<R> r1) {
            this.a = r1;
        }

        public final void subscribe(FlowableEmitter<R> r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            this.a.subscribe(new C0261a(r4), new b(r4));
        }
    }

    public c(w<R> r1, OfficeUserNetServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.d
    public final Flowable<R> a(NetService.e r5) {
        w<R> r0 = this.a;
        OfficeUserNetServiceImpl r1 = this.b;
        Intrinsics.checkNotNull(r5);
        int r2 = OfficeUserNetServiceImpl.m;
        r1.getClass();
        if (r5.a != null) goto L5;
        r5.a = r1.e.a;
    L5:
        String r3 = r5.b;
        NetService.b r4 = r1.l;
        if (r5.i == false) goto L9;
        if (r4 == null) goto L9;
        r3 = r4.s0(r3);
    L9:
        x r6 = new x(r3);
        r6.h = r5.a;
        Map<String, String> r7 = r5.d;
        if (r7 == null) goto L12;
        HashMap r8 = new HashMap(r7);
        r6.c.putAll(r8);
    L12:
        Map<String, List<String>> r9 = r5.g;
        if (r9 == null) goto L16;
        r6.g = new HashMap(r9);
    L16:
        if (TextUtils.isEmpty(r5.j) == true) goto L18;
        r6.i = r5.j;
    L18:
        Map<String, String> r10 = r5.e;
        if (r10 == null) goto L21;
        r6.e.putAll(r10);
    L21:
        r6.f = r5.f;
        Map<String, String> r11 = r5.h;
        if (r11 == null) goto L24;
        r6.d.putAll(r11);
    L24:
        int r12 = r5.c;
        if (r12 != 2) goto L27;
        r6.a = 2;
    L32:
        return Flowable.create(new a(r0.a(r6)), BackpressureStrategy.BUFFER);
    L27:
        if (r12 == 3) goto L29;
        r6.a = 1;
        goto L32
    L29:
        r6.a = 3;
        goto L32
    }
}
