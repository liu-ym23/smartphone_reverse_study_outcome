package i12;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends e33.j implements d, e33.h<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f487960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f487961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f487962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f487963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.room.a f487964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f487965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f487966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f487967l;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.scope.__ScopeImpl_GiftPanelScope";
    }

    @Override // i12.d
    public final LocateGiftInfo C() {
        Object r100 = this.f487960e;
        if (r100 == null) goto L7;
        return (LocateGiftInfo) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo");
    }

    @Override // i12.d, i12.e
    public Context getContext() {
        Object r100 = this.f487962g;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r100 = this.f487963h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r100 = this.f487964i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final g i() {
        g r100 = this.f487966k;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r100 = this.f487965j;
        if (r100 == null) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // i12.d
    public final Bundle q() {
        return (Bundle) this.f487961f;
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f487967l;
    }

    public q(e r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f487967l = r100;
        Object r101 = e33.k.f470908a;
        this.f487960e = r101;
        this.f487961f = r101;
        this.f487962g = r100.getContext();
        this.f487963h = r100.getDataCenter();
        this.f487964i = r100.getRoomContext();
        this.f487965j = Boolean.valueOf(r100.m());
        this.f487966k = r100.i();
    }
}
