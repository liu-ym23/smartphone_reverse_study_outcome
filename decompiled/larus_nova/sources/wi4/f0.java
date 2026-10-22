package wi4;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.creativex.mediaimport.view.internal.IMediaSelectDragCloseView$Event;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.tools.view.widget.ViewPagerBottomSheetBehavior;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPagerBottomSheetBehavior<View> f559804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<IMediaSelectDragCloseView$Event> f559805b;

    public static final class a extends ViewPagerBottomSheetBehavior.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f559806a;

        @Override // com.ss.android.ugc.tools.view.widget.ViewPagerBottomSheetBehavior.c
        public final void b(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        public a(f0 r100) {
            this.f559806a = r100;
        }

        @Override // com.ss.android.ugc.tools.view.widget.ViewPagerBottomSheetBehavior.c
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            this.f559806a.f559805b.onNext(IMediaSelectDragCloseView$Event.PRE_CLOSE);
        }

        @Override // com.ss.android.ugc.tools.view.widget.ViewPagerBottomSheetBehavior.c
        public final void c(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 1) goto L5;
            this.f559806a.f559805b.onNext(IMediaSelectDragCloseView$Event.DRAGGING);
            return;
        L5:
            if (r101 != 5) goto L11;
            this.f559806a.f559805b.onNext(IMediaSelectDragCloseView$Event.CLOSED);
            return;
        }
    }

    public f0(final View r100, ViewPager r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "viewPager");
        this.f559805b = PublishSubject.create();
        CoordinatorLayout.LayoutParams r103 = null;
        if (r102 == false) goto L10;
        ViewPagerBottomSheetBehavior<View> r104 = new ViewPagerBottomSheetBehavior(r100.getContext());
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof CoordinatorLayout.LayoutParams) == false) goto L7;
        r103 = (CoordinatorLayout.LayoutParams) r105;
    L7:
        if (r103 == null) goto L9;
        r103.setBehavior(r104);
    L9:
        this.f559804a = r104;
        r100.post(new e0(this, r100));
        r104.f455091h = true;
        r101.addOnPageChangeListener(new ViewPagerBottomSheetBehavior.d(r101, r104));
        r104.f455101r = new a(this);
        return;
    L10:
        this.f559804a = null;
    }
}
