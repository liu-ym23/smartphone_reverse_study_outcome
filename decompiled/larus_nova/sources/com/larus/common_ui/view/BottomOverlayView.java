package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0011J$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J \u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0014J\b\u0010(\u001a\u00020\u0014H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/view/BottomOverlayView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialTouchX", "", "initialTouchY", "initHeight", "downEvent", "Landroid/view/MotionEvent;", "isScrolling", "", "_isSwipeDown", "initViewInfo", "", "isSwipeDown", "initMenuOnlyTouchListener", TplType.MENU, "attachParent", "Landroid/view/ViewGroup;", "sourceRoot", "createMenuOnlyLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "left", "top", "initBottomSheetAndMenuTouchListener", DocumentType.SHEET_NAME, "coordinator", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "updateHeight", "newHeight", "resetHeight", "onDetachedFromWindow", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomOverlayView extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f328131g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f328132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f328133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f328134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MotionEvent f328135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f328136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f328137f;

    public static final class a {
    }

    static {
    }

    public BottomOverlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomOverlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        MotionEvent r100 = this.f328135d;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f328135d = null;
    }

    public BottomOverlayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public static final void b(Rect r100, View r101, MotionEvent r102) {
        Rect r103 = new Rect();
        r101.getGlobalVisibleRect(r103);
        int r104 = r100.left - r103.left;
        int r105 = r100.top - r103.top;
        MotionEvent r106 = MotionEvent.obtain(r102);
        r106.offsetLocation(r104, r105);
        r101.dispatchTouchEvent(r106);
        r106.recycle();
    }

    public final void a(final View r110, View r111, final CoordinatorLayout r210) {
        Intrinsics.checkNotNullParameter(r110, TplType.MENU);
        Intrinsics.checkNotNullParameter(r111, DocumentType.SHEET_NAME);
        Intrinsics.checkNotNullParameter(r210, "coordinator");
        this.f328132a = 0.0f;
        this.f328133b = 0.0f;
        this.f328135d = null;
        this.f328136e = false;
        this.f328137f = false;
        final Rect r100 = new Rect();
        r110.getGlobalVisibleRect(r100);
        final Rect r101 = new Rect();
        r111.getGlobalVisibleRect(r101);
        final Rect r102 = new Rect(r100);
        r102.union(r101);
        final float r103 = r111.getX() + (r111.getWidth() / 2.0f);
        final float r104 = r111.getY() + (r111.getHeight() / 2.0f);
        int r105 = r100.width();
        int r112 = r102.width();
        int r113 = Math.abs(r100.left - r101.left);
        FLogger r114 = FLogger.f375446a;
        r114.i("BottomOverlayView", "initCover menuRect:" + r100 + " sheetRect:" + r101 + " coverRect:" + r102 + " menuW:" + r105 + " coverW:" + r112 + " gap:" + r113);
        if (r105 > 0) goto L5;
    L7:
        setLayoutParams(new ViewGroup.LayoutParams(r102.width(), r102.height()));
        this.f328134c = r102.height();
        setX(r102.left);
        setY(r102.top);
        setBackgroundColor(0);
        setOnTouchListener(new b(this, r102, r101, r210, r100, r110, r103, r104));
        return;
    L5:
        if (r112 <= (r105 * 1.5f)) goto L7;
        r114.e("BottomOverlayView", "cover_width_abnormal menuRect:" + r100 + " sheetRect:" + r101 + " coverRect:" + r102 + " menuW:" + r105 + " coverW:" + r112);
        goto L7
    }

    public /* synthetic */ BottomOverlayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void c(BottomOverlayView r100, CoordinatorLayout r101, float r102, float r103, MotionEvent r104) {
        float r105 = r104.getY() - r100.f328133b;
        MotionEvent r106 = MotionEvent.obtain(r104);
        r106.setLocation(r102, r103 + r105);
        r101.dispatchTouchEvent(r106);
        r106.recycle();
    }
}
