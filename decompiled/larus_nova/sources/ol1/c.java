package ol1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.dialog.ReplayDanmakuInputDialogFrom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final d a(@ReplayDanmakuInputDialogFrom int r100, Episode r101, DataCenter r102, ll1.a r103, boolean r104, Function0<Unit> r105, Function1<? super a, Unit> r106) {
        Intrinsics.checkNotNullParameter(r101, "episode");
        Intrinsics.checkNotNullParameter(r102, "bindDataCenter");
        Intrinsics.checkNotNullParameter(r103, "inputAttrs");
        d r107 = new d(r100, r101, r102);
        if (TextUtils.isEmpty(r103.f509672f) == true) goto L5;
        String r108 = String.valueOf(r103.f509672f);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f524121c = r108;
        r103.f509672f = "";
    L5:
        r107.f524120b = r104;
        r107.f524119a = r105;
        r107.f524124f = r106;
        r107.f524123e = true;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        Intrinsics.checkNotNullParameter("-1", "<set-?>");
        Intrinsics.checkNotNullParameter("default", "<set-?>");
        r107.f524130l = "default";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r107.f524131m = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r107.f524132n = "";
        if (r100 != 1) goto L8;
        Intrinsics.checkNotNullParameter("来条弹幕，让世界多点爱~", "<set-?>");
        r107.f524122d = "来条弹幕，让世界多点爱~";
        r107.f524128j = 1;
    L12:
        return r107;
    L8:
        if (r100 != 2) goto L12;
        Intrinsics.checkNotNullParameter("来条弹幕，让世界多点爱~", "<set-?>");
        r107.f524122d = "来条弹幕，让世界多点爱~";
        r107.f524128j = 1;
        goto L12
    }
}
