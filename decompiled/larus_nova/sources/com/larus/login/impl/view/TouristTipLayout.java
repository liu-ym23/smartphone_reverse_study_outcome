package com.larus.login.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import ck9.g;
import ck9.h;
import com.larus.login.impl.databinding.LarusLayoutTouristTipBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u001c\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/login/impl/view/TouristTipLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/login/impl/databinding/LarusLayoutTouristTipBinding;", "closeIconClickAction", "Lkotlin/Function0;", "", "getCloseButton", "Landroid/view/View;", "initTouristText", "initTouristClose", "initByLoginMode", "loginWindowStyle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouristTipLayout extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f358365c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutTouristTipBinding f358366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f358367b;

    public TouristTipLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TouristTipLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final View getCloseButton() {
        LarusLayoutTouristTipBinding r100 = this.f358366a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f357587b;
    }

    public final void a(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "closeIconClickAction");
        if (r100 != 1) goto L5;
        ViewGroup.LayoutParams r102 = this.f358366a.f357586a.getLayoutParams();
        r102.height = getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_56, null, R.dimen.larus_dp_56));
        this.f358366a.f357586a.setLayoutParams(r102);
        e1.o(this.f358366a.f357588c);
    L5:
        this.f358367b = r101;
    }

    public TouristTipLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_tourist_tip, this, false);
        addView(r103);
        int r104 = R.id.tourist_close;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.tourist_close);
        if (r105 == null) goto L9;
        r104 = R.id.tourist_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.tourist_text);
        if (r106 == null) goto L9;
        FrameLayout r107 = (FrameLayout) r103;
        this.f358366a = new LarusLayoutTouristTipBinding(r107, r105, r106, r107);
        r106.getViewTreeObserver().addOnPreDrawListener(new h(r106, this));
        e1.d(r105, new g(this));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ TouristTipLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
