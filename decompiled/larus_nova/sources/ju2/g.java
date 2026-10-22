package ju2;

import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends j implements a, h<mm1.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f500466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final mm1.a f500467f;

    public final String toString() {
        return "com.bytedance.android.livesdk.vs.model.__ScopeImpl_VSDataCenterScope";
    }

    @Override // ju2.a
    public final DataCenter getDataCenter() {
        Object r100 = this.f500466e;
        if (r100 == null) goto L7;
        return (DataCenter) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f500467f;
    }

    public g(mm1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f500467f = r100;
        this.f500466e = k.f470908a;
    }
}
