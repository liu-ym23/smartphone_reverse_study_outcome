package com.larus.common_ui.widget.input.audiowave;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'BA\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/larus/common_ui/widget/input/audiowave/AudioWaveGroup;", "Landroid/graphics/drawable/Drawable;", "barDrawable", "barCount", "", "barWidth", "barGap", "inset", "Landroid/graphics/Rect;", "maxBarHeight", "minBarHeight", "<init>", "(Landroid/graphics/drawable/Drawable;IIILandroid/graphics/Rect;II)V", "getBarCount", "()I", "getMaxBarHeight", "getMinBarHeight", "defaultWaveBarHeights", "", "getDefaultWaveBarHeights", "()[I", "value", "waveBarHeights", "getWaveBarHeights", "setWaveBarHeights", "([I)V", BasicTestActionHandler.TEST_ACTION_RESET, "", "getIntrinsicWidth", "getIntrinsicHeight", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioWaveGroup extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f328682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f328684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f328685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f328686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f328687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f328688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f328689h;
    private int[] waveBarHeights;

    public static final class a {
    }

    static {
    }

    public final void b() {
        int[] r100 = this.f328689h;
        Intrinsics.checkNotNullParameter(r100, "value");
        this.waveBarHeights = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Rect r100 = this.f328686e;
        if (r100 == null) goto L5;
        int r101 = r100.top + r100.bottom;
    L7:
        return this.f328687f + r101;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Rect r100 = this.f328686e;
        if (r100 == null) goto L5;
        int r101 = r100.left + r100.right;
    L6:
        int r102 = this.f328683b;
        int r103 = this.f328684c;
        int r104 = this.f328685d;
        return ((r102 * (r103 + r104)) - r104) + r101;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return Drawable.resolveOpacity(-2, this.f328682a.getOpacity());
    }

    public final int[] a() {
        return this.waveBarHeights;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f328682a.getAlpha() != 0) goto L5;
        return;
    L5:
        Rect r100 = this.f328686e;
        int r101 = 0;
        if (r100 == null) goto L8;
        int r102 = r100.left;
    L9:
        if (r100 == null) goto L11;
        int r103 = r100.top;
    L12:
        if (r100 == null) goto L14;
        int r104 = r100.bottom;
    L15:
        int r105 = this.f328683b;
    L16:
        if (r101 >= r105) goto L18;
        int r106 = this.waveBarHeights[r101];
        int r107 = (getBounds().left + r102) + ((this.f328684c + this.f328685d) * r101);
        int r108 = (getBounds().top + r103) + ((((getBounds().height() - r103) - r104) - r106) / 2);
        Drawable r109 = this.f328682a;
        r109.setBounds(r107, r108, this.f328684c + r107, r106 + r108);
        this.f328682a.draw(r110);
        r101 = r101 + 1;
        goto L16
    L18:
        return;
    L14:
        r104 = 0;
        goto L15
    L11:
        r103 = 0;
        goto L12
    L8:
        r102 = 0;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f328682a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f328682a.setColorFilter(r100);
    }

    public AudioWaveGroup(Drawable r100, int r101, int r102, int r103, Rect r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "barDrawable");
        this.f328682a = r100;
        this.f328683b = r101;
        this.f328684c = r102;
        this.f328685d = r103;
        this.f328686e = r104;
        this.f328687f = r105;
        this.f328688g = r106;
        int[] r107 = new int[r101];
        int r108 = 0;
    L3:
        if (r108 >= r101) goto L5;
        r107[r108] = this.f328688g;
        r108 = r108 + 1;
        goto L3
    L5:
        this.f328689h = r107;
        this.waveBarHeights = r107;
    }
}
