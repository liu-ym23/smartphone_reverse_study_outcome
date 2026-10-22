package tj2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {
    void a(ECV2AuctionInfo r1);

    void b(ECV2UpdatedCommentaryVideoInfo r1, List<Long> r2);

    boolean c(ECV2HotAtmosphere r1, ECV2InteractionData r2, List<Long> r3);

    void d(List<? extends ql.a> r1);
}
