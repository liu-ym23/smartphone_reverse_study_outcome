package my4;

import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverSelectionFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements CoverViewModel.b {
    public final /* synthetic */ OfficialCoverSelectionFragment a;

    @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.b
    public final void onSuccess() {
        tt5.a.b("DocCover_OfficialCoverSelectionFragment", "fetchRemoteCoverData()... success");
    }

    public d(OfficialCoverSelectionFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.b
    public final void onFailure(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        tt5.a.k("DocCover_OfficialCoverSelectionFragment", "fetchRemoteCoverData()... failed, error = " + r3.getMessage());
        OfficialCoverSelectionFragment r4 = this.a;
        int r0 = OfficialCoverSelectionFragment.m;
        r4.V90(false, true);
    }
}
