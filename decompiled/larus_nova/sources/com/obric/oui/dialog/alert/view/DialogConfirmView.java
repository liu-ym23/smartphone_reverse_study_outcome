package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.checkbox.OCheckBox;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import yla.a;
import yla.b;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "only for o demo")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "Landroid/widget/TextView;", "getNormalTextView", "getLinkTextView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class DialogConfirmView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f400615f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCheckBox f400616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f400617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f400618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f400619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f400620e;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r100 = getParent();
        if (r100 == null) goto L10;
        ViewGroup r101 = (ViewGroup) r100;
        this.f400619d.setPadding(0, r101.getPaddingTop(), 0, r101.getPaddingBottom());
        this.f400619d.setOnClickListener(new a(this));
        r101.setPadding(r101.getPaddingLeft(), 0, r101.getPaddingRight(), 0);
        this.f400620e.setOnClickListener(new b(this));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final OCheckBox getCheckBox() {
        return this.f400616a;
    }

    public final TextView getLinkTextView() {
        return this.f400618c;
    }

    public final TextView getNormalTextView() {
        return this.f400617b;
    }

    public DialogConfirmView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DialogConfirmView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_layout_dialog_options, this);
        int r102 = d.n(this, 5);
        setPadding(r102, r102, r102, 0);
        this.f400616a = (OCheckBox) findViewById(R.id.radio);
        this.f400617b = (TextView) findViewById(R.id.tv_normal);
        this.f400618c = (TextView) findViewById(R.id.tv_link);
        this.f400619d = (RelativeLayout) findViewById(R.id.link_text_container);
        this.f400620e = (ViewGroup) findViewById(R.id.click_container);
    }
}
