package com.obric.oui.forms;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\bH&R>\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0007\u0010\u0006¨\u0006!"}, d2 = {"Lcom/obric/oui/forms/AbsOForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "b", "", "setInScrollView1", "(Z)V", "setInScrollView", "Landroid/widget/EditText;", "getInterEditText", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "textWatchers", "d", "Z", "isInScrollView", "()Z", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class AbsOForm extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<WeakReference<TextWatcher>> f400850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f400851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f400852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f400853d;

    public AbsOForm(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsOForm(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract EditText getInterEditText();

    public final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.f400850a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L36;
        if (this.f400853d == false) goto L36;
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r100.getAction();
        if (r103 != 0) goto L8;
        this.f400851b = r102;
        goto L36
    L8:
        if (r103 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r103 != 2) goto L12;
        EditText r104 = getInterEditText();
        Intrinsics.checkNotNull(r104);
        if (r101 <= this.f400852c) goto L20;
        if (r104.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f400852c = r101;
        this.f400851b = r102;
    L20:
        if (r101 >= this.f400852c) goto L24;
        if (r104.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r102 >= this.f400851b) goto L28;
        if (r104.canScrollVertically(1) == true) goto L31;
    L28:
        if (r102 <= this.f400851b) goto L32;
        if (r104.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r103 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r100);
    }

    public final void setInScrollView(boolean r100) {
        this.f400853d = r100;
    }

    public final void setInScrollView1(boolean r100) {
        this.f400853d = r100;
    }

    public final void setTextWatchers(ArrayList<WeakReference<TextWatcher>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400850a = r100;
    }

    public AbsOForm(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f400850a = new ArrayList();
    }

    public /* synthetic */ AbsOForm(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
