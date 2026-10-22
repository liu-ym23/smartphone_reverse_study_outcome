package vj6;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.live.photoviewer.game.PhotoViewerDialogActivity;
import com.bytedance.live.photoviewer.photoviewer.PhotoViewerListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements zj6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewerDialogActivity f555418a;

    @Override // zj6.c
    public final void onTransitionBegin(int r100) {
    }

    public a(PhotoViewerDialogActivity r100) {
        this.f555418a = r100;
    }

    @Override // zj6.c
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L17;
        RecyclerView r101 = this.f555418a.f255636a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L6:
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
        if (r102 == null) goto L15;
        PhotoViewerDialogActivity r103 = this.f555418a;
        int r104 = ((LinearLayoutManager) r102).findFirstCompletelyVisibleItemPosition();
        PhotoViewerDialogActivity.c r105 = r103.f255644i;
        if (r105 == null) goto L11;
        r105.a(r104);
    L11:
        PhotoViewerListener r106 = r103.f255647l;
        if (r106 == null) goto L17;
        r106.onPageSelected(r104);
        goto L17
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    L17:
        if (r100 != 2) goto L20;
        this.f555418a.finish();
        return;
    }

    @Override // zj6.c
    public final void onTransitionChanged(int r100, float r101) {
        ViewGroup r102 = this.f555418a.f255637b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
    L5:
        r102.getBackground().setAlpha((int) (255 * r101));
        View r103 = this.f555418a.f255640e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mClTopView");
    L8:
        r103.setAlpha(r101);
        this.f555418a.getWindow().setDimAmount(r101);
    }
}
