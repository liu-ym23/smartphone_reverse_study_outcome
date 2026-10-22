package com.larus.av_call.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.databinding.LarusRealtimeBottomMoreBtnBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/av_call/util/RealtimeBottomMoreBtn;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/av_call/databinding/LarusRealtimeBottomMoreBtnBinding;", "getBinding", "()Lcom/larus/av_call/databinding/LarusRealtimeBottomMoreBtnBinding;", "setImageResource", "", "resId", "setIconVisible", "visible", "", "loadImage", "url", "", "tag", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeBottomMoreBtn extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusRealtimeBottomMoreBtnBinding f290566a;

    public RealtimeBottomMoreBtn(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealtimeBottomMoreBtn(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LarusRealtimeBottomMoreBtnBinding getBinding() {
        return this.f290566a;
    }

    public final void setIconVisible(boolean r100) {
        SimpleDraweeView r101 = this.f290566a.f290562b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public final void setImageResource(int r100) {
        this.f290566a.f290562b.setVisibility(0);
        this.f290566a.f290562b.setImageResource(r100);
    }

    public RealtimeBottomMoreBtn(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_realtime_bottom_more_btn, this, false);
        addView(r103);
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r103, R.id.view_btn_icon);
        if (r104 == null) goto L7;
        this.f290566a = new LarusRealtimeBottomMoreBtnBinding((FrameLayout) r103, r104);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.view_btn_icon)));
    }

    public /* synthetic */ RealtimeBottomMoreBtn(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
