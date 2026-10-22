package com.bytedance.lark.view_flow_wrapper;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.lark.view_flow_wrapper.i;
import java.lang.AutoCloseable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\u00020\u0002*\u00060\u0003j\u0002`\u00042\u00020\u00052\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0012\u0010\b\u001a\u00028\u0000X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/lark/view_flow_wrapper/MoltenViewModel;", "VFR", "Lcom/bytedance/lark/view_flow_wrapper/IMoltenViewFlow;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "viewFlow", "getViewFlow", "()Lcom/bytedance/lark/view_flow_wrapper/IMoltenViewFlow;", "cleared", "Lkotlinx/atomicfu/AtomicBoolean;", "onCleared", "", "close", "view_flow_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MoltenViewModel<VFR extends i & AutoCloseable> extends ViewModel implements AutoCloseable {
    private final buc.a cleared;

    public abstract VFR getViewFlow();

    @Override // java.lang.AutoCloseable
    public void close() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        ViewModelStore r100 = new ViewModelStore();
        r100.put(String.valueOf(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName()), this);
        r100.clear();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (this.cleared.a(false, true) == true) goto L5;
        return;
    L5:
        super.onCleared();
        i r100 = getViewFlow();
        if ((r100 instanceof j) == false) goto L8;
        j r101 = (j) r100;
    L9:
        if (r101 == null) goto L13;
        r101.shutdown();
        Unit r102 = Unit.INSTANCE;
        f0 r103 = new f0(Reflection.getOrCreateKotlinClass(getViewFlow().getClass()).getSimpleName() + '@' + getViewFlow().hashCode());
        y r104 = ViewFlowPlugin.f254409a;
        y r105 = ViewFlowPlugin.f254409a;
        if (r105 == null) goto L13;
        r105.a(r103);
    L13:
        getViewFlow().close();
        return;
    L8:
        r101 = null;
        goto L9
    }

    public MoltenViewModel() {
        this.cleared = buc.b.a(false);
    }
}
