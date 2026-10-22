package com.larus.im.internal.jni;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.internal.database.dao.ConversationDao;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.simple.ConversationSimpleEntity;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b8\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\nH\u0096 J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0096 J\u0011\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0096 J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096 J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096 J\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096 J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0096 J\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0003H\u0096 J'\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH\u0096 J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0003H\u0096 J'\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH\u0096 J\u0019\u0010#\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010$\u001a\u00020\fH\u0096 J\u0019\u0010%\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010&\u001a\u00020\fH\u0096 J\u0019\u0010'\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0096 J\u0019\u0010)\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0003H\u0096 J\u0019\u0010+\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010,\u001a\u00020\fH\u0096 J\u0019\u0010-\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010.\u001a\u00020\fH\u0096 J\u0019\u0010/\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0096 J\u0019\u00101\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0096 J\u0019\u00103\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0003H\u0096 J\u0019\u00105\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00106\u001a\u00020\fH\u0096 J\u0019\u00107\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00108\u001a\u000209H\u0096 J\u0019\u0010:\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nH\u0096 J\u0019\u0010<\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010=\u001a\u00020\fH\u0096 J\u0019\u0010>\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010?\u001a\u00020\fH\u0096 J\u0019\u0010@\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u0003H\u0096 J\u0019\u0010B\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0096 J\u0019\u0010D\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0096 J\u0019\u0010F\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0003H\u0096 J\u000b\u0010G\u001a\u0004\u0018\u00010\bH\u0096 J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096 J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096 J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0007H\u0096 J\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0019\u0010N\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010O\u001a\u00020\fH\u0096 J\u0011\u0010P\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0096 J\u0017\u0010Q\u001a\u00020\f2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 J\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010S\u001a\u00020\nH\u0096 J\u001f\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010S\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0096 J\u0011\u0010T\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\nH\u0096 J\u0019\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096 J\u0019\u0010X\u001a\u00020\f2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096 J\u0019\u0010Y\u001a\u00020\f2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\u0003H\u0096 J\u0019\u0010Z\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u0003H\u0096 J\u0019\u0010\\\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010]\u001a\u00020\nH\u0096 J\u0019\u0010^\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010_\u001a\u00020\nH\u0096 J\u0019\u0010`\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010a\u001a\u000209H\u0096 J \u0010b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010c\u001a\u0004\u0018\u00010\fH\u0096 ¢\u0006\u0002\u0010dJ\u0019\u0010e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010f\u001a\u00020\fH\u0096 J\u0019\u0010g\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010h\u001a\u00020\fH\u0096 J\u0019\u0010i\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010j\u001a\u00020\fH\u0096 J\u0019\u0010k\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010l\u001a\u00020\fH\u0096 J\u0019\u0010m\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010n\u001a\u00020\nH\u0096 J\t\u0010o\u001a\u00020\u0003H\u0096 J\u000f\u0010p\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/larus/im/internal/jni/NativeConversationDaoImpl;", "Lcom/larus/im/internal/database/dao/ConversationDao;", "nativePtr", "", "<init>", "(J)V", "searchConversationByFts", "", "Lcom/larus/im/internal/database/entity/ConversationEntity;", "query", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "timeCursor", "conversationIds", "searchConversationByLike", "getConversationById", "cvsId", "conversationType", "insertConversation", "conversation", "getAllConversation", "getAllConversationIds", "getSimpleCvsListWithLimit", "Lcom/larus/im/internal/database/entity/simple/ConversationSimpleEntity;", "getLocalCvsIdsWithLimit", "getSortedConversations", "getSortedConversationsWithLimit", "getSortedConversationsWithLimitByArchiveStatus", "archiveStatus", "getNonPinConversationWithLimit", "version", "getNonPinConversationWithLimitByArchiveStatus", "getPinConversationWithLimit", "getPinConversationWithLimitByArchiveStatus", "updateBotType", "botType", "updateParticipantCount", "participantCount", "updateName", "name", UserInfo.UPDATE_TIME, "time", "updatePin", "pinned", "updateLocal", "isLocal", "updatePage", "page", "updateTemplates", "templates", "updateCursor", EffectConfiguration.KEY_CURSOR, "updateType", "type", "updateTtsEnable", "enable", "", "updateIcon", "iconImage", "updateBadgeCount", "badgeCount", "updateReadBadgeCount", "count", "updateReadMessageIndex", "index", "updateBriefMsgLocalId", "briefMsgLocalId", "updateExt", "ext", "updateVersion", "getMainConversation", "getMainConversationV2", "getAllSubConversation", "getAllSubSimpleCvsList", "getConversationsByConversationIds", "cvsIds", "getConversationListByIdsWithAuth", "updateStatus", "status", "deleteConversation", "deleteConversations", "getConversationByBotId", "botId", "getCursor", "updateBizExtra", "newCvsId", "it", "updateBizModel", "updateRetentionCursor", "updateLatestMessageIndex", "latestMessageIndex", "updateTraceMap", "traceMap", "updateGroupOwnerId", "ownerId", "updateDeleted", "isDeleted", "updateInputLeftActionStyle", "style", "(Ljava/lang/String;Ljava/lang/Integer;)I", "updateGroupReviewStatus", "groupReviewStatus", "updateCreateScene", "create_scene", "updateCellType", "cellType", "updateCreateChannel", "createChannel", "updateParentCellId", "parentCellId", "getAllConversationCount", "getAllVisibleBotCvsIds", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeConversationDaoImpl implements ConversationDao {
    private final long nativePtr;

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int deleteConversation(String r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int deleteConversations(List<String> r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getAllConversation();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native long getAllConversationCount();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<String> getAllConversationIds();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getAllSubConversation();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationSimpleEntity> getAllSubSimpleCvsList();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<String> getAllVisibleBotCvsIds();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getConversationByBotId(String r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getConversationByBotId(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native ConversationEntity getConversationById(String r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native ConversationEntity getConversationById(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getConversationListByIdsWithAuth(List<String> r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getConversationsByConversationIds(List<String> r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native long getCursor(String r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<String> getLocalCvsIdsWithLimit(int r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native ConversationEntity getMainConversation();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getMainConversationV2();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getNonPinConversationWithLimit(int r100, long r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getNonPinConversationWithLimitByArchiveStatus(int r100, long r101, int r102);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getPinConversationWithLimit(int r100, long r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getPinConversationWithLimitByArchiveStatus(int r100, long r101, int r102);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationSimpleEntity> getSimpleCvsListWithLimit(int r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getSortedConversations();

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getSortedConversationsWithLimit(int r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> getSortedConversationsWithLimitByArchiveStatus(int r100, int r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native long insertConversation(ConversationEntity r100);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> searchConversationByFts(String r100, int r101, long r102, List<String> r103);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native List<ConversationEntity> searchConversationByLike(String r100, int r101, long r102, List<String> r103);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int updateBadgeCount(String r100, int r101);

    public native int updateBizExtra(String r100, String r101);

    public native int updateBizModel(String r100, String r101);

    public native int updateBotType(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int updateBriefMsgLocalId(String r100, String r101);

    public native int updateCellType(String r100, int r101);

    public native int updateCreateChannel(String r100, int r101);

    public native int updateCreateScene(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int updateCursor(String r100, long r101);

    public native int updateDeleted(String r100, boolean r101);

    public native int updateExt(String r100, String r101);

    public native int updateGroupOwnerId(String r100, String r101);

    public native int updateGroupReviewStatus(String r100, int r101);

    public native int updateIcon(String r100, String r101);

    public native int updateInputLeftActionStyle(String r100, Integer r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int updateLatestMessageIndex(String r100, long r101);

    public native int updateLocal(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int updateName(String r100, String r101);

    public native int updatePage(String r100, String r101);

    public native int updateParentCellId(String r100, String r101);

    public native int updateParticipantCount(String r100, int r101);

    public native int updatePin(String r100, int r101);

    public native int updateReadBadgeCount(String r100, int r101);

    public native int updateReadMessageIndex(String r100, long r101);

    public native int updateRetentionCursor(String r100, long r101);

    public native int updateStatus(String r100, int r101);

    public native int updateTemplates(String r100, String r101);

    public native int updateTime(String r100, long r101);

    public native int updateTraceMap(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.ConversationDao
    public native int updateTtsEnable(String r100, boolean r101);

    public native int updateType(String r100, int r101);

    public native int updateVersion(String r100, long r101);

    public NativeConversationDaoImpl(long r100) {
        this.nativePtr = r100;
    }
}
