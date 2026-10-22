package tk6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes19.dex */
public abstract class e<T, V extends View> implements of6.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f546535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vk6.a f546536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SnapType f546537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f546538d;

    @Override // of6.b
    public final com.bytedance.live.zdanmaku.render.canvas.a a() {
        c(this.f546535a);
        this.f546535a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r100 = this.f546535a.getMeasuredWidth();
        int r101 = this.f546535a.getMeasuredHeight();
        this.f546535a.layout(0, 0, r100, r101);
        SnapType r102 = this.f546537c;
        int r103 = d.f546534a[r102.ordinal()];
        if (r103 != 1) goto L5;
        vk6.a r104 = this.f546536b;
        if (this.f546535a.isOpaque() == false) goto L13;
        Bitmap.Config r105 = Bitmap.Config.RGB_565;
    L14:
        Bitmap r106 = r104.obtain(r100, r101, r105);
        this.f546535a.draw(new Canvas(r106));
        return new a(r100, r101, r106, this.f546536b, this.f546538d);
    L13:
        r105 = Bitmap.Config.ARGB_8888;
        goto L14
    L5:
        if (r103 != 2) goto L9;
        Picture r107 = new Picture();
        Canvas r108 = r107.beginRecording(r100, r101);
        this.f546535a.draw(r108);
        r107.endRecording();
        return new c(r107);
    L9:
        throw new NoWhenBranchMatchedException();
    }

    public static void c(View r100) {
        r100.forceLayout();
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        c(r101.getChildAt(r103));
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(View r100, vk6.b r101, SnapType r102, boolean r103) {
        this.f546535a = r100;
        this.f546536b = r101;
        this.f546537c = r102;
        this.f546538d = r103;
    }

    public /* synthetic */ e(View r100, vk6.b r101, SnapType r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = SnapType.Bitmap;
    L5:
        this(r100, r101, r102, false);
    }
}
