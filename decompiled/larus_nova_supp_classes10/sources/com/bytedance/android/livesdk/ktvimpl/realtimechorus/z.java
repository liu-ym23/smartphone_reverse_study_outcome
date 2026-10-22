package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.widget.ImageView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public z(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        sh6.b r12 = (sh6.b) r11;
        Integer r0 = this.a.k;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        com.bytedance.android.live.profit.dress.t r13 = (com.bytedance.android.live.profit.dress.t) sh6.c.b(r12);
        String r2 = null;
        if (r13 == null) goto L11;
        List r14 = r13.c;
        if (r14 == null) goto L11;
        com.bytedance.android.live.profit.dress.config.n r15 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r14, r1);
    L12:
        if (r15 == null) goto L77;
        if (r1 <= 0) goto L21;
        RealTimeChorusMainViewWidget r3 = this.a;
        r3.getClass();
        StringBuilder r4 = new StringBuilder("updateDressTheme, theme image url: ");
        py.k r5 = r15.getBgImage();
        if (r5 == null) goto L17;
        String r6 = KtvUtilsKt.g(r5);
    L18:
        r4.append(r6);
        w.a("RealTimeChorusMainViewWidget", r4.toString());
        HSImageView r7 = r3.y;
        if (r7 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r7);
        com.bytedance.android.live.ui.k.d(r7, r15.getBgImage(), r3.z, ImageView.ScaleType.FIT_XY, 0, new y0(r3, r15));
    L24:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r8 = this.a.Q;
        if (r8 == null) goto L80;
        Intrinsics.checkNotNullParameter(r15, "realTimeChorusStage");
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L76
        r9.put("eventName", "event_party_ktv_chorus_stage_update");     // Catch: Exception -> L76
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L76
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L76
        com.bytedance.android.live.profit.dress.config.e r17 = r15.getEvaluateConfig();     // Catch: Exception -> L76
        if (r17 == null) goto L32;
        py.k r18 = r17.getNiceIcon();     // Catch: Exception -> L76
        if (r18 == null) goto L32;
        String r19 = KtvUtilsKt.g(r18);     // Catch: Exception -> L76
    L33:
        r16.put(r19);     // Catch: Exception -> L76
        com.bytedance.android.live.profit.dress.config.e r20 = r15.getEvaluateConfig();     // Catch: Exception -> L76
        if (r20 == null) goto L38;
        py.k r21 = r20.getGoodIcon();     // Catch: Exception -> L76
        if (r21 == null) goto L38;
        String r22 = KtvUtilsKt.g(r21);     // Catch: Exception -> L76
    L39:
        r16.put(r22);     // Catch: Exception -> L76
        com.bytedance.android.live.profit.dress.config.e r23 = r15.getEvaluateConfig();     // Catch: Exception -> L76
        if (r23 == null) goto L44;
        py.k r24 = r23.getPerfectIcon();     // Catch: Exception -> L76
        if (r24 == null) goto L44;
        String r25 = KtvUtilsKt.g(r24);     // Catch: Exception -> L76
    L45:
        r16.put(r25);     // Catch: Exception -> L76
        r10.put("midi_leavel_list", r16);     // Catch: Exception -> L76
        r10.put("theme_color", r15.getThemeColor());     // Catch: Exception -> L76
        py.k r26 = r15.getLeadSingerIconImage();     // Catch: Exception -> L76
        if (r26 == null) goto L48;
        String r27 = KtvUtilsKt.g(r26);     // Catch: Exception -> L76
    L49:
        r10.put("leader_tag", r27);     // Catch: Exception -> L76
        py.k r28 = r15.getCloseEffectImage();     // Catch: Exception -> L76
        if (r28 == null) goto L52;
        String r29 = KtvUtilsKt.g(r28);     // Catch: Exception -> L76
    L53:
        r10.put("snuggle_prefect", r29);     // Catch: Exception -> L76
        JSONArray r30 = new JSONArray();     // Catch: Exception -> L76
        List r31 = r15.getVoiceWaveImages();     // Catch: Exception -> L76
        if (r31 == null) goto L59;
        Iterator<T> r32 = r31.iterator();     // Catch: Exception -> L76
    L57:
        if (r32.hasNext() == false) goto L59;
        r30.put(KtvUtilsKt.g((py.k) r32.next()));     // Catch: Exception -> L76
    L59:
        r10.put("snuggle_wove_array", r30);     // Catch: Exception -> L76
        com.bytedance.android.live.profit.dress.config.g r33 = r15.getStageEffectConfig();     // Catch: Exception -> L76
        if (r33 == null) goto L64;
        py.k r34 = r33.getBasicImage();     // Catch: Exception -> L76
        if (r34 == null) goto L64;
        r2 = KtvUtilsKt.g(r34);     // Catch: Exception -> L76
    L64:
        r10.put("background_image", r2);     // Catch: Exception -> L76
        JSONArray r35 = new JSONArray();     // Catch: Exception -> L76
        com.bytedance.android.live.profit.dress.config.g r110 = r15.getStageEffectConfig();     // Catch: Exception -> L76
        if (r110 == null) goto L72;
        List r111 = r110.getAdvanImageList();     // Catch: Exception -> L76
        if (r111 == null) goto L72;
        Iterator<T> r112 = r111.iterator();     // Catch: Exception -> L76
    L70:
        if (r112.hasNext() == false) goto L72;
        r35.put(KtvUtilsKt.g((py.k) r112.next()));     // Catch: Exception -> L76
    L72:
        r10.put("background_snuggle_animation_array", r35);     // Catch: Exception -> L76
        r9.put("stage", r10);     // Catch: Exception -> L76
        HybridCard r113 = r8.a;     // Catch: Exception -> L76
        if (r113 == null) goto L80;
        r113.sendJsEvent("event_party_ktv_chorus_stage_update", r9);     // Catch: Exception -> L76
        goto L80
    L52:
        r29 = null;
        goto L53
    L48:
        r27 = null;
    L44:
        r25 = null;
    L38:
        r22 = null;
    L32:
        r19 = null;
    L80:
        RealTimeChorusOperateView r114 = this.a.t;
        if (r114 == null) goto L88;
        r114.Z5();
        return;
    L88:
        return;
    L17:
        r6 = null;
        goto L18
    L21:
        HSImageView r36 = this.a.y;
        if (r36 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r36);
        goto L24
    L77:
        HSImageView r115 = this.a.y;
        if (r115 == null) goto L80;
        UtilityKotlinExtentionsKt.t(r115);
    L11:
        r15 = null;
        goto L12
    L5:
        r1 = 0;
        goto L6
    }
}
