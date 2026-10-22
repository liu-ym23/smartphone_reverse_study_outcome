package aw3;

import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class d0 implements Function0 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ d0(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        Function1 r0 = this.a;
        AppletBackgroundAudioMediaSessionService r1 = g0.c;
        if (r1 == null) goto L11;
        if ((!r1.j) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L11;
        r0.invoke(r1);
    L11:
        return Unit.INSTANCE;
    }
}
