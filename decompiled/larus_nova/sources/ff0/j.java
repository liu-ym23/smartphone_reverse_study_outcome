package ff0;

import android.util.Log;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements IFetchResourceListener {
    public j() {
    }

    @Override // com.ss.android.ugc.effectmanager.IFetchResourceListener
    public final void onFailure(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        d r101 = d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "down_load_lip_sync_model_result", -1, Log.getStackTraceString(r100), null, 16);
    }

    @Override // com.ss.android.ugc.effectmanager.IFetchResourceListener
    public final void onSuccess(long r100) {
        HamletAvatarContext r101 = HamletAvatarContext.Companion.getContext();     // Catch: Exception -> L9
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.isLipSyncModelDownloaded();     // Catch: Exception -> L9
        if (r102 == null) goto L7;
        r102.setValue(Boolean.TRUE);     // Catch: Exception -> L9
    L7:
        d r103 = d.f476647a;     // Catch: Exception -> L9
        com.bytedance.android.live.liveinteract.utils.j.a(1, "down_load_lip_sync_model_result", 0, null, null, 24);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        d r104 = d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "down_load_lip_sync_model_result", -1, Log.getStackTraceString(e), null, 16);
    }
}
