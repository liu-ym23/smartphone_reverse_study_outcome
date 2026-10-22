package il1;

import android.content.Context;
import android.view.LayoutInflater;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.viewholder.OfficialDanmakuViewHolder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends a<jq1.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490300a;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490300a = r100;
    }

    public final com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.viewholder.a b(jq1.b r100, com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.d r101, DataCenter r110) {
        return new OfficialDanmakuViewHolder(LayoutInflater.from(this.f490300a).inflate(R.layout.ttlive_replay_layout_landscape_talent, null), r100, r101, a.a(r101.f108999d), r110).f109041c;
    }
}
