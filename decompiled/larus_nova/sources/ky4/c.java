package ky4;

import android.view.View;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.SelectCoverFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectCoverFragment f506635a;

    public c(SelectCoverFragment r100) {
        this.f506635a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SelectCoverFragment r101 = this.f506635a;
        int r102 = SelectCoverFragment.f217801h;
        CoverViewModel r103 = r101.f217802e;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r103 = null;
    L5:
        r103.getSelectCoverActive().setValue(Boolean.FALSE);
    }
}
