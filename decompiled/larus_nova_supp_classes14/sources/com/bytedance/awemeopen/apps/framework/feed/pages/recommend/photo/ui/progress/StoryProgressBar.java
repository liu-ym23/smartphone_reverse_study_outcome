package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002()B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013¨\u0006*"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryProgressBar;", "Landroid/view/View;", "", "orientation", "", "setOrientation", "getOrientation", "", "animationInterval", "setAnimationInterval", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/b;", "config", "setProgressBarConfig", "", "i", "F", "getMHorizontalMarginTop", "()F", "setMHorizontalMarginTop", "(F)V", "mHorizontalMarginTop", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;", "l", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;", "getMChapterStoryProgressBarDrawer", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;", "setMChapterStoryProgressBarDrawer", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;)V", "mChapterStoryProgressBarDrawer", "value", "drawPercentProgress", "getDrawPercentProgress", "setDrawPercentProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "CornerPos", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class StoryProgressBar extends View {
    public static final /* synthetic */ int o = 0;
    public final RectF a;
    public final Path b;
    public final float[] c;
    public int d;
    private float drawPercentProgress;
    public int e;
    public float f;
    public long g;
    public ValueAnimator h;
    public float i;
    public final float j;
    public boolean k;
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a l;
    public final Paint m;
    public final Paint n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryProgressBar$CornerPos;", "", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum CornerPos extends Enum<CornerPos> {
        public static final CornerPos BOTTOM_LEFT = null;
        public static final CornerPos BOTTOM_RIGHT = null;
        public static final CornerPos TOP_LEFT = null;
        public static final CornerPos TOP_RIGHT = null;
        public static final /* synthetic */ CornerPos[] a = null;

        public static CornerPos valueOf(String r1) {
            return (CornerPos) r27.a.a(CornerPos.class, r1);
        }

        public static CornerPos[] values() {
            return (CornerPos[]) a.clone();
        }

        static {
            CornerPos r0 = new CornerPos("TOP_LEFT", 0);
            TOP_LEFT = r0;
            CornerPos r1 = new CornerPos("TOP_RIGHT", 1);
            TOP_RIGHT = r1;
            CornerPos r3 = new CornerPos("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r3;
            CornerPos r5 = new CornerPos("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r5;
            a = new CornerPos[]{r0, r1, r3, r5};
        }

        public CornerPos(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CornerPos.values().length];
            r0[CornerPos.TOP_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CornerPos.TOP_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CornerPos.BOTTOM_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CornerPos.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public StoryProgressBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StoryProgressBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setProgressBarConfig(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.b r1) {
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        boolean r0 = super.performLongClick();
        if (r0 == false) goto L5;
        this.k = true;
    L5:
        return r0;
    }

    public final float getDrawPercentProgress() {
        return this.drawPercentProgress;
    }

    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a getMChapterStoryProgressBarDrawer() {
        return this.l;
    }

    public final float getMHorizontalMarginTop() {
        return this.i;
    }

    public final int getOrientation() {
        return this.d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        super.onDraw(r8);
        if (r8 != null) goto L5;
        return;
    L5:
        if (getOrientation() != 0) goto L7;
        this.a.set(0.0f, this.i, getWidth(), this.i + this.j);
    L8:
        this.n.setColor(this.e);
        RectF r0 = this.a;
        float r2 = this.f;
        r8.drawRoundRect(r0, r2, r2, this.n);
        this.b.reset();
        Arrays.fill(this.c, 0.0f);
        boolean r3 = true;
        if (getOrientation() != 0) goto L23;
        float r1 = getWidth() * this.drawPercentProgress;
        float r5 = getWidth();
        float r6 = this.f;
        if (r5 <= r6) goto L22;
        float r7 = this.drawPercentProgress;
        if (r7 == 0.0f) goto L16;
        r3 = false;
    L16:
        if (r3 == true) goto L43;
        float r9 = r7 * getWidth();
        float r4 = this.f;
        float r10 = 2 * r4;
        if (r9 > r10) goto L21;
        RectF r11 = this.a;
        float r12 = this.i;
        r11.set(0.0f, r12, r10, this.j + r12);
        RectF r13 = this.a;
        float r14 = this.f;
        r8.drawRoundRect(r13, r14, r14, this.m);
        Arrays.fill(this.c, 0.0f);
        return;
    L21:
        a(CornerPos.TOP_LEFT, r4);
        a(CornerPos.BOTTOM_LEFT, this.f);
        a(CornerPos.TOP_RIGHT, this.f);
        a(CornerPos.BOTTOM_RIGHT, this.f);
        RectF r15 = this.a;
        float r16 = this.i;
        r15.set(0.0f, r16, r1, this.j + r16);
        this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
        r8.drawPath(this.b, this.m);
        return;
    L43:
        return;
    L22:
        a(CornerPos.TOP_LEFT, r6);
        a(CornerPos.BOTTOM_LEFT, this.f);
        a(CornerPos.TOP_RIGHT, this.f);
        a(CornerPos.BOTTOM_RIGHT, this.f);
        RectF r17 = this.a;
        float r18 = this.i;
        r17.set(0.0f, r18, r1, this.j + r18);
        this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
        r8.drawPath(this.b, this.m);
        return;
    L23:
        float r19 = getHeight() * this.drawPercentProgress;
        float r20 = getHeight();
        float r21 = this.f;
        if (r20 <= r21) goto L35;
        float r22 = this.drawPercentProgress;
        if (r22 == 0.0f) goto L29;
        r3 = false;
    L29:
        if (r3 == true) goto L44;
        float r23 = r22 * getHeight();
        float r24 = this.f;
        float r25 = 2;
        if (r23 > (r24 * r25)) goto L34;
        this.a.set(0.0f, 0.0f, getWidth(), this.f * r25);
        this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
        r8.drawPath(this.b, this.m);
        return;
    L34:
        a(CornerPos.TOP_LEFT, r24);
        a(CornerPos.TOP_RIGHT, this.f);
        a(CornerPos.BOTTOM_LEFT, this.f);
        a(CornerPos.BOTTOM_RIGHT, this.f);
        this.a.set(0.0f, this.f / r25, getWidth(), r19);
        this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
        r8.drawPath(this.b, this.m);
        return;
    L44:
        return;
    L35:
        a(CornerPos.TOP_LEFT, r21);
        a(CornerPos.BOTTOM_LEFT, this.f);
        a(CornerPos.TOP_RIGHT, this.f);
        a(CornerPos.BOTTOM_RIGHT, this.f);
        this.a.set(0.0f, 0.0f, getWidth(), r19);
        this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
        r8.drawPath(this.b, this.m);
        return;
    L7:
        this.a.set(0.0f, 0.0f, getWidth(), getHeight());
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r0 = Integer.valueOf(r4.getActionMasked());
    L5:
        if (r0 == null) goto L18;
        if (r0.intValue() != 1) goto L18;
        if (isEnabled() == false) goto L29;
        if (isClickable() == false) goto L29;
        if (this.k == true) goto L29;
        performClick();
        return true;
    L29:
        return super.onTouchEvent(r4);
    L18:
        if (r0 != null) goto L21;
    L23:
        if (r0 == null) goto L29;
        if (r0.intValue() != 3) goto L29;
        this.k = false;
        goto L29
    L21:
        if (r0.intValue() != 0) goto L23;
        this.k = false;
        goto L29
    L4:
        r0 = null;
        goto L5
    }

    public final void setAnimationInterval(long r1) {
        this.g = r1;
    }

    public final void setDrawPercentProgress(float r1) {
        this.drawPercentProgress = r1;
        invalidate();
    }

    public final void setMChapterStoryProgressBarDrawer(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a r1) {
        this.l = r1;
    }

    public final void setMHorizontalMarginTop(float r1) {
        this.i = r1;
    }

    public final void setOrientation(int r1) {
        this.d = r1;
    }

    public final void a(CornerPos r3, float r4) {
        int r5 = b.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        float[] r6 = this.c;
        r6[0] = r4;
        r6[1] = r4;
        return;
    L5:
        if (r5 != 2) goto L7;
        float[] r7 = this.c;
        r7[2] = r4;
        r7[3] = r4;
        return;
    L7:
        if (r5 == 3) goto L11;
        if (r5 != 4) goto L18;
        float[] r8 = this.c;
        r8[6] = r4;
        r8[7] = r4;
        return;
    L18:
        return;
    L11:
        float[] r9 = this.c;
        r9[4] = r4;
        r9[5] = r4;
    }

    public final void b(float r5, boolean r6) {
        float r0 = this.drawPercentProgress;
        if (r5 <= 0.0f) goto L12;
        if (r5 > r0) goto L12;
        clearAnimation();
        ValueAnimator r7 = this.h;
        if (r7 == null) goto L9;
        r7.cancel();
    L9:
        setDrawPercentProgress(r5);
        return;
    L12:
        if (getWidth() > 0) goto L14;
    L16:
        boolean r1 = false;
    L17:
        if (r6 == false) goto L27;
        if (r1 == false) goto L27;
        if (r5 <= r0) goto L27;
        if (r5 >= 1.0f) goto L27;
        clearAnimation();
        ValueAnimator r8 = this.h;
        if (r8 == null) goto L26;
        r8.cancel();
    L26:
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this, "drawPercentProgress", new float[]{r0, r5});
        r9.setInterpolator(new LinearInterpolator());
        r9.setDuration(this.g);
        r9.setAutoCancel(true);
        this.h = r9;
        r9.start();
        return;
    L27:
        clearAnimation();
        ValueAnimator r10 = this.h;
        if (r10 == null) goto L30;
        r10.cancel();
    L30:
        setDrawPercentProgress(r5);
        return;
    L14:
        if (getHeight() <= 0) goto L16;
        r1 = true;
        goto L17
    }

    public StoryProgressBar(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3, r4, r5);
        this.a = new RectF();
        this.b = new Path();
        this.c = new float[8];
        int r6 = ContextCompat.getColor(r3, 2131100271);
        this.e = ContextCompat.getColor(r3, 2131100274);
        this.f = n0.a(r3, 1.5f);
        this.g = 300;
        this.i = n0.a(r3, 15.0f);
        this.j = n0.a(r3, 3.0f);
        Paint r7 = new Paint();
        r7.setAntiAlias(true);
        r7.setColor(r6);
        r7.setStyle(Paint.Style.FILL);
        this.m = r7;
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        r8.setColor(this.e);
        r8.setStyle(Paint.Style.FILL);
        this.n = r8;
    }

    public /* synthetic */ StoryProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
