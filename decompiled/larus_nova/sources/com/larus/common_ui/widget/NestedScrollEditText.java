package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/common_ui/widget/NestedScrollEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "canVerticalScroll", "editText", "Landroid/widget/EditText;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedScrollEditText extends AppCompatEditText {
    public NestedScrollEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NestedScrollEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static boolean c(EditText r100) {
        int r101 = r100.getScrollY();
        int r102 = r100.getLayout().getHeight() - ((r100.getHeight() - r100.getCompoundPaddingTop()) - r100.getCompoundPaddingBottom());
        if (r102 != 0) goto L6;
    L10:
        return false;
    L6:
        if (r101 <= 0) goto L8;
        return true;
    L8:
        if (r101 >= (r102 - 1)) goto L10;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L18;
        if (r101 != 1) goto L6;
    L16:
        getParent().requestDisallowInterceptTouchEvent(false);
    L22:
        return super.onTouchEvent(r100);
    L6:
        if (r101 == 2) goto L13;
        if (r101 == 3) goto L16;
        if (r101 != 8) goto L22;
    L13:
        if (c(this) == false) goto L15;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L22
    L15:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L22
    L18:
        if (c(this) == false) goto L20;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L22
    L20:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L22
    }

    public NestedScrollEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ NestedScrollEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.editTextStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
