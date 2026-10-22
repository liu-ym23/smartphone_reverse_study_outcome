package omb;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lark.base.open.pkm.PkmBizType;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements com.bytedance.lark.base.open.pkm.c {
    public b() {
    }

    @Override // com.bytedance.lark.base.open.pkm.c
    public final void onEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        if (Intrinsics.areEqual(r100, "JSSDKVersionInfo") == false) goto L9;
        PkmBizType r102 = a.f524315a;
        String r103 = r101.get("db_sdk_update_version");
        if (r103 != null) goto L7;
        r103 = r101.get("db_sdk_version");
    L7:
        a.f524318d = r103;
        Log.i("CardTemplatePkmManager", "JSSDKVersionInfo: " + a.f524318d);
        return;
    L9:
        if (Intrinsics.areEqual(r100, "JSSDKVersionError") == false) goto L13;
        Log.w("CardTemplatePkmManager", "getJssdkInstallationVersion error: " + r101);
        return;
    }
}
