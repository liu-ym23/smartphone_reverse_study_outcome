package com.bytedance.ee.bear.bitable.celleditor.editor.signature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u0001:\u000234B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ(\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0014J \u0010(\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J \u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J \u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0007H\u0002J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/signature/SignatureTextPreviewView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zhPaint", "Landroid/graphics/Paint;", "enPaint", "exportZhPaint", "getExportZhPaint", "()Landroid/graphics/Paint;", "exportZhPaint$delegate", "Lkotlin/Lazy;", "exportEnPaint", "getExportEnPaint", "exportEnPaint$delegate", DBDefinition.SEGMENT_TABLE_NAME, "", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/signature/SignatureTextPreviewView$Segment;", "resolvedTextSizePx", "", "setSignatureText", "", "value", "", "exportTransparentPng", "Landroid/graphics/Bitmap;", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawSegments", "zh", "en", "recomputeTextSize", "applyTextSize", GXTemplateKey.GAIAX_PX, "paintFor", "seg", "spToPx", CloudControlInf.SP, "buildSegments", "Segment", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignatureTextPreviewView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f209539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f209540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f209541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f209542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<b> f209543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f209544f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f209545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f209546b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f209545a, r101.f209545a) == true) goto L12;
            return false;
        L12:
            if (this.f209546b == r101.f209546b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f209545a.hashCode() * 31;
            if (this.f209546b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Segment(text=" + this.f209545a + ", isCjk=" + this.f209546b + ')';
        }

        public b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f209545a = r100;
            this.f209546b = r101;
        }
    }

    static {
    }

    public SignatureTextPreviewView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SignatureTextPreviewView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Paint getExportEnPaint() {
        return (Paint) this.f209542d.getValue();
    }

    private final Paint getExportZhPaint() {
        return (Paint) this.f209541c.getValue();
    }

    public final Bitmap b() {
        Bitmap r100 = Bitmap.createBitmap(800, 450, Bitmap.Config.ARGB_8888);
        tt5.a.h("SignatureTextPreviewView", "exportTransparentPng, srcWidth: " + getWidth() + ", srcHeight: " + getHeight() + ", exportWidth: 800, exportHeight: 450, byteCount: " + r100.getByteCount() + " bytes (" + ((r100.getByteCount() / 1024.0f) / 1024.0f) + " MB)");
        if (this.f209543e.isEmpty() == false) goto L5;
    L10:
        return r100;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        float r101 = Math.min(800.0f / getWidth(), 450.0f / getHeight());
        float r102 = (800 - (getWidth() * r101)) / 2.0f;
        float r103 = (450 - (getHeight() * r101)) / 2.0f;
        Canvas r104 = new Canvas(r100);
        r104.translate(r102, r103);
        r104.scale(r101, r101);
        a(r104, getExportZhPaint(), getExportEnPaint());
        goto L10
    }

    public final void c() {
        if (this.f209543e.isEmpty() == false) goto L5;
        return;
    L5:
        float r100 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float r101 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r100 > 0.0f) goto L8;
        return;
    L8:
        if (r101 <= 0.0f) goto L36;
        int r102 = 56;
    L12:
        if (r102 <= 16) goto L26;
        float r103 = d(r102);
        Paint r104 = this.f209539a;
        Paint r105 = this.f209540b;
        r104.setTextSize(r103);
        r105.setTextSize(r103);
        Iterator<b> r106 = this.f209543e.iterator();
        float r107 = 0.0f;
    L15:
        if (r106.hasNext() == false) goto L21;
        b r108 = r106.next();
        Paint r109 = this.f209539a;
        Paint r110 = this.f209540b;
        if (r108.f209546b == true) goto L20;
        r109 = r110;
    L20:
        r107 = r107 + r109.measureText(r108.f209545a);
        goto L15
    L21:
        Paint.FontMetrics r111 = this.f209539a.getFontMetrics();
        if (r107 > r100) goto L25;
        if ((r111.descent - r111.ascent) <= r101) goto L26;
    L25:
        r102 = r102 - 1;
    L26:
        this.f209544f = d(r102);
        return;
    }

    public final float d(int r100) {
        Resources r101 = getResources();
        return TypedValue.applyDimension(2, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f209543e.isEmpty() == false) goto L5;
        return;
    L5:
        a(r100, this.f209539a, this.f209540b);
    }

    public final void setSignatureText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        List<b> r103 = CollectionsKt.emptyList();
    L19:
        this.f209543e = r103;
        c();
        invalidate();
        return;
    L8:
        ArrayList r104 = new ArrayList();
    L10:
        if (r101 >= r100.length()) goto L18;
        boolean r105 = yu5.a.a(r100.charAt(r101));
        int r106 = r101;
    L13:
        if (r106 >= r100.length()) goto L17;
        if (yu5.a.a(r100.charAt(r106)) != r105) goto L17;
        r106 = r106 + 1;
    L17:
        r104.add(new b(r100.substring(r101, r106), r105));
        r101 = r106;
        goto L10
    L18:
        r103 = r104;
        goto L19
    L5:
        r102 = false;
        goto L6
    }

    public SignatureTextPreviewView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setColor(c.a(r100));
        this.f209539a = r103;
        Paint r104 = new Paint(1);
        r104.setColor(c.a(r100));
        this.f209540b = r104;
        this.f209541c = LazyKt.lazy(new SignatureTextPreviewView$exportZhPaint$2(this));
        this.f209542d = LazyKt.lazy(new SignatureTextPreviewView$exportEnPaint$2(this));
        this.f209543e = CollectionsKt.emptyList();
        this.f209544f = d(56);
    }

    public final void a(Canvas r100, Paint r101, Paint r102) {
        float r103 = this.f209544f;
        r101.setTextSize(r103);
        r102.setTextSize(r103);
        int r104 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        Iterator<b> r106 = this.f209543e.iterator();
        float r107 = 0.0f;
    L4:
        if (r106.hasNext() == false) goto L10;
        b r108 = r106.next();
        if (r108.f209546b == false) goto L8;
        Paint r109 = r101;
    L9:
        r107 = r107 + r109.measureText(r108.f209545a);
        goto L4
    L8:
        r109 = r102;
        goto L9
    L10:
        float r110 = getPaddingLeft() + ((r104 - r107) / 2.0f);
        Paint.FontMetrics r111 = r101.getFontMetrics();
        float r112 = (getPaddingTop() + (r105 / 2.0f)) - ((r111.ascent + r111.descent) / 2.0f);
        Iterator<b> r113 = this.f209543e.iterator();
    L12:
        if (r113.hasNext() == false) goto L18;
        b r114 = r113.next();
        if (r114.f209546b == false) goto L16;
        Paint r115 = r101;
    L17:
        r100.drawText(r114.f209545a, r110, r112, r115);
        r110 = r110 + r115.measureText(r114.f209545a);
        goto L12
    L16:
        r115 = r102;
        goto L17
    }

    public /* synthetic */ SignatureTextPreviewView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        c();
    }
}
