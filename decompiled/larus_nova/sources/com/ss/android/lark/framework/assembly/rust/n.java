package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.rustclient.internal.DefaultRustClientDefinition;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.statistics.Statistics;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class n extends DefaultRustClientDefinition {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e5c.b f425703d;

    @Override // com.bytedance.lark.rustclient.internal.DefaultRustClientDefinition, com.bytedance.lark.rustclient.internal.k
    public final boolean b() {
        return DevEnvUtil.isDevelopPackage(com.larksuite.framework.utils.b.f285948a);
    }

    @Override // com.bytedance.lark.rustclient.internal.DefaultRustClientDefinition, com.bytedance.lark.rustclient.internal.k
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return f0.a(r100);
    }

    @Override // com.bytedance.lark.rustclient.internal.DefaultRustClientDefinition, com.bytedance.lark.rustclient.internal.k
    public final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter("lark_rust_ffi_userid_check_dev", "eventName");
        Intrinsics.checkNotNullParameter(r100, "eventParams");
        this.f425703d.a(com.larksuite.framework.utils.b.f285948a);
        Statistics.sendEvent("lark_rust_ffi_userid_check_dev", r100);
    }

    @Inject
    public n(e5c.b r100, Set<com.bytedance.lark.rustclient.api.o> r101) {
        Intrinsics.checkNotNullParameter(r100, "simpleMode");
        Intrinsics.checkNotNullParameter(r101, "asyncCallbackExecutorGroups");
        super(r101);
        this.f425703d = r100;
    }
}
