package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.AIRoundInfo;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.ding.entity.DingStatus;
import com.ss.android.lark.log.Log;
import f5b.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p5b.c;
import uxb.d;

/* JADX INFO: loaded from: classes35.dex */
public class MessageInfo implements d, c, b, p5b.a, Serializable, Comparable<MessageInfo>, y28.b<MessageInfo> {
    public static final String TAG = "MessageInfo";
    private AIRecommendQuestions aiRecommendQuestions;
    private AIRoundInfo aiRoundInfo;
    private List<Message> childMessageInThread;
    private DingStatus dingStatus;
    private MessageFoldDetail foldDetail;
    private boolean isForceUpdate;
    private Boolean isTranslating;
    private long lastReplyInThreadTime;
    private List<MessageInfo> latestRepliesInThread;
    private Message mMessage;
    private ChatChatter mMessageSender;
    private boolean mNeedToAutoTranslate;
    private MessageInfo mParentMessageInfo;
    private Pin mPin;
    private ChatChatter mRecallUser;
    private MessageInfo mRootMessageInfo;
    private MessageInfo mThreadParentMessageInfo;
    private TranslateInfo mTranslateInfo;
    private UniversalPinExtra mUniversalPinExtra;
    private ArrayList<String> msgIdPathList;
    private MyAIThreadInfo myAIThreadInfo;
    private ChatChatter originalSender;
    private PartialReplyInfo partialReplyInfo;
    private List<ReactionInfo> reactionInfos;
    private int replyInThreadCount;
    private SmartReplyEntryInfo smartReplyEntryInfo;
    private List<e5b.a> threadMergeForwardSimplifyReplies;

    @Override // f5b.b
    public boolean isNoTraceDelete() {
        return false;
    }

    public void setFollow(boolean r100) {
    }

    public void setNoTraceDelete(boolean r100) {
    }

    @Override // f5b.b
    public boolean canShow() {
        return this.mMessage.canShow();
    }

    public b doCopy() {
        return new MessageInfo(this);
    }

    public String getAIAnswerRawData() {
        Message r100 = this.mMessage;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAiAnswerRawData();
    }

    public long getAIChatModeId() {
        Message r100 = this.mMessage;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAiChatModeId();
    }

    @Override // f5b.b
    public String getId() {
        return this.mMessage.getId();
    }

    public String getParentId() {
        return this.mMessage.getParentId();
    }

    @Override // f5b.b
    public long getUpdateTime() {
        return this.mMessage.getUpdateTime();
    }

    @Override // f5b.b
    public String getcId() {
        return this.mMessage.getcId();
    }

    public int hashCode() {
        Message r100 = this.mMessage;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    @Override // f5b.b
    public boolean isIntermediateMessage() {
        return this.mMessage.isCryptoIntermediate();
    }

    @Override // f5b.b
    public boolean isPreMessage() {
        return this.mMessage.isPreMessage();
    }

    @Override // f5b.b
    public boolean isTranslating() {
        Boolean r100 = this.isTranslating;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.booleanValue() == false) goto L7;
        return true;
    }

