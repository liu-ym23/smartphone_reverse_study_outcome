package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class KtvMusicPlayer$bgmProgressListener$1$onError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Exception $exception;
    final /* synthetic */ int $statusCode;
    final /* synthetic */ KtvMusicPlayer.b this$0;

    public KtvMusicPlayer$bgmProgressListener$1$onError$1(KtvMusicPlayer.b r1, int r2, Exception r3) {
        this.this$0 = r1;
        this.$statusCode = r2;
        this.$exception = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m254invoke() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "onError " + this.$statusCode + ' ' + this.$exception);
        KtvMusicPlayer r0 = this.this$0.a;
        r0.h = false;
        r0.c("live_core_stop_music_callback_source");
        KtvMusicPlayer r1 = this.this$0.a;
        MusicPanel r2 = r1.b;
        if (r2 == null) goto L26;
        pd2.d r3 = pd2.d.n;
        String r4 = r1.a.name();
        int r5 = this.$statusCode;
        Exception r6 = this.$exception;
        r3.getClass();
        pd2.d.K(r2, r4, r5, r6);
        int r7 = xe2.g.a;
        int r8 = this.$statusCode;
        Exception r9 = this.$exception;
        if (r9 == null) goto L8;
        String r10 = r9.getMessage();
        if (r10 == null) goto L8;
    L9:
        String r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "errMsg");
        JSONObject r12 = new JSONObject();
        KtvMusic r13 = r2.a;
        String r14 = "";
        if (r13 == null) goto L12;
        Object r15 = Long.valueOf(r13.getMId());
    L13:
        r12.put("music_id", r15);
        KtvMusic r16 = r2.a;
        if (r16 == null) goto L17;
        String r17 = r16.getMTitle();
        if (r17 == null) goto L17;
    L18:
        r12.put("music_name", r17);
        InteractiveSongUserInfo r18 = r2.f();
        if (r18 == null) goto L24;
        String r19 = String.valueOf(r18.getId());
        if (r19 == null) goto L24;
        r14 = r19;
    L24:
        r12.put("order_user_id", r14);
        int r20 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "PlayMusicError", r8, r11, r12, 64);
        return;
    L17:
        r17 = "";
        goto L18
    L12:
        r15 = "";
    L8:
        r10 = "setBgm error";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m254invoke();
        return Unit.INSTANCE;
    }
}
