package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010,\u001a\u00020\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0018H\u0002J\u0006\u00101\u001a\u00020\u0018J\u000e\u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0018J\u0006\u00103\u001a\u00020\u001eJ\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0014J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0018J\u000e\u00108\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0018J\b\u00109\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSearchInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "searchEditText", "Landroid/widget/EditText;", "searchCancel", "Landroid/widget/TextView;", "searchClearButton", "Landroid/view/View;", "searchContainer", "debounceTimeMs", "", "debounceJob", "Lkotlinx/coroutines/Job;", "pendingHint", "", "pendingCancelText", "searchCancelVisible", "", "onTextChangedListener", "Lkotlin/Function1;", "", "getOnTextChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTextChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onTextChangedWithDebounceListener", "getOnTextChangedWithDebounceListener", "setOnTextChangedWithDebounceListener", "onCancelClickListener", "Lkotlin/Function0;", "getOnCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initAttrs", "initView", "initDebounce", "dispatchDebouncedTextChanged", "text", "getText", "setText", "clearText", "setDebounceTime", "timeMs", "setHint", "hint", "setCancelText", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSearchInputView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f435695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditText f435696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f435697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f435698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f435699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f435700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f435701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f435702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f435703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f435704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super String, Unit> f435705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super String, Unit> f435706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f435707m;

    public MmSearchInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmSearchInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final String getText() {
        EditText r100 = this.f435696b;
        String r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r100 = null;
    L5:
        Editable r102 = r100.getText();
        if (r102 == null) goto L8;
        r101 = r102.toString();
    L8:
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Job r100 = this.f435701g;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        CoroutineScopeKt.cancel$default(this.f435695a, null, 1, null);
        super.onDetachedFromWindow();
    }

    public final Function0<Unit> getOnCancelClickListener() {
        return this.f435707m;
    }

    public final Function1<String, Unit> getOnTextChangedListener() {
        return this.f435705k;
    }

    public final Function1<String, Unit> getOnTextChangedWithDebounceListener() {
        return this.f435706l;
    }

    public final void setCancelText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f435697c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setDebounceTime(long r100) {
        this.f435700f = r100;
        Job r101 = this.f435701g;
        if (r101 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        return;
    }

    public final void setHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        EditText r101 = this.f435696b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r101 = null;
    L5:
        r101.setHint(r100);
    }

    public final void setOnCancelClickListener(Function0<Unit> r100) {
        this.f435707m = r100;
    }

    public final void setOnTextChangedListener(Function1<? super String, Unit> r100) {
        this.f435705k = r100;
    }

    public final void setOnTextChangedWithDebounceListener(Function1<? super String, Unit> r100) {
        this.f435706l = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        EditText r101 = this.f435696b;
        EditText r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r101 = null;
    L5:
        r101.setText(r100);
        EditText r103 = this.f435696b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
    L9:
        r102.setSelection(r100.length());
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public MmSearchInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f435695a = CoroutineScopeKt.MainScope();
        this.f435700f = 600;
        MmRecordingUILaunchMode r103 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(r100);
        com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(r103).getLayout().q(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r100, r103)), this);
        int r104 = 0;
        if (r101 == null) goto L10;
        TypedArray r105 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.debounceTime, R.attr.searchCancelText, R.attr.searchCancelVisible, R.attr.searchHint});
        this.f435702h = r105.getString(3);     // Catch: Throwable -> L7
        this.f435703i = r105.getString(1);     // Catch: Throwable -> L7
        this.f435700f = r105.getInt(0, 600);     // Catch: Throwable -> L7
        this.f435704j = r105.getBoolean(2, false);     // Catch: Throwable -> L7
        r105.recycle();
    L7:
        th = move-exception;
        r105.recycle();
        throw th;
    L10:
        this.f435696b = (EditText) findViewById(R.id.searchEditText);
        this.f435697c = (TextView) findViewById(R.id.searchCancel);
        this.f435698d = findViewById(R.id.searchClearButton);
        View r106 = findViewById(R.id.searchContainer);
        this.f435699e = r106;
        TextView r107 = null;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchContainer");
        r106 = null;
    L13:
        r106.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).a(getContext()));
        EditText r108 = this.f435696b;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r108 = null;
    L16:
        UIUtils.setTextViewCursorDrawable(r108, com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).t(getContext()));
        String r109 = this.f435702h;
        if (r109 == null) goto L22;
        EditText r110 = this.f435696b;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r110 = null;
    L21:
        r110.setHint(r109);
    L22:
        String r111 = this.f435703i;
        if (r111 == null) goto L28;
        TextView r112 = this.f435697c;
        if (r112 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        r112 = null;
    L27:
        r112.setText(r111);
    L28:
        TextView r113 = this.f435697c;
        if (r113 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        r113 = null;
    L32:
        if (this.f435704j == true) goto L35;
        r104 = 8;
    L35:
        r113.setVisibility(r104);
        EditText r114 = this.f435696b;
        if (r114 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r114 = null;
    L38:
        r114.addTextChangedListener(new c(this));
        View r115 = this.f435698d;
        if (r115 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("searchClearButton");
        r115 = null;
    L41:
        h.a(r115, new MmSearchInputView$initView$4(this));
        if (this.f435704j == false) goto L51;
        TextView r116 = this.f435697c;
        if (r116 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
    L47:
        h.a(r107, new MmSearchInputView$initView$5(this));
        return;
    L46:
        r107 = r116;
        goto L47
    }

    public /* synthetic */ MmSearchInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
