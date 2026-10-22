package vp9;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.photopicker.v2.impl.viewmodel.MediaSelectorViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f556696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaSelectorViewModel f556697b;

    public t(RecyclerView r100, MediaSelectorViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "mediaSelectorViewModel");
        this.f556696a = r100;
        this.f556697b = r101;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (r103 >= 0.0f) goto L5;
        boolean r104 = true;
    L7:
        if ((!this.f556696a.canScrollVertically(-1)) == false) goto L11;
        if (r104 == false) goto L11;
        this.f556697b.notifyRecyclerViewCanScroll(false);
        return true;
    L11:
        this.f556697b.notifyRecyclerViewCanScroll(true);
        return super.onScroll(r100, r101, r102, r103);
    L5:
        r104 = false;
        goto L7
    }
}
