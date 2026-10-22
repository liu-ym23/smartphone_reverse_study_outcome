package i12;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r extends e33.j implements e, e33.h<cy0.e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f487968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f487969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f487970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f487971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f487972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final cy0.e f487973j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.scope.__ScopeImpl_GiftScope";
    }

    @Override // i12.e
    public Context getContext() {
        Object r100 = this.f487968e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        Object r100 = this.f487969f;
        if (r100 == null) goto L7;
        return (DataCenter) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        Object r100 = this.f487970g;
        if (r100 == null) goto L7;
        return (com.bytedance.android.livesdk.revenue.room.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final g i() {
        Object r100 = this.f487972i;
        if (r100 == null) goto L7;
        return (g) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r100 = this.f487971h;
        if (r100 == null) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f487973j;
    }

    public r(cy0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f487973j = r100;
        Object r101 = e33.k.f470908a;
        this.f487968e = r101;
        this.f487969f = r101;
        this.f487970g = r101;
        this.f487971h = r101;
        this.f487972i = r101;
    }
}
