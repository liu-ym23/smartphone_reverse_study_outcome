package com.bytedance.applet.aibridge.sound;

import android.app.Application;
import android.media.MediaPlayer;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import fna.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wv3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/sound/PlaySoundEffectMethod;", "Lcom/bytedance/applet/aibridge/sound/AbsPlaySoundEffectMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/sound/AbsPlaySoundEffectMethodIDL$PlaySoundEffectMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/sound/AbsPlaySoundEffectMethodIDL$PlaySoundEffectMethodResultModel;", "handleCollectType", "callbackFailure", "type", "", "errorMsg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaySoundEffectMethod extends AbsPlaySoundEffectMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public PlaySoundEffectMethod() {
    }

    public final void b(String r3, String r4, h<AbsPlaySoundEffectMethodIDL.b> r5) {
        FLogger.a.i("PlaySoundEffectMethod", r3 + " playing sound effect fail, errorMsg: " + r4);
        h.a.a(r5, r4, null, null, 14);
    }

    public final void handle(d r2, ParamModel r3, final h r4) {
        AbsPlaySoundEffectMethodIDL.a r5 = (AbsPlaySoundEffectMethodIDL.a) r3;
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (Intrinsics.areEqual(r5.getType(), "collect") == false) goto L11;
        AppHost.Companion r6 = AppHost.a;
        Application r7 = r6.getApplication();
        if (r6.getApplication().getResources() != null) goto L7;
        b("collect", "context_error", r4);
        return;
    L7:
        MediaPlayer r8 = MediaPlayer.create(r7, 2131820579);
        r8.setOnCompletionListener(new wv3.a(r4));
        r8.setOnErrorListener(new b(this, r4));
        if (g.d() == true) goto L10;
        r8.start();
        return;
    L10:
        r8.start();
        gna.a.c(r8.hashCode());
        return;
    L11:
        b(CommentPublishScene.UNKNOWN, "wrong_type:" + r5.getType(), r4);
    }
}
