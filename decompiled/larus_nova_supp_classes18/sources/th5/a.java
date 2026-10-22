package th5;

import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import java.io.Serializable;
import java.util.Map;
import qe5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void QQ(e.c r1, e.b r2, SecretApprovalInstanceModel r3, SecretApprovalDefModel r4, SecretLevel r5, SecretLevel r6);

    void rU(int r1);

    void sJ(String r1, int r2, String r3, String r4, int r5, String r6, String r7, SecretLevel r8, SecretApprovalDefModel r9, Map<String, ? extends Serializable> r10, SecretLevel r11);
}
