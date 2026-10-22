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
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002()B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013¨\u0006*"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryProgressBar;", "Landroid/view/View;", "", "orientation", "", "setOrientation", "getOrientation", "", "animationInterval", "setAnimationInterval", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/b;", "config", "setProgressBarConfig", "", RXScreenCaptureService.KEY_INDEX, FaceService.girlLabel, "getMHorizontalMarginTop", "()F", "setMHorizontalMarginTop", "(F)V", "mHorizontalMarginTop", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;", "l", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;", "getMChapterStoryProgressBarDrawer", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;", "setMChapterStoryProgressBarDrawer", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/a;)V", "mChapterStoryProgressBarDrawer", "value", "drawPercentProgress", "getDrawPercentProgress", "setDrawPercentProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CornerPos", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class StoryProgressBar extends View {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f195326o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f195327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f195328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f195329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f195330d;
    private float drawPercentProgress;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f195331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f195332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f195333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f195334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f195335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f195336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f195337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a f195338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f195339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f195340n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/progress/StoryProgressBar$CornerPos;", "", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum CornerPos extends Enum<CornerPos> {
        public static final CornerPos BOTTOM_LEFT = null;
        public static final CornerPos BOTTOM_RIGHT = null;
        public static final CornerPos TOP_LEFT = null;
        public static final CornerPos TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CornerPos[] f195341a = null;

        public static CornerPos valueOf(String r100) {
            return (CornerPos) r27.a.a(CornerPos.class, r100);
        }

        public static CornerPos[] values() {
            return (CornerPos[]) f195341a.clone();
        }

        static {
            CornerPos r100 = new CornerPos("TOP_LEFT", 0);
            TOP_LEFT = r100;
            CornerPos r101 = new CornerPos("TOP_RIGHT", 1);
            TOP_RIGHT = r101;
            CornerPos r102 = new CornerPos("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r102;
            CornerPos r103 = new CornerPos("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r103;
            f195341a = new CornerPos[]{r100, r101, r102, r103};
        }

        public CornerPos(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f195342a = null;

        static {
            int[] r100 = new int[CornerPos.values().length];
            r100[CornerPos.TOP_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CornerPos.TOP_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CornerPos.BOTTOM_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CornerPos.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f195342a = r100;
        }
    }

    static {
    }

    public StoryProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StoryProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setProgressBarConfig(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.b r100) {
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        boolean r100 = super.performLongClick();
        if (r100 == false) goto L5;
        this.f195337k = true;
    L5:
        return r100;
    }

    public final float getDrawPercentProgress() {
        return this.drawPercentProgress;
    }

    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a getMChapterStoryProgressBarDrawer() {
        return this.f195338l;
    }

    public final float getMHorizontalMarginTop() {
        return this.f195335i;
    }

    public final int getOrientation() {
        return this.f195330d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (getOrientation() != 0) goto L7;
        this.f195327a.set(0.0f, this.f195335i, getWidth(), this.f195335i + this.f195336j);
    L8:
        this.f195340n.setColor(this.f195331e);
        RectF r101 = this.f195327a;
        float r102 = this.f195332f;
        r100.drawRoundRect(r101, r102, r102, this.f195340n);
        this.f195328b.reset();
        Arrays.fill(this.f195329c, 0.0f);
        boolean r103 = true;
        if (getOrientation() != 0) goto L23;
        float r104 = getWidth() * this.drawPercentProgress;
        float r105 = getWidth();
        float r106 = this.f195332f;
        if (r105 <= r106) goto L22;
        float r107 = this.drawPercentProgress;
        if (r107 == 0.0f) goto L16;
        r103 = false;
    L16:
        if (r103 == true) goto L43;
        float r108 = r107 * getWidth();
        float r109 = this.f195332f;
        float r110 = 2 * r109;
        if (r108 > r110) goto L21;
        RectF r111 = this.f195327a;
        float r112 = this.f195335i;
        r111.set(0.0f, r112, r110, this.f195336j + r112);
        RectF r113 = this.f195327a;
        float r114 = this.f195332f;
        r100.drawRoundRect(r113, r114, r114, this.f195339m);
        Arrays.fill(this.f195329c, 0.0f);
        return;
    L21:
        a(CornerPos.TOP_LEFT, r109);
        a(CornerPos.BOTTOM_LEFT, this.f195332f);
        a(CornerPos.TOP_RIGHT, this.f195332f);
        a(CornerPos.BOTTOM_RIGHT, this.f195332f);
        RectF r115 = this.f195327a;
        float r116 = this.f195335i;
        r115.set(0.0f, r116, r104, this.f195336j + r116);
        this.f195328b.addRoundRect(this.f195327a, this.f195329c, Path.Direction.CW);
        r100.drawPath(this.f195328b, this.f195339m);
        return;
    L43:
        return;
    L22:
        a(CornerPos.TOP_LEFT, r106);
        a(CornerPos.BOTTOM_LEFT, this.f195332f);
        a(CornerPos.TOP_RIGHT, this.f195332f);
        a(CornerPos.BOTTOM_RIGHT, this.f195332f);
        RectF r117 = this.f195327a;
        float r118 = this.f195335i;
        r117.set(0.0f, r118, r104, this.f195336j + r118);
        this.f195328b.addRoundRect(this.f195327a, this.f195329c, Path.Direction.CW);
        r100.drawPath(this.f195328b, this.f195339m);
        return;
    L23:
        float r119 = getHeight() * this.drawPercentProgress;
        float r120 = getHeight();
        float r121 = this.f195332f;
        if (r120 <= r121) goto L35;
        float r122 = this.drawPercentProgress;
        if (r122 == 0.0f) goto L29;
        r103 = false;
    L29:
        if (r103 == true) goto L44;
        float r123 = r122 * getHeight();
        float r124 = this.f195332f;
        float r125 = 2;
        if (r123 > (r124 * r125)) goto L34;
        this.f195327a.set(0.0f, 0.0f, getWidth(), this.f195332f * r125);
        this.f195328b.addRoundRect(this.f195327a, this.f195329c, Path.Direction.CW);
        r100.drawPath(this.f195328b, this.f195339m);
        return;
    L34:
        a(CornerPos.TOP_LEFT, r124);
        a(CornerPos.TOP_RIGHT, this.f195332f);
        a(CornerPos.BOTTOM_LEFT, this.f195332f);
        a(CornerPos.BOTTOM_RIGHT, this.f195332f);
        this.f195327a.set(0.0f, this.f195332f / r125, getWidth(), r119);
        this.f195328b.addRoundRect(this.f195327a, this.f195329c, Path.Direction.CW);
        r100.drawPath(this.f195328b, this.f195339m);
        return;
    L44:
        return;
    L35:
        a(CornerPos.TOP_LEFT, r121);
        a(CornerPos.BOTTOM_LEFT, this.f195332f);
        a(CornerPos.TOP_RIGHT, this.f195332f);
        a(CornerPos.BOTTOM_RIGHT, this.f195332f);
        this.f195327a.set(0.0f, 0.0f, getWidth(), r119);
        this.f195328b.addRoundRect(this.f195327a, this.f195329c, Path.Direction.CW);
        r100.drawPath(this.f195328b, this.f195339m);
        return;
    L7:
        this.f195327a.set(0.0f, 0.0f, getWidth(), getHeight());
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L5:
        if (r101 == null) goto L18;
        if (r101.intValue() != 1) goto L18;
        if (isEnabled() == false) goto L29;
        if (isClickable() == false) goto L29;
        if (this.f195337k == true) goto L29;
        performClick();
        return true;
    L29:
        return super.onTouchEvent(r100);
    L18:
        if (r101 != null) goto L21;
    L23:
        if (r101 == null) goto L29;
        if (r101.intValue() != 3) goto L29;
        this.f195337k = false;
        goto L29
    L21:
        if (r101.intValue() != 0) goto L23;
        this.f195337k = false;
        goto L29
    L4:
        r101 = null;
        goto L5
    }

    public final void setAnimationInterval(long r100) {
        this.f195333g = r100;
    }

    public final void setDrawPercentProgress(float r100) {
        this.drawPercentProgress = r100;
        invalidate();
    }

    public final void setMChapterStoryProgressBarDrawer(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.a r100) {
        this.f195338l = r100;
    }

    public final void setMHorizontalMarginTop(float r100) {
        this.f195335i = r100;
    }

    public final void setOrientation(int r100) {
        this.f195330d = r100;
    }

    public final void a(CornerPos r100, float r101) {
        int r102 = b.f195342a[r100.ordinal()];
        if (r102 != 1) goto L5;
        float[] r103 = this.f195329c;
        r103[0] = r101;
        r103[1] = r101;
        return;
    L5:
        if (r102 != 2) goto L7;
        float[] r104 = this.f195329c;
        r104[2] = r101;
        r104[3] = r101;
        return;
    L7:
        if (r102 == 3) goto L11;
        if (r102 != 4) goto L18;
        float[] r105 = this.f195329c;
        r105[6] = r101;
        r105[7] = r101;
        return;
    L18:
        return;
    L11:
        float[] r106 = this.f195329c;
        r106[4] = r101;
        r106[5] = r101;
    }

    public final void b(float r100, boolean r101) {
        float r102 = this.drawPercentProgress;
        if (r100 <= 0.0f) goto L12;
        if (r100 > r102) goto L12;
        clearAnimation();
        ValueAnimator r103 = this.f195334h;
        if (r103 == null) goto L9;
        r103.cancel();
    L9:
        setDrawPercentProgress(r100);
        return;
    L12:
        if (getWidth() > 0) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r101 == false) goto L27;
        if (r104 == false) goto L27;
        if (r100 <= r102) goto L27;
        if (r100 >= 1.0f) goto L27;
        clearAnimation();
        ValueAnimator r105 = this.f195334h;
        if (r105 == null) goto L26;
        r105.cancel();
    L26:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this, "drawPercentProgress", new float[]{r102, r100});
        r106.setInterpolator(new LinearInterpolator());
        r106.setDuration(this.f195333g);
        r106.setAutoCancel(true);
        this.f195334h = r106;
        r106.start();
        return;
    L27:
        clearAnimation();
        ValueAnimator r107 = this.f195334h;
        if (r107 == null) goto L30;
        r107.cancel();
    L30:
        setDrawPercentProgress(r100);
        return;
    L14:
        if (getHeight() <= 0) goto L16;
        r104 = true;
        goto L17
    }

    public StoryProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f195327a = new RectF();
        this.f195328b = new Path();
        this.f195329c = new float[8];
        int r103 = ContextCompat.getColor(r100, R.color.aos_const_text_inverse);
        this.f195331e = ContextCompat.getColor(r100, R.color.aos_const_text_inverse5);
        this.f195332f = n0.a(r100, 1.5f);
        this.f195333g = 300;
        this.f195335i = n0.a(r100, 15.0f);
        this.f195336j = n0.a(r100, 3.0f);
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setColor(r103);
        r104.setStyle(Paint.Style.FILL);
        this.f195339m = r104;
        Paint r105 = new Paint();
        r105.setAntiAlias(true);
        r105.setColor(this.f195331e);
        r105.setStyle(Paint.Style.FILL);
        this.f195340n = r105;
    }

    public /* synthetic */ StoryProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
