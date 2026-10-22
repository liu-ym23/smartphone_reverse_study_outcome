package um4;

import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Provider<a>> f550663a;

    @Inject
    public b(Map<String, Provider<a>> r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataSourceProviders");
        this.f550663a = r100;
    }
}
