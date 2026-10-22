package com.bytedance.live.photoviewer.photoviewer;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.live.photoviewer.transition.TransitionLayout;
import com.bytedance.live.photoviewer.transition.TransitionPhotoDraweeView;
import com.bytedance.live.photoviewer.ui.LoadingLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zj6.f;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/live/photoviewer/photoviewer/PhotoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public final class PhotoVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransitionPhotoDraweeView f255659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoadingLayout f255660b;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoVH f255661a;

        public a(PhotoVH r100) {
            this.f255661a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            f r101 = this.f255661a.f255659a.f255719h;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("controllerImp");
        L5:
            r101.G.set(r101.f550404k);
            r101.r(true);
            return super.onSingleTapConfirmed(r100);
        }
    }

    public PhotoVH(TransitionLayout r100) {
        super(r100);
        TransitionPhotoDraweeView r101 = (TransitionPhotoDraweeView) r100.findViewById(R.id.photo_view);
        this.f255659a = r101;
        this.f255660b = (LoadingLayout) r100.findViewById(R.id.loading_view);
        r101.setHorizontalNestedScrollEnabled(true);
        r100.setDelegateDragTransitionView(r101);
        r101.setTapListener(new a(this));
    }
}
