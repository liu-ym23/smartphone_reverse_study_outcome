package nmb;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.ImPlugin;
import com.ss.android.lark.flow.chat.menu.FlowImMessageActionFactoryConfig;
import com.ss.android.lark.integrator.im.extension.ImContextImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@ImPlugin
public final class c implements qxa.b {
    public c() {
    }

    @Override // qxa.b
    public final void a(ImContextImpl r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.d(ImExtensionType.MESSAGE_ACTION_PROVIDER, (List) FlowImMessageActionFactoryConfig.f422227a.getValue());
        ImExtensionType r101 = ImExtensionType.MESSAGE_ACTION_INTERCEPTOR;
        List r102 = CollectionsKt.toMutableList((List) FlowImMessageActionFactoryConfig.f422228b.getValue());
        r102.add(qmb.a.class);
        Unit r103 = Unit.INSTANCE;
        r100.d(r101, r102);
        r100.c(new kgb.a());
    }
}
