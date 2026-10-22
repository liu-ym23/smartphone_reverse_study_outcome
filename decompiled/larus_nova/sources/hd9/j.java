package hd9;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface j {
    void updateConversationBadgeCount(String r100, int r101, int r102);

    void updateConversationLastMessage(List<MessageEntity> r100, boolean r101);

    void verifyConversationConsistency();
}
