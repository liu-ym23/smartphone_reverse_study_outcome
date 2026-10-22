package w05;

import com.bytedance.ee.bear.list.dto.DocVersion;
import io.reactivex.Flowable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Singleton
public final class e implements d {
    @Inject
    public e() {
    }

    @Override // w05.d
    public final Flowable a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        return Flowable.just(new DocVersion(5));
    }
}
