package com.ss.android.lark.vote.message.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J \u0010\u0013\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0016\u0010\u0016\u001a\u00020\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0016\u0010\u0017\u001a\u00020\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0006\u0010\u0018\u001a\u00020\u000fR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/vote/message/cell/MaxHeightConstrainLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "visibleViewList", "", "Landroid/view/View;", "inVisibleViewList", "shouldShowMore", "", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "updateVisibility", "views", RemoteMessageConst.Notification.VISIBILITY, "bindVisibleViewList", "bindInVisibleViewList", "showMore", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaxHeightConstrainLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends View> f445148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends View> f445149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f445150c;

    public MaxHeightConstrainLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public MaxHeightConstrainLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f445150c = true;
    }

    public static boolean R5(List r100, int r101) {
        boolean r102 = false;
        if (r100 == null) goto L10;
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        View r104 = (View) r103.next();
        if (r104.getVisibility() == r101) goto L6;
        r104.setVisibility(r101);
        r102 = true;
    L10:
        return r102;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f445150c == false) goto L15;
        int r102 = DeviceUtils.getScreenHeight(getContext());
        int r103 = View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
        super.onMeasure(r100, r103);
        if (getMeasuredHeight() < r102) goto L11;
        boolean r104 = false;
        if (R5(this.f445148a, 0) == false) goto L9;
    L10:
        r104 = true;
    L12:
        if (r104 == false) goto L17;
        super.onMeasure(r100, r103);
        return;
    L17:
        return;
    L9:
        if (R5(this.f445149b, 8) == false) goto L12;
    L11:
        r104 = R5(this.f445148a, 8);
        goto L12
    L15:
        super.onMeasure(r100, r101);
    }
}
