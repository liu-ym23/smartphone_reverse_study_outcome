package com.larus.im.internal.jni;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.database.dao.MessageDao;
import com.larus.im.internal.database.entity.MessageEntity;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\bL\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JY\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0096 JY\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0096 J)\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0096 J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0096 J\u0017\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096 J\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0096 J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J+\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J'\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u0013\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\nH\u0096 J\u0013\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020\nH\u0096 J%\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0096 J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0003H\u0096 J'\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003H\u0096 J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\nH\u0096 J\u001f\u00103\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u0011\u00104\u001a\u00020\u00032\u0006\u00102\u001a\u00020\nH\u0096 J\u001f\u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0096 J\u001f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0096 J\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010:\u001a\u00020\nH\u0096 J\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096 J'\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0096 J\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0096 J'\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0003H\u0096 J'\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u001f\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0096 J\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010F\u001a\u00020\fH\u0096 J+\u0010G\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0096 J\u001b\u0010J\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010K\u001a\u00020LH\u0096 J\u001b\u0010M\u001a\u0004\u0018\u00010\b2\u0006\u00102\u001a\u00020\n2\u0006\u0010K\u001a\u00020LH\u0096 J\u0011\u0010N\u001a\u00020\u00032\u0006\u00102\u001a\u00020\nH\u0096 J\u0011\u0010O\u001a\u00020\u00032\u0006\u00102\u001a\u00020\nH\u0096 J\u0011\u0010P\u001a\u00020\u00032\u0006\u00102\u001a\u00020\nH\u0096 J\u0011\u0010Q\u001a\u00020\u00032\u0006\u00102\u001a\u00020\nH\u0096 J\u0019\u0010R\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010S\u001a\u00020\nH\u0096 J\u0019\u0010T\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010U\u001a\u00020\nH\u0096 J\u0019\u0010V\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010W\u001a\u00020\fH\u0096 J\u0019\u0010X\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\fH\u0096 J\u0019\u0010Z\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010[\u001a\u00020LH\u0096 J\u0019\u0010\\\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010]\u001a\u00020\nH\u0096 J\u0019\u0010^\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0096 J\u0019\u0010_\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010F\u001a\u00020\fH\u0096 J\u0019\u0010`\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0096 J\u0019\u0010a\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u0003H\u0096 J\u0019\u0010c\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0096 J\u0019\u0010d\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010e\u001a\u00020\nH\u0096 J\u0019\u0010f\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010g\u001a\u00020\nH\u0096 J\u0019\u0010h\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010i\u001a\u00020\nH\u0096 J\u0019\u0010j\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH\u0096 J\u0019\u0010l\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010m\u001a\u00020\fH\u0096 J\u0019\u0010n\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010o\u001a\u00020\nH\u0096 J\u0019\u0010p\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010q\u001a\u00020\nH\u0096 J\u0011\u0010r\u001a\u00020\f2\u0006\u00102\u001a\u00020\nH\u0096 J\u0019\u0010r\u001a\u00020\f2\u0006\u00102\u001a\u00020\n2\u0006\u0010s\u001a\u00020\nH\u0096 J\u0017\u0010t\u001a\u00020\f2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0011\u0010v\u001a\u00020\f2\u0006\u0010'\u001a\u00020\nH\u0096 J\u0017\u0010w\u001a\u00020\f2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0019\u0010y\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0003H\u0096 J\u0011\u0010z\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0096 J\u0019\u0010{\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0006\u0010}\u001a\u00020\fH\u0096 J\u0019\u0010~\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020LH\u0096 J\u001b\u0010\u0080\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020\nH\u0096 J\u001b\u0010\u0082\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0007\u0010\u0083\u0001\u001a\u00020\fH\u0096 J\u001a\u0010\u0084\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0096 J\u001d\u0010\u0085\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\nH\u0096 J\u001b\u0010\u0087\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\fH\u0096 J\u001b\u0010\u0089\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\u0003H\u0096 J\u001b\u0010\u008b\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0096 J\u001b\u0010\u008d\u0001\u001a\u00020\f2\u0006\u0010|\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u00020\nH\u0096 J \u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u00102\u001a\u00020\n2\u0006\u0010s\u001a\u00020\nH\u0096 J)\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u00032\u0007\u0010\u0091\u0001\u001a\u00020\u0003H\u0096 J!\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0007\u0010\u0091\u0001\u001a\u00020\u0003H\u0096 J\n\u0010\u0093\u0001\u001a\u00020\u0003H\u0096 J\u0012\u0010\u0093\u0001\u001a\u00020\u00032\u0006\u00102\u001a\u00020\nH\u0096 J\u001a\u0010\u0094\u0001\u001a\u00020\f2\u0006\u00102\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\n\u0010\u0095\u0001\u001a\u00020\fH\u0096 J\n\u0010\u0096\u0001\u001a\u00020\u0003H\u0096 J\n\u0010\u0097\u0001\u001a\u00020\u0003H\u0096 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Lcom/larus/im/internal/jni/NativeMessageDaoImpl;", "Lcom/larus/im/internal/database/dao/MessageDao;", "nativePtr", "", "<init>", "(J)V", "searchMessageByFts", "", "Lcom/larus/im/internal/database/entity/MessageEntity;", "query", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "timeCursor", "availableContentType", "conversationId", "conversationIdList", "senderId", "searchMessageByLike", "getMessageLessThanTartLocalIndex", "mTarTime", "offset", "insertMessage", "", "message", "insertAllMessages", "messages", "getLatestVisibleMessageList", "getMessageListByCollectionId", "collectionID", "getVisibleMessageListById", "ids", "getMessageListByIdsOrLocalIds", "localMsgIds", "getOlderVisibleMessageList", "maxIndex", "getMessageById", RemoteMessageConst.MSGID, "getMessageByLocalId", "localMsgId", "getMessageByLocalIdOrMsgId", "getMessageListByMaxIndex", "maxLocalIndex", "getMessageListByIndexRange", "minLocalIndex", "getMessagesByLocalMessageIds", "localMessageIdList", "getMessagesByMessageIds", "messageIdList", "getMessagesByCvsId", "cvsId", "getMessagesByCvsIdWithLimit", "getLastLocalIndexByCvsId", "getMessageListByReplyId", "replyId", "getThreadMessageListByReplyId", "threadId", "getMessageListByReferId", "referMsgId", "getSendSuccessImageMessageList", "getMessageListByCreateTimeWithLimit", DyPayConstant.KEY_START_TIME, "endTime", "getAllMessageBySenderId", "getLocalOnboardingIds", "getMessageListBySenderId", "getMessageListBySenderIdWithLimit", "getMessageListBySectionId", "sectionId", "getMessageListByStatus", "status", "getTypeMsgInStatus", "typeList", "statusList", "getLastLocalMessageId", "isVisible", "", "getLastLocalMessage", "getLastLocalCreateTime", "getMaxServerIndexByCvsId", "getLastServerIndexByCvsId", "getOldestServerIndexByCvsId", "updateBrief", SelectInfo.BRIEF, "updateFtsContent", "ftsContent", "updateRegenIndex", "regenIndex", "updateRegenStatus", "regenStatus", "updateRegenVisible", "regenVisible", "updateRegenRootId", "regenRootId", "updateMessageId", "updateStatus", "updateSender", "updateLocalIndex", "localIndex", "updateSectionId", "updateSectionName", "sectionName", "updateExt", "ext", "updateReferenceInfo", "refInfo", "updateSuggestionQuestions", "suggestQuestions", "updateFeedback", "feedback", "updateThinkingContent", "thinkingContent", "updateCollectionId", "collectionId", "deleteMessageByConversationId", "matcher", "deleteMessageByCvsIds", "cvsIds", "deleteMessageByLocalMessageId", "deleteMsgByLocalMsgId", "idList", "deleteMessageListByMaxIndex", "deleteAllMessageBySenderId", "updateServerStatus", "localMessageId", "serverStatus", "updateSourceFromAsr", "sourceFromAsr", "updateImageDataPath", "imageDataPath", "updateImageUploadStatus", "imageUploadStatus", "updateConversationId", "updateRegenMessageList", "regenMessageList", "updateMessageBodyVersion", "msgBodyVersion", "updateServerIndex", "serverIndex", "updateBizExt", "bizExt", "updateTags", PromotionProductPrivilegesStruct.TAGS, "getMessageByMatcherCvsId", "getSendMessageListByLocalIndex", "createTimeLimit", "getSendingMessageList", "getAllMessageCount", "deleteOlderMessage", "deleteAllMessage", "getMessageNewBlockCount", "getMessageTotalBlockCount", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeMessageDaoImpl implements MessageDao {
    private final long nativePtr;

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteAllMessage();

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteAllMessageBySenderId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteMessageByConversationId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteMessageByConversationId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteMessageByCvsIds(List<String> r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteMessageByLocalMessageId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteMessageListByMaxIndex(String r100, long r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteMsgByLocalMsgId(List<String> r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int deleteOlderMessage(String r100, int r101);

    public native List<MessageEntity> getAllMessageBySenderId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getAllMessageCount();

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getAllMessageCount(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getLastLocalCreateTime(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getLastLocalIndexByCvsId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native MessageEntity getLastLocalMessage(String r100, boolean r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native String getLastLocalMessageId(String r100, boolean r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getLastServerIndexByCvsId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getLatestVisibleMessageList(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<String> getLocalOnboardingIds(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getMaxServerIndexByCvsId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native MessageEntity getMessageById(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native MessageEntity getMessageByLocalId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageByLocalIdOrMsgId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageByMatcherCvsId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageLessThanTartLocalIndex(long r100, int r101, int r102);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByCollectionId(String r100, String r101);

    public native List<MessageEntity> getMessageListByCreateTimeWithLimit(long r100, long r101, int r102);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByIdsOrLocalIds(List<String> r100, List<String> r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByIndexRange(String r100, long r101, long r102);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByMaxIndex(String r100, long r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByReferId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByReplyId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListBySectionId(String r100, String r101);

    public native List<MessageEntity> getMessageListBySenderId(String r100, String r101, long r102);

    public native List<MessageEntity> getMessageListBySenderIdWithLimit(String r100, String r101, int r102);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessageListByStatus(int r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getMessageNewBlockCount();

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getMessageTotalBlockCount();

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessagesByCvsId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessagesByCvsIdWithLimit(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessagesByLocalMessageIds(List<String> r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getMessagesByMessageIds(List<String> r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getOlderVisibleMessageList(String r100, long r101, int r102);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native long getOldestServerIndexByCvsId(String r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getSendMessageListByLocalIndex(String r100, long r101, long r102);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getSendSuccessImageMessageList(int r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getSendingMessageList(String r100, long r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getThreadMessageListByReplyId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getTypeMsgInStatus(List<Integer> r100, List<Integer> r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> getVisibleMessageListById(List<String> r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native void insertAllMessages(List<MessageEntity> r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native void insertMessage(MessageEntity r100);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> searchMessageByFts(String r100, int r101, long r102, List<Integer> r103, String r104, List<String> r105, String r106);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native List<MessageEntity> searchMessageByLike(String r100, int r101, long r102, List<Integer> r103, String r104, List<String> r105, String r106);

    public native int updateBizExt(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateBrief(String r100, String r101);

    public native int updateCollectionId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateConversationId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateExt(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateFeedback(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateFtsContent(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateImageDataPath(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateImageUploadStatus(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateLocalIndex(String r100, long r101);

    public native int updateMessageBodyVersion(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateMessageId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateReferenceInfo(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateRegenIndex(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateRegenMessageList(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateRegenRootId(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateRegenStatus(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateRegenVisible(String r100, boolean r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateSectionId(String r100, String r101);

    public native int updateSectionName(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateSender(String r100, String r101);

    public native int updateServerIndex(String r100, long r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateServerStatus(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateSourceFromAsr(String r100, boolean r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateStatus(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.MessageDao
    public native int updateSuggestionQuestions(String r100, String r101);

    public native int updateTags(String r100, String r101);

    public native int updateThinkingContent(String r100, String r101);

    public NativeMessageDaoImpl(long r100) {
        this.nativePtr = r100;
    }
}
