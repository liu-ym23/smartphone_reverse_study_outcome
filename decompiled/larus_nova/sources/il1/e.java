package il1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.m;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.n;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.view.VSGifDanmuTextView;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.ReplayDanmakuUtilsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends a<jq1.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490301a;

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490301a = r100;
    }

    public final d b(jq1.b r100, boolean r101, com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.d r102, DataCenter r110) {
        View r103 = LayoutInflater.from(this.f490301a).inflate(R.layout.ttlive_replay_layout_barrage_landscape_text, null);
        VSGifDanmuTextView r104 = (VSGifDanmuTextView) r103.findViewById(R.id.tv_danmaku_text);
        r104.d(r102, h.a(r110).idStr, r100.getChatContent());
        List<String> r111 = r100.b();
        if (r111 != null) goto L5;
        r111 = CollectionsKt.emptyList();
    L5:
        int r105 = ReplayDanmakuUtilsKt.a(r100, r102);
        boolean r106 = true;
        if (ReplayDanmakuUtilsKt.d(r100) == true) goto L8;
    L10:
        r104.setTextSingleColor(r105);
    L11:
        int r107 = m.f109019d;
        m r108 = m.a.a(r100, r102);
        float r109 = r108.f109020a;
        int r112 = r108.f109021b;
        r104.f109033f = r109;
        r104.f109034g = r112;
        r104.a();
        float r113 = r108.f109020a;
        r104.setShadowLayer(new jl1.a(r113, r113, r113, r108.f109022c));
        if (r101 == false) goto L22;
        List<String> r114 = r111;
        if (r114 != null) goto L16;
    L19:
        if (r106 == false) goto L21;
        r103.setBackgroundResource(R.drawable.ttlive_vs_bg_landscape_self_text_danmaku);
        goto L22
    L21:
        r103.setBackground(new n(ReplayDanmakuUtilsKt.c((String) ListProtector.get(r111, 0))));
        goto L22
    L16:
        if (r114.isEmpty() == true) goto L19;
        r106 = false;
    L22:
        r104.setTextSize(r102.f108996a.f109004b);
        ReplayDanmakuUtilsKt.b(r100, r102);
        return new d(r100, r103, r103, a.a(r102.f108999d));
    L8:
        if (r111.size() <= 1) goto L10;
        r104.setGradientColors(r111);
        goto L11
    }
}
