package dx1;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    FeedbackCard getLiveRoomFeedback(long r100);

    FeedbackCard getPreviewFeedback(long r100);

    FeedItem getRoomFeedback(long r100);

    void insertLiveRoomFeedback(long r100, Function1<? super FeedbackCard, Unit> r101);

    void insertRoomFeedback(long r100, Function1<? super FeedItem, Unit> r101);

    void onReadFeedback(FeedItem r100);

    void removeLiveRoomFeedback(long r100, Function1<? super FeedbackCard, Unit> r101);

    void removePreviewFeedback(long r100);

    void removeRoomFeedback(long r100, Function1<? super FeedItem, Unit> r101);

    void saveLiveRoomFeedback(long r100, FeedbackCard r101);

    void savePreviewFeedback(long r100, Bundle r101);

    void saveRoomFeedback(long r100, FeedItem r101);

    void saveUnReadFeedback(FeedItem r100, String r101);
}
