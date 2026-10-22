package za5;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class b implements a {
    public b() {
    }

    @Override // za5.a
    public void a(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "filePointerList");
    }

    @Override // za5.a
    public void b() {
    }

    @Override // za5.a
    public void c(List<? extends FileBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "fileList");
    }
}
