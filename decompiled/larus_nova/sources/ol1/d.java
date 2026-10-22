package ol1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.ReplayDanmakuUtilsKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f524119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f524120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f524121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f524122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f524123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super a, Unit> f524124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f524125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pair<Integer, Integer> f524126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f524127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f524128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f524129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f524130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f524131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f524132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f524133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DataCenter f524134p;

    public d(int r100, Episode r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r101, "episode");
        Intrinsics.checkNotNullParameter(r102, "bindDataCenter");
        this.f524133o = r100;
        this.f524134p = r102;
        this.f524121c = "";
        this.f524122d = s1.B(R.string.ttlive_vs_danmaku_send_input_hint);
        this.f524123e = true;
        this.f524125g = R.layout.ttlive_dialog_replay_danmu_input;
        this.f524126h = TuplesKt.to(Integer.valueOf(R.drawable.ttlive_ic_panel_input_emoji), Integer.valueOf(R.drawable.ttlive_ic_panel_input_keyboard));
        ReplayDanmakuUtilsKt.c("FFFFFF");
        ReplayDanmakuUtilsKt.c("000000");
        this.f524127i = s1.h(R.color.ttlive_vs_danmaku_input_color);
        this.f524128j = 2;
        this.f524129k = 50;
        this.f524130l = "default";
        this.f524131m = "";
        this.f524132n = "";
    }
}
