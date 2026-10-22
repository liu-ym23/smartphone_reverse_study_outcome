package com.larus.livetutor.impl.view.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.m.x.d;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sj9.b;
import sj9.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/livetutor/impl/view/error/DefaultErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/livetutor/impl/view/error/ILiveTutorErrorView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewInstance", "Landroid/view/View;", "getViewInstance", "()Landroid/view/View;", "setMainImage", "", "img", d.f25925o, "text", "", "setButtonText", "setOnRetry", "onRetry", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultErrorView extends ConstraintLayout implements sj9.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f356831b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultErrorView f356832a;

    public DefaultErrorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DefaultErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // sj9.d
    public void setButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // sj9.d
    public void setMainImage(int r100) {
    }

    @Override // sj9.d
    public void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // sj9.d
    public View getViewInstance() {
        return this.f356832a;
    }

    @Override // sj9.d
    public void setOnRetry(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onRetry");
        UtilsKt.h(findViewById(R.id.error_text), new b(r100));
        UtilsKt.h(findViewById(R.id.error_icon), new c(r100));
    }

    public DefaultErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.live_tutor_default_error_layout, this, true);
        this.f356832a = this;
    }

    public /* synthetic */ DefaultErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
