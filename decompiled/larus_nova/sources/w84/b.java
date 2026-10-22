package w84;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import x84.f;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558623a = 0;

    static {
    }

    public static float a(com.bytedance.bdnavigationsdk.pojo.a r100, com.bytedance.bdnavigationsdk.pojo.a r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        return (float) com.bytedance.bdnavigationsdk.utils.b.a(x84.d.c(new f(r100.f200331b, r100.f200330a), new f(r101.f200331b, r101.f200330a), "meters"), 2);
    }
}
