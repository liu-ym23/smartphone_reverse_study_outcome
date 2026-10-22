package qtb;

import com.bytedance.lark.pb.feed.v1.FeedCursor;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListResponse;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends IOfficeSDKCapacity {
    GetDoubaoFeedListResponse Ra(FeedCursor r100, int r101);

    void v(List<String> r100);
}
