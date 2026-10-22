package com.suite.lark.component.navroute.args;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class NavArgsExtKt$navArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Activity $this_navArgs;

    public NavArgsExtKt$navArgs$1(Activity r100) {
        this.$this_navArgs = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        Bundle r100 = this.$this_navArgs.getIntent().getExtras();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Activity " + this.$this_navArgs + " has null extras");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Bundle invoke() {
        return invoke();
    }
}
