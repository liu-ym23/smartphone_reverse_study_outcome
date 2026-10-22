package com.ss.android.lark.flow.chat.page.flow.configurator;

import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorKey;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import l3c.c;
import l3c.f;

/* JADX INFO: loaded from: classes36.dex */
@ConfiguratorKey(ConfiguratorType.MESSAGE_LIST)
public final class FlowMessageListConfigurator implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f422730a;

    @Inject
    public FlowMessageListConfigurator() {
        this.f422730a = LazyKt.lazy(FlowMessageListConfigurator$coreConfigurator$2.INSTANCE);
    }

    @Override // l3c.c
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rt");
        ((d) this.f422730a.getValue()).a(r100);
    }
}
