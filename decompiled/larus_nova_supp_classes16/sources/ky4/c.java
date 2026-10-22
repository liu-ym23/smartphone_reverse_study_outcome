package ky4;

import android.view.View;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.SelectCoverFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ SelectCoverFragment a;

    public c(SelectCoverFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SelectCoverFragment r3 = this.a;
        int r0 = SelectCoverFragment.h;
        CoverViewModel r4 = r3.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r4 = null;
    L5:
        r4.getSelectCoverActive().setValue(Boolean.FALSE);
    }
}
