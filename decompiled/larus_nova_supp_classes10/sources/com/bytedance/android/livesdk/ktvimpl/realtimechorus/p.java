package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.BuoyMaterial;
import com.bytedance.android.livesdkapi.depend.message.FeedbackMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public static final MidiSkinDressInfo a(com.bytedance.android.live.profit.dress.t r4, String r5, int r6) {
        String r0 = null;
        if (r4 == null) goto L63;
        List r1 = r4.c;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L63;
        List r7 = r4.c;
        if (r7 == null) goto L63;
        com.bytedance.android.live.profit.dress.config.n r8 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r7, r6);
        if (r8 == null) goto L63;
        MidiSkinDressInfo r9 = new MidiSkinDressInfo();
        MidiSkinMaterial r3 = new MidiSkinMaterial();
        BuoyMaterial r10 = new BuoyMaterial();
        com.bytedance.android.live.profit.dress.config.f r11 = r8.getMidiConfig();
        if (r11 == null) goto L21;
        py.k r12 = r11.getBuoyBall();
    L22:
        r10.setBuoyBall(r12);
        com.bytedance.android.live.profit.dress.config.f r13 = r8.getMidiConfig();
        if (r13 == null) goto L25;
        py.k r14 = r13.getBuoyTailing();
    L26:
        r10.setBuoyTailing(r14);
        com.bytedance.android.live.profit.dress.config.f r15 = r8.getMidiConfig();
        if (r15 == null) goto L29;
        py.k r16 = r15.getUnivScatterDecoA();
    L30:
        r10.setUnivScatterDecoA(r16);
        com.bytedance.android.live.profit.dress.config.f r17 = r8.getMidiConfig();
        if (r17 == null) goto L33;
        py.k r18 = r17.getUnivScatterDecoB();
    L34:
        r10.setUnivScatterDecoB(r18);
        r10.setUnivScatterDecoC(null);
        com.bytedance.android.live.profit.dress.config.f r19 = r8.getMidiConfig();
        if (r19 == null) goto L37;
        py.k r20 = r19.getAdvanScatterDecoA();
    L38:
        r10.setAdvanScatterDecoA(r20);
        com.bytedance.android.live.profit.dress.config.f r21 = r8.getMidiConfig();
        if (r21 == null) goto L41;
        py.k r22 = r21.getAdvanScatterDecoB();
    L42:
        r10.setAdvanScatterDecoB(r22);
        Unit r23 = Unit.INSTANCE;
        r3.setBuoy(r10);
        BackgroundMaterial r24 = new BackgroundMaterial();
        com.bytedance.android.live.profit.dress.config.f r25 = r8.getMidiConfig();
        if (r25 == null) goto L45;
        py.k r26 = r25.getBuoyAreaBg();
    L46:
        r24.setBuoyAreaBg(r26);
        r24.setSongTitleBgImage(r8.getSongTitleBgImage());
        r24.setGlobalBg(null);
        r24.setScoreboardBg(null);
        r24.setToneLineStart(r8.getThemeColor());
        r24.setToneLineEnd(r8.getThemeColor());
        r3.setBg(r24);
        FeedbackMaterial r27 = new FeedbackMaterial();
        com.bytedance.android.live.profit.dress.config.e r28 = r8.getEvaluateConfig();
        if (r28 == null) goto L49;
        py.k r29 = r28.getNiceIcon();
    L50:
        r27.setNice(r29);
        com.bytedance.android.live.profit.dress.config.e r30 = r8.getEvaluateConfig();
        if (r30 == null) goto L53;
        py.k r31 = r30.getGoodIcon();
    L54:
        r27.setGood(r31);
        com.bytedance.android.live.profit.dress.config.e r32 = r8.getEvaluateConfig();
        if (r32 == null) goto L57;
        py.k r33 = r32.getPerfectIcon();
    L58:
        r27.setPerfect(r33);
        r27.setAdvanPerfectBg(null);
        r27.setAdvanPerfectTx(null);
        r3.setFeedback(r27);
        r3.setLyricColorValue(r8.getThemeColor());
        com.bytedance.android.live.profit.dress.config.f r34 = r8.getMidiConfig();
        if (r34 == null) goto L61;
        r0 = r34.getScoreColor();
    L61:
        r3.setScoreColor(r0);
        r9.setMaterial(r3);
        r9.setDressId(r5);
        return r9;
    L57:
        r33 = null;
        goto L58
    L53:
        r31 = null;
        goto L54
    L49:
        r29 = null;
        goto L50
    L45:
        r26 = null;
        goto L46
    L41:
        r22 = null;
        goto L42
    L37:
        r20 = null;
        goto L38
    L33:
        r18 = null;
        goto L34
    L29:
        r16 = null;
        goto L30
    L25:
        r14 = null;
        goto L26
    L21:
        r12 = null;
        goto L22
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L63:
        return null;
    }
}
