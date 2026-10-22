package com.ss.android.lark.widget.previewanimation.player.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.previewanimation.player.AnimationPlayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tdc.b;
import tdc.c;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0017J\u0016\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013J\u0010\u0010(\u001a\u00020\u00002\b\b\u0001\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0003J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0002J\u0014\u00102\u001a\u00020\"2\n\u00103\u001a\u00060*j\u0002`4H\u0016J\u001c\u00105\u001a\u00020\"2\u0006\u00106\u001a\u0002072\n\u00103\u001a\u00060*j\u0002`4H\u0016J\u0018\u00108\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0013H\u0016J\b\u0010:\u001a\u00020\u0013H\u0016J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/ss/android/lark/widget/previewanimation/player/image/ImageScaleTransformPlayer;", "Lcom/ss/android/lark/widget/previewanimation/player/AnimationPlayer;", PickerReporterConstants.KEY.TARGET, "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "originScaleType", "Landroid/widget/ImageView$ScaleType;", "terminalScaleType", "matrixParams", "Lcom/ss/android/lark/widget/previewanimation/player/image/matrix/MatrixParams;", "matrixProvider", "Lcom/ss/android/lark/widget/previewanimation/player/image/matrix/MatrixProvider;", "useCompatMode", "", "backgroundColor", "", "animatedBounds", "Landroid/graphics/RectF;", "originBounds", "Landroid/graphics/Rect;", "terminalBounds", "startPosition", "", "centerRect", "getCenterRect", "()Landroid/graphics/Rect;", "centerRect$delegate", "Lkotlin/Lazy;", "centerRectCompat", "prepareMatrixProvider", "", "updateBounds", "newBounds", "updateCenterRect", "width", "height", "updateBackgroundColorAlpha", "alpha", "", "updateImage", "drawable", "onEnter", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", d.f25928r, "updateAnimationData", "beforePlayFrame", "progress", "Lcom/ss/android/lark/widget/previewanimation/toolkit/Progress;", "onPlayFrame", "canvas", "Landroid/graphics/Canvas;", "writeToParcel", "flags", "describeContents", "setUseCompatMode", "CREATOR", "Builder", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageScaleTransformPlayer extends AnimationPlayer {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f448009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView.ScaleType f448010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView.ScaleType f448011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f448012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public tdc.d f448013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f448014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f448015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f448016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f448017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f448018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f448019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f448020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Rect f448021m;

    public static final class a implements Parcelable.Creator<ImageScaleTransformPlayer> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageScaleTransformPlayer createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = udc.a.f549756b;
            Intrinsics.checkNotNullParameter(r100, "parcel");
            IBinder r102 = r100.readStrongBinder();     // Catch: ClassCastException -> L5
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.widget.previewanimation.toolkit.DrawableTransferBinder");     // Catch: ClassCastException -> L5
            udc.a r103 = (udc.a) r102;     // Catch: ClassCastException -> L5
        L6:
            if (r103 == null) goto L9;
            Drawable r104 = r103.f549757a;
            if (r104 == null) goto L9;
        L10:
            ImageScaleTransformPlayer r105 = new ImageScaleTransformPlayer(r104);
            r105.f448015g = r100.readInt();
            int r106 = r100.readInt();
            r105.f448010b = ImageView.ScaleType.values()[r106];
            int r107 = r100.readInt();
            r105.f448011c = ImageView.ScaleType.values()[r107];
            Rect r108 = r105.f448017i;
            Rect r109 = (Rect) r100.readParcelable(Rect.class.getClassLoader());
            if (r109 != null) goto L13;
            r109 = new Rect();
        L13:
            r108.set(r109);
            Rect r110 = r105.f448018j;
            Rect r111 = (Rect) r100.readParcelable(Rect.class.getClassLoader());
            if (r111 != null) goto L16;
            r111 = new Rect();
        L16:
            r110.set(r111);
            int[] r112 = r100.createIntArray();
            if (r112 != null) goto L19;
            r112 = new int[2];
        L19:
            r105.f448019k = r112;
            b r113 = r105.f448012d;
            if (r113 == null) goto L23;
            c.f545545a.getClass();
            Intrinsics.checkNotNullParameter(r113, "params");
            r105.f448013e = new tdc.d(r113);
        L23:
            return r105;
        L9:
            r104 = new ColorDrawable(0);
        L5:
            Log.i("DrawableBinder", "obtain: binder type cast error!");
            r103 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ImageScaleTransformPlayer[] newArray(int r100) {
            return new ImageScaleTransformPlayer[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.widget.previewanimation.player.AnimationPlayer
    public final void a() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e() {
        ImageView.ScaleType r100 = this.f448010b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originScaleType");
        ImageView.ScaleType r101 = null;
    L6:
        ImageView.ScaleType r102 = this.f448011c;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("terminalScaleType");
        ImageView.ScaleType r103 = null;
    L10:
        Drawable r104 = this.f448009a;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        ImageView.ScaleType r105 = r101;
        ImageView.ScaleType r106 = r103;
        b r107 = new b(r105, r106, (((long) r104.getIntrinsicWidth()) << 32) + ((long) r104.getIntrinsicHeight()), this.f448017i, this.f448018j);
        this.f448012d = r107;
        c.f545545a.getClass();
        Intrinsics.checkNotNullParameter(r107, "params");
        this.f448013e = new tdc.d(r107);
        return;
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }

    @Override // com.ss.android.lark.widget.previewanimation.player.AnimationPlayer
    public final void c() {
        e();
    }

    public ImageScaleTransformPlayer(Drawable r100) {
        this.f448009a = r100;
        this.f448016h = new RectF();
        this.f448017i = new Rect();
        this.f448018j = new Rect();
        this.f448019k = new int[2];
        this.f448020l = LazyKt.lazy(ImageScaleTransformPlayer$centerRect$2.INSTANCE);
        Drawable r101 = this.f448009a;
        r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        Drawable r102 = this.f448009a;
        r102.setBounds(0, 0, r102.getIntrinsicWidth(), this.f448009a.getIntrinsicHeight());
    }

    @Override // com.ss.android.lark.widget.previewanimation.player.AnimationPlayer
    public final void b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Rect r101 = this.f448018j;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int r103 = r102[0];
        r101.set(new Rect(r103, r102[1], (r100.getRight() + r103) - r100.getLeft(), (r102[1] + r100.getBottom()) - r100.getTop()));
        e();
    }

    @Override // com.ss.android.lark.widget.previewanimation.player.AnimationPlayer
    public final void d(Canvas r100, float r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        b r101 = this.f448012d;
        if (r101 != null) goto L5;
        return;
    L5:
        Drawable r102 = this.f448009a;
        if ((r102 instanceof BitmapDrawable) == false) goto L16;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r103 = ((BitmapDrawable) r102).getBitmap();
        if (r103 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L16;
        Log.e("ImageScaleTransformPlay", "target bitmap is null or has been recycled");
        return;
    L10:
        if (r103.isRecycled() == true) goto L12;
        r104 = true;
    L16:
        r100.drawColor(udc.b.a(r110, this.f448015g));
        if (r101.f545543d.isEmpty() == false) goto L19;
    L22:
        Log.i("ImageScaleTransformPlay", "scale to center, progress:" + r110);
        this.f448009a.setAlpha((int) (((float) 255) * r110));
        if (ImageWidgetFG.a() == false) goto L27;
        Rect r105 = this.f448021m;
        if (r105 != null) goto L28;
        r105 = (Rect) this.f448020l.getValue();
    L28:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f545543d = r105;
    L29:
        int r106 = r100.save();
        Rect r107 = r101.f545543d;
        Rect r108 = r101.f545544e;
        RectF r109 = this.f448016h;
        float r111 = r107.left;
        float r112 = ((r108.left - r111) * r110) + r111;
        float r113 = r107.top;
        float r114 = ((r108.top - r113) * r110) + r113;
        float r115 = r107.right;
        float r116 = ((r108.right - r115) * r110) + r115;
        float r117 = r107.bottom;
        r109.set(r112, r114, r116, ((r108.bottom - r117) * r110) + r117);
        r100.clipRect(r109);
        tdc.d r118 = this.f448013e;
        if (r118 == null) goto L34;
        r100.concat(r118.f545547b.evaluate2(r110, r118.f545548c, r118.f545549d));
        this.f448009a.draw(r100);
        r100.restoreToCount(r106);
        return;
    L34:
        throw new IllegalArgumentException("Required value was null.".toString());
    L27:
        r105 = (Rect) this.f448020l.getValue();
        goto L28
    L19:
        if (this.f448014f == true) goto L22;
        Log.i("ImageScaleTransformPlay", "scale to origin, progress:" + r110);
        goto L29
    }

    public final void g(int r100, int r101) {
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L7;
        int r102 = UIHelper.dp2px(15.0f);
        this.f448021m = new Rect(r100 - r102, r101 - r102, r100 + r102, r101 + r102);
        return;
    L7:
        Log.w("ImageScaleTransformPlay", "updateCenterRect / Invalid width: " + r100 + ", or height: " + r101);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        udc.a r102 = new udc.a(this.f448009a);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeStrongBinder(r102);
        r100.writeInt(this.f448015g);
        ImageView.ScaleType r103 = this.f448010b;
        ImageView.ScaleType r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originScaleType");
        r103 = null;
    L5:
        r100.writeInt(r103.ordinal());
        ImageView.ScaleType r105 = this.f448011c;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("terminalScaleType");
    L9:
        r100.writeInt(r104.ordinal());
        r100.writeParcelable(this.f448017i, r101);
        r100.writeParcelable(this.f448018j, r101);
        r100.writeIntArray(this.f448019k);
        return;
    L8:
        r104 = r105;
        goto L9
    }
}
