package com.larus.audioplayer.api.utils;

import com.bytedance.applet.aibridge.i;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001J-\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/larus/audioplayer/api/utils/MusicActionUtilDelegate;", "Lcom/larus/audioplayer/api/utils/IMusicActionUtil;", "<init>", "()V", "onDoraBudsEvent", "", "type", "", "key", "event", "onMusicKeyEvent", "musicId", "", "keyEvent", "source", "doraScene", "setMusicActionHandler", "musicActionHandler", "Lcom/larus/audioplayer/api/music/IMusicActionHandler;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicActionUtilDelegate implements IMusicActionUtil {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MusicActionUtilDelegate f290198b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMusicActionUtil f290199a;

    static {
        f290198b = new MusicActionUtilDelegate();
    }

    @Override // com.larus.audioplayer.api.utils.IMusicActionUtil
    public final void a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "musicActionHandler");
        this.f290199a.a(r100);
    }

    private MusicActionUtilDelegate() {
        IMusicActionUtil r100 = (IMusicActionUtil) ServiceManager.get().getService(IMusicActionUtil.class);
        if (r100 != null) goto L5;
        r100 = NoopMusicActionUtil.f290200a;
    L5:
        this.f290199a = r100;
    }
}
