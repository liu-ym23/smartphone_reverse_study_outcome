package vm4;

import com.bytedance.ee.android.file.picker.lib.v2.di.Default;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<a> f556341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Provider<a>> f556342b;

    @Inject
    public b(@Default Provider<a> r100, Map<String, Provider<a>> r101) {
        Intrinsics.checkNotNullParameter(r100, "mDefaultLoader");
        Intrinsics.checkNotNullParameter(r101, "mLoaders");
        this.f556341a = r100;
        this.f556342b = r101;
    }
}
