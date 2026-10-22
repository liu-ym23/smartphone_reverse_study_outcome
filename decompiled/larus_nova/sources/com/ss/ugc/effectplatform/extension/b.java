package com.ss.ugc.effectplatform.extension;

import bytekn.foundation.encryption.d;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static final boolean a(Effect r100) {
        String r101 = r100.getExtra();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        boolean r102 = Intrinsics.areEqual(bytekn.foundation.encryption.b.a(d.a(ByteArrayExKt.a(r100.getId() + "swv2naghkXiK5usX" + r101))), r100.getExtra_tag());
        if (r102 == true) goto L9;
        Logger.e$default(Logger.INSTANCE, "EffectEx", r100.getEffect_id() + " verify failed", null, 4, null);
    L9:
        return r102;
    }
}
