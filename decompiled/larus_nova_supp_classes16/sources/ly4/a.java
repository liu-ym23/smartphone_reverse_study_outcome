package ly4;

import com.bytedance.ee.bear.doc.cover.CoverConstants$CoverSource;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.vfs.VFSPath;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends za5.b {
    public final /* synthetic */ LocalCoverSelectionFragment a;

    public a(LocalCoverSelectionFragment r1) {
        this.a = r1;
    }

    @Override // za5.b, za5.a
    public final void c(List<? extends FileBean> r4) {
        Intrinsics.checkNotNullParameter(r4, "fileList");
        if ((!r4.isEmpty()) == false) goto L9;
        FileBean r5 = (FileBean) ListProtector.get(r4, 0);
        VFSPath r0 = ay4.d.a().z(r5.getPath());
        CoverViewModel r1 = this.a.e;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r1 = null;
    L7:
        r1.selectLocalImage(CoverConstants$CoverSource.ALBUM, LocalCoverSelectionFragment.U90(this.a, r0, r5.getMimeType()));
        return;
    }
}
