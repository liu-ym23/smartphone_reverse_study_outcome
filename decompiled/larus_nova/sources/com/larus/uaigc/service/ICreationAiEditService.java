package com.larus.uaigc.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/service/ICreationAiEditService;", "", "getCreationAiEditParams", "Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditParams;", "aiEditContext", "Lcom/larus/uaigc/bean/chat/gallery/AiEditFeatureContext;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationAiEditService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373895a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/service/ICreationAiEditService$Companion;", "Lcom/larus/uaigc/service/ICreationAiEditService;", "<init>", "()V", "getCreationAiEditParams", "Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditParams;", "aiEditContext", "Lcom/larus/uaigc/bean/chat/gallery/AiEditFeatureContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationAiEditService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373896c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationAiEditService f373897b;

        static {
            f373896c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationAiEditService
        public final jy9.e a(jy9.a r100) {
            Intrinsics.checkNotNullParameter(r100, "aiEditContext");
            return this.f373897b.a(r100);
        }

        private Companion() {
            ICreationAiEditService r100 = (ICreationAiEditService) ServiceManager.get().getService(ICreationAiEditService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationAiEditServiceNoop();
        L5:
            this.f373897b = r100;
        }
    }

    static {
        f373895a = Companion.f373896c;
    }

    jy9.e a(jy9.a r100);
}
