package d75;

import com.bytedance.ee.bear.drive.biz.versions.VersionHistoryRepository;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d implements Function {
    public final /* synthetic */ VersionHistoryRepository.Params a;

    public /* synthetic */ d(VersionHistoryRepository.Params r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("VersionHistoryRepository", "VersionHistoryRepository.fetchHistory() error, params: " + this.a, r5, false);
        return Flowable.error(r5);
    }
}
