package com.ss.android.ugc.aweme.search.vision.result.panel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.topsection.widget.HeaderRoundHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "b", "Z", "getEnableRoundHeader", "()Z", "setEnableRoundHeader", "(Z)V", "enableRoundHeader", "Lkotlin/Function0;", "", "c", "Lkotlin/jvm/functions/Function0;", "getOnActionDown", "()Lkotlin/jvm/functions/Function0;", "setOnActionDown", "(Lkotlin/jvm/functions/Function0;)V", "onActionDown", "Lcom/ss/android/ugc/aweme/search/common/topsection/widget/HeaderRoundHelper;", "headerRoundHelper", "Lcom/ss/android/ugc/aweme/search/common/topsection/widget/HeaderRoundHelper;", "getHeaderRoundHelper", "()Lcom/ss/android/ugc/aweme/search/common/topsection/widget/HeaderRoundHelper;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f453747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f453748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f453749c;

    public PhotoSearchConstraintLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoSearchConstraintLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final HeaderRoundHelper getHeaderRoundHelper() {
        return new HeaderRoundHelper(this, this.f453747a);
    }

    public final boolean getEnableRoundHeader() {
        return this.f453748b;
    }

    public final Function0<Unit> getOnActionDown() {
        return this.f453749c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        if (r101 == null) goto L13;
        if (r101.intValue() != 0) goto L13;
        Function0<Unit> r102 = this.f453749c;
        if (r102 == null) goto L13;
        Unit r103 = r102.invoke();
    L13:
        return super.dispatchTouchEvent(r100);
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f453748b == false) goto L7;
        HeaderRoundHelper r101 = getHeaderRoundHelper();
        if (r101 == null) goto L7;
        r101.a(r100);
    L7:
        super.draw(r100);
    }

    public final void setEnableRoundHeader(boolean r100) {
        this.f453748b = r100;
    }

    public final void setOnActionDown(Function0<Unit> r100) {
        this.f453749c = r100;
    }

    public PhotoSearchConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f453747a = UIUtils.dip2Px(r100, 20.0f);
    }

    public /* synthetic */ PhotoSearchConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
