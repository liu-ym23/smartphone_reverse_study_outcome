package com.larus.im.internal.jni;

import com.larus.im.internal.database.dao.BotDao;
import com.larus.im.internal.database.entity.BotEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096 J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0096 J\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0096 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0096 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0096 J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0014\u001a\u00020\nH\u0096 J\t\u0010\u0015\u001a\u00020\u0003H\u0096 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/im/internal/jni/NativeBotDaoImpl;", "Lcom/larus/im/internal/database/dao/BotDao;", "nativePtr", "", "<init>", "(J)V", "getMainBot", "Lcom/larus/im/internal/database/entity/BotEntity;", "getBotById", "botId", "", "getBotsByIds", "", "botIds", "insertBot", "", "bot", "deleteBot", "", "getBotByConversationId", "conversationId", "getAllBotCount", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeBotDaoImpl implements BotDao {
    private final long nativePtr;

    @Override // com.larus.im.internal.database.dao.BotDao
    public native int deleteBot(String r100);

    @Override // com.larus.im.internal.database.dao.BotDao
    public native long getAllBotCount();

    @Override // com.larus.im.internal.database.dao.BotDao
    public native List<BotEntity> getBotByConversationId(String r100);

    @Override // com.larus.im.internal.database.dao.BotDao
    public native BotEntity getBotById(String r100);

    @Override // com.larus.im.internal.database.dao.BotDao
    public native List<BotEntity> getBotsByIds(List<String> r100);

    @Override // com.larus.im.internal.database.dao.BotDao
    public native BotEntity getMainBot();

    @Override // com.larus.im.internal.database.dao.BotDao
    public native void insertBot(BotEntity r100);

    public NativeBotDaoImpl(long r100) {
        this.nativePtr = r100;
    }
}
