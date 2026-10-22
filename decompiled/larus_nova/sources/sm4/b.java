package sm4;

import com.bytedance.ee.android.file.picker.lib.v2.di.Default;
import com.ss.android.lark.log.Log;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<a> f542571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Provider<a>> f542572b;

    public final a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Provider<a> r101 = this.f542572b.get(r100);
        if (r101 != null) goto L7;
        Log.w("FilePickerV2", "File category [" + r100 + "] not registered");
        return this.f542571a.get();
    L7:
        return r101.get();
    }

    @Inject
    public b(@Default Provider<a> r100, Map<String, Provider<a>> r101) {
        Intrinsics.checkNotNullParameter(r100, "mDefault");
        Intrinsics.checkNotNullParameter(r101, "mMap");
        this.f542571a = r100;
        this.f542572b = r101;
    }
}
