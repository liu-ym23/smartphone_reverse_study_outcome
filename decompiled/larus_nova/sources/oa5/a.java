package oa5;

import at5.e;
import at5.l;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends e {
    public a() {
    }

    @Override // at5.e
    public final l a(Status r100, String r101, Object r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put2("bizDomain", ChameleonResConstants.CCM_ROOT_DIR);
        l r105 = new l();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f16259b = r101;
        r105.f16261d = r104.toString();
        r105.f16258a = r100;
        r105.f16260c = r102;
        return r105;
    }
}
