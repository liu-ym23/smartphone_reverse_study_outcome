package com.larus.office.plugins.titlebar;

import com.bytedance.ee.bear.more.protocol3.panel.MoreGroup;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s0 {
    public static final void a(com.bytedance.ee.bear.more.protocol3.panel.l r100, final ChameleonPluginHost r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "host");
        r100.a(MoreGroup.DANGER, new a0(r101));
    }
}
