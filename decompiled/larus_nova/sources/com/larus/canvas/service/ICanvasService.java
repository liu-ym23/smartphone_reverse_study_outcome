package com.larus.canvas.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import ny8.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&R\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/canvas/service/ICanvasService;", "", "openCanvasPage", "", "param", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "createCanvasRouterIntent", "Landroid/content/Intent;", "createCanvasPageArguments", "Landroid/os/Bundle;", "createCanvasFragment", "Landroidx/fragment/app/Fragment;", "args", "createCanvasRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "anchorEventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/canvas/service/bean/CanvasAnchorEvent;", "getAnchorEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICanvasService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f323793a = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u000b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096\u0001R\u001a\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/canvas/service/ICanvasService$Companion;", "Lcom/larus/canvas/service/ICanvasService;", "<init>", "()V", "createCanvasFragment", "Landroidx/fragment/app/Fragment;", "args", "Landroid/os/Bundle;", "createCanvasPageArguments", "param", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "createCanvasRouterIntent", "Landroid/content/Intent;", "createCanvasRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "openCanvasPage", "", "anchorEventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/canvas/service/bean/CanvasAnchorEvent;", "getAnchorEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICanvasService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f323794c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICanvasService f323795b;

        static {
            f323794c = new Companion();
        }

        @Override // com.larus.canvas.service.ICanvasService
        public final void a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            this.f323795b.a(r100);
        }

        @Override // com.larus.canvas.service.ICanvasService
        public final q97.a b() {
            return this.f323795b.b();
        }

        @Override // com.larus.canvas.service.ICanvasService
        public final Flow<ny8.a> c() {
            return this.f323795b.c();
        }

        @Override // com.larus.canvas.service.ICanvasService
        public final Fragment d(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "args");
            return this.f323795b.d(r100);
        }

        @Override // com.larus.canvas.service.ICanvasService
        public final Bundle f(e r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            return this.f323795b.f(r100);
        }

        private Companion() {
            ICanvasService r100 = (ICanvasService) ServiceManager.get().getService(ICanvasService.class);
            if (r100 != null) goto L5;
            r100 = new CanvasServiceNoop();
        L5:
            this.f323795b = r100;
        }
    }

    static {
        f323793a = Companion.f323794c;
    }

    void a(e r100);

    q97.a b();

    Flow<ny8.a> c();

    Fragment d(Bundle r100);

    Bundle f(e r100);
}
