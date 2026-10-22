package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements com.obric.assistant.provider.hybrid.a {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // com.obric.assistant.provider.hybrid.a
    public Bundle call(String r100, Bundle r101) {
        Lazy r102 = we8.e.f559400a;
        int r103 = we8.e.f559403d;
        FLogger.f375446a.i("QueryFontLevelSettingFunctionality", "fontLevel = " + r103);
        Bundle r104 = new Bundle();
        r104.putInt("font_level", r103);
        return r104;
    }
}
