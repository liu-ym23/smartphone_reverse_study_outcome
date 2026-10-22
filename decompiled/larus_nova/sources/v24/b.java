package v24;

import com.bytedance.awemeopen.bizmodels.feed.preload.AosConsumeCacheFeedListReason;
import com.bytedance.awemeopen.bizmodels.feed.preload.AosPreloadFeedListReason;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public interface b {
    w14.a a();

    boolean b();

    void c(AosPreloadFeedListReason r100, w24.b r101);

    List<r14.c> d(AosConsumeCacheFeedListReason r100);

    void e(Function1<? super List<r14.c>, Unit> r100);
}
