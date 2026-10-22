package com.larus.im.internal.database.dao;

import com.larus.im.internal.database.entity.ParticipantEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&J\u0016\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\fH&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/larus/im/internal/database/dao/ParticipantDao;", "", "getParticipantById", "Lcom/larus/im/internal/database/entity/ParticipantEntity;", "participantId", "", "conversationId", "insertParticipant", "", "participant", "insertAllParticipant", "list", "", "getParticipantByConversationId", "cvsId", "getParticipantCount", "", "status", "deleteParticipantsByConversationId", "deleteParticipantsByCvsIds", "cvsIds", "getAllParticipantCount", "", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ParticipantDao {
    int deleteParticipantsByConversationId(String r100);

    int deleteParticipantsByCvsIds(List<String> r100);

    long getAllParticipantCount();

    List<ParticipantEntity> getParticipantByConversationId(String r100);

    ParticipantEntity getParticipantById(String r100, String r101);

    int getParticipantCount(String r100, int r101);

    void insertAllParticipant(List<ParticipantEntity> r100);

    void insertParticipant(ParticipantEntity r100);
}
