package di5;

import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f468743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecretApprovalDefModel f468744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecretApprovalInstanceModel f468745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VisibleSecretResult f468746d;

    public a() {
        this.f468743a = false;
        this.f468743a = false;
    }

    public a(SecretApprovalDefModel r100, SecretApprovalInstanceModel r101, VisibleSecretResult r102) {
        this.f468743a = false;
        this.f468744b = r100;
        this.f468745c = r101;
        this.f468746d = r102;
        this.f468743a = true;
    }
}
