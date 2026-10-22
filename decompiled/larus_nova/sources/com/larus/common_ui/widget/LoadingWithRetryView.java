package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusViewLoadingWithRetryBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;
import z19.s;
import z19.t;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0015\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0002J\u0015\u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/common_ui/widget/LoadingWithRetryView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewLoadingWithRetryBinding;", "alignTopMode", "", "setAlignTopMode", "", "setOnRetryListener", "listener", "Landroid/view/View$OnClickListener;", DyPayConstant.KEY_SHOW_LOADING, "showRetry", "retryText", "", "(Ljava/lang/Integer;)V", "", "showTextTipsOnly", "tipText", "showTipsActionText", "tipsActionText", "setTipsAction", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingWithRetryView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f328477c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusViewLoadingWithRetryBinding f328478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f328479b;

    public final void a() {
        this.f328479b = true;
        setGravity(0);
        this.f328478a.f326814h.setVisibility(8);
        this.f328478a.f326809c.setVisibility(8);
        ViewGroup.LayoutParams r100 = this.f328478a.f326810d.getLayoutParams();
        if (r100 == null) goto L6;
        r100.width = i5.J();
        r100.height = i5.J();
        return;
    }

    public final void b() {
        this.f328478a.f326807a.setVisibility(0);
        this.f328478a.f326810d.setVisibility(0);
        this.f328478a.f326811e.setVisibility(8);
        this.f328478a.f326813g.setVisibility(4);
        if (this.f328479b == false) goto L11;
        setGravity(0);
        ViewGroup.LayoutParams r100 = this.f328478a.f326810d.getLayoutParams();
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
    L8:
        if (r101 == null) goto L12;
        r101.topMargin = i5.E();
        return;
    L12:
        return;
    L7:
        r101 = null;
        goto L8
    }

    public LoadingWithRetryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void c(Integer r100) {
        if (r100 != null) goto L4;
        String r101 = null;
    L5:
        this.f328478a.f326807a.setVisibility(0);
        this.f328478a.f326810d.setVisibility(8);
        this.f328478a.f326811e.setVisibility(0);
        this.f328478a.f326813g.setVisibility(0);
        this.f328478a.f326808b.setVisibility(8);
        if (r101 == null) goto L9;
        this.f328478a.f326812f.setText(r101);
    L9:
        if (this.f328479b == false) goto L12;
        setGravity(17);
        return;
    L12:
        return;
    L4:
        r101 = getContext().getString(r100.intValue());
        goto L5
    }

    public final void d(Integer r100) {
        if (r100 != null) goto L4;
        String r101 = null;
    L5:
        this.f328478a.f326807a.setVisibility(0);
        this.f328478a.f326810d.setVisibility(8);
        this.f328478a.f326811e.setVisibility(8);
        this.f328478a.f326813g.setVisibility(0);
        this.f328478a.f326808b.setVisibility(8);
        if (r101 == null) goto L9;
        this.f328478a.f326812f.setText(r101);
    L9:
        if (this.f328479b == false) goto L12;
        setGravity(0);
        return;
    L12:
        return;
    L4:
        r101 = getContext().getString(r100.intValue());
        goto L5
    }

    public final void setOnRetryListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        setOnClickListener(new t(this, r100));
    }

    public final void setTipsAction(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        e1.d(this.f328478a.f326808b, new s(r100));
    }

    public LoadingWithRetryView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.larus_view_loading_with_retry, this);
        int r100 = R.id.action_text;
        TextView r101 = (TextView) ViewBindings.findChildViewById(this, R.id.action_text);
        if (r101 == null) goto L19;
        r100 = R.id.bottom_blank;
        View r102 = ViewBindings.findChildViewById(this, R.id.bottom_blank);
        if (r102 == null) goto L19;
        r100 = R.id.loading_progress;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_progress);
        if (r103 == null) goto L19;
        r100 = R.id.refresh_btn;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.refresh_btn);
        if (r104 == null) goto L19;
        r100 = R.id.refresh_text;
        TextView r112 = (TextView) ViewBindings.findChildViewById(this, R.id.refresh_text);
        if (r112 == null) goto L19;
        r100 = R.id.tips_container;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.tips_container);
        if (r105 == null) goto L19;
        r100 = R.id.top_blank;
        View r113 = ViewBindings.findChildViewById(this, R.id.top_blank);
        if (r113 == null) goto L19;
        this.f328478a = new LarusViewLoadingWithRetryBinding(this, r101, r102, r103, r104, r112, r105, r113);
        setOrientation(1);
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.textColor, android.R.attr.background});
        setBackgroundColor(r114.getColor(1, ContextCompat.getColor(r110, c.b(R.attr.larus_base_1, r110, R.color.larus_base_1))));
        int r115 = r114.getColor(0, ContextCompat.getColor(r110, c.b(R.attr.larus_neutral_100, r110, R.color.larus_neutral_100)));
        r104.setColorFilter(r115);
        r112.setTextColor(r115);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r100)));
    }
}
