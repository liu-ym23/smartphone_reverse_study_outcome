package th5;

import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import java.io.Serializable;
import java.util.Map;
import qe5.e;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    void QQ(e.c r100, e.b r101, SecretApprovalInstanceModel r102, SecretApprovalDefModel r103, SecretLevel r104, SecretLevel r105);

    void rU(int r100);

    void sJ(String r100, int r101, String r102, String r103, int r104, String r105, String r106, SecretLevel r107, SecretApprovalDefModel r108, Map<String, ? extends Serializable> r110, SecretLevel r111);
}
