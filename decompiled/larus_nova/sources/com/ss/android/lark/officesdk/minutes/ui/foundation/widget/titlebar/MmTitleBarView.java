package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.m.x.d;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.style.a;
import com.ss.android.lark.officesdk.minutes.ui.style.b;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kwb.e;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/titlebar/MmTitleBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contract", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/dialog/MmTitleBarViewContract;", "tvTitle", "Landroid/widget/TextView;", "ivClose", "Landroid/widget/ImageView;", d.f25925o, "", "titleRes", "title", "", "setIncludingDivider", "includingDivider", "", "setCloseClickListener", "listener", "Landroid/view/View$OnClickListener;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmTitleBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f435774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f435775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f435776c;

    public MmTitleBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmTitleBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setCloseClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        h.a(this.f435776c, new AnonymousClass1(r100));
    }

    public final void setIncludingDivider(boolean r100) {
        View r101 = this.f435774a.f506517d;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f435775b.setText(r100);
    }

    public final void setTitle(int r100) {
        this.f435775b.setText(r100);
    }

    public MmTitleBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        MmRecordingUILaunchMode r103 = c.a(r100);
        com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a.getClass();
        e r104 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r103).getLayout().l(LayoutInflater.from(c.c(r100, r103)), this);
        this.f435774a = r104;
        this.f435775b = r104.f506515b;
        ImageView r105 = r104.f506516c;
        this.f435776c = r105;
        r105.setBackground(b.a(r100).y(r100));
        r105.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(r100, a.a(r100).a())));
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.includingDivider, R.attr.tbv_title_text});
        String r107 = r106.getString(1);
        if (r107 == null) goto L5;
        setTitle(r107);
    L5:
        setIncludingDivider(r106.getBoolean(0, false));
        r106.recycle();
    }

    public /* synthetic */ MmTitleBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
