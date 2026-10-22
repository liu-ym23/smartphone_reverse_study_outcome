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
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/titlebar/MmTitleBarView2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tvTitle", "Landroid/widget/TextView;", "tvSubTitle", "ivClose", "Landroid/widget/ImageView;", d.f25925o, "", "titleRes", "title", "", "setSubTitle", "subTitleRes", "subTitle", "clearSubTitle", "setCloseClickListener", "listener", "Landroid/view/View$OnClickListener;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmTitleBarView2 extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f435777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f435778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f435779c;

    public MmTitleBarView2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmTitleBarView2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setCloseClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        h.a(this.f435779c, new AnonymousClass1(r100));
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitle");
        if (StringsKt.isBlank(r100) == false) goto L6;
        this.f435778b.setVisibility(8);
        return;
    L6:
        this.f435778b.setText(r100);
        this.f435778b.setVisibility(0);
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f435777a.setText(r100);
    }

    public final void setSubTitle(int r100) {
        this.f435778b.setText(r100);
        this.f435778b.setVisibility(0);
    }

    public final void setTitle(int r100) {
        this.f435777a.setText(r100);
    }

    public MmTitleBarView2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        MmRecordingUILaunchMode r103 = c.a(r100);
        e.f436896a.getClass();
        kwb.d r104 = e.b(r103).getLayout().h(LayoutInflater.from(c.c(r100, r103)), this);
        this.f435777a = r104.f506509c;
        this.f435778b = r104.f506510d;
        ImageView r105 = r104.f506511e;
        this.f435779c = r105;
        r105.setBackground(b.a(r100).y(r100));
        r105.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(r100, a.a(r100).a())));
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.tbv2_sub_title_text, R.attr.tbv2_title_text});
        String r107 = r106.getString(1);
        if (r107 == null) goto L5;
        setTitle(r107);
    L5:
        String r108 = r106.getString(0);
        if (r108 == null) goto L8;
        setSubTitle(r108);
    L8:
        r106.recycle();
    }

    public /* synthetic */ MmTitleBarView2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
