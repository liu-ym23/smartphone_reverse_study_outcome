package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Landroid/widget/GridView;", "Lcom/obric/oui/indexscrollbar/SurnameGridView$a;", "listener", "", "setOnPressChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class SurnameGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f401139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f401140b;

    public interface a {
        void a(int r100);
    }

    public final void setOnPressChangeListener(a r100) {
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = pointToPosition((int) r100.getX(), (int) r100.getY());
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L5;
        this.f401139a = r101;
    L15:
        if (this.f401140b == r101) goto L17;
        Intrinsics.checkNotNull(null);
        throw null;
    L17:
        return super.onTouchEvent(r100);
    L5:
        if (r102 != 1) goto L7;
    L12:
        r101 = -1;
        goto L15
    L7:
        if (r102 != 2) goto L12;
        int r103 = this.f401139a;
        if (r103 != r101) goto L12;
        r101 = r103;
        goto L15
    }

    public SurnameGridView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f401139a = -1;
        this.f401140b = -1;
    }
}
