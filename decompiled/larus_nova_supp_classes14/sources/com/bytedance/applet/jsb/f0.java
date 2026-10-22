package com.bytedance.applet.jsb;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.spi.IAIChatService;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 extends bx7.c {
    public final String getName() {
        return "applet.openMapSelectPanel";
    }

    public f0() {
    }

    public final void a(dx7.b r9, final ux7.d.d r10, IvyBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        ex7.d r12 = ((bx7.c) this).a;
        if (r12 == null) goto L14;
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        ex7.a r13 = (ex7.a) ((LinkedHashMap) r12.a).get(Context.class);
        if (r13 != null) goto L8;
        r13 = null;
    L8:
        if (r13 == null) goto L15;
        Context r1 = (Context) r13.provideInstance();
        if (r1 == null) goto L16;
        String r6 = r9.getString("poiName");
        String r14 = r9.getString("lon");
        String r15 = r9.getString("lat");
        IAIChatService.a.y7(r1, CastDoubleProtector.parseDouble(r15), CastDoubleProtector.parseDouble(r14), r6, new e0(r10));
        return;
    L16:
        return;
    L15:
        return;
    }
}
