package com.ss.android.lark.widget.columns.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ecc.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\fH\u0002J\u0006\u0010\u0011\u001a\u00020\fR\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/widget/columns/view/ColumnsView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "columnsDataView", "columnsDataAdapter", "Lcom/ss/android/lark/widget/columns/view/ColumnsDataAdapter;", "setColumnsAdapter", "", "setLinearLayoutOrientation", "isColumnsOverMaxCellWidth", "", "setupColumnsDataView", "forceRefresh", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnsView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f445732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f445733b;

    public final void setColumnsAdapter(a r100) {
        Intrinsics.checkNotNullParameter(r100, "columnsDataAdapter");
        this.f445733b = r100;
        removeAllViews();
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-1, -1);
        ScrollView r102 = new ScrollView(getContext());
        r102.setId(R.id.columns_detail_vertical_scroll_view);
        r102.setLayoutParams(r101);
        r102.setVerticalScrollBarEnabled(false);
        addView(r102);
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(-1, -2);
        LinearLayout r104 = this.f445732a;
        if (r104 == null) goto L5;
        r104.setLayoutParams(r103);
    L5:
        LinearLayout r105 = this.f445732a;
        if (r105 == null) goto L8;
        r105.removeAllViews();
    L8:
        a r106 = this.f445733b;
        if (r106 == null) goto L11;
        r106.f472168c = this.f445732a;
        r106.a(r106.f472166a, r106.f472167b);
    L11:
        LinearLayout r107 = this.f445732a;
        ViewGroup r108 = null;
        if (r107 == null) goto L14;
        ViewParent r109 = r107.getParent();
    L15:
        if (r109 == null) goto L25;
        LinearLayout r110 = this.f445732a;
        if (r110 == null) goto L19;
        ViewParent r111 = r110.getParent();
    L21:
        if ((r111 instanceof ViewGroup) == false) goto L23;
        r108 = (ViewGroup) r111;
    L23:
        if (r108 == null) goto L25;
        r108.removeView(this.f445732a);
        goto L25
    L19:
        r111 = null;
    L25:
        r102.addView(this.f445732a);
        LinearLayout r112 = this.f445732a;
        if (r112 == null) goto L29;
        r112.invalidate();
        return;
    L29:
        return;
    L14:
        r109 = null;
        goto L15
    }

    public final void setLinearLayoutOrientation(boolean r100) {
        LinearLayout r101 = this.f445732a;
        if (r101 == null) goto L6;
        r101.setOrientation(r100 ? 1 : 0);
        return;
    }

    public ColumnsView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f445732a = new LinearLayout(r100);
    }
}
