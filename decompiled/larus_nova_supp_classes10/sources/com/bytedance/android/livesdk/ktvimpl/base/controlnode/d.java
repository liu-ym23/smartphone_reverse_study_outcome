package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;
import com.bytedance.android.live.ktv.common.music.control.e;
import com.bytedance.android.live.ktv.common.music.control.g;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicActionType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mb0.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends e {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ long b;

        public a(d r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.a r12 = (com.bytedance.android.live.network.response.a) r11;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiPausePlayMusic, System.currentTimeMillis() - this.b, ((ExtraResponse) r12).logId);
            int r0 = f.a;
            d r1 = this.a;
            MusicPanel r2 = ((com.bytedance.android.live.ktv.common.music.control.d) r1).d;
            String r13 = ((ExtraResponse) r12).logId;
            boolean r3 = ((e) r1).h;
            Intrinsics.checkNotNullParameter(r2, "musicPanel");
            Intrinsics.checkNotNullParameter(r13, "logId");
            JSONObject r8 = new JSONObject();
            KtvMusic r4 = r2.a;
            if (r4 == null) goto L5;
            Long r5 = Long.valueOf(r4.getId());
        L6:
            mb0.e.a(r8, r5.longValue());
            KtvMusic r6 = r2.a;
            if (r6 == null) goto L10;
            String r7 = r6.getTitle();
            if (r7 == null) goto L10;
        L11:
            mb0.e.b(r8, r7);
            r8.put("logId", r13);
            r8.put("isPause", String.valueOf(r3));
            int r14 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.SongControl, "musicPause", 0, null, r8, 88);
            d r15 = this.a;
            MusicPanel r9 = ((com.bytedance.android.live.ktv.common.music.control.d) r15).d;
            Intrinsics.checkNotNullParameter(r9, "panel");
            Disposable r10 = ((com.bytedance.android.live.ktv.common.music.control.d) r15).b;
            if (r10 == null) goto L14;
            r10.dispose();
        L14:
            g r16 = ((com.bytedance.android.live.ktv.common.music.control.d) r15).c;
            if (r16 == null) goto L18;
            r16.b(new IMusicControlNode.b(r15.getType(), r9), r15);
            return;
        L18:
            return;
        L10:
            r7 = "";
            goto L11
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ long b;

        public b(d r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            ApiServerException r12 = (Throwable) r11;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiPausePlayMusic, System.currentTimeMillis() - this.b, r12);
            int r0 = f.a;
            d r1 = this.a;
            MusicPanel r2 = ((com.bytedance.android.live.ktv.common.music.control.d) r1).d;
            boolean r3 = ((e) r1).h;
            Intrinsics.checkNotNullParameter(r2, "musicPanel");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            JSONObject r8 = new JSONObject();
            KtvMusic r4 = r2.a;
            if (r4 == null) goto L5;
            Long r5 = Long.valueOf(r4.getId());
        L6:
            mb0.e.a(r8, r5.longValue());
            KtvMusic r6 = r2.a;
            if (r6 == null) goto L10;
            String r7 = r6.getTitle();
            if (r7 == null) goto L10;
        L11:
            mb0.e.b(r8, r7);
            r8.put("isPause", String.valueOf(r3));
            nd0.c.a.getClass();
            Pair r9 = nd0.c.t(r12, r8);
            int r10 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.SongControl, "musicPause", ((Number) r9.getFirst()).intValue(), (String) r9.getSecond(), r8, 64);
            if ((r12 instanceof ApiServerException) == false) goto L14;
            f2.c(r12.getPrompt(), 0);
        L14:
            d r13 = this.a;
            MusicPanel r14 = ((com.bytedance.android.live.ktv.common.music.control.d) r13).d;
            Intrinsics.checkNotNullParameter(r14, "panel");
            Disposable r15 = ((com.bytedance.android.live.ktv.common.music.control.d) r13).b;
            if (r15 == null) goto L17;
            r15.dispose();
        L17:
            g r16 = ((com.bytedance.android.live.ktv.common.music.control.d) r13).c;
            if (r16 == null) goto L21;
            r16.c(new IMusicControlNode.b(r13.getType(), r14), r13);
            return;
        L21:
            return;
        L10:
            r7 = "";
            goto L11
        L5:
            r5 = null;
            goto L6
        }
    }

    public final void e() {
        if (((e) this).g != null) goto L9;
        g r0 = ((com.bytedance.android.live.ktv.common.music.control.d) this).c;
        if (r0 == null) goto L14;
        r0.c(new IMusicControlNode.b(getType(), ((com.bytedance.android.live.ktv.common.music.control.d) this).d), this);
        return;
    L14:
        return;
    L9:
        if (((e) this).h == false) goto L11;
        MusicActionType r1 = MusicActionType.PAUSE;
    L12:
        long r2 = System.currentTimeMillis();
        KtvRoomApi r4 = (KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class);
        long r5 = ((com.bytedance.android.live.ktv.common.music.control.d) this).d.a.getMId();
        int r7 = r1.ordinal();
        IRoom r3 = ((e) this).g;
        Intrinsics.checkNotNull(r3);
        RxUtilKt.c(r4.pausePlayMusic(r5, r7, r3.getId(), ((com.bytedance.android.live.ktv.common.music.control.d) this).d.a.getSongType(), d5.c(((com.bytedance.android.live.ktv.common.music.control.d) this).d.a.getOrderUserIdString()), ((com.bytedance.android.live.ktv.common.music.control.d) this).d.a.getOrderUserIdString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r2), new b(this, r2)), ((com.bytedance.android.live.ktv.common.music.control.d) this).a);
        return;
    L11:
        r1 = MusicActionType.RESUME;
        goto L12
    }

    public d(MusicPanel r2, boolean r3, ModeType r4) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        super(r2, r3, r4);
    }
}
