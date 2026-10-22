package com.obric.assistant.state;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000eH\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/state/ObricSharedStateDelegate;", "Lcom/obric/assistant/state/ISharedStateService;", "<init>", "()V", "getSharedStateBoolean", "", "key", "", "defaultValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "getSharedStateInt", "", "(Ljava/lang/String;I)Ljava/lang/Integer;", "getSharedStateLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "getSharedStateString", "init", "", "prepareDoubaoData", "putSharedStateBoolean", "value", "putSharedStateInt", "putSharedStateLong", "putSharedStateString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSharedStateDelegate implements ISharedStateService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ObricSharedStateDelegate f392933c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ISharedStateService f392934b;

    static {
        f392933c = new ObricSharedStateDelegate();
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f392934b.a(r100, r101);
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final Integer b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f392934b.b(r100);
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final void c() {
        this.f392934b.c();
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final boolean d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f392934b.d(r100, r101);
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final Boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f392934b.e(r100);
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final boolean f(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f392934b.f(r100, r101);
    }

    @Override // com.obric.assistant.state.ISharedStateService
    public final void init() {
        this.f392934b.init();
    }

    private ObricSharedStateDelegate() {
        this.f392934b = (ISharedStateService) ServiceManager.get().getService(ISharedStateService.class);
    }
}
