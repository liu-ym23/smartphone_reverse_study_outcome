package my4;

import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverSelectionFragment;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements CoverViewModel.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialCoverSelectionFragment f516372a;

    @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.b
    public final void onSuccess() {
        tt5.a.b("DocCover_OfficialCoverSelectionFragment", "fetchRemoteCoverData()... success");
    }

    public d(OfficialCoverSelectionFragment r100) {
        this.f516372a = r100;
    }

    @Override // com.bytedance.ee.bear.doc.cover.CoverViewModel.b
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        tt5.a.k("DocCover_OfficialCoverSelectionFragment", "fetchRemoteCoverData()... failed, error = " + r100.getMessage());
        OfficialCoverSelectionFragment r101 = this.f516372a;
        int r102 = OfficialCoverSelectionFragment.f217840m;
        r101.V90(false, true);
    }
}
