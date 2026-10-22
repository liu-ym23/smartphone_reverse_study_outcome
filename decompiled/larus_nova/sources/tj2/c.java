package tj2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface c {
    void a(ECV2AuctionInfo r100);

    void b(ECV2UpdatedCommentaryVideoInfo r100, List<Long> r101);

    boolean c(ECV2HotAtmosphere r100, ECV2InteractionData r101, List<Long> r102);

    void d(List<? extends ql.a> r100);
}
