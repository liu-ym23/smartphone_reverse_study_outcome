package com.larus.login.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0014J(\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u001aJ\u0010\u00106\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u001cJ\u0010\u00108\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u001eR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lcom/larus/login/impl/SideIndexBar;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIndexItems", "", "", "mItemHeight", "", "mTextSize", "mTextColor", "mTextTouchedColor", "mCurrentIndex", "mPaint", "Landroid/graphics/Paint;", "mTouchedPaint", "mWidth", "mHeight", "mTopMargin", "mOverlayTextView", "Landroid/widget/TextView;", "mCenterTextView", "Lcom/larus/login/impl/CenterTextView;", "mOnIndexChangedListener", "Lcom/larus/login/impl/SideIndexBar$OnIndexTouchedChangedListener;", "navigationBarHeight", "getNavigationBarHeight", "()I", "setNavigationBarHeight", "(I)V", "setIndexItems", "", "mutableList", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "performClick", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setOverlayTextView", "overlay", "setCenterTextView", "centerTextView", "setOnIndexChangedListener", "listener", "OnIndexTouchedChangedListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideIndexBar extends View {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f357209k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f357210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f357211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f357212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f357213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f357214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f357215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f357216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f357217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f357218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f357219j;

    public static final class a {
    }

    public interface b {
        void onIndexChanged(String r100);
    }

    public SideIndexBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SideIndexBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        String[] r100 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "G", FaceService.neutralLabel, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
    L6:
        f357209k = r100;
        return;
    L5:
        r100 = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, FaceService.girlLabel, "G", FaceService.neutralLabel, "J", "K", "L", "M", "N", "P", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        goto L6
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public final int getNavigationBarHeight() {
        return this.f357219j;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = this.f357210a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        String r102 = (String) ListProtector.get(this.f357210a, r101);
        Paint.FontMetrics r103 = this.f357213d.getFontMetrics();
        float r104 = 2;
        float r105 = (this.f357215f - this.f357213d.measureText(r102)) / r104;
        float r106 = this.f357211b;
        float r107 = r103.bottom;
        float r108 = ((((r106 / r104) + ((r107 - r103.top) / r104)) - r107) + (r106 * r101)) + this.f357217h;
        if (r101 != this.f357212c) goto L7;
        Paint r109 = this.f357214e;
    L8:
        r110.drawText(r102, r105, r108, r109);
        r101 = r101 + 1;
        goto L3
    L7:
        r109 = this.f357213d;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.performClick();
        int r101 = r100.getAction();
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L6;
    L10:
        this.f357212c = -1;
        invalidate();
    L26:
        return true;
    L6:
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L10;
    L11:
        float r102 = r100.getY() - this.f357217h;
        int r103 = this.f357210a.size();
        int r104 = (int) (r102 / this.f357211b);
        if (r104 >= 0) goto L14;
        r104 = 0;
    L17:
        if (this.f357218i == null) goto L26;
        if (r104 < 0) goto L26;
        if (r104 >= r103) goto L26;
        if (r104 == this.f357212c) goto L26;
        this.f357212c = r104;
        String r105 = (String) ListProtector.get(this.f357210a, r104);
        b r106 = this.f357218i;
        if (r106 == null) goto L25;
        r106.onIndexChanged(r105);
    L25:
        invalidate();
        goto L26
    L14:
        if (r104 < r103) goto L17;
        r104 = r103 - 1;
        goto L17
    }

    public final void setIndexItems(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "mutableList");
        this.f357210a = r100;
    }

    public final void setNavigationBarHeight(int r100) {
        this.f357219j = r100;
    }

    public SideIndexBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        String[] r103 = f357209k;
        this.f357210a = CollectionsKt.mutableListOf(Arrays.copyOf(r103, r103.length));
        this.f357212c = -1;
        Paint r104 = new Paint(1);
        this.f357213d = r104;
        Paint r105 = new Paint(1);
        this.f357214e = r105;
        Resources r106 = r100.getResources();
        int r107 = (int) TypedValue.applyDimension(2, 11.0f, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()));
        int r108 = ContextCompat.getColor(r100, R.color.larus_neutral_50);
        int r109 = ContextCompat.getColor(r100, R.color.larus_primary_50);
        float r110 = r107;
        r104.setTextSize(r110);
        r104.setColor(r108);
        r105.setTextSize(r110);
        r105.setColor(r109);
    }

    public /* synthetic */ SideIndexBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f357215f = getWidth();
        if (Math.abs(r101 - r103) == this.f357219j) goto L6;
        r101 = RangesKt.coerceAtLeast(getHeight(), r103);
    L6:
        this.f357216g = r101;
        float r104 = j19.c.c(20);
        this.f357211b = r104;
        this.f357217h = (this.f357216g - (r104 * this.f357210a.size())) / 2;
    }
}
