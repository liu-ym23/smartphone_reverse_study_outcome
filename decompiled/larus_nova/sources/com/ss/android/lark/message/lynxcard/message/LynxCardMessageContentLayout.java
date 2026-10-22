package com.ss.android.lark.message.lynxcard.message;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJp\u0010\u0014\u001a\u00020\u00122h\u0010\u0015\u001ad\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014Rp\u0010\n\u001ad\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/message/lynxcard/message/LynxCardMessageContentLayout;", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sizeChangedListener", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "w", "h", "oldw", "oldh", "", "Lcom/ss/android/lark/message/lynxcard/message/OnSizeChangedListener;", "setOnSizeChangeListener", "listener", "onSizeChanged", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxCardMessageContentLayout extends LKUIRoundableLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> f432157r;

    public static final class a {
    }

    static {
    }

    public LynxCardMessageContentLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LynxCardMessageContentLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnSizeChangeListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r100) {
        this.f432157r = r100;
    }

    public LynxCardMessageContentLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ LynxCardMessageContentLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.larksuite.component.ui.layout.LKUIRoundableLayout, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        hac.b.f484427a.a("LynxCardMessageContentLayout", "onSizeChanged w:" + r100 + ", h:" + r101 + ", oldw:" + r102 + ", oldh:" + r103);
        super.onSizeChanged(r100, r101, r102, r103);
        Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r104 = this.f432157r;
        if (r104 == null) goto L6;
        r104.invoke(Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103));
        return;
    }
}
