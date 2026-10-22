package tk6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.artist.render.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.live.zdanmaku.render.canvas.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f546524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f546525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f546526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f546527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f546528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bitmap f546529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vk6.a f546530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f546531k;

    @Override // com.bytedance.live.artist.render.e
    public final void d() {
        this.f546530j.a(this.f546529i);
    }

    @Override // of6.a, com.bytedance.live.artist.render.e
    public final void e() {
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        this.f546524d = r100;
        if (this.f546531k == true) goto L8;
        float r101 = this.f546527g;
        float r102 = this.f546528h;
        RenderEntity r103 = this.f254850a;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L7:
        f r104 = r103.f254828c;
        r104.f254852a = r101;
        r104.f254853b = r102;
    L8:
        int r105 = this.f546527g;
        int r106 = this.f546528h;
        f r107 = this.f254851b;
        r107.f254852a = r105;
        r107.f254853b = r106;
        this.f546525e.set(0, 0, r105, r106);
    }

    @Override // com.bytedance.live.artist.render.e
    public final void f() {
        this.f546526f.set(this.f546525e);
        RenderEntity r100 = this.f254850a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L5:
        com.bytedance.live.artist.render.b r101 = r100.f254829d;
        this.f546526f.offset((int) r101.f254847a, (int) r101.f254848b);
        RenderEntity r102 = this.f254850a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L8:
        pk6.a r103 = (pk6.a) r102.e(pk6.a.class);
        if (r103 == null) goto L11;
        int r104 = r103.f529667a;
    L12:
        Paint r105 = this.f546524d;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bitmapPaint");
    L15:
        r105.setAlpha(r104);
        Canvas r106 = this.f255886c;
        if (r106 == null) goto L22;
        Bitmap r107 = this.f546529i;
        Rect r108 = this.f546525e;
        Rect r109 = this.f546526f;
        Paint r110 = this.f546524d;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("bitmapPaint");
    L20:
        r106.drawBitmap(r107, r108, r109, r110);
        return;
    L22:
        return;
    L11:
        r104 = 255;
        goto L12
    }

    public a(int r100, int r101, Bitmap r102, vk6.a r103, boolean r104) {
        this.f546527g = r100;
        this.f546528h = r101;
        this.f546529i = r102;
        this.f546530j = r103;
        this.f546531k = r104;
        this.f546525e = new Rect();
        this.f546526f = new Rect();
    }
}
