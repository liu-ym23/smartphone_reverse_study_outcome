package com.larksuite.framework.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 5*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u000256B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020#0&J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010,\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016J\u0015\u0010-\u001a\u00020#2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00067"}, d2 = {"Lcom/larksuite/framework/ui/ViewTransitionContainer;", "ViewType", "Landroid/view/View;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "targetView", "Landroid/view/View;", "snapshot", "Landroid/graphics/Bitmap;", "snapshotPosition", "Landroid/graphics/PointF;", "transitionAnimator", "Landroid/animation/ValueAnimator;", "transitionType", "Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;", "getTransitionType", "()Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;", "setTransitionType", "(Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;)V", "transitionDuration", "", "getTransitionDuration$annotations", "()V", "getTransitionDuration", "()J", "setTransitionDuration", "(J)V", "update", "", "animate", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "onViewAdded", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "onViewRemoved", "takeSnapshot", "(Landroid/view/View;)V", "startTransitionAnimator", "clearTransitionAnimator", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawSnapshotIfNeeded", "Companion", "TransitionType", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewTransitionContainer<ViewType extends View> extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f285833g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewType f285834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f285835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f285836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f285837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TransitionType f285838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f285839f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "CROSS_FADE", "SLIDING_DOWN_FADE", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType CROSS_FADE = null;
        public static final TransitionType NONE = null;
        public static final TransitionType SLIDING_DOWN_FADE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransitionType[] f285840a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285841b = null;

        public static EnumEntries<TransitionType> getEntries() {
            return f285841b;
        }

        static {
            TransitionType r100 = new TransitionType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            TransitionType r101 = new TransitionType("CROSS_FADE", 1);
            CROSS_FADE = r101;
            TransitionType r102 = new TransitionType("SLIDING_DOWN_FADE", 2);
            SLIDING_DOWN_FADE = r102;
            TransitionType[] r103 = {r100, r101, r102};
            f285840a = r103;
            f285841b = EnumEntriesKt.enumEntries(r103);
        }

        public static TransitionType[] values() {
            return (TransitionType[]) f285840a.clone();
        }

        public static TransitionType valueOf(String r100) {
            return (TransitionType) r27.a.a(TransitionType.class, r100);
        }

        public TransitionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public ViewTransitionContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ViewTransitionContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void getTransitionDuration$annotations() {
    }

    public final long getTransitionDuration() {
        return this.f285839f;
    }

    public final TransitionType getTransitionType() {
        return this.f285838e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        ValueAnimator r100 = this.f285837d;
        if (r100 != null) goto L5;
    L39:
        super.dispatchDraw(r110);
        return;
    L5:
        if (Intrinsics.areEqual(r100.getAnimatedValue(), Float.valueOf(1.0f)) == true) goto L39;
        Bitmap r101 = this.f285835b;
        Float r102 = null;
        if (r101 == null) goto L22;
        ValueAnimator r103 = this.f285837d;
        if (r103 == null) goto L22;
        Object r104 = r103.getAnimatedValue();
        if ((r104 instanceof Float) == false) goto L16;
        Float r105 = (Float) r104;
    L17:
        if (r105 == null) goto L22;
        float r106 = r105.floatValue();
        int r107 = r110.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), (int) (255 * (1 - r106)));
        if (this.f285838e != TransitionType.SLIDING_DOWN_FADE) goto L21;
        r110.translate(0.0f, (r101.getHeight() / 3.0f) * r106);
    L21:
        PointF r108 = this.f285836c;
        r110.drawBitmap(r101, r108.x, r108.y, null);
        r110.restoreToCount(r107);
        goto L22
    L16:
        r105 = null;
    L22:
        ValueAnimator r109 = this.f285837d;
        if (r109 == null) goto L25;
        Object r111 = r109.getAnimatedValue();
    L27:
        if ((r111 instanceof Float) == false) goto L29;
        r102 = (Float) r111;
    L29:
        if (r102 == null) goto L41;
        float r112 = r102.floatValue();
        int r113 = r110.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), (int) (255 * r112));
        if (this.f285838e != TransitionType.SLIDING_DOWN_FADE) goto L37;
        ViewType r114 = this.f285834a;
        if (r114 == null) goto L35;
        float r115 = r114.getHeight();
    L36:
        r110.translate(0.0f, ((-r115) / 3.0f) * (1 - r112));
        goto L37
    L35:
        r115 = 0.0f;
    L37:
        super.dispatchDraw(r110);
        r110.restoreToCount(r113);
        return;
    L41:
        return;
    L25:
        r111 = null;
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        super.onViewAdded(r100);
        if (this.f285834a != null) goto L6;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type ViewType of com.larksuite.framework.ui.ViewTransitionContainer");
        this.f285834a = r100;
        return;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        if (Intrinsics.areEqual(this.f285834a, r100) == false) goto L6;
        this.f285834a = null;
        return;
    }

    public final void setTransitionDuration(long r100) {
        this.f285839f = r100;
    }

    public final void setTransitionType(TransitionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f285838e = r100;
    }

    public final void update(boolean r100, Function1<? super ViewType, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "update");
        ViewType r102 = this.f285834a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == true) goto L7;
    L26:
        r101.invoke(r102);
        return;
    L7:
        if (this.f285838e == TransitionType.NONE) goto L26;
        ValueAnimator r103 = this.f285837d;
        if (r103 == null) goto L13;
        r103.cancel();
    L13:
        if (r102.getWidth() != 0) goto L15;
    L18:
        r101.invoke(r102);
        if (this.f285835b == null) goto L28;
        ValueAnimator r104 = this.f285837d;
        if (r104 == null) goto L24;
        r104.cancel();
    L24:
        this.f285837d = null;
        invalidate();
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r105.setDuration(this.f285839f);
        r105.addUpdateListener(new d(this));
        r105.addListener(new e(this));
        r105.start();
        this.f285837d = r105;
        return;
    L28:
        return;
    L15:
        if (r102.getHeight() == 0) goto L18;
        Bitmap r106 = Bitmap.createBitmap(r102.getWidth(), r102.getHeight(), Bitmap.Config.ARGB_8888);
        this.f285835b = r106;
        this.f285836c.set(r102.getX(), r102.getY());
        r102.draw(new Canvas(r106));
        goto L18
    }

    public ViewTransitionContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f285836c = new PointF(0.0f, 0.0f);
        setWillNotDraw(false);
        this.f285838e = TransitionType.CROSS_FADE;
        this.f285839f = 300;
    }

    public /* synthetic */ ViewTransitionContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
