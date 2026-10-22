package com.larus.bmhome.bot.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.chat.immerse.k0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002+,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ7\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0014J \u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/bmhome/bot/share/ImmerseBgBitmapImageView;", "Landroid/view/View;", "aContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAContext", "()Landroid/content/Context;", "setAContext", "(Landroid/content/Context;)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "getDefStyleAttr", "()I", "setDefStyleAttr", "(I)V", "immersiveBgBitmap", "Landroid/graphics/Bitmap;", "immersiveBgColor", "footerContainerHeight", "immersiveBgMaskHeight", "paint", "Landroid/graphics/Paint;", "drawBitmapCacheInfo", "Lcom/larus/bmhome/bot/share/ImmerseBgBitmapImageView$DrawBitmapCacheInfo;", "setImmerseAvatarAndColor", "", "bgAvatar", "bgColor", "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getDrawBitmap", SimplayerImageStrategy.RESULT_BITMAP, "canvasHeight", "canvasWidth", "DrawBitmapCacheInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImmerseBgBitmapImageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f296711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AttributeSet f296712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f296713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f296714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f296715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f296716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f296717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f296718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f296719i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f296720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f296721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bitmap f296722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f296723d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f296720a == r101.f296720a) goto L12;
            return false;
        L12:
            if (this.f296721b == r101.f296721b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f296722c, r101.f296722c) == true) goto L18;
            return false;
        L18:
            if (this.f296723d == r101.f296723d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f296720a * 31) + this.f296721b) * 31) + this.f296722c.hashCode()) * 31;
            if (this.f296723d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "DrawBitmapCacheInfo(height=" + this.f296720a + ", width=" + this.f296721b + ", bitmap=" + this.f296722c + ", isScaledBitmap=" + this.f296723d + ')';
        }

        public b(int r100, int r101, Bitmap r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, SimplayerImageStrategy.RESULT_BITMAP);
            this.f296720a = r100;
            this.f296721b = r101;
            this.f296722c = r102;
            this.f296723d = r103;
        }
    }

    static {
    }

    public ImmerseBgBitmapImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "aContext");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImmerseBgBitmapImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "aContext");
        this(r100, r101, 4, 0);
    }

    public final Context getAContext() {
        return this.f296711a;
    }

    public final AttributeSet getAttrs() {
        return this.f296712b;
    }

    public final int getDefStyleAttr() {
        return this.f296713c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        FLogger r100 = FLogger.f375446a;
        r100.d("ImmerseBgBitmapImageView", "onDraw: " + Integer.valueOf(r110.getHeight()) + "   " + Integer.valueOf(r110.getWidth()));
        Bitmap r101 = this.f296714d;
        if (r101 != null) goto L5;
        r100.d("ImmerseBgBitmapImageView", "buildImmersiveBg: immersiveBgBitmap is null");
        int r102 = this.f296715e;
        Rect r103 = new Rect(0, 0, r110.getWidth(), r110.getHeight());
        Paint r104 = this.f296718h;
        r104.reset();
        r104.setColor(r102);
        Unit r105 = Unit.INSTANCE;
        r110.drawRect(r103, r104);
        return;
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        int r106 = r110.getHeight();
        int r107 = r110.getWidth();
        b r108 = this.f296719i;
        if (r108 == null) goto L15;
        if (r108.f296720a != r106) goto L15;
        if (r108.f296721b != r107) goto L15;
        r100.d("ImmerseBgBitmapImageView", "getDrawBitmap from cache");
        Bitmap r109 = r108.f296722c;
    L19:
        r110.drawBitmap(r109, 0.0f, 0.0f, null);
        int r111 = ColorUtils.setAlphaComponent(this.f296715e, 255);
        int r112 = ColorUtils.setAlphaComponent(this.f296715e, 0);
        int r113 = Math.min(r109.getHeight(), r110.getHeight() - this.f296716f);
        int r114 = r113 - this.f296717g;
        LinearGradient r115 = new LinearGradient(0.0f, r113, 0.0f, r114, r111, r112, Shader.TileMode.CLAMP);
        Rect r116 = new Rect(0, r114, r110.getWidth(), r113);
        Paint r117 = this.f296718h;
        r117.reset();
        r117.setShader(r115);
        Unit r118 = Unit.INSTANCE;
        r110.drawRect(r116, r117);
        Rect r119 = new Rect(0, r113, r110.getWidth(), r110.getHeight());
        Paint r120 = this.f296718h;
        r120.reset();
        r120.setColor(r111);
        r110.drawRect(r119, r120);
        return;
    L15:
        if (r101.getWidth() == getWidth()) goto L17;
        boolean r121 = true;
        r101 = Bitmap.createScaledBitmap(r101, getWidth(), (int) (r101.getHeight() * (getWidth() / r101.getWidth())), true);
        r100.d("ImmerseBgBitmapImageView", "getDrawBitmap createScaledBitmap");
    L18:
        this.f296719i = new b(r106, r107, r101, r121);
        r109 = r101;
        goto L19
    L17:
        r121 = false;
        goto L18
    }

    public final void setAContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f296711a = r100;
    }

    public final void setAttrs(AttributeSet r100) {
        this.f296712b = r100;
    }

    public final void setDefStyleAttr(int r100) {
        this.f296713c = r100;
    }

    public ImmerseBgBitmapImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "aContext");
        super(r100, r101, r102);
        this.f296711a = r100;
        this.f296712b = r101;
        this.f296713c = r102;
        int r103 = k0.f303286a;
        this.f296715e = k0.a(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_70, null, R.color.larus_neutral_70)), 0.4f, 0.15f);
        this.f296716f = i5.i();
        this.f296717g = i5.R();
        this.f296718h = new Paint();
    }

    public static void a(ImmerseBgBitmapImageView r100, Bitmap r101, Integer r102) {
        r100.f296714d = r101;
        if (r102 == null) goto L5;
        r100.f296715e = k0.a(r102.intValue(), 0.4f, 0.15f);
    L5:
        r100.invalidate();
    }

    public /* synthetic */ ImmerseBgBitmapImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
