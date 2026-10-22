package com.suite.lark.component.navroute.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class FragemntExtKt$navRouteArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Fragment $this_navRouteArgs;

    public FragemntExtKt$navRouteArgs$1(Fragment r100) {
        this.$this_navRouteArgs = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        Bundle r100 = this.$this_navRouteArgs.getArguments();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this.$this_navRouteArgs + " has null arguments");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Bundle invoke() {
        return invoke();
    }
}
