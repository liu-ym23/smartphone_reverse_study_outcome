package com.bytedance.kmp.ec.yata.view.render.controller.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R?\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/ec/yata/view/render/controller/common/YataPerfLinearLayout;", "Landroid/widget/LinearLayout;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isShown", "", "b", "Lkotlin/jvm/functions/Function1;", "getShownStateChangedListener", "()Lkotlin/jvm/functions/Function1;", "setShownStateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "shownStateChangedListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class YataPerfLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f251837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f251838b;

    public YataPerfLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public YataPerfLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function1<Boolean, Unit> getShownStateChangedListener() {
        return this.f251838b;
    }

    public final void setShownStateChangedListener(Function1<? super Boolean, Unit> r100) {
        this.f251838b = r100;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        boolean r102 = isShown();
        if (Intrinsics.areEqual(Boolean.valueOf(r102), this.f251837a) == true) goto L8;
        this.f251837a = Boolean.valueOf(r102);
        Function1<? super Boolean, Unit> r103 = this.f251838b;
        if (r103 == null) goto L9;
        r103.invoke(Boolean.valueOf(r102));
        return;
    L9:
        return;
    }

    public YataPerfLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ YataPerfLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
