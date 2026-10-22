package aw3;

import android.content.Intent;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class e0 implements Function0 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ e0(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Function1<AppletBackgroundAudioMediaSessionService, Unit> r0 = this.a;
        AppletBackgroundAudioMediaSessionService r1 = g0.c;
        if (r1 != null) goto L5;
    L8:
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r2 = g0.a;
        r2.add(r0);
        if (g0.e == true) goto L17;
        g0.e = true;
        com.bytedance.applet.audio.background.a r3 = new com.bytedance.applet.audio.background.a();
        g0.d = r3;
        AppHost.Companion r4 = AppHost.a;
        if (r4.getApplication().bindService(new Intent(r4.getApplication(), AppletBackgroundAudioMediaSessionService.class), r3, 1) == true) goto L15;
        g0.e = false;
        g0.d = null;
        r2.clear();
        FLogger.a.e("AppletBackgroundAudioMediaSessionController", "media session service bind failed. reason: bindService returned false");
    L15:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L5:
        if (r1.j == true) goto L7;
        r0.invoke(r1);
        return Unit.INSTANCE;
    L7:
        g0.d();
        goto L8
    }
}
