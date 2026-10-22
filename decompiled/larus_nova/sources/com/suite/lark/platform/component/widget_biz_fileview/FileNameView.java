package com.suite.lark.platform.component.widget_biz_fileview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_fileview/FileNameView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tailText", "", "setTailContent", "", "tail", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "widget-biz-fileview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileNameView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f460879a;

    public static final class a {
    }

    static {
    }

    public FileNameView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        String r100 = this.f460879a;
        int r101 = getMaxLines();
        CharSequence r102 = getText();
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L54;
        if (r101 <= 0) goto L54;
        if (r102 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L54;
        if (getLayout() == null) goto L26;
        if (r101 < getLayout().getLineCount()) goto L26;
        super.onDraw(r110);
        return;
    L26:
        if (getLayout() != null) goto L33;
        int r105 = r110.save();
        r110.clipRect(0, 0, 0, 0);
        super.onDraw(r110);     // Catch: Throwable -> L30
        r110.restoreToCount(r105);
    L30:
        th = move-exception;
        r110.restoreToCount(r105);
        throw th;
    L33:
        Layout r111 = getLayout();
        if (r111 != null) goto L36;
    L52:
        super.onDraw(r110);
        return;
    L36:
        if (r101 >= r111.getLineCount()) goto L52;
        int r112 = r101 - 1;
        float r113 = r111.getLineLeft(r112);
        float r114 = r111.getLineRight(r112);
        int r115 = r111.getLineStart(r112);
        int r116 = r111.getLineEnd(r112);
        if (r116 >= r115) goto L42;
        super.onDraw(r110);
        return;
    L42:
        float r106 = r111.getLineTop(r112);
        float r107 = r111.getLineBottom(r112);
        int r108 = r110.save();
        if (Build.VERSION.SDK_INT < 26) goto L45;
        r110.clipOutRect(r113, r106, r114, r107);
    L56:
        super.onDraw(r110);     // Catch: Throwable -> L49
        r110.restoreToCount(r108);
        TextPaint r109 = getPaint();
        r110.drawText(TextUtils.ellipsize(r102.subSequence(r115, r116), r109, (r114 - r113) - r109.measureText(r100), TextUtils.TruncateAt.END) + r100, r113, r111.getLineBaseline(r112), r109);
        return;
    L49:
        th = move-exception;
        r110.restoreToCount(r108);
        throw th;
    L45:
        r110.clipRect(r113, r106, r114, r107, Region.Op.DIFFERENCE);
        goto L56
    L13:
        if (r102.length() == 0) goto L16;
        r104 = false;
    L54:
        super.onDraw(r110);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void setTailContent(String r100) {
        this.f460879a = r100;
        invalidate();
    }

    public FileNameView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
