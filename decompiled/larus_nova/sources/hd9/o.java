package hd9;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface o {
    void clearAllServerLoading(String r100);

    MessageEntity concatChunk(MessageEntity r100, MessageEntity r101, List<Integer> r102, boolean r103);

    String ftsParseMessage(String r100, String r101, int r102, String r103, String r104);

    List<String> getAllServerLoadingLocalMessageIds(String r100);

    void handleDeprecatedCmd(String r100, int r101);

    void handleSSECmd(String r100, Boolean r101);

    void ignoreQuestion(String r100);

    void interruptOldSSE(String r100, String r101, String r102);

    Map<String, String> interruptTypewriter(String r100, String r101);

    boolean isIgnored(String r100, String r101);

    boolean isMsgConvPending(String r100, String r101);

    boolean isMsgPended(String r100);

    void launchChunk(String r100, MessageEntity r101);

    void resumeChunk();
}
