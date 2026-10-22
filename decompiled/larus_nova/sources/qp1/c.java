package qp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs.player.VSPlayerServiceImpl;
import com.bytedance.android.livesdk.chatroom.vs.player.tips.impl.VSPlayerTipServiceImpl;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements gr1.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, com.bytedance.android.livesdk.chatroom.vsplayer.api.b> f534329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, com.bytedance.android.livesdk.chatroom.vsplayer.api.c> f534330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mm1.a f534331c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public c(mm1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f534331c = r100;
        this.f534329a = new LinkedHashMap();
        this.f534330b = new LinkedHashMap();
    }

    @Override // gr1.a
    public final com.bytedance.android.livesdk.chatroom.vsplayer.api.b provideVSPlayerTipService(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r101 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.b) ((LinkedHashMap) this.f534329a).get(Integer.valueOf(r100.hashCode()));
        if (r101 != null) goto L9;
        VSPlayerTipServiceImpl r102 = new VSPlayerTipServiceImpl();
        this.f534329a.put(Integer.valueOf(r100.hashCode()), r102);
        ALogger.w(VSPlayerServiceImpl.TAG, "create IVSPlayerTipService for dataCenter:" + r100.hashCode() + ",now size:" + this.f534329a.size());
        return r102;
    L9:
        return r101;
    }

    @Override // gr1.a
    public final com.bytedance.android.livesdk.chatroom.vsplayer.api.c provideVSPlayerViewControlService(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.c) ((LinkedHashMap) this.f534330b).get(Integer.valueOf(r100.hashCode()));
        if (r101 != null) goto L9;
        wp1.a r102 = new wp1.a();
        this.f534330b.put(Integer.valueOf(r100.hashCode()), r102);
        ALogger.w(VSPlayerServiceImpl.TAG, "create IVSPlayerViewControlService for dataCenter:" + r100.hashCode() + ",now size:" + this.f534330b.size());
        return r102;
    L9:
        return r101;
    }

    @Override // gr1.a
    public final void releaseService(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ALogger.w(VSPlayerServiceImpl.TAG, "start do PlayerControlBrickService release for dataCenter:" + r100.hashCode());
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r101 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.c) ((LinkedHashMap) this.f534330b).get(Integer.valueOf(r100.hashCode()));
        if (r101 == null) goto L7;
        r101.releaseService();
    L7:
        int r102 = r100.hashCode();
        this.f534329a.remove(Integer.valueOf(r102));
        this.f534330b.remove(Integer.valueOf(r102));
    }
}
