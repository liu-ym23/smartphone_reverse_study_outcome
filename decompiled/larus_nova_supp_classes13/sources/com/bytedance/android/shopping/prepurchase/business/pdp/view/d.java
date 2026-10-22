package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackVideoDataResponse;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackVideoStruct;
import com.bytedance.android.shopping.api.video.AVScene;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ AnchorV4PlaybackAreaV2 a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.f b;

    public d(AnchorV4PlaybackAreaV2 r1, com.bytedance.android.shopping.anchorv4.video.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r18) {
        PlaybackVideoDataResponse r1 = (PlaybackVideoDataResponse) r18;
        ECPDPBaseVideo r2 = r1.getVideoInfoV2();
        fj.d r3 = m73.a.a(r1.getVideoInfo());
        AnchorV4PlaybackAreaV2 r4 = this.a;
        Long r5 = r1.getCutOffset();
        if (r5 == null) goto L5;
        long r6 = r5.longValue();
    L6:
        r4.w = r6 * ((long) 1000);
        if (r3 != null) goto L10;
        if (r2 == null) goto L10;
        this.a.setVisibility(8);
        this.a.t = false;
        return;
    L10:
        this.a.c();
        AnchorV4PlaybackAreaV2 r7 = this.a;
        r7.u = r3;
        r7.v = r2;
        r7.t = true;
        PlayerBlock r8 = r7.f;
        if (r8 == null) goto L15;
        PlayerViewScene r9 = PlayerViewScene.SCENE_PLAY_BACK_VIDEO;
        if (r9 == null) goto L15;
        r8.z = r9;
    L15:
        Integer r10 = null;
        if (r8 == null) goto L18;
        PlayerBlock.m(r8, PlayAbilityUtil.b(r3, r2, null, 12), null, false, AVScene.CONTENT_PD_LIVE_REPLAY_WINDOW, new com.bytedance.android.shopping.api.video.d(false, true, 0, 0, false, 509), null, 36);
    L18:
        AnchorV4PlaybackAreaV2 r11 = this.a;
        ECPDPBaseVideo r12 = r11.v;
        if (r12 == null) goto L27;
        String r13 = r12.getVideoId();
        ECPDPBaseVideo r14 = this.a.v;
        if (r14 == null) goto L23;
        Integer r15 = Integer.valueOf(r14.getWidth());
    L24:
        ECPDPBaseVideo r16 = this.a.v;
        if (r16 == null) goto L39;
        r10 = Integer.valueOf(r16.getHeight());
    L39:
        if (r15 == null) goto L46;
        if (r10 == null) goto L46;
        int r17 = r10.intValue();
        int r19 = r15.intValue();
        PlayerBlock r20 = this.a.f;
        if (r20 == null) goto L46;
        Double r110 = Double.valueOf(0.0d);
        Double r111 = Double.valueOf(1.0d);
        double r21 = r17;
        Double r112 = Double.valueOf(170.0d / r21);
        Double r113 = Double.valueOf((((double) r19) + 170.0d) / r21);
        gj.b r22 = r20.f;
        if (r22 == null) goto L46;
        r22.e(2, r110, r111, r112, r113);
    L46:
        c r23 = new c(this);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L53;
        com.bytedance.android.shopping.anchorv4.video.f r24 = this.b;
        if (r24 != null) goto L51;
    L52:
        r23.run();
    L54:
        n73.a r25 = this.a.q;
        if (r25 == null) goto L59;
        r25.a(MapsKt.mapOf(TuplesKt.to("video_id", r13)));
        return;
    L59:
        return;
    L51:
        if (r24.e() == true) goto L54;
    L53:
        r23.run();
        goto L54
    L23:
        r15 = null;
        goto L24
    L27:
        fj.d r26 = r11.u;
        if (r26 == null) goto L30;
        String r27 = r26.c;
    L31:
        PlaybackVideoStruct r28 = r1.getVideoInfo();
        if (r28 == null) goto L34;
        Integer r29 = Integer.valueOf((int) r28.getWidth());
    L35:
        PlaybackVideoStruct r30 = r1.getVideoInfo();
        if (r30 == null) goto L38;
        r10 = Integer.valueOf((int) r30.getHeight());
    L38:
        r13 = r27;
        r15 = r29;
        goto L39
    L34:
        r29 = null;
        goto L35
    L30:
        r27 = null;
        goto L31
    L5:
        r6 = 0;
        goto L6
    }
}
