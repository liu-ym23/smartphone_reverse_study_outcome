package q73;

import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static final r a(ImageMonitorMeta r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toImageCallerContext");
        return new r(r100.getImageBiz(), r100.getImageScene());
    }
}
