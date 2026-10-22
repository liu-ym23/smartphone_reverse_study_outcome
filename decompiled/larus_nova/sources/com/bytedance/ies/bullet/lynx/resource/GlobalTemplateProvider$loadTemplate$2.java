package com.bytedance.ies.bullet.lynx.resource;

import bolts.Task;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import d8a.b;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/d1;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/bullet/service/base/d1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class GlobalTemplateProvider$loadTemplate$2 extends Lambda implements Function1<d1, Unit> {
    final /* synthetic */ b.a $callback;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d1 f247403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d8a.b.a f247404b;

        /* JADX INFO: renamed from: com.bytedance.ies.bullet.lynx.resource.GlobalTemplateProvider$loadTemplate$2$a$a, reason: collision with other inner class name */
        public static final class CallableC3536a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d8a.b.a f247405a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ byte[] f247406b;

            public CallableC3536a(d8a.b.a r100, byte[] r101) {
                this.f247405a = r100;
                this.f247406b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final Unit call() {
                d8a.b.a r100 = this.f247405a;
                if (r100 == null) goto L5;
                r100.onSuccess(this.f247406b);
                return Unit.INSTANCE;
            L5:
                return null;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public static final class b<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d8a.b.a f247407a;

            public b(d8a.b.a r100) {
                this.f247407a = r100;
            }

            @Override // java.util.concurrent.Callable
            public final Unit call() {
                d8a.b.a r100 = this.f247407a;
                if (r100 == null) goto L5;
                r100.onFailed("file not found");
                return Unit.INSTANCE;
            L5:
                return null;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public static final class c<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d8a.b.a f247408a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Throwable f247409b;

            public c(d8a.b.a r100, Throwable r101) {
                this.f247408a = r100;
                this.f247409b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final Unit call() {
                d8a.b.a r100 = this.f247408a;
                if (r100 == null) goto L5;
                r100.onFailed("stream write error, " + this.f247409b.getMessage());
                return Unit.INSTANCE;
            L5:
                return null;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public a(d1 r100, d8a.b.a r101) {
            this.f247403a = r100;
            this.f247404b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final Task<Unit> call() {
            InputStream r100 = this.f247403a.c();     // Catch: Throwable -> L23
            if (r100 == null) goto L35;
            d8a.b.a r101 = this.f247404b;     // Catch: Throwable -> L23
            ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L16
            ByteStreamsKt.copyTo$default(r100, r102, 0, 2, null);     // Catch: Throwable -> L11
            Task<Unit> r103 = Task.call(new CallableC3536a(r101, r102.toByteArray()), Task.UI_THREAD_EXECUTOR);     // Catch: Throwable -> L11
            CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L16
            CloseableKt.closeFinally(r100, null);     // Catch: Throwable -> L23
            return r103;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L16
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            CloseableKt.closeFinally(r100, th);     // Catch: Throwable -> L23
            throw th;     // Catch: Throwable -> L23
        L35:
            return Task.call(new b(this.f247404b), Task.UI_THREAD_EXECUTOR);
        L23:
            th = move-exception;
            return Task.call(new c(this.f247404b, th), Task.UI_THREAD_EXECUTOR);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public GlobalTemplateProvider$loadTemplate$2(b.a r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Task.call(new a(r100, this.$callback), Task.BACKGROUND_EXECUTOR);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d1 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
