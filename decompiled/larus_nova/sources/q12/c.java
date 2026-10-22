package q12;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import i12.e;
import i12.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends j implements a, h<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f531285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f531286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f531287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f531288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f531289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f531290j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.format.__ScopeImpl_FormatGiftPanelScope";
    }

    @Override // q12.a, i12.e
    public Context getContext() {
        Object r100 = this.f531285e;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r100 = this.f531286f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r100 = this.f531288h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final g i() {
        g r100 = this.f531289i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r100 = this.f531287g;
        if (r100 == null) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f531290j;
    }

    public c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f531290j = r100;
        Object r101 = k.f470908a;
        this.f531285e = r100.getContext();
        this.f531286f = r100.getDataCenter();
        this.f531287g = Boolean.valueOf(r100.m());
        this.f531288h = r100.getRoomContext();
        this.f531289i = r100.i();
    }
}
