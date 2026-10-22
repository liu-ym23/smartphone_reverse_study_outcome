package ko1;

import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f504392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f504393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f504394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f504395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f504396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f504397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f504398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f504399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f504400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.platformplayer.layout.c f504401j;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.f504397f == false) goto L7;
        if (r100.getScaleFactor() <= 1) goto L7;
    L11:
        if (this.f504397f == false) goto L14;
        r100.getScaleFactor();
    L14:
        if (this.f504398g == false) goto L16;
        r100.getScaleFactor();
    L16:
        return true;
    L7:
        if (this.f504398g == true) goto L9;
    L17:
        this.f504392a = this.f504393b * r100.getScaleFactor();
        float r101 = x6.a();
        float r102 = this.f504392a;
        float r103 = this.f504395d * r101;
        boolean r104 = false;
        if (r102 <= r103) goto L20;
        this.f504392a = r103;
        this.f504397f = true;
        this.f504398g = false;
    L23:
        r104 = true;
    L34:
        if (x6.f114300a != 1) goto L31;
        float r105 = x6.a();     // Catch: Exception -> L33
        if (x6.f114301b == false) goto L30;
        a(Float.valueOf(this.f504392a), Float.valueOf(this.f504392a / r105));     // Catch: Exception -> L33
        goto L32
    L30:
        a(Float.valueOf(this.f504392a / r105), Float.valueOf(this.f504392a));     // Catch: Exception -> L33
        goto L32
    L31:
        a(Float.valueOf(this.f504392a), Float.valueOf(this.f504392a));     // Catch: Exception -> L33
    L32:
        return r104;
    L20:
        float r106 = this.f504396e * r101;
        if (r102 >= r106) goto L24;
        this.f504392a = r106;
        this.f504397f = false;
        this.f504398g = true;
        goto L23
    L24:
        this.f504397f = false;
        this.f504398g = false;
        goto L34
    L9:
        if (r100.getScaleFactor() >= 1) goto L17;
        goto L17
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.f504393b = this.f504392a;
    }

    public final void a(Float r100, Float r101) {
        if (r100 == null) goto L4;
        float r102 = r100.floatValue();
        this.f504399h.setScaleX(r102);
    L4:
        if (r101 == null) goto L6;
        float r103 = r101.floatValue();
        this.f504399h.setScaleY(r103);
    L6:
        com.bytedance.android.live.platformplayer.layout.c r104 = this.f504401j;
        if (r104 == null) goto L13;
        if (r100 == null) goto L10;
        r104.setScaleX(r100.floatValue());
    L10:
        if (r101 == null) goto L14;
        r104.setScaleY(r101.floatValue());
        return;
    L14:
        return;
    }

    public e(View r100, ViewGroup r101, com.bytedance.android.live.platformplayer.layout.c r102) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        this.f504399h = r100;
        this.f504400i = r101;
        this.f504401j = r102;
        this.f504392a = 1.0f;
        this.f504393b = 1.0f;
        this.f504395d = 5.0f;
        this.f504396e = 1.0f;
        this.f504398g = true;
    }
}
