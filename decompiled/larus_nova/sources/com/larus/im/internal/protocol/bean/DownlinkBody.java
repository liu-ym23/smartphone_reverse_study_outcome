package com.larus.im.internal.protocol.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00060\u0001j\u0002`\u0002:\u0002STB¯\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 B§\u0001\b\u0010\u0012\u0006\u0010!\u001a\u00020\"\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\u001f\u0010%J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u001eHÆ\u0003J±\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÆ\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\"HÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001J%\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0001¢\u0006\u0002\bRR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b&\u0010'R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b(\u0010'R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b)\u0010'R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b*\u0010'R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b+\u0010'R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b,\u0010'R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b-\u0010'R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b.\u0010'R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b/\u0010'R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b0\u0010'R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b1\u0010'R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b2\u0010'R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b3\u0010'R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b4\u0010'¨\u0006U"}, d2 = {"Lcom/larus/im/internal/protocol/bean/DownlinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "newMessageNotify", "Lcom/larus/im/internal/protocol/bean/NewMessageNotify;", "sendMessageAckDownlinkBody", "Lcom/larus/im/internal/protocol/bean/SendMessageAckDownlinkBody;", "sendMessageListAckDownlinkBody", "Lcom/larus/im/internal/protocol/bean/SendMessageListAckDownlinkBody;", "fetchChunkMessageDownlinkBody", "Lcom/larus/im/internal/protocol/bean/FetchChunkMessageDownlinkBody;", "chunkUpdateDownlinkBody", "Lcom/larus/im/internal/protocol/bean/ChunkUpdateDownlinkBody;", "pullSingeChainDownlinkBody", "Lcom/larus/im/internal/protocol/bean/PullSingleChainDownlinkBody;", "getConvInfoDownlinkBody", "Lcom/larus/im/internal/protocol/bean/GetConversationInfoDownlinkBody;", "batchGetConvInfoDownlinkBody", "Lcom/larus/im/internal/protocol/bean/BatchGetConversationInfoDownlinkBody;", "getParticipantDownlinkBody", "Lcom/larus/im/internal/protocol/bean/GetConversationParticipantDownlinkBody;", "batchGetConversationParticipantsDownlinkBody", "Lcom/larus/im/internal/protocol/bean/BatchGetConversationParticipantsDownlinkBody;", "commonCmdNotify", "Lcom/larus/im/internal/protocol/bean/CommonCmdNotify;", "botReplyLoadingUpdateNotify", "Lcom/larus/im/internal/protocol/bean/BotReplyLoadingUpdateNotify;", "replyEndDownlinkBody", "Lcom/larus/im/internal/protocol/bean/ReplyEndDownlinkBody;", "generalInteractionAskNotify", "Lcom/larus/im/internal/protocol/bean/GeneralInteractionAskNotifyDownlinkBody;", "<init>", "(Lcom/larus/im/internal/protocol/bean/NewMessageNotify;Lcom/larus/im/internal/protocol/bean/SendMessageAckDownlinkBody;Lcom/larus/im/internal/protocol/bean/SendMessageListAckDownlinkBody;Lcom/larus/im/internal/protocol/bean/FetchChunkMessageDownlinkBody;Lcom/larus/im/internal/protocol/bean/ChunkUpdateDownlinkBody;Lcom/larus/im/internal/protocol/bean/PullSingleChainDownlinkBody;Lcom/larus/im/internal/protocol/bean/GetConversationInfoDownlinkBody;Lcom/larus/im/internal/protocol/bean/BatchGetConversationInfoDownlinkBody;Lcom/larus/im/internal/protocol/bean/GetConversationParticipantDownlinkBody;Lcom/larus/im/internal/protocol/bean/BatchGetConversationParticipantsDownlinkBody;Lcom/larus/im/internal/protocol/bean/CommonCmdNotify;Lcom/larus/im/internal/protocol/bean/BotReplyLoadingUpdateNotify;Lcom/larus/im/internal/protocol/bean/ReplyEndDownlinkBody;Lcom/larus/im/internal/protocol/bean/GeneralInteractionAskNotifyDownlinkBody;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/protocol/bean/NewMessageNotify;Lcom/larus/im/internal/protocol/bean/SendMessageAckDownlinkBody;Lcom/larus/im/internal/protocol/bean/SendMessageListAckDownlinkBody;Lcom/larus/im/internal/protocol/bean/FetchChunkMessageDownlinkBody;Lcom/larus/im/internal/protocol/bean/ChunkUpdateDownlinkBody;Lcom/larus/im/internal/protocol/bean/PullSingleChainDownlinkBody;Lcom/larus/im/internal/protocol/bean/GetConversationInfoDownlinkBody;Lcom/larus/im/internal/protocol/bean/BatchGetConversationInfoDownlinkBody;Lcom/larus/im/internal/protocol/bean/GetConversationParticipantDownlinkBody;Lcom/larus/im/internal/protocol/bean/BatchGetConversationParticipantsDownlinkBody;Lcom/larus/im/internal/protocol/bean/CommonCmdNotify;Lcom/larus/im/internal/protocol/bean/BotReplyLoadingUpdateNotify;Lcom/larus/im/internal/protocol/bean/ReplyEndDownlinkBody;Lcom/larus/im/internal/protocol/bean/GeneralInteractionAskNotifyDownlinkBody;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNewMessageNotify$annotations", "()V", "getSendMessageAckDownlinkBody$annotations", "getSendMessageListAckDownlinkBody$annotations", "getFetchChunkMessageDownlinkBody$annotations", "getChunkUpdateDownlinkBody$annotations", "getPullSingeChainDownlinkBody$annotations", "getGetConvInfoDownlinkBody$annotations", "getBatchGetConvInfoDownlinkBody$annotations", "getGetParticipantDownlinkBody$annotations", "getBatchGetConversationParticipantsDownlinkBody$annotations", "getCommonCmdNotify$annotations", "getBotReplyLoadingUpdateNotify$annotations", "getReplyEndDownlinkBody$annotations", "getGeneralInteractionAskNotify$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class DownlinkBody implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public BatchGetConversationInfoDownlinkBody batchGetConvInfoDownlinkBody;
    public BatchGetConversationParticipantsDownlinkBody batchGetConversationParticipantsDownlinkBody;
    public BotReplyLoadingUpdateNotify botReplyLoadingUpdateNotify;
    public ChunkUpdateDownlinkBody chunkUpdateDownlinkBody;
    public CommonCmdNotify commonCmdNotify;
    public FetchChunkMessageDownlinkBody fetchChunkMessageDownlinkBody;
    public GeneralInteractionAskNotifyDownlinkBody generalInteractionAskNotify;
    public GetConversationInfoDownlinkBody getConvInfoDownlinkBody;
    public GetConversationParticipantDownlinkBody getParticipantDownlinkBody;
    public NewMessageNotify newMessageNotify;
    public PullSingleChainDownlinkBody pullSingeChainDownlinkBody;
    public c replyEndDownlinkBody;
    public SendMessageAckDownlinkBody sendMessageAckDownlinkBody;
    public SendMessageListAckDownlinkBody sendMessageListAckDownlinkBody;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<DownlinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349625a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349626b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349626b;
        }

        static {
            a r100 = new a();
            f349625a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.DownlinkBody", r100, 14);
            r101.j("new_message_notify", true);
            r101.j("send_message_ack_downlink_body", true);
            r101.j("send_message_list_ack_downlink_body", true);
            r101.j("fetch_chunk_message_downlink_body", true);
            r101.j("chunk_update_downlink_body", true);
            r101.j("pull_singe_chain_downlink_body", true);
            r101.j("get_conv_info_downlink_body", true);
            r101.j("batch_get_conv_info_downlink_body", true);
            r101.j("get_participant_downlink_body", true);
            r101.j("batch_get_conversation_participants_downlink_body", true);
            r101.j("common_cmd_notify", true);
            r101.j("bot_reply_loading_update_notify", true);
            r101.j("reply_end_downlink_body", true);
            r101.j("general_interaction_ask_notify", true);
            f349626b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(NewMessageNotify.a.f349688a), kuc.a.d(SendMessageAckDownlinkBody.a.f349710a), kuc.a.d(SendMessageListAckDownlinkBody.a.f349712a), kuc.a.d(FetchChunkMessageDownlinkBody.a.f349629a), kuc.a.d(ChunkUpdateDownlinkBody.a.f349605a), kuc.a.d(PullSingleChainDownlinkBody.a.f349696a), kuc.a.d(GetConversationInfoDownlinkBody.a.f349635a), kuc.a.d(BatchGetConversationInfoDownlinkBody.a.f349580a), kuc.a.d(GetConversationParticipantDownlinkBody.a.f349639a), kuc.a.d(BatchGetConversationParticipantsDownlinkBody.a.f349584a), kuc.a.d(CommonCmdNotify.a.f349609a), kuc.a.d(BotReplyLoadingUpdateNotify.a.f349594a), kuc.a.d(c.a.f349760a), kuc.a.d(GeneralInteractionAskNotifyDownlinkBody.a.f349633a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f349626b;
            muc.c r101 = r310.beginStructure(r100);
            int r110 = 11;
            c r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            NewMessageNotify r103 = (NewMessageNotify) r101.decodeNullableSerializableElement(r100, 0, NewMessageNotify.a.f349688a, null);
            SendMessageAckDownlinkBody r104 = (SendMessageAckDownlinkBody) r101.decodeNullableSerializableElement(r100, 1, SendMessageAckDownlinkBody.a.f349710a, null);
            SendMessageListAckDownlinkBody r111 = (SendMessageListAckDownlinkBody) r101.decodeNullableSerializableElement(r100, 2, SendMessageListAckDownlinkBody.a.f349712a, null);
            FetchChunkMessageDownlinkBody r105 = (FetchChunkMessageDownlinkBody) r101.decodeNullableSerializableElement(r100, 3, FetchChunkMessageDownlinkBody.a.f349629a, null);
            ChunkUpdateDownlinkBody r112 = (ChunkUpdateDownlinkBody) r101.decodeNullableSerializableElement(r100, 4, ChunkUpdateDownlinkBody.a.f349605a, null);
            PullSingleChainDownlinkBody r106 = (PullSingleChainDownlinkBody) r101.decodeNullableSerializableElement(r100, 5, PullSingleChainDownlinkBody.a.f349696a, null);
            GetConversationInfoDownlinkBody r107 = (GetConversationInfoDownlinkBody) r101.decodeNullableSerializableElement(r100, 6, GetConversationInfoDownlinkBody.a.f349635a, null);
            BatchGetConversationInfoDownlinkBody r108 = (BatchGetConversationInfoDownlinkBody) r101.decodeNullableSerializableElement(r100, 7, BatchGetConversationInfoDownlinkBody.a.f349580a, null);
            GetConversationParticipantDownlinkBody r113 = (GetConversationParticipantDownlinkBody) r101.decodeNullableSerializableElement(r100, 8, GetConversationParticipantDownlinkBody.a.f349639a, null);
            BatchGetConversationParticipantsDownlinkBody r109 = (BatchGetConversationParticipantsDownlinkBody) r101.decodeNullableSerializableElement(r100, 9, BatchGetConversationParticipantsDownlinkBody.a.f349584a, null);
            CommonCmdNotify r114 = (CommonCmdNotify) r101.decodeNullableSerializableElement(r100, 10, CommonCmdNotify.a.f349609a, null);
            BotReplyLoadingUpdateNotify r115 = (BotReplyLoadingUpdateNotify) r101.decodeNullableSerializableElement(r100, 11, BotReplyLoadingUpdateNotify.a.f349594a, null);
            c r210 = (c) r101.decodeNullableSerializableElement(r100, 12, c.a.f349760a, null);
            GeneralInteractionAskNotifyDownlinkBody r211 = (GeneralInteractionAskNotifyDownlinkBody) r101.decodeNullableSerializableElement(r100, 13, GeneralInteractionAskNotifyDownlinkBody.a.f349633a, null);
            PullSingleChainDownlinkBody r116 = r106;
            GetConversationInfoDownlinkBody r117 = r107;
            BatchGetConversationInfoDownlinkBody r212 = r108;
            BatchGetConversationParticipantsDownlinkBody r213 = r109;
            CommonCmdNotify r214 = r114;
            BotReplyLoadingUpdateNotify r215 = r115;
            SendMessageListAckDownlinkBody r118 = r111;
            GetConversationParticipantDownlinkBody r216 = r113;
            SendMessageAckDownlinkBody r119 = r104;
            int r120 = 16383;
            FetchChunkMessageDownlinkBody r121 = r105;
            ChunkUpdateDownlinkBody r122 = r112;
            NewMessageNotify r123 = r103;
        L36:
            r101.endStructure(r100);
            return new DownlinkBody(r120, r123, r119, r118, r121, r122, r116, r117, r212, r216, r213, r214, r215, r210, r211, null);
        L5:
            int r124 = 13;
            SendMessageListAckDownlinkBody r125 = null;
            ChunkUpdateDownlinkBody r126 = null;
            BatchGetConversationInfoDownlinkBody r127 = null;
            GeneralInteractionAskNotifyDownlinkBody r128 = null;
            BotReplyLoadingUpdateNotify r129 = null;
            GetConversationInfoDownlinkBody r130 = null;
            PullSingleChainDownlinkBody r131 = null;
            CommonCmdNotify r132 = null;
            FetchChunkMessageDownlinkBody r133 = null;
            NewMessageNotify r134 = null;
            SendMessageAckDownlinkBody r217 = null;
            GetConversationParticipantDownlinkBody r218 = null;
            BatchGetConversationParticipantsDownlinkBody r219 = null;
            int r135 = 0;
            boolean r311 = true;
        L6:
            if (r311 == false) goto L35;
            int r136 = r101.decodeElementIndex(r100);
            switch(r136) {
                case -1: goto L33;
                case 0: goto L32;
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L22;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L17;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r136);
        L32:
            NewMessageNotify r137 = r134;
            SendMessageAckDownlinkBody r138 = r217;
            NewMessageNotify r139 = (NewMessageNotify) r101.decodeNullableSerializableElement(r100, 0, NewMessageNotify.a.f349688a, r137);
            r135 = r135 | 1;
        L34:
            r218 = r218;
            r217 = r138;
            r219 = r219;
            r124 = 13;
            r110 = 11;
            r134 = r139;
            r125 = r125;
            goto L6
        L33:
            r139 = r134;
            r138 = r217;
            r311 = false;
            goto L34
        L11:
            r128 = (GeneralInteractionAskNotifyDownlinkBody) r101.decodeNullableSerializableElement(r100, r124, GeneralInteractionAskNotifyDownlinkBody.a.f349633a, r128);
            r135 = r135 | 8192;
        L16:
            r219 = r219;
        L18:
            r218 = r218;
        L29:
            SendMessageListAckDownlinkBody r140 = r125;
        L31:
            r218 = r218;
            r125 = r140;
            r219 = r219;
            r124 = 13;
            r110 = 11;
            goto L6
        L12:
            r102 = (c) r101.decodeNullableSerializableElement(r100, 12, c.a.f349760a, r102);
            r135 = r135 | 4096;
            goto L16
        L13:
            r129 = (BotReplyLoadingUpdateNotify) r101.decodeNullableSerializableElement(r100, r110, BotReplyLoadingUpdateNotify.a.f349594a, r129);
            r135 = r135 | 2048;
            goto L16
        L14:
            r132 = (CommonCmdNotify) r101.decodeNullableSerializableElement(r100, 10, CommonCmdNotify.a.f349609a, r132);
            r135 = r135 | 1024;
            goto L16
        L15:
            r219 = (BatchGetConversationParticipantsDownlinkBody) r101.decodeNullableSerializableElement(r100, 9, BatchGetConversationParticipantsDownlinkBody.a.f349584a, r219);
            r135 = r135 | 512;
            goto L16
        L17:
            r219 = r219;
            r218 = (GetConversationParticipantDownlinkBody) r101.decodeNullableSerializableElement(r100, 8, GetConversationParticipantDownlinkBody.a.f349639a, r218);
            r135 = r135 | 256;
            goto L18
        L19:
            r127 = (BatchGetConversationInfoDownlinkBody) r101.decodeNullableSerializableElement(r100, 7, BatchGetConversationInfoDownlinkBody.a.f349580a, r127);
            r135 = r135 | 128;
            goto L29
        L20:
            r130 = (GetConversationInfoDownlinkBody) r101.decodeNullableSerializableElement(r100, 6, GetConversationInfoDownlinkBody.a.f349635a, r130);
            r135 = r135 | 64;
            goto L29
        L22:
            r218 = r218;
            r219 = r219;
            r131 = (PullSingleChainDownlinkBody) r101.decodeNullableSerializableElement(r100, 5, PullSingleChainDownlinkBody.a.f349696a, r131);
            r135 = r135 | 32;
            goto L29
        L24:
            r218 = r218;
            r219 = r219;
            r126 = (ChunkUpdateDownlinkBody) r101.decodeNullableSerializableElement(r100, 4, ChunkUpdateDownlinkBody.a.f349605a, r126);
            r135 = r135 | 16;
            goto L29
        L26:
            r218 = r218;
            r219 = r219;
            r135 = r135 | 8;
            r133 = (FetchChunkMessageDownlinkBody) r101.decodeNullableSerializableElement(r100, 3, FetchChunkMessageDownlinkBody.a.f349629a, r133);
            goto L29
        L28:
            r218 = r218;
            r219 = r219;
            r125 = (SendMessageListAckDownlinkBody) r101.decodeNullableSerializableElement(r100, 2, SendMessageListAckDownlinkBody.a.f349712a, r125);
            r135 = r135 | 4;
            goto L29
        L30:
            r218 = r218;
            r219 = r219;
            r140 = r125;
            r135 = r135 | 2;
            r217 = (SendMessageAckDownlinkBody) r101.decodeNullableSerializableElement(r100, 1, SendMessageAckDownlinkBody.a.f349710a, r217);
            goto L31
        L35:
            SendMessageListAckDownlinkBody r141 = r125;
            NewMessageNotify r142 = r134;
            r212 = r127;
            r211 = r128;
            r215 = r129;
            r216 = r218;
            r117 = r130;
            r214 = r132;
            r121 = r133;
            r118 = r141;
            r119 = r217;
            r213 = r219;
            r210 = r102;
            r122 = r126;
            r120 = r135;
            r116 = r131;
            r123 = r142;
            goto L36
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            DownlinkBody r102 = (DownlinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349626b;
            muc.d r104 = r100.beginStructure(r103);
            DownlinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<DownlinkBody> serializer() {
            return a.f349625a;
        }
    }

    public DownlinkBody() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ DownlinkBody copy$default(DownlinkBody r110, NewMessageNotify r111, SendMessageAckDownlinkBody r112, SendMessageListAckDownlinkBody r113, FetchChunkMessageDownlinkBody r114, ChunkUpdateDownlinkBody r210, PullSingleChainDownlinkBody r211, GetConversationInfoDownlinkBody r212, BatchGetConversationInfoDownlinkBody r213, GetConversationParticipantDownlinkBody r214, BatchGetConversationParticipantsDownlinkBody r215, CommonCmdNotify r216, BotReplyLoadingUpdateNotify r217, c r218, GeneralInteractionAskNotifyDownlinkBody r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        NewMessageNotify r100 = r110.newMessageNotify;
    L7:
        if ((r310 & 2) == 0) goto L9;
        SendMessageAckDownlinkBody r101 = r110.sendMessageAckDownlinkBody;
    L11:
        if ((r310 & 4) == 0) goto L13;
        SendMessageListAckDownlinkBody r102 = r110.sendMessageListAckDownlinkBody;
    L15:
        if ((r310 & 8) == 0) goto L17;
        FetchChunkMessageDownlinkBody r103 = r110.fetchChunkMessageDownlinkBody;
    L19:
        if ((r310 & 16) == 0) goto L21;
        ChunkUpdateDownlinkBody r104 = r110.chunkUpdateDownlinkBody;
    L23:
        if ((r310 & 32) == 0) goto L25;
        PullSingleChainDownlinkBody r105 = r110.pullSingeChainDownlinkBody;
    L27:
        if ((r310 & 64) == 0) goto L29;
        GetConversationInfoDownlinkBody r106 = r110.getConvInfoDownlinkBody;
    L31:
        if ((r310 & 128) == 0) goto L33;
        BatchGetConversationInfoDownlinkBody r107 = r110.batchGetConvInfoDownlinkBody;
    L35:
        if ((r310 & 256) == 0) goto L37;
        GetConversationParticipantDownlinkBody r115 = r110.getParticipantDownlinkBody;
    L39:
        if ((r310 & 512) == 0) goto L41;
        BatchGetConversationParticipantsDownlinkBody r116 = r110.batchGetConversationParticipantsDownlinkBody;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        CommonCmdNotify r117 = r110.commonCmdNotify;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        BotReplyLoadingUpdateNotify r118 = r110.botReplyLoadingUpdateNotify;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        c r119 = r110.replyEndDownlinkBody;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        GeneralInteractionAskNotifyDownlinkBody r108 = r110.generalInteractionAskNotify;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("batch_get_conv_info_downlink_body")
    public static /* synthetic */ void getBatchGetConvInfoDownlinkBody$annotations() {
    }

    @SerialName("batch_get_conversation_participants_downlink_body")
    public static /* synthetic */ void getBatchGetConversationParticipantsDownlinkBody$annotations() {
    }

    @SerialName("bot_reply_loading_update_notify")
    public static /* synthetic */ void getBotReplyLoadingUpdateNotify$annotations() {
    }

    @SerialName("chunk_update_downlink_body")
    public static /* synthetic */ void getChunkUpdateDownlinkBody$annotations() {
    }

    @SerialName("common_cmd_notify")
    public static /* synthetic */ void getCommonCmdNotify$annotations() {
    }

    @SerialName("fetch_chunk_message_downlink_body")
    public static /* synthetic */ void getFetchChunkMessageDownlinkBody$annotations() {
    }

    @SerialName("general_interaction_ask_notify")
    public static /* synthetic */ void getGeneralInteractionAskNotify$annotations() {
    }

    @SerialName("get_conv_info_downlink_body")
    public static /* synthetic */ void getGetConvInfoDownlinkBody$annotations() {
    }

    @SerialName("get_participant_downlink_body")
    public static /* synthetic */ void getGetParticipantDownlinkBody$annotations() {
    }

    @SerialName("new_message_notify")
    public static /* synthetic */ void getNewMessageNotify$annotations() {
    }

    @SerialName("pull_singe_chain_downlink_body")
    public static /* synthetic */ void getPullSingeChainDownlinkBody$annotations() {
    }

    @SerialName("reply_end_downlink_body")
    public static /* synthetic */ void getReplyEndDownlinkBody$annotations() {
    }

    @SerialName("send_message_ack_downlink_body")
    public static /* synthetic */ void getSendMessageAckDownlinkBody$annotations() {
    }

    @SerialName("send_message_list_ack_downlink_body")
    public static /* synthetic */ void getSendMessageListAckDownlinkBody$annotations() {
    }

    public final NewMessageNotify component1() {
        return this.newMessageNotify;
    }

    public final BatchGetConversationParticipantsDownlinkBody component10() {
        return this.batchGetConversationParticipantsDownlinkBody;
    }

    public final CommonCmdNotify component11() {
        return this.commonCmdNotify;
    }

    public final BotReplyLoadingUpdateNotify component12() {
        return this.botReplyLoadingUpdateNotify;
    }

    public final c component13() {
        return this.replyEndDownlinkBody;
    }

    public final GeneralInteractionAskNotifyDownlinkBody component14() {
        return this.generalInteractionAskNotify;
    }

    public final SendMessageAckDownlinkBody component2() {
        return this.sendMessageAckDownlinkBody;
    }

    public final SendMessageListAckDownlinkBody component3() {
        return this.sendMessageListAckDownlinkBody;
    }

    public final FetchChunkMessageDownlinkBody component4() {
        return this.fetchChunkMessageDownlinkBody;
    }

    public final ChunkUpdateDownlinkBody component5() {
        return this.chunkUpdateDownlinkBody;
    }

    public final PullSingleChainDownlinkBody component6() {
        return this.pullSingeChainDownlinkBody;
    }

    public final GetConversationInfoDownlinkBody component7() {
        return this.getConvInfoDownlinkBody;
    }

    public final BatchGetConversationInfoDownlinkBody component8() {
        return this.batchGetConvInfoDownlinkBody;
    }

    public final GetConversationParticipantDownlinkBody component9() {
        return this.getParticipantDownlinkBody;
    }

    public final DownlinkBody copy(NewMessageNotify r110, SendMessageAckDownlinkBody r111, SendMessageListAckDownlinkBody r112, FetchChunkMessageDownlinkBody r210, ChunkUpdateDownlinkBody r211, PullSingleChainDownlinkBody r212, GetConversationInfoDownlinkBody r213, BatchGetConversationInfoDownlinkBody r214, GetConversationParticipantDownlinkBody r215, BatchGetConversationParticipantsDownlinkBody r216, CommonCmdNotify r217, BotReplyLoadingUpdateNotify r218, c r219, GeneralInteractionAskNotifyDownlinkBody r310) {
        return new DownlinkBody(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DownlinkBody) == true) goto L8;
        return false;
    L8:
        DownlinkBody r101 = (DownlinkBody) r100;
        if (Intrinsics.areEqual(this.newMessageNotify, r101.newMessageNotify) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sendMessageAckDownlinkBody, r101.sendMessageAckDownlinkBody) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sendMessageListAckDownlinkBody, r101.sendMessageListAckDownlinkBody) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fetchChunkMessageDownlinkBody, r101.fetchChunkMessageDownlinkBody) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.chunkUpdateDownlinkBody, r101.chunkUpdateDownlinkBody) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pullSingeChainDownlinkBody, r101.pullSingeChainDownlinkBody) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.getConvInfoDownlinkBody, r101.getConvInfoDownlinkBody) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.batchGetConvInfoDownlinkBody, r101.batchGetConvInfoDownlinkBody) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.getParticipantDownlinkBody, r101.getParticipantDownlinkBody) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.batchGetConversationParticipantsDownlinkBody, r101.batchGetConversationParticipantsDownlinkBody) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.commonCmdNotify, r101.commonCmdNotify) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.botReplyLoadingUpdateNotify, r101.botReplyLoadingUpdateNotify) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.replyEndDownlinkBody, r101.replyEndDownlinkBody) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.generalInteractionAskNotify, r101.generalInteractionAskNotify) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        NewMessageNotify r100 = this.newMessageNotify;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        SendMessageAckDownlinkBody r104 = this.sendMessageAckDownlinkBody;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SendMessageListAckDownlinkBody r107 = this.sendMessageListAckDownlinkBody;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FetchChunkMessageDownlinkBody r110 = this.fetchChunkMessageDownlinkBody;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ChunkUpdateDownlinkBody r113 = this.chunkUpdateDownlinkBody;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PullSingleChainDownlinkBody r116 = this.pullSingeChainDownlinkBody;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        GetConversationInfoDownlinkBody r119 = this.getConvInfoDownlinkBody;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        BatchGetConversationInfoDownlinkBody r122 = this.batchGetConvInfoDownlinkBody;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        GetConversationParticipantDownlinkBody r125 = this.getParticipantDownlinkBody;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        BatchGetConversationParticipantsDownlinkBody r128 = this.batchGetConversationParticipantsDownlinkBody;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        CommonCmdNotify r131 = this.commonCmdNotify;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        BotReplyLoadingUpdateNotify r134 = this.botReplyLoadingUpdateNotify;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        c r137 = this.replyEndDownlinkBody;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        GeneralInteractionAskNotifyDownlinkBody r140 = this.generalInteractionAskNotify;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "DownlinkBody(newMessageNotify=" + this.newMessageNotify + ", sendMessageAckDownlinkBody=" + this.sendMessageAckDownlinkBody + ", sendMessageListAckDownlinkBody=" + this.sendMessageListAckDownlinkBody + ", fetchChunkMessageDownlinkBody=" + this.fetchChunkMessageDownlinkBody + ", chunkUpdateDownlinkBody=" + this.chunkUpdateDownlinkBody + ", pullSingeChainDownlinkBody=" + this.pullSingeChainDownlinkBody + ", getConvInfoDownlinkBody=" + this.getConvInfoDownlinkBody + ", batchGetConvInfoDownlinkBody=" + this.batchGetConvInfoDownlinkBody + ", getParticipantDownlinkBody=" + this.getParticipantDownlinkBody + ", batchGetConversationParticipantsDownlinkBody=" + this.batchGetConversationParticipantsDownlinkBody + ", commonCmdNotify=" + this.commonCmdNotify + ", botReplyLoadingUpdateNotify=" + this.botReplyLoadingUpdateNotify + ", replyEndDownlinkBody=" + this.replyEndDownlinkBody + ", generalInteractionAskNotify=" + this.generalInteractionAskNotify + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(DownlinkBody r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, NewMessageNotify.a.f349688a, r100.newMessageNotify);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, SendMessageAckDownlinkBody.a.f349710a, r100.sendMessageAckDownlinkBody);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, SendMessageListAckDownlinkBody.a.f349712a, r100.sendMessageListAckDownlinkBody);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, FetchChunkMessageDownlinkBody.a.f349629a, r100.fetchChunkMessageDownlinkBody);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, ChunkUpdateDownlinkBody.a.f349605a, r100.chunkUpdateDownlinkBody);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, PullSingleChainDownlinkBody.a.f349696a, r100.pullSingeChainDownlinkBody);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, GetConversationInfoDownlinkBody.a.f349635a, r100.getConvInfoDownlinkBody);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, BatchGetConversationInfoDownlinkBody.a.f349580a, r100.batchGetConvInfoDownlinkBody);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, GetConversationParticipantDownlinkBody.a.f349639a, r100.getParticipantDownlinkBody);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, BatchGetConversationParticipantsDownlinkBody.a.f349584a, r100.batchGetConversationParticipantsDownlinkBody);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, CommonCmdNotify.a.f349609a, r100.commonCmdNotify);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, BotReplyLoadingUpdateNotify.a.f349594a, r100.botReplyLoadingUpdateNotify);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, c.a.f349760a, r100.replyEndDownlinkBody);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        r103 = true;
    L125:
        if (r103 == false) goto L128;
        r101.encodeNullableSerializableElement(r102, 13, GeneralInteractionAskNotifyDownlinkBody.a.f349633a, r100.generalInteractionAskNotify);
        return;
    L128:
        return;
    L123:
        if (r100.generalInteractionAskNotify == null) goto L125;
    L114:
        if (r100.replyEndDownlinkBody != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.botReplyLoadingUpdateNotify != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.commonCmdNotify != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.batchGetConversationParticipantsDownlinkBody != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.getParticipantDownlinkBody != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.batchGetConvInfoDownlinkBody != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.getConvInfoDownlinkBody != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.pullSingeChainDownlinkBody != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.chunkUpdateDownlinkBody != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.fetchChunkMessageDownlinkBody != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.sendMessageListAckDownlinkBody != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.sendMessageAckDownlinkBody != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.newMessageNotify != null) goto L4;
        r104 = false;
        goto L9
    }

    public DownlinkBody(NewMessageNotify r100, SendMessageAckDownlinkBody r101, SendMessageListAckDownlinkBody r102, FetchChunkMessageDownlinkBody r103, ChunkUpdateDownlinkBody r104, PullSingleChainDownlinkBody r105, GetConversationInfoDownlinkBody r106, BatchGetConversationInfoDownlinkBody r107, GetConversationParticipantDownlinkBody r108, BatchGetConversationParticipantsDownlinkBody r110, CommonCmdNotify r111, BotReplyLoadingUpdateNotify r112, c r113, GeneralInteractionAskNotifyDownlinkBody r114) {
        this.newMessageNotify = r100;
        this.sendMessageAckDownlinkBody = r101;
        this.sendMessageListAckDownlinkBody = r102;
        this.fetchChunkMessageDownlinkBody = r103;
        this.chunkUpdateDownlinkBody = r104;
        this.pullSingeChainDownlinkBody = r105;
        this.getConvInfoDownlinkBody = r106;
        this.batchGetConvInfoDownlinkBody = r107;
        this.getParticipantDownlinkBody = r108;
        this.batchGetConversationParticipantsDownlinkBody = r110;
        this.commonCmdNotify = r111;
        this.botReplyLoadingUpdateNotify = r112;
        this.replyEndDownlinkBody = r113;
        this.generalInteractionAskNotify = r114;
    }

    public DownlinkBody(int r100, NewMessageNotify r101, SendMessageAckDownlinkBody r102, SendMessageListAckDownlinkBody r103, FetchChunkMessageDownlinkBody r110, ChunkUpdateDownlinkBody r111, PullSingleChainDownlinkBody r112, GetConversationInfoDownlinkBody r113, BatchGetConversationInfoDownlinkBody r114, GetConversationParticipantDownlinkBody r115, BatchGetConversationParticipantsDownlinkBody r116, CommonCmdNotify r117, BotReplyLoadingUpdateNotify r118, c r119, GeneralInteractionAskNotifyDownlinkBody r210, q2 r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349626b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.newMessageNotify = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.sendMessageAckDownlinkBody = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.sendMessageListAckDownlinkBody = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.fetchChunkMessageDownlinkBody = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.chunkUpdateDownlinkBody = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.pullSingeChainDownlinkBody = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.getConvInfoDownlinkBody = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.batchGetConvInfoDownlinkBody = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.getParticipantDownlinkBody = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.batchGetConversationParticipantsDownlinkBody = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.commonCmdNotify = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.botReplyLoadingUpdateNotify = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.replyEndDownlinkBody = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.generalInteractionAskNotify = null;
        return;
    L59:
        this.generalInteractionAskNotify = r210;
        return;
    L55:
        this.replyEndDownlinkBody = r119;
        goto L57
    L51:
        this.botReplyLoadingUpdateNotify = r118;
        goto L53
    L47:
        this.commonCmdNotify = r117;
        goto L49
    L43:
        this.batchGetConversationParticipantsDownlinkBody = r116;
        goto L45
    L39:
        this.getParticipantDownlinkBody = r115;
        goto L41
    L35:
        this.batchGetConvInfoDownlinkBody = r114;
        goto L37
    L31:
        this.getConvInfoDownlinkBody = r113;
        goto L33
    L27:
        this.pullSingeChainDownlinkBody = r112;
        goto L29
    L23:
        this.chunkUpdateDownlinkBody = r111;
        goto L25
    L19:
        this.fetchChunkMessageDownlinkBody = r110;
        goto L21
    L15:
        this.sendMessageListAckDownlinkBody = r103;
        goto L17
    L11:
        this.sendMessageAckDownlinkBody = r102;
        goto L13
    L7:
        this.newMessageNotify = r101;
        goto L9
    }

    public /* synthetic */ DownlinkBody(NewMessageNotify r110, SendMessageAckDownlinkBody r111, SendMessageListAckDownlinkBody r112, FetchChunkMessageDownlinkBody r113, ChunkUpdateDownlinkBody r210, PullSingleChainDownlinkBody r211, GetConversationInfoDownlinkBody r212, BatchGetConversationInfoDownlinkBody r213, GetConversationParticipantDownlinkBody r214, BatchGetConversationParticipantsDownlinkBody r215, CommonCmdNotify r216, BotReplyLoadingUpdateNotify r217, c r218, GeneralInteractionAskNotifyDownlinkBody r219, int r310, DefaultConstructorMarker r311) {
        GeneralInteractionAskNotifyDownlinkBody r100 = null;
        if ((r310 & 1) == 0) goto L5;
        NewMessageNotify r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        SendMessageAckDownlinkBody r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        SendMessageListAckDownlinkBody r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        FetchChunkMessageDownlinkBody r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        ChunkUpdateDownlinkBody r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        PullSingleChainDownlinkBody r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        GetConversationInfoDownlinkBody r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        BatchGetConversationInfoDownlinkBody r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        GetConversationParticipantDownlinkBody r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        BatchGetConversationParticipantsDownlinkBody r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        CommonCmdNotify r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        BotReplyLoadingUpdateNotify r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        c r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
}
