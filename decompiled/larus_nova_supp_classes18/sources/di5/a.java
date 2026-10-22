package di5;

import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final boolean a;
    public final SecretApprovalDefModel b;
    public final SecretApprovalInstanceModel c;
    public final VisibleSecretResult d;

    public a() {
        this.a = false;
        this.a = false;
    }

    public a(SecretApprovalDefModel r2, SecretApprovalInstanceModel r3, VisibleSecretResult r4) {
        this.a = false;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = true;
    }
}
