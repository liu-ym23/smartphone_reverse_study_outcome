package com.larus.im.internal.database.dao;

import com.larus.im.internal.database.entity.BotEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0010\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/database/dao/BotDao;", "", "getMainBot", "Lcom/larus/im/internal/database/entity/BotEntity;", "getBotById", "botId", "", "getBotsByIds", "", "botIds", "insertBot", "", "bot", "deleteBot", "", "getBotByConversationId", "conversationId", "getAllBotCount", "", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BotDao {
    int deleteBot(String r100);

    long getAllBotCount();

    List<BotEntity> getBotByConversationId(String r100);

    BotEntity getBotById(String r100);

    List<BotEntity> getBotsByIds(List<String> r100);

    BotEntity getMainBot();

    void insertBot(BotEntity r100);
}
