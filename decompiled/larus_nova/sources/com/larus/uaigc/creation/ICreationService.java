package com.larus.uaigc.creation;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/creation/ICreationService;", "", "getAiReplicaWhiteTUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f372787a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/creation/ICreationService$Companion;", "Lcom/larus/uaigc/creation/ICreationService;", "<init>", "()V", "getAiReplicaWhiteTUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f372788c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationService f372789b;

        static {
            f372788c = new Companion();
        }

        @Override // com.larus.uaigc.creation.ICreationService
        public final Object a(Continuation<? super String> r100) {
            return this.f372789b.a(r100);
        }

        private Companion() {
            ICreationService r100 = (ICreationService) ServiceManager.get().getService(ICreationService.class);
            if (r100 != null) goto L5;
            r100 = new CreationServiceNoop();
        L5:
            this.f372789b = r100;
        }
    }

    static {
        f372787a = Companion.f372788c;
    }

    Object a(Continuation<? super String> r100);
}
