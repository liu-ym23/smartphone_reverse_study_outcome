package com.larus.bmhome.view.markableview.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\"\b\u0016\u0018\u0000 U2\u00020\u0001:\u0002TUB)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010 J\u0010\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0016J\u000e\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0012J\u000e\u0010;\u001a\u0002042\u0006\u00108\u001a\u00020\u0012J\u0010\u0010<\u001a\u00020.2\u0006\u00108\u001a\u00020\u0012H\u0016J\u0018\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u000204H\u0016J \u0010C\u001a\u00020.2\u0006\u0010D\u001a\u0002042\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u000204H\u0016J\u001e\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u0002042\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u000204J\b\u0010I\u001a\u00020.H\u0004J0\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0014J\b\u0010P\u001a\u00020.H\u0014J\u001a\u0010Q\u001a\u0002042\u0006\u00108\u001a\u00020\u00122\b\b\u0001\u0010R\u001a\u00020\u0007H\u0004J\b\u0010S\u001a\u00020.H\u0004R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00109\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b:\u00106R\u0013\u0010=\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006V"}, d2 = {"Lcom/larus/bmhome/view/markableview/base/TransformImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCurrentImageCorners", "", "getMCurrentImageCorners", "()[F", "mCurrentImageCenter", "getMCurrentImageCenter", "mMatrixValues", "mCurrentImageMatrix", "Landroid/graphics/Matrix;", "getMCurrentImageMatrix", "()Landroid/graphics/Matrix;", "setMCurrentImageMatrix", "(Landroid/graphics/Matrix;)V", "mThisWidth", "getMThisWidth", "()I", "setMThisWidth", "(I)V", "mThisHeight", "getMThisHeight", "setMThisHeight", "mTransformImageListener", "Lcom/larus/bmhome/view/markableview/base/TransformImageView$TransformImageListener;", "getMTransformImageListener", "()Lcom/larus/bmhome/view/markableview/base/TransformImageView$TransformImageListener;", "setMTransformImageListener", "(Lcom/larus/bmhome/view/markableview/base/TransformImageView$TransformImageListener;)V", "mInitialImageCorners", "mInitialImageCenter", "mBitmapLaidOut", "", "getMBitmapLaidOut", "()Z", "setMBitmapLaidOut", "(Z)V", "setTransformImageListener", "", "transformImageListener", "setImageBitmap", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "currentScale", "", "getCurrentScale", "()F", "getMatrixScale", "matrix", "currentAngle", "getCurrentAngle", "getMatrixAngle", "setImageMatrix", "viewBitmap", "getViewBitmap", "()Landroid/graphics/Bitmap;", "postTranslate", "deltaX", "deltaY", "postScale", "deltaScale", GXTemplateKey.GAIAX_PX, "py", "postRotate", "deltaAngle", "init", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onImageLaidOut", "getMatrixValue", "valueIndex", "updateCurrentImagePoints", "TransformImageListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TransformImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f317032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f317033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f317034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Matrix f317035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f317036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f317037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f317038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f317039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f317040i;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public TransformImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransformImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final b getMTransformImageListener() {
        return null;
    }

    public final void setMTransformImageListener(b r100) {
    }

    public final void setTransformImageListener(b r100) {
    }

    public final float getCurrentAngle() {
        Matrix r100 = this.f317035d;
        Intrinsics.checkNotNullParameter(r100, "matrix");
        return -((float) (Math.atan2(j(r100, 1), j(r100, 0)) * 57.29577951308232d));
    }

    public final float getCurrentScale() {
        Matrix r100 = this.f317035d;
        Intrinsics.checkNotNullParameter(r100, "matrix");
        return (float) Math.sqrt(Math.pow(j(r100, 0), 2.0d) + Math.pow(j(r100, 3), 2.0d));
    }

    public final void m() {
        Matrix r100 = this.f317035d;
        float[] r101 = this.f317032a;
        float[] r102 = this.f317038g;
        float[] r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCorners");
        r102 = null;
    L5:
        r100.mapPoints(r101, r102);
        Matrix r104 = this.f317035d;
        float[] r105 = this.f317033b;
        float[] r106 = this.f317039h;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCenter");
    L9:
        r104.mapPoints(r105, r103);
        return;
    L8:
        r103 = r106;
        goto L9
    }

    public final Bitmap getViewBitmap() {
        if (getDrawable() != null) goto L5;
    L8:
        return null;
    L5:
        if ((getDrawable() instanceof jt8.a) == false) goto L8;
        Drawable r100 = getDrawable();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.bmhome.view.markableview.base.FastBitmapDrawable");
        return ((jt8.a) r100).f500339b;
    }

    public void l() {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        int r100 = getDrawable().getIntrinsicWidth();
        int r101 = getDrawable().getIntrinsicHeight();
        FLogger.f375446a.d("TransformImageView", "Image size: [" + r100 + ':' + r101 + ']');
        RectF r102 = new RectF(0.0f, 0.0f, (float) r100, (float) r101);
        float r103 = r102.left;
        float r104 = r102.top;
        float r105 = r102.right;
        float r106 = r102.bottom;
        this.f317038g = new float[]{r103, r104, r105, r104, r105, r106, r103, r106};
        this.f317039h = new float[]{r102.centerX(), r102.centerY()};
        this.f317040i = true;
    }

    public final boolean getMBitmapLaidOut() {
        return this.f317040i;
    }

    public final float[] getMCurrentImageCenter() {
        return this.f317033b;
    }

    public final float[] getMCurrentImageCorners() {
        return this.f317032a;
    }

    public final Matrix getMCurrentImageMatrix() {
        return this.f317035d;
    }

    public final int getMThisHeight() {
        return this.f317037f;
    }

    public final int getMThisWidth() {
        return this.f317036e;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        setImageDrawable(new jt8.a(r100));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "matrix");
        super.setImageMatrix(r100);
        this.f317035d.set(r100);
        m();
    }

    public final void setMBitmapLaidOut(boolean r100) {
        this.f317040i = r100;
    }

    public final void setMCurrentImageMatrix(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f317035d = r100;
    }

    public final void setMThisHeight(int r100) {
        this.f317037f = r100;
    }

    public final void setMThisWidth(int r100) {
        this.f317036e = r100;
    }

    public final float j(Matrix r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "matrix");
        r100.getValues(this.f317034c);
        return this.f317034c[r101];
    }

    public TransformImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101, r102);
        this.f317032a = new float[8];
        this.f317033b = new float[2];
        this.f317034c = new float[9];
        this.f317035d = new Matrix();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public /* synthetic */ TransformImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L5;
    L6:
        this.f317036e = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.f317037f = (getHeight() - getPaddingTop()) - getPaddingBottom();
        l();
        return;
    L5:
        if (this.f317040i == false) goto L6;
    }
}
