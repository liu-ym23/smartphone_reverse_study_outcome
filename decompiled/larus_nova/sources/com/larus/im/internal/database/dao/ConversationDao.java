package com.larus.im.internal.database.dao;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.simple.ConversationSimpleEntity;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b8\b`\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0006H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH&J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\nH&J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\bH&J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\nH&J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\bH&J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH&J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\bH&J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H&J\u0018\u0010&\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\nH&J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\bH&J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\bH&J\u0018\u0010,\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H&J\u0018\u0010.\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H&J\u0018\u00100\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00101\u001a\u00020\nH&J\u0018\u00102\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u00020\bH&J\u0018\u00104\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00105\u001a\u000206H&J\u0018\u00107\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H&J\u0018\u00109\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\bH&J\u0018\u0010;\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\bH&J\u0018\u0010=\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\nH&J\u0018\u0010?\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006H&J\u0018\u0010A\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0006H&J\u0018\u0010C\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH&J\n\u0010D\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0003H&J\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0018\u0010K\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\bH&J\u0010\u0010M\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0016\u0010N\u001a\u00020\b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010P\u001a\u00020\u0006H&J\u001e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010P\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH&J\u0010\u0010Q\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0006H&J\u0018\u0010U\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0006H&J\u0018\u0010V\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\nH&J\u0018\u0010W\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\nH&J\u0018\u0010Y\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H&J\u0018\u0010[\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u0006H&J\u0018\u0010]\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010^\u001a\u000206H&J\u001f\u0010_\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010`\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010aJ\u0018\u0010b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\bH&J\u0018\u0010d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\bH&J\u0018\u0010f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\bH&J\u0018\u0010h\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\bH&J\u0018\u0010j\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0006H&J\b\u0010l\u001a\u00020\nH&J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&¨\u0006n"}, d2 = {"Lcom/larus/im/internal/database/dao/ConversationDao;", "", "searchConversationByFts", "", "Lcom/larus/im/internal/database/entity/ConversationEntity;", "query", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "timeCursor", "", "conversationIds", "searchConversationByLike", "getConversationById", "cvsId", "conversationType", "insertConversation", "conversation", "getAllConversation", "getAllConversationIds", "getSimpleCvsListWithLimit", "Lcom/larus/im/internal/database/entity/simple/ConversationSimpleEntity;", "getLocalCvsIdsWithLimit", "getSortedConversations", "getSortedConversationsWithLimit", "getSortedConversationsWithLimitByArchiveStatus", "archiveStatus", "getNonPinConversationWithLimit", "version", "getNonPinConversationWithLimitByArchiveStatus", "getPinConversationWithLimit", "getPinConversationWithLimitByArchiveStatus", "updateBotType", "botType", "updateParticipantCount", "participantCount", "updateName", "name", UserInfo.UPDATE_TIME, "time", "updatePin", "pinned", "updateLocal", "isLocal", "updatePage", "page", "updateTemplates", "templates", "updateCursor", EffectConfiguration.KEY_CURSOR, "updateType", "type", "updateTtsEnable", "enable", "", "updateIcon", "iconImage", "updateBadgeCount", "badgeCount", "updateReadBadgeCount", "count", "updateReadMessageIndex", "index", "updateBriefMsgLocalId", "briefMsgLocalId", "updateExt", "ext", "updateVersion", "getMainConversation", "getMainConversationV2", "getAllSubConversation", "getAllSubSimpleCvsList", "getConversationsByConversationIds", "cvsIds", "getConversationListByIdsWithAuth", "updateStatus", "status", "deleteConversation", "deleteConversations", "getConversationByBotId", "botId", "getCursor", "updateBizExtra", "newCvsId", "it", "updateBizModel", "updateRetentionCursor", "updateLatestMessageIndex", "latestMessageIndex", "updateTraceMap", "traceMap", "updateGroupOwnerId", "ownerId", "updateDeleted", "isDeleted", "updateInputLeftActionStyle", "style", "(Ljava/lang/String;Ljava/lang/Integer;)I", "updateGroupReviewStatus", "groupReviewStatus", "updateCreateScene", "create_scene", "updateCellType", "cellType", "updateCreateChannel", "createChannel", "updateParentCellId", "parentCellId", "getAllConversationCount", "getAllVisibleBotCvsIds", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ConversationDao {
    int deleteConversation(String r100);

    int deleteConversations(List<String> r100);

    List<ConversationEntity> getAllConversation();

    long getAllConversationCount();

    List<String> getAllConversationIds();

    List<ConversationEntity> getAllSubConversation();

    List<ConversationSimpleEntity> getAllSubSimpleCvsList();

    List<String> getAllVisibleBotCvsIds();

    List<ConversationEntity> getConversationByBotId(String r100);

    List<ConversationEntity> getConversationByBotId(String r100, int r101);

    ConversationEntity getConversationById(String r100);

    ConversationEntity getConversationById(String r100, int r101);

    List<ConversationEntity> getConversationListByIdsWithAuth(List<String> r100);

    List<ConversationEntity> getConversationsByConversationIds(List<String> r100);

    long getCursor(String r100);

    List<String> getLocalCvsIdsWithLimit(int r100);

    ConversationEntity getMainConversation();

    List<ConversationEntity> getMainConversationV2();

    List<ConversationEntity> getNonPinConversationWithLimit(int r100, long r101);

    List<ConversationEntity> getNonPinConversationWithLimitByArchiveStatus(int r100, long r101, int r102);

    List<ConversationEntity> getPinConversationWithLimit(int r100, long r101);

    List<ConversationEntity> getPinConversationWithLimitByArchiveStatus(int r100, long r101, int r102);

    List<ConversationSimpleEntity> getSimpleCvsListWithLimit(int r100);

    List<ConversationEntity> getSortedConversations();

    List<ConversationEntity> getSortedConversationsWithLimit(int r100);

    List<ConversationEntity> getSortedConversationsWithLimitByArchiveStatus(int r100, int r101);

    long insertConversation(ConversationEntity r100);

    List<ConversationEntity> searchConversationByFts(String r100, int r101, long r102, List<String> r103);

    List<ConversationEntity> searchConversationByLike(String r100, int r101, long r102, List<String> r103);

    int updateBadgeCount(String r100, int r101);

    int updateBriefMsgLocalId(String r100, String r101);

    int updateCursor(String r100, long r101);

    int updateLatestMessageIndex(String r100, long r101);

    int updateName(String r100, String r101);

    int updateTtsEnable(String r100, boolean r101);
}
