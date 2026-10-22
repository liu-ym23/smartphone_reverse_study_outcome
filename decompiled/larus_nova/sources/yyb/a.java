package yyb;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class a implements b {
    @Inject
    public a() {
    }

    @Override // yyb.b
    public final void a(Activity r100, String r101, JSONObject r102, IGetDataCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "callback");
        r103.onSuccess(null);
    }
}
