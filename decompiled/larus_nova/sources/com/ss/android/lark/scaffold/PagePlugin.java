package com.ss.android.lark.scaffold;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.scaffold.internal.PluginImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l3c.f;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014J\b\u0010\r\u001a\u00020\u0006H\u0014¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/scaffold/PagePlugin;", "Lcom/ss/android/lark/scaffold/internal/PluginImpl;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "runtime", "Lcom/ss/android/lark/scaffold/PageRuntime;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "scaffold_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PagePlugin extends PluginImpl {
    public void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "runtime");
    }

    public final void onResume() {
    }

    public final void onStart() {
    }

    public PagePlugin() {
    }
}
