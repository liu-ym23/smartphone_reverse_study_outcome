package com.obric.oui.progress;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public class OProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f402529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f402530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f402531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f402532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f402533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402538j;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f402539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f402540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f402541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f402542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f402543e;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f402539a = r100.readInt();
            this.f402540b = r100.readInt();
            this.f402541c = r100.readInt();
            this.f402542d = r100.readInt();
            this.f402543e = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f402539a);
            r100.writeInt(this.f402540b);
            r100.writeInt(this.f402541c);
            r100.writeInt(this.f402542d);
            r100.writeInt(this.f402543e);
        }
    }

    public final void a() {
        if (this.f402537i == 0) goto L6;
        this.f402535g = ContextCompat.getColor(getContext(), this.f402537i);
    L6:
        if (this.f402538j == 0) goto L8;
        this.f402536h = ContextCompat.getColor(getContext(), this.f402538j);
    L8:
        invalidate();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f402539a = this.f402534f;
        r100.f402540b = this.f402537i;
        r100.f402541c = this.f402538j;
        r100.f402542d = this.f402535g;
        r100.f402543e = this.f402536h;
        return r100;
    }

    public int getBackgroundColor() {
        return this.f402536h;
    }

    public int getProgress() {
        return this.f402534f;
    }

    public int getProgressColor() {
        return this.f402535g;
    }

    public OProgressView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f402529a != null) goto L5;
        this.f402529a = new Paint();
    L5:
        this.f402529a.reset();
        this.f402529a.setStyle(Paint.Style.FILL);
        this.f402529a.setAntiAlias(true);
        float r101 = getHeight();
        float r102 = (r101 - this.f402533e) / 2.0f;
        if (this.f402531c != null) goto L8;
        this.f402531c = new RectF();
    L8:
        float r103 = r101 - r102;
        this.f402531c.set(0.0f, r102, getWidth(), r103);
        if (this.f402532d != null) goto L11;
        this.f402532d = new RectF();
    L11:
        this.f402532d.set(0.0f, r102, (getWidth() * getProgress()) / 100.0f, r103);
        r100.save();
        this.f402530b.reset();
        Path r104 = this.f402530b;
        RectF r105 = this.f402531c;
        float r106 = this.f402533e;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        r100.clipPath(this.f402530b);
        this.f402529a.setColor(this.f402536h);
        r100.drawRect(this.f402531c, this.f402529a);
        this.f402529a.setColor(this.f402535g);
        r100.drawRect(this.f402532d, this.f402529a);
        r100.restore();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setProgress(r101.f402539a);
        this.f402537i = r101.f402540b;
        this.f402538j = r101.f402541c;
        this.f402535g = r101.f402542d;
        this.f402536h = r101.f402543e;
        a();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f402538j = 0;
        this.f402536h = r100;
        invalidate();
    }

    public void setProgress(int r100) {
        if (this.f402534f != r100) goto L5;
        return;
    L5:
        if (r100 > 0) goto L8;
        r100 = 0;
    L10:
        this.f402534f = r100;
        invalidate();
        return;
    L8:
        if (r100 < 100) goto L10;
        r100 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r100) {
        this.f402533e = r100;
    }

    public void setProgressColor(int r100) {
        this.f402537i = 0;
        this.f402535g = r100;
        invalidate();
    }

    public OProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, 0);
        this.f402530b = new Path();
        this.f402537i = 0;
        this.f402538j = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_background_color, R.attr.oui_background_height, R.attr.oui_progress, R.attr.oui_progress_color}, r102, 0);
        this.f402534f = r103.getInt(2, 0);
        this.f402537i = r103.getResourceId(3, R.color.oui_fill_highlighted);
        this.f402538j = r103.getResourceId(0, R.color.oui_line_2);
        Resources r104 = Resources.getSystem();
        setProgressBackgroundHeight(r103.getDimensionPixelSize(1, (int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 6.0f)));
        a();
        r103.recycle();
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
