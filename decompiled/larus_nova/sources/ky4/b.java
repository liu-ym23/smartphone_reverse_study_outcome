package ky4;

import android.view.View;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.doc.cover.selectcover.SelectCoverFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectCoverFragment f506634a;

    public b(SelectCoverFragment r100) {
        this.f506634a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CoverViewModel r101 = this.f506634a.f217802e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r101 = null;
    L5:
        r101.randomCover(2);
    }
}
