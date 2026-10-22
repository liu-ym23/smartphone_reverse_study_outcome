package com.larus.account.saas.ui.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import j48.a;
import j48.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/ui/web/FlowAccountSaasWebErrorView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setOnCloseClickListener", "setOnRefreshClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class FlowAccountSaasWebErrorView extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f286611e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f286612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f286613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f286614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f286615d;

    public FlowAccountSaasWebErrorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowAccountSaasWebErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
    }

    public final void setOnCloseClickListener(View.OnClickListener r100) {
        this.f286614c = r100;
    }

    public final void setOnRefreshClickListener(View.OnClickListener r100) {
        this.f286615d = r100;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
    }

    public FlowAccountSaasWebErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (getBackground() != null) goto L5;
        setBackgroundResource(R.color.account_saas_base_1);
    L5:
        LayoutInflater.from(r100).inflate(R.layout.account_saas_web_error_view, this, true);
        View r103 = findViewById(R.id.account_saas_error_close);
        this.f286612a = r103;
        View r104 = findViewById(R.id.account_saas_error_refresh);
        this.f286613b = r104;
        r103.setOnClickListener(new a(this));
        r104.setOnClickListener(new b(this));
    }

    public /* synthetic */ FlowAccountSaasWebErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
