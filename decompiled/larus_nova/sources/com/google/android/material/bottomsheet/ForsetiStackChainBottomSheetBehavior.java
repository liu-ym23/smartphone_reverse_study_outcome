package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002\u0017\u0018B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/google/android/material/bottomsheet/ForsetiStackChainBottomSheetBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isLockedToHidden", "", "findScrollingChild", "view", "setState", "", "state", "", "findScrollingChildFromViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "lockToHidden", "Companion", "TrackingScrollingChildOnPageChangeListener", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiStackChainBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public static final Companion Companion = null;
    private static final String TAG = "ForsetiStackChainBottomSheetBehavior";
    private boolean isLockedToHidden;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/android/material/bottomsheet/ForsetiStackChainBottomSheetBehavior$Companion;", "", "<init>", "()V", "TAG", "", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/google/android/material/bottomsheet/ForsetiStackChainBottomSheetBehavior$TrackingScrollingChildOnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "<init>", "(Lcom/google/android/material/bottomsheet/ForsetiStackChainBottomSheetBehavior;Landroidx/viewpager/widget/ViewPager;)V", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TrackingScrollingChildOnPageChangeListener implements ViewPager.OnPageChangeListener {
        final /* synthetic */ ForsetiStackChainBottomSheetBehavior<V> this$0;
        private final ViewPager viewPager;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r100) {
        }

        public TrackingScrollingChildOnPageChangeListener(ForsetiStackChainBottomSheetBehavior r100, ViewPager r101) {
            Intrinsics.checkNotNullParameter(r101, "viewPager");
            this.this$0 = r100;
            this.viewPager = r101;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r100, float r101, int r102) {
            if (r102 != 0) goto L5;
            ForsetiStackChainBottomSheetBehavior<V> r103 = this.this$0;
            r103.nestedScrollingChildRef = new WeakReference(ForsetiStackChainBottomSheetBehavior.access$findScrollingChildFromViewPager(this.this$0, this.viewPager));
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void lockToHidden() {
        this.isLockedToHidden = true;
    }

    public ForsetiStackChainBottomSheetBehavior() {
    }

    private final View findScrollingChildFromViewPager(ViewPager r100) {
        int r101 = r100.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        View r103 = r100.getChildAt(r102);
        if (r103.isAttachedToWindow() == false) goto L10;
        if ((((int) r103.getX()) - r100.getScrollX()) != 0) goto L10;
        return findScrollingChild(r103);
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public View findScrollingChild(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewPager) == false) goto L13;
        ViewPager r101 = (ViewPager) r100;
        if ((r101.getTag() instanceof TrackingScrollingChildOnPageChangeListener) == true) goto L11;
        TrackingScrollingChildOnPageChangeListener r102 = new TrackingScrollingChildOnPageChangeListener(this, r101);
        r101.addOnPageChangeListener(r102);
        r101.setTag(r102);
    L11:
        return findScrollingChildFromViewPager(r101);
    L13:
        if ((r100 instanceof ViewGroup) == false) goto L20;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount() - 1;
    L15:
        if (r104 < 0) goto L24;
        View r105 = findScrollingChild(r103.getChildAt(r104));
        if (r105 != null) goto L18;
        r104 = r104 - 1;
        goto L15
    L18:
        return r105;
    L24:
        return null;
    L20:
        return null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setState(int r100) {
        if (this.isLockedToHidden == true) goto L5;
    L8:
        super.setState(r100);
        return;
    L5:
        if (r100 == 5) goto L8;
        Log.i(TAG, "setState: " + r100 + " returns for isLockedToHidden");
    }

    public ForsetiStackChainBottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public static final /* synthetic */ View access$findScrollingChildFromViewPager(ForsetiStackChainBottomSheetBehavior r100, ViewPager r101) {
        return r100.findScrollingChildFromViewPager(r101);
    }
}
