package com.bytedance.locallife.poi.media.photo;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/PoiSlidesPhotosProgressBar;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/locallife/poi/media/photo/k;", "config", "", "setProgressBarConfig", "", "getCurrentPosition", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiSlidesPhotosProgressBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f262689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f262690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f262691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f262692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f262693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f262694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f262695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f262696h;

    public PoiSlidesPhotosProgressBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiSlidesPhotosProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getCurrentPosition() {
        return this.f262689a;
    }

    public final void a(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f262691c = this.f262690b;
        if (getOrientation() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L15;
        int r102 = getMeasuredWidth();
        if (r102 > 0) goto L12;
        return;
    L12:
        this.f262695g = getMeasuredHeight();
        float r103 = this.f262691c;
        int r104 = (int) ((r102 - ((r100 - 1) * r103)) / r100);
        this.f262694f = r104;
        if (r104 >= r103) goto L22;
        int r105 = (r102 / ((r100 * 2) - 1)) + 1;
        this.f262694f = r105;
        this.f262691c = r105;
        return;
    L22:
        return;
    L15:
        int r106 = getMeasuredHeight();
        if (r106 > 0) goto L18;
        return;
    L18:
        this.f262694f = getMeasuredWidth();
        float r107 = this.f262691c;
        int r108 = (int) ((r106 - ((r100 - 1) * r107)) / r100);
        this.f262695g = r108;
        if (r108 >= r107) goto L24;
        int r109 = (r106 / ((r100 * 2) - 1)) + 1;
        this.f262695g = r109;
        this.f262691c = r109;
        return;
    L24:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void c(int r100) {
        int r101 = getChildCount();
        if (r100 <= this.f262689a) goto L13;
        int r102 = 0;
    L5:
        if (r102 >= r100) goto L22;
        View r103 = getChildAt(r102);
        if ((r103 instanceof StoryProgressBar) == false) goto L12;
        if (r102 >= r100) goto L10;
        float r104 = 1.0f;
    L11:
        int r105 = StoryProgressBar.f262733n;
        ((StoryProgressBar) r103).b(r104, false);
        goto L12
    L10:
        r104 = 0.0f;
    L12:
        r102 = r102 + 1;
        goto L5
    L22:
        return;
    L13:
        int r106 = r101 - 1;
    L14:
        if ((-1) >= r106) goto L29;
        View r107 = getChildAt(r106);
        if ((r107 instanceof StoryProgressBar) == false) goto L21;
        if (r106 < r100) goto L19;
        float r108 = 0.0f;
    L20:
        int r109 = StoryProgressBar.f262733n;
        ((StoryProgressBar) r107).b(r108, false);
        goto L21
    L19:
        r108 = 1.0f;
    L21:
        r106 = r106 - 1;
        goto L14
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f262696h = true;
    }

    public final void setProgressBarConfig(k r100) {
        this.f262692d = r100;
    }

    public final StoryProgressBar b(int r100, int r101) {
        StoryProgressBar r102 = new StoryProgressBar(getContext(), null, 6, 0);
        if (getOrientation() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L11;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(0, -1);
        r104.weight = 1.0f;
        if (r100 >= (r101 - 1)) goto L14;
        int r105 = (int) this.f262691c;
        r104.rightMargin = r105;
        r104.setMarginEnd(r105);
    L14:
        r102.setLayoutParams(r104);
        k r106 = this.f262692d;
        if (r106 == null) goto L17;
        r102.setProgressBarConfig(r106);
    L17:
        return r102;
    L11:
        r102.setOrientation(1);
        r104 = new LinearLayout.LayoutParams(-1, -2);
        r104.height = this.f262695g;
        r104.width = this.f262694f;
        if (r100 >= (r101 - 1)) goto L14;
        r104.bottomMargin = (int) this.f262691c;
        goto L14
    L5:
        r103 = false;
        goto L7
    }

    public final void e(int r110, float r111) {
        d(this, r110, 0.0f, 0, 12);
        d(this, r110, r111, 0, 12);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f262693e == false) goto L5;
    L6:
        int r102 = getChildCount();
        a(r102);
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L21;
        View r104 = getChildAt(r103);
        if (r104 == null) goto L20;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        r106.height = this.f262695g;
        r106.weight = 1.0f;
        if (r103 < (r102 - 1)) goto L13;
    L19:
        r104.setLayoutParams(r106);
        goto L20
    L13:
        if (getOrientation() != 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        int r108 = (int) this.f262691c;
        r106.rightMargin = r108;
        r106.setMarginEnd(r108);
        goto L19
    L18:
        r106.bottomMargin = (int) this.f262691c;
        goto L19
    L15:
        r107 = false;
    L20:
        r103 = r103 + 1;
        goto L7
    L21:
        this.f262693e = false;
        this.f262696h = false;
        return;
    L5:
        if (this.f262696h == true) goto L6;
    }

    public PoiSlidesPhotosProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        float r103 = UIUtils.dip2Px(r100, 3.0f);
        this.f262690b = r103;
        this.f262691c = r103;
        this.f262693e = true;
    }

    public /* synthetic */ PoiSlidesPhotosProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void d(PoiSlidesPhotosProgressBar r100, int r101, float r102, long r103, int r110) {
        if ((r110 & 4) == 0) goto L5;
        r103 = 300;
    L5:
        boolean r104 = true;
        if ((r110 & 8) == 0) goto L8;
        boolean r111 = true;
    L10:
        if (r100.f262689a != r101) goto L12;
        int r105 = r101 + 1;
        int r106 = r100.getChildCount();
    L19:
        if (r105 >= r106) goto L24;
        View r107 = r100.getChildAt(r105);
        if ((r107 instanceof StoryProgressBar) == false) goto L23;
        int r108 = StoryProgressBar.f262733n;
        ((StoryProgressBar) r107).b(0.0f, false);
    L23:
        r105 = r105 + 1;
        goto L19
    L24:
        if (r101 >= 0) goto L26;
    L28:
        r104 = false;
    L29:
        if (r104 == false) goto L33;
        View r109 = r100.getChildAt(r101);
        if ((r109 instanceof StoryProgressBar) == false) goto L33;
        StoryProgressBar r112 = (StoryProgressBar) r109;
        r112.setAnimationInterval(r103);
        r112.b(r102, r111);
    L33:
        r100.f262689a = r101;
        return;
    L26:
        if (r101 >= r100.getChildCount()) goto L28;
    L12:
        if (r102 == 1.0f) goto L15;
        r104 = false;
    L15:
        if (r104 == false) goto L17;
        r100.e(r101, r102);
        goto L33
    L17:
        r100.c(r101);
        goto L33
    L8:
        r111 = false;
        goto L10
    }
}
