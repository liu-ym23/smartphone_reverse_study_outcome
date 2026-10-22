package my4;

import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverSelectionFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialCoverSelectionFragment f516373a;

    public e(OfficialCoverSelectionFragment r100) {
        this.f516373a = r100;
    }

    @Override // my4.g
    public final void onClick(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "coverToken");
        CoverViewModel r102 = this.f516373a.f217842f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r102 = null;
    L5:
        r102.selectOfficialCover(2, r100, r101);
    }
}
