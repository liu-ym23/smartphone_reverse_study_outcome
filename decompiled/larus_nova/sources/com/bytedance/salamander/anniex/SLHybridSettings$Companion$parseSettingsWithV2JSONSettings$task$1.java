package com.bytedance.salamander.anniex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SLHybridSettings$Companion$parseSettingsWithV2JSONSettings$task$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ JSONObject $jsonSettings;

    public SLHybridSettings$Companion$parseSettingsWithV2JSONSettings$task$1(JSONObject r100) {
        this.$jsonSettings = r100;
        super(1);
    }

    public final Object invoke(boolean r100) {
        JSONObject r101 = this.$jsonSettings;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Any");
        String r102 = com.bytedance.anniex.bd.foundation.impl.o.b(TypeIntrinsics.asMutableMap(r101));
        z5.a r103 = z5.f268541a;
        c6 r104 = x.a(this.$jsonSettings);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "response");
        com.bytedance.salamander.adapter.e r105 = z5.f268542b;
        r105.a();
        z5.f268543c = r104;
        r105.b();
        z5.f268544d.a("sl_monitor_hybrid_settings", r102);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.a("HybridSettings", "async parseSettingsWithV2Response: ".concat(r102));
        return null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100) {
        return invoke(r100.booleanValue());
    }
}
