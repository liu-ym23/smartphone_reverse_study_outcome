package com.larus.bmhome.chat.standarduikit.quickreply.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import j19.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyUnderlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "underlinePaint", "Landroid/graphics/Paint;", "underlineWidth", "", "iconSize", "", "title", "", "iconUrl", "iconBitmap", "Landroid/graphics/Bitmap;", "value", "underlineColor", "getUnderlineColor", "()I", "setUnderlineColor", "(I)V", "bind", "", "textColor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "loadIconIfNeeded", "updateText", "drawSoftlinkUnderline", "CenterImageSpan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickReplyUnderlineTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f309544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f309545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f309546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f309547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f309548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f309549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f309550g;

    public static final class a extends ImageSpan {
        public a(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            super(r100);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r108, "paint");
            Drawable r109 = getDrawable();
            Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
            int r111 = ((((r110.descent + r106) + r106) + r110.ascent) / 2) - (r109.getBounds().height() / 2);
            r100.save();
            r100.translate(r104, r111);
            r109.draw(r100);
            r100.restore();
        }
    }

    public static final class b {
    }

    static {
    }

    public final void x() {
        Bitmap r100 = this.f309549f;
        if (this.f309547d.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L13;
        if (r100 == null) goto L13;
        if (r100.isRecycled() == true) goto L13;
        SpannableStringBuilder r102 = new SpannableStringBuilder(this.f309547d);
        r102.append(" ");
        int r103 = r102.length();
        r102.append("￼");
        BitmapDrawable r104 = new BitmapDrawable(getResources(), r100);
        int r105 = this.f309546c;
        r104.setBounds(0, 0, r105, r105);
        r102.setSpan(new a(r104), r103, r102.length(), 33);
        setText(r102);
        return;
    L13:
        setText(this.f309547d);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final int getUnderlineColor() {
        return this.f309550g;
    }

    public QuickReplyUnderlineTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        CharSequence r101 = getText();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        if (this.f309550g == 0) goto L22;
        Layout r103 = getLayout();
        if (r103 == null) goto L23;
        float r104 = RangesKt.coerceAtMost(r103.getLineWidth(0), getWidth());
        if (r104 <= 0.0f) goto L24;
        this.f309544a.setColor(this.f309550g);
        float r105 = getHeight() - (this.f309545b / 2.0f);
        r100.drawLine(0.0f, r105, r104, r105, this.f309544a);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void setUnderlineColor(int r100) {
        this.f309550g = r100;
        invalidate();
    }

    public QuickReplyUnderlineTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint(1);
        this.f309544a = r102;
        Resources r103 = getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        this.f309545b = r104;
        this.f309546c = c.c(17);
        this.f309547d = "";
        r102.setStrokeWidth(r104);
    }
}
