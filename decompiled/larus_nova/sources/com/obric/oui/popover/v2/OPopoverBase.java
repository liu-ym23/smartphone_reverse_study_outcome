package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public interface OPopoverBase<T> {
    public static final a D1 = null;

    public static final class StackController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StackController f402325a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final List<WeakReference<OPopoverBase<?>>> f402326b = null;

        public StackController() {
        }

        public final synchronized void a() {
            monitor-enter(this);
            CollectionsKt.removeAll(f402326b, OPopoverBase$StackController$cleanupStackLocked$1.INSTANCE);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        static {
            f402325a = new StackController();
            f402326b = new ArrayList();
        }

        public final synchronized OPopoverBase<?> c(OPopoverBase<?> r100) {
            monitor-enter(this);
            a();     // Catch: Throwable -> L19
            int r101 = ((ArrayList) f402326b).size() - 1;     // Catch: Throwable -> L19
            if (r101 < 0) goto L16;
        L5:
            int r102 = r101 - 1;     // Catch: Throwable -> L19
            OPopoverBase<?> r103 = (OPopoverBase) ((WeakReference) ListProtector.get(f402326b, r101)).get();     // Catch: Throwable -> L19
            if (r103 == null) goto L11;
            if (r100 == null) goto L14;
            if (r103 == r100) goto L11;
        L14:
            monitor-exit(this);
            return r103;
        L11:
            if (r102 < 0) goto L16;
            r101 = r102;
        L16:
            monitor-exit(this);
            return null;
        L19:
            th = move-exception;
            throw th;
        }

        public final synchronized void b(OPopoverBase r100, float r101, float r102) {
            monitor-enter(this);
            OPopoverBase<?> r103 = c(r100);     // Catch: Throwable -> L11
            if (r103 != null) goto L8;
            monitor-exit(this);
            return;
        L8:
            f.a(r103, false, r101, r102);     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f402327a = null;

        static {
            f402327a = new a();
        }

        public a() {
        }

        public static void a(View r100, int r101) {
            if ((r100 instanceof OPopoverMenuView) == false) goto L6;
            ((OPopoverMenuView) r100).setPopoverMaxHeight(r101);
        L6:
            if ((r100 instanceof ViewGroup) == false) goto L11;
            Iterator<View> r102 = ViewGroupKt.getChildren((ViewGroup) r100).iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            a(r102.next(), r101);
            goto L9
        L13:
            return;
        }
    }

    public static final class b {
        public static <T> void a(OPopoverBase<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            AnimatorSet r101 = r100.getPopoverAnimator();
            if (r101 == null) goto L6;
            r101.cancel();
        L6:
            r100.setPopoverAnimator(null);
        }

        public static <T> void d(final OPopoverBase<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            if (r100.getPopoverRemovedFromStack() == false) goto L5;
            return;
        L5:
            r100.setPopoverRemovedFromStack(true);
            StackController r101 = StackController.f402325a;
            monitor-enter(r101);
            Intrinsics.checkNotNullParameter(r100, "current");     // Catch: Throwable -> L13
            r101.a();     // Catch: Throwable -> L13
            CollectionsKt.removeAll(StackController.f402326b, new OPopoverBase$StackController$onDismiss$1(r100));     // Catch: Throwable -> L13
            OPopoverBase<?> r102 = r101.c(null);     // Catch: Throwable -> L13
            if (r102 == null) goto L11;
            f.a(r102, true, 1.0f, 1.0f);     // Catch: Throwable -> L13
        L11:
            monitor-exit(r101);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public static <T> void h(OPopoverBase<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "this");
            r100.e(r100.getContentViewInternal(), 0, 0);
            r100.getPopoverWindowFrame().setPivotX(r100.g(r100.getPopoverAnchorCenterX(), r100.getPopoverPopupOriginX(), r100.getPopoverWindowFrame().getMeasuredWidth() / 2.0f));
            r100.getPopoverWindowFrame().setPivotY(r100.g(r100.getPopoverAnchorCenterY(), r100.getPopoverPopupOriginY(), r100.getPopoverWindowFrame().getMeasuredHeight() / 2.0f));
        }

        public static <T> void e(OPopoverBase<T> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            int r102 = c.G;
            r100.setPopoverGravity(c.b.a(r101));
        }

        public static <T> OPopoverLayout b(OPopoverBase<T> r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "this");
            Intrinsics.checkNotNullParameter(r101, "contentView");
            Context r103 = r100.getPopoverContext();
            boolean r104 = r100.getPopoverEnableBubbleMaterial();
            Function1<Boolean, com.obric.oui.material.c[]> r105 = r100.getPopoverMaterials();
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, "materials");
            OPopoverLayout r106 = new OPopoverLayout(r103, null, r104, r105, r102);
            boolean r107 = false;
            r106.setBackgroundColor(0);
            r106.setGravity(17);
            a r108 = OPopoverBase.D1;
            Context r109 = r100.getPopoverContext();
            int r110 = r100.getPopoverDisplayOrientation();
            r108.getClass();
            if (r110 != 1) goto L5;
            float r111 = 90.0f;
        L10:
            if (r111 != 0.0f) goto L12;
            boolean r112 = true;
        L13:
            if (r112 == true) goto L16;
            j r113 = new j(r109);
            r113.setOrientationAngle(r111);
            r113.addView(r101);
            r101 = r113;
        L16:
            r106.addView(r101);
            r106.setCornerRadius(pla.d.d(r100.getPopoverContext(), 28.0f));
            if (r100.getPopoverBgColor() == 0) goto L20;
            r106.setBgColor(r100.getPopoverBgColor());
        L20:
            if (r106.f402341m == true) goto L22;
        L24:
            if (r107 == true) goto L26;
            r106.setBorderColor(r100.getPopoverBorderColor());
            r106.setBorderWidth(r100.getPopoverBorderWidth());
        L26:
            r106.setTransparentBg(r100.getPopoverTransparentBg());
            return r106;
        L22:
            if (r106.f402340l == false) goto L24;
            r107 = true;
            goto L24
        L12:
            r112 = false;
            goto L13
        L5:
            if (r110 == 3) goto L7;
            r111 = 0.0f;
            goto L10
        L7:
            r111 = 270.0f;
            goto L10
        }

        public static void f(OPopoverBase r100, int r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "this");
            Intrinsics.checkNotNullParameter(r102, "measureTarget");
            if (r101 > 0) goto L5;
            return;
        L5:
            int r103 = RangesKt.coerceAtLeast(r101 - (r100.getPopoverBubbleLayout().getArrowHeight() * 2), 0);
            a r104 = OPopoverBase.D1;
            OPopoverLayout r105 = r100.getPopoverBubbleLayout();
            r104.getClass();
            a.a(r105, r103);
            r100.getPopoverBubbleLayout().requestLayout();
            r100.e(r102, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        public static <T> void c(OPopoverBase<T> r100, View r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "this");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            if (r100.getPopoverWidth() != 0) goto L5;
        L7:
            r101.measure(r102, r103);
            return;
        L5:
            if (r100.getPopoverHeight() == 0) goto L7;
            r101.measure(View.MeasureSpec.makeMeasureSpec(r100.getPopoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r100.getPopoverHeight(), 1073741824));
        }

        /* JADX WARN: Type inference failed for: r1v7, types: [T, com.obric.oui.animation.easy.b] */
        public static AnimatorSet g(OPopoverBase r110, boolean r111, int r112, Animator r113, Function0 r114, Function0 r115) {
            Intrinsics.checkNotNullParameter(r110, "this");
            r110.b();
            f.b r100 = f.f402406a;
            final ViewGroup r116 = r110.getPopoverWindowFrame();
            float r101 = r110.getPopoverWindowFrame().getPivotX();
            float r102 = r110.getPopoverWindowFrame().getPivotY();
            Intrinsics.checkNotNullParameter(r116, "view");
            r116.setPivotX(r101);
            r116.setPivotY(r102);
            boolean r103 = false;
            r116.setVisibility(0);
            AnimatorSet r117 = new AnimatorSet();
            Ref.ObjectRef r118 = new Ref.ObjectRef();
            if (r113 == null) goto L5;
            r117.play(r113);
        L62:
            r117.addListener(new g(r111, r116, r118, r114, r115));
            r117.start();
            return r117;
        L5:
            PathInterpolator r104 = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
            if (r111 == false) goto L8;
            float r105 = 0.0f;
        L9:
            if (r111 == false) goto L11;
            float r106 = 1.0f;
        L13:
            if (r116.getAlpha() != 0.0f) goto L15;
            boolean r107 = true;
        L16:
            if (r107 == false) goto L18;
        L23:
            ObjectAnimator r108 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{r105, r106});
            r108.setInterpolator(r104);
            r108.setDuration(100);
            r117.play(r108);
            float r109 = 0.2f;
            if (r111 == false) goto L26;
            final float r119 = 0.2f;
        L27:
            if (r111 == false) goto L30;
            r109 = 1.0f;
        L30:
            if (r112 == 48) goto L32;
            int r120 = 1;
        L34:
            if (r111 == false) goto L36;
            float r121 = -pla.d.q(r116, 10);
        L37:
            float r122 = r120;
            final float r123 = r121 * r122;
            if (r111 == false) goto L40;
            float r124 = 0.0f;
        L41:
            final float r125 = r124 * r122;
            if (r111 == false) goto L44;
            final float r126 = 0.0f;
        L45:
            if (r111 == false) goto L47;
            final float r127 = 10000.0f;
        L48:
            Collection r128 = ((LinkedHashMap) com.obric.oui.animation.easy.f.a(r116).f398740c).values();
            if ((r128 instanceof Collection) == true) goto L51;
        L53:
            Iterator<T> r129 = r128.iterator();
        L55:
            if (r129.hasNext() == false) goto L59;
            if (((jla.d) r129.next()).f499583f == false) goto L55;
            r103 = true;
        L59:
            if (r103 == true) goto L61;
            r116.setScaleX(r119);
            r116.setScaleY(r119);
            r116.setTranslationY(r123);
            r116.setTag(R.id.o_popover_anim_p, new f.a(r126));
        L61:
            ?? r130 = (T) com.obric.oui.animation.easy.f.a(r116);
            r130.f398741d = 0.85f;
            r130.f398742e = 632.0f;
            f.b r131 = f.f402406a;
            com.obric.oui.animation.easy.b.b(r130, r127);
            final float r132 = r109;
            jla.b.j r133 = new e(r116, r126, r127, r119, r132, r123, r125);
            Intrinsics.checkNotNullParameter(r133, "listener");
            r130.f398744g = r133;
            r118.element = r130;
            goto L62
        L51:
            if (r128.isEmpty() == false) goto L53;
        L47:
            r127 = 0.0f;
            goto L48
        L44:
            r126 = 10000.0f;
            goto L45
        L40:
            r124 = -pla.d.q(r116, 10);
            goto L41
        L36:
            r121 = 0.0f;
            goto L37
        L32:
            r120 = -1;
            goto L34
        L26:
            r119 = 1.0f;
            goto L27
        L18:
            if (r116.getAlpha() != 1.0f) goto L20;
            boolean r134 = true;
        L21:
            if (r134 == true) goto L23;
            r105 = r116.getAlpha();
            goto L23
        L20:
            r134 = false;
            goto L21
        L15:
            r107 = false;
            goto L16
        L11:
            r106 = 0.0f;
            goto L13
        L8:
            r105 = 1.0f;
            goto L9
        }
    }

    static {
        D1 = a.f402327a;
    }

    boolean a();

    void b();

    void c(int r100, View r101);

    void d();

    void e(View r100, int r101, int r102);

    void f();

    float g(float r100, int r101, float r102);

    View getContentViewInternal();

    float getPopoverAnchorCenterX();

    float getPopoverAnchorCenterY();

    long getPopoverAnimationDurationMillis();

    AnimatorSet getPopoverAnimator();

    int getPopoverBgColor();

    int getPopoverBorderColor();

    int getPopoverBorderWidth();

    OPopoverLayout getPopoverBubbleLayout();

    Context getPopoverContext();

    int getPopoverDisplayOrientation();

    boolean getPopoverEnableBubbleMaterial();

    int getPopoverHeight();

    Function1<Boolean, com.obric.oui.material.c[]> getPopoverMaterials();

    int getPopoverPopupOriginX();

    int getPopoverPopupOriginY();

    boolean getPopoverPushedToStack();

    boolean getPopoverRemovedFromStack();

    boolean getPopoverShowWithAnimation();

    boolean getPopoverTransparentBg();

    int getPopoverWidth();

    ViewGroup getPopoverWindowFrame();

    void setPopoverAnimator(AnimatorSet r100);

    void setPopoverGravity(int r100);

    void setPopoverPushedToStack(boolean r100);

    void setPopoverRemovedFromStack(boolean r100);

    void setPopoverXOffset(int r100);

    void setPopoverYOffset(int r100);
}
