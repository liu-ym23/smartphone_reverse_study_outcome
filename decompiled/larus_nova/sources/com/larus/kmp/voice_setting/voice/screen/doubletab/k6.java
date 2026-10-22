package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import com.larus.kmp.voice_setting.voice.component.VoiceEditAreaLayoutMode;
import com.larus.kmp.voice_setting.voice.component.VoiceEditMode;
import com.larus.kmp.voice_setting.voice.component.VoiceListKind;
import com.larus.kmp.voice_setting.voice.component.t8;
import com.larus.kmp.voice_setting.voice.component.u8;
import com.larus.kmp.voice_setting.voice.mix.VoiceMixPlayVisualState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes30.dex */
public final class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<CoroutineScope> f354423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f354424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4 f354425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m6 f354426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e5 f354427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w6 f354428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m4 f354429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VoiceDoubleTabPageController f354430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VoiceDoubleTabPitchRateController f354431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final VoiceDoubleTabSelectionController f354432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g7 f354433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VoiceDoubleTabSessionController f354434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final VoiceDoubleTabSaveController f354435m;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r40v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v67, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v35, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v4 */
    public final void d() {
        g7 r100 = this.f354433k;
        i4 r101 = r100.f354334a;
        g5 r102 = (g5) CollectionsKt.getOrNull(r101.f354369c, r101.f354370d);
        if (r102 == null) goto L5;
        String r103 = r102.a();
    L6:
        boolean r110 = r100.f354334a.f354383q.a();
        if (r110 == false) goto L17;
        List<MixVoice> r104 = r100.f354334a.f354382p;
        ?? r105 = new ArrayList();
        Iterator r106 = ((ArrayList) r104).iterator();
    L10:
        if (r106.hasNext() == false) goto L18;
        Object r107 = r106.next();
        if (((MixVoice) r107).getVoiceItem() == null) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L10;
        r105.add(r107);
        goto L10
    L14:
        r108 = false;
    L18:
        ?? r111 = r105;
        if (r110 == true) goto L21;
    L26:
        SpeakerVoice r109 = r100.f354334a.f354372f;
        if (r109 != null) goto L30;
        r109 = r100.f354336c.invoke();
    L30:
        if (r100.f354334a.f354372f != null) goto L65;
        if (r109 == null) goto L33;
        l4 r112 = r100.f354337d.invoke(r109);
    L34:
        i4 r113 = r100.f354334a;
        r113.f354372f = r109;
        String r114 = r113.f354371e;
        if (r114 != null) goto L39;
        if (r109 == null) goto L38;
        r114 = r109.getId();
        goto L39
    L38:
        r114 = null;
    L39:
        r113.f354371e = r114;
        i4 r115 = r100.f354334a;
        if (r112 == null) goto L43;
        com.larus.kmp.voice_setting.voice.editvoice.f r116 = r112.f354457a;
        if (r116 == null) goto L43;
    L44:
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r115.f354373g = r116;
        i4 r117 = r100.f354334a;
        if (r109 == null) goto L54;
        if (r112 != null) goto L48;
    L50:
        boolean r118 = false;
    L51:
        if (r118 == true) goto L54;
        boolean r119 = false;
    L55:
        r117.f354374h = r119;
        com.larus.kmp.voice_setting.voice.component.v4 r120 = r117.f354367a;
        if (r109 == null) goto L65;
        if (r120 == null) goto L65;
        if (r112 != null) goto L60;
    L62:
        boolean r121 = false;
    L63:
        if (r121 == true) goto L65;
        r100.f354338e.invoke(r120, r109, "publishResolved");
        goto L65
    L60:
        if (r112.f354458b != true) goto L62;
        r121 = true;
        goto L63
    L48:
        if (r112.f354458b != true) goto L50;
        r118 = true;
    L54:
        r119 = true;
    L43:
        r116 = c8.a(r109);
        goto L44
    L33:
        r112 = null;
    L65:
        p6 r122 = r100.f354334a.f354368b;
        if (r122 == null) goto L74;
        String r123 = r122.f354573d;
        if (r123 == null) goto L74;
        if ((!StringsKt.isBlank(r123)) == true) goto L73;
        r123 = null;
    L73:
        if (r123 == null) goto L74;
    L80:
        i4 r124 = r100.f354334a;
        List<? extends g5> r125 = r124.f354369c;
        int r126 = r124.f354370d;
        String r127 = r124.f354371e;
        com.larus.kmp.voice_setting.voice.editvoice.f r128 = r124.f354373g;
        k7 r129 = r124.f354383q;
        long r130 = r124.f354390x;
        boolean r131 = r124.f354389w;
        String r132 = r124.f354375i;
        VoiceMixPlayVisualState r133 = r124.f354376j;
        VoiceDoubleTabPreviewIndicatorScope r134 = r124.f354377k;
        n8 r135 = r124.f354384r;
        p6 r136 = r124.f354368b;
        if (r136 == null) goto L84;
        String r137 = r136.f354573d;
        if (r137 == null) goto L84;
    L90:
        boolean r138 = r124.f354391y;
        Intrinsics.checkNotNullParameter(r125, "pageOwners");
        Intrinsics.checkNotNullParameter(r111, "currentMixVoiceList");
        Intrinsics.checkNotNullParameter(r128, "currentPitchAndRate");
        Intrinsics.checkNotNullParameter(r129, "selectModeSnapshot");
        Intrinsics.checkNotNullParameter(r133, "previewPlayState");
        Intrinsics.checkNotNullParameter(r134, "previewIndicatorScope");
        Intrinsics.checkNotNullParameter(r135, "ttsBackgroundPlayState");
        Intrinsics.checkNotNullParameter(r123, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r137, "botLanguage");
        g5 r139 = (g5) CollectionsKt.getOrNull(r125, r126);
        List<? extends g5> r140 = r125;
        String r310 = r103;
        ArrayList r141 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r140, 10));
        Iterator r142 = r140.iterator();
        int r143 = 0;
    L92:
        if (r142.hasNext() == false) goto L104;
        Object r210 = r142.next();
        int r311 = r143 + 1;
        if (r143 >= 0) goto L96;
        CollectionsKt.throwIndexOverflow();
    L96:
        g5 r211 = (g5) r210;
        Iterator r410 = r142;
        String r212 = r211.a();
        String r411 = r127;
        String r144 = r211.f().f354312b;
        String r412 = r137;
        VoiceListKind r145 = r211.f().f354313c;
        com.larus.kmp.voice_setting.voice.editvoice.f r413 = r128;
        com.larus.kmp.voice_setting.voice.base.api.i r146 = r211.f().f354314d;
        if (r146 == null) goto L99;
        int r312 = r146.f351777c;
    L100:
        if (r143 != r126) goto L102;
        boolean r313 = true;
    L103:
        r141.add(new t8(r212, r144, r143, r145, r312, r313, 160));
        r143 = r311;
        r142 = r410;
        r127 = r411;
        r137 = r412;
        r128 = r413;
        goto L92
    L102:
        r313 = false;
        goto L103
    L99:
        r312 = 0;
        goto L100
    L104:
        String r414 = r137;
        String r415 = r127;
        com.larus.kmp.voice_setting.voice.editvoice.f r416 = r128;
        ArrayList r147 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r140, 10));
        Iterator r148 = r140.iterator();
    L106:
        if (r148.hasNext() == false) goto L108;
        g5 r149 = (g5) r148.next();
        r147.add(new com.larus.kmp.voice_setting.voice.component.w3(r149.a(), r149.f().f354312b, 60));
        r148 = r148;
        goto L106
    L108:
        Intrinsics.checkNotNullParameter(r123, UserInfo.LANGUAGECODE);
        if (Intrinsics.areEqual(r123, "en") == false) goto L111;
    L114:
        boolean r150 = true;
    L115:
        FlowRuntime.b().a().isOversea();
        if (com.larus.kmp.voice_setting.voice.utils.h.f355098a.c().f527490a == false) goto L119;
        if (r150 == false) goto L119;
    L121:
        boolean r151 = true;
    L123:
        String r152 = com.larus.kmp.voice_setting.platform.x.b(VoiceStringKey.LARUS_BOT_SETTING_VOICE, new Object[0]);
        String r153 = com.larus.kmp.voice_setting.platform.x.b(VoiceStringKey.LARUS_MODIFY_BOT_VOICE_CANCEL_BTN, new Object[0]);
        String r154 = com.larus.kmp.voice_setting.platform.x.b(VoiceStringKey.LARUS_BOT_SETTING_VOICE_USE, new Object[0]);
        Intrinsics.checkNotNullParameter(r152, "title");
        Intrinsics.checkNotNullParameter(r153, "leadingText");
        Intrinsics.checkNotNullParameter(r154, "trailingText");
        lh9.b r155 = lh9.a.a();
        if (r109 == null) goto L126;
        String r213 = r109.getId();
    L127:
        if (r109 == null) goto L129;
        String r156 = r109.getName();
    L130:
        if (r156 != null) goto L132;
        String r214 = "";
    L133:
        if (r109 == null) goto L135;
        String r314 = r109.getStyleId();
    L136:
        if (r109 == null) goto L140;
        AudioPreview r157 = r109.getPreview();
        if (r157 == null) goto L140;
        String r315 = r157.getPreviewAudio();
    L141:
        if (r109 == null) goto L145;
        AudioPreview r158 = r109.getPreview();
        if (r158 == null) goto L145;
        String r316 = r158.getMd5();
    L146:
        com.larus.kmp.voice_setting.voice.component.e6 r317 = new com.larus.kmp.voice_setting.voice.component.e6(r213, r214, r314, r315, r316);
        if (r110 == false) goto L180;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        int r215 = r126;
        ?? r159 = new ArrayList();
        Iterator r160 = ((Iterable) r111).iterator();
    L150:
        if (r160.hasNext() == false) goto L196;
        MixVoice r216 = (MixVoice) r160.next();
        SpeakerVoice r217 = r216.getVoiceItem();
        if (r217 != null) goto L154;
        com.larus.kmp.voice_setting.voice.component.d5 r161 = null;
    L177:
        if (r161 == null) goto L179;
        r159.add(r161);
    L179:
        r160 = r160;
        goto L150
    L154:
        String r417 = r217.getId();
        String r318 = r217.getName();
        if (r318 != null) goto L157;
        String r418 = "";
    L158:
        String r419 = r217.getStyleId();
        Integer r218 = Integer.valueOf(r216.getPercentage());
        if (r218.intValue() <= 0) goto L161;
        boolean r319 = true;
    L162:
        if (r319 == true) goto L165;
        r218 = null;
    L165:
        if (r218 == null) goto L167;
        int r420 = r218.intValue();
    L168:
        AudioPreview r219 = r217.getPreview();
        if (r219 == null) goto L171;
        String r421 = r219.getPreviewAudio();
    L172:
        AudioPreview r220 = r217.getPreview();
        if (r220 == null) goto L175;
        String r510 = r220.getMd5();
    L176:
        r161 = new com.larus.kmp.voice_setting.voice.component.d5(r417, r418, r419, r420, r421, r510);
        goto L177
    L175:
        r510 = null;
        goto L176
    L171:
        r421 = null;
        goto L172
    L167:
        r420 = 100;
        goto L168
    L161:
        r319 = false;
        goto L162
    L157:
        r418 = r318;
    L196:
        ?? r422 = r159;
        if (r110 == true) goto L199;
    L201:
        boolean r162 = false;
    L202:
        if (r110 == false) goto L205;
        if (r162 == true) goto L205;
        String r163 = r155.f509301f;
    L206:
        String r423 = r163;
        int r164 = r422.size();
        Intrinsics.checkNotNullParameter(r129, "selectModeSnapshot");
        if (r110 == true) goto L209;
    L211:
        if (r110 == false) goto L215;
        VoiceEditMode r165 = VoiceEditMode.MULTI;
    L213:
        VoiceEditMode r166 = r165;
        if (r162 == false) goto L222;
        VoiceEditAreaLayoutMode r167 = VoiceEditAreaLayoutMode.SELECTED_SINGLE;
    L223:
        VoiceEditAreaLayoutMode r221 = r167;
        if (r110 == true) goto L226;
        if (r109 == null) goto L230;
    L229:
        boolean r222 = true;
    L231:
        if (r222 == true) goto L234;
        VoiceEditMode r168 = VoiceEditMode.NONE;
    L233:
        VoiceEditMode r511 = r168;
        if (r134 != VoiceDoubleTabPreviewIndicatorScope.TOP_SINGLE) goto L248;
        if (r110 == true) goto L248;
        if (r109 == null) goto L244;
        String r169 = r109.getId();
    L246:
        if (Intrinsics.areEqual(r169, r132) == false) goto L248;
        boolean r170 = true;
    L250:
        if (r134 != VoiceDoubleTabPreviewIndicatorScope.LIST_AND_MIX_ITEM) goto L260;
        if (r110 == false) goto L260;
        if (r132 != null) goto L254;
    L257:
        boolean r171 = true;
    L258:
        if (r171 == true) goto L260;
        boolean r172 = true;
    L262:
        if (r134 != VoiceDoubleTabPreviewIndicatorScope.MIXED_PREVIEW) goto L267;
        if (r110 == false) goto L267;
        if (Intrinsics.areEqual(r132, "__mix_preview__") == false) goto L267;
        boolean r173 = true;
    L268:
        if (r170 == true) goto L273;
        if (r172 == true) goto L273;
        if (r173 == true) goto L273;
        VoiceMixPlayVisualState r174 = VoiceMixPlayVisualState.Idle;
    L274:
        if (r173 == false) goto L276;
        VoiceMixPlayVisualState r320 = r133;
    L277:
        if (r110 == false) goto L293;
        Iterator r175 = ((Iterable) r111).iterator();
    L280:
        if (r175.hasNext() == false) goto L288;
        Object r176 = r175.next();
        SpeakerVoice r177 = ((MixVoice) r176).getVoiceItem();
        if (r177 == null) goto L284;
        String r178 = r177.getId();
    L286:
        if (Intrinsics.areEqual(r178, r132) == false) goto L280;
    L289:
        MixVoice r179 = (MixVoice) r176;
        if (r179 == null) goto L293;
        SpeakerVoice r180 = r179.getVoiceItem();
        if (r180 == null) goto L293;
    L294:
        if (r180 != null) goto L296;
        com.larus.kmp.voice_setting.platform.q0 r512 = null;
    L305:
        if (r110 == false) goto L310;
        int r181 = 1;
        if (r111.size() <= 1) goto L311;
        r416 = r416;
        com.larus.kmp.voice_setting.voice.editvoice.b r424 = com.larus.kmp.voice_setting.voice.editvoice.c.a(r111, r416, r414);
    L312:
        w3 r182 = new w3(r152, r153, r154, r181);
        v r183 = new v(r151, com.larus.kmp.voice_setting.platform.x.b(VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_CLONE_VOICE_BTN2, new Object[0]));
        if (r415 != null) goto L317;
        if (r109 == null) goto L316;
        String r184 = r109.getId();
    L318:
        String r185 = r184;
        int r186 = 10;
    L319:
        LinkedHashMap r187 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r140, r186)), 16));
        Iterator r188 = r140.iterator();
    L321:
        if (r188.hasNext() == false) goto L323;
        g5 r189 = (g5) r188.next();
        Pair r190 = TuplesKt.to(r189.a(), r189.getState());
        r187.put(r190.getFirst(), r190.getSecond());
        goto L321
    L323:
        com.larus.kmp.voice_setting.voice.editvoice.f r223 = r416;
        com.larus.kmp.voice_setting.voice.component.y3 r425 = new com.larus.kmp.voice_setting.voice.component.y3(r182, r183, r310, r185, r135, r187, new com.larus.kmp.voice_setting.voice.component.x3(r147, r310, 252), new u8(r141, r215, r215, r310, r138), 3648);
        if (r139 == null) goto L327;
        com.larus.kmp.voice_setting.voice.component.b5 r191 = r139.getState();
        if (r191 == null) goto L327;
    L328:
        com.larus.kmp.voice_setting.voice.component.b5 r192 = r191;
        if (r166 == VoiceEditMode.NONE) goto L331;
        boolean r193 = true;
    L332:
        boolean r194 = r129.f354441f;
        boolean r195 = r129.f354442g;
        if (r166 != VoiceEditMode.MULTI) goto L335;
        boolean r224 = true;
    L336:
        com.larus.kmp.voice_setting.voice.bridge.o r196 = new com.larus.kmp.voice_setting.voice.bridge.o(r425, r192, new com.larus.kmp.voice_setting.voice.component.s4(r166, r193, r222, r221, r194, r195, r224, r131, r130, r317, r223, new com.larus.kmp.voice_setting.voice.component.r4(r423, r155.f509296a, r155.f509297b, r155.f509298c, r155.f509299d), r422.size(), r320, r424, r512, 65536), new com.larus.kmp.voice_setting.voice.component.i5(r511, r317, r422, r174, r132, new com.larus.kmp.voice_setting.voice.component.e5(r155.f509301f, r155.f509302g, r155.f509303h), r424, r512, 2083), 1);
        Function1<String, Unit> r197 = r100.f354339f;
        StringBuilder r198 = new StringBuilder("[publish] selectedIndex=");
        r198.append(r100.f354334a.f354370d);
        r198.append(", selectedTab=");
        if (r310 != null) goto L339;
        String r199 = "";
    L340:
        r198.append(r199);
        r198.append(", pageCount=");
        r198.append(r196.f351880b.f352636i.f352570a.size());
        r198.append(", listKind=");
        r198.append(r196.f351881c.f352162a);
        r198.append(", rowCount=");
        r198.append(r196.f351881c.f352164c.f353451a.size());
        r198.append(", mixMode=");
        r198.append(r110);
        r198.append(", mixCount=");
        r198.append(r196.f351883e.f352294e.size());
        r198.append(", hasContent=");
        r198.append(r196.f351882d.f352531c);
        r198.append(", editMode=");
        r198.append(r196.f351882d.f352529a);
        r198.append(", mixContentMode=");
        r198.append(r196.f351883e.f352292c);
        r198.append(", layout=");
        r198.append(r196.f351882d.f352532d);
        r198.append(", collapsed=");
        r198.append(r196.f351882d.f352536h);
        r198.append(", emptyTextKind=");
        if (r110 == false) goto L343;
        String r200 = "mix";
    L344:
        r198.append(r200);
        r198.append(", expandToken=");
        r198.append(r100.f354334a.f354390x);
        r198.append(", emptyText=");
        r198.append(r196.f351882d.f352540l.f352504a);
        r198.append(", mix=");
        r198.append(o4.b(r111));
        r198.append(", activePreview=");
        String r201 = r100.f354334a.f354375i;
        if (r201 != null) goto L347;
        r201 = "";
    L347:
        r198.append(r201);
        r198.append(", playState=");
        r198.append(r196.f351883e.f352296g);
        r198.append(", ctaPlayState=");
        r198.append(r196.f351882d.f352542n);
        r198.append(", previewScope=");
        r198.append(r100.f354334a.f354377k);
        r198.append(", previewSource=");
        r198.append(r100.f354334a.f354378l);
        r198.append(", bgPlayVisible=");
        r198.append(r100.f354334a.f354384r.f354527a);
        r198.append(", bgPlayChecked=");
        r198.append(r100.f354334a.f354384r.f354528b);
        r198.append(", bgPlayDirty=");
        r198.append(r100.f354334a.f354384r.a());
        r197.invoke(r198.toString());
        Function1<String, Unit> r202 = r100.f354339f;
        StringBuilder r203 = new StringBuilder("[bridge:publish:footers] selectedTab=");
        if (r310 != null) goto L350;
        String r204 = "";
    L351:
        r203.append(r204);
        r203.append(" owners=");
        r203.append(CollectionsKt.joinToString$default(r100.f354334a.f354369c, null, null, null, 0, null, new f7(), 31, null));
        r202.invoke(r203.toString());
        r100.f354335b.setValue(r196);
        return;
    L350:
        r204 = r310;
        goto L351
    L343:
        r200 = "single";
        goto L344
    L339:
        r199 = r310;
        goto L340
    L335:
        r224 = false;
        goto L336
    L331:
        r193 = false;
    L327:
        r191 = new com.larus.kmp.voice_setting.voice.component.b5(VoiceListKind.PUBLIC, null, null, null, 30);
        goto L328
    L316:
        r186 = 10;
        r185 = null;
        goto L319
    L317:
        r184 = r415;
    L311:
        r424 = null;
        goto L312
    L310:
        r181 = 1;
        goto L311
    L296:
        String r513 = r180.getStyleId();
        AudioPreview r205 = r180.getPreview();
        if (r205 == null) goto L299;
        String r514 = r205.getPreviewAudio();
    L300:
        AudioPreview r206 = r180.getPreview();
        if (r206 == null) goto L303;
        String r515 = r206.getMd5();
    L304:
        r512 = new com.larus.kmp.voice_setting.platform.q0(r513, r514, r515, r180.getId(), r180.getName());
        goto L305
    L303:
        r515 = null;
        goto L304
    L299:
        r514 = null;
        goto L300
    L284:
        r178 = null;
        goto L286
    L288:
        r176 = null;
    L293:
        r180 = r109;
        goto L294
    L276:
        r320 = VoiceMixPlayVisualState.Idle;
    L273:
        r174 = r133;
    L267:
        r173 = false;
        goto L268
    L254:
        if (StringsKt.isBlank(r132) == true) goto L257;
        r171 = false;
    L260:
        r172 = false;
        goto L262
    L244:
        r169 = null;
    L248:
        r170 = false;
        goto L250
    L234:
        if (r162 == false) goto L236;
        r168 = VoiceEditMode.SINGLE;
        goto L233
    L236:
        if (r110 == false) goto L238;
        r168 = VoiceEditMode.MULTI;
        goto L233
    L238:
        r168 = VoiceEditMode.SINGLE;
    L230:
        r222 = false;
        goto L231
    L226:
        if (((Collection) r422).isEmpty() == true) goto L230;
    L222:
        r167 = r129.f354440e;
        goto L223
    L215:
        if (r129.f354440e == VoiceEditAreaLayoutMode.SELECTED_SINGLE) goto L217;
    L219:
        r165 = VoiceEditMode.NONE;
        goto L213
    L217:
        if (r129.f354442g == false) goto L219;
        r165 = VoiceEditMode.SINGLE;
        goto L213
    L209:
        if (r164 != 1) goto L211;
        r165 = VoiceEditMode.SINGLE;
    L205:
        r163 = r155.f509300e;
        goto L206
    L199:
        if (r422.size() != 1) goto L201;
        r162 = true;
        goto L202
    L180:
        r215 = r126;
        if (r109 != null) goto L183;
        r159 = CollectionsKt.emptyList();
        goto L196
    L183:
        String r225 = r109.getId();
        String r207 = r109.getName();
        if (r207 != null) goto L186;
        String r321 = "";
    L187:
        String r322 = r109.getStyleId();
        AudioPreview r208 = r109.getPreview();
        if (r208 == null) goto L190;
        String r323 = r208.getPreviewAudio();
    L191:
        AudioPreview r209 = r109.getPreview();
        if (r209 == null) goto L194;
        String r324 = r209.getMd5();
    L195:
        r159 = CollectionsKt.listOf(new com.larus.kmp.voice_setting.voice.component.d5(r225, r321, r322, 100, r323, r324));
        goto L196
    L194:
        r324 = null;
        goto L195
    L190:
        r323 = null;
        goto L191
    L186:
        r321 = r207;
    L145:
        r316 = null;
    L140:
        r315 = null;
        goto L141
    L135:
        r314 = null;
        goto L136
    L132:
        r214 = r156;
        goto L133
    L129:
        r156 = null;
        goto L130
    L126:
        r213 = null;
    L119:
        if (com.larus.kmp.voice_setting.voice.bridge.y.b() == false) goto L122;
        if (r150 == true) goto L121;
    L122:
        r151 = false;
        goto L123
    L111:
        if (Intrinsics.areEqual(r123, "zh") == true) goto L114;
        r150 = false;
    L84:
        com.larus.kmp.voice_setting.voice.component.v4 r226 = r124.f354367a;
        if (r226 == null) goto L87;
        r137 = r226.f352583d;
    L88:
        if (r137 != null) goto L90;
        r137 = "";
        goto L90
    L87:
        r137 = null;
    L74:
        com.larus.kmp.voice_setting.voice.component.v4 r227 = r100.f354334a.f354367a;
        if (r227 == null) goto L77;
        r123 = r227.f352583d;
    L78:
        if (r123 != null) goto L80;
        r123 = "";
        goto L80
    L77:
        r123 = null;
        goto L78
    L21:
        if ((!((Collection) r111).isEmpty()) == false) goto L26;
        MixVoice r228 = (MixVoice) CollectionsKt.firstOrNull(r111);
        if (r228 == null) goto L25;
        r109 = r228.getVoiceItem();
        goto L30
    L25:
        r109 = null;
        goto L30
    L17:
        r105 = CollectionsKt.emptyList();
        goto L18
    L5:
        r103 = null;
        goto L6
    }

    public static void c(String r100) {
        FlowRuntime.b().e().i("VoiceDoubleTabBridge", r100);
    }

    public final void g(m6 r100) {
        this.f354426d = r100;
        e5 r101 = this.f354427e;
        r101.f354273b = r100.k();
        i4 r102 = this.f354425c;
        r102.f354391y = r100.g();
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.v5] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.n5] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.u5] */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.o5] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.q5] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.g6] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.i6] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.j6] */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.f6] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.w5] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.d6] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.p5] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.b6] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.h6] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.t5] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.y5] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.e6] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.x5] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.z5] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.c6] */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.r5] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.a6] */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.s5] */
    public k6(com.larus.kmp.voice_setting.voice.component.o r310, com.larus.kmp.voice_setting.voice.component.s1 r311) {
        Intrinsics.checkNotNullParameter(r310, "repoPort");
        Intrinsics.checkNotNullParameter(r311, "lifecycleScope");
        this.f354423a = r311;
        StateFlowImpl r110 = kotlinx.coroutines.flow.j1.a(new com.larus.kmp.voice_setting.voice.bridge.o(null, null, null, null, 31));
        this.f354424b = r110;
        i4 r111 = new i4();
        this.f354425c = r111;
        this.f354426d = p4.f354567a;
        e5 r100 = new e5(new n5(this));
        r100.f354273b = 0;
        this.f354427e = r100;
        w6 r101 = new w6(r111, r310, new p5(this), r311, new VoiceDoubleTabPlatformController$previewController$2(this), new VoiceDoubleTabPlatformController$previewController$3(this), new t5(this), new u5(this), new VoiceDoubleTabPlatformController$previewController$6(this), new v5(this));
        this.f354428f = r101;
        m4 r112 = new m4(r111, new w5(this), r101, new VoiceDoubleTabPlatformController$mixController$2(this), new VoiceDoubleTabPlatformController$mixController$3(this), new VoiceDoubleTabPlatformController$mixController$4(this), new x5(this));
        this.f354429g = r112;
        VoiceDoubleTabPageController r113 = new VoiceDoubleTabPageController(r111, r100, r311, new VoiceDoubleTabPlatformController$pageController$1(r101), new VoiceDoubleTabPlatformController$pageController$2(this), new VoiceDoubleTabPlatformController$pageController$3(this), new z5(this), new a6());
        this.f354430h = r113;
        VoiceDoubleTabPitchRateController r114 = new VoiceDoubleTabPitchRateController(r111, r311, new b6(this), new VoiceDoubleTabPlatformController$pitchRateController$2(this), new y5(this), new VoiceDoubleTabPlatformController$pitchRateController$4(this), new c6(this));
        this.f354431i = r114;
        VoiceDoubleTabSelectionController r102 = new VoiceDoubleTabSelectionController(r111, new d6(this), r114, r101, r112, new VoiceDoubleTabPlatformController$selectionController$2(this), new VoiceDoubleTabPlatformController$selectionController$3(this), new e6(this));
        this.f354432j = r102;
        this.f354433k = new g7(r111, r110, new VoiceDoubleTabPlatformController$publisher$1(r102), new VoiceDoubleTabPlatformController$publisher$2(r114), new VoiceDoubleTabPlatformController$publisher$3(r114), new f6());
        this.f354434l = new VoiceDoubleTabSessionController(r111, r310, r100, r113, r114, r101, r102, r112, new j4(new g6(), new VoiceDoubleTabPlatformController$dialogController$2(this), new h6(this)), new i6(this), r311, new VoiceDoubleTabPlatformController$sessionController$2(this), new VoiceDoubleTabPlatformController$sessionController$3(this), new VoiceDoubleTabPlatformController$sessionController$4(this), new j6(this), new o5());
        this.f354435m = new VoiceDoubleTabSaveController(r111, new q5(this), r114, new VoiceDoubleTabPlatformController$saveController$2(r102), new VoiceDoubleTabPlatformController$saveController$3(r102), new VoiceDoubleTabPlatformController$saveController$4(this), new VoiceDoubleTabPlatformController$saveController$5(this), new VoiceDoubleTabPlatformController$saveController$6(this), new r5(this), new s5(this));
    }

    public static final void a(k6 r100, String r101) {
        i4 r102 = r100.f354425c;
        r102.f354389w = false;
        r102.f354390x++;
        r102.a();
        c("[editAreaExpand] reason=" + r101 + " token=" + r100.f354425c.f354390x + " collapsed=" + r100.f354425c.f354389w);
    }

    public final void e(boolean r100, String r101) {
        if (r100 == true) goto L4;
    L6:
        boolean r102 = false;
    L7:
        i4 r103 = this.f354425c;
        if (r103.f354389w != r102) goto L11;
        c("[editAreaCollapse:skip] reason=" + r101 + " collapsed=" + r102 + " collapseEnabled=" + this.f354425c.f354383q.f354442g + " mixCount=" + ((ArrayList) this.f354425c.f354382p).size() + " expandToken=" + this.f354425c.f354390x);
        return;
    L11:
        r103.f354389w = r102;
        r103.a();
        c("[editAreaCollapse] reason=" + r101 + " collapsed=" + this.f354425c.f354389w + " collapseEnabled=" + this.f354425c.f354383q.f354442g + " mixCount=" + ((ArrayList) this.f354425c.f354382p).size() + " expandToken=" + this.f354425c.f354390x);
        d();
        return;
    L4:
        if (this.f354425c.f354383q.f354442g == false) goto L6;
        r102 = true;
        goto L7
    }

    public final void b(com.larus.kmp.voice_setting.voice.component.v4 r110, m6 r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r111, "delegate");
        Intrinsics.checkNotNullParameter(r112, "caller");
        g(r111);
        this.f354434l.b(r110, null);
        w6 r113 = this.f354428f;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r112, "caller");
        Job r100 = r113.f354767j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        List<MixVoice> r101 = r113.d();
        if (com.larus.kmp.voice_setting.voice.bridge.v.e().f351914b == true) goto L9;
        r113.f354766i.invoke("[pitchRate:autoPlay] skip disabled caller=".concat(r112));
        return;
    L9:
        if (r101.size() == 1) goto L11;
        r113.f354766i.invoke("[pitchRate:autoPlay] skip voiceCount=" + r101.size() + " caller=" + r112);
        return;
    L11:
        r113.f354767j = BuildersKt.launch$default(r113.f354760c.invoke(), null, null, new VoiceDoubleTabPreviewController$autoPlayForPitchRateChange$1(r113, r110, r112, null), 3, null);
    }

    public final void f(com.larus.kmp.voice_setting.voice.component.v4 r110, m6 r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r210, "delegate");
        g(r210);
        this.f354434l.b(r110, null);
        w6 r100 = this.f354428f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "args");
        List<MixVoice> r101 = r100.d();
        if (r101.size() <= 1) goto L6;
        VoiceDoubleTabPreviewIndicatorScope r102 = VoiceDoubleTabPreviewIndicatorScope.MIXED_PREVIEW;
    L10:
        if (r101.size() <= 1) goto L13;
        VoiceDoubleTabPreviewSource r103 = VoiceDoubleTabPreviewSource.MIXED_PREVIEW;
    L16:
        String r111 = "";
        if ((!r101.isEmpty()) == false) goto L48;
        MixVoice r104 = (MixVoice) CollectionsKt.firstOrNull(r101);
        if (r104 == null) goto L21;
        SpeakerVoice r105 = r104.getVoiceItem();
    L22:
        int r112 = mh9.r.f514018a;
        if (r211 != null) goto L25;
        final String r113 = "";
    L27:
        if (StringsKt.isBlank(r113) == false) goto L29;
        r113 = "voiceEdit";
    L29:
        Intrinsics.checkNotNullParameter(r101, "voiceList");
        Intrinsics.checkNotNullParameter(r113, "caller");
        final MixVoice r114 = (MixVoice) CollectionsKt.firstOrNull(r101);
        if (r114 == null) goto L33;
        com.larus.kmp.voice_setting.voice.utils.k r115 = com.larus.kmp.voice_setting.voice.utils.m.f355113a.b("click play button");
        r115.b(new mh9.o(r114, r113));
        r115.f355107d = CollectionsKt.listOf("VoicePlay");
        com.larus.kmp.voice_setting.voice.utils.k.a(r115);
    L33:
        com.larus.kmp.voice_setting.voice.mix.a r116 = com.larus.kmp.voice_setting.voice.mix.a.f353751a;
        boolean r117 = r100.f354758a.f354389w;
        if (r105 == null) goto L36;
        String r118 = r105.getId();
    L37:
        if (r105 == null) goto L39;
        String r119 = r105.getStyleId();
    L40:
        if (r105 == null) goto L42;
        String r120 = r105.getName();
    L43:
        com.larus.kmp.voice_setting.voice.mix.a.f(r117, r118, "audition", r119, r120);
        if (r101.size() <= 1) goto L46;
        i4 r121 = r100.f354758a;
        w2a.f r106 = i7.a(r101, r121.f354373g, r121.f354385s, r110.f352585f, r121.f354386t);
    L47:
        com.larus.kmp.voice_setting.voice.mix.a.d(r106, "voice_mix_bar", r105, 8);
        goto L48
    L46:
        r106 = null;
        goto L47
    L42:
        r120 = null;
        goto L43
    L39:
        r119 = null;
        goto L40
    L36:
        r118 = null;
        goto L37
    L25:
        r113 = r211;
        goto L27
    L21:
        r105 = null;
    L48:
        i4 r107 = r100.f354758a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r107.f354377k = r102;
        i4 r108 = r100.f354758a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r108.f354378l = r103;
        e7 r122 = r100.f354768k;
        m6 r109 = r100.f354759b.invoke();
        CoroutineScope r123 = r100.f354760c.invoke();
        i4 r124 = r100.f354758a;
        String r125 = r124.f354375i;
        VoiceMixPlayVisualState r126 = r124.f354376j;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r109, "platform");
        Intrinsics.checkNotNullParameter(r123, "scope");
        Intrinsics.checkNotNullParameter(r126, "previewPlayState");
        List<MixVoice> r127 = r122.f354282e.invoke();
        if (r127.size() <= 1) goto L51;
        String r128 = "__mix_preview__";
    L56:
        String r129 = r128;
    L58:
        com.larus.kmp.voice_setting.voice.editvoice.f r130 = r122.f354281d.invoke();
        Function1<String, Unit> r131 = r122.f354287j;
        StringBuilder r132 = new StringBuilder("[previewToggle] request target=");
        if (r129 != null) goto L61;
        String r133 = "";
    L62:
        r132.append(r133);
        r132.append(" size=");
        r132.append(r127.size());
        r132.append(" voices=");
        r132.append(o4.b(r127));
        r132.append(" currentActive=");
        if (r125 != null) goto L65;
        String r134 = "";
    L66:
        r132.append(r134);
        r132.append(" playState=");
        r132.append(r126);
        r132.append(" pitch=");
        r132.append(r130.f353255a);
        r132.append(" rate=");
        r132.append(r130.f353256b);
        r131.invoke(r132.toString());
        if (r126 == VoiceMixPlayVisualState.Idle) goto L81;
        r122.b();
        r109.stopAudio();
        r122.f354285h.invoke(r125, null);
        if (Intrinsics.areEqual(r125, r129) == false) goto L71;
    L72:
        Function1<String, Unit> r135 = r122.f354287j;
        StringBuilder r136 = new StringBuilder("[previewToggle] stop current target=");
        if (r125 != null) goto L75;
        r125 = "";
    L75:
        r136.append(r125);
        r136.append(" next=");
        if (r129 == null) goto L79;
        r111 = r129;
    L79:
        r136.append(r111);
        r136.append(" empty=");
        r136.append(r127.isEmpty());
        r135.invoke(r136.toString());
        return;
    L71:
        if (r127.isEmpty() == true) goto L72;
    L81:
        if (r127.isEmpty() == false) goto L83;
        r122.f354287j.invoke("[previewToggle] skip empty voice list");
        return;
    L83:
        r122.f354284g.invoke(r129, VoiceMixPlayVisualState.Loading, null);
        VoiceDoubleTabPreviewPlaybackCoordinator$togglePreview$1 r137 = new VoiceDoubleTabPreviewPlaybackCoordinator$togglePreview$1(r122, r127, r130, r110, r129, r122.f354283f.invoke().longValue(), r109, null);
        Intrinsics.checkNotNullParameter(r123, "scope");
        Intrinsics.checkNotNullParameter(r137, "block");
        r122.b();
        r122.f354288k = BuildersKt.launch$default(r123, null, null, r137, 3, null);
        return;
    L65:
        r134 = r125;
        goto L66
    L61:
        r133 = r129;
        goto L62
    L51:
        MixVoice r138 = (MixVoice) CollectionsKt.firstOrNull(r127);
        if (r138 == null) goto L57;
        SpeakerVoice r139 = r138.getVoiceItem();
        if (r139 == null) goto L57;
        r128 = r139.getId();
    L57:
        r129 = null;
        goto L58
    L13:
        if (r100.f354761d.invoke().booleanValue() == false) goto L15;
        r103 = VoiceDoubleTabPreviewSource.MIX_LIST_ITEM;
        goto L16
    L15:
        r103 = VoiceDoubleTabPreviewSource.TOP_SINGLE;
        goto L16
    L6:
        if (r100.f354761d.invoke().booleanValue() == false) goto L8;
        r102 = VoiceDoubleTabPreviewIndicatorScope.LIST_AND_MIX_ITEM;
        goto L10
    L8:
        r102 = VoiceDoubleTabPreviewIndicatorScope.TOP_SINGLE;
        goto L10
    }
}
