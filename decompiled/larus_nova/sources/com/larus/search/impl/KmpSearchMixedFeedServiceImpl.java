package com.larus.search.impl;

import com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Item;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.bytedance.lark.pb.feed.v1.FeedCursor;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListResponse;
import com.bytedance.lark.pb.feed.v1.OpenFeedData;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u0018H\u0002J\f\u0010\u0019\u001a\u00020\f*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\f*\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001d*\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u001dH\u0002J\u000e\u0010\u001f\u001a\u00020\u0010*\u0004\u0018\u00010 H\u0002J\u000e\u0010!\u001a\u0004\u0018\u00010\u0010*\u00020\"H\u0002J'\u0010#\u001a\u0004\u0018\u00010\u0010*\u00020\"2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100%\"\u00020\u0010H\u0002¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020\f*\u00020\"H\u0002R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"Lcom/larus/search/impl/KmpSearchMixedFeedServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedService;", "<init>", "()V", "ntpService", "Lcom/ss/android/lark/usersetting/service/ntp/INtpService;", "kotlin.jvm.PlatformType", "getNtpService", "()Lcom/ss/android/lark/usersetting/service/ntp/INtpService;", "ntpService$delegate", "Lkotlin/Lazy;", "isMixedFeedEnabled", "", "requestMixedFeed", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedResult;", EffectConfiguration.KEY_CURSOR, "", "count", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeedOfficeSdkService", "Lcom/ss/android/lark/officesdk/feed/api/IFeedOfficeSdkService;", "toSearchMixedFeedPreview", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedPreview;", "Lcom/bytedance/lark/pb/feed/v1/FeedEntityPreview;", "hasActiveOnLeaveStatus", "Lcom/bytedance/lark/pb/feed/v1/ChatData;", "hasExternalRelationTag", "toFeedCursor", "Lcom/bytedance/lark/pb/feed/v1/FeedCursor;", "toCursorKey", "decodeDoubaoConversationId", "", "readConversationId", "Lorg/json/JSONObject;", "optNonBlankString", "keys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "hasPreviewDataPayloadKeys", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpSearchMixedFeedServiceImpl implements SearchMixedFeedService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f367416c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f367417b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService
    public final boolean i3() {
        LarkSocialExp.f365340a.getClass();
        return LarkSocialExp.e();
    }

    public KmpSearchMixedFeedServiceImpl() {
        this.f367417b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new w());
    }

    public static FeedCursor k0(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        long r101 = 0;
        long r102 = Long.MAX_VALUE;
        if (r100 == true) goto L12;
        List r111 = StringsKt.split$default(r110, new String[]{":"}, false, 2, 2, null);
        String r103 = (String) CollectionsKt.getOrNull(r111, 0);
        if (r103 == null) goto L18;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L18;
        r101 = r104.longValue();
    L18:
        String r112 = (String) CollectionsKt.getOrNull(r111, 1);
        if (r112 == null) goto L24;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L24;
        r102 = r113.longValue();
    L24:
        return new FeedCursor(Long.valueOf(r102), Long.valueOf(r101));
    L12:
        return new FeedCursor(Long.MAX_VALUE, 0L);
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r100 = false;
        goto L9
    }

    public final zv5.k z0(FeedEntityPreview r310) {
        String r100 = "";
        if (r310.doubao_custom_data == null) goto L83;
        String r101 = r310.biz_id;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (StringsKt.isBlank(r101) == false) goto L79;
        OpenFeedData r102 = r310.doubao_custom_data;
        if (r102 == null) goto L14;
        ByteString r103 = r102.preview_data;
        if (r103 == null) goto L14;
        byte[] r104 = r103.toByteArray();
    L198:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        if (r104 == null) goto L18;
        String r106 = StringsKt.decodeToString(r104);     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r107) == false) goto L26;
        r107 = null;
    L26:
        String r108 = (String) r107;
        if (r108 != null) goto L30;
        r108 = "";
    L30:
        if (StringsKt.isBlank(r108) == true) goto L76;
        String r109 = StringsKt.trim(r108).toString();
        if (StringsKt.startsWith$default(r109, "{", false, 2, null) == false) goto L76;
        Object r110 = Result.m9449constructorimpl(new JSONObject(r109));     // Catch: Throwable -> L37
    L40:
        if (Result.m9455isFailureimpl(r110) == false) goto L42;
        r110 = null;
    L42:
        JSONObject r111 = (JSONObject) r110;
        if (r111 != null) goto L49;
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("decodeDoubaoConversationId failed, size=");
        if (r104 == null) goto L47;
        int r114 = r104.length;
    L48:
        r113.append(r114);
        r112.w("SearchMixedFeedServiceImpl", r113.toString());
        goto L76
    L47:
        r114 = 0;
        goto L48
    L49:
        String r115 = u(r111, new String[]{"bizId"});
        if (r115 != null) goto L77;
        JSONObject r116 = r111.optJSONObject("data");
        if (r116 == null) goto L56;
        JSONObject r117 = r116.optJSONObject("conversation");
        if (r117 == null) goto L56;
        r115 = u(r117, new String[]{"conversationId", "conversation_id"});
    L57:
        if (r115 != null) goto L77;
        if (r111.has("conversation") == false) goto L61;
    L66:
        boolean r118 = true;
    L67:
        if (r118 == true) goto L70;
        r111 = null;
    L70:
        if (r111 == null) goto L74;
        JSONObject r119 = r111.optJSONObject("conversation");
        if (r119 == null) goto L74;
        r101 = u(r119, new String[]{"conversationId", "conversation_id"});
    L75:
        if (r101 != null) goto L79;
    L74:
        r101 = null;
        goto L75
    L61:
        if (r111.has("botModel") == true) goto L66;
        if (r111.has("message") == true) goto L66;
        r118 = false;
    L56:
        r115 = null;
    L77:
        r101 = r115;
    L37:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L76:
        r101 = "";
        goto L79
    L18:
        r106 = null;
    L21:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        r104 = null;
    L79:
        if ((!StringsKt.isBlank(r101)) == true) goto L82;
        r101 = null;
    L82:
        String r122 = r101;
    L84:
        ChatData r123 = r310.chat_data;
        if (r123 == null) goto L189;
        Item r124 = r123.item;
        if (r124 == null) goto L89;
        String r125 = r124.entity_id;
    L90:
        if (r125 != null) goto L93;
        r125 = "";
    L93:
        if (StringsKt.isBlank(r125) == false) goto L98;
        r125 = r310.biz_id;
        if (r125 != null) goto L98;
        r125 = "";
    L98:
        if (StringsKt.isBlank(r125) == false) goto L102;
        r125 = r310.feed_id;
        if (r125 != null) goto L102;
        String r126 = "";
    L103:
        String r127 = r123.chatter_id;
        if (r127 != null) goto L106;
        String r128 = "";
    L107:
        String r129 = (String) CollectionsKt.firstOrNull(r123.avatar_urls);
        if (r129 != null) goto L110;
        String r130 = "";
    L111:
        String r131 = r123.name;
        if (r131 != null) goto L114;
        String r132 = "";
    L115:
        String r133 = r123.localized_digest_message;
        if (r133 != null) goto L118;
        String r134 = "";
    L119:
        Long r135 = r123.display_time;
        Long r136 = r310.backup_update_time_ms;
        Integer r137 = r123.unread_count;
        if (r137 == null) goto L122;
        int r138 = r137.intValue();
    L123:
        Chat.Type r139 = r123.chat_type;
        if (r139 == null) goto L126;
        Integer r140 = Integer.valueOf(r139.getValue());
    L127:
        Boolean r141 = r123.is_shortcut;
        Boolean r142 = Boolean.TRUE;
        boolean r143 = Intrinsics.areEqual(r141, r142);
        String r144 = r123.avatar_key;
        if (r144 == null) goto L131;
        r100 = r144;
    L131:
        boolean r210 = Intrinsics.areEqual(r123.is_public_v2, r142);
        boolean r211 = Intrinsics.areEqual(r123.is_department, r142);
        List<Tag> r145 = r123.tags;
        if (r145 != null) goto L134;
    L136:
        boolean r212 = false;
    L137:
        List<Tag> r146 = r123.tags;
        if (r146 != null) goto L140;
    L142:
        boolean r213 = false;
    L143:
        boolean r214 = Intrinsics.areEqual(r123.is_blocked, r142);
        long r147 = ((cac.a) this.f367417b.getValue()).a(30000) / 1000;
        List<Chatter.ChatterCustomStatus> r148 = r123.chatter_status;
        if (r148 != null) goto L146;
        r148 = CollectionsKt.emptyList();
    L146:
        List<Chatter.ChatterCustomStatus> r149 = r148;
        if ((r149 instanceof Collection) == true) goto L149;
    L151:
        Iterator r150 = r149.iterator();
    L153:
        if (r150.hasNext() == false) goto L171;
        Chatter.ChatterCustomStatus r151 = (Chatter.ChatterCustomStatus) r150.next();
        StatusEffectiveInterval r152 = r151.effective_interval;
        if (r152 != null) goto L157;
        Iterator r215 = r150;
    L167:
        boolean r153 = false;
    L168:
        if (r153 == true) goto L169;
        r150 = r215;
        goto L153
    L169:
        boolean r154 = true;
    L172:
        TagData r155 = com.ss.android.lark.parser.internal.a0.a(r123.tag_info);
        if (r155 == null) goto L182;
        TagData.Companion.getClass();
        Iterator r156 = ((ArrayList) TagData.a.b(r155)).iterator();
    L176:
        if (r156.hasNext() == false) goto L180;
        Object r157 = r156.next();
        if (g08.b.a(((g08.a) r157).f479500b) == false) goto L176;
    L181:
        g08.a r158 = (g08.a) r157;
    L183:
        if (r158 != null) goto L185;
    L187:
        boolean r216 = false;
    L188:
        zv5.j r159 = new zv5.j(r126, r128, r130, r132, r134, r135, r136, r138, r140, r143, r100, r210, r211, r212, r213, r214, r154, r216, Intrinsics.areEqual(r123.is_agent, Boolean.TRUE));
    L190:
        if (r122 != null) goto L195;
        if (r159 != null) goto L195;
        return null;
    L195:
        return new zv5.k(r122, r159, r310.update_time, r310.rank_level, r310.on_top_rank_time);
    L185:
        if (r158.f479500b != 1) goto L187;
        r216 = true;
        goto L188
    L180:
        r157 = null;
        goto L181
    L182:
        r158 = null;
        goto L183
    L157:
        r215 = r150;
        if (Intrinsics.areEqual(r151.icon_key, "GeneralVacation") == false) goto L167;
        Long r160 = r152.start_time;
        if (r147 <= r152.end_time.longValue()) goto L162;
    L164:
        boolean r161 = false;
    L165:
        if (r161 == false) goto L167;
        r153 = true;
        goto L168
    L162:
        if (r160.longValue() > r147) goto L164;
        r161 = true;
    L171:
        r154 = false;
        goto L172
    L149:
        if (r149.isEmpty() == false) goto L151;
    L140:
        if (r146.contains(Tag.FROZEN) != true) goto L142;
        r213 = true;
        goto L143
    L134:
        if (r145.contains(Tag.USER_RESIGNED) != true) goto L136;
        r212 = true;
        goto L137
    L126:
        r140 = null;
        goto L127
    L122:
        r138 = 0;
        goto L123
    L118:
        r134 = r133;
        goto L119
    L114:
        r132 = r131;
        goto L115
    L110:
        r130 = r129;
        goto L111
    L106:
        r128 = r127;
    L102:
        r126 = r125;
        goto L103
    L89:
        r125 = null;
        goto L90
    L189:
        r159 = null;
        goto L190
    L83:
        r122 = null;
        goto L84
    }

    public static String u(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        String r104 = null;
        if (r103 >= r102) goto L10;
        String r105 = r100.optString(r101[r103]);
        Intrinsics.checkNotNull(r105);
        if ((!StringsKt.isBlank(r105)) == false) goto L8;
        r104 = r105;
    L8:
        if (r104 != null) goto L10;
        r103 = r103 + 1;
    L10:
        return r104;
    }

    @Override // com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService
    public final Object r2(String r100, int r110, Continuation<? super zv5.l> r111) {
        if ((r111 instanceof KmpSearchMixedFeedServiceImpl$requestMixedFeed$1) == false) goto L7;
        KmpSearchMixedFeedServiceImpl$requestMixedFeed$1 r101 = (KmpSearchMixedFeedServiceImpl$requestMixedFeed$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        KmpSearchMixedFeedServiceImpl r105 = (KmpSearchMixedFeedServiceImpl) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14
    L44:
        GetDoubaoFeedListResponse r113 = (GetDoubaoFeedListResponse) r112;     // Catch: Throwable -> L14
        if (r113 != null) goto L47;
        zv5.l r114 = null;
    L64:
        Object r106 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L14
    L67:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r106);
        if (r115 == null) goto L71;
        FLogger.f375446a.e("SearchMixedFeedServiceImpl", "requestMixedFeed failed", r115);
    L71:
        if (Result.m9455isFailureimpl(r106) == false) goto L74;
        return null;
    L74:
        return r106;
    L47:
        List<FeedEntityPreview> r116 = r113.previews;     // Catch: Throwable -> L14
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<T> r117 = r116.iterator();     // Catch: Throwable -> L14
    L49:
        if (r117.hasNext() == false) goto L53;
        FeedEntityPreview r108 = (FeedEntityPreview) r117.next();     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L14
        zv5.k r109 = r105.z0(r108);     // Catch: Throwable -> L14
        if (r109 == null) goto L49;
        r107.add(r109);     // Catch: Throwable -> L14
        goto L49
    L53:
        FeedCursor r118 = r113.next_cursor;     // Catch: Throwable -> L14
        r105.getClass();     // Catch: Throwable -> L14
        if (r118 == null) goto L62;
        Long r119 = r118.f253623id;     // Catch: Throwable -> L14
        if (r119 == null) goto L62;
        long r120 = r119.longValue();     // Catch: Throwable -> L14
        Long r121 = r118.rank_time;     // Catch: Throwable -> L14
        if (r121 == null) goto L60;
        long r122 = r121.longValue();     // Catch: Throwable -> L14
    L61:
        StringBuilder r123 = new StringBuilder();     // Catch: Throwable -> L14
        r123.append(r120);     // Catch: Throwable -> L14
        r123.append(':');     // Catch: Throwable -> L14
        r123.append(r122);     // Catch: Throwable -> L14
        String r124 = r123.toString();     // Catch: Throwable -> L14
    L63:
        r114 = new zv5.l(r107, r124);     // Catch: Throwable -> L14
        goto L64
    L60:
        r122 = Long.MAX_VALUE;
    L62:
        r124 = null;
        goto L63
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L28
        Object r126 = xp9.o.f564776a;     // Catch: Throwable -> L28
        if ((r126 instanceof OfficeSDKUserApi) == false) goto L22;
        OfficeSDKUserApi r127 = (OfficeSDKUserApi) r126;     // Catch: Throwable -> L28
    L23:
        if (r127 == null) goto L25;
        qtb.a r128 = (qtb.a) r127.getService(qtb.a.class);     // Catch: Throwable -> L28
    L26:
        Object r129 = Result.m9449constructorimpl(r128);     // Catch: Throwable -> L28
    L30:
        Throwable r130 = Result.m9452exceptionOrNullimpl(r129);
        if (r130 == null) goto L34;
        FLogger.f375446a.e("SearchMixedFeedServiceImpl", "getFeedOfficeSdkService failed", r130);
    L34:
        if (Result.m9455isFailureimpl(r129) == false) goto L36;
        r129 = null;
    L36:
        qtb.a r131 = (qtb.a) r129;
        if (r131 != null) goto L40;
        FLogger.f375446a.w("SearchMixedFeedServiceImpl", "requestMixedFeed skipped, feedUpdateService is null");
        return null;
    L40:
        FeedCursor r132 = k0(r100);     // Catch: Throwable -> L14
        r101.L$0 = this;     // Catch: Throwable -> L14
        r101.label = 1;     // Catch: Throwable -> L14
        r112 = r131.Ra(r132, r110);     // Catch: Throwable -> L14
        if (r112 != r103) goto L43;
        return r103;
    L43:
        r105 = this;
        goto L44
    L25:
        r128 = null;
        goto L26
    L22:
        r127 = null;
    L28:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new KmpSearchMixedFeedServiceImpl$requestMixedFeed$1(this, r111);
        goto L8
    }
}
