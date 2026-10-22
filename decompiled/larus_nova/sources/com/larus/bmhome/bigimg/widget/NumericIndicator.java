package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/NumericIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ItemStyle.ITEM_STYLE_DIVIDER, "", "curIndex", "totalCount", "setTotalCount", "", "count", "refreshCurIndex", "index", "refreshText", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NumericIndicator extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f296123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f296124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f296125c;

    public NumericIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NumericIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setTotalCount(int r100) {
        this.f296125c = r100;
        int r101 = 0;
        if (r100 <= 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = 8;
    L9:
        setVisibility(r101);
        if (r100 <= 1) goto L12;
        float r103 = 1.0f;
    L13:
        setAlpha(r103);
        setText(this.f296124b + this.f296123a + this.f296125c);
        return;
    L12:
        r103 = 0.0f;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public final void x(int r100) {
        this.f296124b = r100;
        setText(this.f296124b + this.f296123a + this.f296125c);
    }

    public NumericIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f296123a = HTTP.URL_DEFAULT;
        this.f296124b = 1;
        this.f296125c = 1;
    }

    public /* synthetic */ NumericIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
