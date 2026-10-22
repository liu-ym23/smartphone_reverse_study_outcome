package com.ss.android.lark.scaffold;

import android.content.Context;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.scaffold.internal.component.ComponentImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000fJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0004J\b\u0010\u0016\u001a\u00020\u0015H\u0004J\u001c\u0010\u0017\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0019\u0012\u0004\u0012\u00020\u00040\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH$J\b\u0010\u001d\u001a\u00020\rH\u0014J\b\u0010\u001e\u001a\u00020\rH\u0014J\b\u0010\u001f\u001a\u00020\rH\u0014J\b\u0010 \u001a\u00020\rH\u0014J\b\u0010!\u001a\u00020\rH\u0014J\b\u0010\"\u001a\u00020\rH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/ss/android/lark/scaffold/Component2;", "Lcom/ss/android/lark/scaffold/internal/component/ComponentImpl;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/ss/android/lark/scaffold/IComponent;", "<init>", "()V", "_pageRuntime", "Lcom/ss/android/lark/scaffold/PageRuntime;", "pageRuntime", "getPageRuntime", "()Lcom/ss/android/lark/scaffold/PageRuntime;", "attachPageRuntime", "", "runtime", "attachPageRuntime$scaffold_release", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "getContext", "Landroid/content/Context;", "requireContext", "provideComponents", "", "Ljava/lang/Class;", "createView", "parent", "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "scaffold_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Component2 extends ComponentImpl implements IComponent {
    @Override // com.ss.android.lark.scaffold.internal.component.ComponentImpl
    public final Context getContext() {
        return super.getContext();
    }

    public Component2() {
    }
}
