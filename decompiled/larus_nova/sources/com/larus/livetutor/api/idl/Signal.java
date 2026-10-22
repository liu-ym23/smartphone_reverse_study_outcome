package com.larus.livetutor.api.idl;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u008b\u0001\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BË\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010>J\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010>J\f\u0010§\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010,HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u000106HÆ\u0003JÔ\u0002\u0010¿\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u000106HÆ\u0001¢\u0006\u0003\u0010À\u0001J\u0017\u0010Á\u0001\u001a\u00030Â\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001HÖ\u0003J\u000b\u0010Å\u0001\u001a\u00030Æ\u0001HÖ\u0001J\u000b\u0010Ç\u0001\u001a\u00030È\u0001HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR$\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R$\u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R$\u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R$\u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R$\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R$\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R$\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R$\u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001¨\u0006É\u0001"}, d2 = {"Lcom/larus/livetutor/api/idl/Signal;", "Ljava/io/Serializable;", "type", "Lcom/larus/livetutor/api/idl/SignalType;", "seqId", "", "ackSeqId", "endCallMsg", "Lcom/larus/livetutor/api/idl/EndCallMsg;", "userInterruptMsg", "Lcom/larus/livetutor/api/idl/UserInterruptMsg;", "callStartedMsg", "Lcom/larus/livetutor/api/idl/CallStartedMsg;", "callStartFailMsg", "Lcom/larus/livetutor/api/idl/CallStartFailMsg;", "userAsrEndMsg", "Lcom/larus/livetutor/api/idl/UserAsrEndMsg;", "answerStartMsg", "Lcom/larus/livetutor/api/idl/AnswerStartMsg;", "answerEndMsg", "Lcom/larus/livetutor/api/idl/AnswerEndMsg;", "userAsrStartMsg", "Lcom/larus/livetutor/api/idl/UserAsrStartMsg;", "errMsg", "Lcom/larus/livetutor/api/idl/ErrorMsg;", "clearSubtitleMsg", "Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;", "uploadDataMsg", "Lcom/larus/livetutor/api/idl/UploadDataMsg;", "boardMessageAckMsg", "Lcom/larus/livetutor/api/idl/BoardMessageAckMsg;", "startControlMsg", "Lcom/larus/livetutor/api/idl/StartControlMsg;", "userAsrTimeoutSubmit", "Lcom/larus/livetutor/api/idl/UserAsrTimeoutSubimitMsg;", "userSpeakingMsg", "Lcom/larus/livetutor/api/idl/UserSpeakingMsg;", "liveTutorClientControlMsg", "Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;", "modifyTutorUserSettingMsg", "Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;", "fixedAudioMsg", "Lcom/larus/livetutor/api/idl/FixedAudioMsg;", "subtitleMsg", "Lcom/larus/livetutor/api/idl/SubtitleMsg;", "boardMessageMsg", "Lcom/larus/livetutor/api/idl/BoardMessageMsg;", "loadingStartMsg", "Lcom/larus/livetutor/api/idl/LoadingStartMsg;", "liveTutorStartMsg", "Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;", "waitUserAnswerMsg", "Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "liveTutorRoundEndMsg", "Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/SignalType;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/EndCallMsg;Lcom/larus/livetutor/api/idl/UserInterruptMsg;Lcom/larus/livetutor/api/idl/CallStartedMsg;Lcom/larus/livetutor/api/idl/CallStartFailMsg;Lcom/larus/livetutor/api/idl/UserAsrEndMsg;Lcom/larus/livetutor/api/idl/AnswerStartMsg;Lcom/larus/livetutor/api/idl/AnswerEndMsg;Lcom/larus/livetutor/api/idl/UserAsrStartMsg;Lcom/larus/livetutor/api/idl/ErrorMsg;Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;Lcom/larus/livetutor/api/idl/UploadDataMsg;Lcom/larus/livetutor/api/idl/BoardMessageAckMsg;Lcom/larus/livetutor/api/idl/StartControlMsg;Lcom/larus/livetutor/api/idl/UserAsrTimeoutSubimitMsg;Lcom/larus/livetutor/api/idl/UserSpeakingMsg;Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;Lcom/larus/livetutor/api/idl/FixedAudioMsg;Lcom/larus/livetutor/api/idl/SubtitleMsg;Lcom/larus/livetutor/api/idl/BoardMessageMsg;Lcom/larus/livetutor/api/idl/LoadingStartMsg;Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;)V", "getType", "()Lcom/larus/livetutor/api/idl/SignalType;", "setType", "(Lcom/larus/livetutor/api/idl/SignalType;)V", "getSeqId", "()Ljava/lang/Long;", "setSeqId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAckSeqId", "setAckSeqId", "getEndCallMsg", "()Lcom/larus/livetutor/api/idl/EndCallMsg;", "setEndCallMsg", "(Lcom/larus/livetutor/api/idl/EndCallMsg;)V", "getUserInterruptMsg", "()Lcom/larus/livetutor/api/idl/UserInterruptMsg;", "setUserInterruptMsg", "(Lcom/larus/livetutor/api/idl/UserInterruptMsg;)V", "getCallStartedMsg", "()Lcom/larus/livetutor/api/idl/CallStartedMsg;", "setCallStartedMsg", "(Lcom/larus/livetutor/api/idl/CallStartedMsg;)V", "getCallStartFailMsg", "()Lcom/larus/livetutor/api/idl/CallStartFailMsg;", "setCallStartFailMsg", "(Lcom/larus/livetutor/api/idl/CallStartFailMsg;)V", "getUserAsrEndMsg", "()Lcom/larus/livetutor/api/idl/UserAsrEndMsg;", "setUserAsrEndMsg", "(Lcom/larus/livetutor/api/idl/UserAsrEndMsg;)V", "getAnswerStartMsg", "()Lcom/larus/livetutor/api/idl/AnswerStartMsg;", "setAnswerStartMsg", "(Lcom/larus/livetutor/api/idl/AnswerStartMsg;)V", "getAnswerEndMsg", "()Lcom/larus/livetutor/api/idl/AnswerEndMsg;", "setAnswerEndMsg", "(Lcom/larus/livetutor/api/idl/AnswerEndMsg;)V", "getUserAsrStartMsg", "()Lcom/larus/livetutor/api/idl/UserAsrStartMsg;", "setUserAsrStartMsg", "(Lcom/larus/livetutor/api/idl/UserAsrStartMsg;)V", "getErrMsg", "()Lcom/larus/livetutor/api/idl/ErrorMsg;", "setErrMsg", "(Lcom/larus/livetutor/api/idl/ErrorMsg;)V", "getClearSubtitleMsg", "()Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;", "setClearSubtitleMsg", "(Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;)V", "getUploadDataMsg", "()Lcom/larus/livetutor/api/idl/UploadDataMsg;", "setUploadDataMsg", "(Lcom/larus/livetutor/api/idl/UploadDataMsg;)V", "getBoardMessageAckMsg", "()Lcom/larus/livetutor/api/idl/BoardMessageAckMsg;", "setBoardMessageAckMsg", "(Lcom/larus/livetutor/api/idl/BoardMessageAckMsg;)V", "getStartControlMsg", "()Lcom/larus/livetutor/api/idl/StartControlMsg;", "setStartControlMsg", "(Lcom/larus/livetutor/api/idl/StartControlMsg;)V", "getUserAsrTimeoutSubmit", "()Lcom/larus/livetutor/api/idl/UserAsrTimeoutSubimitMsg;", "setUserAsrTimeoutSubmit", "(Lcom/larus/livetutor/api/idl/UserAsrTimeoutSubimitMsg;)V", "getUserSpeakingMsg", "()Lcom/larus/livetutor/api/idl/UserSpeakingMsg;", "setUserSpeakingMsg", "(Lcom/larus/livetutor/api/idl/UserSpeakingMsg;)V", "getLiveTutorClientControlMsg", "()Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;", "setLiveTutorClientControlMsg", "(Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;)V", "getModifyTutorUserSettingMsg", "()Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;", "setModifyTutorUserSettingMsg", "(Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;)V", "getFixedAudioMsg", "()Lcom/larus/livetutor/api/idl/FixedAudioMsg;", "setFixedAudioMsg", "(Lcom/larus/livetutor/api/idl/FixedAudioMsg;)V", "getSubtitleMsg", "()Lcom/larus/livetutor/api/idl/SubtitleMsg;", "setSubtitleMsg", "(Lcom/larus/livetutor/api/idl/SubtitleMsg;)V", "getBoardMessageMsg", "()Lcom/larus/livetutor/api/idl/BoardMessageMsg;", "setBoardMessageMsg", "(Lcom/larus/livetutor/api/idl/BoardMessageMsg;)V", "getLoadingStartMsg", "()Lcom/larus/livetutor/api/idl/LoadingStartMsg;", "setLoadingStartMsg", "(Lcom/larus/livetutor/api/idl/LoadingStartMsg;)V", "getLiveTutorStartMsg", "()Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;", "setLiveTutorStartMsg", "(Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;)V", "getWaitUserAnswerMsg", "()Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "setWaitUserAnswerMsg", "(Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;)V", "getLiveTutorRoundEndMsg", "()Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;", "setLiveTutorRoundEndMsg", "(Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Lcom/larus/livetutor/api/idl/SignalType;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/EndCallMsg;Lcom/larus/livetutor/api/idl/UserInterruptMsg;Lcom/larus/livetutor/api/idl/CallStartedMsg;Lcom/larus/livetutor/api/idl/CallStartFailMsg;Lcom/larus/livetutor/api/idl/UserAsrEndMsg;Lcom/larus/livetutor/api/idl/AnswerStartMsg;Lcom/larus/livetutor/api/idl/AnswerEndMsg;Lcom/larus/livetutor/api/idl/UserAsrStartMsg;Lcom/larus/livetutor/api/idl/ErrorMsg;Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;Lcom/larus/livetutor/api/idl/UploadDataMsg;Lcom/larus/livetutor/api/idl/BoardMessageAckMsg;Lcom/larus/livetutor/api/idl/StartControlMsg;Lcom/larus/livetutor/api/idl/UserAsrTimeoutSubimitMsg;Lcom/larus/livetutor/api/idl/UserSpeakingMsg;Lcom/larus/livetutor/api/idl/LiveTutorClientControlMsg;Lcom/larus/livetutor/api/idl/ModifyTutorUserSettingMsg;Lcom/larus/livetutor/api/idl/FixedAudioMsg;Lcom/larus/livetutor/api/idl/SubtitleMsg;Lcom/larus/livetutor/api/idl/BoardMessageMsg;Lcom/larus/livetutor/api/idl/LoadingStartMsg;Lcom/larus/livetutor/api/idl/LiveTutorStartMsg;Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;Lcom/larus/livetutor/api/idl/LiveTutorRoundEndMsg;)Lcom/larus/livetutor/api/idl/Signal;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Signal implements Serializable {

    @SerializedName("ack_seq_id")
    private Long ackSeqId;

    @SerializedName("answer_end_msg")
    private AnswerEndMsg answerEndMsg;

    @SerializedName("answer_start_msg")
    private AnswerStartMsg answerStartMsg;

    @SerializedName("board_message_ack_msg")
    private BoardMessageAckMsg boardMessageAckMsg;

    @SerializedName("board_message_msg")
    private BoardMessageMsg boardMessageMsg;

    @SerializedName("call_start_fail_msg")
    private CallStartFailMsg callStartFailMsg;

    @SerializedName("call_started_msg")
    private CallStartedMsg callStartedMsg;

    @SerializedName("clear_subtitle_msg")
    private ClearSubtitleMsg clearSubtitleMsg;

    @SerializedName("end_call_msg")
    private EndCallMsg endCallMsg;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private ErrorMsg errMsg;

    @SerializedName("fixed_audio_msg")
    private FixedAudioMsg fixedAudioMsg;

    @SerializedName("live_tutor_client_control_msg")
    private LiveTutorClientControlMsg liveTutorClientControlMsg;

    @SerializedName("live_tutor_round_end_msg")
    private LiveTutorRoundEndMsg liveTutorRoundEndMsg;

    @SerializedName("live_tutor_start_msg")
    private LiveTutorStartMsg liveTutorStartMsg;

    @SerializedName("loading_start_msg")
    private LoadingStartMsg loadingStartMsg;

    @SerializedName("modify_tutor_user_setting_msg")
    private ModifyTutorUserSettingMsg modifyTutorUserSettingMsg;

    @SerializedName("seq_id")
    private Long seqId;

    @SerializedName("start_control_msg")
    private StartControlMsg startControlMsg;

    @SerializedName("subtitle_msg")
    private SubtitleMsg subtitleMsg;

    @SerializedName("type")
    private SignalType type;

    @SerializedName("upload_data_msg")
    private UploadDataMsg uploadDataMsg;

    @SerializedName("user_asr_end_msg")
    private UserAsrEndMsg userAsrEndMsg;

    @SerializedName("user_asr_start_msg")
    private UserAsrStartMsg userAsrStartMsg;

    @SerializedName("user_asr_timeout_submit")
    private UserAsrTimeoutSubimitMsg userAsrTimeoutSubmit;

    @SerializedName("user_interrupt_msg")
    private UserInterruptMsg userInterruptMsg;

    @SerializedName("user_speaking_msg")
    private UserSpeakingMsg userSpeakingMsg;

    @SerializedName("wait_user_answer_msg")
    private WaitUserAnswerMsg waitUserAnswerMsg;

    public Signal() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    public static /* synthetic */ Signal copy$default(Signal r110, SignalType r111, Long r112, Long r210, EndCallMsg r211, UserInterruptMsg r212, CallStartedMsg r213, CallStartFailMsg r214, UserAsrEndMsg r215, AnswerStartMsg r216, AnswerEndMsg r217, UserAsrStartMsg r218, ErrorMsg r219, ClearSubtitleMsg r310, UploadDataMsg r311, BoardMessageAckMsg r312, StartControlMsg r313, UserAsrTimeoutSubimitMsg r314, UserSpeakingMsg r315, LiveTutorClientControlMsg r316, ModifyTutorUserSettingMsg r317, FixedAudioMsg r318, SubtitleMsg r319, BoardMessageMsg r410, LoadingStartMsg r411, LiveTutorStartMsg r412, WaitUserAnswerMsg r413, LiveTutorRoundEndMsg r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        SignalType r100 = r110.type;
    L7:
        if ((r415 & 2) == 0) goto L9;
        Long r101 = r110.seqId;
    L11:
        if ((r415 & 4) == 0) goto L13;
        Long r102 = r110.ackSeqId;
    L15:
        if ((r415 & 8) == 0) goto L17;
        EndCallMsg r103 = r110.endCallMsg;
    L19:
        if ((r415 & 16) == 0) goto L21;
        UserInterruptMsg r104 = r110.userInterruptMsg;
    L23:
        if ((r415 & 32) == 0) goto L25;
        CallStartedMsg r105 = r110.callStartedMsg;
    L27:
        if ((r415 & 64) == 0) goto L29;
        CallStartFailMsg r106 = r110.callStartFailMsg;
    L31:
        if ((r415 & 128) == 0) goto L33;
        UserAsrEndMsg r107 = r110.userAsrEndMsg;
    L35:
        if ((r415 & 256) == 0) goto L37;
        AnswerStartMsg r113 = r110.answerStartMsg;
    L39:
        if ((r415 & 512) == 0) goto L41;
        AnswerEndMsg r114 = r110.answerEndMsg;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        UserAsrStartMsg r115 = r110.userAsrStartMsg;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        ErrorMsg r116 = r110.errMsg;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        ClearSubtitleMsg r117 = r110.clearSubtitleMsg;
    L55:
        if ((r415 & 8192) == 0) goto L57;
        UploadDataMsg r118 = r110.uploadDataMsg;
    L58:
        UploadDataMsg r320 = r118;
        if ((r415 & 16384) == 0) goto L61;
        BoardMessageAckMsg r119 = r110.boardMessageAckMsg;
    L62:
        BoardMessageAckMsg r321 = r119;
        if ((r415 & 32768) == 0) goto L65;
        StartControlMsg r120 = r110.startControlMsg;
    L66:
        StartControlMsg r322 = r120;
        if ((r415 & 65536) == 0) goto L69;
        UserAsrTimeoutSubimitMsg r121 = r110.userAsrTimeoutSubmit;
    L70:
        UserAsrTimeoutSubimitMsg r323 = r121;
        if ((r415 & 131072) == 0) goto L73;
        UserSpeakingMsg r122 = r110.userSpeakingMsg;
    L74:
        UserSpeakingMsg r324 = r122;
        if ((r415 & 262144) == 0) goto L77;
        LiveTutorClientControlMsg r123 = r110.liveTutorClientControlMsg;
    L78:
        LiveTutorClientControlMsg r325 = r123;
        if ((r415 & 524288) == 0) goto L81;
        ModifyTutorUserSettingMsg r124 = r110.modifyTutorUserSettingMsg;
    L82:
        ModifyTutorUserSettingMsg r326 = r124;
        if ((r415 & 1048576) == 0) goto L85;
        FixedAudioMsg r125 = r110.fixedAudioMsg;
    L86:
        FixedAudioMsg r327 = r125;
        if ((r415 & 2097152) == 0) goto L89;
        SubtitleMsg r126 = r110.subtitleMsg;
    L90:
        SubtitleMsg r328 = r126;
        if ((r415 & 4194304) == 0) goto L93;
        BoardMessageMsg r127 = r110.boardMessageMsg;
    L94:
        BoardMessageMsg r417 = r127;
        if ((r415 & 8388608) == 0) goto L97;
        LoadingStartMsg r128 = r110.loadingStartMsg;
    L98:
        LoadingStartMsg r418 = r128;
        if ((r415 & 16777216) == 0) goto L101;
        LiveTutorStartMsg r129 = r110.liveTutorStartMsg;
    L102:
        LiveTutorStartMsg r419 = r129;
        if ((r415 & 33554432) == 0) goto L105;
        WaitUserAnswerMsg r130 = r110.waitUserAnswerMsg;
    L107:
        if ((r415 & 67108864) == 0) goto L109;
        LiveTutorRoundEndMsg r108 = r110.liveTutorRoundEndMsg;
    L111:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r417, r418, r419, r130, r108);
    L109:
        r108 = r414;
        goto L111
    L105:
        r130 = r413;
        goto L107
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final SignalType component1() {
        return this.type;
    }

    public final AnswerEndMsg component10() {
        return this.answerEndMsg;
    }

    public final UserAsrStartMsg component11() {
        return this.userAsrStartMsg;
    }

    public final ErrorMsg component12() {
        return this.errMsg;
    }

    public final ClearSubtitleMsg component13() {
        return this.clearSubtitleMsg;
    }

    public final UploadDataMsg component14() {
        return this.uploadDataMsg;
    }

    public final BoardMessageAckMsg component15() {
        return this.boardMessageAckMsg;
    }

    public final StartControlMsg component16() {
        return this.startControlMsg;
    }

    public final UserAsrTimeoutSubimitMsg component17() {
        return this.userAsrTimeoutSubmit;
    }

    public final UserSpeakingMsg component18() {
        return this.userSpeakingMsg;
    }

    public final LiveTutorClientControlMsg component19() {
        return this.liveTutorClientControlMsg;
    }

    public final Long component2() {
        return this.seqId;
    }

    public final ModifyTutorUserSettingMsg component20() {
        return this.modifyTutorUserSettingMsg;
    }

    public final FixedAudioMsg component21() {
        return this.fixedAudioMsg;
    }

    public final SubtitleMsg component22() {
        return this.subtitleMsg;
    }

    public final BoardMessageMsg component23() {
        return this.boardMessageMsg;
    }

    public final LoadingStartMsg component24() {
        return this.loadingStartMsg;
    }

    public final LiveTutorStartMsg component25() {
        return this.liveTutorStartMsg;
    }

    public final WaitUserAnswerMsg component26() {
        return this.waitUserAnswerMsg;
    }

    public final LiveTutorRoundEndMsg component27() {
        return this.liveTutorRoundEndMsg;
    }

    public final Long component3() {
        return this.ackSeqId;
    }

    public final EndCallMsg component4() {
        return this.endCallMsg;
    }

    public final UserInterruptMsg component5() {
        return this.userInterruptMsg;
    }

    public final CallStartedMsg component6() {
        return this.callStartedMsg;
    }

    public final CallStartFailMsg component7() {
        return this.callStartFailMsg;
    }

    public final UserAsrEndMsg component8() {
        return this.userAsrEndMsg;
    }

    public final AnswerStartMsg component9() {
        return this.answerStartMsg;
    }

    public final Signal copy(SignalType r310, Long r311, Long r312, EndCallMsg r313, UserInterruptMsg r314, CallStartedMsg r315, CallStartFailMsg r316, UserAsrEndMsg r317, AnswerStartMsg r318, AnswerEndMsg r319, UserAsrStartMsg r410, ErrorMsg r411, ClearSubtitleMsg r412, UploadDataMsg r413, BoardMessageAckMsg r414, StartControlMsg r415, UserAsrTimeoutSubimitMsg r416, UserSpeakingMsg r417, LiveTutorClientControlMsg r418, ModifyTutorUserSettingMsg r419, FixedAudioMsg r510, SubtitleMsg r511, BoardMessageMsg r512, LoadingStartMsg r513, LiveTutorStartMsg r514, WaitUserAnswerMsg r515, LiveTutorRoundEndMsg r516) {
        return new Signal(r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Signal) == true) goto L8;
        return false;
    L8:
        Signal r101 = (Signal) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.seqId, r101.seqId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ackSeqId, r101.ackSeqId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endCallMsg, r101.endCallMsg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userInterruptMsg, r101.userInterruptMsg) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.callStartedMsg, r101.callStartedMsg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.callStartFailMsg, r101.callStartFailMsg) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userAsrEndMsg, r101.userAsrEndMsg) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.answerStartMsg, r101.answerStartMsg) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.answerEndMsg, r101.answerEndMsg) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.userAsrStartMsg, r101.userAsrStartMsg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.clearSubtitleMsg, r101.clearSubtitleMsg) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.uploadDataMsg, r101.uploadDataMsg) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.boardMessageAckMsg, r101.boardMessageAckMsg) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.startControlMsg, r101.startControlMsg) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.userAsrTimeoutSubmit, r101.userAsrTimeoutSubmit) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.userSpeakingMsg, r101.userSpeakingMsg) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.liveTutorClientControlMsg, r101.liveTutorClientControlMsg) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.modifyTutorUserSettingMsg, r101.modifyTutorUserSettingMsg) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.fixedAudioMsg, r101.fixedAudioMsg) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.subtitleMsg, r101.subtitleMsg) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.boardMessageMsg, r101.boardMessageMsg) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.loadingStartMsg, r101.loadingStartMsg) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.liveTutorStartMsg, r101.liveTutorStartMsg) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.waitUserAnswerMsg, r101.waitUserAnswerMsg) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.liveTutorRoundEndMsg, r101.liveTutorRoundEndMsg) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        SignalType r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.seqId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.ackSeqId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        EndCallMsg r110 = this.endCallMsg;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        UserInterruptMsg r113 = this.userInterruptMsg;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        CallStartedMsg r116 = this.callStartedMsg;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CallStartFailMsg r119 = this.callStartFailMsg;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        UserAsrEndMsg r122 = this.userAsrEndMsg;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        AnswerStartMsg r125 = this.answerStartMsg;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        AnswerEndMsg r128 = this.answerEndMsg;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        UserAsrStartMsg r131 = this.userAsrStartMsg;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        ErrorMsg r134 = this.errMsg;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        ClearSubtitleMsg r137 = this.clearSubtitleMsg;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        UploadDataMsg r140 = this.uploadDataMsg;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        BoardMessageAckMsg r143 = this.boardMessageAckMsg;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        StartControlMsg r146 = this.startControlMsg;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        UserAsrTimeoutSubimitMsg r149 = this.userAsrTimeoutSubmit;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        UserSpeakingMsg r152 = this.userSpeakingMsg;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        LiveTutorClientControlMsg r155 = this.liveTutorClientControlMsg;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        ModifyTutorUserSettingMsg r158 = this.modifyTutorUserSettingMsg;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        FixedAudioMsg r161 = this.fixedAudioMsg;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        SubtitleMsg r164 = this.subtitleMsg;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        BoardMessageMsg r167 = this.boardMessageMsg;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        LoadingStartMsg r170 = this.loadingStartMsg;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        LiveTutorStartMsg r173 = this.liveTutorStartMsg;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (r172 + r174) * 31;
        WaitUserAnswerMsg r176 = this.waitUserAnswerMsg;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        LiveTutorRoundEndMsg r179 = this.liveTutorRoundEndMsg;
        if (r179 == null) goto L111;
        r101 = r179.hashCode();
    L111:
        return r178 + r101;
    L105:
        r177 = r176.hashCode();
        goto L106
    L101:
        r174 = r173.hashCode();
        goto L102
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
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
        return "Signal(type=" + this.type + ", seqId=" + this.seqId + ", ackSeqId=" + this.ackSeqId + ", endCallMsg=" + this.endCallMsg + ", userInterruptMsg=" + this.userInterruptMsg + ", callStartedMsg=" + this.callStartedMsg + ", callStartFailMsg=" + this.callStartFailMsg + ", userAsrEndMsg=" + this.userAsrEndMsg + ", answerStartMsg=" + this.answerStartMsg + ", answerEndMsg=" + this.answerEndMsg + ", userAsrStartMsg=" + this.userAsrStartMsg + ", errMsg=" + this.errMsg + ", clearSubtitleMsg=" + this.clearSubtitleMsg + ", uploadDataMsg=" + this.uploadDataMsg + ", boardMessageAckMsg=" + this.boardMessageAckMsg + ", startControlMsg=" + this.startControlMsg + ", userAsrTimeoutSubmit=" + this.userAsrTimeoutSubmit + ", userSpeakingMsg=" + this.userSpeakingMsg + ", liveTutorClientControlMsg=" + this.liveTutorClientControlMsg + ", modifyTutorUserSettingMsg=" + this.modifyTutorUserSettingMsg + ", fixedAudioMsg=" + this.fixedAudioMsg + ", subtitleMsg=" + this.subtitleMsg + ", boardMessageMsg=" + this.boardMessageMsg + ", loadingStartMsg=" + this.loadingStartMsg + ", liveTutorStartMsg=" + this.liveTutorStartMsg + ", waitUserAnswerMsg=" + this.waitUserAnswerMsg + ", liveTutorRoundEndMsg=" + this.liveTutorRoundEndMsg + ')';
    }

    public final Long getAckSeqId() {
        return this.ackSeqId;
    }

    public final AnswerEndMsg getAnswerEndMsg() {
        return this.answerEndMsg;
    }

    public final AnswerStartMsg getAnswerStartMsg() {
        return this.answerStartMsg;
    }

    public final BoardMessageAckMsg getBoardMessageAckMsg() {
        return this.boardMessageAckMsg;
    }

    public final BoardMessageMsg getBoardMessageMsg() {
        return this.boardMessageMsg;
    }

    public final CallStartFailMsg getCallStartFailMsg() {
        return this.callStartFailMsg;
    }

    public final CallStartedMsg getCallStartedMsg() {
        return this.callStartedMsg;
    }

    public final ClearSubtitleMsg getClearSubtitleMsg() {
        return this.clearSubtitleMsg;
    }

    public final EndCallMsg getEndCallMsg() {
        return this.endCallMsg;
    }

    public final ErrorMsg getErrMsg() {
        return this.errMsg;
    }

    public final FixedAudioMsg getFixedAudioMsg() {
        return this.fixedAudioMsg;
    }

    public final LiveTutorClientControlMsg getLiveTutorClientControlMsg() {
        return this.liveTutorClientControlMsg;
    }

    public final LiveTutorRoundEndMsg getLiveTutorRoundEndMsg() {
        return this.liveTutorRoundEndMsg;
    }

    public final LiveTutorStartMsg getLiveTutorStartMsg() {
        return this.liveTutorStartMsg;
    }

    public final LoadingStartMsg getLoadingStartMsg() {
        return this.loadingStartMsg;
    }

    public final ModifyTutorUserSettingMsg getModifyTutorUserSettingMsg() {
        return this.modifyTutorUserSettingMsg;
    }

    public final Long getSeqId() {
        return this.seqId;
    }

    public final StartControlMsg getStartControlMsg() {
        return this.startControlMsg;
    }

    public final SubtitleMsg getSubtitleMsg() {
        return this.subtitleMsg;
    }

    public final SignalType getType() {
        return this.type;
    }

    public final UploadDataMsg getUploadDataMsg() {
        return this.uploadDataMsg;
    }

    public final UserAsrEndMsg getUserAsrEndMsg() {
        return this.userAsrEndMsg;
    }

    public final UserAsrStartMsg getUserAsrStartMsg() {
        return this.userAsrStartMsg;
    }

    public final UserAsrTimeoutSubimitMsg getUserAsrTimeoutSubmit() {
        return this.userAsrTimeoutSubmit;
    }

    public final UserInterruptMsg getUserInterruptMsg() {
        return this.userInterruptMsg;
    }

    public final UserSpeakingMsg getUserSpeakingMsg() {
        return this.userSpeakingMsg;
    }

    public final WaitUserAnswerMsg getWaitUserAnswerMsg() {
        return this.waitUserAnswerMsg;
    }

    public final void setAckSeqId(Long r100) {
        this.ackSeqId = r100;
    }

    public final void setAnswerEndMsg(AnswerEndMsg r100) {
        this.answerEndMsg = r100;
    }

    public final void setAnswerStartMsg(AnswerStartMsg r100) {
        this.answerStartMsg = r100;
    }

    public final void setBoardMessageAckMsg(BoardMessageAckMsg r100) {
        this.boardMessageAckMsg = r100;
    }

    public final void setBoardMessageMsg(BoardMessageMsg r100) {
        this.boardMessageMsg = r100;
    }

    public final void setCallStartFailMsg(CallStartFailMsg r100) {
        this.callStartFailMsg = r100;
    }

    public final void setCallStartedMsg(CallStartedMsg r100) {
        this.callStartedMsg = r100;
    }

    public final void setClearSubtitleMsg(ClearSubtitleMsg r100) {
        this.clearSubtitleMsg = r100;
    }

    public final void setEndCallMsg(EndCallMsg r100) {
        this.endCallMsg = r100;
    }

    public final void setErrMsg(ErrorMsg r100) {
        this.errMsg = r100;
    }

    public final void setFixedAudioMsg(FixedAudioMsg r100) {
        this.fixedAudioMsg = r100;
    }

    public final void setLiveTutorClientControlMsg(LiveTutorClientControlMsg r100) {
        this.liveTutorClientControlMsg = r100;
    }

    public final void setLiveTutorRoundEndMsg(LiveTutorRoundEndMsg r100) {
        this.liveTutorRoundEndMsg = r100;
    }

    public final void setLiveTutorStartMsg(LiveTutorStartMsg r100) {
        this.liveTutorStartMsg = r100;
    }

    public final void setLoadingStartMsg(LoadingStartMsg r100) {
        this.loadingStartMsg = r100;
    }

    public final void setModifyTutorUserSettingMsg(ModifyTutorUserSettingMsg r100) {
        this.modifyTutorUserSettingMsg = r100;
    }

    public final void setSeqId(Long r100) {
        this.seqId = r100;
    }

    public final void setStartControlMsg(StartControlMsg r100) {
        this.startControlMsg = r100;
    }

    public final void setSubtitleMsg(SubtitleMsg r100) {
        this.subtitleMsg = r100;
    }

    public final void setType(SignalType r100) {
        this.type = r100;
    }

    public final void setUploadDataMsg(UploadDataMsg r100) {
        this.uploadDataMsg = r100;
    }

    public final void setUserAsrEndMsg(UserAsrEndMsg r100) {
        this.userAsrEndMsg = r100;
    }

    public final void setUserAsrStartMsg(UserAsrStartMsg r100) {
        this.userAsrStartMsg = r100;
    }

    public final void setUserAsrTimeoutSubmit(UserAsrTimeoutSubimitMsg r100) {
        this.userAsrTimeoutSubmit = r100;
    }

    public final void setUserInterruptMsg(UserInterruptMsg r100) {
        this.userInterruptMsg = r100;
    }

    public final void setUserSpeakingMsg(UserSpeakingMsg r100) {
        this.userSpeakingMsg = r100;
    }

    public final void setWaitUserAnswerMsg(WaitUserAnswerMsg r100) {
        this.waitUserAnswerMsg = r100;
    }

    public Signal(SignalType r100, Long r101, Long r102, EndCallMsg r103, UserInterruptMsg r104, CallStartedMsg r105, CallStartFailMsg r106, UserAsrEndMsg r110, AnswerStartMsg r111, AnswerEndMsg r112, UserAsrStartMsg r113, ErrorMsg r114, ClearSubtitleMsg r115, UploadDataMsg r116, BoardMessageAckMsg r117, StartControlMsg r118, UserAsrTimeoutSubimitMsg r119, UserSpeakingMsg r210, LiveTutorClientControlMsg r211, ModifyTutorUserSettingMsg r212, FixedAudioMsg r213, SubtitleMsg r214, BoardMessageMsg r215, LoadingStartMsg r216, LiveTutorStartMsg r217, WaitUserAnswerMsg r218, LiveTutorRoundEndMsg r219) {
        this.type = r100;
        this.seqId = r101;
        this.ackSeqId = r102;
        this.endCallMsg = r103;
        this.userInterruptMsg = r104;
        this.callStartedMsg = r105;
        this.callStartFailMsg = r106;
        this.userAsrEndMsg = r110;
        this.answerStartMsg = r111;
        this.answerEndMsg = r112;
        this.userAsrStartMsg = r113;
        this.errMsg = r114;
        this.clearSubtitleMsg = r115;
        this.uploadDataMsg = r116;
        this.boardMessageAckMsg = r117;
        this.startControlMsg = r118;
        this.userAsrTimeoutSubmit = r119;
        this.userSpeakingMsg = r210;
        this.liveTutorClientControlMsg = r211;
        this.modifyTutorUserSettingMsg = r212;
        this.fixedAudioMsg = r213;
        this.subtitleMsg = r214;
        this.boardMessageMsg = r215;
        this.loadingStartMsg = r216;
        this.liveTutorStartMsg = r217;
        this.waitUserAnswerMsg = r218;
        this.liveTutorRoundEndMsg = r219;
    }

    public /* synthetic */ Signal(SignalType r210, Long r310, Long r311, EndCallMsg r312, UserInterruptMsg r313, CallStartedMsg r314, CallStartFailMsg r315, UserAsrEndMsg r316, AnswerStartMsg r317, AnswerEndMsg r318, UserAsrStartMsg r319, ErrorMsg r410, ClearSubtitleMsg r411, UploadDataMsg r412, BoardMessageAckMsg r413, StartControlMsg r414, UserAsrTimeoutSubimitMsg r415, UserSpeakingMsg r416, LiveTutorClientControlMsg r417, ModifyTutorUserSettingMsg r418, FixedAudioMsg r419, SubtitleMsg r510, BoardMessageMsg r511, LoadingStartMsg r512, LiveTutorStartMsg r513, WaitUserAnswerMsg r514, LiveTutorRoundEndMsg r515, int r516, DefaultConstructorMarker r517) {
        if ((r516 & 1) == 0) goto L5;
        SignalType r100 = null;
    L7:
        if ((r516 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r516 & 4) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r516 & 8) == 0) goto L17;
        EndCallMsg r103 = null;
    L19:
        if ((r516 & 16) == 0) goto L21;
        UserInterruptMsg r104 = null;
    L23:
        if ((r516 & 32) == 0) goto L25;
        CallStartedMsg r105 = null;
    L27:
        if ((r516 & 64) == 0) goto L29;
        CallStartFailMsg r106 = null;
    L31:
        if ((r516 & 128) == 0) goto L33;
        UserAsrEndMsg r107 = null;
    L35:
        if ((r516 & 256) == 0) goto L37;
        AnswerStartMsg r110 = null;
    L39:
        if ((r516 & 512) == 0) goto L41;
        AnswerEndMsg r111 = null;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        UserAsrStartMsg r112 = null;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        ErrorMsg r113 = null;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        ClearSubtitleMsg r114 = null;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        UploadDataMsg r115 = null;
    L59:
        if ((r516 & 16384) == 0) goto L61;
        BoardMessageAckMsg r108 = null;
    L63:
        if ((r516 & 32768) == 0) goto L65;
        StartControlMsg r116 = null;
    L67:
        if ((r516 & 65536) == 0) goto L69;
        UserAsrTimeoutSubimitMsg r117 = null;
    L71:
        if ((r516 & 131072) == 0) goto L73;
        UserSpeakingMsg r118 = null;
    L75:
        if ((r516 & 262144) == 0) goto L77;
        LiveTutorClientControlMsg r119 = null;
    L79:
        if ((r516 & 524288) == 0) goto L81;
        ModifyTutorUserSettingMsg r211 = null;
    L83:
        if ((r516 & 1048576) == 0) goto L85;
        FixedAudioMsg r212 = null;
    L87:
        if ((r516 & 2097152) == 0) goto L89;
        SubtitleMsg r213 = null;
    L91:
        if ((r516 & 4194304) == 0) goto L93;
        BoardMessageMsg r214 = null;
    L95:
        if ((r516 & 8388608) == 0) goto L97;
        LoadingStartMsg r215 = null;
    L99:
        if ((r516 & 16777216) == 0) goto L101;
        LiveTutorStartMsg r216 = null;
    L103:
        if ((r516 & 33554432) == 0) goto L105;
        WaitUserAnswerMsg r217 = null;
    L107:
        if ((r516 & 67108864) == 0) goto L109;
        LiveTutorRoundEndMsg r109 = null;
    L110:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r109);
        return;
    L109:
        r109 = r515;
        goto L110
    L105:
        r217 = r514;
        goto L107
    L101:
        r216 = r513;
        goto L103
    L97:
        r215 = r512;
        goto L99
    L93:
        r214 = r511;
        goto L95
    L89:
        r213 = r510;
        goto L91
    L85:
        r212 = r419;
        goto L87
    L81:
        r211 = r418;
        goto L83
    L77:
        r119 = r417;
        goto L79
    L73:
        r118 = r416;
        goto L75
    L69:
        r117 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L67
    L61:
        r108 = r413;
        goto L63
    L57:
        r115 = r412;
        goto L59
    L53:
        r114 = r411;
        goto L55
    L49:
        r113 = r410;
        goto L51
    L45:
        r112 = r319;
        goto L47
    L41:
        r111 = r318;
        goto L43
    L37:
        r110 = r317;
        goto L39
    L33:
        r107 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
