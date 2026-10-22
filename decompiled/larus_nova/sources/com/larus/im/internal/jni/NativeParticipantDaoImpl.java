package com.larus.im.internal.jni;

import com.larus.im.internal.database.dao.ParticipantDao;
import com.larus.im.internal.database.entity.ParticipantEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0096 J\u0017\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0096 J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0096 J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0096 J\u0011\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\tH\u0096 J\u0017\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0096 J\t\u0010\u0019\u001a\u00020\u0003H\u0096 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/im/internal/jni/NativeParticipantDaoImpl;", "Lcom/larus/im/internal/database/dao/ParticipantDao;", "nativePtr", "", "<init>", "(J)V", "getParticipantById", "Lcom/larus/im/internal/database/entity/ParticipantEntity;", "participantId", "", "conversationId", "insertParticipant", "", "participant", "insertAllParticipant", "list", "", "getParticipantByConversationId", "cvsId", "getParticipantCount", "", "status", "deleteParticipantsByConversationId", "deleteParticipantsByCvsIds", "cvsIds", "getAllParticipantCount", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeParticipantDaoImpl implements ParticipantDao {
    private final long nativePtr;

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native int deleteParticipantsByConversationId(String r100);

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native int deleteParticipantsByCvsIds(List<String> r100);

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native long getAllParticipantCount();

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native List<ParticipantEntity> getParticipantByConversationId(String r100);

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native ParticipantEntity getParticipantById(String r100, String r101);

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native int getParticipantCount(String r100, int r101);

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native void insertAllParticipant(List<ParticipantEntity> r100);

    @Override // com.larus.im.internal.database.dao.ParticipantDao
    public native void insertParticipant(ParticipantEntity r100);

    public NativeParticipantDaoImpl(long r100) {
        this.nativePtr = r100;
    }
}
