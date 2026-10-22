package com.ss.android.lark.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import com.ss.android.lark.compose.foundation.widget.FlowSwitchStyle;
import com.ss.android.lark.compose.foundation.widget.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0013J\u001c\u0010\u001e\u001a\u00020\u00172\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0013H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/foundation/widget/FlowSwitch;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "style", "Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchStyle;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/ss/android/lark/compose/foundation/widget/FlowSwitchStyle;)V", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "state", "Landroidx/compose/runtime/MutableState;", "Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchState;", "enabledState", "", "styleState", "listener", "Lkotlin/Function1;", "", "isChecked", "toggle", "setChecked", "checked", "setLoading", "loading", "setOnCheckedChangeListener", "l", "setStyle", "setEnabled", "enabled", "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowSwitch extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState<a> f425611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableState<Boolean> f425612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState<FlowSwitchStyle> f425613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f425614d;

    public FlowSwitch(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public FlowSwitch(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public FlowSwitch(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f425611a.getValue().f417684a;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f425611a.getValue().f417684a);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f425611a.getValue().f417684a == r100) goto L6;
        MutableState<a> r101 = this.f425611a;
        r101.setValue(a.a(r101.getValue(), r100, false, 2));
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (this.f425612b.getValue().booleanValue() == r100) goto L6;
        this.f425612b.setValue(Boolean.valueOf(r100));
        return;
    }

    public final void setLoading(boolean r100) {
        if (this.f425611a.getValue().f417685b == r100) goto L6;
        MutableState<a> r101 = this.f425611a;
        r101.setValue(a.a(r101.getValue(), false, r100, 1));
        return;
    }

    public final void setOnCheckedChangeListener(Function1<? super Boolean, Unit> r100) {
        this.f425614d = r100;
    }

    public final void setStyle(FlowSwitchStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (this.f425613c.getValue() == r100) goto L6;
        this.f425613c.setValue(r100);
        return;
    }

    public FlowSwitch(Context r110, AttributeSet r111, int r112, int r113) {
        if ((r113 & 2) == 0) goto L6;
        r111 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r112 = 0;
    L9:
        if ((r113 & 8) == 0) goto L11;
        FlowSwitchStyle r114 = FlowSwitchStyle.NORMAL;
    L12:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "style");
        super(r110, r111, r112);
        ComposeView r115 = new ComposeView(r110, null, 0, 6, null);
        this.f425611a = SnapshotStateKt.mutableStateOf$default(new a(false, false), null, 2, null);
        this.f425612b = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isEnabled()), null, 2, null);
        this.f425613c = SnapshotStateKt.mutableStateOf$default(r114, null, 2, null);
        r115.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
        r115.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r115.setContent(ComposableLambdaKt.composableLambdaInstance(-279263023, true, new AnonymousClass1(this)));
        addView(r115);
        return;
    L11:
        r114 = null;
        goto L12
    }
}
