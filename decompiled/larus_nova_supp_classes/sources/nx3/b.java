package nx3;

import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.g0;
import ix3.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b implements g0 {
    public final a a;

    public b(com.bytedance.applog.b r1) {
        this.a = r1.f;
    }

    @Override // com.bytedance.bdinstall.g0
    public final String get(String r7, Map<String, String> r8) throws RangersHttpException {
        return this.a.f(0, r7, (HashMap) r8, null, 0).a;
    }

    @Override // com.bytedance.bdinstall.g0
    public final String post(String r7, byte[] r8, Map<String, String> r9) throws RangersHttpException {
        return this.a.f(1, r7, (HashMap) r9, r8, 0).a;
    }

    @Override // com.bytedance.bdinstall.g0
    public final byte[] postStream(String r7, byte[] r8, Map<String, String> r9) throws RangersHttpException {
        return this.a.f(1, r7, (HashMap) r9, r8, 1).b;
    }
}
