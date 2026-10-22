package com.larus.bmhome.utils;

import android.app.Application;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.Block;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Transient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010#H\u0002J\u000e\u0010$\u001a\u00020\u0000H\u0086@¢\u0006\u0002\u0010%J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R&\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lcom/larus/bmhome/utils/ReferenceMessage;", "", "messageId", "", "content", "senderName", "self", "", POINativeModule.RESP_EXIST, "searchIndex", "", "refExt", "replyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getContent", "getSenderName", "getSelf", "()Z", "getExist", "getSearchIndex", "()I", "getRefExt", "getReplyId$annotations", "()V", "getReplyId", "setReplyId", "(Ljava/lang/String;)V", "toJsonString", "getReferenceReply", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "getRefExtFromString", "", "update", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "Manager", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceMessage {
    public static final Companion Companion = null;
    private static final String DEFAULT_MSG_ID = "0";
    private static final ReferenceMessage EMPTY_REFERENCE_MESSAGE = null;
    public static final String KEY_REFERENCE_TEXT = "reference_text";
    private static final Map<String, String> botNameCache = null;
    private static final Lazy<Gson> convert$delegate = null;
    private static final Map<String, ReferenceMessage> refMessageCache = null;

    @SerializedName("content")
    private final String content;

    @SerializedName(POINativeModule.RESP_EXIST)
    private final boolean exist;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("ref_ext")
    private final String refExt;
    private transient String replyId;

    @SerializedName("search_index")
    private final int searchIndex;

    @SerializedName("self")
    private final boolean self;

    @SerializedName("sender_name")
    private final String senderName;

    public static final class Companion {
        public Companion() {
        }

        public final Object c(ReferenceInfo r210, Continuation<? super ReferenceMessage> r211) {
            ReferenceInfo r100 = r210;
            if ((r211 instanceof ReferenceMessage$Companion$build$8) == false) goto L7;
            ReferenceMessage$Companion$build$8 r101 = (ReferenceMessage$Companion$build$8) r211;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L19;
            if (r105 == 1) goto L15;
            if (r105 != 2) goto L14;
            boolean r106 = r101.Z$0;
            String r107 = (String) r101.L$3;
            String r108 = (String) r101.L$2;
            Message r109 = (Message) r101.L$1;
            ReferenceInfo r110 = (ReferenceInfo) r101.L$0;
            ResultKt.throwOnFailure(r103);
            boolean r111 = r106;
            String r112 = r107;
            String r113 = r108;
        L49:
            String r114 = (String) r103;
            boolean r115 = com.larus.bmhome.chat.bean.d.G0(r109);
            int r116 = r110.searchIndex;
            JSONObject r117 = new JSONObject();
            Map<String, String> r118 = r110.ext;
            if (r118 == null) goto L55;
            Iterator<Map.Entry<String, String>> r119 = r118.entrySet().iterator();
        L53:
            if (r119.hasNext() == false) goto L55;
            Map.Entry<String, String> r120 = r119.next();
            r117.put(r120.getKey(), r120.getValue());
        L55:
            Unit r121 = Unit.INSTANCE;
            ReferenceMessage r122 = new ReferenceMessage(r113, r112, r114, r115, r111, r116, r117.toString(), null, 128, null);
            String r123 = r122.getMessageId();
            if (r123 == null) goto L58;
            ReferenceMessage.access$getRefMessageCache$cp().put(r123, r122);
        L58:
            return r122;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            String r124 = (String) r101.L$2;
            ReferenceMessage r125 = (ReferenceMessage) r101.L$1;
            ReferenceInfo r126 = (ReferenceInfo) r101.L$0;
            ResultKt.throwOnFailure(r103);     // Catch: Exception -> L18
            String r127 = r124;
            r100 = r126;
            Object r128 = r103;
        L33:
            r109 = (Message) r128;     // Catch: Exception -> L60
        L36:
            if (r109 != null) goto L39;
            FLogger.f375446a.i("BotUtils", "ref message not found, use default");
            return r125;
        L39:
            boolean r129 = com.larus.bmhome.chat.bean.d.U(r109);
            if (r129 == false) goto L44;
            String r130 = r100.displayContent;
            if (r130 != null) goto L45;
            r130 = "";
        L45:
            r101.L$0 = r100;
            r101.L$1 = r109;
            r101.L$2 = r127;
            r101.L$3 = r130;
            r101.Z$0 = r129;
            r101.label = 2;
            Object r131 = d(r109, false, r101);
            if (r131 != r104) goto L48;
            return r104;
        L48:
            r113 = r127;
            r103 = r131;
            r111 = r129;
            r112 = r130;
            r110 = r100;
            goto L49
        L44:
            r130 = AppHost.f326268a.getApplication().getString(R.string.larus_quote_message_deleted);
        L35:
            r109 = null;
        L18:
            r127 = r124;
            r100 = r126;
            goto L35
        L19:
            ResultKt.throwOnFailure(r103);
            r125 = new ReferenceMessage(null, r100.displayContent, null, false, false, 0, null, null, 253, null);
            r127 = r100.referencedMessageId;
            if (r127 != null) goto L22;
        L25:
            boolean r132 = true;
        L26:
            if (r132 == false) goto L28;
        L59:
            return r125;
        L28:
            if (Intrinsics.areEqual(r127, "0") == true) goto L59;
            IChatRepoService r133 = zh8.a.f572196a;     // Catch: Exception -> L60
            r101.L$0 = r100;     // Catch: Exception -> L60
            r101.L$1 = r125;     // Catch: Exception -> L60
            r101.L$2 = r127;     // Catch: Exception -> L60
            r101.label = 1;     // Catch: Exception -> L60
            r128 = r133.E1(r127, r101);     // Catch: Exception -> L60
            if (r128 != r104) goto L33;
            return r104;
        L22:
            if (r127.length() == 0) goto L25;
            r132 = false;
        L7:
            r101 = new ReferenceMessage$Companion$build$8(this, r211);
            goto L8
        }

        public static ReferenceMessage a(ReferenceInfo r210, Message r211, BotModel r212) {
            Intrinsics.checkNotNullParameter(r210, "info");
            ReferenceMessage r100 = new ReferenceMessage(null, r210.displayContent, null, false, false, 0, null, null, 253, null);
            String r110 = r210.referencedMessageId;
            if (r211 != null) goto L5;
        L46:
            FLogger.f375446a.i("BotUtils", "ref message not found, use default");
            return r100;
        L5:
            if (r110 != null) goto L7;
        L10:
            boolean r101 = true;
        L11:
            if (r101 == true) goto L46;
            if (Intrinsics.areEqual(r110, "0") == true) goto L46;
            ReferenceMessage r102 = (ReferenceMessage) ReferenceMessage.access$getRefMessageCache$cp().get(r110);
            if (r102 == null) goto L18;
            return r102;
        L18:
            boolean r111 = com.larus.bmhome.chat.bean.d.U(r211);
            if (r111 == false) goto L23;
            String r103 = r210.displayContent;
            if (r103 != null) goto L24;
            String r112 = "";
        L25:
            String r104 = r211.getReplyId();
            if (r104 != null) goto L28;
        L30:
            r104 = null;
        L31:
            if (r104 != null) goto L33;
            String r213 = "";
        L34:
            String r105 = r212.getName();
            if (r105 != null) goto L37;
            String r113 = "";
        L38:
            boolean r114 = com.larus.bmhome.chat.bean.d.G0(r211);
            int r106 = r210.searchIndex;
            JSONObject r107 = new JSONObject();
            Map<String, String> r108 = r210.ext;
            if (r108 == null) goto L45;
            Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
        L42:
            if (r109.hasNext() == false) goto L45;
            Map.Entry<String, String> r115 = r109.next();
            r107.put(r115.getKey(), r115.getValue());
        L45:
            return new ReferenceMessage(r110, r112, r113, r114, r111, r106, r107.toString(), r213);
        L37:
            r113 = r105;
            goto L38
        L33:
            r213 = r104;
            goto L34
        L28:
            if ((true ^ Intrinsics.areEqual(r104, "0")) == false) goto L30;
        L24:
            r112 = r103;
            goto L25
        L23:
            r103 = AppHost.f326268a.getApplication().getString(R.string.larus_quote_message_deleted);
            goto L24
        L7:
            if (r110.length() == 0) goto L10;
            r101 = false;
            goto L11
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.utils.m3] */
        public final Object b(Message r210, Map<String, String> r211, Continuation<? super ReferenceMessage> r212) {
            if ((r212 instanceof ReferenceMessage$Companion$build$1) == false) goto L7;
            ReferenceMessage$Companion$build$1 r100 = (ReferenceMessage$Companion$build$1) r212;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            String r111 = "";
            if (r103 == 0) goto L16;
            if (r103 == 1) goto L15;
            if (r103 != 2) goto L14;
            String r104 = (String) r100.L$4;
            String r105 = (String) r100.L$3;
            String r106 = (String) r100.L$2;
            Map<String, String> r107 = (Map) r100.L$1;
            Message r108 = (Message) r100.L$0;
            ResultKt.throwOnFailure(r102);
            String r112 = r104;
        L70:
            String r109 = (String) r102;
            boolean r113 = com.larus.bmhome.chat.bean.d.G0(r108);
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L81
            int r115 = com.larus.utils.p0.f375454a;     // Catch: Throwable -> L81
            Map<String, String> r116 = r108.getBusinessExt();     // Catch: Throwable -> L81
            if (r116 == null) goto L74;
            String r117 = r116.get("search_index");     // Catch: Throwable -> L81
        L75:
            String r118 = com.larus.utils.p0.a(r117);     // Catch: Throwable -> L81
            if (r118 == null) goto L78;
            int r119 = CastIntegerProtector.parseInt(r118);     // Catch: Throwable -> L81
        L79:
            Object r120 = Result.m9449constructorimpl(Boxing.boxInt(r119));     // Catch: Throwable -> L81
        L84:
            if (Result.m9452exceptionOrNullimpl(r120) == null) goto L87;
            r120 = Boxing.boxInt(0);
        L87:
            int r121 = ((Number) r120).intValue();
            JSONObject r122 = new JSONObject();
            Map<String, String> r123 = r108.getExt();
            if (r123 == null) goto L90;
            r122.put("deep_research_phase", r123.get("deep_research_phase"));
        L90:
            if (r107 == null) goto L96;
            Iterator<Map.Entry<String, String>> r124 = r107.entrySet().iterator();
        L93:
            if (r124.hasNext() == false) goto L96;
            Map.Entry<String, String> r125 = r124.next();
            r122.put(r125.getKey(), r125.getValue());
        L96:
            return new ReferenceMessage(r105, r106, r109, r113, true, r121, r122.toString(), r112);
        L78:
            r119 = 0;
            goto L79
        L74:
            r117 = null;
        L81:
            th = move-exception;
            Result.Companion r126 = Result.Companion;
            r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L84
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            Map<String, String> r127 = (Map) r100.L$1;
            Message r128 = (Message) r100.L$0;
            ResultKt.throwOnFailure(r102);
            Map<String, String> r129 = r127;
        L24:
            List r130 = (List) r102;
            if (r130 == null) goto L28;
            String r131 = CollectionsKt.joinToString$default(r130, "", null, null, 0, null, new n3(), 30, null);
        L56:
            r106 = r131;
        L57:
            String r132 = r128.getMessageId();
            String r133 = r128.getReplyId();
            if (r133 != null) goto L60;
        L62:
            r133 = null;
        L63:
            if (r133 == null) goto L66;
            r111 = r133;
        L66:
            r100.L$0 = r128;
            r100.L$1 = r129;
            r100.L$2 = r106;
            r100.L$3 = r132;
            r100.L$4 = r111;
            r100.label = 2;
            Object r134 = d(r128, true, r100);
            if (r134 != r110) goto L69;
            return r110;
        L69:
            r112 = r111;
            r107 = r129;
            Message r213 = r128;
            r105 = r132;
            r102 = r134;
            r108 = r213;
            goto L70
        L60:
            if ((!Intrinsics.areEqual(r133, "0")) == false) goto L62;
        L28:
            r106 = null;
            goto L57
        L16:
            ResultKt.throwOnFailure(r102);
            if (com.larus.im.bean.message.a.b0(r210) == false) goto L29;
            com.larus.bmhome.chat.layout.holder.helper.s0 r135 = ILegacyChatUiServiceDelegate.f297164b.X8();
            if (r135 == null) goto L27;
            Application r136 = AppHost.f326268a.getApplication();
            List<Block> r137 = com.larus.im.bean.message.a.A(r210);
            ?? r138 = new m3();
            r100.L$0 = r210;
            r129 = r211;
            r100.L$1 = r129;
            r100.label = 1;
            r102 = com.larus.bmhome.chat.layout.holder.helper.s0.a.c(r135, r136, r137, true, r138, r100, 56);
            if (r102 != r110) goto L23;
            return r110;
        L23:
            r128 = r210;
            goto L24
        L27:
            r129 = r211;
            r128 = r210;
            goto L28
        L29:
            r129 = r211;
            String r139 = r210.getContent();
            if (r139 != null) goto L32;
        L52:
            r131 = null;
        L53:
            r128 = r210;
            if (r131 != null) goto L56;
            r106 = "";
            goto L57
        L32:
            if (r139.length() <= 0) goto L34;
            boolean r140 = true;
        L35:
            if (r140 == true) goto L38;
            r139 = null;
        L38:
            if (r139 == null) goto L52;
            if (StringsKt.isBlank(r139) == false) goto L97;
        L48:
            Object r141 = null;
        L49:
            TextContent r142 = (TextContent) r141;
            if (r142 == null) goto L52;
            r131 = r142.text;
            goto L53
        L97:
            Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L44
            r141 = Result.m9449constructorimpl(HttpExtKt.f360123f.fromJson(r139, TextContent.class));     // Catch: Throwable -> L44
        L47:
            if (Result.m9455isFailureimpl(r141) == false) goto L49;
        L44:
            th = move-exception;
            Result.Companion r144 = Result.Companion;
            r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L47
        L34:
            r140 = false;
        L7:
            r100 = new ReferenceMessage$Companion$build$1(this, r212);
            goto L8
        }

        public final Object d(Message r100, boolean r101, Continuation<? super String> r102) {
            if ((r102 instanceof ReferenceMessage$Companion$getBotName$1) == false) goto L7;
            ReferenceMessage$Companion$getBotName$1 r103 = (ReferenceMessage$Companion$getBotName$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            boolean r108 = true;
            String r109 = "";
            if (r107 == 0) goto L16;
            if (r107 != 1) goto L15;
            r100 = (Message) r103.L$0;
            ResultKt.throwOnFailure(r105);     // Catch: Exception -> L35
        L29:
            BotModel r110 = (BotModel) r105;     // Catch: Exception -> L35
            if (r110 == null) goto L37;
            String r111 = r110.getName();     // Catch: Exception -> L35
            if (r111 == null) goto L37;
            r109 = r111;
            goto L37
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r105);
            if (r100 != null) goto L19;
            return "";
        L19:
            if (r101 == false) goto L23;
            String r112 = r100.getConversationId();
            String r113 = (String) ReferenceMessage.access$getBotNameCache$cp().get(r112);
            if (r113 == null) goto L23;
            return r113;
        L23:
            IChatRepoService r114 = zh8.a.f572196a;     // Catch: Exception -> L35
            IChatRepoService r115 = zh8.a.f572196a;     // Catch: Exception -> L35
            String r116 = r100.getMessageId();     // Catch: Exception -> L35
            if (r116 != null) goto L26;
            r116 = "";
        L26:
            r103.L$0 = r100;     // Catch: Exception -> L35
            r103.label = 1;     // Catch: Exception -> L35
            r105 = r115.F1(r116, r103);     // Catch: Exception -> L35
            if (r105 != r106) goto L29;
            return r106;
        L37:
            if (r109.length() == 0) goto L40;
            r108 = false;
        L40:
            if (r108 == false) goto L42;
            return r109;
        L42:
            String r117 = r100.getConversationId();
            if (r117 == null) goto L45;
            ReferenceMessage.access$getBotNameCache$cp().put(r117, r109);
        L45:
            return r109;
        L7:
            r103 = new ReferenceMessage$Companion$getBotName$1(this, r102);
            goto L8
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function0<Unit> f314952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ReferenceMessage f314953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f314954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f314955d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f314956e;

        /* JADX INFO: renamed from: com.larus.bmhome.utils.ReferenceMessage$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4110a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f314957a = null;

            static {
                int[] r100 = new int[RefEntranceType.values().length];
                r100[RefEntranceType.ChooseTextAutoCite.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[RefEntranceType.LongPressAnswerMore.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[RefEntranceType.LongPressAndChooseText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[RefEntranceType.ClickMarkDownLink.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[RefEntranceType.TaskCardQuestion.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f314957a = r100;
            }
        }

        public a() {
            this.f314952a = new p3();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.utils.ReferenceMessage$update$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.utils.ReferenceMessage", f = "ReferenceMessage.kt", i = {}, l = {270}, m = "update", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ReferenceMessage this$0;

        public AnonymousClass1(ReferenceMessage r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(this);
        }
    }

    public ReferenceMessage() {
        this(null, null, null, false, false, 0, null, null, 255, null);
    }

    public static /* synthetic */ Gson a() {
        return convert_delegate$lambda$4();
    }

    public static /* synthetic */ String b(ReferenceMessage r100) {
        return toJsonString$lambda$0(r100);
    }

    public static /* synthetic */ ReferenceMessage copy$default(ReferenceMessage r100, String r110, String r111, String r112, boolean r113, boolean r114, int r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.messageId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.content;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.senderName;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.self;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.exist;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.searchIndex;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.refExt;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.replyId;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @Transient
    public static /* synthetic */ void getReplyId$annotations() {
    }

    public final String component1() {
        return this.messageId;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.senderName;
    }

    public final boolean component4() {
        return this.self;
    }

    public final boolean component5() {
        return this.exist;
    }

    public final int component6() {
        return this.searchIndex;
    }

    public final String component7() {
        return this.refExt;
    }

    public final String component8() {
        return this.replyId;
    }

    public final ReferenceMessage copy(String r110, String r111, String r112, boolean r113, boolean r114, int r115, String r116, String r117) {
        return new ReferenceMessage(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReferenceMessage) == true) goto L8;
        return false;
    L8:
        ReferenceMessage r101 = (ReferenceMessage) r100;
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderName, r101.senderName) == true) goto L18;
        return false;
    L18:
        if (this.self == r101.self) goto L21;
        return false;
    L21:
        if (this.exist == r101.exist) goto L24;
        return false;
    L24:
        if (this.searchIndex == r101.searchIndex) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refExt, r101.refExt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.messageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.senderName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.self == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.exist == true) goto L22;
        r110 = 1237;
    L22:
        int r113 = (((r112 + r110) * 31) + this.searchIndex) * 31;
        String r114 = this.refExt;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.replyId;
        if (r117 == null) goto L31;
        r101 = r117.hashCode();
    L31:
        return r116 + r101;
    L25:
        r115 = r114.hashCode();
        goto L26
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ReferenceMessage(messageId=" + this.messageId + ", content=" + this.content + ", senderName=" + this.senderName + ", self=" + this.self + ", exist=" + this.exist + ", searchIndex=" + this.searchIndex + ", refExt=" + this.refExt + ", replyId=" + this.replyId + ')';
    }

    static {
        Companion = new Companion();
        convert$delegate = LazyKt.lazy(new l3());
        botNameCache = new LinkedHashMap();
        refMessageCache = new LinkedHashMap();
        EMPTY_REFERENCE_MESSAGE = new ReferenceMessage("", "", "", false, false, 0, null, null, 224, null);
    }

    private static final Gson convert_delegate$lambda$4() {
        return new Gson();
    }

    private final Map<String, String> getRefExtFromString() {
        if (this.refExt != null) goto L26;
        return null;
    L26:
        LinkedHashMap r100 = new LinkedHashMap();     // Catch: JSONException -> L25
        JSONObject r101 = new JSONObject(this.refExt);     // Catch: JSONException -> L25
        Object r102 = r101.opt("deep_research_phase");     // Catch: JSONException -> L25
        if ((r102 instanceof String) == false) goto L8;
        String r103 = (String) r102;     // Catch: JSONException -> L25
    L9:
        if (r103 == null) goto L11;
        r100.put("deep_research_phase", r103);     // Catch: JSONException -> L25
    L11:
        r100.put("ref_msg_is_self", String.valueOf(this.self));     // Catch: JSONException -> L25
        Object r104 = r101.opt("ref_icon_key");     // Catch: JSONException -> L25
        if ((r104 instanceof String) == false) goto L14;
        String r105 = (String) r104;     // Catch: JSONException -> L25
    L15:
        if (r105 == null) goto L17;
        r100.put("ref_icon_key", r105);     // Catch: JSONException -> L25
    L17:
        Object r106 = r101.opt("general_task_param");     // Catch: JSONException -> L25
        if ((r106 instanceof String) == false) goto L20;
        String r107 = (String) r106;     // Catch: JSONException -> L25
    L21:
        if (r107 == null) goto L24;
        r100.put("general_task_param", r107);     // Catch: JSONException -> L25
    L24:
        return r100;
    L20:
        r107 = null;
        goto L21
    L14:
        r105 = null;
        goto L15
    L8:
        r103 = null;
    L28:
        return null;
    }

    public final ReferenceInfo getReferenceInfo() {
        String r100 = this.messageId;
        String r101 = this.replyId;
        return new ReferenceInfo(1, this.content, r100, this.searchIndex, null, getRefExtFromString(), null, r101, 80, null);
    }

    public final String getReferenceReply() {
        String r100 = this.content;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String toJsonString() {
        return (String) com.larus.utils.l0.a("", new k3(this));
    }

    public static final /* synthetic */ Map access$getBotNameCache$cp() {
        return botNameCache;
    }

    public static final /* synthetic */ Lazy access$getConvert$delegate$cp() {
        return convert$delegate;
    }

    public static final /* synthetic */ ReferenceMessage access$getEMPTY_REFERENCE_MESSAGE$cp() {
        return EMPTY_REFERENCE_MESSAGE;
    }

    public static final /* synthetic */ Map access$getRefMessageCache$cp() {
        return refMessageCache;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getExist() {
        return this.exist;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getRefExt() {
        return this.refExt;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final int getSearchIndex() {
        return this.searchIndex;
    }

    public final boolean getSelf() {
        return this.self;
    }

    public final String getSenderName() {
        return this.senderName;
    }

    private static final String toJsonString$lambda$0(ReferenceMessage r100) {
        Companion.getClass();
        return GsonProtectorUtils.toJson((Gson) access$getConvert$delegate$cp().getValue(), r100);
    }

    public final void setReplyId(String r100) {
        this.replyId = r100;
    }

    public final Object update(Continuation<? super ReferenceMessage> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        Message r105 = null;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L30
    L28:
        r105 = (Message) r102;     // Catch: Exception -> L30
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        String r106 = this.messageId;     // Catch: Exception -> L30
        if (r106 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L31;
        IChatRepoService r108 = zh8.a.f572196a;     // Catch: Exception -> L30
        IChatRepoService r109 = zh8.a.f572196a;     // Catch: Exception -> L30
        String r111 = this.messageId;     // Catch: Exception -> L30
        r100.label = 1;     // Catch: Exception -> L30
        r102 = r109.E1(r111, r100);     // Catch: Exception -> L30
        if (r102 != r103) goto L28;
        return r103;
    L19:
        if (r106.length() == 0) goto L22;
        r107 = false;
    L31:
        boolean r112 = com.larus.bmhome.chat.bean.d.U(r105);
        if (r112 == false) goto L34;
        String r113 = this.content;
    L36:
        return copy$default(this, null, r113, null, false, r112, 0, null, null, VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, null);
    L34:
        r113 = AppHost.f326268a.getApplication().getString(R.string.larus_quote_message_deleted);
    L7:
        r100 = new AnonymousClass1(this, r110);
        goto L8
    }

    public ReferenceMessage(String r100, String r101, String r102, boolean r103, boolean r104, int r105, String r106, String r107) {
        this.messageId = r100;
        this.content = r101;
        this.senderName = r102;
        this.self = r103;
        this.exist = r104;
        this.searchIndex = r105;
        this.refExt = r106;
        this.replyId = r107;
    }

    public /* synthetic */ ReferenceMessage(String r110, String r111, String r112, boolean r113, boolean r114, int r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        int r104 = 0;
        if ((r118 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r118 & 32) != 0) goto L27;
        r104 = r115;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r105, r106, r104, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
