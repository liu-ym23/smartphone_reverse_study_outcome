package com.larus.office.base.share;

import android.content.Context;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.home.impl.sdk.SdkSlidesServiceImpl;
import com.larus.home.impl.sdk.n1;
import com.larus.home.impl.sdk.x1;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowOfficeThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeSdkSharePanelProvider implements com.bytedance.ee.bear.share.export.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashSet<String> f361122c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.share.export.o f361123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f361124b;

    public static final class a {
    }

    public interface b extends ShareItemModel.a {
    }

    static {
        f361122c = SetsKt.linkedSetOf(new String[]{ShareChannel.DOUYIN, "wechat", ShareChannel.WX_MOMENTS, "qq"});
    }

    public static boolean g() {
        IFlowOfficeThemeConfigProvider r100 = (IFlowOfficeThemeConfigProvider) ServiceManager.get().getService(IFlowOfficeThemeConfigProvider.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a(new d(), AdaptThemeFeatureKey.OFFICE_COPY_LINK_DIRECTLY) != true) goto L7;
        return true;
    }

    public OfficeSdkSharePanelProvider(com.bytedance.ee.bear.share.export.o r100) {
        this.f361123a = r100;
        this.f361124b = new k(new OfficeSdkSharePanelProvider$sharePanelTracker$1(this), new OfficeSdkSharePanelProvider$sharePanelTracker$2(this), new OfficeSdkSharePanelProvider$sharePanelTracker$3(this));
    }

    public static com.larus.bmhome.share.panel.h e(km5.a r105) {
        String r100 = r105.f504067c;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L11;
        r101.N();
        n1 r102 = n1.f346205a;
    L12:
        if (r101 == null) goto L14;
        r101.E0();
        SdkSlidesServiceImpl r103 = SdkSlidesServiceImpl.f346131a;
    L15:
        if (r101 == null) goto L17;
        r101.h();
        SdkSheetsServiceImpl r104 = SdkSheetsServiceImpl.f346130a;
    L18:
        int r106 = r105.f504066b;
        if (r106 == 3) goto L27;
        if (r106 == 8) goto L25;
        if (r106 != 30) goto L29;
        if (r103 == null) goto L29;
        JSONObject r107 = r103.i();
    L30:
        if (r107 != null) goto L32;
    L37:
        r107 = null;
    L38:
        int r108 = r105.f504066b;
        if (r108 != 3) goto L41;
        String r110 = r100;
        if (r107 == null) goto L477;
        String r109 = r107.optString("previous_page");
    L478:
        String r310 = p(r109);
        if (r107 == null) goto L481;
        String r111 = r107.optString("current_page");
    L482:
        String r112 = p(r111);
        if (r112 != null) goto L485;
        r112 = "aisheet_detail";
    L485:
        String r311 = r112;
        if (r107 == null) goto L488;
        String r113 = r107.optString(MusicAppletPage.KEY_MESSAGE_ID);
    L489:
        String r312 = p(r113);
        if (r107 == null) goto L492;
        String r114 = r107.optString("conversation_id");
    L493:
        String r510 = p(r114);
        if (r107 == null) goto L496;
        String r115 = r107.optString("resource_id");
    L497:
        String r116 = p(r115);
        if (r116 != null) goto L500;
        String r610 = r110;
    L501:
        if (r107 == null) goto L503;
        String r117 = r107.optString("artifact_meta_id");
    L504:
        String r611 = p(r117);
        if (r107 == null) goto L507;
        Integer r118 = Integer.valueOf(r107.optInt("artifact_type"));
    L508:
        Integer r119 = q(r118);
        if (r119 == null) goto L511;
        int r120 = r119.intValue();
    L512:
        if (r107 == null) goto L514;
        String r121 = r107.optString("enter_method");
    L515:
        String r710 = p(r121);
        if (r107 == null) goto L518;
        String r122 = r107.optString("aippt_task_id");
    L519:
        String r711 = p(r122);
        if (r107 == null) goto L522;
        String r123 = r107.optString("spreadsheet_id");
    L523:
        String r124 = p(r123);
        if (r124 != null) goto L533;
        if (r107 == null) goto L527;
        String r125 = r107.optString("resource_id");
    L528:
        r124 = p(r125);
        if (r124 != null) goto L533;
        if (r110 != null) goto L532;
        String r712 = "";
    L534:
        if (r107 == null) goto L536;
        String r126 = r107.optString("resource_id");
    L537:
        String r127 = p(r126);
        if (r127 != null) goto L542;
        if (r110 != null) goto L541;
        String r713 = "";
    L543:
        if (r107 == null) goto L545;
        Integer r128 = Integer.valueOf(r107.optInt("resource_type"));
    L546:
        Integer r129 = q(r128);
        if (r129 == null) goto L549;
        int r130 = r129.intValue();
    L550:
        if (r107 == null) goto L552;
        String r131 = r107.optString("canvas_type");
    L553:
        String r132 = p(r131);
        if (r132 != null) goto L556;
        r132 = "aisheet";
    L556:
        String r810 = r132;
        if (r107 == null) goto L559;
        String r133 = r107.optString("artifact_create_method");
    L560:
        String r811 = p(r133);
        if (r107 == null) goto L563;
        String r134 = r107.optString("bot_id");
    L564:
        String r313 = p(r134);
        if (r107 == null) goto L567;
        String r135 = r107.optString("feishu_record_id");
    L568:
        String r812 = p(r135);
        if (r107 == null) goto L571;
        String r136 = r107.optString("feishu_record_generated_type");
    L572:
        String r813 = p(r136);
        if (r107 == null) goto L575;
        String r137 = r107.optString("record_scene");
    L576:
        String r910 = p(r137);
        if (r107 == null) goto L579;
        String r138 = r107.optString("is_general_agent");
    L580:
        String r139 = p(r138);
        if (r139 != null) goto L583;
        String r911 = "0";
    L584:
        if (r107 == null) goto L586;
        String r140 = r107.optString("chat_id");
    L587:
        String r141 = p(r140);
        if (r141 != null) goto L590;
        String r912 = "";
    L591:
        com.larus.bmhome.share.panel.h r142 = new com.larus.bmhome.share.panel.h(null, null, r310, r311, null, r313, r312, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r510, null, null, null, null, null, null, null, null, r610, r611, Integer.valueOf(r120), null, null, null, null, null, null, null, r710, null, null, null, r711, null, r712, r713, Integer.valueOf(r130), r810, null, null, null, null, r811, null, r812, r813, r911, r912, null, null, false, null, r910, null, null, -134217945, 1578598287, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION);
    L595:
        return r142;
    L590:
        r912 = r141;
        goto L591
    L586:
        r140 = null;
        goto L587
    L583:
        r911 = r139;
        goto L584
    L579:
        r138 = null;
        goto L580
    L575:
        r137 = null;
        goto L576
    L571:
        r136 = null;
        goto L572
    L567:
        r135 = null;
        goto L568
    L563:
        r134 = null;
        goto L564
    L559:
        r133 = null;
        goto L560
    L552:
        r131 = null;
        goto L553
    L549:
        r130 = r105.f504066b;
        goto L550
    L545:
        r128 = null;
        goto L546
    L541:
        r713 = r110;
        goto L543
    L542:
        r713 = r127;
        goto L543
    L536:
        r126 = null;
        goto L537
    L532:
        r712 = r110;
        goto L534
    L527:
        r125 = null;
    L533:
        r712 = r124;
        goto L534
    L522:
        r123 = null;
        goto L523
    L518:
        r122 = null;
        goto L519
    L514:
        r121 = null;
        goto L515
    L511:
        r120 = r105.f504066b;
        goto L512
    L507:
        r118 = null;
        goto L508
    L503:
        r117 = null;
        goto L504
    L500:
        r610 = r116;
        goto L501
    L496:
        r115 = null;
        goto L497
    L492:
        r114 = null;
        goto L493
    L488:
        r113 = null;
        goto L489
    L481:
        r111 = null;
        goto L482
    L477:
        r109 = null;
        goto L478
    L41:
        if (r108 != 8) goto L43;
        String r143 = r100;
        if (r107 == null) goto L371;
        String r144 = r107.optString("previous_page");
    L372:
        String r314 = p(r144);
        if (r107 == null) goto L375;
        String r145 = r107.optString("current_page");
    L376:
        String r146 = p(r145);
        if (r146 != null) goto L379;
        r146 = "aibase_detail";
    L379:
        String r315 = r146;
        if (r107 == null) goto L382;
        String r147 = r107.optString(MusicAppletPage.KEY_MESSAGE_ID);
    L383:
        String r316 = p(r147);
        if (r107 == null) goto L386;
        String r148 = r107.optString("conversation_id");
    L387:
        String r511 = p(r148);
        if (r107 == null) goto L390;
        String r149 = r107.optString("resource_id");
    L391:
        String r150 = p(r149);
        if (r150 != null) goto L394;
        String r612 = r143;
    L395:
        if (r107 == null) goto L397;
        String r151 = r107.optString("artifact_meta_id");
    L398:
        String r613 = p(r151);
        if (r107 == null) goto L401;
        Integer r152 = Integer.valueOf(r107.optInt("artifact_type"));
    L402:
        Integer r153 = q(r152);
        int r154 = 15;
        if (r153 == null) goto L405;
        int r155 = r153.intValue();
    L406:
        if (r107 == null) goto L408;
        String r156 = r107.optString("enter_method");
    L409:
        String r714 = p(r156);
        if (r107 == null) goto L412;
        String r157 = r107.optString("base_id");
    L413:
        String r158 = p(r157);
        if (r158 != null) goto L421;
        if (r107 == null) goto L417;
        String r159 = r107.optString("resource_id");
    L418:
        r158 = p(r159);
        if (r158 != null) goto L421;
        String r913 = r143;
    L422:
        if (r107 == null) goto L424;
        String r160 = r107.optString("resource_id");
    L425:
        String r161 = p(r160);
        if (r161 != null) goto L428;
        String r715 = r143;
    L429:
        if (r107 == null) goto L431;
        Integer r162 = Integer.valueOf(r107.optInt("resource_type"));
    L432:
        Integer r163 = q(r162);
        if (r163 == null) goto L435;
        r154 = r163.intValue();
    L435:
        if (r107 == null) goto L437;
        String r164 = r107.optString("canvas_type");
    L438:
        String r165 = p(r164);
        if (r165 != null) goto L441;
        r165 = "aibase";
    L441:
        String r814 = r165;
        if (r107 == null) goto L444;
        String r166 = r107.optString("artifact_create_method");
    L445:
        String r815 = p(r166);
        if (r107 == null) goto L448;
        String r167 = r107.optString("bot_id");
    L449:
        String r317 = p(r167);
        if (r107 == null) goto L452;
        String r168 = r107.optString("feishu_record_id");
    L453:
        String r816 = p(r168);
        if (r107 == null) goto L456;
        String r169 = r107.optString("feishu_record_generated_type");
    L457:
        String r817 = p(r169);
        if (r107 == null) goto L460;
        String r170 = r107.optString("is_general_agent");
    L461:
        String r171 = p(r170);
        if (r171 != null) goto L464;
        String r914 = "0";
    L465:
        if (r107 == null) goto L467;
        String r172 = r107.optString("chat_id");
    L468:
        String r173 = p(r172);
        if (r173 != null) goto L471;
        String r915 = "";
    L472:
        r142 = new com.larus.bmhome.share.panel.h(null, null, r314, r315, null, r317, r316, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r511, null, null, null, null, null, null, null, null, r612, r613, Integer.valueOf(r155), ShareScene.BITABLE.getScene(), null, null, null, null, null, null, r714, null, null, null, null, null, null, r715, Integer.valueOf(r154), r814, null, null, null, null, r815, null, r816, r817, r914, r915, null, null, false, r913, null, null, null, -134217945, 1580171023, 952);
        goto L595
    L471:
        r915 = r173;
        goto L472
    L467:
        r172 = null;
        goto L468
    L464:
        r914 = r171;
        goto L465
    L460:
        r170 = null;
        goto L461
    L456:
        r169 = null;
        goto L457
    L452:
        r168 = null;
        goto L453
    L448:
        r167 = null;
        goto L449
    L444:
        r166 = null;
        goto L445
    L437:
        r164 = null;
        goto L438
    L431:
        r162 = null;
        goto L432
    L428:
        r715 = r161;
        goto L429
    L424:
        r160 = null;
        goto L425
    L417:
        r159 = null;
    L421:
        r913 = r158;
        goto L422
    L412:
        r157 = null;
        goto L413
    L408:
        r156 = null;
        goto L409
    L405:
        r155 = 15;
        goto L406
    L401:
        r152 = null;
        goto L402
    L397:
        r151 = null;
        goto L398
    L394:
        r612 = r150;
        goto L395
    L390:
        r149 = null;
        goto L391
    L386:
        r148 = null;
        goto L387
    L382:
        r147 = null;
        goto L383
    L375:
        r145 = null;
        goto L376
    L371:
        r144 = null;
        goto L372
    L43:
        if (r108 == 30) goto L251;
        if (r108 == 125) goto L242;
        if (r100 != null) goto L54;
        if (r102 == null) goto L53;
        String r174 = r102.c(null);
        if (r174 == null) goto L53;
        if ((!StringsKt.isBlank(r174)) == false) goto L53;
        String r614 = r174;
    L55:
        if (r102 == null) goto L57;
        wc9.e r210 = r102.l();
    L58:
        if (r102 == null) goto L60;
        BotModel r318 = r102.k();
    L61:
        if (r107 == null) goto L63;
        String r175 = r107.optString("previous_page");
    L64:
        String r176 = p(r175);
        if (r176 != null) goto L81;
        if (r102 == null) goto L72;
        r176 = r102.m();
        if (r176 == null) goto L72;
        if ((!StringsKt.isBlank(r176)) == false) goto L72;
    L73:
        if (r176 != null) goto L81;
        if (r102 == null) goto L80;
        r176 = r102.i();
        if (r176 == null) goto L80;
        if ((!StringsKt.isBlank(r176)) == true) goto L81;
    L80:
        String r319 = null;
    L82:
        if (r107 == null) goto L84;
        String r177 = r107.optString("current_page");
    L85:
        String r178 = p(r177);
        if (r178 != null) goto L88;
        r178 = "doc_detail";
    L88:
        String r320 = r178;
        if (r107 == null) goto L91;
        String r179 = r107.optString("artifact_meta_id");
    L92:
        String r180 = p(r179);
        if (r180 != null) goto L101;
        if (r102 == null) goto L100;
        String r181 = r102.d(null);
        if (r181 == null) goto L100;
        if ((!StringsKt.isBlank(r181)) == false) goto L100;
        String r615 = r181;
    L102:
        if (r107 == null) goto L104;
        Integer r182 = Integer.valueOf(r107.optInt("artifact_type"));
    L105:
        Integer r183 = q(r182);
        if (r183 == null) goto L108;
        int r184 = r183.intValue();
    L114:
        if (r107 == null) goto L116;
        String r185 = r107.optString("enter_method");
    L117:
        String r716 = p(r185);
        if (r107 == null) goto L120;
        String r186 = r107.optString("aippt_task_id");
    L121:
        String r187 = p(r186);
        if (r187 != null) goto L130;
        if (r102 == null) goto L129;
        String r188 = r102.a(null);
        if (r188 == null) goto L129;
        if ((!StringsKt.isBlank(r188)) == false) goto L129;
        String r717 = r188;
    L131:
        if (r107 == null) goto L133;
        String r189 = r107.optString("resource_id");
    L134:
        String r190 = p(r189);
        if (r190 != null) goto L148;
        if (r102 == null) goto L142;
        String r191 = r102.b(null);
        if (r191 == null) goto L142;
        if ((!StringsKt.isBlank(r191)) == false) goto L142;
    L143:
        if (r191 != null) goto L147;
        if (r614 != null) goto L146;
        String r818 = "";
    L149:
        if (r107 == null) goto L151;
        Integer r192 = Integer.valueOf(r107.optInt("resource_type"));
    L152:
        Integer r193 = q(r192);
        if (r193 == null) goto L155;
        int r194 = r193.intValue();
        String r195 = null;
    L161:
        if (r107 == null) goto L163;
        String r196 = r107.optString("canvas_type");
    L164:
        String r197 = p(r196);
        if (r197 != null) goto L167;
        r197 = "ai_doc";
    L167:
        String r819 = r197;
        if (r107 == null) goto L170;
        String r198 = r107.optString("artifact_create_method");
    L171:
        String r820 = p(r198);
        if (r107 == null) goto L174;
        String r199 = r107.optString("conversation_id");
    L175:
        String r512 = p(r199);
        if (r107 == null) goto L178;
        String r200 = r107.optString(MusicAppletPage.KEY_MESSAGE_ID);
    L179:
        String r321 = p(r200);
        if (r107 == null) goto L182;
        String r201 = r107.optString("bot_id");
    L183:
        String r322 = p(r201);
        if (r107 == null) goto L186;
        String r202 = r107.optString("feishu_record_id");
    L187:
        String r203 = p(r202);
        if (r203 != null) goto L192;
        if (r102 == null) goto L191;
        r203 = r102.o();
        goto L192
    L191:
        String r821 = r195;
    L193:
        if (r107 == null) goto L195;
        String r204 = r107.optString("feishu_record_generated_type");
    L196:
        String r205 = p(r204);
        if (r205 != null) goto L201;
        if (r102 == null) goto L200;
        r205 = r102.r();
        goto L201
    L200:
        String r916 = r195;
    L202:
        if (r107 == null) goto L204;
        String r206 = r107.optString("record_scene");
    L205:
        String r207 = p(r206);
        if (r207 != null) goto L210;
        if (r102 == null) goto L209;
        r207 = r102.s();
        goto L210
    L209:
        String r917 = r195;
    L211:
        if (r107 == null) goto L213;
        String r208 = r107.optString("is_general_agent");
    L214:
        String r209 = p(r208);
        if (r209 != null) goto L225;
        if (r102 == null) goto L222;
        r209 = r102.q();
        if (r209 == null) goto L222;
        if ((!StringsKt.isBlank(r209)) == false) goto L222;
    L223:
        if (r209 != null) goto L225;
        String r918 = "0";
    L226:
        if (r107 == null) goto L228;
        String r211 = r107.optString("chat_id");
    L229:
        String r212 = p(r211);
        if (r212 != null) goto L240;
        if (r102 == null) goto L237;
        r212 = r102.j();
        if (r212 == null) goto L237;
        if ((!StringsKt.isBlank(r212)) == false) goto L237;
    L238:
        if (r212 != null) goto L240;
        String r919 = "";
    L592:
        return new com.larus.bmhome.share.panel.h(r210, r318, r319, r320, null, r322, r321, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r512, null, null, null, null, null, null, null, null, r614, r615, Integer.valueOf(r184), null, null, null, null, null, null, null, r716, null, null, null, r717, null, null, r818, Integer.valueOf(r194), r819, null, null, null, null, r820, null, r821, r916, r918, r919, null, null, false, null, r917, null, null, -134217948, 1580695439, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION);
    L237:
        r212 = r195;
    L240:
        r919 = r212;
        goto L592
    L228:
        r211 = r195;
    L222:
        r209 = r195;
    L225:
        r918 = r209;
        goto L226
    L213:
        r208 = r195;
    L210:
        r917 = r207;
        goto L211
    L204:
        r206 = r195;
    L201:
        r916 = r205;
        goto L202
    L195:
        r204 = r195;
    L192:
        r821 = r203;
        goto L193
    L186:
        r202 = r195;
        goto L187
    L182:
        r201 = r195;
        goto L183
    L178:
        r200 = r195;
        goto L179
    L174:
        r199 = r195;
        goto L175
    L170:
        r198 = r195;
        goto L171
    L163:
        r196 = r195;
        goto L164
    L155:
        if (r102 == null) goto L157;
        r195 = null;
        Integer r213 = r102.e(null);
    L158:
        if (r213 == null) goto L160;
        r194 = r213.intValue();
        goto L161
    L160:
        r194 = r105.f504066b;
        goto L161
    L157:
        r195 = null;
        r213 = null;
        goto L158
    L151:
        r192 = null;
        goto L152
    L146:
        r818 = r614;
        goto L149
    L147:
        r818 = r191;
    L142:
        r191 = null;
        goto L143
    L148:
        r818 = r190;
        goto L149
    L133:
        r189 = null;
    L129:
        r717 = null;
        goto L131
    L130:
        r717 = r187;
        goto L131
    L120:
        r186 = null;
        goto L121
    L116:
        r185 = null;
        goto L117
    L108:
        if (r102 == null) goto L110;
        Integer r214 = r102.e(null);
    L111:
        if (r214 == null) goto L113;
        r184 = r214.intValue();
        goto L114
    L113:
        r184 = r105.f504066b;
        goto L114
    L110:
        r214 = null;
        goto L111
    L104:
        r182 = null;
    L100:
        r615 = null;
        goto L102
    L101:
        r615 = r180;
        goto L102
    L91:
        r179 = null;
        goto L92
    L84:
        r177 = null;
    L72:
        r176 = null;
    L81:
        r319 = r176;
        goto L82
    L63:
        r175 = null;
        goto L64
    L60:
        r318 = null;
        goto L61
    L57:
        r210 = null;
    L53:
        r614 = null;
        goto L55
    L54:
        r614 = r100;
        goto L55
    L242:
        com.larus.office.base.share.a r215 = com.larus.office.base.share.a.f361125a;
        com.larus.bmhome.share.panel.h r216 = com.larus.office.base.share.a.f361126b;
        if (r216 != null) goto L245;
        r216 = new com.larus.bmhome.share.panel.h(null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -1, -1, 1023);
    L245:
        com.larus.bmhome.share.panel.h r217 = r216;
        if (r100 != null) goto L248;
        String r1100 = "";
    L593:
        return com.larus.bmhome.share.panel.h.a(r217, null, null, null, ShareScene.CONVERSATION_CCM.getScene(), null, r1100, 125, -1, -12583041);
    L248:
        r1100 = r100;
        goto L593
    L251:
        if (r107 == null) goto L253;
        String r218 = r107.optString("previous_page");
    L254:
        String r323 = p(r218);
        if (r107 == null) goto L257;
        String r219 = r107.optString("current_page");
    L258:
        String r220 = p(r219);
        if (r220 != null) goto L261;
        r220 = "aippt_new_detail";
    L261:
        String r324 = r220;
        if (r107 == null) goto L264;
        String r221 = r107.optString(MusicAppletPage.KEY_MESSAGE_ID);
    L265:
        String r325 = p(r221);
        if (r107 == null) goto L268;
        String r222 = r107.optString("conversation_id");
    L269:
        String r513 = p(r222);
        if (r107 == null) goto L272;
        String r223 = r107.optString("resource_id");
    L273:
        String r224 = p(r223);
        if (r224 != null) goto L276;
        String r616 = r100;
    L277:
        if (r107 == null) goto L279;
        String r225 = r107.optString("artifact_meta_id");
    L280:
        String r617 = p(r225);
        if (r107 == null) goto L283;
        Integer r226 = Integer.valueOf(r107.optInt("artifact_type"));
    L284:
        Integer r227 = q(r226);
        if (r227 == null) goto L287;
        int r228 = r227.intValue();
    L288:
        if (r107 == null) goto L290;
        String r229 = r107.optString("enter_method");
    L291:
        String r718 = p(r229);
        if (r107 == null) goto L294;
        String r230 = r107.optString("aippt_task_id");
    L295:
        String r719 = p(r230);
        if (r107 == null) goto L298;
        String r231 = r107.optString("presentation_id");
    L299:
        String r232 = p(r231);
        if (r232 != null) goto L309;
        if (r107 == null) goto L303;
        String r233 = r107.optString("resource_id");
    L304:
        r232 = p(r233);
        if (r232 != null) goto L309;
        if (r100 != null) goto L308;
        String r720 = "";
    L310:
        if (r107 == null) goto L312;
        String r234 = r107.optString("resource_id");
    L313:
        String r235 = p(r234);
        if (r235 != null) goto L318;
        if (r100 != null) goto L317;
        String r721 = "";
    L319:
        if (r107 == null) goto L321;
        Integer r236 = Integer.valueOf(r107.optInt("resource_type"));
    L322:
        Integer r237 = q(r236);
        if (r237 == null) goto L325;
        int r238 = r237.intValue();
    L326:
        if (r107 == null) goto L328;
        String r239 = r107.optString("canvas_type");
    L329:
        String r240 = p(r239);
        if (r240 != null) goto L332;
        r240 = "aippt_new";
    L332:
        String r822 = r240;
        if (r107 == null) goto L335;
        String r241 = r107.optString("artifact_create_method");
    L336:
        String r823 = p(r241);
        if (r107 == null) goto L339;
        String r242 = r107.optString("bot_id");
    L340:
        String r326 = p(r242);
        if (r107 == null) goto L343;
        String r243 = r107.optString("feishu_record_id");
    L344:
        String r824 = p(r243);
        if (r107 == null) goto L347;
        String r244 = r107.optString("feishu_record_generated_type");
    L348:
        String r825 = p(r244);
        if (r107 == null) goto L351;
        String r245 = r107.optString("record_scene");
    L352:
        String r920 = p(r245);
        if (r107 == null) goto L355;
        String r246 = r107.optString("is_general_agent");
    L356:
        String r247 = p(r246);
        if (r247 != null) goto L359;
        String r921 = "0";
    L360:
        if (r107 == null) goto L362;
        String r1101 = r107.optString("chat_id");
    L363:
        String r248 = p(r1101);
        if (r248 != null) goto L366;
        String r922 = "";
    L594:
        return new com.larus.bmhome.share.panel.h(null, null, r323, r324, null, r326, r325, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r513, null, null, null, null, null, null, null, null, r616, r617, Integer.valueOf(r228), null, null, null, null, null, null, null, r718, null, null, null, r719, r720, null, r721, Integer.valueOf(r238), r822, null, null, null, null, r823, null, r824, r825, r921, r922, null, null, false, null, r920, null, null, -134217945, 1579646863, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION);
    L366:
        r922 = r248;
        goto L594
    L362:
        r1101 = null;
        goto L363
    L359:
        r921 = r247;
        goto L360
    L355:
        r246 = null;
        goto L356
    L351:
        r245 = null;
        goto L352
    L347:
        r244 = null;
        goto L348
    L343:
        r243 = null;
        goto L344
    L339:
        r242 = null;
        goto L340
    L335:
        r241 = null;
        goto L336
    L328:
        r239 = null;
        goto L329
    L325:
        r238 = r105.f504066b;
        goto L326
    L321:
        r236 = null;
        goto L322
    L317:
        r721 = r100;
        goto L319
    L318:
        r721 = r235;
        goto L319
    L312:
        r234 = null;
        goto L313
    L308:
        r720 = r100;
        goto L310
    L303:
        r233 = null;
    L309:
        r720 = r232;
        goto L310
    L298:
        r231 = null;
        goto L299
    L294:
        r230 = null;
        goto L295
    L290:
        r229 = null;
        goto L291
    L287:
        r228 = r105.f504066b;
        goto L288
    L283:
        r226 = null;
        goto L284
    L279:
        r225 = null;
        goto L280
    L276:
        r616 = r224;
        goto L277
    L272:
        r223 = null;
        goto L273
    L268:
        r222 = null;
        goto L269
    L264:
        r221 = null;
        goto L265
    L257:
        r219 = null;
        goto L258
    L253:
        r218 = null;
        goto L254
    L32:
        if (r107.length() <= 0) goto L34;
        boolean r249 = true;
    L35:
        if (r249 == false) goto L37;
    L34:
        r249 = false;
    L29:
        r107 = null;
        goto L30
    L25:
        if (r101 == null) goto L29;
        r101.D();
        r107 = x1.f346268a.g();
        goto L30
    L27:
        if (r104 == null) goto L29;
        r107 = r104.g();
        goto L30
    L17:
        r104 = null;
        goto L18
    L14:
        r103 = null;
        goto L15
    L11:
        r102 = null;
        goto L12
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    public static String i(ShareItemModel r100) {
        ShareType r101 = r100.getType();
        ShareType r102 = ShareType.Wechat;
        if (r101 != r102) goto L5;
    L20:
        return "wechat";
    L5:
        if (Intrinsics.areEqual(r100.getItemId(), r102.getItemId()) == true) goto L20;
        ShareType r103 = r100.getType();
        ShareType r104 = ShareType.WechatMoments;
        if (r103 != r104) goto L10;
    L19:
        return ShareChannel.WX_MOMENTS;
    L10:
        if (Intrinsics.areEqual(r100.getItemId(), r104.getItemId()) == true) goto L19;
        ShareType r105 = r100.getType();
        ShareType r106 = ShareType.QQ;
        if (r105 != r106) goto L15;
    L18:
        return "qq";
    L15:
        if (Intrinsics.areEqual(r100.getItemId(), r106.getItemId()) == true) goto L18;
        return null;
    }

    public static ShareScene m(km5.a r100) {
        if (r100.f504081q == com.bytedance.ee.bear.share.externalshare.ShareScene.EXPORT_IMAGE) goto L5;
        int r101 = r100.f504066b;
        if (r101 == 3) goto L19;
        if (r101 == 8) goto L23;
        if (r101 == 30) goto L22;
        if (r101 == 125) goto L21;
        return ShareScene.DOCUMENT;
    L21:
        return ShareScene.CONVERSATION_CCM;
    L22:
        return ShareScene.SLIDES;
    L23:
        return ShareScene.BITABLE;
    L19:
        return ShareScene.SHEET;
    L5:
        return ShareScene.IMAGE_VIEWER;
    }

    public static boolean o(ShareItemModel r100) {
        if (h(r100, ShareType.Wechat) == false) goto L5;
    L12:
        return true;
    L5:
        if (h(r100, ShareType.WechatMoments) == true) goto L12;
        if (h(r100, ShareType.QQ) == true) goto L12;
        if (h(r100, ShareType.Weibo) == true) goto L12;
        return false;
    }

    public static String p(String r100) {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        return r100;
    }

    public static Integer q(Integer r100) {
        if (r100 != null) goto L4;
    L9:
        return null;
    L4:
        if (r100.intValue() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return r100;
    L6:
        r101 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.export.o
    public final List<ShareItemModel> a(final km5.a r210) {
        String r100 = "params";
        Intrinsics.checkNotNullParameter(r210, "params");
        boolean r101 = g();
        ShareScene r110 = m(r210);
        jr9.c r102 = ShareServiceDelegate.f313831b.t(r110);
        List r103 = CollectionsKt.createListBuilder();
        if (r102 == null) goto L10;
        List<jr9.a> r104 = r102.a();
        if (r104 == null) goto L10;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r103.add((jr9.a) r105.next());
    L10:
        if (r102 == null) goto L17;
        List<jr9.a> r106 = r102.c();
        if (r106 == null) goto L17;
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        r103.add((jr9.a) r107.next());
    L17:
        List r108 = CollectionsKt.build(r103);
        ArrayList r109 = new ArrayList();
        Iterator r111 = r108.iterator();
    L19:
        if (r111.hasNext() == false) goto L26;
        jr9.a r112 = (jr9.a) r111.next();
        if (r112 == null) goto L23;
        String r113 = r112.b();
    L24:
        if (r113 == null) goto L19;
        r109.add(r113);
        goto L19
    L23:
        r113 = null;
        goto L24
    L26:
        List r114 = CollectionsKt.distinct(r109);
        com.bytedance.ee.bear.share.export.o r115 = this.f361123a;
        if (r115 == null) goto L29;
        List<ShareItemModel> r116 = r115.a(r210);
    L30:
        if (r116 != null) goto L32;
        r116 = CollectionsKt.emptyList();
    L32:
        String r117 = ", type=";
        if (r116.isEmpty() == false) goto L36;
        List r118 = CollectionsKt.emptyList();
    L69:
        String r119 = "params";
    L93:
        if (r118.isEmpty() == false) goto L95;
        List<ShareItemModel> r120 = CollectionsKt.emptyList();
    L132:
        if (r101 == true) goto L199;
        ArrayList r121 = new ArrayList();
        Iterator r122 = r114.iterator();
    L136:
        if (r122.hasNext() == false) goto L141;
        Object r123 = r122.next();
        if (f361122c.contains((String) r123) == false) goto L136;
        r121.add(r123);
        goto L136
    L141:
        if (r121.isEmpty() == false) goto L143;
        FLogger.f375446a.i("OfficeSdkSharePanelProvider", "buildCustomItems: no host channels found, type=" + r210.f504066b + ", hostShareScene=" + r110);
        List<ShareItemModel> r124 = CollectionsKt.emptyList();
    L167:
        ArrayList r125 = new ArrayList();
        Iterator r126 = r124.iterator();
    L169:
        if (r126.hasNext() == false) goto L185;
        Object r127 = r126.next();
        ShareItemModel r128 = (ShareItemModel) r127;
        List<ShareItemModel> r129 = r120;
        if ((r129 instanceof Collection) == true) goto L173;
    L175:
        Iterator<T> r130 = r129.iterator();
    L177:
        if (r130.hasNext() == false) goto L181;
        if (Intrinsics.areEqual(((ShareItemModel) r130.next()).getItemId(), r128.getItemId()) == false) goto L177;
        boolean r131 = false;
    L182:
        if (r131 == false) goto L169;
        r125.add(r127);
    L181:
        r131 = true;
        goto L182
    L173:
        if (r129.isEmpty() == false) goto L175;
    L185:
        if (r120.isEmpty() == false) goto L188;
        r120 = r124;
        goto L199
    L188:
        if (r125.isEmpty() == true) goto L199;
        r120 = CollectionsKt.toMutableList(r120);
        ShareItemModel r132 = (ShareItemModel) CollectionsKt.lastOrNull(r120);
        if (r132 == null) goto L193;
        String r133 = r132.getItemId();
    L195:
        if (Intrinsics.areEqual(r133, ShareType.More.getItemId()) == false) goto L197;
        int r134 = RangesKt.coerceAtLeast(r120.size() - 1, 0);
    L198:
        r120.addAll(r134, r125);
        goto L199
    L197:
        r134 = RangesKt.coerceAtLeast(r120.size(), 0);
        goto L198
    L193:
        r133 = null;
        goto L195
    L143:
        FLogger.f375446a.i("OfficeSdkSharePanelProvider", "buildCustomItems: type=" + r210.f504066b + ", hostShareScene=" + r110 + ", configuredChannels=" + r121);
        ArrayList r135 = new ArrayList();
        Iterator r136 = r121.iterator();
    L145:
        if (r136.hasNext() == false) goto L160;
        final String r137 = (String) r136.next();
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L149
        ShareItemModel r139 = new ShareItemModel(r137);     // Catch: Throwable -> L149
        r139.setState(ShareState.SHOW);     // Catch: Throwable -> L149
        r139.setShareIconStyle(ShareItemModel.ShareIconStyle.FILL);     // Catch: Throwable -> L149
        d(r139, r137, r210);     // Catch: Throwable -> L149
        r139.setOnClickedListener(new com.larus.office.base.share.b(this, r137, r210));     // Catch: Throwable -> L149
        Object r140 = Result.m9449constructorimpl(r139);     // Catch: Throwable -> L149
    L151:
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L155;
        FLogger.f375446a.e("OfficeSdkSharePanelProvider", "createShareItem failed, itemId=" + r137, r141);
    L155:
        if (Result.m9455isFailureimpl(r140) == false) goto L157;
        r140 = null;
    L157:
        ShareItemModel r142 = (ShareItemModel) r140;
        if (r142 == null) goto L145;
        r135.add(r142);
    L149:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L151
    L160:
        HashSet r144 = new HashSet();
        ArrayList r145 = new ArrayList();
        Iterator r146 = r135.iterator();
    L162:
        if (r146.hasNext() == false) goto L166;
        Object r147 = r146.next();
        if (r144.add(((ShareItemModel) r147).getItemId()) == false) goto L162;
        r145.add(r147);
        goto L162
    L166:
        r124 = r145;
    L199:
        k r148 = this.f361124b;
        r148.getClass();
        Intrinsics.checkNotNullParameter(r120, "items");
        String r149 = r119;
        Intrinsics.checkNotNullParameter(r210, r149);
        k.a r150 = r148.f361154d;
        if (r150 == null) goto L215;
        Intrinsics.checkNotNullParameter(r210, r149);
        Intrinsics.checkNotNullParameter(r120, "items");
        if (r150.f361155a == true) goto L205;
        ShareServiceDelegate.f313831b.x(r148.f361151a.invoke(r210), r148.f361152b.invoke(r210), null);
        r150.f361155a = true;
    L205:
        Iterator r151 = r120.iterator();
    L207:
        if (r151.hasNext() == false) goto L215;
        String r152 = r148.f361153c.invoke((ShareItemModel) r151.next(), r210);
        if (r152 == null) goto L207;
        if (r150.f361156b.add(r152) == false) goto L207;
        ShareServiceDelegate.f313831b.i(r148.f361151a.invoke(r210), r152, r148.f361152b.invoke(r210), null);
    L215:
        return r120;
    L95:
        List r153 = r118;
        ArrayList r154 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r153, 10));
        Iterator r155 = r153.iterator();
    L97:
        if (r155.hasNext() == false) goto L131;
        ShareItemModel r156 = (ShareItemModel) r155.next();
        if (Intrinsics.areEqual(r156.getItemId(), ShareType.CopyLink.getItemId()) == true) goto L101;
    L103:
        boolean r157 = false;
    L104:
        if (r157 == false) goto L111;
        FLogger r158 = FLogger.f375446a;
        StringBuilder r159 = new StringBuilder("wrapCopyLinkItem: itemId=");
        r159.append(r156.getItemId());
        r159.append(r117);
        r159.append(r156.getType());
        r159.append(", hasOriginalListener=");
        if (r156.getOnClickedListener() == null) goto L108;
        boolean r160 = true;
    L109:
        r159.append(r160);
        r158.i("OfficeSdkSharePanelProvider", r159.toString());
        r158.i("OfficeSdkSharePanelProvider", "wrapCopyLinkItem: wrap copy link success, itemId=" + r156.getItemId());
        r156 = r156.copy();
        r156.setOnClickedListener(new c(this, r210));
    L121:
        r117 = r117;
        r155 = r155;
    L130:
        r154.add(r156);
        r155 = r155;
        r117 = r117;
        goto L97
    L108:
        r160 = false;
        goto L109
    L111:
        if (g() == true) goto L113;
    L115:
        boolean r161 = false;
    L116:
        if (r161 == false) goto L122;
        final String r162 = i(r156);
        if (r162 == null) goto L121;
        FLogger.f375446a.i("OfficeSdkSharePanelProvider", "wrapEnterpriseShareItemClick: replace enterprise click listener, itemId=" + r156.getItemId() + r117 + r156.getType() + ", channel=" + r162);
        r156 = r156.copy();
        Intrinsics.checkNotNull(r156);
        d(r156, r162, r210);
        r156.setOnClickedListener(new e(this, r162, r210));
        goto L121
    L122:
        String r163 = j(r156.getItemId(), r210);
        if (r163 != null) goto L125;
        r163 = r156.getItemId();
    L125:
        String r164 = r163;
        ShareItemModel r165 = r156.copy();
        ShareItemModel.a r166 = r165.getOnClickedListener();
        if ((r166 instanceof b) == true) goto L129;
        r165.setOnClickedListener(new j(this, r164, r210, r165, r166));
    L129:
        r156 = r165;
        goto L130
    L113:
        if (i(r156) == null) goto L115;
        r161 = true;
        goto L116
    L101:
        if (g() == true) goto L103;
        r157 = true;
        goto L104
    L131:
        r120 = r154;
        goto L132
    L36:
        if (g() == false) goto L57;
        ArrayList r167 = new ArrayList();
        Iterator<T> r168 = r116.iterator();
    L39:
        if (r168.hasNext() == false) goto L55;
        Object r169 = r168.next();
        ShareItemModel r170 = (ShareItemModel) r169;
        ShareType r171 = ShareType.Lark;
        if (h(r170, r171) == false) goto L46;
        if (l.a().contains(r171.getItemId()) == true) goto L46;
    L51:
        boolean r172 = true;
    L53:
        if (r172 == true) goto L39;
        r167.add(r169);
    L46:
        if (r210.f504066b == 125) goto L48;
    L52:
        r172 = h(r170, ShareType.Weibo);
        goto L53
    L48:
        if (h(r170, ShareType.PasswordLink) == true) goto L51;
        if (h(r170, r171) == false) goto L52;
    L55:
        r118 = r167;
        goto L69
    L57:
        if (r114.isEmpty() == false) goto L70;
        r167 = new ArrayList();
        Iterator<T> r173 = r116.iterator();
    L60:
        if (r173.hasNext() == false) goto L55;
        Object r174 = r173.next();
        ShareItemModel r175 = (ShareItemModel) r174;
        if (o(r175) == false) goto L64;
    L66:
        boolean r176 = false;
    L67:
        if (r176 == false) goto L60;
        r167.add(r174);
        goto L60
    L64:
        if (n(r175.getItemId(), r210) == false) goto L66;
        r176 = true;
        goto L67
    L70:
        Set r177 = CollectionsKt.toSet(r114);
        ArrayList r178 = new ArrayList();
        Iterator r179 = r116.iterator();
    L72:
        if (r179.hasNext() == false) goto L91;
        Object r180 = r179.next();
        ShareItemModel r181 = (ShareItemModel) r180;
        if (o(r181) == false) goto L76;
        FLogger.f375446a.i("OfficeSdkSharePanelProvider", "filterDefaultItems: remove personal default item, itemId=" + r181.getItemId() + ", type=" + r181.getType());
        boolean r182 = false;
    L88:
        if (r182 == false) goto L90;
        r178.add(r180);
    L90:
        r179 = r179;
        r100 = r100;
        goto L72
    L76:
        String r183 = j(r181.getItemId(), r210);
        if (n(r181.getItemId(), r210) == true) goto L86;
        if (r183 != null) goto L80;
    L82:
        boolean r184 = false;
    L83:
        if (r184 == true) goto L86;
        r182 = false;
    L87:
        FLogger.f375446a.i("OfficeSdkSharePanelProvider", "filterDefaultItems: itemId=" + r181.getItemId() + ", mappedChannel=" + r183 + ", shouldKeep=" + r182 + ", mergedChannels=" + r177);
        goto L88
    L80:
        if (r177.contains(r183) != true) goto L82;
        r184 = true;
    L86:
        r182 = true;
        goto L87
    L91:
        r119 = r100;
        r118 = r178;
        goto L93
    L29:
        r116 = null;
        goto L30
    }

    @Override // com.bytedance.ee.bear.share.export.o
    public final boolean b(km5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.ee.bear.share.export.o r101 = this.f361123a;
        if (r101 == null) goto L6;
        return r101.b(r100);
    L6:
        if (r100.f504081q == com.bytedance.ee.bear.share.externalshare.ShareScene.DOCUMENT) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean h(ShareItemModel r100, ShareType r101) {
        if (r100.getType() != r101) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.getItemId(), r101.getItemId()) == true) goto L8;
        return false;
    }

    public static String j(String r100, km5.a r101) {
        if (Intrinsics.areEqual(r100, ShareType.Lark.getItemId()) == false) goto L6;
    L39:
        return null;
    L6:
        if (Intrinsics.areEqual(r100, ShareType.CopyLink.getItemId()) == false) goto L9;
        return "copy_link";
    L9:
        if (Intrinsics.areEqual(r100, ShareType.QRCode.getItemId()) == false) goto L12;
        return ShareChannel.SCAN_QR_CODE;
    L12:
        if (Intrinsics.areEqual(r100, ShareType.PasswordLink.getItemId()) == true) goto L39;
        if (Intrinsics.areEqual(r100, ShareType.ExportImage.getItemId()) == false) goto L18;
        return ShareChannel.SHARE_LONG_PIC;
    L18:
        if (Intrinsics.areEqual(r100, ShareType.SlideExport.getItemId()) == true) goto L39;
        if (Intrinsics.areEqual(r100, ShareType.CopyText.getItemId()) == false) goto L24;
        return ShareChannel.COPY_TEXT;
    L24:
        if (Intrinsics.areEqual(r100, ShareType.More.getItemId()) == false) goto L27;
        return "more";
    L27:
        if (Intrinsics.areEqual(r100, ShareType.Download.getItemId()) == false) goto L33;
        if (r101.f504081q != com.bytedance.ee.bear.share.externalshare.ShareScene.EXPORT_IMAGE) goto L31;
        return ShareChannel.SAVE_IMAGE;
    L31:
        return ShareChannel.EXPORT_FILE;
    L33:
        if (Intrinsics.areEqual(r100, ShareType.Wechat.getItemId()) == true) goto L39;
        if (Intrinsics.areEqual(r100, ShareType.WechatMoments.getItemId()) == true) goto L39;
        if (Intrinsics.areEqual(r100, ShareType.QQ.getItemId()) == true) goto L39;
        Intrinsics.areEqual(r100, ShareType.Weibo.getItemId());
        goto L39
    }

    public static void k(String r100, km5.a r101) {
        ShareServiceDelegate.f313831b.s(m(r101), r100, e(r101), null);
    }

    public static boolean n(String r100, km5.a r101) {
        if (r101.f504081q != com.bytedance.ee.bear.share.externalshare.ShareScene.EXPORT_IMAGE) goto L6;
        return false;
    L6:
        if (r101.f504066b != 125) goto L13;
        if (Intrinsics.areEqual(r100, ShareType.PasswordLink.getItemId()) == false) goto L10;
    L11:
        return false;
    L10:
        if (Intrinsics.areEqual(r100, ShareType.Lark.getItemId()) == true) goto L11;
    L13:
        return l.a().contains(r100);
    }

    public static String r(String r100, int r101) {
        if (r101 == 0) goto L4;
        return r100;
    L4:
        Uri r102 = UriProtector.parse(r100);
        String r103 = r102.getEncodedPath();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        if (StringsKt.startsWith$default(r103, "/drive/folder/", false, 2, null) == false) goto L12;
        String r104 = r102.buildUpon().encodedPath("/drive/shr/" + StringsKt.removePrefix(r103, "/drive/folder/")).build().toString();
        Intrinsics.checkNotNull(r104);
        return r104;
    L12:
        return r100;
    }

    public static final Object c(OfficeSdkSharePanelProvider r100, km5.a r101, Continuation r102) {
        r100.getClass();
        IDocPublicPermission r103 = r101.f504077m;
        if (r103 != null) goto L6;
    L10:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L16;
        FLogger.f375446a.i("OfficeSdkSharePanelProvider", "ensurePublicPermissionForUrlShare: skip because already public, token=" + r101.f504067c + ", type=" + r101.f504066b);
        return Boxing.boxBoolean(true);
    L16:
        if (g() == true) goto L53;
        String r105 = r101.f504067c;
        com.bytedance.ee.permission.a r106 = null;
        if (r105 != null) goto L21;
    L23:
        r105 = null;
    L24:
        if (r105 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        if (r107 == false) goto L32;
        FLogger.f375446a.w("OfficeSdkSharePanelProvider", "ensurePublicPermissionForUrlShare: token is empty, type=" + r101.f504066b);
        return Boxing.boxBoolean(false);
    L32:
        int r108 = r101.f504066b;
        if (r108 != 2) goto L35;
    L41:
        IOfficeSdkServiceV2 r109 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r109 == null) goto L46;
        gk5.e r110 = r109.q0();
        if (r110 == null) goto L46;
        r106 = r110.i0();
    L46:
        if (r106 != null) goto L48;
        FLogger.f375446a.w("OfficeSdkSharePanelProvider", "updatePublicPermission: permissionSdk is null, token=" + r105 + ", docType=" + r108);
        return Boxing.boxBoolean(false);
    L48:
        kotlinx.coroutines.j r111 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r111.C();
        vt5.c r112 = new vt5.c(r105, r108);
        TypeExternalAccess r113 = TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r112.f557226d = r113;
        TypeLinkShare r114 = TypeLinkShare.LINK_SHARE_ANYONE_READ;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r112.f557227e = r114;
        ((PermissionSdk) r106).a().f(r112, new i(r111, r105, r108));
        Object r115 = r111.B();
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        DebugProbesKt.probeCoroutineSuspended(r102);
        return r115;
    L57:
        return r115;
    L35:
        if (r108 == 3) goto L41;
        if (r108 == 22) goto L41;
        if (r108 == 30) goto L41;
        return Boxing.boxBoolean(true);
    L26:
        if (StringsKt.isBlank(r105) == true) goto L29;
        r107 = false;
        goto L30
    L21:
        if ((!StringsKt.isBlank(r105)) == false) goto L23;
    L53:
        return Boxing.boxBoolean(true);
    L6:
        if (r103.isLinkShareAnyoneRead() == false) goto L8;
    L11:
        r104 = true;
        goto L13
    L8:
        if (r103.isLinkShareAnyoneEdit() == false) goto L10;
        goto L10
    }

    public static void d(ShareItemModel r100, String r101, km5.a r102) {
        jr9.b r103 = ShareServiceDelegate.f313831b.g(r101);
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = r103.f500143a;
        if (r104 == 0) goto L8;
        r100.setIconResId(r104);
    L8:
        int r105 = r103.f500145c;
        if (Intrinsics.areEqual(r101, ShareChannel.DOUYIN) == true) goto L11;
    L13:
        if (r105 == 0) goto L16;
        r100.setDescription(AppHost.f326268a.getApplication().getString(r105));
        return;
    L16:
        return;
    L11:
        if (r102.f504081q != com.bytedance.ee.bear.share.externalshare.ShareScene.DOCUMENT) goto L13;
        r105 = R.string.larus_sharesheet_douyinfriend_cn;
        goto L13
    }

    public static void l(String r100, String r101, boolean r102) {
        ShareServiceDelegate r103 = ShareServiceDelegate.f313831b;
        if (r102 == false) goto L5;
        String r104 = "1";
    L6:
        r103.d(r100, r101, null, r104);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public final void f(final String r210, km5.a r211, final Context r212, String r213, String r214, String r215) {
        String r100 = r215;
        k(r210, r211);
        boolean r101 = true;
        if (r211.f504066b != 125) goto L16;
        com.larus.office.base.share.a r102 = com.larus.office.base.share.a.f361125a;
        sr8.b r103 = com.larus.office.base.share.a.f361127c;
        if (r103 == null) goto L7;
        String r104 = r103.f543230a;
    L8:
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
    L23:
        String r106 = r104;
        if (r100 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        boolean r108 = !r107;
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("share item clicked, itemId=");
        r111.append(r210);
        r111.append(", hasContext=");
        if (r212 == null) goto L33;
        boolean r112 = true;
    L34:
        r111.append(r112);
        r111.append(", hasShareUrl=");
        if (r213 != null) goto L37;
    L40:
        boolean r113 = true;
    L41:
        r111.append(!r113);
        r111.append(", hasShareImage=");
        if (r100 != null) goto L44;
    L47:
        boolean r114 = true;
    L48:
        r111.append(!r114);
        r110.i("OfficeSdkSharePanelProvider", r111.toString());
        String r115 = "image";
        if (r212 != null) goto L56;
        r110.w("OfficeSdkSharePanelProvider", "share item clicked but context is null, itemId=" + r210);
        ShareServiceDelegate r109 = ShareServiceDelegate.f313831b;
        if (r108 == true) goto L54;
        r115 = "url";
    L54:
        r109.d(r210, r115, null, "0");
        return;
    L56:
        if (r108 == false) goto L74;
        if (r100 != null) goto L59;
    L62:
        if (r101 == false) goto L66;
        r110.w("OfficeSdkSharePanelProvider", "image share clicked but image path is empty, itemId=" + r210);
        l(r210, "image", false);
        return;
    L66:
        if (StringsKt.startsWith$default(r100, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == false) goto L69;
    L71:
        String r116 = r100;
        r110.i("OfficeSdkSharePanelProvider", "start image share, itemId=" + r210 + ", imagePath=" + r116);
        ImageSave.z(ImageSave.f295932a, r116, null, null, null, false, false, null, new f(r210, this, r212), 126);
        return;
    L69:
        if (StringsKt.startsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == false) goto L71;
        r100 = MSkiaImageRegionDecoder.FILE_PREFIX + r100;
        goto L71
    L59:
        if (StringsKt.isBlank(r215) == true) goto L62;
        r101 = false;
        goto L62
    L74:
        if (r213 != null) goto L76;
    L79:
        if (r101 == false) goto L82;
        r110.w("OfficeSdkSharePanelProvider", "url share clicked but share url is empty, itemId=" + r210);
        l(r210, "url", false);
        return;
    L82:
        r110.i("OfficeSdkSharePanelProvider", "start share, itemId=" + r210 + ", shareUrl=" + r213);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new OfficeSdkSharePanelProvider$shareUrlByChannel$1(this, r211, r210, r212, r213, r106, null), 3, null);
        return;
    L76:
        if (StringsKt.isBlank(r213) == true) goto L79;
        r101 = false;
        goto L79
    L44:
        if (StringsKt.isBlank(r215) == true) goto L47;
        r114 = false;
        goto L48
    L37:
        if (StringsKt.isBlank(r213) == true) goto L40;
        r113 = false;
        goto L41
    L33:
        r112 = false;
        goto L34
    L26:
        if (r215.length() == 0) goto L29;
        r107 = false;
        goto L30
    L10:
        if (StringsKt.isBlank(r104) == true) goto L13;
        r105 = false;
        goto L14
    L7:
        r104 = null;
    L16:
        if (r214 != null) goto L18;
    L22:
        r104 = AppHost.f326268a.getApplication().getString(R.string.larus_aiDoc_untitled_docName);
        goto L23
    L18:
        if ((!StringsKt.isBlank(r214)) == false) goto L20;
        r104 = r214;
    L21:
        if (r104 != null) goto L23;
    L20:
        r104 = null;
        goto L21
    }
}
