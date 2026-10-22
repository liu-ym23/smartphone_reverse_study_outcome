package com.larus.bmhome.chat.detail.code.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import re8.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/view/PreviewSwitchButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnState1", "Landroid/widget/TextView;", "btnState2", "indicator", "Landroid/view/View;", "isState1Selected", "", "onStateChangeListener", "Lcom/larus/bmhome/chat/detail/code/view/PreviewSwitchButton$OnStateChangeListener;", "setState", "", "switchToState1", "switchToState2", "setOnStateChangeListener", "listener", "OnStateChangeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewSwitchButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f302818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f302819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f302820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f302821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f302822e;

    public interface a {
        void a(boolean r100);
    }

    public PreviewSwitchButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PreviewSwitchButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        this.f302821d = true;
        View r100 = this.f302820c;
        Typeface r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        r103.startToStart = R.id.btn_state1;
        r103.endToEnd = R.id.btn_state1;
        this.f302820c.setLayoutParams(r103);
        TextView r104 = this.f302818a;
        if (r104 == null) goto L20;
        if (r104 == null) goto L18;
        Typeface r105 = r104.getTypeface();
        if (r105 == null) goto L18;
        Typeface r106 = Typeface.create(r105, 1);
    L19:
        r104.setTypeface(r106);
    L18:
        r106 = null;
    L20:
        TextView r107 = this.f302819b;
        if (r107 == null) goto L28;
        if (r107 == null) goto L26;
        Typeface r108 = r107.getTypeface();
        if (r108 == null) goto L26;
        r101 = Typeface.create(r108, 0);
    L26:
        r107.setTypeface(r101);
        return;
    L28:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public final void S5() {
        this.f302821d = false;
        View r100 = this.f302820c;
        Typeface r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        r103.startToStart = R.id.btn_state2;
        r103.endToEnd = R.id.btn_state2;
        this.f302820c.setLayoutParams(r103);
        TextView r104 = this.f302818a;
        if (r104 == null) goto L20;
        if (r104 == null) goto L18;
        Typeface r105 = r104.getTypeface();
        if (r105 == null) goto L18;
        Typeface r106 = Typeface.create(r105, 0);
    L19:
        r104.setTypeface(r106);
    L18:
        r106 = null;
    L20:
        TextView r107 = this.f302819b;
        if (r107 == null) goto L28;
        if (r107 == null) goto L26;
        Typeface r108 = r107.getTypeface();
        if (r108 == null) goto L26;
        r101 = Typeface.create(r108, 1);
    L26:
        r107.setTypeface(r101);
        return;
    L28:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public final void setOnStateChangeListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f302822e = r100;
    }

    public final void setState(boolean r100) {
        if (r100 != this.f302821d) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        R5();
        return;
    L7:
        S5();
    }

    public PreviewSwitchButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f302821d = true;
        ViewGroup.inflate(r100, R.layout.larus_layout_preview_switch_button, this);
        TextView r103 = (TextView) findViewById(R.id.btn_state1);
        this.f302818a = r103;
        TextView r104 = (TextView) findViewById(R.id.btn_state2);
        this.f302819b = r104;
        this.f302820c = findViewById(R.id.indicator);
        if (r103 == null) goto L5;
        r103.setOnClickListener(new re8.a(this));
    L5:
        if (r104 == null) goto L8;
        r104.setOnClickListener(new b(this));
        return;
    }

    public /* synthetic */ PreviewSwitchButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
