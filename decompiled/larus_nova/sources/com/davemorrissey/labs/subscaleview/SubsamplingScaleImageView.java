package com.davemorrissey.labs.subscaleview;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import f06.b;
import f06.c;
import f06.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes22.dex */
public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final String TAG = null;
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    private static final List<Integer> VALID_EASING_STYLES = null;
    private static final List<Integer> VALID_ORIENTATIONS = null;
    private static final List<Integer> VALID_PAN_LIMITS = null;
    private static final List<Integer> VALID_SCALE_TYPES = null;
    private static final List<Integer> VALID_ZOOM_STYLES = null;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;

    public static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }

        public /* synthetic */ Anim(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ boolean access$2700(Anim r100) {
            return r100.interruptible;
        }

        public static /* synthetic */ OnAnimationEventListener access$2800(Anim r100) {
            return r100.listener;
        }

        public static /* synthetic */ PointF access$3100(Anim r100) {
            return r100.vFocusStart;
        }

        public static /* synthetic */ long access$3200(Anim r100) {
            return r100.time;
        }

        public static /* synthetic */ long access$3300(Anim r100) {
            return r100.duration;
        }

        public static /* synthetic */ int access$3400(Anim r100) {
            return r100.easing;
        }

        public static /* synthetic */ float access$3500(Anim r100) {
            return r100.scaleStart;
        }

        public static /* synthetic */ float access$3600(Anim r100) {
            return r100.scaleEnd;
        }

        public static /* synthetic */ PointF access$3700(Anim r100) {
            return r100.vFocusEnd;
        }

        public static /* synthetic */ PointF access$3800(Anim r100) {
            return r100.sCenterEnd;
        }

        public static /* synthetic */ int access$3900(Anim r100) {
            return r100.origin;
        }

        public static /* synthetic */ PointF access$4400(Anim r100) {
            return r100.sCenterStart;
        }

        public static /* synthetic */ PointF access$4500(Anim r100) {
            return r100.sCenterEndRequested;
        }

        public static /* synthetic */ boolean access$2702(Anim r100, boolean r101) {
            r100.interruptible = r101;
            return r101;
        }

        public static /* synthetic */ OnAnimationEventListener access$2802(Anim r100, OnAnimationEventListener r101) {
            r100.listener = r101;
            return r101;
        }

        public static /* synthetic */ PointF access$3102(Anim r100, PointF r101) {
            r100.vFocusStart = r101;
            return r101;
        }

        public static /* synthetic */ long access$3202(Anim r100, long r101) {
            r100.time = r101;
            return r101;
        }

        public static /* synthetic */ long access$3302(Anim r100, long r101) {
            r100.duration = r101;
            return r101;
        }

        public static /* synthetic */ int access$3402(Anim r100, int r101) {
            r100.easing = r101;
            return r101;
        }

        public static /* synthetic */ float access$3502(Anim r100, float r101) {
            r100.scaleStart = r101;
            return r101;
        }

        public static /* synthetic */ float access$3602(Anim r100, float r101) {
            r100.scaleEnd = r101;
            return r101;
        }

        public static /* synthetic */ PointF access$3702(Anim r100, PointF r101) {
            r100.vFocusEnd = r101;
            return r101;
        }

        public static /* synthetic */ PointF access$3802(Anim r100, PointF r101) {
            r100.sCenterEnd = r101;
            return r101;
        }

        public static /* synthetic */ int access$3902(Anim r100, int r101) {
            r100.origin = r101;
            return r101;
        }

        public static /* synthetic */ PointF access$4402(Anim r100, PointF r101) {
            r100.sCenterStart = r101;
            return r101;
        }

        public static /* synthetic */ PointF access$4502(Anim r100, PointF r101) {
            r100.sCenterEndRequested = r101;
            return r101;
        }
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        final /* synthetic */ SubsamplingScaleImageView this$0;
        private final PointF vFocus;

        public void start() {
            if (SubsamplingScaleImageView.access$6400(this.this$0) != null) goto L5;
        L9:
            int r100 = this.this$0.getPaddingLeft() + (((this.this$0.getWidth() - this.this$0.getPaddingRight()) - this.this$0.getPaddingLeft()) / 2);
            int r101 = this.this$0.getPaddingTop() + (((this.this$0.getHeight() - this.this$0.getPaddingBottom()) - this.this$0.getPaddingTop()) / 2);
            float r102 = SubsamplingScaleImageView.access$6500(this.this$0, this.targetScale);
            if (this.panLimited == false) goto L12;
            SubsamplingScaleImageView r103 = this.this$0;
            PointF r104 = this.targetSCenter;
            PointF r105 = SubsamplingScaleImageView.access$6600(r103, r104.x, r104.y, r102, new PointF());
        L13:
            AnonymousClass1 r106 = null;
            SubsamplingScaleImageView.access$6402(this.this$0, new Anim(r106));
            Anim.access$3502(SubsamplingScaleImageView.access$6400(this.this$0), SubsamplingScaleImageView.access$1000(this.this$0));
            Anim.access$3602(SubsamplingScaleImageView.access$6400(this.this$0), r102);
            Anim.access$3202(SubsamplingScaleImageView.access$6400(this.this$0), System.currentTimeMillis());
            Anim.access$4502(SubsamplingScaleImageView.access$6400(this.this$0), r105);
            Anim.access$4402(SubsamplingScaleImageView.access$6400(this.this$0), this.this$0.getCenter());
            Anim.access$3802(SubsamplingScaleImageView.access$6400(this.this$0), r105);
            Anim.access$3102(SubsamplingScaleImageView.access$6400(this.this$0), this.this$0.sourceToViewCoord(r105));
            Anim.access$3702(SubsamplingScaleImageView.access$6400(this.this$0), new PointF(r100, r101));
            Anim.access$3302(SubsamplingScaleImageView.access$6400(this.this$0), this.duration);
            Anim.access$2702(SubsamplingScaleImageView.access$6400(this.this$0), this.interruptible);
            Anim.access$3402(SubsamplingScaleImageView.access$6400(this.this$0), this.easing);
            Anim.access$3902(SubsamplingScaleImageView.access$6400(this.this$0), this.origin);
            Anim.access$3202(SubsamplingScaleImageView.access$6400(this.this$0), System.currentTimeMillis());
            Anim.access$2802(SubsamplingScaleImageView.access$6400(this.this$0), this.listener);
            PointF r107 = this.vFocus;
            if (r107 == null) goto L16;
            float r108 = r107.x - (Anim.access$4400(SubsamplingScaleImageView.access$6400(this.this$0)).x * r102);
            float r109 = this.vFocus.y - (Anim.access$4400(SubsamplingScaleImageView.access$6400(this.this$0)).y * r102);
            ScaleAndTranslate r110 = new ScaleAndTranslate(r102, new PointF(r108, r109), r106);
            SubsamplingScaleImageView.access$6800(this.this$0, true, r110);
            Anim.access$3702(SubsamplingScaleImageView.access$6400(this.this$0), new PointF(this.vFocus.x + (ScaleAndTranslate.access$4800(r110).x - r108), this.vFocus.y + (ScaleAndTranslate.access$4800(r110).y - r109)));
        L16:
            this.this$0.invalidate();
            return;
        L12:
            r105 = this.targetSCenter;
            goto L13
        L5:
            if (Anim.access$2800(SubsamplingScaleImageView.access$6400(this.this$0)) == null) goto L9;
            Anim.access$2800(SubsamplingScaleImageView.access$6400(this.this$0)).onInterruptedByNewAnim();     // Catch: Exception -> L8
        L8:
            SubsamplingScaleImageView.access$5400();
            goto L9
        }

        private AnimationBuilder withOrigin(int r100) {
            this.origin = r100;
            return this;
        }

        private AnimationBuilder withPanLimited(boolean r100) {
            this.panLimited = r100;
            return this;
        }

        public AnimationBuilder withDuration(long r100) {
            this.duration = r100;
            return this;
        }

        public AnimationBuilder withEasing(int r100) {
            if (SubsamplingScaleImageView.access$6300().contains(Integer.valueOf(r100)) == false) goto L7;
            this.easing = r100;
            return this;
        L7:
            throw new IllegalArgumentException("Unknown easing type: " + r100);
        }

        public AnimationBuilder withInterruptible(boolean r100) {
            this.interruptible = r100;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener r100) {
            this.listener = r100;
            return this;
        }

        private AnimationBuilder(SubsamplingScaleImageView r100, float r101) {
            this.this$0 = r100;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = r101;
            this.targetSCenter = r100.getCenter();
            this.vFocus = null;
        }

        public static /* synthetic */ AnimationBuilder access$1200(AnimationBuilder r100, boolean r101) {
            return r100.withPanLimited(r101);
        }

        public static /* synthetic */ AnimationBuilder access$1300(AnimationBuilder r100, int r101) {
            return r100.withOrigin(r101);
        }

        private AnimationBuilder(SubsamplingScaleImageView r100, PointF r101) {
            this.this$0 = r100;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.access$1000(r100);
            this.targetSCenter = r101;
            this.vFocus = null;
        }

        private AnimationBuilder(SubsamplingScaleImageView r100, float r101, PointF r102) {
            this.this$0 = r100;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = r101;
            this.targetSCenter = r102;
            this.vFocus = null;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r100, float r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r100, PointF r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        private AnimationBuilder(SubsamplingScaleImageView r100, float r101, PointF r102, PointF r103) {
            this.this$0 = r100;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = r101;
            this.targetSCenter = r102;
            this.vFocus = r103;
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r100, float r101, PointF r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }

        public /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r100, float r101, PointF r102, PointF r103, AnonymousClass1 r104) {
            this(r100, r101, r102, r103);
        }
    }

    public static class BitmapLoadTask extends PthreadAsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public Integer doInBackground(Void... r100) {
            String r101 = this.source.toString();     // Catch: OutOfMemoryError -> L8 Exception -> L10
            Context r102 = this.contextRef.get();     // Catch: OutOfMemoryError -> L8 Exception -> L10
            DecoderFactory<? extends ImageDecoder> r103 = this.decoderFactoryRef.get();     // Catch: OutOfMemoryError -> L8 Exception -> L10
            SubsamplingScaleImageView r104 = this.viewRef.get();     // Catch: OutOfMemoryError -> L8 Exception -> L10
            if (r102 == null) goto L16;
            if (r103 == null) goto L17;
            if (r104 == null) goto L18;
            SubsamplingScaleImageView.access$5100(r104, "BitmapLoadTask.doInBackground", new Object[0]);     // Catch: OutOfMemoryError -> L8 Exception -> L10
            this.bitmap = r103.make().decode(r102, this.source);     // Catch: OutOfMemoryError -> L8 Exception -> L10
            return Integer.valueOf(SubsamplingScaleImageView.access$5200(r104, r102, r101));
        L18:
            return null;
        L17:
            return null;
        L16:
            return null;
        L10:
            e = move-exception;
            SubsamplingScaleImageView.access$5400();
            this.exception = e;
            return null;
        L8:
            e = move-exception;
            SubsamplingScaleImageView.access$5400();
            this.exception = new RuntimeException(e);
            return null;
        }

        public void onPostExecute(Integer r100) {
            SubsamplingScaleImageView r101 = this.viewRef.get();
            if (r101 == null) goto L20;
            Bitmap r102 = this.bitmap;
            if (r102 == null) goto L12;
            if (r100 == null) goto L12;
            if (this.preview == false) goto L10;
            SubsamplingScaleImageView.access$6000(r101, r102);
            return;
        L10:
            SubsamplingScaleImageView.access$6100(r101, r102, r100.intValue(), false);
            return;
        L12:
            if (this.exception != null) goto L14;
            return;
        L14:
            if (SubsamplingScaleImageView.access$5600(r101) != null) goto L16;
            return;
        L16:
            if (this.preview == false) goto L18;
            SubsamplingScaleImageView.access$5600(r101).onPreviewLoadError(this.exception);
            return;
        L18:
            SubsamplingScaleImageView.access$5600(r101).onImageLoadError(this.exception);
            return;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
            return doInBackground((Void[]) r100);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r100) {
            onPostExecute((Integer) r100);
        }

        public BitmapLoadTask(SubsamplingScaleImageView r100, Context r101, DecoderFactory<? extends ImageDecoder> r102, Uri r103, boolean r104) {
            this.viewRef = new WeakReference(r100);
            this.contextRef = new WeakReference(r101);
            this.decoderFactoryRef = new WeakReference(r102);
            this.source = r103;
            this.preview = r104;
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public DefaultOnAnimationEventListener() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public DefaultOnImageEventListener() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception r100) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception r100) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception r100) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public DefaultOnStateChangedListener() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(PointF r100, int r101) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float r100, int r101) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception r100);

        void onImageLoaded();

        void onPreviewLoadError(Exception r100);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception r100);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF r100, int r101);

        void onScaleChanged(float r100, int r101);
    }

    public static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        public static /* synthetic */ float access$4700(ScaleAndTranslate r100) {
            return r100.scale;
        }

        public static /* synthetic */ PointF access$4800(ScaleAndTranslate r100) {
            return r100.vTranslate;
        }

        private ScaleAndTranslate(float r100, PointF r101) {
            this.scale = r100;
            this.vTranslate = r101;
        }

        public static /* synthetic */ float access$4702(ScaleAndTranslate r100, float r101) {
            r100.scale = r101;
            return r101;
        }

        public /* synthetic */ ScaleAndTranslate(float r100, PointF r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }

        public /* synthetic */ Tile(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ boolean access$400(Tile r100) {
            return r100.visible;
        }

        public static /* synthetic */ boolean access$4000(Tile r100) {
            return r100.loading;
        }

        public static /* synthetic */ Rect access$4100(Tile r100) {
            return r100.sRect;
        }

        public static /* synthetic */ Rect access$4200(Tile r100) {
            return r100.vRect;
        }

        public static /* synthetic */ int access$4300(Tile r100) {
            return r100.sampleSize;
        }

        public static /* synthetic */ Bitmap access$500(Tile r100) {
            return r100.bitmap;
        }

        public static /* synthetic */ Rect access$5000(Tile r100) {
            return r100.fileSRect;
        }

        public static /* synthetic */ boolean access$4002(Tile r100, boolean r101) {
            r100.loading = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$402(Tile r100, boolean r101) {
            r100.visible = r101;
            return r101;
        }

        public static /* synthetic */ Rect access$4102(Tile r100, Rect r101) {
            r100.sRect = r101;
            return r101;
        }

        public static /* synthetic */ Rect access$4202(Tile r100, Rect r101) {
            r100.vRect = r101;
            return r101;
        }

        public static /* synthetic */ int access$4302(Tile r100, int r101) {
            r100.sampleSize = r101;
            return r101;
        }

        public static /* synthetic */ Rect access$5002(Tile r100, Rect r101) {
            r100.fileSRect = r101;
            return r101;
        }

        public static /* synthetic */ Bitmap access$502(Tile r100, Bitmap r101) {
            r100.bitmap = r101;
            return r101;
        }
    }

    public static class TileLoadTask extends PthreadAsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public Bitmap doInBackground(Void... r100) {
            SubsamplingScaleImageView r101 = this.viewRef.get();     // Catch: OutOfMemoryError -> L27 Exception -> L29
            ImageRegionDecoder r102 = this.decoderRef.get();     // Catch: OutOfMemoryError -> L27 Exception -> L29
            Tile r103 = this.tileRef.get();     // Catch: OutOfMemoryError -> L27 Exception -> L29
            if (r102 == null) goto L24;
            if (r103 == null) goto L24;
            if (r101 == null) goto L24;
            if (r102.isReady() == false) goto L24;
            if (Tile.access$400(r103) == false) goto L24;
            SubsamplingScaleImageView.access$5100(r101, "TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", new Object[]{Tile.access$4100(r103), Integer.valueOf(Tile.access$4300(r103))});     // Catch: OutOfMemoryError -> L27 Exception -> L29
            SubsamplingScaleImageView.access$5700(r101).readLock().lock();     // Catch: OutOfMemoryError -> L27 Exception -> L29
        L21:
            th = move-exception;
            SubsamplingScaleImageView.access$5700(r101).readLock().unlock();     // Catch: OutOfMemoryError -> L27 Exception -> L29
            throw th;     // Catch: OutOfMemoryError -> L27 Exception -> L29
        L12:
            if (r102.isReady() == false) goto L19;
            SubsamplingScaleImageView.access$5800(r101, Tile.access$4100(r103), Tile.access$5000(r103));     // Catch: Throwable -> L21
            if (SubsamplingScaleImageView.access$5300(r101) == null) goto L16;
            Tile.access$5000(r103).offset(SubsamplingScaleImageView.access$5300(r101).left, SubsamplingScaleImageView.access$5300(r101).top);     // Catch: Throwable -> L21
        L16:
            Bitmap r104 = r102.decodeRegion(Tile.access$5000(r103), Tile.access$4300(r103));     // Catch: Throwable -> L21
            SubsamplingScaleImageView.access$5700(r101).readLock().unlock();     // Catch: OutOfMemoryError -> L27 Exception -> L29
            return r104;
        L19:
            Tile.access$4002(r103, false);     // Catch: Throwable -> L21
            SubsamplingScaleImageView.access$5700(r101).readLock().unlock();     // Catch: OutOfMemoryError -> L27 Exception -> L29
            return null;
        L24:
            if (r103 == null) goto L36;
            Tile.access$4002(r103, false);     // Catch: OutOfMemoryError -> L27 Exception -> L29
            return null;
        L36:
            return null;
        L29:
            e = move-exception;
            SubsamplingScaleImageView.access$5400();
            this.exception = e;
            return null;
        L27:
            e = move-exception;
            SubsamplingScaleImageView.access$5400();
            this.exception = new RuntimeException(e);
            return null;
        }

        public void onPostExecute(Bitmap r100) {
            SubsamplingScaleImageView r101 = this.viewRef.get();
            Tile r102 = this.tileRef.get();
            if (r101 == null) goto L13;
            if (r102 == null) goto L14;
            if (r100 == null) goto L8;
            Tile.access$502(r102, r100);
            Tile.access$4002(r102, false);
            SubsamplingScaleImageView.access$5900(r101);
            return;
        L8:
            if (this.exception != null) goto L10;
            return;
        L10:
            if (SubsamplingScaleImageView.access$5600(r101) == null) goto L17;
            SubsamplingScaleImageView.access$5600(r101).onTileLoadError(this.exception);
            return;
        L17:
            return;
        L14:
            return;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
            return doInBackground((Void[]) r100);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r100) {
            onPostExecute((Bitmap) r100);
        }

        public TileLoadTask(SubsamplingScaleImageView r100, ImageRegionDecoder r101, Tile r102) {
            this.viewRef = new WeakReference(r100);
            this.decoderRef = new WeakReference(r101);
            this.tileRef = new WeakReference(r102);
            Tile.access$4002(r102, true);
        }
    }

    public static class TilesInitTask extends PthreadAsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public int[] doInBackground(Void... r100) {
            String r101 = this.source.toString();     // Catch: Exception -> L11
            Context r102 = this.contextRef.get();     // Catch: Exception -> L11
            DecoderFactory<? extends ImageRegionDecoder> r103 = this.decoderFactoryRef.get();     // Catch: Exception -> L11
            SubsamplingScaleImageView r104 = this.viewRef.get();     // Catch: Exception -> L11
            if (r102 == null) goto L17;
            if (r103 == null) goto L18;
            if (r104 == null) goto L19;
            SubsamplingScaleImageView.access$5100(r104, "TilesInitTask.doInBackground", new Object[0]);     // Catch: Exception -> L11
            ImageRegionDecoder r105 = r103.make();     // Catch: Exception -> L11
            this.decoder = r105;     // Catch: Exception -> L11
            Point r106 = r105.init(r102, this.source);     // Catch: Exception -> L11
            int r107 = r106.x;     // Catch: Exception -> L11
            int r108 = r106.y;     // Catch: Exception -> L11
            int r109 = SubsamplingScaleImageView.access$5200(r104, r102, r101);     // Catch: Exception -> L11
            if (SubsamplingScaleImageView.access$5300(r104) == null) goto L9;
            SubsamplingScaleImageView.access$5300(r104).left = Math.max(0, SubsamplingScaleImageView.access$5300(r104).left);     // Catch: Exception -> L11
            SubsamplingScaleImageView.access$5300(r104).top = Math.max(0, SubsamplingScaleImageView.access$5300(r104).top);     // Catch: Exception -> L11
            SubsamplingScaleImageView.access$5300(r104).right = Math.min(r107, SubsamplingScaleImageView.access$5300(r104).right);     // Catch: Exception -> L11
            SubsamplingScaleImageView.access$5300(r104).bottom = Math.min(r108, SubsamplingScaleImageView.access$5300(r104).bottom);     // Catch: Exception -> L11
            r107 = SubsamplingScaleImageView.access$5300(r104).width();     // Catch: Exception -> L11
            r108 = SubsamplingScaleImageView.access$5300(r104).height();     // Catch: Exception -> L11
        L9:
            return new int[]{r107, r108, r109};
        L19:
            return null;
        L18:
            return null;
        L17:
            return null;
        L11:
            e = move-exception;
            SubsamplingScaleImageView.access$5400();
            this.exception = e;
            return null;
        }

        public void onPostExecute(int[] r100) {
            SubsamplingScaleImageView r101 = this.viewRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (this.decoder == null) goto L11;
            if (r100 == null) goto L11;
            if (r100.length != 3) goto L11;
            SubsamplingScaleImageView.access$5500(r101, this.decoder, r100[0], r100[1], r100[2]);
            return;
        L11:
            if (this.exception != null) goto L13;
            return;
        L13:
            if (SubsamplingScaleImageView.access$5600(r101) == null) goto L19;
            SubsamplingScaleImageView.access$5600(r101).onImageLoadError(this.exception);
            return;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
            return doInBackground((Void[]) r100);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r100) {
            onPostExecute((int[]) r100);
        }

        public TilesInitTask(SubsamplingScaleImageView r100, Context r101, DecoderFactory<? extends ImageRegionDecoder> r102, Uri r103) {
            this.viewRef = new WeakReference(r100);
            this.contextRef = new WeakReference(r101);
            this.decoderFactoryRef = new WeakReference(r102);
            this.source = r103;
        }
    }

    private float easeInOutQuad(long r100, float r101, float r102, long r103) {
        float r104 = r100 / (r103 / 2.0f);
        if (r104 >= 1.0f) goto L7;
        float r105 = (r102 / 2.0f) * r104;
    L6:
        return (r105 * r104) + r101;
    L7:
        float r106 = r104 - 1.0f;
        r105 = (-r102) / 2.0f;
        r104 = (r106 * (r106 - 2.0f)) - 1.0f;
        goto L6
    }

    private float easeOutQuad(long r100, float r101, float r102, long r103) {
        float r104 = r100 / r103;
        return (((-r102) * r104) * (r104 - 2.0f)) + r101;
    }

    private synchronized void onTileLoaded() {
        monitor-enter(this);
        debug("onTileLoaded", new Object[0]);     // Catch: Throwable -> L19
        checkReady();     // Catch: Throwable -> L19
        checkImageLoaded();     // Catch: Throwable -> L19
        if (isBaseLayerReady() == false) goto L16;
        Bitmap r100 = this.bitmap;     // Catch: Throwable -> L19
        if (r100 == null) goto L16;
        if (this.bitmapIsCached == true) goto L10;
        r100.recycle();     // Catch: Throwable -> L19
    L10:
        this.bitmap = null;     // Catch: Throwable -> L19
        OnImageEventListener r101 = this.onImageEventListener;     // Catch: Throwable -> L19
        if (r101 != null) goto L13;
    L15:
        this.bitmapIsPreview = false;     // Catch: Throwable -> L19
        this.bitmapIsCached = false;     // Catch: Throwable -> L19
        goto L16
    L13:
        if (this.bitmapIsCached == false) goto L15;
        r101.onPreviewReleased();     // Catch: Throwable -> L19
    L16:
        invalidate();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public void onImageLoaded() {
    }

    public void onReady() {
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady() == false) goto L5;
        this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
    L6:
        invalidate();
        return;
    L5:
        this.sPendingCenter = new PointF(0.0f, 0.0f);
        goto L6
    }

    static {
        TAG = "SubsamplingScaleImageView";
        VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});
        VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
        VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
        VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
        VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    }

    private void createPaints() {
        if (this.bitmapPaint != null) goto L6;
        Paint r100 = new Paint();
        this.bitmapPaint = r100;
        r100.setAntiAlias(true);
        this.bitmapPaint.setFilterBitmap(true);
        this.bitmapPaint.setDither(true);
    L6:
        if (this.debugTextPaint == null) goto L10;
        if (this.debugLinePaint == null) goto L10;
        return;
    L10:
        if (this.debug == false) goto L14;
        Paint r101 = new Paint();
        this.debugTextPaint = r101;
        r101.setTextSize(px(12));
        this.debugTextPaint.setColor(FakePickerAvatarCreator.MAGENTA);
        this.debugTextPaint.setStyle(Paint.Style.FILL);
        Paint r102 = new Paint();
        this.debugLinePaint = r102;
        r102.setColor(FakePickerAvatarCreator.MAGENTA);
        this.debugLinePaint.setStyle(Paint.Style.STROKE);
        this.debugLinePaint.setStrokeWidth(px(1));
        return;
    }

    private int getRequiredRotation() {
        int r100 = this.orientation;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.sOrientation;
    }

    private boolean isBaseLayerReady() {
        boolean r100 = true;
        if (this.bitmap != null) goto L5;
    L7:
        Map<Integer, List<Tile>> r101 = this.tileMap;
        if (r101 == null) goto L23;
        Iterator<Map.Entry<Integer, List<Tile>>> r102 = r101.entrySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L22;
        Map.Entry<Integer, List<Tile>> r103 = r102.next();
        if (r103.getKey().intValue() != this.fullImageSampleSize) goto L11;
        Iterator<Tile> r104 = r103.getValue().iterator();
    L16:
        if (r104.hasNext() == false) goto L11;
        Tile r105 = r104.next();
        if (Tile.access$4000(r105) == true) goto L21;
        if (Tile.access$500(r105) != null) goto L16;
    L21:
        r100 = false;
        goto L16
    L22:
        return r100;
    L23:
        return false;
    L5:
        if (this.bitmapIsPreview == true) goto L7;
        return true;
    }

    public final ImageViewState getState() {
        if (this.vTranslate != null) goto L5;
        return null;
    L5:
        if (this.sWidth > 0) goto L7;
        return null;
    L7:
        if (this.sHeight > 0) goto L9;
        return null;
    L9:
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        if (this.uri == null) goto L5;
    L8:
        return true;
    L5:
        if (this.bitmap != null) goto L8;
        return false;
    }

    private boolean checkImageLoaded() {
        boolean r100 = isBaseLayerReady();
        if (this.imageLoadedSent == true) goto L8;
        if (r100 == false) goto L8;
        preDraw();
        this.imageLoadedSent = true;
        onImageLoaded();
        OnImageEventListener r101 = this.onImageEventListener;
        if (r101 == null) goto L8;
        r101.onImageLoaded();
    L8:
        return r100;
    }

    private boolean checkReady() {
        if (getWidth() > 0) goto L5;
    L15:
        boolean r100 = false;
    L17:
        if (this.readySent == true) goto L22;
        if (r100 == false) goto L22;
        preDraw();
        this.readySent = true;
        onReady();
        OnImageEventListener r101 = this.onImageEventListener;
        if (r101 == null) goto L22;
        r101.onReady();
    L22:
        return r100;
    L5:
        if (getHeight() <= 0) goto L15;
        if (this.sWidth <= 0) goto L15;
        if (this.sHeight <= 0) goto L15;
        if (this.bitmap == null) goto L13;
    L14:
        r100 = true;
        goto L17
    L13:
        if (isBaseLayerReady() == false) goto L15;
        goto L14
    }

    private float minScale() {
        int r100 = getPaddingBottom() + getPaddingTop();
        int r101 = getPaddingLeft() + getPaddingRight();
        int r102 = this.minimumScaleType;
        if (r102 == 2) goto L15;
        if (r102 == 4) goto L15;
        if (r102 != 3) goto L13;
        float r103 = this.minScale;
        if (r103 <= 0.0f) goto L13;
        return r103;
    L13:
        return Math.min((getWidth() - r101) / sWidth(), (getHeight() - r100) / sHeight());
    L15:
        return Math.max((getWidth() - r101) / sWidth(), (getHeight() - r100) / sHeight());
    }

    private void preDraw() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() != 0) goto L7;
        return;
    L7:
        if (this.sWidth > 0) goto L9;
        return;
    L9:
        if (this.sHeight > 0) goto L12;
        return;
    L12:
        if (this.sPendingCenter == null) goto L19;
        Float r100 = this.pendingScale;
        if (r100 == null) goto L19;
        this.scale = r100.floatValue();
        if (this.vTranslate != null) goto L18;
        this.vTranslate = new PointF();
    L18:
        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
        this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
        this.sPendingCenter = null;
        this.pendingScale = null;
        fitToBounds(true);
        refreshRequiredTiles(true);
    L19:
        fitToBounds(false);
    }

    private int sHeight() {
        int r100 = getRequiredRotation();
        if (r100 == 90) goto L10;
        if (r100 == 270) goto L10;
        return this.sHeight;
    L10:
        return this.sWidth;
    }

    private int sWidth() {
        int r100 = getRequiredRotation();
        if (r100 == 90) goto L10;
        if (r100 == 270) goto L10;
        return this.sWidth;
    L10:
        return this.sHeight;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public final float getMinScale() {
        return minScale();
    }

    public static /* synthetic */ String access$5400() {
        return TAG;
    }

    public static /* synthetic */ List access$6300() {
        return VALID_EASING_STYLES;
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    public SubsamplingScaleImageView(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ View.OnLongClickListener access$000(SubsamplingScaleImageView r100) {
        return r100.onLongClickListener;
    }

    public static /* synthetic */ float access$1000(SubsamplingScaleImageView r100) {
        return r100.scale;
    }

    public static /* synthetic */ boolean access$1400(SubsamplingScaleImageView r100) {
        return r100.zoomEnabled;
    }

    public static /* synthetic */ boolean access$1600(SubsamplingScaleImageView r100) {
        return r100.quickScaleEnabled;
    }

    public static /* synthetic */ PointF access$1700(SubsamplingScaleImageView r100) {
        return r100.vCenterStart;
    }

    public static /* synthetic */ PointF access$2200(SubsamplingScaleImageView r100) {
        return r100.quickScaleSCenter;
    }

    public static /* synthetic */ Rect access$5300(SubsamplingScaleImageView r100) {
        return r100.sRegion;
    }

    public static /* synthetic */ OnImageEventListener access$5600(SubsamplingScaleImageView r100) {
        return r100.onImageEventListener;
    }

    public static /* synthetic */ ReadWriteLock access$5700(SubsamplingScaleImageView r100) {
        return r100.decoderLock;
    }

    public static /* synthetic */ void access$5900(SubsamplingScaleImageView r100) {
        r100.onTileLoaded();
    }

    public static /* synthetic */ boolean access$600(SubsamplingScaleImageView r100) {
        return r100.panEnabled;
    }

    public static /* synthetic */ Anim access$6400(SubsamplingScaleImageView r100) {
        return r100.anim;
    }

    public static /* synthetic */ boolean access$700(SubsamplingScaleImageView r100) {
        return r100.readySent;
    }

    public static /* synthetic */ PointF access$800(SubsamplingScaleImageView r100) {
        return r100.vTranslate;
    }

    public static /* synthetic */ boolean access$900(SubsamplingScaleImageView r100) {
        return r100.isZooming;
    }

    private int calculateInSampleSize(float r100) {
        if (this.minimumTileDpi <= 0) goto L5;
        DisplayMetrics r101 = INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        r100 = r100 * (this.minimumTileDpi / ((r101.xdpi + r101.ydpi) / 2.0f));
    L5:
        int r102 = (int) (sWidth() * r100);
        int r103 = (int) (sHeight() * r100);
        if (r102 == 0) goto L23;
        if (r103 == 0) goto L27;
        int r104 = 1;
        if (sHeight() <= r103) goto L12;
    L15:
        int r105 = Math.round(sHeight() / r103);
        int r106 = Math.round(sWidth() / r102);
        if (r105 < r106) goto L19;
        r105 = r106;
    L19:
        int r107 = r104 * 2;
        if (r107 >= r105) goto L22;
        r104 = r107;
        goto L19
    L22:
        return r104;
    L12:
        if (sWidth() > r102) goto L15;
        r105 = 1;
        goto L19
    L27:
        return 32;
    L23:
        return 32;
    }

    private void execute(AsyncTask<Void, Void, ?> r100) {
        r100.executeOnExecutor(this.executor, new Void[0]);
    }

    private void fitToBounds(boolean r100) {
        float r101 = 0.0f;
        if (this.vTranslate != null) goto L5;
        this.vTranslate = new PointF(0.0f, 0.0f);
        boolean r102 = true;
    L7:
        if (this.satTemp != null) goto L9;
        this.satTemp = new ScaleAndTranslate(r101, new PointF(0.0f, 0.0f), null);
    L9:
        ScaleAndTranslate.access$4702(this.satTemp, this.scale);
        ScaleAndTranslate.access$4800(this.satTemp).set(this.vTranslate);
        fitToBounds(r100, this.satTemp);
        this.scale = ScaleAndTranslate.access$4700(this.satTemp);
        this.vTranslate.set(ScaleAndTranslate.access$4800(this.satTemp));
        if (r102 == true) goto L12;
        return;
    L12:
        if (this.minimumScaleType == 4) goto L16;
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
        return;
    L16:
        return;
    L5:
        r102 = false;
        goto L7
    }

    private Point getMaxBitmapDimensions(Canvas r100) {
        return new Point(Math.min(r100.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(r100.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    private synchronized void initialiseBaseLayer(Point r110) {
        monitor-enter(this);
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r110.x), Integer.valueOf(r110.y)});     // Catch: Throwable -> L22
        ScaleAndTranslate r100 = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);     // Catch: Throwable -> L22
        this.satTemp = r100;     // Catch: Throwable -> L22
        fitToBounds(true, r100);     // Catch: Throwable -> L22
        int r101 = calculateInSampleSize(ScaleAndTranslate.access$4700(this.satTemp));     // Catch: Throwable -> L22
        this.fullImageSampleSize = r101;     // Catch: Throwable -> L22
        if (r101 <= 1) goto L7;
        this.fullImageSampleSize = r101 / 2;     // Catch: Throwable -> L22
    L7:
        if (this.fullImageSampleSize == 1) goto L9;
    L15:
        initialiseTileMap(r110);     // Catch: Throwable -> L22
        Iterator<Tile> r111 = this.tileMap.get(Integer.valueOf(this.fullImageSampleSize)).iterator();     // Catch: Throwable -> L22
    L17:
        if (r111.hasNext() == false) goto L19;
        execute(new TileLoadTask(this, this.decoder, r111.next()));     // Catch: Throwable -> L22
        goto L17
    L19:
        refreshRequiredTiles(true);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L9:
        if (this.sRegion != null) goto L15;
        if (sWidth() >= r110.x) goto L15;
        if (sHeight() >= r110.y) goto L15;
        this.decoder.recycle();     // Catch: Throwable -> L22
        this.decoder = null;     // Catch: Throwable -> L22
        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private void initialiseTileMap(Point r110) {
        int r100 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r110.x), Integer.valueOf(r110.y)});
        this.tileMap = new LinkedHashMap();
        int r101 = this.fullImageSampleSize;
        int r102 = 1;
        int r103 = 1;
    L3:
        int r104 = sWidth() / r102;
        int r105 = sHeight() / r103;
        int r106 = r104 / r101;
        int r111 = r105 / r101;
    L5:
        if (((r106 + r102) + r100) > r110.x) goto L41;
        if (r106 <= (((double) getWidth()) * 1.25d)) goto L12;
        if (r101 < this.fullImageSampleSize) goto L41;
    L12:
        if (((r111 + r103) + r100) > r110.y) goto L40;
        if (r111 <= (((double) getHeight()) * 1.25d)) goto L18;
        if (r101 < this.fullImageSampleSize) goto L40;
    L18:
        ArrayList r107 = new ArrayList(r102 * r103);
        int r112 = 0;
    L19:
        if (r112 >= r102) goto L36;
        int r113 = 0;
    L21:
        if (r113 >= r103) goto L35;
        Tile r114 = new Tile(null);
        Tile.access$4302(r114, r101);
        if (r101 != this.fullImageSampleSize) goto L25;
        boolean r115 = true;
    L26:
        Tile.access$402(r114, r115);
        int r116 = r112 * r104;
        int r117 = r113 * r105;
        if (r112 != (r102 - 1)) goto L29;
        int r108 = sWidth();
    L31:
        if (r113 != (r103 - 1)) goto L33;
        int r109 = sHeight();
    L34:
        Tile.access$4102(r114, new Rect(r116, r117, r108, r109));
        Tile.access$4202(r114, new Rect(0, 0, 0, 0));
        Tile.access$5002(r114, new Rect(Tile.access$4100(r114)));
        r107.add(r114);
        r113 = r113 + 1;
        goto L21
    L33:
        r109 = (r113 + 1) * r105;
        goto L34
    L29:
        r108 = (r112 + 1) * r104;
        goto L31
    L25:
        r115 = false;
        goto L26
    L35:
        r112 = r112 + 1;
        goto L19
    L36:
        this.tileMap.put(Integer.valueOf(r101), r107);
        if (r101 == 1) goto L38;
        r101 = r101 / 2;
        r100 = 1;
        goto L3
    L38:
        return;
    L40:
        r103 = r103 + 1;
        r105 = sHeight() / r103;
        r111 = r105 / r101;
        r100 = 1;
    L41:
        r102 = r102 + 1;
        r104 = sWidth() / r102;
        r106 = r104 / r101;
        r100 = 1;
        goto L5
    }

    private float limitedScale(float r100) {
        float r101 = Math.max(minScale(), r100);
        return Math.min(this.maxScale, r101);
    }

    private synchronized void onPreviewLoaded(Bitmap r100) {
        monitor-enter(this);
        debug("onPreviewLoaded", new Object[0]);     // Catch: Throwable -> L20
        if (this.bitmap == null) goto L6;
    L17:
        r100.recycle();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (this.imageLoadedSent == true) goto L17;
        Rect r101 = this.pRegion;     // Catch: Throwable -> L20
        if (r101 == null) goto L11;
        this.bitmap = Bitmap.createBitmap(r100, r101.left, r101.top, r101.width(), this.pRegion.height());     // Catch: Throwable -> L20
    L12:
        this.bitmapIsPreview = true;     // Catch: Throwable -> L20
        if (checkReady() == false) goto L15;
        invalidate();     // Catch: Throwable -> L20
        requestLayout();     // Catch: Throwable -> L20
    L15:
        monitor-exit(this);
        return;
    L11:
        this.bitmap = r100;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private boolean onTouchEventInternal(MotionEvent r110) {
        int r100 = r110.getPointerCount();
        int r101 = r110.getAction();
        if (r101 == 0) goto L165;
        if (r101 == 1) goto L138;
        if (r101 == 2) goto L16;
        if (r101 == 5) goto L165;
        if (r101 == 6) goto L138;
        if (r101 == 261) goto L165;
        if (r101 == 262) goto L138;
    L137:
        return false;
    L16:
        if (this.maxTouchCount > 0) goto L18;
    L133:
        boolean r111 = false;
    L134:
        if (r111 == false) goto L137;
        this.handler.removeMessages(1);
        invalidate();
        return true;
    L18:
        if (r100 < 2) goto L47;
        float r102 = distance(r110.getX(0), r110.getX(1), r110.getY(0), r110.getY(1));
        float r103 = (r110.getX(0) + r110.getX(1)) / 2.0f;
        float r104 = (r110.getY(0) + r110.getY(1)) / 2.0f;
        if (this.zoomEnabled == false) goto L133;
        PointF r112 = this.vCenterStart;
        if (distance(r112.x, r103, r112.y, r104) <= 5.0f) goto L24;
    L27:
        this.isZooming = true;
        this.isPanning = true;
        double r105 = this.scale;
        float r113 = Math.min(this.maxScale, (r102 / this.vDistStart) * this.scaleStart);
        this.scale = r113;
        if (r113 > minScale()) goto L31;
        this.vDistStart = r102;
        this.scaleStart = minScale();
        this.vCenterStart.set(r103, r104);
        this.vTranslateStart.set(this.vTranslate);
    L45:
        fitToBounds(true);
        refreshRequiredTiles(this.eagerLoadingEnabled);
    L80:
        r111 = true;
        goto L134
    L31:
        if (this.panEnabled == false) goto L42;
        PointF r114 = this.vCenterStart;
        float r106 = r114.x;
        PointF r107 = this.vTranslateStart;
        float r108 = r106 - r107.x;
        float r115 = r114.y - r107.y;
        float r109 = this.scale;
        float r116 = this.scaleStart;
        float r117 = r108 * (r109 / r116);
        float r118 = r115 * (r109 / r116);
        PointF r119 = this.vTranslate;
        r119.x = r103 - r117;
        r119.y = r104 - r118;
        if ((((double) sHeight()) * r105) >= getHeight()) goto L37;
        if ((this.scale * sHeight()) < getHeight()) goto L37;
    L40:
        fitToBounds(true);
        this.vCenterStart.set(r103, r104);
        this.vTranslateStart.set(this.vTranslate);
        this.scaleStart = this.scale;
        this.vDistStart = r102;
    L37:
        if ((r105 * ((double) sWidth())) >= getWidth()) goto L45;
        if ((this.scale * sWidth()) < getWidth()) goto L45;
    L42:
        if (this.sRequestedCenter == null) goto L44;
        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
        this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
        goto L45
    L44:
        this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        goto L45
    L24:
        if (Math.abs(r102 - this.vDistStart) > 5.0f) goto L27;
        if (this.isPanning == false) goto L133;
    L47:
        if (this.isQuickScaling == false) goto L82;
        float r120 = (Math.abs(this.quickScaleVStart.y - r110.getY()) * 2.0f) + this.quickScaleThreshold;
        if (this.quickScaleLastDistance != (-1.0f)) goto L51;
        this.quickScaleLastDistance = r120;
    L51:
        float r121 = r110.getY();
        PointF r122 = this.quickScaleVLastPoint;
        if (r121 <= r122.y) goto L54;
        boolean r123 = true;
    L55:
        r122.set(0.0f, r110.getY());
        float r124 = 1.0f;
        float r125 = Math.abs(1.0f - (r120 / this.quickScaleLastDistance)) * 0.5f;
        if (r125 <= 0.03f) goto L58;
    L59:
        this.quickScaleMoved = true;
        if (this.quickScaleLastDistance <= 0.0f) goto L64;
        if (r123 == false) goto L63;
        r124 = r125 + 1.0f;
        goto L64
    L63:
        r124 = 1.0f - r125;
    L64:
        double r126 = this.scale;
        float r127 = Math.max(minScale(), Math.min(this.maxScale, this.scale * r124));
        this.scale = r127;
        if (this.panEnabled == false) goto L76;
        PointF r128 = this.vCenterStart;
        float r129 = r128.x;
        PointF r130 = this.vTranslateStart;
        float r131 = r129 - r130.x;
        float r132 = r128.y;
        float r133 = r132 - r130.y;
        float r134 = this.scaleStart;
        float r135 = r131 * (r127 / r134);
        float r136 = r133 * (r127 / r134);
        PointF r137 = this.vTranslate;
        r137.x = r129 - r135;
        r137.y = r132 - r136;
        if ((((double) sHeight()) * r126) >= getHeight()) goto L71;
        if ((this.scale * sHeight()) < getHeight()) goto L71;
    L74:
        fitToBounds(true);
        this.vCenterStart.set(sourceToViewCoord(this.quickScaleSCenter));
        this.vTranslateStart.set(this.vTranslate);
        this.scaleStart = this.scale;
        r120 = 0.0f;
    L79:
        this.quickScaleLastDistance = r120;
        fitToBounds(true);
        refreshRequiredTiles(this.eagerLoadingEnabled);
    L71:
        if ((r126 * ((double) sWidth())) >= getWidth()) goto L79;
        if ((this.scale * sWidth()) < getWidth()) goto L79;
    L76:
        if (this.sRequestedCenter == null) goto L78;
        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
        this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
        goto L79
    L78:
        this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        goto L79
    L58:
        if (this.quickScaleMoved == false) goto L79;
    L54:
        r123 = false;
        goto L55
    L82:
        if (this.isZooming == true) goto L133;
        float r138 = Math.abs(r110.getX() - this.vCenterStart.x);
        float r139 = Math.abs(r110.getY() - this.vCenterStart.y);
        float r140 = this.density * 5.0f;
        if (r138 <= r140) goto L86;
    L89:
        this.vTranslate.x = this.vTranslateStart.x + (r110.getX() - this.vCenterStart.x);
        this.vTranslate.y = this.vTranslateStart.y + (r110.getY() - this.vCenterStart.y);
        PointF r141 = this.vTranslate;
        float r142 = r141.x;
        float r143 = r141.y;
        fitToBounds(true);
        PointF r144 = this.vTranslate;
        if (r142 == r144.x) goto L92;
        boolean r145 = true;
    L93:
        float r146 = r144.y;
        if (r143 == r146) goto L96;
        boolean r147 = true;
    L97:
        if (r145 == true) goto L99;
    L103:
        boolean r148 = false;
    L104:
        if (r147 == true) goto L106;
    L110:
        boolean r149 = false;
    L112:
        if (r143 == r146) goto L114;
    L116:
        boolean r150 = false;
    L117:
        if (r148 == true) goto L125;
        if (r149 == true) goto L125;
        if (r145 == false) goto L124;
        if (r147 == false) goto L124;
        if (r150 == true) goto L124;
        if (this.isPanning == false) goto L125;
    L124:
        this.isPanning = true;
    L130:
        if (this.panEnabled == true) goto L132;
        PointF r151 = this.vTranslate;
        PointF r152 = this.vTranslateStart;
        r151.x = r152.x;
        r151.y = r152.y;
        requestDisallowInterceptTouchEvent(false);
    L132:
        refreshRequiredTiles(this.eagerLoadingEnabled);
    L125:
        if (r138 <= r140) goto L127;
    L128:
        this.maxTouchCount = 0;
        this.handler.removeMessages(1);
        requestDisallowInterceptTouchEvent(false);
        goto L130
    L127:
        if (r139 <= r140) goto L130;
    L114:
        if (r139 <= (3.0f * r140)) goto L116;
        r150 = true;
        goto L117
    L106:
        if (r139 <= r138) goto L110;
        if (this.isPanning == true) goto L110;
        r149 = true;
        goto L112
    L99:
        if (r138 <= r139) goto L103;
        if (this.isPanning == true) goto L103;
        r148 = true;
        goto L104
    L96:
        r147 = false;
        goto L97
    L92:
        r145 = false;
        goto L93
    L86:
        if (r139 > r140) goto L89;
        if (this.isPanning == false) goto L133;
    L138:
        this.handler.removeMessages(1);
        if (this.isQuickScaling == false) goto L144;
        this.isQuickScaling = false;
        if (this.quickScaleMoved == true) goto L144;
        doubleTapZoom(this.quickScaleSCenter, this.vCenterStart);
    L144:
        if (this.maxTouchCount <= 0) goto L162;
        boolean r153 = this.isZooming;
        if (r153 == false) goto L148;
    L149:
        if (r153 == false) goto L156;
        if (r100 != 2) goto L156;
        this.isPanning = true;
        PointF r154 = this.vTranslateStart;
        PointF r155 = this.vTranslate;
        r154.set(r155.x, r155.y);
        if (r110.getActionIndex() != 1) goto L154;
        this.vCenterStart.set(r110.getX(0), r110.getY(0));
        goto L156
    L154:
        this.vCenterStart.set(r110.getX(1), r110.getY(1));
    L156:
        if (r100 >= 3) goto L158;
        this.isZooming = false;
    L158:
        if (r100 >= 2) goto L160;
        this.isPanning = false;
        this.maxTouchCount = 0;
    L160:
        refreshRequiredTiles(true);
        return true;
    L148:
        if (this.isPanning == true) goto L149;
    L162:
        if (r100 != 1) goto L164;
        this.isZooming = false;
        this.isPanning = false;
        this.maxTouchCount = 0;
    L164:
        return true;
    L165:
        this.anim = null;
        requestDisallowInterceptTouchEvent(true);
        this.maxTouchCount = Math.max(this.maxTouchCount, r100);
        if (r100 < 2) goto L173;
        if (this.zoomEnabled == false) goto L170;
        float r156 = distance(r110.getX(0), r110.getX(1), r110.getY(0), r110.getY(1));
        this.scaleStart = this.scale;
        this.vDistStart = r156;
        PointF r157 = this.vTranslateStart;
        PointF r158 = this.vTranslate;
        r157.set(r158.x, r158.y);
        this.vCenterStart.set((r110.getX(0) + r110.getX(1)) / 2.0f, (r110.getY(0) + r110.getY(1)) / 2.0f);
    L171:
        this.handler.removeMessages(1);
    L175:
        return true;
    L170:
        this.maxTouchCount = 0;
        goto L171
    L173:
        if (this.isQuickScaling == true) goto L175;
        PointF r159 = this.vTranslateStart;
        PointF r160 = this.vTranslate;
        r159.set(r160.x, r160.y);
        this.vCenterStart.set(r110.getX(), r110.getY());
        this.handler.sendEmptyMessageDelayed(1, 600);
        goto L175
    }

    private int px(int r100) {
        return (int) (this.density * r100);
    }

    private void refreshRequiredTiles(boolean r100) {
        if (this.decoder != null) goto L5;
        return;
    L5:
        if (this.tileMap == null) goto L63;
        int r101 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> r102 = this.tileMap.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L64;
        Iterator<Tile> r103 = r102.next().getValue().iterator();
    L12:
        if (r103.hasNext() == false) goto L9;
        Tile r104 = r103.next();
        if (Tile.access$4300(r104) >= r101) goto L16;
    L19:
        Tile.access$402(r104, false);
        if (Tile.access$500(r104) == null) goto L23;
        Tile.access$500(r104).recycle();
        Tile.access$502(r104, null);
    L23:
        if (Tile.access$4300(r104) == r101) goto L25;
        if (Tile.access$4300(r104) != this.fullImageSampleSize) goto L12;
        Tile.access$402(r104, true);
        goto L12
    L25:
        if (tileVisible(r104) == true) goto L26;
        if (Tile.access$4300(r104) == this.fullImageSampleSize) goto L12;
        Tile.access$402(r104, false);
        if (Tile.access$500(r104) == null) goto L12;
        Tile.access$500(r104).recycle();
        Tile.access$502(r104, null);
        goto L12
    L26:
        Tile.access$402(r104, true);
        if (Tile.access$4000(r104) == true) goto L12;
        if (Tile.access$500(r104) != null) goto L12;
        if (r100 == false) goto L12;
        execute(new TileLoadTask(this, this.decoder, r104));
        goto L12
    L16:
        if (Tile.access$4300(r104) <= r101) goto L23;
        if (Tile.access$4300(r104) == this.fullImageSampleSize) goto L23;
    L64:
        return;
    }

    private void requestDisallowInterceptTouchEvent(boolean r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    private void reset(boolean r100) {
        debug("reset newImage=" + r100, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (r100 == false) goto L24;
        this.uri = null;
        this.decoderLock.writeLock().lock();
        ImageRegionDecoder r101 = this.decoder;     // Catch: Throwable -> L21
        if (r101 == null) goto L8;
        r101.recycle();     // Catch: Throwable -> L21
        this.decoder = null;     // Catch: Throwable -> L21
    L8:
        this.decoderLock.writeLock().unlock();
        Bitmap r102 = this.bitmap;
        if (r102 == null) goto L14;
        if (this.bitmapIsCached == true) goto L14;
        r102.recycle();
    L14:
        if (this.bitmap != null) goto L16;
    L20:
        this.sWidth = 0;
        this.sHeight = 0;
        this.sOrientation = 0;
        this.sRegion = null;
        this.pRegion = null;
        this.readySent = false;
        this.imageLoadedSent = false;
        this.bitmap = null;
        this.bitmapIsPreview = false;
        this.bitmapIsCached = false;
        goto L24
    L16:
        if (this.bitmapIsCached == false) goto L20;
        OnImageEventListener r103 = this.onImageEventListener;
        if (r103 == null) goto L20;
        r103.onPreviewReleased();
    L21:
        th = move-exception;
        this.decoderLock.writeLock().unlock();
        throw th;
    L24:
        Map<Integer, List<Tile>> r104 = this.tileMap;
        if (r104 == null) goto L36;
        Iterator<Map.Entry<Integer, List<Tile>>> r105 = r104.entrySet().iterator();
    L28:
        if (r105.hasNext() == false) goto L35;
        Iterator<Tile> r106 = r105.next().getValue().iterator();
    L31:
        if (r106.hasNext() == false) goto L28;
        Tile r107 = r106.next();
        Tile.access$402(r107, false);
        if (Tile.access$500(r107) == null) goto L31;
        Tile.access$500(r107).recycle();
        Tile.access$502(r107, null);
        goto L31
    L35:
        this.tileMap = null;
    L36:
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(r100.getOrientation())) == false) goto L8;
        this.orientation = r100.getOrientation();
        this.pendingScale = Float.valueOf(r100.getScale());
        this.sPendingCenter = r100.getCenter();
        invalidate();
        return;
    }

    private void setGestureDetector(final Context r100) {
        this.detector = new GestureDetector(r100, new AnonymousClass2(this, r100));
        this.singleDetector = new GestureDetector(r100, new AnonymousClass3(this));
    }

    public static void setPreferredBitmapConfig(Bitmap.Config r100) {
        preferredBitmapConfig = r100;
    }

    private float sourceToViewX(float r100) {
        PointF r101 = this.vTranslate;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 * this.scale) + r101.x;
    }

    private float sourceToViewY(float r100) {
        PointF r101 = this.vTranslate;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 * this.scale) + r101.y;
    }

    private boolean tileVisible(Tile r100) {
        float r101 = viewToSourceX(0.0f);
        float r102 = viewToSourceX(getWidth());
        float r103 = viewToSourceY(0.0f);
        float r104 = viewToSourceY(getHeight());
        if (r101 <= Tile.access$4100(r100).right) goto L5;
    L11:
        return false;
    L5:
        if (Tile.access$4100(r100).left > r102) goto L11;
        if (r103 > Tile.access$4100(r100).bottom) goto L11;
        if (Tile.access$4100(r100).top > r104) goto L11;
        return true;
    }

    private float viewToSourceX(float r100) {
        PointF r101 = this.vTranslate;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 - r101.x) / this.scale;
    }

    private float viewToSourceY(float r100) {
        PointF r101 = this.vTranslate;
        if (r101 != null) goto L7;
        return Float.NaN;
    L7:
        return (r100 - r101.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF r100) {
        AnonymousClass1 r101 = null;
        if (isReady() == true) goto L6;
        return null;
    L6:
        return new AnimationBuilder(this, r100, r101);
    }

    public AnimationBuilder animateScale(float r100) {
        AnonymousClass1 r101 = null;
        if (isReady() == true) goto L6;
        return null;
    L6:
        return new AnimationBuilder(this, r100, r101);
    }

    public final void getPanRemaining(RectF r100) {
        if (isReady() == true) goto L5;
        return;
    L5:
        float r101 = this.scale * sWidth();
        float r102 = this.scale * sHeight();
        int r103 = this.panLimit;
        if (r103 != 3) goto L8;
        r100.top = Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
        r100.left = Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
        r100.bottom = Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - r102));
        r100.right = Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - r101));
        return;
    L8:
        if (r103 != 2) goto L10;
        r100.top = Math.max(0.0f, -(this.vTranslate.y - getHeight()));
        r100.left = Math.max(0.0f, -(this.vTranslate.x - getWidth()));
        r100.bottom = Math.max(0.0f, this.vTranslate.y + r102);
        r100.right = Math.max(0.0f, this.vTranslate.x + r101);
        return;
    L10:
        r100.top = Math.max(0.0f, -this.vTranslate.y);
        r100.left = Math.max(0.0f, -this.vTranslate.x);
        r100.bottom = Math.max(0.0f, (r102 + this.vTranslate.y) - getHeight());
        r100.right = Math.max(0.0f, (r101 + this.vTranslate.x) - getWidth());
    }

    @Override // android.view.View
    public void onDraw(Canvas r310) {
        super.onDraw(r310);
        createPaints();
        if (this.sWidth != 0) goto L5;
        return;
    L5:
        if (this.sHeight != 0) goto L7;
        return;
    L7:
        if (getWidth() != 0) goto L9;
        return;
    L9:
        if (getHeight() != 0) goto L12;
        return;
    L12:
        if (this.tileMap != null) goto L17;
        if (this.decoder == null) goto L17;
        initialiseBaseLayer(getMaxBitmapDimensions(r310));
    L17:
        if (checkReady() == true) goto L19;
        return;
    L19:
        preDraw();
        Anim r100 = this.anim;
        if (r100 == null) goto L45;
        if (Anim.access$3100(r100) == null) goto L45;
        float r101 = this.scale;
        if (this.vTranslateBefore != null) goto L26;
        this.vTranslateBefore = new PointF(0.0f, 0.0f);
    L26:
        this.vTranslateBefore.set(this.vTranslate);
        long r102 = System.currentTimeMillis() - Anim.access$3200(this.anim);
        if (r102 <= Anim.access$3300(this.anim)) goto L29;
        boolean r110 = true;
    L30:
        long r111 = Math.min(r102, Anim.access$3300(this.anim));
        this.scale = ease(Anim.access$3400(this.anim), r111, Anim.access$3500(this.anim), Anim.access$3600(this.anim) - Anim.access$3500(this.anim), Anim.access$3300(this.anim));
        float r112 = ease(Anim.access$3400(this.anim), r111, Anim.access$3100(this.anim).x, Anim.access$3700(this.anim).x - Anim.access$3100(this.anim).x, Anim.access$3300(this.anim));
        float r103 = ease(Anim.access$3400(this.anim), r111, Anim.access$3100(this.anim).y, Anim.access$3700(this.anim).y - Anim.access$3100(this.anim).y, Anim.access$3300(this.anim));
        this.vTranslate.x -= sourceToViewX(Anim.access$3800(this.anim).x) - r112;
        this.vTranslate.y -= sourceToViewY(Anim.access$3800(this.anim).y) - r103;
        if (r110 == false) goto L33;
    L36:
        boolean r104 = true;
    L37:
        fitToBounds(r104);
        sendStateChanged(r101, this.vTranslateBefore, Anim.access$3900(this.anim));
        refreshRequiredTiles(r110);
        if (r110 == true) goto L40;
    L43:
        invalidate();
        goto L45
    L40:
        if (Anim.access$2800(this.anim) != null) goto L164;
    L42:
        this.anim = null;
        goto L43
    L164:
        Anim.access$2800(this.anim).onComplete();     // Catch: Exception -> L163
        goto L42
    L33:
        if (Anim.access$3500(this.anim) == Anim.access$3600(this.anim)) goto L36;
        r104 = false;
        goto L37
    L29:
        r110 = false;
    L45:
        if (this.tileMap != null) goto L47;
    L112:
        int r113 = 5;
        Bitmap r105 = this.bitmap;
        if (r105 == null) goto L146;
        float r106 = this.scale;
        if (this.bitmapIsPreview == false) goto L117;
        r106 = r106 * (this.sWidth / r105.getWidth());
        float r107 = this.scale * (this.sHeight / this.bitmap.getHeight());
    L119:
        if (this.matrix != null) goto L121;
        this.matrix = new Matrix();
    L121:
        this.matrix.reset();
        this.matrix.postScale(r106, r107);
        this.matrix.postRotate(getRequiredRotation());
        Matrix r108 = this.matrix;
        PointF r109 = this.vTranslate;
        r108.postTranslate(r109.x, r109.y);
        if (getRequiredRotation() != 180) goto L125;
        Matrix r114 = this.matrix;
        float r115 = this.scale;
        r114.postTranslate(this.sWidth * r115, r115 * this.sHeight);
    L131:
        if (this.tileBgPaint != null) goto L133;
    L144:
        r310.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
        goto L146
    L133:
        if (this.sRect != null) goto L135;
        this.sRect = new RectF();
    L135:
        RectF r116 = this.sRect;
        if (this.bitmapIsPreview == false) goto L138;
        int r117 = this.bitmap.getWidth();
    L139:
        float r118 = r117;
        if (this.bitmapIsPreview == false) goto L142;
        int r119 = this.bitmap.getHeight();
    L143:
        r116.set(0.0f, 0.0f, r118, r119);
        this.matrix.mapRect(this.sRect);
        r310.drawRect(this.sRect, this.tileBgPaint);
        goto L144
    L142:
        r119 = this.sHeight;
        goto L143
    L138:
        r117 = this.sWidth;
        goto L139
    L125:
        if (getRequiredRotation() != 90) goto L128;
        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
        goto L131
    L128:
        if (getRequiredRotation() != 270) goto L131;
        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
        goto L131
    L117:
        r107 = r106;
    L146:
        if (this.debug == false) goto L186;
        StringBuilder r120 = new StringBuilder("Scale: ");
        Locale r121 = Locale.ENGLISH;
        r120.append(String.format(r121, "%.2f", new Object[]{Float.valueOf(this.scale)}));
        r120.append(" (");
        r120.append(String.format(r121, "%.2f", new Object[]{Float.valueOf(minScale())}));
        r120.append(" - ");
        r120.append(String.format(r121, "%.2f", new Object[]{Float.valueOf(this.maxScale)}));
        r120.append(")");
        r310.drawText(r120.toString(), px(r113), px(15), this.debugTextPaint);
        r310.drawText("Translate: " + String.format(r121, "%.2f", new Object[]{Float.valueOf(this.vTranslate.x)}) + ":" + String.format(r121, "%.2f", new Object[]{Float.valueOf(this.vTranslate.y)}), px(r113), px(30), this.debugTextPaint);
        PointF r122 = getCenter();
        r310.drawText("Source center: " + String.format(r121, "%.2f", new Object[]{Float.valueOf(r122.x)}) + ":" + String.format(r121, "%.2f", new Object[]{Float.valueOf(r122.y)}), px(r113), px(45), this.debugTextPaint);
        Anim r123 = this.anim;
        if (r123 == null) goto L151;
        PointF r124 = sourceToViewCoord(Anim.access$4400(r123));
        PointF r125 = sourceToViewCoord(Anim.access$4500(this.anim));
        PointF r126 = sourceToViewCoord(Anim.access$3800(this.anim));
        r310.drawCircle(r124.x, r124.y, px(10), this.debugLinePaint);
        this.debugLinePaint.setColor(-65536);
        r310.drawCircle(r125.x, r125.y, px(20), this.debugLinePaint);
        this.debugLinePaint.setColor(FakePickerAvatarCreator.BLUE);
        r310.drawCircle(r126.x, r126.y, px(25), this.debugLinePaint);
        this.debugLinePaint.setColor(FakePickerAvatarCreator.CYAN);
        r310.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
    L151:
        if (this.vCenterStart == null) goto L154;
        this.debugLinePaint.setColor(-65536);
        PointF r127 = this.vCenterStart;
        r310.drawCircle(r127.x, r127.y, px(20), this.debugLinePaint);
    L154:
        if (this.quickScaleSCenter == null) goto L157;
        this.debugLinePaint.setColor(FakePickerAvatarCreator.BLUE);
        r310.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(35), this.debugLinePaint);
    L157:
        if (this.quickScaleVStart != null) goto L159;
    L161:
        this.debugLinePaint.setColor(FakePickerAvatarCreator.MAGENTA);
        return;
    L159:
        if (this.isQuickScaling == false) goto L161;
        this.debugLinePaint.setColor(FakePickerAvatarCreator.CYAN);
        PointF r128 = this.quickScaleVStart;
        r310.drawCircle(r128.x, r128.y, px(30), this.debugLinePaint);
        goto L161
    L186:
        return;
    L47:
        if (isBaseLayerReady() == false) goto L112;
        int r129 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> r130 = this.tileMap.entrySet().iterator();
        boolean r131 = false;
    L50:
        if (r130.hasNext() == false) goto L63;
        Map.Entry<Integer, List<Tile>> r132 = r130.next();
        if (r132.getKey().intValue() != r129) goto L50;
        Iterator<Tile> r133 = r132.getValue().iterator();
    L55:
        if (r133.hasNext() == false) goto L50;
        Tile r134 = r133.next();
        if (Tile.access$400(r134) == false) goto L55;
        if (Tile.access$4000(r134) == true) goto L62;
        if (Tile.access$500(r134) != null) goto L55;
    L62:
        r131 = true;
        goto L55
    L63:
        Iterator<Map.Entry<Integer, List<Tile>>> r135 = this.tileMap.entrySet().iterator();
    L65:
        if (r135.hasNext() == false) goto L111;
        Map.Entry<Integer, List<Tile>> r136 = r135.next();
        if (r136.getKey().intValue() == r129) goto L71;
        if (r131 == true) goto L71;
    L110:
        r129 = r129;
    L71:
        Iterator<Tile> r137 = r136.getValue().iterator();
    L73:
        if (r137.hasNext() == false) goto L110;
        Tile r138 = r137.next();
        sourceToViewRect(Tile.access$4100(r138), Tile.access$4200(r138));
        if (Tile.access$4000(r138) == false) goto L77;
    L99:
        int r210 = r129;
        int r139 = 5;
        if (Tile.access$4000(r138) == true) goto L102;
    L105:
        if (Tile.access$400(r138) == false) goto L109;
        if (this.debug == false) goto L109;
        r310.drawText("ISS " + Tile.access$4300(r138) + " RECT " + Tile.access$4100(r138).top + "," + Tile.access$4100(r138).left + "," + Tile.access$4100(r138).bottom + "," + Tile.access$4100(r138).right, Tile.access$4200(r138).left + px(r139), Tile.access$4200(r138).top + px(15), this.debugTextPaint);
    L109:
        r129 = r210;
        goto L73
    L102:
        if (this.debug == false) goto L105;
        r310.drawText("LOADING", Tile.access$4200(r138).left + px(5), Tile.access$4200(r138).top + px(35), this.debugTextPaint);
        goto L105
    L77:
        if (Tile.access$500(r138) == null) goto L99;
        if (this.tileBgPaint == null) goto L82;
        r310.drawRect(Tile.access$4200(r138), this.tileBgPaint);
    L82:
        if (this.matrix != null) goto L84;
        this.matrix = new Matrix();
    L84:
        this.matrix.reset();
        r139 = 5;
        r210 = r129;
        setMatrixArray(this.srcArray, 0.0f, 0.0f, Tile.access$500(r138).getWidth(), 0.0f, Tile.access$500(r138).getWidth(), Tile.access$500(r138).getHeight(), 0.0f, Tile.access$500(r138).getHeight());
        if (getRequiredRotation() != 0) goto L88;
        setMatrixArray(this.dstArray, Tile.access$4200(r138).left, Tile.access$4200(r138).top, Tile.access$4200(r138).right, Tile.access$4200(r138).top, Tile.access$4200(r138).right, Tile.access$4200(r138).bottom, Tile.access$4200(r138).left, Tile.access$4200(r138).bottom);
    L96:
        this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
        r310.drawBitmap(Tile.access$500(r138), this.matrix, this.bitmapPaint);
        if (this.debug == false) goto L105;
        r310.drawRect(Tile.access$4200(r138), this.debugLinePaint);
        goto L105
    L88:
        if (getRequiredRotation() != 90) goto L91;
        setMatrixArray(this.dstArray, Tile.access$4200(r138).right, Tile.access$4200(r138).top, Tile.access$4200(r138).right, Tile.access$4200(r138).bottom, Tile.access$4200(r138).left, Tile.access$4200(r138).bottom, Tile.access$4200(r138).left, Tile.access$4200(r138).top);
        goto L96
    L91:
        if (getRequiredRotation() != 180) goto L94;
        setMatrixArray(this.dstArray, Tile.access$4200(r138).right, Tile.access$4200(r138).bottom, Tile.access$4200(r138).left, Tile.access$4200(r138).bottom, Tile.access$4200(r138).left, Tile.access$4200(r138).top, Tile.access$4200(r138).right, Tile.access$4200(r138).top);
        goto L96
    L94:
        if (getRequiredRotation() != 270) goto L96;
        setMatrixArray(this.dstArray, Tile.access$4200(r138).left, Tile.access$4200(r138).bottom, Tile.access$4200(r138).left, Tile.access$4200(r138).top, Tile.access$4200(r138).right, Tile.access$4200(r138).top, Tile.access$4200(r138).right, Tile.access$4200(r138).bottom);
        goto L96
    L111:
        r113 = 5;
        goto L146
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Anim r101 = this.anim;
        if (r101 != null) goto L5;
    L8:
        Anim r102 = this.anim;
        if (r102 != null) goto L11;
    L15:
        this.anim = null;
        if (this.vTranslate != null) goto L22;
        GestureDetector r103 = this.singleDetector;
        if (r103 == null) goto L20;
        r103.onTouchEvent(r100);
    L20:
        return true;
    L22:
        if (this.isQuickScaling == true) goto L30;
        GestureDetector r104 = this.detector;
        if (r104 != null) goto L26;
    L27:
        this.isZooming = false;
        this.isPanning = false;
        this.maxTouchCount = 0;
        return true;
    L26:
        if (r104.onTouchEvent(r100) == true) goto L27;
    L30:
        if (this.vTranslateStart != null) goto L33;
        this.vTranslateStart = new PointF(0.0f, 0.0f);
    L33:
        if (this.vTranslateBefore != null) goto L36;
        this.vTranslateBefore = new PointF(0.0f, 0.0f);
    L36:
        if (this.vCenterStart != null) goto L38;
        this.vCenterStart = new PointF(0.0f, 0.0f);
    L38:
        float r105 = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean r106 = onTouchEventInternal(r100);
        sendStateChanged(r105, this.vTranslateBefore, 2);
        if (r106 == false) goto L41;
        return true;
    L41:
        if (super.onTouchEvent(r100) == true) goto L48;
        return false;
    L48:
        return true;
    L11:
        if (Anim.access$2800(r102) == null) goto L15;
        Anim.access$2800(this.anim).onInterruptedByUser();     // Catch: Exception -> L14
        goto L15
    L5:
        if (Anim.access$2700(r101) == true) goto L8;
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> r100) {
        if (r100 == null) goto L6;
        this.bitmapDecoderFactory = new CompatDecoderFactory(r100);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> r100) {
        if (r100 == null) goto L6;
        this.bitmapDecoderFactory = r100;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean r100) {
        this.debug = r100;
    }

    public final void setDoubleTapZoomDpi(int r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        setDoubleTapZoomScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setDoubleTapZoomDuration(int r100) {
        this.doubleTapZoomDuration = Math.max(0, r100);
    }

    public final void setDoubleTapZoomScale(float r100) {
        this.doubleTapZoomScale = r100;
    }

    public final void setDoubleTapZoomStyle(int r100) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(r100)) == false) goto L7;
        this.doubleTapZoomStyle = r100;
        return;
    L7:
        throw new IllegalArgumentException("Invalid zoom style: " + r100);
    }

    public void setEagerLoadingEnabled(boolean r100) {
        this.eagerLoadingEnabled = r100;
    }

    public void setExecutor(Executor r100) {
        if (r100 == null) goto L6;
        this.executor = r100;
        return;
    L6:
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(ImageSource r100) {
        setImage(r100, null, null);
    }

    public final void setMaxScale(float r100) {
        this.maxScale = r100;
    }

    public void setMaxTileSize(int r100) {
        this.maxTileWidth = r100;
        this.maxTileHeight = r100;
    }

    public final void setMaximumDpi(int r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        setMinScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setMinScale(float r100) {
        this.minScale = r100;
    }

    public final void setMinimumDpi(int r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        setMaxScale(((r101.xdpi + r101.ydpi) / 2.0f) / r100);
    }

    public final void setMinimumScaleType(int r100) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(r100)) == false) goto L9;
        this.minimumScaleType = r100;
        if (isReady() == false) goto L10;
        fitToBounds(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid scale type: " + r100);
    }

    public void setMinimumTileDpi(int r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        this.minimumTileDpi = (int) Math.min((r101.xdpi + r101.ydpi) / 2.0f, r100);
        if (isReady() == false) goto L6;
        reset(false);
        invalidate();
        return;
    }

    public void setOnImageEventListener(OnImageEventListener r100) {
        this.onImageEventListener = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.onLongClickListener = r100;
    }

    public void setOnStateChangedListener(OnStateChangedListener r100) {
        this.onStateChangedListener = r100;
    }

    public final void setOrientation(int r100) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(r100)) == false) goto L7;
        this.orientation = r100;
        reset(false);
        invalidate();
        requestLayout();
        return;
    L7:
        throw new IllegalArgumentException("Invalid orientation: " + r100);
    }

    public final void setPanEnabled(boolean r100) {
        this.panEnabled = r100;
        if (r100 == true) goto L10;
        PointF r101 = this.vTranslate;
        if (r101 == null) goto L11;
        r101.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady() == false) goto L12;
        refreshRequiredTiles(true);
        invalidate();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setPanLimit(int r100) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(r100)) == false) goto L9;
        this.panLimit = r100;
        if (isReady() == false) goto L10;
        fitToBounds(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid pan limit: " + r100);
    }

    public final void setQuickScaleEnabled(boolean r100) {
        this.quickScaleEnabled = r100;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> r100) {
        if (r100 == null) goto L6;
        this.regionDecoderFactory = new CompatDecoderFactory(r100);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> r100) {
        if (r100 == null) goto L6;
        this.regionDecoderFactory = r100;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setTileBackgroundColor(int r100) {
        if (Color.alpha(r100) != 0) goto L5;
        this.tileBgPaint = null;
    L6:
        invalidate();
        return;
    L5:
        Paint r101 = new Paint();
        this.tileBgPaint = r101;
        r101.setStyle(Paint.Style.FILL);
        this.tileBgPaint.setColor(r100);
        goto L6
    }

    public final void setZoomEnabled(boolean r100) {
        this.zoomEnabled = r100;
    }

    public final PointF sourceToViewCoord(PointF r100) {
        return sourceToViewCoord(r100.x, r100.y, new PointF());
    }

    public final PointF viewToSourceCoord(PointF r100) {
        return viewToSourceCoord(r100.x, r100.y, new PointF());
    }

    public void visibleFileRect(Rect r100) {
        if (this.vTranslate != null) goto L5;
        return;
    L5:
        if (this.readySent == false) goto L10;
        r100.set(0, 0, getWidth(), getHeight());
        viewToFileRect(r100, r100);
        return;
    }

    public SubsamplingScaleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(r100);
        this.handler = new Handler(new AnonymousClass1(this));
        if (r101 == null) goto L29;
        TypedArray r102 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.assetName, R.attr.panEnabled, R.attr.quickScaleEnabled, R.attr.src, R.attr.tileBackgroundColor, R.attr.zoomEnabled});
        if (r102.hasValue(0) == false) goto L12;
        String r103 = r102.getString(0);
        if (r103 == null) goto L12;
        if (r103.length() <= 0) goto L12;
        setImage(ImageSource.asset(r103).tilingEnabled());
    L12:
        if (r102.hasValue(3) == false) goto L17;
        int r104 = r102.getResourceId(3, 0);
        if (r104 <= 0) goto L17;
        setImage(ImageSource.resource(r104).tilingEnabled());
    L17:
        if (r102.hasValue(1) == false) goto L20;
        setPanEnabled(r102.getBoolean(1, true));
    L20:
        if (r102.hasValue(5) == false) goto L23;
        setZoomEnabled(r102.getBoolean(5, true));
    L23:
        if (r102.hasValue(2) == false) goto L26;
        setQuickScaleEnabled(r102.getBoolean(2, true));
    L26:
        if (r102.hasValue(4) == false) goto L28;
        setTileBackgroundColor(r102.getColor(4, Color.argb(0, 0, 0, 0)));
    L28:
        r102.recycle();
    L29:
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, INVOKEVIRTUAL_com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static /* synthetic */ int access$102(SubsamplingScaleImageView r100, int r101) {
        r100.maxTouchCount = r101;
        return r101;
    }

    public static /* synthetic */ void access$1500(SubsamplingScaleImageView r100, Context r101) {
        r100.setGestureDetector(r101);
    }

    public static /* synthetic */ PointF access$1702(SubsamplingScaleImageView r100, PointF r101) {
        r100.vCenterStart = r101;
        return r101;
    }

    public static /* synthetic */ PointF access$1802(SubsamplingScaleImageView r100, PointF r101) {
        r100.vTranslateStart = r101;
        return r101;
    }

    public static /* synthetic */ float access$1902(SubsamplingScaleImageView r100, float r101) {
        r100.scaleStart = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2002(SubsamplingScaleImageView r100, boolean r101) {
        r100.isQuickScaling = r101;
        return r101;
    }

    public static /* synthetic */ void access$201(SubsamplingScaleImageView r100, View.OnLongClickListener r101) {
        super.setOnLongClickListener(r101);
    }

    public static /* synthetic */ float access$2102(SubsamplingScaleImageView r100, float r101) {
        r100.quickScaleLastDistance = r101;
        return r101;
    }

    public static /* synthetic */ PointF access$2202(SubsamplingScaleImageView r100, PointF r101) {
        r100.quickScaleSCenter = r101;
        return r101;
    }

    public static /* synthetic */ PointF access$2302(SubsamplingScaleImageView r100, PointF r101) {
        r100.quickScaleVStart = r101;
        return r101;
    }

    public static /* synthetic */ PointF access$2402(SubsamplingScaleImageView r100, PointF r101) {
        r100.quickScaleVLastPoint = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2502(SubsamplingScaleImageView r100, boolean r101) {
        r100.quickScaleMoved = r101;
        return r101;
    }

    public static /* synthetic */ void access$301(SubsamplingScaleImageView r100, View.OnLongClickListener r101) {
        super.setOnLongClickListener(r101);
    }

    public static /* synthetic */ void access$6000(SubsamplingScaleImageView r100, Bitmap r101) {
        r100.onPreviewLoaded(r101);
    }

    public static /* synthetic */ Anim access$6402(SubsamplingScaleImageView r100, Anim r101) {
        r100.anim = r101;
        return r101;
    }

    public static /* synthetic */ float access$6500(SubsamplingScaleImageView r100, float r101) {
        return r100.limitedScale(r101);
    }

    public static /* synthetic */ boolean access$902(SubsamplingScaleImageView r100, boolean r101) {
        r100.isZooming = r101;
        return r101;
    }

    private void debug(String r100, Object... r101) {
        if (this.debug == false) goto L6;
        String.format(r100, r101);
        return;
    }

    private void doubleTapZoom(PointF r110, PointF r111) {
        if (this.panEnabled == true) goto L8;
        PointF r100 = this.sRequestedCenter;
        if (r100 == null) goto L7;
        r110.x = r100.x;
        r110.y = r100.y;
        goto L8
    L7:
        r110.x = sWidth() / 2;
        r110.y = sHeight() / 2;
    L8:
        float r101 = Math.min(this.maxScale, this.doubleTapZoomScale);
        float r102 = this.scale;
        if (r102 > (((double) r101) * 0.9d)) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        r101 = minScale();
    L18:
        float r104 = r101;
        int r105 = this.doubleTapZoomStyle;
        if (r105 != 3) goto L22;
        setScaleAndCenter(r104, r110);
    L30:
        invalidate();
        return;
    L22:
        if (r105 == 2) goto L29;
        if (r103 == false) goto L29;
        if (this.panEnabled == false) goto L29;
        if (r105 != 1) goto L30;
        AnimationBuilder.access$1300(new AnimationBuilder(this, r104, r110, r111, null).withInterruptible(false).withDuration(this.doubleTapZoomDuration), 4).start();
    L29:
        AnimationBuilder.access$1300(new AnimationBuilder(this, r104, r110, null).withInterruptible(false).withDuration(this.doubleTapZoomDuration), 4).start();
        goto L30
    L11:
        if (r102 == this.minScale) goto L14;
        r103 = false;
        goto L15
    }

    private void fileSRect(Rect r100, Rect r101) {
        if (getRequiredRotation() != 0) goto L6;
        r101.set(r100);
        return;
    L6:
        if (getRequiredRotation() != 90) goto L9;
        int r102 = r100.top;
        int r103 = this.sHeight;
        r101.set(r102, r103 - r100.right, r100.bottom, r103 - r100.left);
        return;
    L9:
        if (getRequiredRotation() != 180) goto L11;
        int r104 = this.sWidth;
        int r105 = r104 - r100.right;
        int r106 = this.sHeight;
        r101.set(r105, r106 - r100.bottom, r104 - r100.left, r106 - r100.top);
        return;
    L11:
        int r107 = this.sWidth;
        r101.set(r107 - r100.bottom, r100.left, r107 - r100.top, r100.right);
    }

    private void fitToBounds(boolean r110, ScaleAndTranslate r111) {
        if (this.panLimit == 2) goto L5;
    L7:
        PointF r100 = ScaleAndTranslate.access$4800(r111);
        float r101 = limitedScale(ScaleAndTranslate.access$4700(r111));
        float r102 = sWidth() * r101;
        float r103 = sHeight() * r101;
        if (this.panLimit == 3) goto L10;
    L12:
        if (r110 == false) goto L14;
        r100.x = Math.max(r100.x, getWidth() - r102);
        r100.y = Math.max(r100.y, getHeight() - r103);
    L15:
        float r104 = 0.5f;
        if (getPaddingLeft() <= 0) goto L18;
    L21:
        float r105 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    L23:
        if (getPaddingTop() <= 0) goto L25;
    L26:
        r104 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    L28:
        if (this.panLimit == 3) goto L30;
    L32:
        if (r110 == false) goto L34;
        float r112 = Math.max(0.0f, (getWidth() - r102) * r105);
        float r106 = Math.max(0.0f, (getHeight() - r103) * r104);
    L36:
        r100.x = Math.min(r100.x, r112);
        r100.y = Math.min(r100.y, r106);
        ScaleAndTranslate.access$4702(r111, r101);
        return;
    L34:
        r112 = Math.max(0, getWidth());
        int r107 = Math.max(0, getHeight());
    L35:
        r106 = r107;
        goto L36
    L30:
        if (isReady() == false) goto L32;
        r112 = Math.max(0, getWidth() / 2);
        r107 = Math.max(0, getHeight() / 2);
        goto L35
    L25:
        if (getPaddingBottom() <= 0) goto L28;
    L18:
        if (getPaddingRight() > 0) goto L21;
        r105 = 0.5f;
        goto L23
    L14:
        r100.x = Math.max(r100.x, -r102);
        r100.y = Math.max(r100.y, -r103);
        goto L15
    L10:
        if (isReady() == false) goto L12;
        r100.x = Math.max(r100.x, (getWidth() / 2) - r102);
        r100.y = Math.max(r100.y, (getHeight() / 2) - r103);
        goto L15
    L5:
        if (isReady() == false) goto L7;
        r110 = false;
        goto L7
    }

    private int getExifOrientation(Context r110, String r111) {
        int r100 = 0;
        if (r111.startsWith("content") == false) goto L24;
        Cursor r101 = null;
        ContentResolver r102 = r110.getContentResolver();     // Catch: Throwable -> L17 Exception -> L21
        Uri r103 = Uri.parse(r111);     // Catch: Throwable -> L17 Exception -> L21
        r101 = com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_android_content_ContentResolver_query(r102, r103, new String[]{"orientation"}, null, null, null);     // Catch: Throwable -> L17 Exception -> L21
        if (r101 != null) goto L8;
    L15:
        if (r101 == null) goto L47;
    L16:
        r101.close();
        return r100;
    L47:
        return r100;
    L8:
        if (r101.moveToFirst() == false) goto L15;
        int r112 = r101.getInt(0);     // Catch: Throwable -> L17 Exception -> L21
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(r112)) == true) goto L12;
    L14:
    L12:
        if (r112 == (-1)) goto L14;
        r100 = r112;
    L21:
        if (r101 != null) goto L16;
        return 0;
    L17:
        th = move-exception;
        if (r101 == null) goto L20;
        r101.close();
    L20:
        throw th;
    L24:
        if (r111.startsWith("file:///") == true) goto L26;
        return 0;
    L26:
        if (r111.startsWith("file:///android_asset/") == true) goto L51;
        int r113 = new ExifInterface(r111.substring(7)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);     // Catch: Exception -> L42
        if (r113 == 1) goto L52;
        if (r113 != 0) goto L32;
        return 0;
    L32:
        if (r113 != 6) goto L35;
        return 90;
    L35:
        if (r113 != 3) goto L38;
        return 180;
    L38:
        if (r113 == 8) goto L56;
        return 0;
    L56:
        return 270;
    L52:
        return 0;
    L57:
        return 0;
    L51:
        return 0;
    }

    private void sourceToViewRect(Rect r100, Rect r101) {
        r101.set((int) sourceToViewX(r100.left), (int) sourceToViewY(r100.top), (int) sourceToViewX(r100.right), (int) sourceToViewY(r100.bottom));
    }

    public AnimationBuilder animateScaleAndCenter(float r100, PointF r101) {
        AnonymousClass1 r102 = null;
        if (isReady() == true) goto L6;
        return null;
    L6:
        return new AnimationBuilder(this, r100, r101, r102);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        boolean r106 = true;
        if (r102 == 1073741824) goto L5;
        boolean r107 = true;
    L6:
        if (r103 != 1073741824) goto L10;
        r106 = false;
    L10:
        if (this.sWidth > 0) goto L12;
    L20:
        setMeasuredDimension(Math.max(r104, getSuggestedMinimumWidth()), Math.max(r105, getSuggestedMinimumHeight()));
        return;
    L12:
        if (this.sHeight <= 0) goto L20;
        if (r107 == false) goto L16;
        if (r106 == false) goto L16;
        r104 = sWidth();
        r105 = sHeight();
    L16:
        if (r106 == false) goto L18;
        r105 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) r104));
        goto L20
    L18:
        if (r107 == false) goto L20;
        r104 = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) r105));
        goto L20
    L5:
        r107 = false;
        goto L6
    }

    public final void setImage(ImageSource r100, ImageSource r101) {
        setImage(r100, r101, null);
    }

    public void setMaxTileSize(int r100, int r101) {
        this.maxTileWidth = r100;
        this.maxTileHeight = r101;
    }

    public final void setScaleAndCenter(float r100, PointF r101) {
        this.anim = null;
        this.pendingScale = Float.valueOf(r100);
        this.sPendingCenter = r101;
        this.sRequestedCenter = r101;
        invalidate();
    }

    public final PointF sourceToViewCoord(float r100, float r101) {
        return sourceToViewCoord(r100, r101, new PointF());
    }

    public void viewToFileRect(Rect r100, Rect r101) {
        if (this.vTranslate != null) goto L5;
        return;
    L5:
        if (this.readySent == false) goto L13;
        r101.set((int) viewToSourceX(r100.left), (int) viewToSourceY(r100.top), (int) viewToSourceX(r100.right), (int) viewToSourceY(r100.bottom));
        fileSRect(r101, r101);
        r101.set(Math.max(0, r101.left), Math.max(0, r101.top), Math.min(this.sWidth, r101.right), Math.min(this.sHeight, r101.bottom));
        Rect r102 = this.sRegion;
        if (r102 == null) goto L12;
        r101.offset(r102.left, r102.top);
        return;
    L12:
        return;
    }

    public final PointF viewToSourceCoord(float r100, float r101) {
        return viewToSourceCoord(r100, r101, new PointF());
    }

    public final void setImage(ImageSource r100, ImageViewState r101) {
        setImage(r100, null, r101);
    }

    public final PointF sourceToViewCoord(PointF r100, PointF r101) {
        return sourceToViewCoord(r100.x, r100.y, r101);
    }

    public final PointF viewToSourceCoord(PointF r100, PointF r101) {
        return viewToSourceCoord(r100.x, r100.y, r101);
    }

    public static /* synthetic */ void access$2600(SubsamplingScaleImageView r100, PointF r101, PointF r102) {
        r100.doubleTapZoom(r101, r102);
    }

    public static /* synthetic */ void access$5100(SubsamplingScaleImageView r100, String r101, Object[] r102) {
        r100.debug(r101, r102);
    }

    public static /* synthetic */ int access$5200(SubsamplingScaleImageView r100, Context r101, String r102) {
        return r100.getExifOrientation(r101, r102);
    }

    public static /* synthetic */ void access$5800(SubsamplingScaleImageView r100, Rect r101, Rect r102) {
        r100.fileSRect(r101, r102);
    }

    public static /* synthetic */ void access$6800(SubsamplingScaleImageView r100, boolean r101, ScaleAndTranslate r102) {
        r100.fitToBounds(r101, r102);
    }

    private synchronized void onImageLoaded(Bitmap r100, int r101, boolean r102) {
        monitor-enter(this);
        debug("onImageLoaded", new Object[0]);     // Catch: Throwable -> L30
        int r103 = this.sWidth;     // Catch: Throwable -> L30
        if (r103 > 0) goto L6;
    L12:
        Bitmap r104 = this.bitmap;     // Catch: Throwable -> L30
        if (r104 == null) goto L18;
        if (this.bitmapIsCached == true) goto L18;
        r104.recycle();     // Catch: Throwable -> L30
    L18:
        if (this.bitmap != null) goto L20;
    L24:
        this.bitmapIsPreview = false;     // Catch: Throwable -> L30
        this.bitmapIsCached = r102;     // Catch: Throwable -> L30
        this.bitmap = r100;     // Catch: Throwable -> L30
        this.sWidth = r100.getWidth();     // Catch: Throwable -> L30
        this.sHeight = r100.getHeight();     // Catch: Throwable -> L30
        this.sOrientation = r101;     // Catch: Throwable -> L30
        boolean r105 = checkReady();     // Catch: Throwable -> L30
        boolean r106 = checkImageLoaded();     // Catch: Throwable -> L30
        if (r105 == true) goto L27;
        if (r106 == true) goto L27;
    L28:
        monitor-exit(this);
        return;
    L27:
        invalidate();     // Catch: Throwable -> L30
        requestLayout();     // Catch: Throwable -> L30
        goto L28
    L20:
        if (this.bitmapIsCached == false) goto L24;
        OnImageEventListener r107 = this.onImageEventListener;     // Catch: Throwable -> L30
        if (r107 == null) goto L24;
        r107.onPreviewReleased();     // Catch: Throwable -> L30
        goto L24
    L6:
        if (this.sHeight <= 0) goto L12;
        if (r103 == r100.getWidth()) goto L10;
    L11:
        reset(false);     // Catch: Throwable -> L30
        goto L12
    L10:
        if (this.sHeight == r100.getHeight()) goto L12;
    L30:
        th = move-exception;
        throw th;
    }

    private void sendStateChanged(float r100, PointF r101, int r102) {
        OnStateChangedListener r103 = this.onStateChangedListener;
        if (r103 == null) goto L8;
        float r104 = this.scale;
        if (r104 == r100) goto L8;
        r103.onScaleChanged(r104, r102);
    L8:
        if (this.onStateChangedListener != null) goto L10;
        return;
    L10:
        if (this.vTranslate.equals(r101) == true) goto L14;
        this.onStateChangedListener.onCenterChanged(getCenter(), r102);
        return;
    }

    private PointF vTranslateForSCenter(float r100, float r101, float r102) {
        int r103 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int r104 = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp != null) goto L5;
        this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
    L5:
        ScaleAndTranslate.access$4702(this.satTemp, r102);
        ScaleAndTranslate.access$4800(this.satTemp).set(r103 - (r100 * r102), r104 - (r101 * r102));
        fitToBounds(true, this.satTemp);
        return ScaleAndTranslate.access$4800(this.satTemp);
    }

    public final void setImage(ImageSource r100, ImageSource r110, ImageViewState r111) {
        if (r100 == null) goto L49;
        reset(true);
        if (r111 == null) goto L7;
        restoreState(r111);
    L7:
        if (r110 == null) goto L28;
        if (r100.getBitmap() != null) goto L26;
        if (r100.getSWidth() <= 0) goto L24;
        if (r100.getSHeight() <= 0) goto L24;
        this.sWidth = r100.getSWidth();
        this.sHeight = r100.getSHeight();
        this.pRegion = r110.getSRegion();
        if (r110.getBitmap() == null) goto L17;
        this.bitmapIsCached = r110.isCached();
        onPreviewLoaded(r110.getBitmap());
        goto L28
    L17:
        Uri r101 = r110.getUri();
        if (r101 == null) goto L20;
    L22:
        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, r101, true));
        goto L28
    L20:
        if (r110.getResource() == null) goto L22;
        r101 = UriProtector.parse("android.resource://" + getContext().getPackageName() + HTTP.URL_DEFAULT + r110.getResource());
    L24:
        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
    L26:
        throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
    L28:
        if (r100.getBitmap() == null) goto L33;
        if (r100.getSRegion() == null) goto L33;
        onImageLoaded(Bitmap.createBitmap(r100.getBitmap(), r100.getSRegion().left, r100.getSRegion().top, r100.getSRegion().width(), r100.getSRegion().height()), 0, false);
        return;
    L33:
        if (r100.getBitmap() == null) goto L35;
        onImageLoaded(r100.getBitmap(), 0, r100.isCached());
        return;
    L35:
        this.sRegion = r100.getSRegion();
        Uri r112 = r100.getUri();
        this.uri = r112;
        if (r112 != null) goto L41;
        if (r100.getResource() == null) goto L41;
        this.uri = UriProtector.parse("android.resource://" + getContext().getPackageName() + HTTP.URL_DEFAULT + r100.getResource());
    L41:
        if (r100.getTile() == false) goto L43;
    L46:
        execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
        return;
    L43:
        if (this.sRegion != null) goto L46;
        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        return;
    L49:
        throw new NullPointerException("imageSource must not be null");
    }

    public final PointF sourceToViewCoord(float r100, float r101, PointF r102) {
        if (this.vTranslate != null) goto L6;
        return null;
    L6:
        r102.set(sourceToViewX(r100), sourceToViewY(r101));
        return r102;
    }

    public final PointF viewToSourceCoord(float r100, float r101, PointF r102) {
        if (this.vTranslate != null) goto L6;
        return null;
    L6:
        r102.set(viewToSourceX(r100), viewToSourceY(r101));
        return r102;
    }

    public static /* synthetic */ void access$6100(SubsamplingScaleImageView r100, Bitmap r101, int r102, boolean r103) {
        r100.onImageLoaded(r101, r102, r103);
    }

    private float distance(float r100, float r101, float r102, float r103) {
        float r104 = r100 - r101;
        float r105 = r102 - r103;
        return (float) Math.sqrt((r104 * r104) + (r105 * r105));
    }

    private PointF limitedSCenter(float r100, float r101, float r102, PointF r103) {
        PointF r104 = vTranslateForSCenter(r100, r101, r102);
        r103.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - r104.x) / r102, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - r104.y) / r102);
        return r103;
    }

    private synchronized void onTilesInited(ImageRegionDecoder r100, int r101, int r102, int r103) {
        monitor-enter(this);
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[]{Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(this.orientation)});     // Catch: Throwable -> L37
        int r104 = this.sWidth;     // Catch: Throwable -> L37
        if (r104 <= 0) goto L20;
        int r105 = this.sHeight;     // Catch: Throwable -> L37
        if (r105 <= 0) goto L20;
        if (r104 != r101) goto L9;
        if (r105 == r102) goto L20;
    L9:
        reset(false);     // Catch: Throwable -> L37
        Bitmap r106 = this.bitmap;     // Catch: Throwable -> L37
        if (r106 == null) goto L20;
        if (this.bitmapIsCached == true) goto L14;
        r106.recycle();     // Catch: Throwable -> L37
    L14:
        this.bitmap = null;     // Catch: Throwable -> L37
        OnImageEventListener r107 = this.onImageEventListener;     // Catch: Throwable -> L37
        if (r107 != null) goto L17;
    L19:
        this.bitmapIsPreview = false;     // Catch: Throwable -> L37
        this.bitmapIsCached = false;     // Catch: Throwable -> L37
        goto L20
    L17:
        if (this.bitmapIsCached == false) goto L19;
        r107.onPreviewReleased();     // Catch: Throwable -> L37
    L20:
        this.decoder = r100;     // Catch: Throwable -> L37
        this.sWidth = r101;     // Catch: Throwable -> L37
        this.sHeight = r102;     // Catch: Throwable -> L37
        this.sOrientation = r103;     // Catch: Throwable -> L37
        checkReady();     // Catch: Throwable -> L37
        if (checkImageLoaded() == true) goto L34;
        int r108 = this.maxTileWidth;     // Catch: Throwable -> L37
        if (r108 <= 0) goto L34;
        if (r108 == Integer.MAX_VALUE) goto L34;
        int r109 = this.maxTileHeight;     // Catch: Throwable -> L37
        if (r109 <= 0) goto L34;
        if (r109 == Integer.MAX_VALUE) goto L34;
        if (getWidth() <= 0) goto L34;
        if (getHeight() <= 0) goto L34;
        initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));     // Catch: Throwable -> L37
    L34:
        invalidate();     // Catch: Throwable -> L37
        requestLayout();     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        debug("onSizeChanged %dx%d -> %dx%d", new Object[]{Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r100), Integer.valueOf(r101)});
        PointF r104 = getCenter();
        if (this.readySent == false) goto L7;
        if (r104 == null) goto L8;
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = r104;
        return;
    L8:
        return;
    }

    public static /* synthetic */ void access$5500(SubsamplingScaleImageView r100, ImageRegionDecoder r101, int r102, int r103, int r104) {
        r100.onTilesInited(r101, r102, r103, r104);
    }

    public static /* synthetic */ PointF access$6600(SubsamplingScaleImageView r100, float r101, float r102, float r103, PointF r104) {
        return r100.limitedSCenter(r101, r102, r103, r104);
    }

    private float ease(int r100, long r101, float r110, float r111, long r112) {
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L9;
        return easeInOutQuad(r101, r110, r111, r112);
    L9:
        throw new IllegalStateException("Unexpected easing type: " + r100);
    L11:
        return easeOutQuad(r101, r110, r111, r112);
    }

    private static Cursor com_davemorrissey_labs_subscaleview_SubsamplingScaleImageView_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }

    private void setMatrixArray(float[] r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r110) {
        r100[0] = r101;
        r100[1] = r102;
        r100[2] = r103;
        r100[3] = r104;
        r100[4] = r105;
        r100[5] = r106;
        r100[6] = r107;
        r100[7] = r110;
    }
}
