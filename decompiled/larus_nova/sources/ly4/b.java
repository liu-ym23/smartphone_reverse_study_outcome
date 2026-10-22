package ly4;

import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.vfs.VFSPath;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends za5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalCoverSelectionFragment f511304a;

    public b(LocalCoverSelectionFragment r100) {
        this.f511304a = r100;
    }

    @Override // za5.b, za5.a
    public final void c(List<? extends FileBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "fileList");
        if ((!r100.isEmpty()) == false) goto L9;
        FileBean r101 = (FileBean) ListProtector.get(r100, 0);
        VFSPath r102 = ay4.d.a().z(r101.getPath());
        CoverViewModel r103 = this.f511304a.f217815e;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r103 = null;
    L7:
        r103.selectLocalImage("take_photo", LocalCoverSelectionFragment.U90(this.f511304a, r102, r101.getMimeType()));
        return;
    }
}
