package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H$R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/forms/AbsOInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/EditText;", "getInterEditText", "", "c", "Z", "isInScrollView", "()Z", "setInScrollView", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class AbsOInput extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f400854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f400855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f400856c;

    public AbsOInput(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsOInput(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract EditText getInterEditText();

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L36;
        if (this.f400856c == false) goto L36;
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r100.getAction();
        if (r103 != 0) goto L8;
        this.f400854a = r102;
        goto L36
    L8:
        if (r103 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r103 != 2) goto L12;
        EditText r104 = getInterEditText();
        if (r101 <= this.f400855b) goto L20;
        if (r104.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f400855b = r101;
        this.f400854a = r102;
    L20:
        if (r101 >= this.f400855b) goto L24;
        if (r104.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r102 >= this.f400854a) goto L28;
        if (r104.canScrollVertically(1) == true) goto L31;
    L28:
        if (r102 <= this.f400854a) goto L32;
        if (r104.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r103 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r100);
    }

    public final void setInScrollView(boolean r100) {
        this.f400856c = r100;
    }

    public AbsOInput(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AbsOInput(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
