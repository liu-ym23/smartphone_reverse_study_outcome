package lcb;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class f implements mcb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public String f508638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public mcb.b f508639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public j f508640c;

    @Override // mcb.c
    public final String a(String r100) {
        Log.d("UserDomainConfigService", "getDomain called, alias: ".concat(r100));
        return this.f508639b.e0(this.f508638a, r100);
    }

    @Override // mcb.c
    public final List<String> b(String r100) {
        Log.d("UserDomainConfigService", "getDomains called, alias: " + r100);
        return this.f508639b.A(this.f508638a, r100);
    }

    @Inject
    public f(j r100, mcb.b r101) {
        Log.i("UserDomainConfigService", "UserDomainConfigService start");
        this.f508640c = r100;
        this.f508639b = r101;
        Log.i("UserDomainConfigService", "UserDomainConfigService finish");
        if (TextUtils.isEmpty(this.f508638a) == false) goto L5;
        Log.w("UserDomainConfigService", "wtf, invalid uid within user-state-framework.");
        return;
    L5:
        Log.i("UserDomainConfigService", "uid info:" + this.f508638a);
    }
}
