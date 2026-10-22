package com.larus.trace.tracespan.span;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.platform.model.upload.ResourceUploadError;
import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.context.g;
import itc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jtc.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;
import yx9.c;

/* JADX INFO: loaded from: classes31.dex */
public final class SpanWrapImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f370163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f370164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f370165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Job f370166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile b f370167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f370168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f370169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f370170h;

    /* JADX INFO: renamed from: com.larus.trace.tracespan.span.SpanWrapImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.trace.tracespan.span.SpanWrapImpl$1", f = "SpanWrapImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SpanWrapImpl this$0;

        public AnonymousClass1(SpanWrapImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            if (this.this$0.hasEnd() == true) goto L14;
            c.f569437c.w("span id:" + this.this$0.a() + " timeout canceled");
            this.this$0.cancel(false);
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            long r103 = this.this$0.f370164b;
            this.label = 1;
            if (DelayKt.delay(r103, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.trace.tracespan.span.SpanWrapImpl$cancel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.trace.tracespan.span.SpanWrapImpl$cancel$1", f = "SpanWrapImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C115631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $needReport;
        int label;
        final /* synthetic */ SpanWrapImpl this$0;

        public C115631(SpanWrapImpl r100, boolean r101, Continuation<? super C115631> r102) {
            this.this$0 = r100;
            this.$needReport = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115631(this.this$0, this.$needReport, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115631) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r100);
            SpanWrapImpl r101 = this.this$0;
            List<b> r102 = r101.f370168f;
            boolean r103 = this.$needReport;
            monitor-enter(r102);
            List<b> r104 = r101.k();     // Catch: Throwable -> L23
            ((ArrayList) r101.f370168f).clear();     // Catch: Throwable -> L23
            Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L23
        L7:
            boolean r106 = false;
            if (r105.hasNext() == false) goto L14;
            b r107 = (b) r105.next();     // Catch: Throwable -> L23
            if (r103 == false) goto L12;
            r106 = true;
        L12:
            r107.cancel(r106);     // Catch: Throwable -> L23
            goto L7
        L14:
            if (r101.hasEnd() == true) goto L20;
            r101.d("trace_status", Boxing.boxInt(1));     // Catch: Throwable -> L23
            r101.d("error_code", Boxing.boxInt(-10000));     // Catch: Throwable -> L23
            r101.d("error_msg", "span cancel");     // Catch: Throwable -> L23
            if (r103 == false) goto L19;
            r106 = true;
        L19:
            r101.j(ResourceUploadError.CANCELED, r106);     // Catch: Throwable -> L23
        L20:
            monitor-exit(r102);
            return Unit.INSTANCE;
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String a() {
        return ((io.opentelemetry.api.internal.b) this.f370163a.b()).f492665c;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String f() {
        return "4-" + getTraceId() + '-' + a() + "-1";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTraceId() {
        return ((io.opentelemetry.api.internal.b) this.f370163a.b()).f492664b;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final boolean hasEnd() {
        if (Intrinsics.areEqual(this.f370169g, "end") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f370169g, ResourceUploadError.CANCELED) == true) goto L8;
        return false;
    }

    public final List<b> k() {
        List<b> r100 = this.f370168f;
        monitor-enter(r100);
        List<b> r101 = CollectionsKt.toMutableList(this.f370168f);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b getParent() {
        return this.f370167e;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTag() {
        return this.f370170h;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        xx9.a.a(this).b(r100);
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Iterator<String> r101 = r100.keys();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        Intrinsics.checkNotNull(r102);
        d(r102, r100.get(r102));
        goto L4
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void cancel(boolean r100) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new C115631(this, r100, null), 2, null);
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        List<b> r101 = this.f370168f;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f370168f).remove(r100) == true) goto L8;
    L12:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r101);
        return;
    L8:
        if (((ArrayList) this.f370168f).isEmpty() == false) goto L12;
        if (Intrinsics.areEqual(this.f370169g, "waiting") == false) goto L12;
        g(null, null);     // Catch: Throwable -> L15
        goto L12
    }

    public final void h(SpanWrapImpl r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        List<b> r101 = this.f370168f;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (hasEnd() == false) goto L10;
        c.f569437c.w("add child error, parent id:" + a() + " has end");     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L10:
        if (r100.hasEnd() == false) goto L15;
        c.f569437c.w("add child error, child id:" + r100.a() + " has end");     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L15:
        if (((ArrayList) this.f370168f).contains(r100) == true) goto L17;
        r100.i(this);     // Catch: Throwable -> L20
        ((ArrayList) this.f370168f).add(r100);     // Catch: Throwable -> L20
    L17:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
    }

    public final void i(b r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.f370167e == null) goto L6;
        c.f569437c.e("span id:" + a() + " has bind parent");
        return;
    L6:
        this.f370167e = r100;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f370170h = r100;
    }

    public SpanWrapImpl(i r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, "realSpan");
        this.f370163a = r100;
        this.f370164b = r110;
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(JobKt.Job$default(null, 1, null)));
        this.f370165c = r101;
        this.f370168f = new ArrayList();
        this.f370169g = "starting";
        this.f370170h = "";
        if (r110 <= 0) goto L6;
        this.f370166d = BuildersKt.launch$default(r101, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if ((r101 instanceof Integer) == false) goto L6;
        this.f370163a.a(e.a(r100), Long.valueOf(((Number) r101).intValue()));
    L21:
        return this;
    L6:
        if ((r101 instanceof Boolean) == false) goto L9;
        this.f370163a.a(io.opentelemetry.api.internal.i.a(r100, AttributeType.BOOLEAN), r101);
        goto L21
    L9:
        if ((r101 instanceof Long) == false) goto L12;
        this.f370163a.a(e.a(r100), r101);
        goto L21
    L12:
        if ((r101 instanceof Float) == false) goto L15;
        this.f370163a.a(io.opentelemetry.api.internal.i.a(r100, AttributeType.DOUBLE), Double.valueOf(((Number) r101).floatValue()));
        goto L21
    L15:
        if ((r101 instanceof Double) == false) goto L18;
        this.f370163a.a(io.opentelemetry.api.internal.i.a(r100, AttributeType.DOUBLE), r101);
        goto L21
    L18:
        if ((r101 instanceof String) == false) goto L20;
        this.f370163a.a(e.c(r100), r101);
        goto L21
    L20:
        c.f569437c.e("span attribute type not support");
        Unit r102 = Unit.INSTANCE;
        goto L21
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void g(Integer r100, String r101) {
        List<b> r102 = this.f370168f;
        monitor-enter(r102);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (hasEnd() == true) goto L17;
        if (r100 != null) goto L9;
        d("trace_status", 0);     // Catch: Throwable -> L20
    L14:
        if ((!k().isEmpty()) == false) goto L16;
        this.f370169g = "waiting";     // Catch: Throwable -> L20
        goto L17
    L16:
        j("end", true);     // Catch: Throwable -> L20
        goto L17
    L9:
        d("trace_status", 2);     // Catch: Throwable -> L20
        d("error_code", r100);     // Catch: Throwable -> L20
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        d("error_msg", r101);     // Catch: Throwable -> L20
    L17:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
    }

    public final void j(String r100, boolean r101) {
        Job r102 = this.f370166d;
        zx9.a r103 = null;
        if (r102 == null) goto L6;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L6:
        if (hasEnd() == false) goto L8;
        return;
    L8:
        this.f370169g = r100;
        if (r101 == false) goto L11;
        this.f370163a.end();
    L11:
        io.opentelemetry.context.c r104 = g.f492702b;
        if ((r104 instanceof zx9.a) == false) goto L14;
        r103 = (zx9.a) r104;
    L14:
        if (r103 == null) goto L16;
        r103.b(((io.opentelemetry.api.internal.b) this.f370163a.b()).f492664b, ((io.opentelemetry.api.internal.b) this.f370163a.b()).f492665c);
    L16:
        b r105 = this.f370167e;
        if (r105 == null) goto L20;
        r105.e(this);
        return;
    }
}
