package com.ss.android.bytedcert.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;

/* JADX INFO: loaded from: classes34.dex */
public class VideoRecordButton extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f407786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f407787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f407788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f407789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f407790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f407791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f407792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f407793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f407794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f407795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f407796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f407797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f407798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f407799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f407800o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f407801p;

    public static final enum StopType extends Enum<StopType> {
        public static final StopType CLICK = null;
        public static final StopType RELEASE = null;
        public static final StopType TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StopType[] f407802a = null;

        static {
            StopType r100 = new StopType("RELEASE", 0);
            RELEASE = r100;
            StopType r101 = new StopType("TIMEOUT", 1);
            TIMEOUT = r101;
            StopType r102 = new StopType("CLICK", 2);
            CLICK = r102;
            f407802a = new StopType[]{r100, r101, r102};
        }

        public static StopType[] values() {
            return (StopType[]) f407802a.clone();
        }

        public static StopType valueOf(String r100) {
            return (StopType) r27.a.a(StopType.class, r100);
        }

        public StopType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordButton f407803a;

        @Override // com.ss.android.bytedcert.view.VideoRecordButton.d
        public final void a1() {
            VideoRecordButton r100 = this.f407803a;
            r100.f407795j = true;
            r100.f407797l = System.currentTimeMillis();
            this.f407803a.f407800o.sendEmptyMessage(2);
            d r101 = this.f407803a.f407786a;
            if (r101 == null) goto L6;
            r101.a1();
            return;
        }

        public a(VideoRecordButton r100) {
            this.f407803a = r100;
        }

        @Override // com.ss.android.bytedcert.view.VideoRecordButton.d
        public final void a(StopType r100) {
            VideoRecordButton r101 = this.f407803a;
            r101.f407795j = false;
            r101.f407800o.removeMessages(2);
            d r102 = this.f407803a.f407786a;
            if (r102 == null) goto L6;
            r102.a(r100);
            return;
        }

        @Override // com.ss.android.bytedcert.view.VideoRecordButton.d
        public final void b(long r100) {
            d r101 = this.f407803a.f407786a;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordButton f407804a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            VideoRecordButton r102 = this.f407804a;
            r102.f407796k = true;
            r102.f407787b.a1();
            return;
        L5:
            if (r101 != 2) goto L15;
            long r103 = System.currentTimeMillis();
            VideoRecordButton r104 = this.f407804a;
            long r105 = r103 - r104.f407797l;
            if (r105 < r104.f407799n) goto L10;
            r104.f407795j = false;
            r104.f407787b.a(StopType.TIMEOUT);
            return;
        L10:
            r104.f407787b.b(r105);
            VideoRecordButton r106 = this.f407804a;
            r106.f407798m = (r105 / r106.f407799n) * 360.0f;
            r106.f407800o.sendEmptyMessageDelayed(2, 100);
            this.f407804a.invalidate();
            return;
        }

        public b(VideoRecordButton r100, Looper r101) {
            this.f407804a = r100;
            super(r101);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordButton f407805a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f407805a.f407800o.sendEmptyMessage(1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VideoRecordButton r100) {
            this.f407805a = r100;
        }
    }

    public interface d {
        void a(StopType r100);

        void a1();

        void b(long r100);
    }

    public final void a() {
        Paint r100 = new Paint();
        this.f407788c = r100;
        r100.setAntiAlias(true);
        this.f407788c.setStyle(Paint.Style.STROKE);
        Paint r101 = new Paint();
        this.f407789d = r101;
        r101.setAntiAlias(true);
        this.f407789d.setStyle(Paint.Style.FILL);
        this.f407789d.setColor(-1);
        this.f407790e = new RectF();
        this.f407791f = new RectF();
    }

    public final void b() {
        invalidate();
        this.f407795j = false;
        this.f407800o.removeCallbacksAndMessages(null);
    }

    public VideoRecordButton(Context r100) {
        super(r100);
        this.f407787b = new a(this);
        this.f407795j = false;
        this.f407796k = false;
        this.f407799n = 20000;
        this.f407800o = new b(this, Looper.getMainLooper());
        this.f407801p = new c(this);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        float r100 = getWidth() / 2.0f;
        float r101 = getHeight() / 2.0f;
        if (this.f407795j == false) goto L5;
        this.f407789d.setColor(FakePickerAvatarCreator.GRAY);
        r110.drawCircle(r100, r101, this.f407792g + 5.0f, this.f407789d);
        this.f407788c.setColor(-65536);
        this.f407788c.setStrokeWidth(10.0f);
        RectF r102 = this.f407790e;
        float r103 = this.f407792g;
        r102.set(r100 - r103, r101 - r103, r100 + r103, r103 + r101);
        r110.drawArc(this.f407790e, -90.0f, this.f407798m, false, this.f407788c);
        this.f407789d.setColor(-1);
        r110.drawCircle(r100, r101, this.f407794i - 8.0f, this.f407789d);
        this.f407789d.setColor(-65536);
        RectF r104 = this.f407791f;
        float r105 = this.f407794i;
        r104.set(r100 - (r105 / 3.0f), r101 - (r105 / 3.0f), r100 + (r105 / 3.0f), r101 + (r105 / 3.0f));
        r110.drawRoundRect(this.f407791f, 8.0f, 8.0f, this.f407789d);
        return;
    L5:
        this.f407788c.setColor(-1);
        this.f407788c.setStrokeWidth(6.0f);
        r110.drawCircle(r100, r101, this.f407793h, this.f407788c);
        this.f407789d.setColor(-65536);
        r110.drawCircle(r100, r101, this.f407794i, this.f407789d);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L16;
        if (r101 != 1) goto L6;
    L8:
        this.f407800o.removeCallbacks(this.f407801p);
        if (this.f407796k == false) goto L12;
        this.f407787b.a(StopType.RELEASE);
    L15:
        invalidate();
    L17:
        return true;
    L12:
        if (this.f407795j == false) goto L14;
        this.f407787b.a(StopType.CLICK);
        goto L15
    L14:
        this.f407787b.a1();
        goto L15
    L6:
        if (r101 == 3) goto L8;
    L16:
        this.f407796k = false;
        this.f407800o.postDelayed(this.f407801p, 500);
        invalidate();
        goto L17
    }

    public void setMaxDuration(int r100) {
        this.f407799n = r100;
    }

    public void setOnRecordListener(d r100) {
        this.f407786a = r100;
    }

    public VideoRecordButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f407787b = new a(this);
        this.f407795j = false;
        this.f407796k = false;
        this.f407799n = 20000;
        this.f407800o = new b(this, Looper.getMainLooper());
        this.f407801p = new c(this);
        a();
    }

    public VideoRecordButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407787b = new a(this);
        this.f407795j = false;
        this.f407796k = false;
        this.f407799n = 20000;
        this.f407800o = new b(this, Looper.getMainLooper());
        this.f407801p = new c(this);
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = (Math.min(r100, r101) / 2.0f) - 5.0f;
        this.f407792g = r104;
        float r105 = r104 / 1.8f;
        this.f407793h = r105;
        this.f407794i = r105 - 12.0f;
    }
}
