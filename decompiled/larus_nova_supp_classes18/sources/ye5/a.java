package ye5;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void createNewDiscuss(String r1, String r2, String r3);

    void deleteMainDiscuss(String r1);

    LiveData<Boolean> getCommentAble();

    LiveData<List<String>> getCurrentDiscussIds();

    String getCurrentRecordId();

    String getCurrentTableId();

    boolean needCallReplyAfterScroll(String r1, String r2);

    void onDiscussShareClick(String r1, String r2, String r3, String r4, String r5);

    void openDiscussDetailsPanel(String r1, String r2, String r3, String r4, int r5);
}
