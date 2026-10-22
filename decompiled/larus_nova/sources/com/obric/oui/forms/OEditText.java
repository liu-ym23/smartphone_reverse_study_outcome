package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\u001f !\"B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u000eH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/view/View$OnTouchListener;", "l", "", "setOnTouchListener", "", "type", "setInputType", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "setOnFocusChangeListener", "Lcom/obric/oui/forms/OEditText$a;", "commitCompletionListener", "Lcom/obric/oui/forms/OEditText$a;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$a;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f400880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f400881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f400882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f400883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f400884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f400885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f400886g;

    public interface a {
    }

    public static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super Boolean, Unit> f400887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnFocusChangeListener f400888b;

        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            Function1<? super Boolean, Unit> r102 = this.f400887a;
            if (r102 == null) goto L6;
            r102.invoke(Boolean.valueOf(r101));
        L6:
            View.OnFocusChangeListener r103 = this.f400888b;
            if (r103 == null) goto L11;
            r103.onFocusChange(r100, r101);
            return;
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super MotionEvent, Unit> f400889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnTouchListener f400890b;

        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Function1<? super MotionEvent, Unit> r102 = this.f400889a;
            if (r102 == null) goto L6;
            r102.invoke(r101);
        L6:
            View.OnTouchListener r103 = this.f400890b;
            if (r103 != null) goto L10;
            return false;
        L10:
            return r103.onTouch(r100, r101);
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> f400891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super Editable, Unit> f400892b;

        public d() {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Function1<? super Editable, Unit> r101 = this.f400892b;
            if (r101 == null) goto L7;
            r101.invoke(r100);
            return;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r104 = this.f400891a;
            if (r104 == null) goto L7;
            r104.invoke(r100, Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103));
            return;
        }
    }

    public OEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    public final a getCommitCompletionListener() {
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        this.f400886g = true;
        boolean r100 = super.performLongClick();
        this.f400886g = false;
        return r100;
    }

    public final void setCommitCompletionListener(a r100) {
    }

    public final void c() {
        int r100 = getInputType() & UnixStat.PERM_MASK;
        boolean r101 = false;
        if (r100 != 129) goto L5;
        boolean r102 = true;
    L7:
        if (r100 != 225) goto L9;
        boolean r103 = true;
    L11:
        if (r100 != 18) goto L13;
        boolean r104 = true;
    L14:
        if (r102 == true) goto L19;
        if (r103 == true) goto L19;
        if (r104 == true) goto L19;
        boolean r105 = false;
    L20:
        if (r105 == false) goto L22;
        TransformationMethod r106 = getTransformationMethod();
        if ((r106 instanceof u) == false) goto L37;
        u r107 = (u) r106;
        if (r107.f401043a != this.f400883d) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == false) goto L37;
        if (r107.f401044b != this.f400884e) goto L35;
        r101 = true;
    L35:
        if (r101 == false) goto L37;
        return;
    L30:
        r108 = false;
    L37:
        setTransformationMethod(new u(this.f400883d, this.f400884e, this.f400885f));
        return;
    L22:
        if ((getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L39;
        setTransformationMethod(null);
        return;
    L39:
        return;
    L19:
        r105 = true;
        goto L20
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r100 = super.getOnFocusChangeListener();
        if ((r100 instanceof b) == true) goto L5;
        return r100;
    L5:
        return ((b) r100).f400888b;
    }

    @Override // android.widget.TextView
    public final void onCommitCompletion(CompletionInfo r100) {
        super.onCommitCompletion(r100);
    }

    @Override // android.widget.TextView
    public void setInputType(int r100) {
        super.setInputType(r100);
        c();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r100) {
        if ((r100 instanceof b) == false) goto L5;
        super.setOnFocusChangeListener(r100);
        return;
    L5:
        this.f400880a.f400888b = r100;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r100) {
        this.f400881b.f400890b = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        if (r100 == r101) goto L5;
        boolean r102 = true;
    L7:
        if (this.f400886g == true) goto L11;
        if (r102 == false) goto L12;
        bma.a.c(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = false;
        goto L7
    }

    public OEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        b r103 = new b();
        this.f400880a = r103;
        c r104 = new c();
        this.f400881b = r104;
        d r105 = new d();
        this.f400882c = r105;
        this.f400883d = 0.38f;
        this.f400884e = 0.19f;
        this.f400885f = ContextCompat.getColor(r100, R.color.oui_functional_red_2);
        setOnFocusChangeListener(r103);
        super.setOnTouchListener(r104);
        addTextChangedListener(r105);
        setHighlightColor(r100.getColor(R.color.oui_text_highlight_color));
        c();
    }

    public /* synthetic */ OEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
