package com.relax.relaxreact.prewarm.page;

import com.relax.relaxreact.d1;
import com.relax.relaxreact.e;
import com.relax.relaxreact.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\b\u0010\u000e\u001a\u00020\bH\u0007\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"PrewarmPage", "Lcom/relax/relaxreact/FC;", "", "getPrewarmPage$annotations", "()V", "getPrewarmPage", "()Lcom/relax/relaxreact/FC;", "_snapshot_PrewarmPage_0_4aac5e5e_cache", "Lcom/relax/relaxreact/Snapshot;", "get_snapshot_PrewarmPage_0_4aac5e5e_cache$annotations", "get_snapshot_PrewarmPage_0_4aac5e5e_cache", "()Lcom/relax/relaxreact/Snapshot;", "set_snapshot_PrewarmPage_0_4aac5e5e_cache", "(Lcom/relax/relaxreact/Snapshot;)V", "_snapshot_PrewarmPage_0_4aac5e5e", "relax-kmp-runtime_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PrewarmPageKt {
    private static final s<Unit> PrewarmPage = null;
    private static d1 _snapshot_PrewarmPage_0_4aac5e5e_cache;

    public static /* synthetic */ void getPrewarmPage$annotations() {
    }

    public static /* synthetic */ void get_snapshot_PrewarmPage_0_4aac5e5e_cache$annotations() {
    }

    static {
        PrewarmPage = e.a(PrewarmPageKt$PrewarmPage$1.INSTANCE);
    }

    public static final d1 _snapshot_PrewarmPage_0_4aac5e5e() {
        d1 r100 = _snapshot_PrewarmPage_0_4aac5e5e_cache;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "create");
        d1 r102 = new d1(r101, null, null, null, null, null);
        _snapshot_PrewarmPage_0_4aac5e5e_cache = r102;
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public static final s<Unit> getPrewarmPage() {
        return PrewarmPage;
    }

    public static final d1 get_snapshot_PrewarmPage_0_4aac5e5e_cache() {
        return _snapshot_PrewarmPage_0_4aac5e5e_cache;
    }

    public static final void set_snapshot_PrewarmPage_0_4aac5e5e_cache(d1 r100) {
        _snapshot_PrewarmPage_0_4aac5e5e_cache = r100;
    }
}
