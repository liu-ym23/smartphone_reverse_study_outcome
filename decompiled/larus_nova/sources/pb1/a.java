package pb1;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.ss.bytedance.ies.audiorecord.api.IAudioEffectService;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAudioEffectService f528407a;

    public a() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 == null) goto L5;
        IAudioEffectService r101 = (IAudioEffectService) r100.getOrNull(IAudioEffectService.class);
    L6:
        this.f528407a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
