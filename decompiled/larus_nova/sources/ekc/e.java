package ekc;

import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IGetDataCallback<String> f472972a;

    public e(String r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f472972a = r101;
    }
}
