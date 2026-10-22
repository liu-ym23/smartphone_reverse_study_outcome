package com.ss.android.lark.forseti.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackChainBackgroundView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "defaultAttrInt", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chainHelper", "Lcom/ss/android/lark/forseti/widget/StackChainHelper;", "isCMode", "", "Ljava/lang/Boolean;", "style", "Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "getStyle", "()Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "setStyle", "(Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "checkToInvisible", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiStackChainBackgroundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f424702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f424703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ForsetiStackChainViewGroup.Style f424704c;

    public ForsetiStackChainBackgroundView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ForsetiStackChainBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ForsetiStackChainViewGroup.Style getStyle() {
        return this.f424704c;
    }

    public final void setStyle(ForsetiStackChainViewGroup.Style r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f424704c = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        e r104 = this.f424702a;
        r104.getClass();
        if (Math.min(r102, r103) < r104.f424746c) goto L8;
        int r105 = r104.f424745b;
        if (r102 < ((r104.f424744a * 2) + r105)) goto L8;
    L9:
        int r106 = 0;
        if (r102 <= r105) goto L12;
        boolean r107 = true;
    L13:
        boolean r108 = !r107;
        if (Intrinsics.areEqual(this.f424703b, Boolean.valueOf(r108)) == true) goto L38;
        this.f424703b = Boolean.valueOf(r108);
        Activity r109 = ContextsKt.findActivity(getContext());
        if (r109 == null) goto L39;
        Boolean r110 = this.f424703b;
        if (r110 == null) goto L21;
        boolean r111 = r110.booleanValue();
    L22:
        if (r111 == false) goto L26;
        ForsetiStackChainViewGroup.Style r112 = this.f424704c;
        if (r112 == ForsetiStackChainViewGroup.Style.HALF_STACK) goto L26;
        if (r112 != ForsetiStackChainViewGroup.Style.STACK) goto L32;
        LKSplitController r113 = LKSplitController.f409739b;
        if (LKSplitController.a.a().e() == false) goto L32;
        boolean r114 = com.ss.android.lark.base.embedded.b.c(r109);
    L34:
        if ((!r114) == false) goto L36;
        r106 = 4;
    L36:
        setVisibility(r106);
        return;
    L32:
        r114 = false;
    L26:
        r114 = true;
        goto L34
    L21:
        r111 = true;
        goto L22
    L39:
        return;
    L38:
        return;
    L12:
        r107 = false;
    L8:
        r105 = r102;
        goto L9
    }

    public ForsetiStackChainBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f424702a = new e(r100);
        this.f424704c = ForsetiStackChainViewGroup.Style.UNINITIALIZED;
    }

    public /* synthetic */ ForsetiStackChainBackgroundView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
