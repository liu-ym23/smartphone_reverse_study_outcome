package com.bytedance.dux.forms;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001:\u0001\rJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\bH&J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006R>\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u0007\u0010\u0006R\"\u0010\n\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0006¨\u0006\""}, d2 = {"Lcom/bytedance/dux/forms/AbsDuxForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "b", "", "setInScrollView1", "(Z)V", "setInScrollView", "Landroid/widget/EditText;", "getInterEditText", "adaptLargeFont", "setAdaptLargeFontInternal", "(Ljava/lang/Boolean;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getLimitLargeFontScale", "()Z", "setLimitLargeFontScale", "limitLargeFontScale", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "textWatchers", "e", "isInScrollView", "f", "getAdaptLargeFont", "setAdaptLargeFont", "dux_release"}, k = 1, mv = {1, 7, 1})
public abstract class AbsDuxForm extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DuxComponent f205091g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<WeakReference<TextWatcher>> f205093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f205094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f205095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205097f;

    public static final class a {
    }

    public AbsDuxForm(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 0, 30);
    }

    public AbsDuxForm(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public AbsDuxForm(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    public abstract EditText getInterEditText();

    static {
        f205091g = DuxComponent.FORM_ITEMS;
    }

    public final boolean getAdaptLargeFont() {
        return this.f205097f;
    }

    public final boolean getLimitLargeFontScale() {
        return this.f205092a;
    }

    public final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.f205093b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f205096e == false) goto L35;
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r100.getAction();
        if (r103 != 0) goto L7;
        this.f205094c = r102;
        goto L35
    L7:
        if (r103 != 1) goto L9;
        super.requestDisallowInterceptTouchEvent(false);
        goto L35
    L9:
        if (r103 != 2) goto L11;
        EditText r104 = getInterEditText();
        Intrinsics.checkNotNull(r104);
        if (r101 <= this.f205095d) goto L19;
        if (r104.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.f205095d = r101;
        this.f205094c = r102;
    L19:
        if (r101 >= this.f205095d) goto L23;
        if (r104.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r102 >= this.f205094c) goto L27;
        if (r104.canScrollVertically(1) == true) goto L30;
    L27:
        if (r102 <= this.f205094c) goto L31;
        if (r104.canScrollVertically(-1) == false) goto L31;
    L11:
        if (r103 != 3) goto L35;
        super.requestDisallowInterceptTouchEvent(false);
    L35:
        return super.dispatchTouchEvent(r100);
    }

    public final void setAdaptLargeFont(boolean r100) {
        this.f205097f = r100;
    }

    public final void setAdaptLargeFontInternal(Boolean r100) {
        Lazy r101 = DuxLargeFontHelper.f205243a;
        this.f205097f = DuxLargeFontHelper.a(f205091g, r100);
    }

    public final void setInScrollView(boolean r100) {
        this.f205096e = r100;
    }

    public final void setInScrollView1(boolean r100) {
        this.f205096e = r100;
    }

    public final void setLimitLargeFontScale(boolean r100) {
        this.f205092a = r100;
    }

    public final void setTextWatchers(ArrayList<WeakReference<TextWatcher>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f205093b = r100;
    }

    public /* synthetic */ AbsDuxForm(Context r100, AttributeSet r101, int r102, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = null;
    L5:
        AttributeSet r103 = r101;
        if ((r110 & 4) == 0) goto L8;
        int r104 = 0;
    L9:
        this(r100, r103, r104, null, false);
        return;
    L8:
        r104 = r102;
        goto L9
    }

    public AbsDuxForm(Context r100, AttributeSet r101, int r102, Boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205092a = r104;
        this.f205093b = new ArrayList();
        Lazy r105 = DuxLargeFontHelper.f205243a;
        this.f205097f = DuxLargeFontHelper.a(f205091g, r103);
    }
}
