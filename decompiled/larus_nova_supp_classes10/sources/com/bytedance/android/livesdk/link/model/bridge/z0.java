package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.livesdk.link.model.c6;
import com.bytedance.android.livesdk.message.model.c8;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u0000 Ë\u00012\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002Ì\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0018\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u001c\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010$\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u001c\u0010*\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\n\"\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\rR\u001c\u0010-\u001a\u00020\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00103\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010#R\u0014\u00105\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\nR\u0014\u00107\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\nR\u0016\u00109\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\rR\u0016\u0010;\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\rR\"\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020=\u0018\u00010<8&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010D\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\rR\u0016\u0010F\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\rR\u0016\u0010H\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\rR\u0016\u0010J\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\rR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00190K8&X¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001c\u0010Q\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010K8&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010MR\u0016\u0010U\u001a\u0004\u0018\u00010R8&X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0016\u0010]\u001a\u0004\u0018\u00010Z8&X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u001c\u0010a\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^8&X¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010MR\u0014\u0010c\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010.R\u0016\u0010g\u001a\u0004\u0018\u00010d8&X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0016\u0010k\u001a\u0004\u0018\u00010h8&X¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0016\u0010o\u001a\u0004\u0018\u00010l8&X¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0018\u0010t\u001a\u00060pj\u0002`q8&X¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0016\u0010x\u001a\u0004\u0018\u00010u8&X¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001c\u0010{\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\by\u0010\u001b\"\u0004\bz\u0010#R\u0016\u0010\u007f\u001a\u0004\u0018\u00010|8&X¦\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R!\u0010\u0084\u0001\u001a\f\u0018\u00010\u0080\u0001j\u0005\u0018\u0001`\u0081\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001a\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0016\u0010\u008e\u0001\u001a\u00020\b8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010\nR\"\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b\u008f\u0001\u0010\r\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\"\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b\u0093\u0001\u0010\r\"\u0006\b\u0094\u0001\u0010\u0091\u0001R\"\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b\u0096\u0001\u0010\r\"\u0006\b\u0097\u0001\u0010\u0091\u0001R\u001a\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\"\u0010£\u0001\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b¡\u0001\u0010\r\"\u0006\b¢\u0001\u0010\u0091\u0001R\"\u0010¦\u0001\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b¤\u0001\u0010\r\"\u0006\b¥\u0001\u0010\u0091\u0001R\u0016\u0010¨\u0001\u001a\u00020\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010\rR\u0016\u0010ª\u0001\u001a\u00020\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010\rR$\u0010°\u0001\u001a\u0005\u0018\u00010«\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u0018\u0010²\u0001\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010\rR$\u0010¸\u0001\u001a\u0005\u0018\u00010³\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R$\u0010¾\u0001\u001a\u0005\u0018\u00010¹\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001f\u0010Á\u0001\u001a\u00020\u00198&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¿\u0001\u0010\u001b\"\u0005\bÀ\u0001\u0010#R\"\u0010Ç\u0001\u001a\u00030Â\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R\"\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\u000f\u001a\u0005\bÈ\u0001\u0010\r\"\u0006\bÉ\u0001\u0010\u0091\u0001¨\u0006Í\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "Lvh7/c;", "", "", "uid", "", "isToUser", "isFromUser", "", "getMessageId2", "()J", "messageId2", "getGetFromUserId", "()Ljava/lang/String;", "getFromUserId", "getToUserId", "toUserId", "getFromUserIdStr", "fromUserIdStr", "getAckMessage", "ackMessage", "getSecFromUserId", "getSecFromUserId$annotations", "()V", "secFromUserId", "", "getReplyType", "()I", "replyType", "getControlType", "controlType", "getValidScene", "validScene", "getLayout", "setLayout", "(I)V", "layout", "getLinkType", "linkType", "getScene", "setScene", "(J)V", "scene", "getSceneLayoutInfo", "sceneLayoutInfo", "isSupportCamera", "()Z", "setSupportCamera", "(Z)V", "getUiLayout", "setUiLayout", "uiLayout", "getPaidCount", "paidCount", "getLinkDuration", "linkDuration", "getOpenSource", "openSource", "getFunctionType2", "functionType2", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "()Ljava/util/Map;", "linkerContentMap", "getLiveCoreExtInfo", "liveCoreExtInfo", "getAnchorLinkMicIdStr", "anchorLinkMicIdStr", "getReplyPrompts", "replyPrompts", "getPrompts", "prompts", "getBizTag", "bizTag", "", "getPlayModes", "()Ljava/util/List;", "playModes", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkedListUsers", "linkedListUsers", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "multiLiveCoreInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "getMessageBoardInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "messageBoardInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "linkerBaseInfo", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "getLockedPositions", "lockedPositions", "getSwitchToSilence", "switchToSilence", "Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "getActionSource", "()Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "actionSource", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getGuestLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "guestLinkMicInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "getGameInviteInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "gameInviteInfo", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getBaseMessage2", "()Lcom/bytedance/android/live/base/model/message/m0;", "baseMessage2", "Lcom/bytedance/android/livesdk/message/linker/b;", "getBackupInfo", "()Lcom/bytedance/android/livesdk/message/linker/b;", "backupInfo", "getInitSource", "setInitSource", "initSource", "Lcom/bytedance/android/livesdk/message/model/c8;", "getInvitorInfo", "()Lcom/bytedance/android/livesdk/message/model/c8;", "invitorInfo", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getInviteMsg", "()Lcom/bytedance/android/live/base/model/message/a5;", "inviteMsg", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "joinTeamFightInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "getBanAnchorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "banAnchorInfo", "getVersion", "version", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "(Ljava/lang/String;)V", "rivalLinkmicIdStr", "getLinkerSessionId", "setLinkerSessionId", "linkerSessionId", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "remoteLinkerSessionId", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "linkGameInfo", "Lpy/k;", "getInviteImage", "()Lpy/k;", "inviteImage", "getInvitePrompt", "setInvitePrompt", "invitePrompt", "getInviteSubtitle", "setInviteSubtitle", "inviteSubtitle", "get_guestId", "_guestId", "get_fromUserId", "_fromUserId", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "getJoinChannelData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "setJoinChannelData", "(Lcom/bytedance/android/live/liveinteract/plantform/model/q0;)V", "joinChannelData", "getGameBarrageLinkerFinishReason", "gameBarrageLinkerFinishReason", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCDNInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "chorusCDNInfo", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/t;", "setChorusAccompanimentInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/t;)V", "chorusAccompanimentInfo", "getPushRtcType", "setPushRtcType", "pushRtcType", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "clientUIInfo", "getTrackingData", "setTrackingData", "trackingData", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface z0 extends vh7.c<z0> {
    public static final int BattleScoreUpdateFromType_AUDIENCE_P2P = 1;
    public static final int BattleScoreUpdateFromType_DEFAULT = 0;
    public static final a Companion = null;
    public static final int PushRtcType_PUSH = 1;
    public static final int PushRtcType_UNKNOW = 0;
    public static final int PushRtcType_UNPUSH = 2;
    public static final int TYPE_AGREE_ADMIN_FIRST_INVITE = 15;
    public static final int TYPE_ALL_LIST_CHANGED = 7;
    public static final int TYPE_ANCHOR_INTERACT_TURN_ON = 100;
    public static final int TYPE_APPLY = 109;
    public static final int TYPE_APPLY_CLEAN = 111;
    public static final int TYPE_APPLY_PERMIT = 110;
    public static final int TYPE_AUDIENCE_INVITED = 12;
    public static final int TYPE_AUDIENCE_REPLY = 13;
    public static final int TYPE_AUTO_JOIN = 14;
    public static final int TYPE_BATTLE_CUT_SHORT = 205;
    public static final int TYPE_BATTLE_DATA = 202;
    public static final int TYPE_BATTLE_INVITE = 203;
    public static final int TYPE_BATTLE_REJECT = 204;
    public static final int TYPE_CANCELED_BY_SERVER = 105;
    public static final int TYPE_FAN_TICKET_CHANGED = 8;
    public static final int TYPE_FINISH = 4;
    public static final int TYPE_INROOM_NOTIFY = 106;
    public static final int TYPE_INVITE = 101;
    public static final int TYPE_INVITE_CLEAN = 104;
    public static final int TYPE_INVITE_NOTIFY_JOIN = 103;
    public static final int TYPE_INVITE_REPLY = 102;
    public static final int TYPE_JOIN_GAME_BARRAGE_RTC = 18;
    public static final int TYPE_KICKED_OUT = 3;
    public static final int TYPE_LEAVE_GAME_BARRAGE_RTC = 19;
    public static final int TYPE_LINKED_LIST_CHANGED = 6;
    public static final int TYPE_PERMIT = 2;
    public static final int TYPE_SILENCE = 10;
    public static final int TYPE_SILENCE_PASSIVE = 16;
    public static final int TYPE_SWITCH_SCENE = 17;
    public static final int TYPE_TURN_ON = 1;
    public static final int TYPE_UNSILENCE = 11;
    public static final int TYPE_WAITING_LIST_CHANGED = 5;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    String getAckMessage();

    com.bytedance.android.live.liveinteract.plantform.model.f getActionSource();

    /* synthetic */ long getAnchorLinkMicId();

    String getAnchorLinkMicIdStr();

    com.bytedance.android.livesdk.message.linker.b getBackupInfo();

    IBanUser getBanAnchorInfo();

    com.bytedance.android.live.base.model.message.m0 getBaseMessage2();

    String getBizTag();

    /* synthetic */ long getChannelId();

    com.bytedance.android.livesdk.chatroom.model.t getChorusAccompanimentInfo();

    com.bytedance.android.livesdk.chatroom.model.v getChorusCDNInfo();

    ClientUIInfo getClientUIInfo();

    int getControlType();

    String getFromUserIdStr();

    String getFunctionType2();

    String getGameBarrageLinkerFinishReason();

    com.bytedance.android.live.liveinteract.plantform.model.e getGameInviteInfo();

    String getGetFromUserId();

    j1 getGuestLinkMicInfo();

    int getInitSource();

    py.k getInviteImage();

    a5 getInviteMsg();

    String getInvitePrompt();

    String getInviteSubtitle();

    c8 getInvitorInfo();

    com.bytedance.android.live.liveinteract.plantform.model.q0 getJoinChannelData();

    com.bytedance.android.live.liveinteract.plantform.model.j0 getJoinTeamFightInfo();

    /* synthetic */ int getKickOutSource();

    int getLayout();

    long getLinkDuration();

    c6 getLinkGameInfo();

    int getLinkType();

    List<k> getLinkedListUsers();

    com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo();

    Map<Long, g2> getLinkerContentMap();

    String getLinkerSessionId();

    String getLiveCoreExtInfo();

    List<LinkmicPositionItem> getLockedPositions();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.e0 getMcuContent();

    IMessageBoardInfo getMessageBoardInfo();

    long getMessageId2();

    u1 getMultiLiveCoreInfo();

    /* synthetic */ v1 getMultiRtcInfo();

    String getOpenSource();

    long getPaidCount();

    List<Integer> getPlayModes();

    String getPrompts();

    int getPushRtcType();

    String getRemoteLinkerSessionId();

    String getReplyPrompts();

    int getReplyType();

    String getRivalLinkmicIdStr();

    /* synthetic */ String getRtcExtInfo();

    long getScene();

    String getSceneLayoutInfo();

    String getSecFromUserId();

    boolean getSwitchToSilence();

    String getToUserId();

    String getTrackingData();

    /* synthetic */ long getType2();

    int getUiLayout();

    int getValidScene();

    long getVersion();

    String get_fromUserId();

    String get_guestId();

    boolean isFromUser(String r1);

    boolean isSupportCamera();

    boolean isToUser(String r1);

    void setChorusAccompanimentInfo(com.bytedance.android.livesdk.chatroom.model.t r1);

    void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r1);

    void setClientUIInfo(ClientUIInfo r1);

    void setInitSource(int r1);

    void setInvitePrompt(String r1);

    void setInviteSubtitle(String r1);

    void setJoinChannelData(com.bytedance.android.live.liveinteract.plantform.model.q0 r1);

    void setLayout(int r1);

    void setLinkerSessionId(String r1);

    void setPushRtcType(int r1);

    void setRemoteLinkerSessionId(String r1);

    void setRivalLinkmicIdStr(String r1);

    void setScene(long r1);

    void setSupportCamera(boolean r1);

    void setTrackingData(String r1);

    void setUiLayout(int r1);
}
