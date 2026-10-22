package doc;

import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.LarkKVStorage;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@UserScope
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o5c.b f469545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f469546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f469547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.suite.lark.emm.impl.clipboard.utils.c f469548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f469549e;

    @Inject
    public l(com.ss.android.lark.storage.kv.storage.a r100, yzb.a r101, o5c.b r102) {
        Intrinsics.checkNotNullParameter(r100, "userKV");
        Intrinsics.checkNotNullParameter(r101, "userApi");
        Intrinsics.checkNotNullParameter(r102, "statistics");
        this.f469545a = r102;
        com.ss.android.lark.storage.a r103 = com.suite.lark.emm.impl.clipboard.utils.b.f460469a;
        Intrinsics.checkNotNullParameter(r100, "user");
        LarkKVStorage r104 = LarkKVStorage.f440926a;
        com.ss.android.lark.storage.a r105 = com.suite.lark.emm.impl.clipboard.utils.b.f460469a;
        r104.getClass();
        this.f469547c = LarkKVStorage.l(r100, r105, "common");
        this.f469548d = new com.suite.lark.emm.impl.clipboard.utils.c();
        r101.getTenantInfo().getTenantId();
        this.f469549e = r101.getTenantInfo().getTenantName();
    }
}
