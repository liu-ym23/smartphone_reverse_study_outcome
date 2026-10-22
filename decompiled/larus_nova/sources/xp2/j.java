package xp2;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x00.c f564708a;

    public final i a() {
        IVoiceLiveTheme r100 = this.f564708a.q(2);
        if (r100 != null) goto L7;
        return null;
    L7:
        return new i(r100);
    }

    public j(x00.c r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f564708a = r100;
    }
}
