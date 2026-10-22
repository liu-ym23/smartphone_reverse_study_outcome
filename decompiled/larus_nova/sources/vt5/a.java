package vt5;

import com.bytedance.ee.permission.define.IPermissionApi$ERequestMethod;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements ut5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f557222b;

    @Override // ut5.b
    public final Map<String, Serializable> b() {
        return null;
    }

    @Override // ut5.b
    public final String a() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "/api/suite/permission/public.v4/?token=%s&type=%d", Arrays.copyOf(new Object[]{this.f557221a, Integer.valueOf(this.f557222b)}, 2));
    }

    @Override // ut5.b
    public final IPermissionApi$ERequestMethod getMethod() {
        return IPermissionApi$ERequestMethod.GET;
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f557221a = r100;
        this.f557222b = r101;
    }
}
