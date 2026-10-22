package com.larus.lbs.trace.api;

import ci9.b;
import com.larus.lbs.trace.api.model.LbsTraceInitializationStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/larus/lbs/trace/api/ILbsTraceService;", "", "init", "Lcom/larus/lbs/trace/api/model/LbsTraceInitializationStatus;", "report", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/lbs/trace/api/model/LbsTraceContextParam;", "event", "Lcom/larus/lbs/trace/api/model/LbsTraceEventParam;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILbsTraceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f355708a = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/larus/lbs/trace/api/ILbsTraceService$Companion;", "Lcom/larus/lbs/trace/api/ILbsTraceService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/lbs/trace/api/ILbsTraceService;", "impl$delegate", "Lkotlin/Lazy;", "init", "Lcom/larus/lbs/trace/api/model/LbsTraceInitializationStatus;", "report", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/lbs/trace/api/model/LbsTraceContextParam;", "event", "Lcom/larus/lbs/trace/api/model/LbsTraceEventParam;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ILbsTraceService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f355709b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<ILbsTraceService> f355710c = null;

        private Companion() {
        }

        static {
            f355709b = new Companion();
            f355710c = LazyKt.lazy(new bi9.a());
        }

        @Override // com.larus.lbs.trace.api.ILbsTraceService
        public final LbsTraceInitializationStatus init() {
            ILbsTraceService r100 = f355710c.getValue();
            if (r100 == null) goto L7;
            LbsTraceInitializationStatus r101 = r100.init();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return LbsTraceInitializationStatus.FAILED;
        }

        @Override // com.larus.lbs.trace.api.ILbsTraceService
        public final void a(ci9.a r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "event");
            ILbsTraceService r102 = f355710c.getValue();
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    static {
        f355708a = Companion.f355709b;
    }

    void a(ci9.a r100, b r101);

    LbsTraceInitializationStatus init();
}
