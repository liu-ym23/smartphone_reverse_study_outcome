package com.bytedance.locallife.poi.media.photo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR*\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/StoryProgressBar;", "Landroid/view/View;", "", "orientation", "", "setOrientation", "getOrientation", "Lcom/bytedance/locallife/poi/media/photo/k;", "config", "setProgressBarConfig", "", VideoThumbInfo.KEY_INTERVAL, "setAnimationInterval", "", "value", "drawPercentProgress", FaceService.girlLabel, "getDrawPercentProgress", "()F", "setDrawPercentProgress", "(F)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CornerPos", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class StoryProgressBar extends View {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f262733n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f262734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f262735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f262736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f262737d;
    private float drawPercentProgress;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f262738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f262739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f262740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f262741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f262742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f262743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f262744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f262745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f262746m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/StoryProgressBar$CornerPos;", "", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CornerPos extends Enum<CornerPos> {
        public static final CornerPos BOTTOM_LEFT = null;
        public static final CornerPos BOTTOM_RIGHT = null;
        public static final CornerPos TOP_LEFT = null;
        public static final CornerPos TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CornerPos[] f262747a = null;

        public static CornerPos valueOf(String r100) {
            return (CornerPos) r27.a.a(CornerPos.class, r100);
        }

        public static CornerPos[] values() {
            return (CornerPos[]) f262747a.clone();
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
            f262747a = new CornerPos[]{r100, r101, r102, r103};
        }

        public CornerPos(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262748a = null;

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
            f262748a = r100;
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

    public final float getDrawPercentProgress() {
        return this.drawPercentProgress;
    }

    public final int getOrientation() {
        return this.f262737d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (getOrientation() != 0) goto L5;
        this.f262734a.set(0.0f, this.f262743j, getWidth(), this.f262743j + this.f262744k);
    L6:
        this.f262746m.setColor(this.f262739f);
        RectF r101 = this.f262734a;
        float r102 = this.f262740g;
        r100.drawRoundRect(r101, r102, r102, this.f262746m);
        this.f262735b.reset();
        Arrays.fill(this.f262736c, 0.0f);
        boolean r103 = false;
        if (getOrientation() != 0) goto L19;
        float r104 = getWidth() * this.drawPercentProgress;
        float r105 = getWidth();
        float r106 = this.f262740g;
        if (r105 > r106) goto L11;
    L18:
        a(CornerPos.TOP_LEFT, r106);
        a(CornerPos.BOTTOM_LEFT, this.f262740g);
        a(CornerPos.TOP_RIGHT, this.f262740g);
        a(CornerPos.BOTTOM_RIGHT, this.f262740g);
        RectF r107 = this.f262734a;
        float r108 = this.f262743j;
        r107.set(0.0f, r108, r104, this.f262744k + r108);
        this.f262735b.addRoundRect(this.f262734a, this.f262736c, Path.Direction.CW);
        r100.drawPath(this.f262735b, this.f262745l);
        return;
    L11:
        if (this.drawPercentProgress != 0.0f) goto L13;
        r103 = true;
    L13:
        if (r103 == true) goto L36;
        float r109 = 2 * r106;
        if (r104 > r109) goto L18;
        RectF r110 = this.f262734a;
        float r111 = this.f262743j;
        r110.set(0.0f, r111, r109, this.f262744k + r111);
        RectF r112 = this.f262734a;
        float r113 = this.f262740g;
        r100.drawRoundRect(r112, r113, r113, this.f262745l);
        return;
    L36:
        return;
    L19:
        float r114 = getHeight() * this.drawPercentProgress;
        float r115 = getHeight();
        float r116 = this.f262740g;
        if (r115 > r116) goto L22;
        this.f262734a.set(0.0f, 0.0f, getWidth(), r114);
    L31:
        a(CornerPos.TOP_LEFT, this.f262740g);
        a(CornerPos.TOP_RIGHT, this.f262740g);
        a(CornerPos.BOTTOM_LEFT, this.f262740g);
        a(CornerPos.BOTTOM_RIGHT, this.f262740g);
        this.f262735b.addRoundRect(this.f262734a, this.f262736c, Path.Direction.CW);
        r100.drawPath(this.f262735b, this.f262745l);
        return;
    L22:
        if (this.drawPercentProgress != 0.0f) goto L24;
        r103 = true;
    L24:
        if (r103 == true) goto L37;
        float r117 = 2;
        if (r114 > (r116 * r117)) goto L29;
        this.f262734a.set(0.0f, 0.0f, getWidth(), this.f262740g * r117);
        this.f262735b.addRoundRect(this.f262734a, this.f262736c, Path.Direction.CW);
        r100.drawPath(this.f262735b, this.f262745l);
        return;
    L29:
        this.f262734a.set(0.0f, r116 / r117, getWidth(), r114);
        goto L31
    L37:
        return;
    L5:
        this.f262734a.set(0.0f, 0.0f, getWidth(), getHeight());
        goto L6
    }

    public final void setAnimationInterval(long r100) {
        this.f262741h = RangesKt.coerceAtLeast(r100, 0);
    }

    public final void setDrawPercentProgress(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.drawPercentProgress != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        this.drawPercentProgress = r101;
        invalidate();
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setOrientation(int r100) {
        this.f262737d = r100;
    }

    public final void setProgressBarConfig(k r100) {
        if (r100 == null) goto L17;
        float r101 = 0;
        if (0.0f <= r101) goto L6;
        this.f262740g = 0.0f;
    L6:
        int r102 = r100.f262773b;
        if (r102 <= 0) goto L9;
        this.f262739f = r102;
    L9:
        float r103 = r100.f262774c;
        if (r103 < r101) goto L12;
        this.f262743j = r103;
    L12:
        if (0.0f <= r101) goto L14;
        this.f262744k = 0.0f;
    L14:
        int r104 = r100.f262772a;
        if (r104 == 0) goto L17;
        this.f262738e = r104;
    L17:
        this.f262745l.setColor(this.f262738e);
        this.f262746m.setColor(this.f262739f);
        invalidate();
    }

    public final void a(CornerPos r100, float r101) {
        int r102 = b.f262748a[r100.ordinal()];
        if (r102 != 1) goto L5;
        float[] r103 = this.f262736c;
        r103[0] = r101;
        r103[1] = r101;
        return;
    L5:
        if (r102 != 2) goto L7;
        float[] r104 = this.f262736c;
        r104[2] = r101;
        r104[3] = r101;
        return;
    L7:
        if (r102 == 3) goto L11;
        if (r102 != 4) goto L18;
        float[] r105 = this.f262736c;
        r105[6] = r101;
        r105[7] = r101;
        return;
    L18:
        return;
    L11:
        float[] r106 = this.f262736c;
        r106[4] = r101;
        r106[5] = r101;
    }

    public final void b(float r100, boolean r101) {
        float r102 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        float r103 = this.drawPercentProgress;
        if (r102 <= 0) goto L12;
        if (r102 > r103) goto L12;
        clearAnimation();
        ValueAnimator r104 = this.f262742i;
        if (r104 == null) goto L9;
        r104.cancel();
    L9:
        setDrawPercentProgress(r102);
        return;
    L12:
        if (getWidth() > 0) goto L14;
    L16:
        boolean r105 = false;
    L17:
        ValueAnimator r106 = this.f262742i;
        if (r106 == null) goto L20;
        r106.cancel();
    L20:
        if (r101 == false) goto L27;
        if (r105 == false) goto L27;
        if (r102 <= r103) goto L27;
        if (r102 >= 1.0f) goto L27;
        clearAnimation();
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this, "drawPercentProgress", new float[]{r103, r102});
        r107.setInterpolator(new LinearInterpolator());
        r107.setDuration(this.f262741h);
        r107.setAutoCancel(true);
        r107.start();
        this.f262742i = r107;
        return;
    L27:
        clearAnimation();
        setDrawPercentProgress(r102);
        return;
    L14:
        if (getHeight() <= 0) goto L16;
        r105 = true;
        goto L17
    }

    public StoryProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262734a = new RectF();
        this.f262735b = new Path();
        this.f262736c = new float[8];
        this.f262738e = ColorProtector.parseColor("#73FFFFFF");
        this.f262739f = ColorProtector.parseColor("#33FFFFFF");
        this.f262740g = UIUtils.dip2Px(r100, 1.5f);
        this.f262741h = 300;
        this.f262743j = UIUtils.dip2Px(r100, 7.0f);
        this.f262744k = UIUtils.dip2Px(r100, 3.0f);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setColor(this.f262738e);
        r103.setStyle(Paint.Style.FILL);
        this.f262745l = r103;
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setColor(this.f262739f);
        r104.setStyle(Paint.Style.FILL);
        this.f262746m = r104;
    }

    public /* synthetic */ StoryProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
