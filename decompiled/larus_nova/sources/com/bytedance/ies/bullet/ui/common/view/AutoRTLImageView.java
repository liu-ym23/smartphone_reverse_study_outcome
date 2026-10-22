package com.bytedance.ies.bullet.ui.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/AutoRTLImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/drawable/Drawable;", "background", "", "setBackground", "drawable", "setImageDrawable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AutoRTLImageView extends AppCompatImageView {
    public AutoRTLImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoRTLImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        super.setBackground(r100);
        if (r100 == null) goto L6;
        r100.setAutoMirrored(true);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        if (r100 == null) goto L6;
        r100.setAutoMirrored(true);
        return;
    }

    public AutoRTLImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = Build.VERSION.SDK_INT;
        Drawable r104 = getDrawable();
        Drawable r105 = getBackground();
        if (r103 < 23) goto L5;
        Drawable r106 = getForeground();
    L7:
        if (r104 == null) goto L9;
        r104.setAutoMirrored(true);
    L9:
        if (r105 == null) goto L11;
        r105.setAutoMirrored(true);
    L11:
        if (r106 == null) goto L14;
        r106.setAutoMirrored(true);
        return;
    L14:
        return;
    L5:
        r106 = null;
        goto L7
    }

    public /* synthetic */ AutoRTLImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
