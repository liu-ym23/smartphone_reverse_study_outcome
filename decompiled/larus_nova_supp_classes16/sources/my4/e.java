package my4;

import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverSelectionFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements g {
    public final /* synthetic */ OfficialCoverSelectionFragment a;

    public e(OfficialCoverSelectionFragment r1) {
        this.a = r1;
    }

    @Override // my4.g
    public final void onClick(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "coverToken");
        CoverViewModel r0 = this.a.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r0 = null;
    L5:
        r0.selectOfficialCover(2, r3, r4);
    }
}
