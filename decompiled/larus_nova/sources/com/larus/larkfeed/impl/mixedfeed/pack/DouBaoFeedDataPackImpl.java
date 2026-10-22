package com.larus.larkfeed.impl.mixedfeed.pack;

import android.os.SystemClock;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.keva.Keva;
import com.bytedance.lark.pb.office_sdk.im.FeedRankLevel;
import com.bytedance.lark.pb.office_sdk.im.MetaFeed;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkImResult;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkVerifyFeedRequest;
import com.bytedance.lark.pb.office_sdk.im.OpenFeedChannel;
import com.bytedance.lark.pb.office_sdk.im.OpenFeedExtraInfo;
import com.bytedance.lark.pb.office_sdk.im.OpenFeedPreview;
import com.bytedance.lark.pb.office_sdk.im.PackFeedChannelRequest;
import com.bytedance.lark.pb.office_sdk.im.PackFeedChannelResponse;
import com.bytedance.lark.pb.office_sdk.im.PackFeedPreviewRequest;
import com.bytedance.lark.pb.office_sdk.im.PackFeedPreviewResponse;
import com.google.gson.JsonObject;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import ic8.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class DouBaoFeedDataPackImpl implements qtb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vt7.b<WeakReference<qtb.c>> f355479a;

    public static final class a {
    }

    public static final class b implements IIMCallback<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> f355480a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        public b(kotlinx.coroutines.j r100) {
            this.f355480a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.w("DouBaoFeedDataPackImpl", "verifyFeedData: checkConversation failed, error=" + r100);
            if (this.f355480a.isActive() == false) goto L6;
            kotlinx.coroutines.i<Boolean> r101 = this.f355480a;
            Result.Companion r102 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
            return;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Boolean r100) {
            boolean r101 = r100.booleanValue();
            FLogger.f375446a.i("DouBaoFeedDataPackImpl", "verifyFeedData: checkConversation success, result=" + r101);
            if (this.f355480a.isActive() == false) goto L6;
            this.f355480a.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(r101)));
            return;
        }
    }

    static {
    }

    @Override // qtb.b
    public final boolean P0() {
        return false;
    }

    @Override // qtb.b
    public final boolean Y1() {
        return z2.f365865a.enableHasHumanTag();
    }

    @Override // qtb.b
    public final boolean getIsImFeatureOpenedByHostManual() {
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == true) goto L5;
        ConcurrentHashMap<String, Boolean> r101 = xh9.c.f563910a;
        Intrinsics.checkNotNullParameter("unexpected_rust_get_switch", "errorType");
        FLogger.f375446a.w("DouBaoFeedDataMonitor", "reportMixedFeedException errorType=unexpected_rust_get_switch");
        o r102 = o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("error_type", "unexpected_rust_get_switch");
        r102.reportEvent("dev_mixed_feed_exception", r103);
        com.larus.platform.service.g r104 = com.larus.platform.service.g.f365738a;
        JSONObject r105 = new JSONObject();
        r105.put("error_type", "unexpected_rust_get_switch");
        r104.monitorEventForSlardar("dev_mixed_feed_exception", r105, null, null);
    L5:
        com.larus.platform.exp.e r106 = com.larus.platform.exp.e.f365377a;
        String r107 = r100.getUserId();
        r106.getClass();
        return com.larus.platform.exp.e.a(r107);
    }

    public DouBaoFeedDataPackImpl() {
        this.f355479a = new vt7.b();
    }

    @Override // qtb.b
    public final boolean K(String r100) {
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        r101 = false;
    L9:
        if (r101 == false) goto L11;
        com.larus.platform.exp.e.f365377a.getClass();
        boolean r102 = com.larus.platform.exp.e.a(r100);
        FLogger.f375446a.i("DouBaoFeedDataPackImpl", "get freezeSnapshot = " + r102);
        return r102;
    L11:
        FLogger.f375446a.e("DouBaoFeedDataPackImpl", "not current Doubao user and return false");
        return false;
    L5:
        if (Intrinsics.areEqual(r100, AccountService.f365697a.getUserId()) == false) goto L7;
        goto L7
    }

    @Override // qtb.b
    public final void M(com.ss.android.lark.flow.feed.sidebar.human.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FLogger.f375446a.i("DouBaoFeedDataPackImpl", "addLoginFailureListener");
        Iterator<WeakReference<qtb.c>> r101 = this.f355479a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        WeakReference<qtb.c> r102 = r101.next();
        if (r102.get() != null) goto L4;
        this.f355479a.remove(r102);
        goto L4
    L8:
        vt7.b<WeakReference<qtb.c>> r103 = this.f355479a;
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator<WeakReference<qtb.c>> r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r104.next().get(), r100) == false) goto L15;
        boolean r105 = false;
    L20:
        if (r105 == false) goto L31;
        this.f355479a.add(new WeakReference(r100));
        return;
    L31:
        return;
    L19:
        r105 = true;
        goto L20
    L11:
        if (r103.isEmpty() == false) goto L13;
        goto L13
    }

    @Override // qtb.b
    public final void a0(com.ss.android.lark.flow.feed.sidebar.human.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FLogger.f375446a.i("DouBaoFeedDataPackImpl", "removeLoginFailureListener");
        Iterator<WeakReference<qtb.c>> r101 = this.f355479a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        WeakReference<qtb.c> r102 = r101.next();
        qtb.c r103 = r102.get();
        if (r103 == null) goto L9;
        if (Intrinsics.areEqual(r103, r100) == false) goto L4;
    L9:
        this.f355479a.remove(r102);
        goto L4
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0074 -> B:19:0x0076). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:23:0x008e). Please report as a decompilation issue!!! */
    @Override // qtb.b
    public final Object N1(byte[] r110, Continuation<? super byte[]> r111) {
        if ((r111 instanceof DouBaoFeedDataPackImpl$packFeedChannel$1) == false) goto L7;
        DouBaoFeedDataPackImpl$packFeedChannel$1 r100 = (DouBaoFeedDataPackImpl$packFeedChannel$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        Integer r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        MetaFeed r106 = (MetaFeed) r100.L$3;
        Iterator r107 = (Iterator) r100.L$2;
        Collection r108 = (Collection) r100.L$1;
        PackFeedChannelRequest r112 = (PackFeedChannelRequest) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L23:
        wh8.a r109 = (wh8.a) r102;
        if (r109 != null) goto L26;
        FLogger.f375446a.w("DouBaoFeedDataPackImpl", "packFeedChannel: conversationData missing, feedId=" + r106.feed_id + ", bizId=" + r106.biz_id);
    L19:
        OpenFeedChannel r113 = null;
    L46:
        if (r113 == null) goto L16;
        r108.add(r113);
    L16:
        if (r107.hasNext() == false) goto L48;
        r106 = (MetaFeed) r107.next();
        if (r106 == null) goto L19;
        DouBaoFeedDataProvider r114 = DouBaoFeedDataProvider.f355481a;
        String r115 = r106.biz_id;
        r100.L$0 = r112;
        r100.L$1 = r108;
        r100.L$2 = r107;
        r100.L$3 = r106;
        r100.label = 1;
        r102 = r114.a(r115, r100);
        if (r102 != r103) goto L23;
        return r103;
    L48:
        List<OpenFeedChannel> r116 = (List) r108;
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("packFeedChannel: originalSize=");
        List<MetaFeed> r119 = r112.meta_feed;
        if (r119 == null) goto L51;
        r105 = Boxing.boxInt(r119.size());
    L51:
        r118.append(r105);
        r118.append(", resultSize=");
        r118.append(r116.size());
        r117.i("DouBaoFeedDataPackImpl", r118.toString());
        byte[] r120 = new PackFeedChannelResponse.Builder().feed_channel(r116).build().encode();
        OfficeSdkImResult.Builder r121 = new OfficeSdkImResult.Builder();
        ByteString.a r122 = ByteString.Companion;
        Intrinsics.checkNotNull(r120);
        return r121.success_payload(ByteString.a.e(r122, r120)).build().encode();
    L26:
        wc9.e r123 = r109.f559708a;
        if (r123 == null) goto L37;
        Long r124 = Boxing.boxLong(r123.f559218u);
        if (r124.longValue() <= 0) goto L31;
        boolean r125 = true;
    L32:
        if (r125 == true) goto L35;
        r124 = null;
    L35:
        if (r124 == null) goto L37;
        Long r126 = Boxing.boxLong(r124.longValue() / ((long) 1000));
    L38:
        OpenFeedChannel.Builder r127 = new OpenFeedChannel.Builder().feed_id(r106.feed_id);
        wc9.e r128 = r109.f559708a;
        if (n.v(r128) == false) goto L42;
        FeedRankLevel r129 = FeedRankLevel.HIGH_RANK;
    L45:
        OpenFeedChannel.Builder r130 = r127.rank_level(r129).rank_time_ms(r126).badge_count(Boxing.boxInt(xh9.b.a(r109)));
        FLogger.f375446a.d("DouBaoFeedDataPackImpl", "packFeedChannel id=" + r106.biz_id + " rankTime=" + r106.rank_time_ms + ' ' + r130 + ' ' + r109.d());
        r113 = r130.build();
        goto L46
    L42:
        if (n.z(r128) == false) goto L44;
        r129 = FeedRankLevel.MEDIUM_RANK;
        goto L45
    L44:
        r129 = FeedRankLevel.LOWEST_RANK;
        goto L45
    L31:
        r125 = false;
    L37:
        r126 = r106.rank_time_ms;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        PackFeedChannelRequest r131 = PackFeedChannelRequest.ADAPTER.decode(r110);
        List<MetaFeed> r132 = r131.meta_feed;
        r112 = r131;
        r108 = new ArrayList();
        r107 = r132.iterator();
    L7:
        r100 = new DouBaoFeedDataPackImpl$packFeedChannel$1(this, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0079 -> B:19:0x007b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0093 -> B:23:0x0096). Please report as a decompilation issue!!! */
    @Override // qtb.b
    public final Object g0(byte[] r210, Continuation<? super byte[]> r211) {
        if ((r211 instanceof DouBaoFeedDataPackImpl$packFeedPreview$1) == false) goto L7;
        DouBaoFeedDataPackImpl$packFeedPreview$1 r100 = (DouBaoFeedDataPackImpl$packFeedPreview$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        String r106 = "DouBaoFeedDataPackImpl";
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r107 = r100.J$0;
        MetaFeed r108 = (MetaFeed) r100.L$3;
        Iterator r110 = (Iterator) r100.L$2;
        Collection r111 = (Collection) r100.L$1;
        PackFeedPreviewRequest r112 = (PackFeedPreviewRequest) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L23:
        wh8.a r109 = (wh8.a) r102;
        if (r109 != null) goto L26;
        FLogger.f375446a.w(r106, "packFeedPreview: conversationData missing, feedId=" + r108.feed_id + ", bizId=" + r108.biz_id);
    L19:
        OpenFeedPreview r113 = null;
    L170:
        if (r113 == null) goto L172;
        r111.add(r113);
    L172:
        r105 = 1;
    L16:
        if (r110.hasNext() == false) goto L173;
        r108 = (MetaFeed) r110.next();
        if (r108 == null) goto L19;
        DouBaoFeedDataProvider r114 = DouBaoFeedDataProvider.f355481a;
        String r115 = r108.biz_id;
        r100.L$0 = r112;
        r100.L$1 = r111;
        r100.L$2 = r110;
        r100.L$3 = r108;
        r100.J$0 = r107;
        r100.label = r105;
        r102 = r114.a(r115, r100);
        if (r102 != r103) goto L23;
        return r103;
    L173:
        List<OpenFeedPreview> r116 = (List) r111;
        byte[] r117 = new OfficeSdkImResult.Builder().success_payload(ByteString.a.e(ByteString.Companion, new PackFeedPreviewResponse.Builder().preview(r116).build().encode())).build().encode();
        FLogger.f375446a.i(r106, "packFeedPreview finished: size=" + r112.meta_feed.size() + "->" + r116.size() + ", version=" + r112 + ".version, cost=" + (SystemClock.elapsedRealtime() - r107) + "ms");
        Intrinsics.checkNotNull(r117);
        return r117;
    L26:
        wc9.e r118 = r109.f559708a;
        if (r118 == null) goto L37;
        Long r119 = Boxing.boxLong(r118.f559218u);
        if (r119.longValue() <= 0) goto L31;
        boolean r120 = true;
    L32:
        if (r120 == true) goto L35;
        r119 = null;
    L35:
        if (r119 == null) goto L37;
        Long r121 = Boxing.boxLong(r119.longValue() / ((long) 1000));
    L38:
        long r122 = SystemClock.elapsedRealtime();
        k r123 = k.f355492a;
        String r124 = r108.biz_id;
        r123.getClass();
        Intrinsics.checkNotNullParameter(r124, "bizId");
        Intrinsics.checkNotNullParameter(r109, "data");
        DouBaoFeedDataPackImpl$packFeedPreview$1 r125 = r100;
        JsonObject r126 = new JsonObject();
        r126.addProperty("bizId", r124);
        JsonObject r127 = new JsonObject();
        wc9.e r128 = r109.f559708a;
        Object r129 = r103;
        long r212 = r107;
        if (r128 == null) goto L56;
        JsonObject r130 = new JsonObject();
        k.e(r130, "conversationId", r128.f559198a);
        k.e(r130, "name", r128.f559200c);
        IconImage r131 = r128.f559199b;
        if (r131 == null) goto L45;
        ImageObj r132 = r131.imageThumb;
        if (r132 == null) goto L45;
        String r133 = r132.url;
    L46:
        k.e(r130, "avatarThumbUrl", r133);
        IconImage r134 = r128.f559199b;
        if (r134 == null) goto L51;
        ImageObj r135 = r134.imageOri;
        if (r135 == null) goto L51;
        String r136 = r135.url;
    L52:
        k.e(r130, "avatarOriUrl", r136);
        k.d(r130, UserInfo.UPDATE_TIME, r128.f559201d);
        k.b(r130, "pinned", r128.f559202e);
        k.b(r130, "isLocal", r128.f559203f);
        k.c(r130, "conversationPage", r128.f559204g);
        k.a(r130, "ttsEnable", Boolean.valueOf(r128.f559206i));
        k.b(r130, "conversationType", r128.f559207j);
        k.b(r130, "participantCount", r128.f559208k);
        k.b(r130, "botConversationType", r128.f559219v);
        k.b(r130, "status", r128.f559217t);
        k.b(r130, "badgeCount", r128.f559209l);
        k.b(r130, "readBadgeCount", r128.f559210m);
        k.e(r130, "briefMessageLocalId", r128.f559211n);
        k.e(r130, "ext", r128.f559215r);
        k.e(r130, "bizModel", r128.f559216s);
        k.d(r130, "version", Long.valueOf(r128.f559218u));
        k.c(r130, "bizExtra", r128.f559221x);
        k.e(r130, "ownerId", r128.f559223z);
        k.a(r130, "isDeleted", r128.A);
        k.e(r130, "sectionId", r128.B);
        k.b(r130, "inputLeftActionStyle", r128.C);
        k.b(r130, "groupReviewStatus", r128.D);
        k.b(r130, "createScene", r128.E);
        k.b(r130, "cellType", Integer.valueOf(r128.F));
        k.b(r130, "createChannel", Integer.valueOf(r128.G));
        k.e(r130, "parentCellId", r128.H);
        if (n.d(r128) == false) goto L55;
        r130.addProperty("forbidSendMsg", Boolean.TRUE);
    L55:
        Unit r137 = Unit.INSTANCE;
        r127.add("conversation", r130);
    L57:
        BotModel r138 = r109.f559709b;
        if (r138 == null) goto L80;
        JsonObject r139 = new JsonObject();
        k.e(r139, "botId", r138.getBotId());
        k.e(r139, "name", r138.getName());
        BotIconImage r140 = r138.getIconImage();
        if (r140 == null) goto L63;
        JsonObject r141 = new JsonObject();
        k.e(r141, "uri", r140.getUri());
        k.e(r141, "tinyUrl", r140.getTinyUrl());
        k.e(r141, "originUrl", r140.getOriginUrl());
        k.e(r141, "thumbnailUrl", r140.getThumbnailUrl());
        k.e(r141, "img720", r140.getImg720());
        Unit r142 = Unit.INSTANCE;
        r139.add("iconImage", r141);
    L63:
        k.b(r139, "botType", r138.getBotType());
        ShareInfo r143 = r138.getShareInfo();
        if (r143 == null) goto L67;
        JsonObject r144 = new JsonObject();
        k.e(r144, "shareStatus", r143.getShareStatus());
        k.e(r144, "shareBotUrl", r143.getShareBotUrl());
        k.e(r144, "qrCodeUrl", r143.getQrCodeUrl());
        k.a(r144, "isShowShareTab", r143.isShowShareTab());
        k.a(r144, "isShowMessageShare", r143.isShowMessageShare());
        Unit r145 = Unit.INSTANCE;
        r139.add("shareInfo", r144);
    L67:
        k.b(r139, "botStatus", r138.getBotStatus());
        k.b(r139, "botRecommendStatus", r138.getBotRecommendStatus());
        k.b(r139, "privateStatus", r138.getPrivateStatus());
        k.a(r139, "muted", Boolean.valueOf(r138.getMuted()));
        k.a(r139, "disabled", Boolean.valueOf(r138.getDisabled()));
        k.c(r139, "tagList", r138.getTagList());
        BotCreatorInfo r146 = r138.getBotCreatorInfo();
        if (r146 == null) goto L70;
        String r147 = r146.getId();
    L71:
        k.e(r139, "botCreatorId", r147);
        BotOnBoarding r148 = r138.getOnBoarding();
        if (r148 == null) goto L74;
        String r149 = r148.getPrologue();
    L75:
        k.e(r139, "onBoardingPrologue", r149);
        SpeakerVoice r150 = r138.getVoiceType();
        if (r150 == null) goto L78;
        String r151 = r150.getId();
    L79:
        k.e(r139, "voiceTypeId", r151);
        k.e(r139, "bgImgUrl", r138.getBgImgUrl());
        k.e(r139, "bgImgColor", r138.getBgImgColor());
        k.e(r139, "bgImgUri", r138.getBgImgUri());
        k.c(r139, "bgImgInfo", r138.getBgImgInfo());
        k.a(r139, "bgImgOpen", Boolean.valueOf(r138.getBgImgOpen()));
        Unit r152 = Unit.INSTANCE;
        r127.add("botModel", r139);
        goto L80
    L78:
        r151 = null;
        goto L79
    L74:
        r149 = null;
        goto L75
    L70:
        r147 = null;
    L80:
        Message r153 = r109.f559710c;
        if (r153 == null) goto L143;
        JsonObject r154 = new JsonObject();
        k.e(r154, "conversationId", r153.getConversationId());
        k.e(r154, "threadId", r153.getThreadId());
        k.e(r154, "messageId", r153.getMessageId());
        k.e(r154, "localMessageId", r153.getLocalMessageId());
        k.d(r154, "localIndex", Long.valueOf(r153.getLocalIndex()));
        k.d(r154, "serverIndex", Long.valueOf(r153.getServerIndex()));
        k.d(r154, "createTime", Long.valueOf(r153.getCreateTime()));
        k.e(r154, "senderId", r153.getSenderId());
        k.b(r154, "userType", Integer.valueOf(r153.getUserType()));
        k.b(r154, "contentType", Integer.valueOf(r153.getContentType()));
        k.a(r154, "isNewBlockType", Boolean.valueOf(r153.isNewBlockType()));
        k.b(r154, "messageStatusLocal", Integer.valueOf(r153.getMessageStatusLocal()));
        MessageStatus r155 = r153.getMessageStatus();
        if (r155 == null) goto L85;
        Integer r156 = Integer.valueOf(r155.value);
    L86:
        k.b(r154, "messageStatus", r156);
        k.e(r154, SelectInfo.BRIEF, r153.getBrief());
        k.e(r154, "content", r153.getContent());
        String r157 = r153.getBrief();
        if (r157 != null) goto L89;
    L92:
        boolean r158 = true;
    L93:
        if (r158 == false) goto L103;
        List<Block> r159 = r153.getContentBlock();
        if (r159 != null) goto L97;
    L100:
        boolean r160 = true;
    L101:
        if (r160 == true) goto L103;
        k.c(r154, "contentBlock", r153.getContentBlock());
        goto L103
    L97:
        if (r159.isEmpty() == true) goto L100;
        r160 = false;
    L103:
        k.e(r154, "thinkingContent", r153.getThinkingContent());
        k.a(r154, "sourceFromAsr", Boolean.valueOf(r153.getSourceFromAsr()));
        k.e(r154, "sectionId", r153.getSectionId());
        k.e(r154, "sectionName", r153.getSectionName());
        k.c(r154, "businessExt", r153.getBusinessExt());
        k.b(r154, "feedback", r153.getFeedback());
        k.e(r154, "replyId", r153.getReplyId());
        Map<String, String> r161 = r153.getExt();
        if (r161 == null) goto L119;
        LinkedHashMap r162 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r163 = r161.entrySet().iterator();
    L107:
        if (r163.hasNext() == false) goto L112;
        Map.Entry<String, String> r164 = r163.next();
        if ((!k.f355497f.contains(r164.getKey())) == false) goto L107;
        r162.put(r164.getKey(), r164.getValue());
        goto L107
    L112:
        if ((!r162.isEmpty()) == true) goto L115;
        r162 = null;
    L115:
        if (r162 == null) goto L119;
        k.c(r154, "ext", r162);
    L119:
        k r165 = k.f355492a;
        List<Integer> r166 = r153.getTags();
        r165.getClass();
        k.c(r154, PromotionProductPrivilegesStruct.TAGS, r166);
        k.a(r154, "msgLoading", Boolean.valueOf(r153.getMsgLoading()));
        k.e(r154, "bizContentType", r153.getBizContentType());
        k.b(r154, "isConnectCallerName", r153.isConnectCallerName());
        if (r153.getContentType() != 66) goto L131;
        List<Message> r167 = r153.getSubList();
        if (r167 != null) goto L124;
    L127:
        boolean r168 = true;
    L128:
        if (r168 == true) goto L131;
        k.c(r154, "subList", r153.getSubList());
        goto L131
    L124:
        if (r167.isEmpty() == true) goto L127;
        r168 = false;
    L131:
        if (r153.getContentType() != 67) goto L141;
        List<List<Message>> r169 = r153.getSubListGroup();
        if (r169 != null) goto L135;
    L138:
        boolean r170 = true;
    L139:
        if (r170 == true) goto L141;
        k.c(r154, "subListGroup", r153.getSubListGroup());
        goto L141
    L135:
        if (r169.isEmpty() == true) goto L138;
        r170 = false;
    L141:
        Unit r171 = Unit.INSTANCE;
        r127.add("message", r154);
        goto L143
    L89:
        if (r157.length() == 0) goto L92;
        r158 = false;
        goto L93
    L85:
        r156 = null;
    L143:
        k r172 = k.f355492a;
        String r173 = r109.f559711d;
        r172.getClass();
        k.e(r127, "senderName", r173);
        k.e(r127, "requestId", r109.f559712e);
        RecommendFrom r174 = r109.f559713f;
        if (r174 != null) goto L147;
    L154:
        k.b(r127, "recommendBotType", r109.f559714g);
        k.e(r127, "relatedCvsId", r109.f559715h);
        Unit r175 = Unit.INSTANCE;
        r126.add("data", r127);
        byte[] r176 = StringsKt.encodeToByteArray(r126.toString());
        OpenFeedPreview.Builder r177 = new OpenFeedPreview.Builder().feed_id(r108.feed_id);
        wc9.e r178 = r109.f559708a;
        if (n.v(r178) == false) goto L158;
        FeedRankLevel r179 = FeedRankLevel.HIGH_RANK;
    L161:
        OpenFeedPreview.Builder r180 = r177.rank_level(r179).rank_time_ms(r121).version(r112.version).badge_count(Boxing.boxInt(xh9.b.a(r109)));
        OpenFeedExtraInfo.Builder r181 = new OpenFeedExtraInfo.Builder();
        wc9.e r182 = r109.f559708a;
        if (r182 == null) goto L164;
        Boolean r183 = Boxing.boxBoolean(n.v(r182));
    L165:
        OpenFeedPreview.Builder r184 = r180.extra_info(r181.is_doubao_main_bot(r183).build()).preview_data(ByteString.a.e(ByteString.Companion, r176));
        FLogger r185 = FLogger.f375446a;
        StringBuilder r186 = new StringBuilder("packFeedPreview feedId=");
        r186.append(r184.feed_id);
        r186.append(" cvsId=");
        wc9.e r187 = r109.f559708a;
        if (r187 == null) goto L168;
        String r188 = r187.f559198a;
    L169:
        r186.append(r188);
        r186.append(" rankLevel=");
        r186.append(r184.rank_level);
        r186.append(" badgeCount=");
        r186.append(r184.badge_count);
        r186.append(" cost=");
        r186.append(SystemClock.elapsedRealtime() - r122);
        r186.append("ms size=");
        r186.append(r176.length);
        r106 = r106;
        r185.d(r106, r186.toString());
        r113 = r184.build();
        r100 = r125;
        r103 = r129;
        r107 = r212;
        r110 = r110;
        r111 = r111;
        goto L170
    L168:
        r188 = null;
        goto L169
    L164:
        r183 = null;
        goto L165
    L158:
        if (n.z(r178) == false) goto L160;
        r179 = FeedRankLevel.MEDIUM_RANK;
        goto L161
    L160:
        r179 = FeedRankLevel.LOWEST_RANK;
        goto L161
    L147:
        if (r174.f365482a == null) goto L149;
    L153:
        JsonObject r189 = new JsonObject();
        k.e(r189, "scene", r174.f365482a);
        k.e(r189, "requestId", r174.f365483b);
        k.e(r189, "recommendFrom", r174.f365484c);
        Unit r190 = Unit.INSTANCE;
        r127.add("recommendFrom", r189);
        goto L154
    L149:
        if (r174.f365483b != null) goto L153;
        if (r174.f365484c != null) goto L153;
    L51:
        r136 = null;
    L45:
        r133 = null;
        goto L46
    L56:
        r122 = r122;
        goto L57
    L31:
        r120 = false;
    L37:
        r121 = r108.rank_time_ms;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        PackFeedPreviewRequest r191 = PackFeedPreviewRequest.ADAPTER.decode(r210);
        r107 = SystemClock.elapsedRealtime();
        List<MetaFeed> r192 = r191.meta_feed;
        r112 = r191;
        r111 = new ArrayList();
        r110 = r192.iterator();
    L7:
        r100 = new DouBaoFeedDataPackImpl$packFeedPreview$1(this, r211);
        goto L8
    }

    @Override // qtb.b
    public final Object z1(byte[] r110, Continuation<? super Unit> r111) {
        OfficeSdkVerifyFeedRequest r112 = OfficeSdkVerifyFeedRequest.ADAPTER.decode(r110);
        List<MetaFeed> r100 = r112.meta_feed;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L10;
        MetaFeed r104 = (MetaFeed) r102.next();
        if (r104 == null) goto L8;
        r103 = r104.biz_id;
    L8:
        if (r103 == null) goto L3;
        r101.add(r103);
        goto L3
    L10:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        Object r107 = r106.next();
        if ((true ^ StringsKt.isBlank((String) r107)) == false) goto L12;
        r105.add(r107);
        goto L12
    L16:
        String r108 = CollectionsKt.joinToString$default(r105, ",", null, null, 0, null, null, 62, null);
        FLogger r109 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("verifyFeedData: size=");
        List<MetaFeed> r114 = r112.meta_feed;
        if (r114 == null) goto L19;
        r103 = Boxing.boxInt(r114.size());
    L19:
        r113.append(r103);
        r113.append(" conversationIds=");
        r113.append(r108);
        r109.i("DouBaoFeedDataPackImpl", r113.toString());
        if (r108.length() != 0) goto L22;
        boolean r115 = true;
    L23:
        if (r115 == true) goto L25;
        kotlinx.coroutines.j r116 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r111), 1);
        r116.C();
        com.larus.im.d.d().checkConversation(r108, new b(r116));
        Object r117 = r116.B();
        if (r117 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L30:
        if (r117 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        return r117;
    L33:
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L22:
        r115 = false;
        goto L23
    }

    @Override // qtb.b
    public final boolean X1(String r100, boolean r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L28;
        FLogger r103 = FLogger.f375446a;
        r103.i("DouBaoFeedDataPackImpl", "update Doubao IM Feature opened data");
        com.larus.platform.exp.e.f365377a.getClass();
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        String r104 = StringsKt.trim(r100).toString();
        if (r104.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        r103.e("DoubaoIMFeatureStore", "updateIfNewer normalizedUid is empty");
        return false;
    L15:
        Object r106 = com.larus.platform.exp.e.f365378b;
        monitor-enter(r106);
        com.larus.platform.exp.e.a r107 = com.larus.platform.exp.e.b(r104);     // Catch: Throwable -> L25
        if (r107 != null) goto L20;
    L22:
        ((Keva) com.larus.platform.exp.e.f365380d.getValue()).storeString("doubao_im_feature_opened::".concat(r104), new JSONObject().put("doubao_uid", r104).put("im_feature_opened", r110).put("update_timestamp_ms", r111).toString());     // Catch: Throwable -> L25
    L23:
        monitor-exit(r106);
        return r101;
    L20:
        if (r111 > r107.f365382b) goto L22;
        r103.i("DoubaoIMFeatureStore", "updateTimestampMs is not the newest");     // Catch: Throwable -> L25
        r101 = false;
    L25:
        th = move-exception;
        throw th;
    L12:
        r105 = false;
        goto L13
    L28:
        FLogger.f375446a.e("DouBaoFeedDataPackImpl", "not current Doubao user, not update");
        return false;
    L5:
        if (Intrinsics.areEqual(r100, AccountService.f365697a.getUserId()) == false) goto L7;
        r102 = true;
        goto L8
    }
}
