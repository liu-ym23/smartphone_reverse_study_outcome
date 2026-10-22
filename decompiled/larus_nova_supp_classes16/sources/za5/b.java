package za5;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class b implements a {
    public b() {
    }

    @Override // za5.a
    public void a(List<String> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "filePointerList");
    }

    @Override // za5.a
    public void b() {
    }

    @Override // za5.a
    public void c(List<? extends FileBean> r2) {
        Intrinsics.checkNotNullParameter(r2, "fileList");
    }
}