    @Override // f5b.b
    public boolean isTranslatingInited() {
        if (this.isTranslating == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        Message r100 = this.mMessage;
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        StringBuilder r102 = new StringBuilder(r101);
        r102.append(" replyInThreadCount=");
        r102.append(this.replyInThreadCount);
        r102.append(" foldDetail=");
        r102.append(this.foldDetail);
        r102.append(" smartReplyEntryInfo==null:");
        boolean r103 = true;
        if (this.smartReplyEntryInfo != null) goto L9;
        boolean r104 = true;
    L10:
        r102.append(r104);
        r102.append(" AiRecommendQuestions==null:");
        if (this.aiRecommendQuestions == null) goto L14;
        r103 = false;
    L14:
        r102.append(r103);
        return r102.toString();
    L9:
        r104 = false;
        goto L10
    L5:
        r101 = super.toString();
        goto L6
    }

    public MessageInfo() {
        this.mNeedToAutoTranslate = true;
        this.isTranslating = null;
        this.replyInThreadCount = 0;
    }

    @Override // f5b.b
    public b clone() {
        return (b) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // f5b.b
    public List<String> getAuthFileKeys() {
        return getMessage().getAuthFileKeys();
    }

    @Override // p5b.c, f5b.b
    public /* bridge */ /* synthetic */ p5b.b getMessage() {
        return getMessage();
    }

    /* JADX INFO: renamed from: getMessageSender, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ OpenChatter m8608getMessageSender() {
        return getMessageSender();
    }

    /* JADX INFO: renamed from: getOriginalSender, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ OpenChatter m8610getOriginalSender() {
        return getOriginalSender();
    }

    /* JADX INFO: renamed from: getParentMessageInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m8611getParentMessageInfo() {
        return getParentMessageInfo();
    }

    /* JADX INFO: renamed from: getRootMessageInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m8612getRootMessageInfo() {
        return getRootMessageInfo();
    }

    /* JADX INFO: renamed from: getThreadParentMessageInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m8613getThreadParentMessageInfo() {
        return getThreadParentMessageInfo();
    }

    public Content getTranslateContent() {
        return getTranslateContent(isShowMessageOriginContent());
    }

    public boolean hasReaction() {
        if (getReactionInfoList() == null) goto L11;
        Iterator<ReactionInfo> r100 = getReactionInfoList().iterator();
    L6:
        if (r100.hasNext() == false) goto L16;
        if (r100.next().getReaction().getCount() <= 0) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    @Override // f5b.b, p5b.a
    public boolean isShowMessageOriginContent() {
        String r100 = getMessage().getTranslateLanguage();
        TranslateInfo r101 = getTranslateInfo();
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r101 == null) goto L11;
        if (r100.equals(r101.getLanguage()) == false) goto L11;
        if (getMessage().getStatus() == Message.Status.DELETED) goto L11;
        return false;
    L11:
        return true;
    }

    public AIRecommendQuestions getAiRecommendQuestions() {
        return this.aiRecommendQuestions;
    }

    public AIRoundInfo getAiRoundInfo() {
        return this.aiRoundInfo;
    }

    public List<Message> getChildMessagesInThread() {
        return this.childMessageInThread;
    }

    public DingStatus getDingStatus() {
        return this.dingStatus;
    }

    public long getLastReplyInThreadTime() {
        return this.lastReplyInThreadTime;
    }

    public List<MessageInfo> getLatestRepliesInThread() {
        return this.latestRepliesInThread;
    }

    @Override // f5b.b
    public MessageFoldDetail getMessageFoldDetail() {
        return this.foldDetail;
    }

    @Override // f5b.b
    public ArrayList<String> getMsgIdPathList() {
        return this.msgIdPathList;
    }

    public MyAIThreadInfo getMyAIThreadInfo() {
        return this.myAIThreadInfo;
    }

    @Override // f5b.b
    public b getParent() {
        return this.mParentMessageInfo;
    }

    public PartialReplyInfo getPartialReplyInfo() {
        return this.partialReplyInfo;
    }

    @Override // f5b.b
    public Pin getPin() {
        return this.mPin;
    }

    @Override // f5b.b
    public List<ReactionInfo> getReactionInfoList() {
        return this.reactionInfos;
    }

    public ChatChatter getRecallUser() {
        return this.mRecallUser;
    }

    public int getReplyInThreadCount() {
        return this.replyInThreadCount;
    }

    public SmartReplyEntryInfo getSmartReplyEntryInfo() {
        return this.smartReplyEntryInfo;
    }

    public List<e5b.a> getThreadMergeForwardSimplifyReplies() {
        return this.threadMergeForwardSimplifyReplies;
    }

    @Override // f5b.b
    public TranslateInfo getTranslateInfo() {
        return this.mTranslateInfo;
    }

    public UniversalPinExtra getUniversalPinExtra() {
        return this.mUniversalPinExtra;
    }

    public boolean isForceUpdate() {
        return this.isForceUpdate;
    }

    public boolean isNeedToAutoTranslate() {
        return this.mNeedToAutoTranslate;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8606clone() throws CloneNotSupportedException {
        return clone();
    }

    /* JADX INFO: renamed from: getMessage, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ uxb.c m8607getMessage() {
        return getMessage();
    }

    /* JADX INFO: renamed from: getMessageSender, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ uxb.a m8609getMessageSender() {
        return getMessageSender();
    }

    public ChatChatter getOriginalSender() {
        return this.originalSender;
    }

    public MessageInfo getParentMessageInfo() {
        return this.mParentMessageInfo;
    }

    public MessageInfo getRootMessageInfo() {
        return this.mRootMessageInfo;
    }

    public MessageInfo getThreadParentMessageInfo() {
        return this.mThreadParentMessageInfo;
    }

    @Override // p5b.c, f5b.b
    public Message getMessage() {
        return this.mMessage;
    }

    @Override // f5b.b
    public ChatChatter getMessageSender() {
        return this.mMessageSender;
    }

    public MessageInfo(MessageInfo r100) {
        this.mNeedToAutoTranslate = true;
        this.isTranslating = null;
        this.replyInThreadCount = 0;
        this.mMessage = r100.mMessage;
        this.mMessageSender = r100.mMessageSender;
        this.mTranslateInfo = r100.mTranslateInfo;
        this.dingStatus = r100.dingStatus;
        this.reactionInfos = r100.reactionInfos;
        this.mRootMessageInfo = r100.getRootMessageInfo();
        this.mParentMessageInfo = r100.getParentMessageInfo();
        this.mRecallUser = r100.mRecallUser;
        this.mNeedToAutoTranslate = r100.isNeedToAutoTranslate();
        this.isTranslating = r100.isTranslating;
        this.mTranslateInfo = r100.getTranslateInfo();
        this.mPin = r100.getPin();
        this.originalSender = r100.originalSender;
        this.replyInThreadCount = r100.replyInThreadCount;
        this.latestRepliesInThread = r100.latestRepliesInThread;
        this.lastReplyInThreadTime = r100.lastReplyInThreadTime;
        this.foldDetail = r100.foldDetail;
        this.myAIThreadInfo = r100.myAIThreadInfo;
        this.mUniversalPinExtra = r100.mUniversalPinExtra;
        this.smartReplyEntryInfo = r100.smartReplyEntryInfo;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MessageInfo r100) {
        return this.mMessage.compareTo2(r100.getMessage());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageInfo) == true) goto L8;
        return false;
    L8:
        MessageInfo r101 = (MessageInfo) r100;
        Message r102 = this.mMessage;
        if (r102 == null) goto L14;
        if (r102.equals(r101.mMessage) == true) goto L17;
    L15:
        return false;
    L17:
        if (Objects.equals(this.myAIThreadInfo, r101.myAIThreadInfo) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(this.smartReplyEntryInfo, r101.smartReplyEntryInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        if (r101.mMessage == null) goto L17;
        goto L15
    }

    @Override // f5b.b, p5b.a
    public Content getTranslateContent(boolean r100) {
        if (r100 == false) goto L6;
        return getMessage().getContent();
    L6:
        return getTranslateInfo().getTranslateContent();
    }

    public boolean isContentSame(MessageInfo r100) {
        if (y28.a.c(this.mMessage, r100.getMessage()) == true) goto L6;
        return false;
    L6:
        if (y28.a.b(this.reactionInfos, r100.getReactionInfoList()) == true) goto L9;
        return false;
    L9:
        if (y28.a.c(this.dingStatus, r100.getDingStatus()) == true) goto L12;
        return false;
    L12:
        if (y28.a.c(this.mMessageSender, r100.getMessageSender()) == true) goto L15;
        return false;
    L15:
        if (y28.a.c(this.mRecallUser, r100.getRecallUser()) == true) goto L18;
        return false;
    L18:
        if (y28.a.c(this.mPin, r100.getPin()) == true) goto L21;
        return false;
    L21:
        if (y28.a.c(this.mUniversalPinExtra, r100.getUniversalPinExtra()) == true) goto L24;
        return false;
    L24:
        if (y28.a.c(this.foldDetail, r100.foldDetail) == true) goto L27;
        return false;
    L27:
        if (Objects.equals(this.isTranslating, r100.isTranslating) == true) goto L29;
    L47:
        return false;
    L29:
        if (Objects.equals(this.mTranslateInfo, r100.getTranslateInfo()) == false) goto L47;
        if (this.replyInThreadCount != r100.replyInThreadCount) goto L47;
        if (this.lastReplyInThreadTime != r100.lastReplyInThreadTime) goto L47;
        if (Objects.equals(this.myAIThreadInfo, r100.myAIThreadInfo) == true) goto L40;
        return false;
    L40:
        if (Objects.equals(this.smartReplyEntryInfo, r100.smartReplyEntryInfo) == true) goto L43;
        return false;
    L43:
        if (y28.a.c(this.aiRecommendQuestions, r100.aiRecommendQuestions) == false) goto L45;
        return false;
    L45:
        return true;
    }

    public boolean isItemSame(MessageInfo r100) {
        return this.mMessage.isItemSame(r100.getMessage());
    }

    public void setAiRecommendQuestions(AIRecommendQuestions r100) {
        this.aiRecommendQuestions = r100;
    }

    public void setAiRoundInfo(AIRoundInfo r100) {
        this.aiRoundInfo = r100;
    }

    public void setChildMessageInThread(List<Message> r100) {
        this.childMessageInThread = r100;
    }

    @Override // f5b.b
    public void setDingStatus(DingStatus r100) {
        this.dingStatus = r100;
    }

    @Override // f5b.b
    public void setForceUpdate(boolean r100) {
        this.isForceUpdate = r100;
    }

    @Override // f5b.b
    public void setIsTranslating(boolean r100) {
        this.isTranslating = Boolean.valueOf(r100);
    }

    public void setLastReplyInThreadTime(long r100) {
        this.lastReplyInThreadTime = r100;
    }

    public void setLatestRepliesInThread(List<MessageInfo> r100) {
        this.latestRepliesInThread = r100;
    }

    @Override // f5b.b
    public void setMessage(Message r100) {
        this.mMessage = r100;
    }

    @Override // f5b.b
    public void setMessageFoldDetail(MessageFoldDetail r100) {
        this.foldDetail = r100;
    }

    @Override // f5b.b
    public void setMessageSender(ChatChatter r100) {
        this.mMessageSender = r100;
    }

    public void setMsgIdPathList(ArrayList<String> r100) {
        this.msgIdPathList = r100;
    }

    public void setMyAIThreadInfo(MyAIThreadInfo r100) {
        this.myAIThreadInfo = r100;
    }

    public void setNeedToAutoTranslate(boolean r100) {
        this.mNeedToAutoTranslate = r100;
    }

    public void setOriginalSender(ChatChatter r100) {
        this.originalSender = r100;
    }

    public void setParentMessageInfo(MessageInfo r100) {
        this.mParentMessageInfo = r100;
    }

    public void setPartialReplyInfo(PartialReplyInfo r100) {
        this.partialReplyInfo = r100;
    }

    public void setPin(Pin r100) {
        this.mPin = r100;
    }

    public void setReactionInfoList(List<ReactionInfo> r100) {
        this.reactionInfos = r100;
    }

    public void setRecallUser(ChatChatter r100) {
        this.mRecallUser = r100;
    }

    public void setReplyInThreadCount(int r100) {
        this.replyInThreadCount = r100;
    }

    public void setRootMessageInfo(MessageInfo r100) {
        this.mRootMessageInfo = r100;
    }

    public void setSmartReplyEntryInfo(SmartReplyEntryInfo r100) {
        this.smartReplyEntryInfo = r100;
    }

    public void setThreadMergeForwardSimplifyReplies(List<e5b.a> r100) {
        this.threadMergeForwardSimplifyReplies = r100;
    }

    public void setThreadParentMessageInfo(MessageInfo r100) {
        this.mThreadParentMessageInfo = r100;
    }

    @Override // f5b.b
    public void setTranslateInfo(TranslateInfo r100) {
        this.mTranslateInfo = r100;
    }

    public void setUniversalPinExtra(UniversalPinExtra r100) {
        this.mUniversalPinExtra = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MessageInfo r100) {
        return compareTo2(r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((MessageInfo) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((MessageInfo) r100);
    }

    public MessageInfo(Message r100, ChatChatter r101) {
        this.mNeedToAutoTranslate = true;
        this.isTranslating = null;
        this.replyInThreadCount = 0;
        this.mMessage = r100;
        this.mMessageSender = r101;
        if (r101 != null) goto L7;
        if (r100 == null) goto L8;
        Log.w("chatter is null in messageinfo, chatterid: " + r100.getFromId());
        return;
    L8:
        return;
    }
}
