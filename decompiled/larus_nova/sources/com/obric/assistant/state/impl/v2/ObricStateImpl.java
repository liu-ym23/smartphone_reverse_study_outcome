package com.obric.assistant.state.impl.v2;

import com.larus.utils.y;
import com.obric.assistant.state.api.v2.IObricStateApi;
import com.obric.assistant.state.impl.v2.core.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/state/impl/v2/ObricStateImpl;", "Lcom/obric/assistant/state/api/v2/IObricStateApi;", "<init>", "()V", "isRealtimeCalling", "", "registerRealtimeCallStateObserver", "", "observer", "Lcom/obric/assistant/state/api/v2/RealtimeCallStateObserver;", "unregisterRealtimeCallStateObserver", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateImpl implements IObricStateApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<bha.a> f393176a = null;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    public ObricStateImpl() {
    }

    static {
        f393176a = new ArrayList();
    }

    @Override // com.obric.assistant.state.api.v2.IObricStateApi
    public final boolean a() {
        if (g.f393194d.f489924a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.state.api.v2.IObricStateApi
    public final void b(final bha.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        y.c(new eha.a(r100));
    }
}
