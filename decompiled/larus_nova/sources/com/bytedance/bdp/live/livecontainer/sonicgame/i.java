package com.bytedance.bdp.live.livecontainer.sonicgame;

import android.os.Bundle;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.SonicGamePlugin$initSonicContext$2;
import com.bytedance.bdp.bdpbase.core.AbsBdpAppStatusListener;
import com.bytedance.bdp.bdpbase.core.BdpAppInstanceEventListener;
import com.bytedance.bdp.bdpbase.core.IBdpAppInstance;
import com.bytedance.bdp.bdpbase.core.container.BdpAppContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends AbsBdpAppStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBdpAppInstance f201524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f201525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.bdp.live.livecontainer.sonicgame.b f201526c;

    public static final class a implements BdpAppInstanceEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f201527a;

        public a(i r100) {
            this.f201527a = r100;
        }

        @Override // com.bytedance.bdp.bdpbase.core.BdpAppInstanceEventListener
        public final Bundle onEvent(String r100, Bundle r101) {
            if (r101 == null) goto L5;
            Object r102 = r101.get("phase");
        L7:
            if (Intrinsics.areEqual(r102, "first_paint") == false) goto L11;
            com.bytedance.bdp.live.livecontainer.sonicgame.b r103 = this.f201527a.f201526c;
            if (r103 == null) goto L11;
            r103.onFirstFrame();
        L11:
            return null;
        L5:
            r102 = null;
            goto L7
        }
    }

    public static final class b implements BdpAppInstanceEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f201528a;

        public b(i r100) {
            this.f201528a = r100;
        }

        @Override // com.bytedance.bdp.bdpbase.core.BdpAppInstanceEventListener
        public final Bundle onEvent(String r100, Bundle r101) {
            if (r101 == null) goto L5;
            Object r102 = r101.get("phase");
        L7:
            if (Intrinsics.areEqual(r102, "first_paint") == false) goto L11;
            com.bytedance.bdp.live.livecontainer.sonicgame.b r103 = this.f201528a.f201526c;
            if (r103 == null) goto L11;
            r103.b();
        L11:
            return null;
        L5:
            r102 = null;
            goto L7
        }
    }

    @Override // com.bytedance.bdp.bdpbase.core.AbsBdpAppStatusListener, com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public final void onAppExit(int r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.AbsBdpAppStatusListener, com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public final void onLaunchProgress(int r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.AbsBdpAppStatusListener, com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public final void onAppCreate(IBdpAppInstance r100) {
        this.f201524a = r100;
        this.f201525b.f201529a = r100;
        r100.addEventListener("onGameKeyPhase", new a(this));
        r100.addEventListener("onGameFloatViewKeyPhase", new b(this));
    }

    public i(j r100, SonicGamePlugin$initSonicContext$2.a r101) {
        this.f201525b = r100;
        this.f201526c = r101;
    }

    @Override // com.bytedance.bdp.bdpbase.core.AbsBdpAppStatusListener, com.bytedance.bdp.bdpbase.core.BdpAppStatusListener
    public final void onLaunchFinish(int r100, String r101, Bundle r102) {
        if (r100 != 0) goto L10;
        com.bytedance.bdp.live.livecontainer.sonicgame.b r103 = this.f201526c;
        if (r103 == null) goto L22;
        String r104 = this.f201525b.f201530b;
        IBdpAppInstance r105 = this.f201524a;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bdpAppInstance");
    L9:
        r103.a(r104, new h(r104, r105));
        return;
    L22:
        return;
    L10:
        IBdpAppInstance r106 = this.f201524a;
        if (r106 == null) goto L18;
        r106.finish();
        IBdpAppInstance r107 = this.f201524a;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bdpAppInstance");
    L15:
        BdpAppContainer r108 = r107.getAppContainer();
        if (r108 == null) goto L18;
        r108.a();
    L18:
        com.bytedance.bdp.live.livecontainer.sonicgame.b r109 = this.f201526c;
        if (r109 == null) goto L24;
        r109.onFail(this.f201525b.f201530b, "sonic load error: " + r100 + ',' + r101);
        return;
    }
}
