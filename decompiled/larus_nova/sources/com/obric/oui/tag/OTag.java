package com.obric.oui.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "use OTextTag")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/tag/OTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OTag extends AppCompatTextView {
    public OTag(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OTag(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }

    public OTag(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_bgGradientEndColor, R.attr.oui_bgGradientStartColor, R.attr.oui_borderColor, R.attr.oui_bordered, R.attr.oui_size}, 0, 0);
        int r104 = r103.getInteger(4, 0);     // Catch: Throwable -> L17
        r103.getBoolean(3, false);     // Catch: Throwable -> L17
        r103.getColor(2, 0);     // Catch: Throwable -> L17
        int r105 = r103.getColor(1, 0);     // Catch: Throwable -> L17
        int r106 = r103.getColor(0, 0);     // Catch: Throwable -> L17
        r103.recycle();
        if (r104 == 0) goto L9;
        if (r104 == 2) goto L8;
        int r107 = d.n(this, 1);
        int r108 = d.n(this, 3);
    L10:
        setPadding(r108, r107, r108, r107);
        if (r105 == 0) goto L14;
        if (r106 == 0) goto L14;
        GradientDrawable r109 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{r105, r106});
    L15:
        r109.setCornerRadius(d.n(this, 2));
        setBackground(r109);
        return;
    L14:
        r109 = new GradientDrawable();
        goto L15
    L8:
        r107 = d.n(this, 2);
        r108 = d.n(this, 4);
        goto L10
    L9:
        r108 = d.n(this, 3);
        r107 = d.n(this, 1);
    L17:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    public /* synthetic */ OTag(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
