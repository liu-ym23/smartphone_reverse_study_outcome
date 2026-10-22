package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements com.obric.assistant.provider.hybrid.a {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        com.obric.assistant.settings.h.f392071a.getClass();
        com.obric.assistant.settings.h.a r102 = com.obric.assistant.settings.h.a();
        FLogger.f375446a.i("QueryCocreationReviewEntryEnabled", "call enabled=" + r102.f392075a + ", resolved=" + r102.f392076b + ", source=" + r102.f392077c);
        Bundle r103 = new Bundle();
        r103.putBoolean("enabled", r102.f392075a);
        r103.putBoolean("resolved", r102.f392076b);
        r103.putString("source", r102.f392077c);
        return r103;
    }
}
