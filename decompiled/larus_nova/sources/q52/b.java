package q52;

import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.e;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        if ((r100 instanceof e) == true) goto L5;
        return;
    L5:
        if (((e) r100).isPaused() == false) goto L7;
        EpisodeInteractivityTracer.c("resume message manager");
    L8:
        r100.startMessage();
        return;
    L7:
        EpisodeInteractivityTracer.c("start message manager");
        goto L8
    }

    @JvmStatic
    public static final void a(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_CURSOR);
        if ((r100 instanceof e) == false) goto L11;
        amc.e r102 = ((e) r100).q();
        if ((r102 instanceof a) == true) goto L7;
        r102 = null;
    L7:
        a r103 = (a) r102;
        if (r103 == null) goto L12;
        r103.a(r101);
        return;
    L12:
        return;
    }
}
