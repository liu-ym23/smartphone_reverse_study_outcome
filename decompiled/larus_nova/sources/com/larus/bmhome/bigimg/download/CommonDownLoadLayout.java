package com.larus.bmhome.bigimg.download;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.image.databinding.LarusLayoutCommonDownLoadBinding;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutCommonDownLoadBinding;", "loadingStateJob", "Lkotlinx/coroutines/Job;", "hideLoadComplete", "", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "setDownloadIcon", "resId", "setLayoutEnable", "enable", "", "onBindData", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "resourceData", "Lcom/larus/bmhome/bigimg/download/DownloadResource;", LiveCommonConstants.REASON_ON_DEDTROY, "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonDownLoadLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutCommonDownLoadBinding f295961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Job f295962b;

    public CommonDownLoadLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonDownLoadLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        this.f295961a.f350932c.setVisibility(8);
        this.f295961a.f350931b.setVisibility(0);
    }

    public final void T5() {
        this.f295961a.f350932c.setVisibility(0);
        this.f295961a.f350931b.setVisibility(4);
    }

    public final void onDestroy() {
        Job r100 = this.f295962b;
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        return;
    }

    public final void setDownloadIcon(int r100) {
        this.f295961a.f350931b.setImageResource(r100);
    }

    public final void setLayoutEnable(boolean r100) {
        this.f295961a.f350931b.setEnabled(r100);
        AppCompatTextView r101 = this.f295961a.f350933d;
        if (r100 == false) goto L5;
        float r102 = 1.0f;
    L6:
        r101.setAlpha(r102);
        return;
    L5:
        r102 = 0.3f;
        goto L6
    }

    public final void S5(CoroutineScope r100, d<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "resourceData");
        Job r101 = this.f295962b;
        Job r102 = null;
        if (r101 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L6:
        if ((r110 instanceof d.a) == false) goto L11;
        if (r100 == null) goto L9;
        r102 = BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new CommonDownLoadLayout$onBindData$1(r110, this, null), 2, null);
    L9:
        this.f295962b = r102;
        return;
    L11:
        if ((r110 instanceof d.c) == false) goto L16;
        if (r100 == null) goto L14;
        r102 = BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new CommonDownLoadLayout$onBindData$2(r110, this, null), 2, null);
    L14:
        this.f295962b = r102;
        return;
    L16:
        if ((r110 instanceof d.b) == false) goto L23;
        if (r100 == null) goto L19;
        r102 = BuildersKt.launch$default(r100, Dispatchers.getMain(), null, new CommonDownLoadLayout$onBindData$3(r110, this, null), 2, null);
    L19:
        this.f295962b = r102;
        return;
    }

    public CommonDownLoadLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_common_down_load, this);
        int r103 = R.id.download_inner_image_view;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.download_inner_image_view);
        if (r104 == null) goto L20;
        r103 = R.id.download_inner_loading;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.download_inner_loading);
        if (r105 == null) goto L20;
        r103 = R.id.download_inner_text;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.download_inner_text);
        if (r106 == null) goto L20;
        this.f295961a = new LarusLayoutCommonDownLoadBinding(this, r104, r105, r106);
        int r107 = 0;
        TypedArray r108 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_showText});
    L16:
        th = move-exception;
        r108.recycle();
        throw th;
    L10:
        if (r108.getBoolean(0, true) == true) goto L13;
        r107 = 8;
    L13:
        r106.setVisibility(r107);     // Catch: Throwable -> L16
        r108.recycle();
        return;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ CommonDownLoadLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
