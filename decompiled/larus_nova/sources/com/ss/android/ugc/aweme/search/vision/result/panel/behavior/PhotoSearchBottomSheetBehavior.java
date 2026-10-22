package com.ss.android.ugc.aweme.search.vision.result.panel.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\n\u000bB!\b\u0007\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/behavior/PhotoSearchBottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/ss/android/ugc/aweme/search/vision/result/panel/behavior/ECPhotoSearchBottomSheetBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "SettleToStateRunnable", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoSearchBottomSheetBehavior<V extends View> extends ECPhotoSearchBottomSheetBehavior<V> {
    public static final Companion F = null;
    public final PhotoSearchBottomSheetBehavior$mFactory$1 C;
    public Integer D;
    public int E;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/behavior/PhotoSearchBottomSheetBehavior$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/behavior/PhotoSearchBottomSheetBehavior$SettleToStateRunnable;", "Ljava/lang/Runnable;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SettleToStateRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f453721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f453722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PhotoSearchBottomSheetBehavior f453723c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f453723c.f453698l;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f453723c.setStateInternal(this.f453722b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f453721a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public SettleToStateRunnable(PhotoSearchBottomSheetBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f453723c = r100;
            this.f453721a = r101;
            this.f453722b = r102;
        }
    }

    static {
        F = new Companion(0);
    }

    public PhotoSearchBottomSheetBehavior() {
        this(null, null);
    }

    public final void e() {
        WeakReference<V> r100 = this.f453703q;
        if (r100 == null) goto L5;
        V r101 = r100.get();
    L7:
        if (r101 != null) goto L10;
        this.f453697k = 7;
        return;
    L10:
        Integer r102 = this.D;
        if (r102 == null) goto L19;
        int r103 = r102.intValue();
        ViewDragHelper r104 = this.f453698l;
        if (r104 != null) goto L15;
    L17:
        setStateInternal(7);
        return;
    L15:
        if (r104.smoothSlideViewTo(r101, r101.getLeft(), r103) == false) goto L17;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new SettleToStateRunnable(this, r101, 7));
        return;
    L19:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.ss.android.ugc.aweme.search.vision.result.panel.behavior.ECPhotoSearchBottomSheetBehavior
    public final boolean d(View r100) {
        if (r100 == null) goto L5;
        int r101 = r100.getTop();
    L6:
        int r102 = this.f453711y;
        if (r101 > (r102 + (((this.f453710x - r102) / 4.0f) * 3))) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        return true;
    L13:
        return false;
    L9:
        r103 = false;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.search.vision.result.panel.behavior.ECPhotoSearchBottomSheetBehavior
    public final void setStateInternal(int r100) {
        if (r100 != 1) goto L5;
    L7:
        super.setStateInternal(r100);
        return;
    L5:
        if (r100 == 2) goto L7;
        this.E = r100;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.ss.android.ugc.aweme.search.vision.result.panel.behavior.PhotoSearchBottomSheetBehavior$mFactory$1] */
    public PhotoSearchBottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.C = new PhotoSearchBottomSheetBehavior$mFactory$1();
        this.E = 4;
    }

    @Override // com.ss.android.ugc.aweme.search.vision.result.panel.behavior.ECPhotoSearchBottomSheetBehavior
    public final ViewDragHelper a(CoordinatorLayout r100, ViewDragHelper.Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "callback");
        PhotoSearchBottomSheetBehavior$mFactory$1 r102 = this.C;
        int r103 = ECBottomSheetPanelViewDragHelper.f453686a;
        Intrinsics.checkNotNullParameter(r100, "forParent");
        Intrinsics.checkNotNullParameter(r102, "interpolatorFactory");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ViewDragHelper r104 = ViewDragHelper.create(r100, r101);
        Field r105 = r104.getClass().getDeclaredField("mScroller");     // Catch: Exception -> L5
        r105.setAccessible(true);     // Catch: Exception -> L5
        Context r106 = r100.getContext();     // Catch: Exception -> L5
        r102.getClass();     // Catch: Exception -> L5
        r105.set(r104, new OverScroller(r106, PhotoSearchBottomSheetBehavior$mFactory$1$create$1.f453724a));     // Catch: Exception -> L5
    L4:
        return r104;
    }

    @Override // com.ss.android.ugc.aweme.search.vision.result.panel.behavior.ECPhotoSearchBottomSheetBehavior
    public final boolean shouldHide(View r100, float r101) {
        if (this.f453696j == false) goto L5;
        return true;
    L5:
        int r102 = this.f453711y;
        float r103 = r102 + ((this.f453710x - r102) / 3.0f);
        if (r100 == null) goto L8;
        int r104 = r100.getTop();
    L9:
        float r105 = r104;
        if (r105 < r103) goto L12;
        return true;
    L12:
        float r106 = r105 + (r101 * 0.1f);
        int r107 = this.f453688b;
        if (r107 != 0) goto L17;
        r107 = this.f453689c;
    L17:
        if ((Math.abs(r106 - this.f453693g) / r107) > 0.5f) goto L21;
        return false;
    L21:
        return true;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.search.vision.result.panel.behavior.ECPhotoSearchBottomSheetBehavior
    public final void c(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "releasedChild");
        if (this.f453697k != 7) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L9:
        Integer r104 = this.D;
        if (r104 != null) goto L12;
    L35:
        super.c(r100, r101, r102);
        return;
    L12:
        if (r102 >= 0) goto L14;
    L22:
        int r105 = 3;
    L23:
        if (r105 == 3) goto L27;
        if (r105 == 5) goto L26;
        int r106 = this.f453693g;
    L28:
        ViewDragHelper r107 = this.f453698l;
        if (r107 != null) goto L31;
    L33:
        setStateInternal(r105);
        return;
    L31:
        if (r107.settleCapturedViewAt(r100.getLeft(), r106) == false) goto L33;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new SettleToStateRunnable(this, r100, r105));
        return;
    L26:
        r106 = b();
        goto L28
    L27:
        r106 = this.f453692f;
        goto L28
    L14:
        if (r100.getTop() <= r104.intValue()) goto L22;
        if (this.f453694h == true) goto L19;
    L21:
        r105 = 4;
        goto L23
    L19:
        if (shouldHide(r100, r102) == false) goto L21;
        r105 = 5;
        goto L23
    L8:
        if (this.E != 7) goto L35;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.search.vision.result.panel.behavior.ECPhotoSearchBottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.onLayoutChild(r100, r101, r102);
        Integer r103 = this.D;
        if (this.f453697k != 7) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L11;
        if (r103 == null) goto L11;
        if (r101.getTop() == r103.intValue()) goto L11;
        ViewCompat.offsetTopAndBottom(r101, r103.intValue() - r101.getTop());
    L11:
        return true;
    L5:
        r104 = false;
        goto L6
    }
}
