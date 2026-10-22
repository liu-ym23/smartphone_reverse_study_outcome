package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import org.json.JSONObject;
import w20.sd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class p5<P extends sd, R extends JSONObject> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public p5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
