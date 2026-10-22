package com.larus.canvas.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny8.c;
import ny8.d;
import ny8.f;
import ny8.i;
import ny8.j;
import ny8.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/larus/canvas/service/ICanvasRepoService;", "", "getCanvasBlockInfo", "", "request", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;", "callback", "Lcom/larus/canvas/service/bean/CommonCallback;", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoResp;", "pullCanvasBlockInfo", "Lcom/larus/canvas/service/bean/ICanvasSSEPullController;", "Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "Lcom/larus/canvas/service/bean/CanvasUpdateCallback;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICanvasRepoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f323790a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/canvas/service/ICanvasRepoService$Companion;", "Lcom/larus/canvas/service/ICanvasRepoService;", "<init>", "()V", "getCanvasBlockInfo", "", "request", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;", "callback", "Lcom/larus/canvas/service/bean/CommonCallback;", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoResp;", "pullCanvasBlockInfo", "Lcom/larus/canvas/service/bean/ICanvasSSEPullController;", "Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "Lcom/larus/canvas/service/bean/CanvasUpdateCallback;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICanvasRepoService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f323791c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICanvasRepoService f323792b;

        static {
            f323791c = new Companion();
        }

        @Override // com.larus.canvas.service.ICanvasRepoService
        public final j a(k r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "callback");
            return this.f323792b.a(r100, r101);
        }

        @Override // com.larus.canvas.service.ICanvasRepoService
        public final void b(f r100, d<i> r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f323792b.b(r100, r101);
        }

        private Companion() {
            ICanvasRepoService r100 = (ICanvasRepoService) ServiceManager.get().getService(ICanvasRepoService.class);
            if (r100 != null) goto L5;
            r100 = new CanvasRepoServiceNoop();
        L5:
            this.f323792b = r100;
        }
    }

    static {
        f323790a = Companion.f323791c;
    }

    j a(k r100, c r101);

    void b(f r100, d<i> r101);
}
