package ye5;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    void createNewDiscuss(String r100, String r101, String r102);

    void deleteMainDiscuss(String r100);

    LiveData<Boolean> getCommentAble();

    LiveData<List<String>> getCurrentDiscussIds();

    String getCurrentRecordId();

    String getCurrentTableId();

    boolean needCallReplyAfterScroll(String r100, String r101);

    void onDiscussShareClick(String r100, String r101, String r102, String r103, String r104);

    void openDiscussDetailsPanel(String r100, String r101, String r102, String r103, int r104);
}
