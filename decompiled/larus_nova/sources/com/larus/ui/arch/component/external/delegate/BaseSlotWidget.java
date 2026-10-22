package com.larus.ui.arch.component.external.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H'R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/larus/ui/arch/component/external/delegate/BaseSlotWidget;", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentWidget;", "Lcom/larus/ui/arch/context/external/EmptyVWidgetData;", "<init>", "()V", "slotViewId", "", "getSlotViewId", "()I", "setSlotViewId", "(I)V", "onCreateView", "", "injectViewFactory", "Lcom/larus/ui/arch/component/external/SlotViewFactory;", "contentLayoutId", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSlotWidget extends BaseComponentWidget<Object> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f375157k;

    public static final class a implements l1a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSlotWidget f375158a;

        public a(BaseSlotWidget r100) {
            this.f375158a = r100;
        }

        @Override // l1a.a
        public final View a(ViewGroup r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "containerView");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return LayoutInflater.from(r101).inflate(this.f375158a.P2(), r100, false);
        }
    }

    public abstract int P2();

    @Override // m1a.e
    public final void S1() {
        ComponentStateController r100 = this.f375151e;
        FragmentActivity r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateController");
        r100 = null;
    L6:
        Object r102 = r100.f375169e;
        if ((r102 instanceof View) == false) goto L9;
        View r103 = (View) r102;
    L10:
        if (r103 == null) goto L12;
        ViewGroup r104 = (ViewGroup) r103.findViewById(this.f375157k);
    L13:
        if (r104 == null) goto L22;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f375154j = r104;
        View r105 = U2().a(r104, getContext());
        Context r106 = getContext();
        if ((r106 instanceof FragmentActivity) == false) goto L17;
        r101 = (FragmentActivity) r106;
    L17:
        r104.addView(r105);
        if (r101 == null) goto L23;
        Attachable.Companion.getClass();
        N2(r105, Attachable.a.a(r101));
        return;
    L23:
        return;
    L22:
        throw new IllegalStateException("container view in stateController is null".toString());
    L12:
        r104 = null;
        goto L13
    L9:
        r103 = null;
        goto L10
    }

    public l1a.a U2() {
        return new a(this);
    }

    public BaseSlotWidget() {
    }
}
