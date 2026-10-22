package xp2;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IVoiceLiveTheme f564707a;

    public final long a() {
        return this.f564707a.getId();
    }

    public i(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f564707a = r100;
    }
}
